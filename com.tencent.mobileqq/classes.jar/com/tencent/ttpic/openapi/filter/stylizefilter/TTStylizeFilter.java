package com.tencent.ttpic.openapi.filter.stylizefilter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.util.Map;

public class TTStylizeFilter
  extends VideoFilterBase
  implements IStlylizeFilterIniter
{
  public TTStylizeFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    updateWidthHeightParam(0.0F, 0.0F);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    updateWidthHeightParam(1.0F / paramFrame.width, 1.0F / paramFrame.height);
    return super.RenderProcess(paramFrame);
  }
  
  public void apply()
  {
    if (!this.mIsApplied) {
      super.apply();
    }
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    clearGLSLSelf();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.mIsApplied = false;
  }
  
  protected Bitmap getBitmap(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {
      return BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 2147483647, 2147483647);
    }
    return BitmapUtils.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647);
  }
  
  protected void updateBitmapTexture(String paramString1, String paramString2, int paramInt)
  {
    updateBitmapTexture(paramString1, paramString2, paramInt, true);
  }
  
  protected void updateBitmapTexture(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = getBitmap(paramString1);
    if (!BitmapUtils.isLegal(paramString1)) {
      return;
    }
    addParam(new UniformParam.TextureBitmapParam(paramString2, paramString1, paramInt, paramBoolean));
  }
  
  public void updateLutPaths(Map<String, String> paramMap) {}
  
  public void updateMateriaPaths(Map<String, String> paramMap) {}
  
  public void updateThresholdValue(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void updateWidthHeightParam(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", paramFloat1));
    addParam(new UniformParam.FloatParam("texelHeightOffset", paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.TTStylizeFilter
 * JD-Core Version:    0.7.0.1
 */