package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.util.FeatureUtils;

public class FadeFilter
  extends GPUImageLookupFilter
{
  private float mAlpha = 1.0F;
  
  public FadeFilter()
  {
    Bitmap localBitmap = FeatureUtils.getEncryptedBitmap("assets://raw/sh/", FeatureManager.getResourceDir(), "fade_effect.png");
    if (BitmapUtils.isLegal(localBitmap)) {
      addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
    }
    addParam(new UniformParam.FloatParam("alpha", this.mAlpha));
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.mAlpha == 1.0F) {
      return paramFrame;
    }
    return super.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlpha = (1.0F - paramFloat);
    addParam(new UniformParam.FloatParam("alpha", this.mAlpha));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FadeFilter
 * JD-Core Version:    0.7.0.1
 */