package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.LogUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticNumFilter
  extends NormalVideoFilter
{
  private boolean initialized = false;
  private Map<String, Point> mBitSizeMap = new HashMap();
  private FaceRangeStatus mFaceStatus;
  private boolean mIsUnitExists = false;
  private int mLastBitIndex = -1;
  private Map<String, Integer> mLastImageIndexMap = new HashMap();
  private int mNum = -1;
  private AudioUtils.Player mPlayer;
  private Param.TextureBitmapParam mTextureParam;
  private long mTimestamp;
  
  public StaticNumFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private Bitmap getNextFrame(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("_").append(paramInt2).append("_");
    if (paramInt1 == -1) {}
    for (Object localObject = "x";; localObject = Integer.valueOf(paramInt1))
    {
      localObject = localObject + ".png";
      localObject = ImageMemoryManager.getInstance().loadImage(paramString, (String)localObject);
      if (!VideoBitmapUtil.isLegal((Bitmap)localObject)) {
        break;
      }
      return localObject;
    }
    return loadFromAssetsOrFile(paramString, paramInt1, paramInt2);
  }
  
  private int getTotalBit(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i > 0)
    {
      i /= 10;
      paramInt += 1;
    }
    return paramInt;
  }
  
  private Bitmap loadFromAssetsOrFile(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.dataPath).append(File.separator).append(paramString).append(File.separator).append(paramString).append("_").append(paramInt2).append("_");
    if (paramInt1 == -1) {}
    for (paramString = "x";; paramString = Integer.valueOf(paramInt1))
    {
      paramString = paramString + ".png";
      if (!this.dataPath.startsWith("assets://")) {
        break;
      }
      return VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    return VideoBitmapUtil.decodeSampledBitmapFromFile(paramString, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
  }
  
  private void updateNumPosition(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      return;
    }
    if (this.mBitSizeMap.containsKey(paramString)) {}
    int i;
    int j;
    for (paramString = (Point)this.mBitSizeMap.get(paramString);; paramString = new Point(this.item.width, this.item.height))
    {
      i = (int)(this.item.height * (paramString.x * 1.0D / paramString.y));
      j = (this.item.width - paramInt2 * i) / 2;
      if (this.width / this.height < 0.75D) {
        break;
      }
      d = this.width / 720.0D;
      k = (int)(this.width / 0.75D);
      m = (int)(k * (1.0D - this.item.position[1]));
      paramInt1 = (int)((int)((int)(this.width * this.item.position[0]) + (paramInt2 - paramInt1 - 1) * i * d) + j * d);
      paramInt2 = m - (k - this.height) / 2;
      setPositions(AlgoUtils.calPositions(paramInt1, paramInt2, (int)(i * d) + paramInt1, (int)(paramInt2 - this.item.height * d), this.width, this.height));
      return;
    }
    double d = this.height / 960.0D;
    int m = (int)(this.height * 0.75D);
    int k = (int)(this.height * (1.0D - this.item.position[1]));
    paramInt1 = (int)((int)((int)(m * this.item.position[0]) + (paramInt2 - paramInt1 - 1) * i * d) + j * d);
    setPositions(AlgoUtils.calPositions(paramInt1, k, (int)(i * d) + paramInt1, (int)(k - this.item.height * d), this.width, this.height));
  }
  
  private void updateTextureParam(String paramString, int paramInt1, FaceRangeStatus paramFaceRangeStatus, long paramLong, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("_");
    if (paramInt1 == -1) {}
    int i;
    for (Object localObject = "x";; localObject = Integer.valueOf(paramInt1))
    {
      localObject = localObject;
      long l = this.frameStartTime;
      i = 0;
      if (this.item.frameType != 0) {
        break;
      }
      i = (int)((paramLong - l) / Math.max(this.item.frameDuration, 1.0D));
      if ((i >= this.item.frames * (this.playCount + 1)) && (!VideoPrefsUtil.getMaterialMute()))
      {
        this.playCount += 1;
        AudioUtils.startPlayer(this.mPlayer, true);
      }
      int j = i % Math.max(this.item.frames, 1);
      i = j;
      if (paramInt2 != this.mLastBitIndex) {
        break label291;
      }
      i = j;
      if (!this.mLastImageIndexMap.containsKey(localObject)) {
        break label291;
      }
      i = j;
      if (j != ((Integer)this.mLastImageIndexMap.get(localObject)).intValue()) {
        break label291;
      }
      i = j;
      if (this.mTextureParam == null) {
        break label291;
      }
      return;
    }
    if (this.item.frameType == 1) {
      i = (int)((VideoFilterUtil.getFaceStatus(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange) - this.item.featureStatValueRange.min) / ((this.item.featureStatValueRange.max - this.item.featureStatValueRange.min) / this.item.frames));
    }
    label291:
    paramFaceRangeStatus = getNextFrame(paramString, paramInt1, i);
    if ((!VideoBitmapUtil.isLegal(paramFaceRangeStatus)) || (!needRenderTexture()))
    {
      clearTextureParam();
      return;
    }
    if (paramInt1 == -1) {
      this.mIsUnitExists = true;
    }
    if (!this.mBitSizeMap.containsKey(localObject)) {
      this.mBitSizeMap.put(localObject, new Point(paramFaceRangeStatus.getWidth(), paramFaceRangeStatus.getHeight()));
    }
    try
    {
      if (this.mTextureParam != null) {
        this.mTextureParam.swapTextureBitmap(paramFaceRangeStatus);
      }
      for (;;)
      {
        paramFaceRangeStatus = this.mLastImageIndexMap;
        localObject = new StringBuilder().append(paramString).append("_");
        if (paramInt1 != -1) {
          break;
        }
        paramString = "x";
        paramFaceRangeStatus.put(paramString, Integer.valueOf(i));
        return;
        this.mTextureParam = new Param.TextureBitmapParam("inputImageTexture2", paramFaceRangeStatus, 33986, false);
        this.mTextureParam.initialParams(getmProgramIds());
        addParam(this.mTextureParam);
        this.initialized = true;
      }
    }
    catch (Exception paramFaceRangeStatus)
    {
      for (;;)
      {
        paramFaceRangeStatus.printStackTrace();
        LogUtil.e(this, paramFaceRangeStatus.getMessage());
        continue;
        paramString = Integer.valueOf(paramInt1);
      }
    }
  }
  
  public void clearTextureParam()
  {
    if (this.mTextureParam != null)
    {
      this.mTextureParam.clear();
      this.mTextureParam = null;
    }
    setPositions(VideoFilterUtil.EMPTY_POSITIONS);
  }
  
  public void initParams()
  {
    addParam(new Param.IntParam("texNeedTransform", -1));
    addParam(new Param.IntParam("blendMode", this.item.blendMode));
  }
  
  public boolean isRenderReady()
  {
    return this.mNum >= 0;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNum < 0) {
      return true;
    }
    int j = getTotalBit(this.mNum);
    updateTextureParam(this.item.id, -1, this.mFaceStatus, this.mTimestamp, 0);
    int i = j;
    if (this.mIsUnitExists)
    {
      i = j + 1;
      updateNumPosition(this.item.id + "_x", 0, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = 0;
    }
    if (this.mNum < 10)
    {
      if (this.mIsUnitExists) {}
      for (j = 1;; j = 0)
      {
        updateTextureParam(this.item.id, this.mNum, this.mFaceStatus, this.mTimestamp, j);
        updateNumPosition(this.item.id + "_" + this.mNum, j, i);
        OnDrawFrameGLSL();
        super.renderTexture(paramInt1, paramInt2, paramInt3);
        this.mLastBitIndex = j;
        return true;
      }
    }
    int k;
    if ((10 <= this.mNum) && (this.mNum < 100))
    {
      if (this.mIsUnitExists) {}
      for (j = 1;; j = 0)
      {
        k = this.mNum % 10;
        updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
        updateNumPosition(this.item.id + "_" + k, j, i);
        OnDrawFrameGLSL();
        super.renderTexture(paramInt1, paramInt2, paramInt3);
        this.mLastBitIndex = j;
        j += 1;
        k = this.mNum / 10;
        updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
        updateNumPosition(this.item.id + "_" + k, j, i);
        OnDrawFrameGLSL();
        super.renderTexture(paramInt1, paramInt2, paramInt3);
        this.mLastBitIndex = j;
        break;
      }
    }
    if (this.mIsUnitExists) {}
    for (j = 1;; j = 0)
    {
      k = this.mNum % 10;
      updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + k, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      j += 1;
      k = this.mNum / 10 % 10;
      updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + k, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      j += 1;
      k = this.mNum / 100;
      updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + k, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      break;
    }
  }
  
  public void setNum(int paramInt)
  {
    this.mNum = paramInt;
    LogUtil.e("qhz", "mNum = " + this.mNum);
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat) {}
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    updateActionTriggered(paramMap, VideoPreviewFaceOutlineDetector.getInstance().detectFaceRangeStatus(paramList), paramLong);
    if (!needRenderTexture())
    {
      clearTextureParam();
      this.triggered = false;
      this.playCount = 0;
      setNum(-1);
      this.mTimestamp = -1L;
      return;
    }
    this.mTimestamp = paramLong;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.StaticNumFilter
 * JD-Core Version:    0.7.0.1
 */