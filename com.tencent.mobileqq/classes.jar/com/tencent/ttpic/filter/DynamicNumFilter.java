package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.Float3fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.Mat4Param;
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
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.LogUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicNumFilter
  extends NormalVideoFilter
{
  private static final String TAG = NormalVideoFilter.class.getSimpleName();
  private Point canvasCenter;
  private long frameStartTime;
  private PointF mAnchor = new PointF();
  private float mAngle;
  private Map<String, Point> mBitSizeMap = new HashMap();
  private float[] mFaceAngles;
  private List<PointF> mFacePoints;
  private FaceRangeStatus mFaceStatus;
  private boolean mIsUnitExists = false;
  private int mLastBitIndex = -1;
  private Map<String, Integer> mLastImageIndexMap = new HashMap();
  private int mNum = -1;
  private AudioUtils.Player mPlayer;
  protected Param.TextureBitmapParam mTextureParam;
  private long mTimestamp;
  protected int playCount = 0;
  protected boolean triggered = false;
  
  public DynamicNumFilter(StickerItem paramStickerItem, String paramString)
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
    PointF localPointF = (PointF)this.mFacePoints.get(this.item.alignFacePoints[0]);
    Object localObject = this.mFacePoints;
    int i;
    if (this.item.alignFacePoints.length == 1)
    {
      i = this.item.alignFacePoints[0];
      localObject = (PointF)((List)localObject).get(i);
      localPointF = new PointF((localPointF.x + ((PointF)localObject).x) / 2.0F, (((PointF)localObject).y + ((PointF)localObject).y) / 2.0F);
      localPointF.x = ((float)(localPointF.x * (1.0D / this.mScreenScale)));
      localPointF.y = ((float)(localPointF.y * (1.0D / this.mScreenScale)));
      if (!this.mBitSizeMap.containsKey(paramString)) {
        break label711;
      }
      paramString = (Point)this.mBitSizeMap.get(paramString);
      label166:
      i = (int)(this.item.height * (paramString.x * 1.0D / paramString.y));
      int j = (this.item.width - paramInt2 * i) / 2;
      float f1 = localPointF.x - this.item.anchorPoint[0] + (paramInt2 - paramInt1 - 1) * i + j;
      float f2 = this.height - localPointF.y + this.item.anchorPoint[1];
      setPositions(AlgoUtils.calPositions(f1, f2, f1 + i, f2 - this.item.height, this.width, this.height));
      addParam(new Param.Float2fParam("texAnchor", localPointF.x - this.canvasCenter.x, this.canvasCenter.y - localPointF.y));
      this.mAnchor.x = (localPointF.x - this.canvasCenter.x);
      this.mAnchor.y = (this.canvasCenter.y - localPointF.y);
      paramString = new PointF(((PointF)this.mFacePoints.get(this.item.scalePivots[0])).x, ((PointF)this.mFacePoints.get(this.item.scalePivots[0])).y);
      paramString.x = ((float)(paramString.x * (1.0D / this.mScreenScale)));
      paramString.y = ((float)(paramString.y * (1.0D / this.mScreenScale)));
      localPointF = new PointF(((PointF)this.mFacePoints.get(this.item.scalePivots[1])).x, ((PointF)this.mFacePoints.get(this.item.scalePivots[1])).y);
      localPointF.x = ((float)(localPointF.x * (1.0D / this.mScreenScale)));
      localPointF.y = ((float)(localPointF.y * (1.0D / this.mScreenScale)));
      addParam(new Param.FloatParam("texScale", (float)(Math.sqrt(Math.pow(paramString.x - localPointF.x, 2.0D) + Math.pow(paramString.y - localPointF.y, 2.0D)) / this.item.scaleFactor)));
      if (this.item.support3D != 1) {
        break label736;
      }
      addParam(new Param.Float3fParam("texRotate", this.mFaceAngles[0], this.mFaceAngles[1], this.mFaceAngles[2]));
    }
    for (;;)
    {
      addParam(new Param.FloatParam("positionRotate", -this.mAngle));
      return;
      i = this.item.alignFacePoints[1];
      break;
      label711:
      paramString = new Point(this.item.width, this.item.height);
      break label166;
      label736:
      addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, this.mFaceAngles[2]));
    }
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
    if ((!VideoBitmapUtil.isLegal(paramFaceRangeStatus)) || (needClearTexture()))
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
  
  public void initParams()
  {
    addParam(new Param.IntParam("texNeedTransform", 1));
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new Param.FloatParam("texScale", 1.0F));
    addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new Param.FloatParam("positionRotate", 0.0F));
    addParam(new Param.IntParam("blendMode", this.item.blendMode));
    addParam(new Param.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean isRenderReady()
  {
    return this.mNum >= 0;
  }
  
  protected boolean needClearTexture()
  {
    return (this.item.triggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) && ((!this.triggered) || ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((VideoUtil.isEmpty(this.mFacePoints)) || (this.mFaceAngles == null) || (this.mFaceAngles.length < 3) || (this.mFaceStatus == null) || (this.mNum < 0)) {
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
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  protected void updateActionTriggered(Map<Integer, FaceActionCounter> paramMap, FaceRangeStatus paramFaceRangeStatus, long paramLong)
  {
    if ((this.item != null) && (VideoPreviewFaceOutlineDetector.getInstance().detectExpression(this.item.triggerType)) && (VideoFilterUtil.isStatusTriggered(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange)))
    {
      bool = false;
      if (!this.triggered)
      {
        this.frameStartTime = paramLong;
        bool = true;
      }
      this.triggered = true;
      if ((this.item != null) && (!TextUtils.isEmpty(this.dataPath)) && (!TextUtils.isEmpty(this.item.id)) && (!TextUtils.isEmpty(this.item.audio)))
      {
        if ((this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute()))
        {
          paramMap = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
          if (!paramMap.startsWith("assets://")) {
            break label216;
          }
          this.mPlayer = AudioUtils.createPlayerFromAssets(VideoGlobalContext.getContext(), paramMap.replace("assets://", ""), false);
        }
        if (!VideoPrefsUtil.getMaterialMute()) {
          break label231;
        }
        AudioUtils.stopPlayer(this.mPlayer);
      }
    }
    label216:
    label231:
    while ((this.item == null) || (!this.item.alwaysTriggered))
    {
      boolean bool;
      for (;;)
      {
        return;
        this.mPlayer = AudioUtils.createPlayerFromUri(VideoGlobalContext.getContext(), paramMap, false);
      }
      AudioUtils.startPlayer(this.mPlayer, bool);
      return;
    }
    this.triggered = false;
    AudioUtils.stopPlayer(this.mPlayer);
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((VideoUtil.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3))
    {
      clearTextureParam();
      this.mFacePoints = null;
      this.mFaceAngles = null;
      this.mAngle = 0.0F;
      this.mNum = -1;
      return;
    }
    this.mFacePoints = paramList;
    this.mFaceAngles = paramArrayOfFloat;
    this.mAngle = paramFloat;
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    FaceRangeStatus localFaceRangeStatus = VideoPreviewFaceOutlineDetector.getInstance().detectFaceRangeStatus(paramList);
    updateActionTriggered(paramMap, localFaceRangeStatus, paramLong);
    if (needClearTexture())
    {
      clearTextureParam();
      this.triggered = false;
      this.playCount = 0;
      this.mFaceStatus = null;
      this.mTimestamp = -1L;
      this.mNum = -1;
      return;
    }
    this.mFaceStatus = localFaceRangeStatus;
    this.mTimestamp = paramLong;
    updatePositions(paramList, paramArrayOfFloat, paramFloat);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.DynamicNumFilter
 * JD-Core Version:    0.7.0.1
 */