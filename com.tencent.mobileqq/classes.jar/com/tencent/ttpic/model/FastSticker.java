package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.openapi.recorder.ActVideoDecoder;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.PersonParam;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class FastSticker
{
  protected String dataPath;
  protected int height;
  private ArrayList<RedPacketPosition> hotAreaPositions;
  protected boolean isImageReady;
  protected StickerItem item;
  private int lastImageIndex = -1;
  private boolean mAudioPause;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  protected boolean mIsRenderForBitmap = false;
  private PlayerUtil.Player mPlayer;
  public List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  protected double mScreenScale;
  private long mTimesForLostProtect = 2000L;
  protected ActVideoDecoder mVideoDecoder;
  protected RenderParam renderParam = new RenderParam();
  private int[] tex = new int[1];
  protected TriggerCtrlItem triggerCtrlItem;
  protected boolean triggered = false;
  protected int width;
  
  FastSticker(StickerItem paramStickerItem, String paramString)
  {
    this.item = paramStickerItem;
    this.dataPath = paramString;
    this.renderParam.id = paramStickerItem.id;
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
      if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
        paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
      }
    }
    else {
      this.mHasSeenValid = false;
    }
  }
  
  private int getNextFrame(int paramInt)
  {
    Object localObject;
    if ((this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.PAG))
    {
      localObject = this.mVideoDecoder;
      if (localObject != null)
      {
        ((ActVideoDecoder)localObject).decodeFrame(paramInt);
        this.mVideoDecoder.updateFrame();
        this.isImageReady = true;
        this.lastImageIndex = paramInt;
        break label333;
      }
    }
    if (this.tex[0] != 0) {
      if ((this.item.sourceType == VideoMaterial.ITEM_SOURCE_TYPE.PAG) && (!VideoMemoryManager.getInstance().isExtraStickerBitmap(this.item.id)))
      {
        if (VideoMemoryManager.getInstance().loadExtraStickerTxt(this.item.id, paramInt, this.tex[0]) >= 0) {
          this.isImageReady = true;
        }
        this.lastImageIndex = paramInt;
      }
      else
      {
        localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
        int i;
        if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!this.isImageReady) || (this.mIsRenderForBitmap)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.dataPath);
          ((StringBuilder)localObject).append(File.separator);
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
          GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
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
    label333:
    return this.tex[0];
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
      if (((String)localObject).startsWith("assets://"))
      {
        this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), ((String)localObject).replace("assets://", ""), false);
        return;
      }
      this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), (String)localObject, false);
    }
  }
  
  private boolean isRangeValueHit()
  {
    return ((this.item.charmRange == null) || (this.item.charmRange.isHit())) && ((this.item.ageRange == null) || (this.item.ageRange.isHit())) && ((this.item.genderRange == null) || (this.item.genderRange.isHit())) && ((this.item.popularRange == null) || (this.item.popularRange.isHit())) && ((this.item.cpRange == null) || (this.item.cpRange.isHit()));
  }
  
  private void updateHotArea(int paramInt)
  {
    if (this.triggered)
    {
      Object localObject1 = this.item;
      if ((localObject1 != null) && (((StickerItem)localObject1).hotArea != null) && (this.item.hotArea.length > 0) && (paramInt >= this.item.redPacketStartFrame) && (paramInt <= this.item.redPacketEndFrame))
      {
        int i = this.item.hotArea.length / 4;
        localObject1 = new ArrayList();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = new RedPacketPosition();
          double[] arrayOfDouble = this.item.hotArea;
          int j = paramInt * 4;
          ((RedPacketPosition)localObject2).x = arrayOfDouble[j];
          ((RedPacketPosition)localObject2).y = this.item.hotArea[(j + 1)];
          ((RedPacketPosition)localObject2).width = this.item.hotArea[(j + 2)];
          ((RedPacketPosition)localObject2).height = this.item.hotArea[(j + 3)];
          ((ArrayList)localObject1).add(localObject2);
          paramInt += 1;
        }
        Object localObject2 = this.hotAreaPositions;
        if (localObject2 != null) {
          ((ArrayList)localObject2).addAll((Collection)localObject1);
        }
      }
    }
  }
  
  private void updateTriggerAudio(boolean paramBoolean)
  {
    if (!this.triggered)
    {
      destroyAudio();
      return;
    }
    if ((!VideoPrefsUtil.getMaterialMute()) && (!this.mAudioPause))
    {
      initAudio();
      if (this.item.audioLoopCount > 0)
      {
        if (paramBoolean) {
          PlayerUtil.startPlayer(this.mPlayer, true);
        }
      }
      else {
        PlayerUtil.startPlayer(this.mPlayer, paramBoolean);
      }
    }
    else
    {
      PlayerUtil.stopPlayer(this.mPlayer);
    }
  }
  
  public void ApplyGLSLFilter()
  {
    Object localObject = this.tex;
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    if ((this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.PAG))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.dataPath);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.subFolder);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.id);
      ((StringBuilder)localObject).append(".mp4");
      this.mVideoDecoder = new ActVideoDecoder(((StringBuilder)localObject).toString(), this.tex[0]);
    }
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item.blendMode < 2) || (this.item.blendMode > 12);
  }
  
  public void clearGLSLSelf()
  {
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
    this.renderParam.position = GlUtil.EMPTY_POSITIONS_TRIANGLES;
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    PlayerUtil.destroyPlayer(this.mPlayer);
  }
  
  public void destroyAudio()
  {
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public String getItemID()
  {
    if (this.item != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.item.id);
      localStringBuilder.append(this.item.hashCode());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
  }
  
  public RenderParam getRenderParam()
  {
    return this.renderParam;
  }
  
  public int getTexture()
  {
    return this.tex[0];
  }
  
  public boolean isMatchGender(PersonParam paramPersonParam)
  {
    if (this.item.genderType == 0) {
      return true;
    }
    if (paramPersonParam == null) {
      return false;
    }
    return paramPersonParam.isGenderMatch(this.item.genderType);
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isImageReady);
  }
  
  public boolean needRender(int paramInt)
  {
    int i = this.item.personID;
    boolean bool2 = false;
    if ((i != -1) && (this.item.personID != paramInt)) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.triggered)
    {
      bool1 = bool2;
      if (this.isImageReady) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void reset()
  {
    this.triggered = false;
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mPreviousBodyPoints = null;
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable) {}
  
  public void setHotAreaPosition(ArrayList<RedPacketPosition> paramArrayList)
  {
    this.hotAreaPositions = paramArrayList;
  }
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  public void setTriggerCtrlItem(TriggerCtrlItem paramTriggerCtrlItem)
  {
    this.triggerCtrlItem = paramTriggerCtrlItem;
  }
  
  protected abstract void updatePositions(List<PointF> paramList);
  
  protected abstract void updatePositions(List<PointF> paramList, int paramInt);
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat);
  
  protected abstract void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt);
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (VideoMaterial.isBodyDetectItem(this.item)) {
        avoidBodyPointsShake(paramObject);
      }
      TriggerCtrlItem localTriggerCtrlItem = this.triggerCtrlItem;
      int i;
      if (localTriggerCtrlItem != null)
      {
        i = localTriggerCtrlItem.getFrameIndex();
        updateTriggerAudio(this.triggerCtrlItem.isFirstTriggered());
        this.triggered = this.triggerCtrlItem.isTriggered();
      }
      else
      {
        i = 0;
      }
      updateHotArea(i);
      if (!needRenderTexture())
      {
        clearTextureParam();
        VideoMemoryManager.getInstance().reset(this.item.id);
        updateTextureParam(0);
        return;
      }
      if (VideoMaterial.isFaceItem(this.item))
      {
        updatePositions(paramObject.facePoints, paramObject.faceAngles);
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
      else if (VideoMaterial.isGestureItem(this.item))
      {
        updatePositions(paramObject.handPoints, 0);
      }
      updateTextureParam(i);
    }
  }
  
  protected void updateTextureParam(int paramInt)
  {
    int i = this.lastImageIndex;
    if (paramInt == i) {
      return;
    }
    if (i > paramInt)
    {
      ActVideoDecoder localActVideoDecoder = this.mVideoDecoder;
      if (localActVideoDecoder != null) {
        localActVideoDecoder.reset();
      }
    }
    this.renderParam.texture = getNextFrame(paramInt);
  }
  
  public void updateTextureParam(long paramLong)
  {
    TriggerCtrlItem localTriggerCtrlItem = this.triggerCtrlItem;
    if (localTriggerCtrlItem != null)
    {
      int i = localTriggerCtrlItem.getFrameIndex();
      try
      {
        updateTextureParam(i);
        return;
      }
      finally {}
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.mScreenScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.FastSticker
 * JD-Core Version:    0.7.0.1
 */