package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticNumFilter
  extends NormalVideoFilter
{
  private Map<String, Point> mBitSizeMap = new HashMap();
  private boolean mIsUnitExists = false;
  private int mLastBitIndex = -1;
  private Map<String, Integer> mLastImageIndexMap = new HashMap();
  private int mNum = -1;
  private UniformParam.TextureBitmapParam mTextureParam;
  
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
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      return;
    }
    if (this.mBitSizeMap.containsKey(paramString)) {}
    int i;
    int j;
    for (paramString = (Point)this.mBitSizeMap.get(paramString);; paramString = new Point(this.item.width, this.item.height))
    {
      d1 = this.item.height;
      i = (int)(paramString.x * 1.0D / paramString.y * d1);
      j = (this.item.width - paramInt2 * i) / 2;
      if (this.width / this.height < 0.75D) {
        break;
      }
      d1 = this.width / 720.0D;
      k = (int)(this.width / 0.75D);
      m = (int)(k * (1.0D - this.item.position[1]));
      paramInt1 = (int)((int)((int)(this.width * this.item.position[0]) + (paramInt2 - paramInt1 - 1) * i * d1) + j * d1);
      paramInt2 = m - (k - this.height) / 2;
      setPositions(AlgoUtils.calPositions(paramInt1, paramInt2, (int)(i * d1) + paramInt1, (int)(paramInt2 - d1 * this.item.height), this.width, this.height));
      return;
    }
    double d1 = this.height / 960.0D;
    int m = (int)(this.height * 0.75D);
    int k = (int)(this.height * (1.0D - this.item.position[1]));
    double d2 = (int)((int)(m * this.item.position[0]) + (paramInt2 - paramInt1 - 1) * i * d1);
    paramInt1 = (int)(j * d1 + d2);
    setPositions(AlgoUtils.calPositions(paramInt1, k, (int)(i * d1) + paramInt1, (int)(k - d1 * this.item.height), this.width, this.height));
  }
  
  private void updateTextureParam(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = new StringBuilder().append(paramString).append("_");
    if (paramInt1 == -1) {}
    int i;
    for (Object localObject1 = "x";; localObject1 = Integer.valueOf(paramInt1))
    {
      localObject1 = localObject1;
      i = getFrameIndex();
      if ((paramInt2 != this.mLastBitIndex) || (!this.mLastImageIndexMap.containsKey(localObject1)) || (i != ((Integer)this.mLastImageIndexMap.get(localObject1)).intValue()) || (this.mTextureParam == null)) {
        break;
      }
      return;
    }
    localObject2 = getNextFrame(paramString, paramInt1, i);
    if ((!BitmapUtils.isLegal((Bitmap)localObject2)) || (!needRenderTexture()))
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
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("texNeedTransform", -1));
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
  }
  
  public boolean isRenderReady()
  {
    return this.mNum >= 0;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (this.mNum < 0) {
      return true;
    }
    int n = getTotalBit(this.mNum);
    updateTextureParam(this.item.id, -1, 0);
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
      updateTextureParam(this.item.id, this.mNum, j);
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
      updateTextureParam(this.item.id, k, j);
      updateNumPosition(this.item.id + "_" + k, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      j += 1;
      k = this.mNum / 10;
      updateTextureParam(this.item.id, k, j);
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
    updateTextureParam(this.item.id, k, j);
    updateNumPosition(this.item.id + "_" + k, j, i);
    OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
    this.mLastBitIndex = j;
    j += 1;
    k = this.mNum / 10 % 10;
    updateTextureParam(this.item.id, k, j);
    updateNumPosition(this.item.id + "_" + k, j, i);
    OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
    this.mLastBitIndex = j;
    j += 1;
    k = this.mNum / 100;
    updateTextureParam(this.item.id, k, j);
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
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat) {}
  
  public void updatePreview(Object paramObject)
  {
    updatePlayer(this.isFirstTriggered);
    if (!needRenderTexture())
    {
      clearTextureParam();
      setNum(-1);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.StaticNumFilter
 * JD-Core Version:    0.7.0.1
 */