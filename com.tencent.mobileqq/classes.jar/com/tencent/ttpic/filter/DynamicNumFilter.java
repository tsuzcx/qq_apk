package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.AlgoUtils;
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
  private boolean mIsUnitExists = false;
  private int mLastBitIndex = -1;
  private Map<String, Integer> mLastImageIndexMap = new HashMap();
  private int mNum = -1;
  private PlayerUtil.Player mPlayer;
  protected UniformParam.TextureBitmapParam mTextureParam;
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
      localObject = VideoMemoryManager.getInstance().loadImage(paramString, (String)localObject);
      if (!BitmapUtils.isLegal((Bitmap)localObject)) {
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
      return BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    return BitmapUtils.decodeSampledBitmapFromFile(paramString, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
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
      float f1 = (localPointF.x + ((PointF)localObject).x) / 2.0F;
      float f2 = ((PointF)localObject).y;
      localPointF = new PointF(f1, (((PointF)localObject).y + f2) / 2.0F);
      if (VideoMaterialUtil.isFaceItem(this.item))
      {
        localPointF.x = ((float)(localPointF.x * (1.0D / this.mFaceDetScale)));
        localPointF.y = ((float)(localPointF.y * (1.0D / this.mFaceDetScale)));
      }
      if (!this.mBitSizeMap.containsKey(paramString)) {
        break label773;
      }
      paramString = (Point)this.mBitSizeMap.get(paramString);
      label184:
      double d = this.item.height;
      i = (int)(paramString.x * 1.0D / paramString.y * d);
      int j = (this.item.width - paramInt2 * i) / 2;
      f1 = localPointF.x;
      f2 = this.item.anchorPoint[0];
      float f3 = (paramInt2 - paramInt1 - 1) * i;
      f1 = j + (f1 - f2 + f3);
      f2 = this.height - localPointF.y + this.item.anchorPoint[1];
      setPositions(AlgoUtils.calPositions(f1, f2, i + f1, f2 - this.item.height, this.width, this.height));
      addParam(new UniformParam.Float2fParam("texAnchor", localPointF.x - this.canvasCenter.x, this.canvasCenter.y - localPointF.y));
      this.mAnchor.x = (localPointF.x - this.canvasCenter.x);
      this.mAnchor.y = (this.canvasCenter.y - localPointF.y);
      paramString = new PointF(((PointF)this.mFacePoints.get(this.item.scalePivots[0])).x, ((PointF)this.mFacePoints.get(this.item.scalePivots[0])).y);
      if (VideoMaterialUtil.isFaceItem(this.item))
      {
        paramString.x = ((float)(paramString.x * (1.0D / this.mFaceDetScale)));
        paramString.y = ((float)(paramString.y * (1.0D / this.mFaceDetScale)));
      }
      localPointF = new PointF(((PointF)this.mFacePoints.get(this.item.scalePivots[1])).x, ((PointF)this.mFacePoints.get(this.item.scalePivots[1])).y);
      if (VideoMaterialUtil.isFaceItem(this.item))
      {
        localPointF.x = ((float)(localPointF.x * (1.0D / this.mFaceDetScale)));
        localPointF.y = ((float)(localPointF.y * (1.0D / this.mFaceDetScale)));
      }
      d = Math.pow(paramString.x - localPointF.x, 2.0D);
      addParam(new UniformParam.FloatParam("texScale", (float)(Math.sqrt(Math.pow(paramString.y - localPointF.y, 2.0D) + d) / this.item.scaleFactor)));
      if (this.item.support3D != 1) {
        break label798;
      }
      addParam(new UniformParam.Float3fParam("texRotate", this.mFaceAngles[0], this.mFaceAngles[1], this.mFaceAngles[2] - this.item.angle));
    }
    for (;;)
    {
      addParam(new UniformParam.FloatParam("positionRotate", -this.mAngle));
      return;
      i = this.item.alignFacePoints[1];
      break;
      label773:
      paramString = new Point(this.item.width, this.item.height);
      break label184;
      label798:
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.mFaceAngles[2] - this.item.angle));
    }
  }
  
  private void updateTextureParam(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject2 = new StringBuilder().append(paramString).append("_");
    if (paramInt1 == -1) {}
    int i;
    for (Object localObject1 = "x";; localObject1 = Integer.valueOf(paramInt1))
    {
      localObject1 = localObject1;
      i = (int)((paramLong - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0D));
      if ((i >= this.item.frames * (this.playCount + 1)) && (!VideoPrefsUtil.getMaterialMute()))
      {
        this.playCount += 1;
        PlayerUtil.startPlayer(this.mPlayer, true);
      }
      i %= Math.max(this.item.frames, 1);
      if ((paramInt2 != this.mLastBitIndex) || (!this.mLastImageIndexMap.containsKey(localObject1)) || (i != ((Integer)this.mLastImageIndexMap.get(localObject1)).intValue()) || (this.mTextureParam == null)) {
        break;
      }
      return;
    }
    localObject2 = getNextFrame(paramString, paramInt1, i);
    if ((!BitmapUtils.isLegal((Bitmap)localObject2)) || (needClearTexture()))
    {
      clearTextureParam();
      return;
    }
    if (paramInt1 == -1) {
      this.mIsUnitExists = true;
    }
    if (!this.mBitSizeMap.containsKey(localObject1)) {
      this.mBitSizeMap.put(localObject1, new Point(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()));
    }
    try
    {
      if (this.mTextureParam != null)
      {
        this.mTextureParam.swapTextureBitmap((Bitmap)localObject2);
        this.mTextureParam.setParams(getProgramIds());
      }
      for (;;)
      {
        localObject1 = this.mLastImageIndexMap;
        localObject2 = new StringBuilder().append(paramString).append("_");
        if (paramInt1 != -1) {
          break;
        }
        paramString = "x";
        ((Map)localObject1).put(paramString, Integer.valueOf(i));
        return;
        this.mTextureParam = new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject2, 33986, false);
        this.mTextureParam.initialParams(getProgramIds());
        this.mTextureParam.setParams(getProgramIds());
        addParam(this.mTextureParam);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        LogUtils.e(this, localException.getMessage());
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
    setPositions(GlUtil.EMPTY_POSITIONS);
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
  
  public float getFrameDuration(long paramLong)
  {
    if (!this.triggered) {
      return 0.0F;
    }
    return (float)((paramLong - this.frameStartTime) / 1000.0D);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("texNeedTransform", 1));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("texScale", 1.0F));
    addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean isRenderReady()
  {
    return this.mNum >= 0;
  }
  
  protected boolean needClearTexture()
  {
    return (this.item.getTriggerTypeInt() != PTFaceAttr.PTExpression.ALWAYS.value) && ((!this.triggered) || ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if ((CollectionUtils.isEmpty(this.mFacePoints)) || (this.mFaceAngles == null) || (this.mFaceAngles.length < 3) || (this.mNum < 0)) {
      return true;
    }
    int n = getTotalBit(this.mNum);
    updateTextureParam(this.item.id, -1, this.mTimestamp, 0);
    int i = n;
    if (this.mIsUnitExists)
    {
      i = n + 1;
      updateNumPosition(this.item.id + "_x", 0, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = 0;
    }
    if (this.mNum < 10)
    {
      if (this.mIsUnitExists) {
        j = 1;
      }
      updateTextureParam(this.item.id, this.mNum, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + this.mNum, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      return true;
    }
    if ((10 <= this.mNum) && (this.mNum < 100))
    {
      j = k;
      if (this.mIsUnitExists) {
        j = 1;
      }
      k = this.mNum % 10;
      updateTextureParam(this.item.id, k, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + k, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      j += 1;
      k = this.mNum / 10;
      updateTextureParam(this.item.id, k, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + k, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      return true;
    }
    j = m;
    if (this.mIsUnitExists) {
      j = 1;
    }
    k = this.mNum % 10;
    updateTextureParam(this.item.id, k, this.mTimestamp, j);
    updateNumPosition(this.item.id + "_" + k, j, i);
    OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
    this.mLastBitIndex = j;
    j += 1;
    k = this.mNum / 10 % 10;
    updateTextureParam(this.item.id, k, this.mTimestamp, j);
    updateNumPosition(this.item.id + "_" + k, j, i);
    OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
    this.mLastBitIndex = j;
    j += 1;
    k = this.mNum / 100;
    updateTextureParam(this.item.id, k, this.mTimestamp, j);
    updateNumPosition(this.item.id + "_" + k, j, i);
    OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
    this.mLastBitIndex = j;
    return true;
  }
  
  public void setNum(int paramInt)
  {
    this.mNum = paramInt;
  }
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3))
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
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      updatePlayer(this.isFirstTriggered);
      if (needClearTexture())
      {
        clearTextureParam();
        this.triggered = false;
        this.playCount = 0;
        this.mTimestamp = -1L;
        this.mNum = -1;
      }
    }
    else
    {
      return;
    }
    this.mTimestamp = paramObject.timestamp;
    updatePositions(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.DynamicNumFilter
 * JD-Core Version:    0.7.0.1
 */