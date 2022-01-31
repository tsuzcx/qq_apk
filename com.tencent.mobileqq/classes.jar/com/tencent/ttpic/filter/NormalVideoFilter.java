package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetectorManager;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.io.File;
import java.util.List;
import java.util.Map;

public abstract class NormalVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = NormalVideoFilter.class.getSimpleName();
  protected long frameStartTime;
  protected boolean isImageReady;
  protected int lastImageIndex = -1;
  private AudioUtils.Player mPlayer;
  protected ActVideoDecoder mVideoDecoder;
  protected final String materialId;
  protected int playCount = 0;
  protected int[] tex = new int[1];
  protected boolean triggered = false;
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString)
  {
    super(VideoFilterFactory.VERTEX_SHADER_COMMON, VideoFilterFactory.FRAGMENT_SHADER_IMAGE, paramStickerItem);
    if (paramStickerItem.anchorPoint != null)
    {
      int i = 0;
      while (i < paramStickerItem.anchorPoint.length)
      {
        int[] arrayOfInt = paramStickerItem.anchorPoint;
        arrayOfInt[i] = ((int)(arrayOfInt[i] * 1.0D));
        i += 1;
      }
    }
    paramStickerItem.width = ((int)(paramStickerItem.width * 1.0D));
    paramStickerItem.height = ((int)(paramStickerItem.height * 1.0D));
    paramStickerItem.scaleFactor = ((int)(paramStickerItem.scaleFactor * 1.0D));
    this.dataPath = paramString;
    this.materialId = VideoMaterialUtil.getMaterialId(paramString);
    setStickerItem(paramStickerItem);
    setDrawPartial(true);
    initParams();
  }
  
  public NormalVideoFilter(String paramString1, String paramString2, StickerItem paramStickerItem, String paramString3)
  {
    super(paramString1, paramString2, paramStickerItem);
    if (paramStickerItem.anchorPoint != null)
    {
      int i = 0;
      while (i < paramStickerItem.anchorPoint.length)
      {
        paramString1 = paramStickerItem.anchorPoint;
        paramString1[i] = ((int)(paramString1[i] * 1.0D));
        i += 1;
      }
    }
    paramStickerItem.width = ((int)(paramStickerItem.width * 1.0D));
    paramStickerItem.height = ((int)(paramStickerItem.height * 1.0D));
    paramStickerItem.scaleFactor = ((int)(paramStickerItem.scaleFactor * 1.0D));
    this.dataPath = paramString3;
    this.materialId = VideoMaterialUtil.getMaterialId(paramString3);
    setStickerItem(paramStickerItem);
    setDrawPartial(true);
    initParams();
  }
  
  private int getFrameIndex(FaceRangeStatus paramFaceRangeStatus, long paramLong)
  {
    if (!this.triggered) {
      this.frameStartTime = paramLong;
    }
    long l = this.frameStartTime;
    int i = 0;
    if (this.item.frameType == 0)
    {
      i = (int)((paramLong - l) / Math.max(this.item.frameDuration, 1.0D));
      if (i >= this.item.frames * (this.playCount + 1))
      {
        this.playCount += 1;
        if (!VideoPrefsUtil.getMaterialMute()) {
          AudioUtils.startPlayer(this.mPlayer, false);
        }
      }
      i %= Math.max(this.item.frames, 1);
    }
    while (this.item.frameType != 1) {
      return i;
    }
    return (int)((VideoFilterUtil.getFaceStatus(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange) - this.item.featureStatValueRange.min) / ((this.item.featureStatValueRange.max - this.item.featureStatValueRange.min) / this.item.frames));
  }
  
  private int getNextFrame(int paramInt)
  {
    this.isImageReady = false;
    if (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE)
    {
      this.mVideoDecoder.decodeFrame(paramInt);
      this.mVideoDecoder.updateFrame();
      this.isImageReady = true;
    }
    for (;;)
    {
      return this.tex[0];
      Bitmap localBitmap = ImageMemoryManager.getInstance().loadImage(this.item.id, paramInt);
      int i = 0;
      Object localObject = localBitmap;
      if (localBitmap == null)
      {
        i = 1;
        localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
        localObject = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      }
      if (VideoBitmapUtil.isLegal((Bitmap)localObject))
      {
        GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
        if (i != 0) {
          ((Bitmap)localObject).recycle();
        }
        this.isImageReady = true;
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
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
    if (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) {
      this.mVideoDecoder = new ActVideoDecoder(this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + ".mp4", this.tex[0]);
    }
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item.blendMode < 2) || (this.item.blendMode > 12);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
    if (this.mVideoDecoder != null) {
      this.mVideoDecoder.release();
    }
  }
  
  protected void clearTextureParam()
  {
    setPositions(VideoFilterUtil.EMPTY_POSITIONS);
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    AudioUtils.destroyPlayer(this.mPlayer);
  }
  
  public void destroyAudio()
  {
    AudioUtils.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public float getFrameDuration(long paramLong)
  {
    if (!this.triggered) {
      return 0.0F;
    }
    return (float)((paramLong - this.frameStartTime) / 1000.0D);
  }
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
  }
  
  public void initParams()
  {
    addParam(new Param.IntParam("blendMode", this.item.blendMode));
    addParam(new Param.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isImageReady);
  }
  
  public boolean needCopyTex()
  {
    if (this.item == null) {}
    while ((this.item.blendMode < 2) || (this.item.blendMode > 12) || (isFullScreenRender(getAttribParam("position")))) {
      return false;
    }
    return true;
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable) {}
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  protected void updateActionTriggered(Map<Integer, FaceActionCounter> paramMap, FaceRangeStatus paramFaceRangeStatus, long paramLong)
  {
    if (this.item == null) {}
    label142:
    label327:
    label357:
    label492:
    label502:
    do
    {
      int j;
      int i;
      boolean bool;
      do
      {
        return;
        j = 0;
        if (this.item.activateTriggerTotalCount == 0) {
          break label357;
        }
        i = j;
        if (FaceDetectorManager.getInstance().getCurrentFaceDetector().detectExpression(this.item.preTriggerType))
        {
          i = j;
          if (((FaceActionCounter)paramMap.get(Integer.valueOf(this.item.countTriggerType))).count % this.item.activateTriggerTotalCount == this.item.activateTriggerCount)
          {
            if ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)) {
              break;
            }
            j = 1;
            if (this.playCount >= this.item.playCount) {
              break label327;
            }
            FaceDetectorManager.getInstance().getCurrentFaceDetector().lockActionCounter();
            i = j;
          }
        }
        if (i == 0) {
          break label502;
        }
        bool = false;
        if (!this.triggered)
        {
          this.frameStartTime = paramLong;
          bool = true;
        }
        this.triggered = true;
      } while ((this.item == null) || (TextUtils.isEmpty(this.dataPath)) || (TextUtils.isEmpty(this.item.id)) || (TextUtils.isEmpty(this.item.audio)));
      if ((this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute()))
      {
        paramMap = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
        if (!paramMap.startsWith("assets://")) {
          break label477;
        }
      }
      for (this.mPlayer = AudioUtils.createPlayerFromAssets(VideoGlobalContext.getContext(), paramMap.replace("assets://", ""), false);; this.mPlayer = AudioUtils.createPlayerFromUri(VideoGlobalContext.getContext(), paramMap, false))
      {
        if (!VideoPrefsUtil.getMaterialMute()) {
          break label492;
        }
        AudioUtils.stopPlayer(this.mPlayer);
        return;
        j = 0;
        break;
        i = j;
        if (this.item.playCount <= 0) {
          break label142;
        }
        FaceDetectorManager.getInstance().getCurrentFaceDetector().clearActionCounter();
        i = j;
        break label142;
        if (this.item.isFabbyMvItem)
        {
          if (((FaceActionCounter)paramMap.get(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.FABBY_PART.value))).count % this.item.fabbyTotalParts == this.item.fabbyPart)
          {
            i = 1;
            break label142;
          }
          i = 0;
          break label142;
        }
        if (((FaceDetectorManager.getInstance().getCurrentFaceDetector().detectExpression(this.item.triggerType)) && (VideoFilterUtil.isStatusTriggered(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange))) || (this.mIsRenderForBitmap)) {}
        for (i = 1;; i = 0) {
          break;
        }
      }
      AudioUtils.startPlayer(this.mPlayer, bool);
      return;
    } while ((!this.item.alwaysTriggered) && (this.playCount < this.item.playCount));
    label477:
    this.triggered = false;
    AudioUtils.stopPlayer(this.mPlayer);
  }
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat);
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    FaceRangeStatus localFaceRangeStatus = VideoPreviewFaceOutlineDetector.getInstance().detectFaceRangeStatus(paramList);
    int i = getFrameIndex(localFaceRangeStatus, paramLong);
    updateActionTriggered(paramMap, localFaceRangeStatus, paramLong);
    if (!needRenderTexture())
    {
      clearTextureParam();
      this.playCount = 0;
      this.lastImageIndex = -1;
      ImageMemoryManager.getInstance().reset(this.item.id);
      if (this.mVideoDecoder != null) {
        this.mVideoDecoder.reset();
      }
      return;
    }
    updatePositions(paramList, paramArrayOfFloat, paramFloat);
    updateTextureParam(i, paramLong);
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (paramInt == this.lastImageIndex) {
      return;
    }
    if ((this.lastImageIndex > paramInt) && (this.mVideoDecoder != null)) {
      this.mVideoDecoder.reset();
    }
    addParam(new Param.TextureParam("inputImageTexture2", getNextFrame(paramInt), 33986));
    this.lastImageIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.NormalVideoFilter
 * JD-Core Version:    0.7.0.1
 */