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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    if (paramInt1 == -1) {
      localObject = "x";
    } else {
      localObject = Integer.valueOf(paramInt1);
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(".png");
    Object localObject = localStringBuilder.toString();
    localObject = VideoMemoryManager.getInstance().loadImage(paramString, (String)localObject);
    if (BitmapUtils.isLegal((Bitmap)localObject)) {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.dataPath);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    if (paramInt1 == -1) {
      paramString = "x";
    } else {
      paramString = Integer.valueOf(paramInt1);
    }
    localStringBuilder.append(paramString);
    localStringBuilder.append(".png");
    paramString = localStringBuilder.toString();
    if (this.dataPath.startsWith("assets://")) {
      return BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    return BitmapUtils.decodeSampledBitmapFromFile(paramString, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
  }
  
  private void updateNumPosition(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.item != null) && (this.item.position != null) && (this.item.position.length >= 2))
    {
      if (this.mBitSizeMap.containsKey(paramString)) {
        paramString = (Point)this.mBitSizeMap.get(paramString);
      } else {
        paramString = new Point(this.item.width, this.item.height);
      }
      double d1 = this.item.height;
      double d2 = paramString.x;
      Double.isNaN(d2);
      double d3 = paramString.y;
      Double.isNaN(d3);
      d2 = d2 * 1.0D / d3;
      Double.isNaN(d1);
      int i = (int)(d1 * d2);
      int j = (this.item.width - paramInt2 * i) / 2;
      d1 = this.width;
      d2 = this.height;
      Double.isNaN(d1);
      Double.isNaN(d2);
      if (d1 / d2 >= 0.75D)
      {
        d1 = this.width;
        Double.isNaN(d1);
        d1 /= 720.0D;
        d2 = this.width;
        Double.isNaN(d2);
        k = (int)(d2 / 0.75D);
        d2 = k;
        d3 = this.item.position[1];
        Double.isNaN(d2);
        m = (int)(d2 * (1.0D - d3));
        d2 = this.width;
        d3 = this.item.position[0];
        Double.isNaN(d2);
        d2 = (int)(d2 * d3);
        d3 = (paramInt2 - paramInt1 - 1) * i;
        Double.isNaN(d3);
        Double.isNaN(d2);
        d2 = (int)(d2 + d3 * d1);
        d3 = j;
        Double.isNaN(d3);
        Double.isNaN(d2);
        paramInt1 = (int)(d2 + d3 * d1);
        paramInt2 = m - (k - this.height) / 2;
        f1 = paramInt1;
        f2 = paramInt2;
        d2 = i;
        Double.isNaN(d2);
        f3 = paramInt1 + (int)(d2 * d1);
        d2 = paramInt2;
        d3 = this.item.height;
        Double.isNaN(d3);
        Double.isNaN(d2);
        setPositions(AlgoUtils.calPositions(f1, f2, f3, (int)(d2 - d3 * d1), this.width, this.height));
        return;
      }
      d1 = this.height;
      Double.isNaN(d1);
      d1 /= 960.0D;
      d2 = this.height;
      Double.isNaN(d2);
      int m = (int)(d2 * 0.75D);
      d2 = this.height;
      d3 = this.item.position[1];
      Double.isNaN(d2);
      int k = (int)(d2 * (1.0D - d3));
      d2 = m;
      d3 = this.item.position[0];
      Double.isNaN(d2);
      d2 = (int)(d2 * d3);
      d3 = (paramInt2 - paramInt1 - 1) * i;
      Double.isNaN(d3);
      Double.isNaN(d2);
      d2 = (int)(d2 + d3 * d1);
      d3 = j;
      Double.isNaN(d3);
      Double.isNaN(d2);
      paramInt1 = (int)(d2 + d3 * d1);
      float f1 = paramInt1;
      float f2 = k;
      d2 = i;
      Double.isNaN(d2);
      float f3 = paramInt1 + (int)(d2 * d1);
      d2 = k;
      d3 = this.item.height;
      Double.isNaN(d3);
      Double.isNaN(d2);
      setPositions(AlgoUtils.calPositions(f1, f2, f3, (int)(d2 - d3 * d1), this.width, this.height));
      return;
    }
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
  
  private void updateTextureParam(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    String str = "x";
    if (paramInt1 == -1) {
      localObject1 = "x";
    } else {
      localObject1 = Integer.valueOf(paramInt1);
    }
    ((StringBuilder)localObject2).append(localObject1);
    Object localObject1 = ((StringBuilder)localObject2).toString();
    int i = getFrameIndex();
    if ((paramInt2 == this.mLastBitIndex) && (this.mLastImageIndexMap.containsKey(localObject1)) && (i == ((Integer)this.mLastImageIndexMap.get(localObject1)).intValue()) && (this.mTextureParam != null)) {
      return;
    }
    localObject2 = getNextFrame(paramString, paramInt1, i);
    if ((BitmapUtils.isLegal((Bitmap)localObject2)) && (needRenderTexture()))
    {
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
        else
        {
          this.mTextureParam = new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject2, 33986, false);
          this.mTextureParam.initialParams(getProgramIds());
          this.mTextureParam.setParams(getProgramIds());
          addParam(this.mTextureParam);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        LogUtils.e(this, localException.getMessage());
      }
      Map localMap = this.mLastImageIndexMap;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("_");
      if (paramInt1 == -1) {
        paramString = str;
      } else {
        paramString = Integer.valueOf(paramInt1);
      }
      ((StringBuilder)localObject2).append(paramString);
      localMap.put(((StringBuilder)localObject2).toString(), Integer.valueOf(i));
      return;
    }
    clearTextureParam();
  }
  
  public void clearTextureParam()
  {
    UniformParam.TextureBitmapParam localTextureBitmapParam = this.mTextureParam;
    if (localTextureBitmapParam != null)
    {
      localTextureBitmapParam.clear();
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.StaticNumFilter
 * JD-Core Version:    0.7.0.1
 */