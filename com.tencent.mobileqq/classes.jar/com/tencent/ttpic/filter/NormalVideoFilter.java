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
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.recorder.ActVideoDecoder;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
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
  private static final String TAG = NormalVideoFilter.class.getSimpleName();
  private boolean gotSpritePicture = false;
  private ArrayList<RedPacketPosition> hotAreaPositions;
  protected boolean isImageReady;
  protected StickerItem item;
  private int lastImageIndex = -1;
  private boolean mAudioPause;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  private PlayerUtil.Player mPlayer;
  public List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  private long mTimesForLostProtect = 2000L;
  protected ActVideoDecoder mVideoDecoder;
  private int spritePictureColumn;
  private int spritePictureHeight;
  private int spritePictureRow;
  private int spritePictureWidth;
  private int[] tex = new int[2];
  protected TriggerCtrlItem triggerCtrlItem;
  protected boolean triggered = false;
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
    this.item = paramStickerItem;
    this.dataPath = paramString;
    this.triggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
    initParams();
    initAudio();
  }
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramString2, paramString3);
    this.item = paramStickerItem;
    this.dataPath = paramString1;
    this.triggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
    initParams();
    initAudio();
  }
  
  private void avoidBodyPointsShake(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo.bodyPoints == null) || (paramPTDetectInfo.bodyPoints.isEmpty()))
    {
      this.mHasBodyDetected = false;
      if (this.mHasSeenValid)
      {
        if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
          paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
        }
      }
      else {
        return;
      }
      this.mHasSeenValid = false;
      this.mPreviousBodyPoints = null;
      return;
    }
    this.mHasBodyDetected = true;
    this.mHasSeenValid = true;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
  }
  
  private int getNextFrame(int paramInt)
  {
    if (VideoMaterialUtil.isEmptyItem(this.item)) {
      return this.tex[0];
    }
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) && (this.mVideoDecoder != null))
    {
      this.mVideoDecoder.decodeFrame(paramInt);
      if (this.mVideoDecoder.updateFrame()) {
        this.isImageReady = true;
      }
      this.lastImageIndex = paramInt;
    }
    label405:
    for (;;)
    {
      return this.tex[0];
      if (this.tex[0] != 0) {
        if ((this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) && (!VideoMemoryManager.getInstance().isExtraStickerBitmap(this.item.id)))
        {
          if (VideoMemoryManager.getInstance().loadExtraStickerTxt(this.item.id, paramInt, this.tex[0]) >= 0)
          {
            this.isImageReady = true;
            this.lastImageIndex = paramInt;
          }
        }
        else
        {
          Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
          if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!this.isImageReady) || (this.triggerCtrlItem.isRenderForBitmap())))
          {
            localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
            localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
          }
          for (int i = 1;; i = 0) {
            for (;;)
            {
              if (!BitmapUtils.isLegal((Bitmap)localObject)) {
                break label405;
              }
              BenchUtil.benchStart("normal loadTexture");
              try
              {
                GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
                BenchUtil.benchEnd("normal loadTexture");
                this.spritePictureWidth = ((Bitmap)localObject).getWidth();
                this.spritePictureHeight = ((Bitmap)localObject).getHeight();
                if (i != 0)
                {
                  ((Bitmap)localObject).recycle();
                  this.isImageReady = true;
                  this.lastImageIndex = paramInt;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  PTFaceLogUtil.e(TAG, "getNextFrame:loadTexture Exception:" + localException.getMessage());
                  continue;
                  VideoMemoryManager.getInstance().recycleBitmap(this.item.id, (Bitmap)localObject);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void initAudio()
  {
    if (this.mPlayer != null) {}
    while ((this.item == null) || (TextUtils.isEmpty(this.dataPath)) || (TextUtils.isEmpty(this.item.id)) || (TextUtils.isEmpty(this.item.audio))) {
      return;
    }
    String str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
    if (str.startsWith("assets://"))
    {
      this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), str.replace("assets://", ""), false);
      return;
    }
    this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), str, false);
  }
  
  private boolean isFullScreenRender(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return false;
    }
    paramAttributeParam = paramAttributeParam.vertices;
    int j = paramAttributeParam.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      float f = paramAttributeParam[i];
      if ((Float.compare(-1.0F, f) != 0) && (Float.compare(1.0F, f) != 0)) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  private void updateHotArea()
  {
    if ((this.triggerCtrlItem != null) && (this.hotAreaPositions != null))
    {
      ArrayList localArrayList = this.triggerCtrlItem.getHotArea();
      if (localArrayList != null) {
        this.hotAreaPositions.addAll(localArrayList);
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GlUtil.createEtcTexture(this.tex);
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG))
    {
      String str2 = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id;
      String str1 = str2;
      if (!str2.endsWith(".mp4")) {
        str1 = str2 + ".mp4";
      }
      this.mVideoDecoder = new ActVideoDecoder(str1, this.tex[0]);
    }
    if (this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) {
      VideoMemoryManager.getInstance().initInGLThread(this.item.id, this.tex[0]);
    }
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item != null) && (this.item.blendMode < 2);
  }
  
  public void clearGLSLSelf()
  {
    int i = 0;
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
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
      }
      return;
    }
    finally {}
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
    return (float)((paramLong - this.triggerCtrlItem.getFrameStartTime()) / 1000.0D);
  }
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
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
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.IntParam("texNeedTransform", 1));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("texScale", 1.0F));
    addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("alpha", 1.0F));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isImageReady);
  }
  
  public boolean isStaticSticker()
  {
    return (this.item != null) && ((this.item.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type));
  }
  
  public boolean needCopyTex()
  {
    if (this.item == null) {}
    while ((this.item.blendMode < 2) || (this.item.blendMode > 12)) {
      return false;
    }
    return true;
  }
  
  boolean needLoadImage()
  {
    return (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.FACE_FEATURE.type) && (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.SNAP_SHOT.type);
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void reset()
  {
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mPreviousBodyPoints = null;
    this.triggerCtrlItem.reset();
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setHotAreaPosition(ArrayList<RedPacketPosition> paramArrayList)
  {
    this.hotAreaPositions = paramArrayList;
  }
  
  public void setLastFrameIndex(int paramInt)
  {
    this.lastImageIndex = paramInt;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    this.triggerCtrlItem.setRenderForBitmap(paramBoolean);
  }
  
  public void setTriggerWords(String paramString)
  {
    TriggerCtrlItem localTriggerCtrlItem = this.triggerCtrlItem;
    String str = paramString;
    if (this.item != null)
    {
      str = paramString;
      if (!TextUtils.isEmpty(this.item.triggerWords)) {
        str = this.item.triggerWords;
      }
    }
    localTriggerCtrlItem.setTriggerWords(str);
  }
  
  protected TRIGGERED_STATUS updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    return this.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
  }
  
  protected void updatePlayer(boolean paramBoolean)
  {
    this.triggered = this.triggerCtrlItem.isTriggered();
    if (!this.triggered) {
      destroyAudio();
    }
    do
    {
      return;
      if ((VideoPrefsUtil.getMaterialMute()) || (this.mAudioPause)) {
        break label72;
      }
      initAudio();
      if (this.item.audioLoopCount <= 0) {
        break;
      }
    } while (!paramBoolean);
    PlayerUtil.startPlayer(this.mPlayer, true);
    return;
    PlayerUtil.startPlayer(this.mPlayer, paramBoolean);
    return;
    label72:
    PlayerUtil.stopPlayer(this.mPlayer);
  }
  
  protected void updatePositions(List<PointF> paramList) {}
  
  protected void updatePositions(List<PointF> paramList, int paramInt) {}
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat);
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt) {}
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
        avoidBodyPointsShake(paramObject);
      }
      TRIGGERED_STATUS localTRIGGERED_STATUS = updateActionTriggered(paramObject);
      updateHotArea();
      if (localTRIGGERED_STATUS != TRIGGERED_STATUS.FIRST_TRIGGERED) {
        break label95;
      }
    }
    int i;
    label95:
    for (boolean bool = true;; bool = false)
    {
      updatePlayer(bool);
      i = this.triggerCtrlItem.getFrameIndex();
      if (needRenderTexture()) {
        break;
      }
      clearTextureParam();
      VideoMemoryManager.getInstance().reset(this.item.id);
      updateTextureParam(0, paramObject.timestamp);
      return;
    }
    if (VideoMaterialUtil.isGestureItem(this.item)) {
      updatePositions(paramObject.handPoints);
    }
    for (;;)
    {
      updateTextureParam(i, paramObject.timestamp);
      return;
      if (VideoMaterialUtil.isBodyDetectItem(this.item))
      {
        if (VideoMaterialUtil.isBody4AnchorItem(this.item)) {
          updatePositionsForMultiAnchor(paramObject.bodyPoints, 4);
        }
        for (;;)
        {
          if (this.mHasBodyDetected) {
            break label203;
          }
          paramObject.bodyPoints = null;
          break;
          if (VideoMaterialUtil.isBody2AnchorItem(this.item)) {
            updatePositionsForMultiAnchor(paramObject.bodyPoints, 2);
          } else {
            updatePositions(paramObject.bodyPoints);
          }
        }
      }
      else
      {
        label203:
        updatePositions(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle);
      }
    }
  }
  
  public void updateRandomGroupValue(int paramInt)
  {
    this.triggerCtrlItem.setRandomGroupValue(paramInt);
  }
  
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
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramInt != this.lastImageIndex)
      {
        if ((this.lastImageIndex > paramInt) && (this.mVideoDecoder != null)) {
          this.mVideoDecoder.reset();
        }
        if (this.item.stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type)
        {
          ETC1Util.ETC1Texture localETC1Texture1 = VideoMemoryManager.getInstance().loadETCRGBTexture(this.item.id, paramInt);
          ETC1Util.ETC1Texture localETC1Texture2 = VideoMemoryManager.getInstance().loadETCAlphaTexture(this.item.id, paramInt);
          if ((localETC1Texture1 == null) || (localETC1Texture2 == null)) {
            break;
          }
          BenchUtil.benchStart("mPkmReader loadTexture");
          GlUtil.loadTexture(this.tex[0], localETC1Texture1);
          GlUtil.loadTexture(this.tex[1], localETC1Texture2);
          BenchUtil.benchEnd("mPkmReader loadTexture");
          addParam(new UniformParam.TextureParam("inputImageTexture2", this.tex[0], 33986));
          addParam(new UniformParam.TextureParam("inputImageTexture3", this.tex[1], 33987));
          this.isImageReady = true;
          this.lastImageIndex = paramInt;
          return;
        }
        if (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.SPIRITE.type) {
          break label453;
        }
        if (!this.gotSpritePicture)
        {
          addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(paramInt), 33986));
          this.gotSpritePicture = true;
          if ((this.item.frameSize == null) || (this.item.frameSize.length < 2)) {
            break label441;
          }
          this.spritePictureColumn = (this.spritePictureWidth / this.item.frameSize[0]);
          this.spritePictureRow = (this.spritePictureHeight / this.item.frameSize[1]);
        }
        while (paramInt < this.spritePictureColumn * this.spritePictureRow)
        {
          float f1 = 1.0F / this.spritePictureRow * Math.min(this.spritePictureRow - 1, paramInt / this.spritePictureColumn);
          float f2 = Math.min(1.0F / this.spritePictureRow + f1, 1.0F);
          float f3 = 1.0F / this.spritePictureColumn * (paramInt % this.spritePictureColumn);
          float f4 = Math.min(1.0F / this.spritePictureColumn + f3, 1.0F);
          setTexCords(new float[] { f3, f1, f3, f2, f4, f2, f4, f1 });
          this.lastImageIndex = paramInt;
          return;
          label441:
          LogUtils.e(TAG, "SPIRITE Invalid frameSize.");
        }
      }
    }
    label453:
    addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(paramInt), 33986));
  }
  
  public void updateTextureParam(long paramLong)
  {
    this.triggerCtrlItem.updateFrameIndex(paramLong);
    int i = this.triggerCtrlItem.getFrameIndex();
    try
    {
      updateTextureParam(i, paramLong);
      return;
    }
    finally {}
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.NormalVideoFilter
 * JD-Core Version:    0.7.0.1
 */