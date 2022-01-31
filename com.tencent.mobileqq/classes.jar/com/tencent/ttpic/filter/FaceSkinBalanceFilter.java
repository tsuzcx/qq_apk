package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.model.VideoMaterial.FaceImageLayer;
import java.util.Arrays;
import java.util.List;

public class FaceSkinBalanceFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n \n uniform vec3 diffRGB;\n uniform vec3 userRGB;\n uniform int shouldBalance;\n\n \n void main()\n {\n     vec4 color = texture2D(inputImageTexture, textureCoordinate);\n     if (shouldBalance == 1) {\n         float ry;\n         float ri;\n         float rq;\n         if (color.r <= userRGB.r) {\n             ry = color.r + diffRGB.r * (color.r / userRGB.r);\n         } else {\n             ry = color.r + diffRGB.r * ((1.0 - color.r) / (1.0 - userRGB.r));\n         }\n         if (color.g <= userRGB.g) {\n             ri = color.g + diffRGB.g * (color.g / userRGB.g);\n         } else {\n             ri = color.g + diffRGB.g * ((1.0 - color.g) / (1.0 - userRGB.g));\n         }\n         if (color.b <= userRGB.b) {\n             rq = color.b + diffRGB.b * (color.b / userRGB.b);\n         } else {\n             rq = color.b + diffRGB.b * ((1.0 - color.b) / (1.0 - userRGB.b));\n         }\n         vec3 refineRGB = vec3(ry, ri, rq);\n         gl_FragColor = vec4(clamp(refineRGB, 0.0, 1.0), 1.0);\n     }\n     else {\n         gl_FragColor = color;\n     }\n }";
  private static int count = 0;
  private static int total = 0;
  private byte[] data = null;
  private float modelU = -1.0F;
  private float modelU2 = -1.0F;
  private float modelV = -1.0F;
  private float modelV2 = -1.0F;
  private float modelY = -1.0F;
  private float modelY2 = -1.0F;
  private int shouldBalance = 1;
  
  public FaceSkinBalanceFilter(VideoMaterial.FaceImageLayer paramFaceImageLayer)
  {
    super(" precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n \n uniform vec3 diffRGB;\n uniform vec3 userRGB;\n uniform int shouldBalance;\n\n \n void main()\n {\n     vec4 color = texture2D(inputImageTexture, textureCoordinate);\n     if (shouldBalance == 1) {\n         float ry;\n         float ri;\n         float rq;\n         if (color.r <= userRGB.r) {\n             ry = color.r + diffRGB.r * (color.r / userRGB.r);\n         } else {\n             ry = color.r + diffRGB.r * ((1.0 - color.r) / (1.0 - userRGB.r));\n         }\n         if (color.g <= userRGB.g) {\n             ri = color.g + diffRGB.g * (color.g / userRGB.g);\n         } else {\n             ri = color.g + diffRGB.g * ((1.0 - color.g) / (1.0 - userRGB.g));\n         }\n         if (color.b <= userRGB.b) {\n             rq = color.b + diffRGB.b * (color.b / userRGB.b);\n         } else {\n             rq = color.b + diffRGB.b * ((1.0 - color.b) / (1.0 - userRGB.b));\n         }\n         vec3 refineRGB = vec3(ry, ri, rq);\n         gl_FragColor = vec4(clamp(refineRGB, 0.0, 1.0), 1.0);\n     }\n     else {\n         gl_FragColor = color;\n     }\n }");
    setModelColor(paramFaceImageLayer.imageFaceColor);
    initParam();
  }
  
  private void initParam()
  {
    addParam(new Param.IntParam("shouldBalance", this.shouldBalance));
    addParam(new Param.FloatsParam("diffRGB", new float[] { 0.0F, 0.0F, 0.0F }));
    addParam(new Param.FloatsParam("userRGB", new float[] { this.modelY, this.modelU, this.modelV }));
  }
  
  private boolean isSkinColor(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 80) && (paramInt2 <= 80) && (paramInt3 <= 80)) {}
    float f2;
    float f1;
    do
    {
      do
      {
        return false;
      } while (((paramInt1 < 230) && (paramInt2 < 230) && (paramInt3 < 230) && ((paramInt3 >= paramInt2) || (paramInt2 >= paramInt1))) || (paramInt1 + paramInt2 > 400));
      f2 = paramInt1 / 255.0F;
      float f3 = paramInt2 / 255.0F;
      float f4 = paramInt3 / 255.0F;
      f1 = 128.0F - 81.084999F * f2 + 112.0F * f3 - 30.915001F * f4;
      f2 = 128.0F + 112.0F * f2 - 93.786003F * f3 - 18.214001F * f4;
    } while ((f1 < 85.0F) || (f1 > 135.0F) || (f2 < 260.0F - f1) || (f2 > 280.0F - f1));
    return true;
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((total == 0) || (this.data == null)) {
      return;
    }
    total = 0;
    int i = this.data.length / 4;
    double d5 = 0.0D;
    double d4 = 0.0D;
    double d1 = 0.0D;
    double d6 = 0.0D;
    double d3 = 0.0D;
    double d2 = 0.0D;
    paramInt2 = 0;
    paramInt1 = 0;
    float f1;
    float f2;
    float f3;
    while (paramInt1 < i)
    {
      paramInt3 = this.data[(paramInt1 * 4)] & 0xFF;
      int j = this.data[(paramInt1 * 4 + 1)] & 0xFF;
      int k = this.data[(paramInt1 * 4 + 2)] & 0xFF;
      boolean bool = isSkinColor(paramInt3, j, k);
      f1 = paramInt3 / 255.0F;
      f2 = j / 255.0F;
      f3 = k / 255.0F;
      paramInt3 = paramInt2;
      double d9 = d4;
      d8 = d1;
      d7 = d5;
      if (bool)
      {
        d7 = d5 + f1;
        d9 = d4 + f2;
        d8 = d1 + f3;
        paramInt3 = paramInt2 + 1;
      }
      d6 += f1;
      d3 += f2;
      d2 += f3;
      paramInt1 += 1;
      paramInt2 = paramInt3;
      d4 = d9;
      d1 = d8;
      d5 = d7;
    }
    d6 /= i;
    double d7 = d3 / i;
    double d8 = d2 / i;
    if (paramInt2 == 0)
    {
      d3 = d6;
      d1 = d7;
    }
    for (d2 = d8;; d2 = d4)
    {
      float f6 = this.modelY;
      float f4 = this.modelU;
      float f5 = this.modelV;
      f3 = (float)d6;
      f1 = (float)d7;
      f2 = (float)d8;
      if (d3 > 0.0D)
      {
        f3 = (float)d3;
        f1 = (float)d1;
        f2 = (float)d2;
        f6 = this.modelY2;
        f4 = this.modelU2;
        f5 = this.modelV2;
      }
      float f9 = f4;
      float f8 = f5;
      float f7 = f6;
      if (f6 <= 0.0F)
      {
        f9 = f4;
        f8 = f5;
        f7 = f6;
        if (f4 <= 0.0F)
        {
          f9 = f4;
          f8 = f5;
          f7 = f6;
          if (f5 <= 0.0F)
          {
            f7 = f3;
            f9 = f1;
            f8 = f2;
          }
        }
      }
      addParam(new Param.FloatsParam("diffRGB", new float[] { f7 - f3, f9 - f1, f8 - f2 }));
      addParam(new Param.FloatsParam("userRGB", new float[] { f3, f1, f2 }));
      addParam(new Param.IntParam("shouldBalance", this.shouldBalance));
      return;
      d3 = d5 / paramInt2;
      d2 = d4 / paramInt2;
      d4 = d1 / paramInt2;
      d1 = d2;
    }
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (count < 10) {
      count += 1;
    }
    while (paramArrayOfByte == null) {
      return;
    }
    count = 0;
    this.data = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    total = 1;
  }
  
  public void setModelColor(List<Double> paramList)
  {
    if ((paramList == null) || (paramList.size() < 6))
    {
      this.shouldBalance = 0;
      return;
    }
    this.modelY = ((Double)paramList.get(0)).floatValue();
    this.modelU = ((Double)paramList.get(1)).floatValue();
    this.modelV = ((Double)paramList.get(2)).floatValue();
    this.modelY2 = ((Double)paramList.get(3)).floatValue();
    this.modelU2 = ((Double)paramList.get(4)).floatValue();
    this.modelV2 = ((Double)paramList.get(5)).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceSkinBalanceFilter
 * JD-Core Version:    0.7.0.1
 */