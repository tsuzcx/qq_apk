package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.ETC1Util.ETC1Texture;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.openapi.recorder.ActVideoDecoder;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.PTFaceLogUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class NormalVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = "NormalVideoFilter";
  protected float audioScaleFactor = 1.0F;
  protected long firstTriggerInStateTime = 0L;
  protected int frameIndex;
  protected long frameStartTime;
  private boolean gotSpritePicture = false;
  protected ArrayList<RedPacketPosition> hotAreaPositions;
  protected boolean isFirstTriggered;
  protected boolean isImageReady;
  protected boolean isInState = false;
  protected boolean isRenderForBitmap;
  protected StickerItem item;
  protected int lastImageIndex = -1;
  private boolean mAudioPause;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  private boolean mIsLastPause = false;
  private boolean mIsNeedSeekTime = false;
  private int mLastPosition = -1;
  private int mMusicPlayFirstSync = -1;
  private PlayerUtil.Player mPlayer;
  public List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  private long mTimesForLostProtect = 2000L;
  protected ActVideoDecoder mVideoDecoder;
  protected int musicPlayCount = 1;
  boolean needPlayMusic = false;
  protected int playMode = 0;
  private int spritePictureColumn;
  private int spritePictureHeight;
  private int spritePictureRow;
  private int spritePictureWidth;
  protected int[] tex = new int[2];
  protected boolean triggered = false;
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
    this.item = paramStickerItem;
    this.dataPath = paramString;
    initParams();
    initAudio();
  }
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramString2, paramString3);
    this.item = paramStickerItem;
    this.dataPath = paramString1;
    initParams();
    initAudio();
  }
  
  private void avoidBodyPointsShake(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo.bodyPoints != null) && (!paramPTDetectInfo.bodyPoints.isEmpty()))
    {
      this.mHasBodyDetected = true;
      this.mHasSeenValid = true;
      this.mPreviousLostTime = System.currentTimeMillis();
      this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
      return;
    }
    this.mHasBodyDetected = false;
    if (this.mHasSeenValid)
    {
      if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect)
      {
        paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
        return;
      }
      this.mHasSeenValid = false;
      this.mPreviousBodyPoints = null;
    }
  }
  
  private void checkFirstSysnc()
  {
    if ((this.mMusicPlayFirstSync > 0) && (Math.abs(System.currentTimeMillis() - this.frameStartTime - this.mPlayer.getCurrentPosition()) > 500L))
    {
      int i = (int)(System.currentTimeMillis() - this.frameStartTime);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mPlayer.getCurrentPosition());
      localStringBuilder.append("||CORRECT:");
      localStringBuilder.append(i);
      LogUtils.i(str, localStringBuilder.toString());
      PlayerUtil.seekPlayer(this.mPlayer, i);
      this.mMusicPlayFirstSync = 0;
    }
  }
  
  private void initAudio()
  {
    if (this.mPlayer != null) {
      return;
    }
    if ((this.item != null) && (!TextUtils.isEmpty(this.dataPath)) && (!TextUtils.isEmpty(this.item.id)) && (!TextUtils.isEmpty(this.item.audio)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.dataPath);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.id);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.audio);
      localObject = ((StringBuilder)localObject).toString();
      if (((String)localObject).startsWith("assets://")) {
        this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), ((String)localObject).replace("assets://", ""), false);
      } else {
        this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), (String)localObject, false);
      }
      if (this.mPlayer != null) {
        TouchTriggerManager.getInstance().setMusicDuration(this.mPlayer.getDuration());
      }
    }
  }
  
  private boolean isFullScreenRender(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return false;
    }
    paramAttributeParam = paramAttributeParam.vertices;
    int j = paramAttributeParam.length;
    int i = 0;
    while (i < j)
    {
      float f = paramAttributeParam[i];
      if ((Float.compare(-1.0F, f) != 0) && (Float.compare(1.0F, f) != 0)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void playMusic(boolean paramBoolean)
  {
    int i = this.playMode;
    if (i == 0)
    {
      PlayerUtil.startPlayer(this.mPlayer, paramBoolean);
      recordMusicStartInfo(false);
      checkFirstSysnc();
      return;
    }
    if ((i == 1) && (this.mIsNeedSeekTime))
    {
      long l = System.currentTimeMillis();
      PlayerUtil.Player localPlayer = this.mPlayer;
      PlayerUtil.seekPlayer(localPlayer, (int)(l - this.firstTriggerInStateTime) % localPlayer.getDuration());
      this.mIsNeedSeekTime = false;
      return;
    }
    PlayerUtil.startPlayer(this.mPlayer, false);
    recordMusicStartInfo(false);
    checkFirstSysnc();
  }
  
  private void recordMusicStartInfo(boolean paramBoolean)
  {
    if (this.mPlayer == null) {
      return;
    }
    if (TouchTriggerManager.getInstance().getMusicStartTime() <= 0L) {
      TouchTriggerManager.getInstance().setMusicStartTime(System.currentTimeMillis());
    }
    if ((!this.mIsLastPause) && (paramBoolean)) {
      try
      {
        TouchTriggerManager.getInstance().setMusicCurrentPosition(this.mPlayer.getCurrentPosition());
      }
      catch (IllegalStateException localIllegalStateException)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("IllegalStateException:mPlayer.getCurrentPosition()->");
        localStringBuilder.append(localIllegalStateException.getMessage());
        LogUtils.e(str, localStringBuilder.toString());
      }
    }
    this.mIsLastPause = paramBoolean;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GlUtil.createEtcTexture(this.tex);
    if ((this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.PAG))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.dataPath);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.subFolder);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.id);
      String str = ((StringBuilder)localObject).toString();
      localObject = str;
      if (!str.endsWith(".mp4"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(".mp4");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.mVideoDecoder = new ActVideoDecoder((String)localObject, this.tex[0]);
    }
    if (this.item.sourceType == VideoMaterial.ITEM_SOURCE_TYPE.PAG) {
      VideoMemoryManager.getInstance().initInGLThread(this.item.id, this.tex[0]);
    }
  }
  
  public boolean canUseBlendMode()
  {
    StickerItem localStickerItem = this.item;
    return (localStickerItem != null) && (localStickerItem.blendMode < 2) && (!this.item.isDisplacementMaterial());
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    int[] arrayOfInt = this.tex;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    int i = 0;
    try
    {
      while (i < this.tex.length)
      {
        this.tex[i] = 0;
        i += 1;
      }
      if (this.mVideoDecoder != null)
      {
        this.mVideoDecoder.release();
        this.mVideoDecoder = null;
        VideoMemoryManager.getInstance().setVideoPath(null);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected void clearTextureParam()
  {
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    destroyAudio();
  }
  
  public void destroyAudio()
  {
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public float getFrameDuration(long paramLong)
  {
    if (!this.triggered) {
      return 0.0F;
    }
    double d = paramLong - this.frameStartTime;
    Double.isNaN(d);
    return (float)(d / 1000.0D);
  }
  
  public int getFrameIndex()
  {
    return this.frameIndex;
  }
  
  public long getFrameStartTime()
  {
    return this.frameStartTime;
  }
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
  }
  
  protected int getNextFrame(int paramInt)
  {
    if (VideoMaterial.isEmptyItem(this.item)) {
      return this.tex[0];
    }
    Object localObject = VideoMemoryManager.getInstance().getVideoPath();
    String str;
    StringBuilder localStringBuilder;
    if ((this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.PAG))
    {
      if ((localObject != null) && (((String)localObject).endsWith(".png")))
      {
        localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        if (BitmapUtils.isLegal((Bitmap)localObject))
        {
          BenchUtil.benchStart("1normal loadTexture");
          try
          {
            GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
          }
          catch (Exception localException1)
          {
            str = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("1getNextFrame:loadTexture Exception:");
            localStringBuilder.append(localException1.getMessage());
            LogUtils.e(str, localStringBuilder.toString());
          }
          this.isImageReady = true;
          if (localObject != null) {
            ((Bitmap)localObject).recycle();
          }
        }
        localObject = this.mVideoDecoder;
        if (localObject != null) {
          ((ActVideoDecoder)localObject).release();
        }
        VideoMemoryManager.getInstance().setVideoPath(null);
      }
      else
      {
        ActVideoDecoder localActVideoDecoder = this.mVideoDecoder;
        if (localActVideoDecoder != null)
        {
          localActVideoDecoder.decodeFrame(paramInt);
          if (this.mVideoDecoder.updateFrame()) {
            this.isImageReady = true;
          }
          this.lastImageIndex = paramInt;
          if ((localObject != null) && (((String)localObject).endsWith(".mp4")))
          {
            this.mVideoDecoder.release();
            this.mVideoDecoder = null;
            this.mVideoDecoder = new ActVideoDecoder((String)localObject, this.tex[0]);
            VideoMemoryManager.getInstance().setVideoPath(null);
          }
        }
      }
    }
    else if (this.tex[0] != 0) {
      if ((this.item.sourceType == VideoMaterial.ITEM_SOURCE_TYPE.PAG) && (!VideoMemoryManager.getInstance().isExtraStickerBitmap(this.item.id)))
      {
        if (VideoMemoryManager.getInstance().loadExtraStickerTxt(this.item.id, paramInt, this.tex[0]) >= 0)
        {
          this.isImageReady = true;
          this.lastImageIndex = paramInt;
        }
      }
      else
      {
        localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
        int i;
        if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!this.isImageReady) || (this.isRenderForBitmap)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(FileUtils.genSeperateFileDir(this.dataPath));
          ((StringBuilder)localObject).append(this.item.subFolder);
          ((StringBuilder)localObject).append(File.separator);
          ((StringBuilder)localObject).append(this.item.id);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(".png");
          localObject = ((StringBuilder)localObject).toString();
          localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (BitmapUtils.isLegal((Bitmap)localObject))
        {
          BenchUtil.benchStart("normal loadTexture");
          try
          {
            GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
          }
          catch (Exception localException2)
          {
            str = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getNextFrame:loadTexture Exception:");
            localStringBuilder.append(localException2.getMessage());
            PTFaceLogUtil.e(str, localStringBuilder.toString());
          }
          BenchUtil.benchEnd("normal loadTexture");
          this.spritePictureWidth = ((Bitmap)localObject).getWidth();
          this.spritePictureHeight = ((Bitmap)localObject).getHeight();
          if (i != 0) {
            ((Bitmap)localObject).recycle();
          } else {
            VideoMemoryManager.getInstance().recycleBitmap(this.item.id, (Bitmap)localObject);
          }
          this.isImageReady = true;
          this.lastImageIndex = paramInt;
        }
      }
    }
    return this.tex[0];
  }
  
  public StickerItem getStickerItem()
  {
    return this.item;
  }
  
  protected int getTextureId()
  {
    return this.tex[0];
  }
  
  public void initParams()
  {
    int i = this.item.transformType;
    int j = -1;
    if (i == 1)
    {
      i = -1;
    }
    else
    {
      if (this.item.transformType == 2)
      {
        i = 1;
        break label40;
      }
      i = 1;
    }
    j = 1;
    label40:
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.IntParam("texNeedTransform", 1));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("texScale", 1.0F));
    addParam(new UniformParam.FloatParam("texScaleX", j));
    addParam(new UniformParam.FloatParam("texScaleY", i));
    addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("alpha", 1.0F));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    addParam(new UniformParam.Float2fParam("displacement", this.item.displacementX, this.item.displacementY));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.dataPath);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.item.displacementLutPath);
    localObject = ((StringBuilder)localObject).toString();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.item.isDisplacementMaterial()))
    {
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, 1);
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        addParam(new UniformParam.TextureBitmapParam("inputImageTexture4", (Bitmap)localObject, 33988, true));
        addParam(new UniformParam.IntParam("displacementEnableLut", 1));
      }
      else
      {
        addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
        addParam(new UniformParam.IntParam("displacementEnableLut", 0));
      }
    }
    else
    {
      addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
      addParam(new UniformParam.IntParam("displacementEnableLut", 0));
    }
    addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
    addParam(new UniformParam.FloatParam("useDisplacementMask", 0.0F));
  }
  
  public boolean isFirstTriggered()
  {
    return this.isFirstTriggered;
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isImageReady);
  }
  
  public boolean isStaticSticker()
  {
    StickerItem localStickerItem = this.item;
    return (localStickerItem != null) && ((localStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type));
  }
  
  public boolean needCopyTex()
  {
    StickerItem localStickerItem = this.item;
    boolean bool = false;
    if (localStickerItem == null) {
      return false;
    }
    if (((localStickerItem.blendMode >= 2) && (this.item.blendMode <= 12)) || (this.item.isDisplacementMaterial())) {
      bool = true;
    }
    return bool;
  }
  
  boolean needLoadImage()
  {
    return (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.FACE_FEATURE.type) && (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.SNAP_SHOT.type);
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void pauseAndSeekToOrigin()
  {
    PlayerUtil.pauseAndSeekToOrigin(this.mPlayer);
  }
  
  public void reset()
  {
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mPreviousBodyPoints = null;
    this.mAudioPause = false;
    pauseAndSeekToOrigin();
    this.mLastPosition = -1;
    this.musicPlayCount = 1;
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setAudioScaleFactor(float paramFloat)
  {
    this.audioScaleFactor = paramFloat;
  }
  
  public void setFirstPlaySync(int paramInt)
  {
    if (this.mMusicPlayFirstSync < 0) {
      this.mMusicPlayFirstSync = paramInt;
    }
  }
  
  public void setFirstTriggerInStateTime(long paramLong)
  {
    this.firstTriggerInStateTime = paramLong;
  }
  
  public void setFirstTriggered(boolean paramBoolean)
  {
    this.isFirstTriggered = paramBoolean;
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.frameIndex = paramInt;
  }
  
  public void setFrameStartTime(long paramLong)
  {
    this.frameStartTime = paramLong;
  }
  
  public void setHotAreaPosition(ArrayList<RedPacketPosition> paramArrayList)
  {
    this.hotAreaPositions = paramArrayList;
  }
  
  public void setIsInState(boolean paramBoolean)
  {
    this.isInState = paramBoolean;
  }
  
  public void setLastFrameIndex(int paramInt)
  {
    this.lastImageIndex = paramInt;
  }
  
  public void setPlayMode(int paramInt)
  {
    this.playMode = paramInt;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    this.isRenderForBitmap = paramBoolean;
  }
  
  public void setTriggered(boolean paramBoolean)
  {
    this.triggered = paramBoolean;
  }
  
  protected void updateCatFacePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat) {}
  
  public void updateHotArea(ArrayList<RedPacketPosition> paramArrayList)
  {
    if (paramArrayList != null) {
      this.hotAreaPositions.addAll(paramArrayList);
    }
  }
  
  protected void updatePlayer(boolean paramBoolean)
  {
    if (!this.triggered)
    {
      destroyAudio();
      if ((this.playMode == 1) && (this.isInState)) {
        this.mIsNeedSeekTime = true;
      }
      return;
    }
    if ((!VideoPrefsUtil.getMaterialMute()) && (!this.mAudioPause))
    {
      initAudio();
      if (this.mPlayer == null) {
        return;
      }
      if (this.item.audioLoopCount > 0)
      {
        if (this.mLastPosition > this.mPlayer.getCurrentPosition())
        {
          this.musicPlayCount += 1;
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("music Count :");
          localStringBuilder.append(this.musicPlayCount);
          LogUtils.i(str, localStringBuilder.toString());
        }
        this.mLastPosition = this.mPlayer.getCurrentPosition();
        if ((paramBoolean) || (this.musicPlayCount < this.item.audioLoopCount))
        {
          playMusic(paramBoolean);
          this.needPlayMusic = false;
        }
      }
      else
      {
        playMusic(paramBoolean);
      }
    }
    else
    {
      PlayerUtil.stopPlayer(this.mPlayer);
      recordMusicStartInfo(true);
      LogUtils.i(TAG, "Stop !");
    }
  }
  
  protected void updatePositions(List<PointF> paramList) {}
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat);
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt) {}
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if ((this.item.isDisplacementMaterial()) && (paramObject.displacementMaskFrame != null) && (paramObject.displacementMaskFrame.getLastRenderTextureId() > 0))
      {
        addParam(new UniformParam.TextureParam("inputImageTexture5", paramObject.displacementMaskFrame.getLastRenderTextureId(), 33989));
        addParam(new UniformParam.FloatParam("useDisplacementMask", 1.0F));
      }
      else
      {
        addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
        addParam(new UniformParam.FloatParam("useDisplacementMask", 0.0F));
      }
      if (VideoMaterial.isBodyDetectItem(this.item)) {
        avoidBodyPointsShake(paramObject);
      }
      updatePlayer(this.isFirstTriggered);
      int i = this.frameIndex;
      if (!needRenderTexture())
      {
        clearTextureParam();
        VideoMemoryManager.getInstance().reset(this.item.id);
        updateTextureParam(0, paramObject.timestamp);
        return;
      }
      if (VideoMaterial.isGestureItem(this.item))
      {
        updatePositions(paramObject.handPoints);
      }
      else if (VideoMaterial.isBodyDetectItem(this.item))
      {
        if (VideoMaterial.isBody4AnchorItem(this.item)) {
          updatePositionsForMultiAnchor(paramObject.bodyPoints, 4);
        } else if (VideoMaterial.isBody2AnchorItem(this.item)) {
          updatePositionsForMultiAnchor(paramObject.bodyPoints, 2);
        } else {
          updatePositions(paramObject.bodyPoints);
        }
        if (!this.mHasBodyDetected) {
          paramObject.bodyPoints = null;
        }
      }
      else if (VideoMaterial.isCatItem(this.item))
      {
        updateCatFacePositions(paramObject.catFacePoints, paramObject.catFaceAngles, paramObject.phoneAngle);
      }
      else
      {
        updatePositions(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle);
      }
      updateTextureParam(i, paramObject.timestamp);
    }
  }
  
  public void updateRandomGroupValue(int paramInt) {}
  
  public void updateTextureParam(int paramInt)
  {
    if (needLoadImage()) {
      return;
    }
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
    this.isImageReady = true;
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (!needLoadImage()) {
      return;
    }
    if ((paramInt == this.lastImageIndex) && (this.item.isCanDiyPitcureVideo == 0)) {
      return;
    }
    Object localObject;
    if (this.lastImageIndex > paramInt)
    {
      localObject = this.mVideoDecoder;
      if (localObject != null) {
        ((ActVideoDecoder)localObject).reset();
      }
    }
    if (this.item.stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type)
    {
      localObject = VideoMemoryManager.getInstance().loadETCRGBTexture(this.item.id, paramInt);
      ETC1Util.ETC1Texture localETC1Texture = VideoMemoryManager.getInstance().loadETCAlphaTexture(this.item.id, paramInt);
      if ((localObject != null) && (localETC1Texture != null))
      {
        BenchUtil.benchStart("mPkmReader loadTexture");
        GlUtil.loadTexture(this.tex[0], (ETC1Util.ETC1Texture)localObject);
        GlUtil.loadTexture(this.tex[1], localETC1Texture);
        BenchUtil.benchEnd("mPkmReader loadTexture");
        addParam(new UniformParam.TextureParam("inputImageTexture2", this.tex[0], 33986));
        addParam(new UniformParam.TextureParam("inputImageTexture3", this.tex[1], 33987));
        this.isImageReady = true;
        this.lastImageIndex = paramInt;
      }
    }
    else
    {
      if (this.item.stickerType == VideoFilterFactory.STICKER_TYPE.SPIRITE.type)
      {
        if (!this.gotSpritePicture)
        {
          addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(paramInt), 33986));
          this.gotSpritePicture = true;
          if ((this.item.frameSize != null) && (this.item.frameSize.length >= 2))
          {
            this.spritePictureColumn = (this.spritePictureWidth / this.item.frameSize[0]);
            this.spritePictureRow = (this.spritePictureHeight / this.item.frameSize[1]);
          }
          else
          {
            LogUtils.e(TAG, "SPIRITE Invalid frameSize.");
          }
        }
        int i = this.spritePictureColumn;
        int j = this.spritePictureRow;
        if (paramInt >= i * j) {
          return;
        }
        float f1 = 1.0F / j * Math.min(j - 1, paramInt / i);
        float f2 = Math.min(1.0F / this.spritePictureRow + f1, 1.0F);
        i = this.spritePictureColumn;
        float f3 = 1.0F / i * (paramInt % i);
        float f4 = Math.min(1.0F / i + f3, 1.0F);
        setTexCords(new float[] { f3, f1, f3, f2, f4, f2, f4, f1 });
        this.lastImageIndex = paramInt;
        return;
      }
      addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(paramInt), 33986));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.NormalVideoFilter
 * JD-Core Version:    0.7.0.1
 */