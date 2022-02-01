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
  private static final String TAG = "NightRGBStretchImpFilter";
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
    Object localObject1 = this.mHistogram;
    if (localObject1 != null)
    {
      if (localObject1.length < 256) {
        return;
      }
      float f2 = this.param;
      if (f2 > 0.5D)
      {
        f1 = f2;
        if (f2 > 0.6D) {
          f1 = 0.6F;
        }
        if (f1 > this.recordParam)
        {
          addParam(new UniformParam.FloatParam("param", f1));
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("night filter param = ");
          ((StringBuilder)localObject2).append(f1);
          LogUtils.e((String)localObject1, ((StringBuilder)localObject2).toString());
          this.recordParam = f1;
        }
      }
      int m = 255;
      int k = 0;
      paramInt3 = 0;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt3 < 256)
      {
        localObject1 = this.mHistogram;
        paramInt1 += localObject1[paramInt3];
        paramInt2 += localObject1[paramInt3] * paramInt3;
        paramInt3 += 1;
      }
      if (paramInt1 == 0) {
        return;
      }
      int i1 = paramInt2 / paramInt1;
      float f1 = paramInt1;
      paramInt2 = (int)(0.001F * f1);
      int i2 = (int)(f1 * 0.99F);
      paramInt1 = 0;
      paramInt3 = 0;
      while (paramInt1 < 256)
      {
        paramInt3 += this.mHistogram[paramInt1];
        if (paramInt3 > paramInt2)
        {
          paramInt2 = paramInt1;
          break label245;
        }
        paramInt1 += 1;
      }
      paramInt2 = 0;
      label245:
      int j;
      int n;
      do
      {
        j = paramInt1 + 1;
        paramInt1 = m;
        if (j >= 256) {
          break;
        }
        n = paramInt3 + this.mHistogram[j];
        paramInt1 = j;
        paramInt3 = n;
      } while (n <= i2);
      paramInt1 = j;
      f1 = i1 - paramInt2;
      f2 = paramInt1 - paramInt2;
      f1 /= f2;
      f1 = (float)(Math.log(0.5D) / Math.log(f1));
      double d = f1;
      if (d < 0.1D) {
        f1 = 0.1F;
      }
      if (d > 10.0D) {
        f1 = 10.0F;
      }
      Object localObject2 = new float[256];
      paramInt3 = 0;
      while (paramInt3 < paramInt2)
      {
        localObject2[paramInt3] = 0.0F;
        paramInt3 += 1;
      }
      paramInt3 = paramInt2;
      for (;;)
      {
        j = paramInt1;
        if (paramInt3 >= paramInt1) {
          break;
        }
        localObject2[paramInt3] = ((float)Math.pow((paramInt3 - paramInt2) / f2, f1));
        paramInt3 += 1;
      }
      while (j < 256)
      {
        localObject2[j] = 1.0F;
        j += 1;
      }
      localObject1 = new int[256];
      paramInt1 = 0;
      while (paramInt1 < 256)
      {
        localObject1[paramInt1] = ((int)(localObject2[paramInt1] * 255.0F));
        paramInt1 += 1;
      }
      localObject2 = new byte[localObject1.length * 3];
      paramInt1 = k;
      while (paramInt1 < localObject1.length)
      {
        paramInt2 = paramInt1 * 3;
        int i = (byte)localObject1[paramInt1];
        localObject2[(paramInt2 + 2)] = i;
        localObject2[(paramInt2 + 1)] = i;
        localObject2[paramInt2] = i;
        paramInt1 += 1;
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.paramTEXTRUEID);
      GLES20.glTexImage2D(3553, 0, 6407, localObject1.length, 1, 0, 6407, 5121, ByteBuffer.wrap((byte[])localObject2));
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
    this.mHistogram = paramArrayOfInt;
    this.param = 0.0F;
    if (this.mHistogram == null) {
      return;
    }
    int i = 0;
    int m = 0;
    int k;
    for (int j = 0;; j = k)
    {
      paramArrayOfInt = this.mHistogram;
      if (i >= paramArrayOfInt.length) {
        break;
      }
      m += paramArrayOfInt[i];
      k = j;
      if (i < 80) {
        k = j + paramArrayOfInt[i];
      }
      i += 1;
    }
    if (m == 0) {
      return;
    }
    this.param = (j * 1.0F / m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.NightRGBStretchImpFilter
 * JD-Core Version:    0.7.0.1
 */