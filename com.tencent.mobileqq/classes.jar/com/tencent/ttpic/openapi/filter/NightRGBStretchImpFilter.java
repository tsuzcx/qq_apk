package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.view.RendererUtils;
import java.nio.ByteBuffer;

public class NightRGBStretchImpFilter
  extends BaseFilter
{
  public static final String RGB_STRETCH_FRAGMENT = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform float param;\nuniform float scale;\nuniform float alpha;\nvoid main()\n{\nvec4 color_origin = texture2D(inputImageTexture,textureCoordinate);\nvec4 color_raw = vec4(color_origin.r, color_origin.g, color_origin.b, color_origin.a);\ncolor_raw.r = texture2D(inputImageTexture3, vec2(color_raw.r,0.0)).r;\ncolor_raw.g = texture2D(inputImageTexture3, vec2(color_raw.g,0.0)).g;\ncolor_raw.b = texture2D(inputImageTexture3, vec2(color_raw.b,0.0)).b;\ncolor_raw = color_raw + color_raw - color_raw * color_raw;\ncolor_raw = color_origin + (param - 0.5) *scale* (color_raw - color_origin);\ncolor_raw.a = 1.0;\ngl_FragColor = mix(color_origin, color_raw, alpha);\n}";
  private static final String TAG = NightRGBStretchImpFilter.class.getSimpleName();
  private int[] mHistogram;
  private float param;
  private int paramTEXTRUEID = 0;
  private float recordParam = 0.5F;
  
  public NightRGBStretchImpFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform float param;\nuniform float scale;\nuniform float alpha;\nvoid main()\n{\nvec4 color_origin = texture2D(inputImageTexture,textureCoordinate);\nvec4 color_raw = vec4(color_origin.r, color_origin.g, color_origin.b, color_origin.a);\ncolor_raw.r = texture2D(inputImageTexture3, vec2(color_raw.r,0.0)).r;\ncolor_raw.g = texture2D(inputImageTexture3, vec2(color_raw.g,0.0)).g;\ncolor_raw.b = texture2D(inputImageTexture3, vec2(color_raw.b,0.0)).b;\ncolor_raw = color_raw + color_raw - color_raw * color_raw;\ncolor_raw = color_origin + (param - 0.5) *scale* (color_raw - color_origin);\ncolor_raw.a = 1.0;\ngl_FragColor = mix(color_origin, color_raw, alpha);\n}");
    initParams();
  }
  
  private void initParams()
  {
    this.param = 0.0F;
    addParam(new UniformParam.FloatParam("param", 0.5F));
    addParam(new UniformParam.FloatParam("scale", 2.0F));
    addParam(new UniformParam.FloatParam("alpha", 1.0F));
  }
  
  public void apply()
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    super.apply();
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mHistogram == null) || (this.mHistogram.length < 256)) {}
    float f2;
    float f1;
    int k;
    do
    {
      return;
      if (this.param > 0.5D)
      {
        f2 = this.param;
        f1 = f2;
        if (f2 > 0.6D) {
          f1 = 0.6F;
        }
        if (f1 > this.recordParam)
        {
          addParam(new UniformParam.FloatParam("param", f1));
          LogUtils.e(TAG, "night filter param = " + f1);
          this.recordParam = f1;
        }
      }
      paramInt2 = 0;
      paramInt1 = 0;
      k = 0;
      paramInt3 = 0;
      while (paramInt3 < 256)
      {
        paramInt1 += this.mHistogram[paramInt3];
        paramInt2 += this.mHistogram[paramInt3] * paramInt3;
        paramInt3 += 1;
      }
    } while (paramInt1 == 0);
    int m = paramInt2 / paramInt1;
    int i1 = (int)(paramInt1 * 0.001F);
    int n = (int)(paramInt1 * 0.99F);
    paramInt3 = 0;
    paramInt2 = 0;
    int j = paramInt3;
    paramInt1 = k;
    if (paramInt2 < 256)
    {
      paramInt3 += this.mHistogram[paramInt2];
      if (paramInt3 > i1)
      {
        paramInt1 = paramInt2;
        j = paramInt3;
      }
    }
    else
    {
      paramInt2 += 1;
      paramInt3 = j;
      label225:
      if (paramInt2 >= 256) {
        break label548;
      }
      paramInt3 += this.mHistogram[paramInt2];
      if (paramInt3 <= n) {
        break label336;
      }
    }
    for (;;)
    {
      f1 = (m - paramInt1) / (paramInt2 - paramInt1);
      f2 = (float)(Math.log(0.5D) / Math.log(f1));
      if (f2 < 0.1D) {}
      for (f1 = 0.1F;; f1 = f2)
      {
        if (f2 > 10.0D) {
          f1 = 10.0F;
        }
        Object localObject = new float[256];
        paramInt3 = 0;
        for (;;)
        {
          if (paramInt3 < paramInt1)
          {
            localObject[paramInt3] = 0.0F;
            paramInt3 += 1;
            continue;
            paramInt2 += 1;
            break;
            label336:
            paramInt2 += 1;
            break label225;
          }
        }
        paramInt3 = paramInt1;
        for (;;)
        {
          j = paramInt2;
          if (paramInt3 >= paramInt2) {
            break;
          }
          localObject[paramInt3] = ((float)Math.pow((paramInt3 - paramInt1) / (paramInt2 - paramInt1), f1));
          paramInt3 += 1;
        }
        while (j < 256)
        {
          localObject[j] = 1.0F;
          j += 1;
        }
        int[] arrayOfInt = new int[256];
        paramInt1 = 0;
        while (paramInt1 < 256)
        {
          arrayOfInt[paramInt1] = ((int)(localObject[paramInt1] * 255.0F));
          paramInt1 += 1;
        }
        localObject = new byte[arrayOfInt.length * 3];
        paramInt1 = 0;
        while (paramInt1 < arrayOfInt.length)
        {
          int i = (byte)arrayOfInt[paramInt1];
          localObject[(paramInt1 * 3 + 2)] = i;
          localObject[(paramInt1 * 3 + 1)] = i;
          localObject[(paramInt1 * 3)] = i;
          paramInt1 += 1;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.paramTEXTRUEID);
        GLES20.glTexImage2D(3553, 0, 6407, arrayOfInt.length, 1, 0, 6407, 5121, ByteBuffer.wrap((byte[])localObject));
        return;
      }
      label548:
      paramInt2 = 255;
    }
  }
  
  public void clearGLSL()
  {
    RendererUtils.clearTexture(this.paramTEXTRUEID);
    super.clearGLSL();
  }
  
  public boolean needRender()
  {
    return this.param > 0.5D;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setTextureParam(this.paramTEXTRUEID, 1);
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void reset()
  {
    this.recordParam = 0.5F;
  }
  
  public void setAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
  
  public void setHistogram(int[] paramArrayOfInt)
  {
    int i = 0;
    this.mHistogram = paramArrayOfInt;
    this.param = 0.0F;
    if (this.mHistogram == null) {}
    int j;
    int k;
    do
    {
      return;
      j = 0;
      int m;
      for (k = 0; i < this.mHistogram.length; k = m)
      {
        m = k + this.mHistogram[i];
        k = j;
        if (i < 80) {
          k = j + this.mHistogram[i];
        }
        i += 1;
        j = k;
      }
    } while (k == 0);
    this.param = (j * 1.0F / k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.NightRGBStretchImpFilter
 * JD-Core Version:    0.7.0.1
 */