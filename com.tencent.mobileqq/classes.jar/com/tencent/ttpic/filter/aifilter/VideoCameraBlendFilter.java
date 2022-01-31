package com.tencent.ttpic.filter.aifilter;

import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.util.AlgoUtils;

public class VideoCameraBlendFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\n\n vec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n     //revert pre multiply\n     if(texColor.a > 0.0){\n        texColor.rgb = texColor.rgb / texColor.a;\n     }\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n     resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0); \n     return resultColor;\n }\n\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, textureCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate2);\n\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = position.xy * 0.5 + 0.5;\n    textureCoordinate2 = inputTextureCoordinate.xy;\n}\n";
  private float bottomX = -1.0F;
  private float bottomY = -1.0F;
  private BaseFilter copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private float picRatio = -1.0F;
  private float random1 = 0.0F;
  private float random2 = 0.0F;
  private float randomHeight = -1.0F;
  private int rotateType = -1;
  private float topX = -1.0F;
  private float topY = -1.0F;
  
  public VideoCameraBlendFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = position.xy * 0.5 + 0.5;\n    textureCoordinate2 = inputTextureCoordinate.xy;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\n\n vec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n     //revert pre multiply\n     if(texColor.a > 0.0){\n        texColor.rgb = texColor.rgb / texColor.a;\n     }\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n     resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0); \n     return resultColor;\n }\n\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, textureCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate2);\n\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n");
  }
  
  private boolean needRotate(int paramInt1, int paramInt2)
  {
    if (this.rotateType >= 0) {
      if (this.rotateType == 1) {
        if (paramInt1 * 1.05D >= paramInt2) {}
      }
    }
    do
    {
      return true;
      return false;
      return false;
      if (((this.randomHeight <= 0.0F) || (this.picRatio <= 0.0F)) && ((this.topX < 0.0F) || (this.topY < 0.0F) || (this.bottomX < 0.0F) || (this.bottomY < 0.0F))) {
        break;
      }
    } while (paramInt1 * 1.05D < paramInt2);
    return false;
    return false;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.copyFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    float[] arrayOfFloat;
    float f1;
    float f2;
    if ((this.randomHeight > 0.0F) && (this.picRatio > 0.0F))
    {
      arrayOfFloat = new float[5];
      if (!needRotate(paramInt2, paramInt3))
      {
        f1 = this.randomHeight;
        f2 = this.picRatio * f1 * paramInt3 / paramInt2;
        arrayOfFloat[0] = ((float)Math.min(Math.max(this.random1 * (1.0D - f2), 0.0D), 1.0D - f2));
        arrayOfFloat[1] = ((float)Math.min(Math.max(this.random2 * (1.0D - f1), 0.0D), 1.0D - f1));
        arrayOfFloat[2] = arrayOfFloat[0];
        arrayOfFloat[3] = (arrayOfFloat[1] + this.randomHeight);
        arrayOfFloat[4] = this.picRatio;
        setTop(arrayOfFloat[0], arrayOfFloat[1]);
        setBottom(arrayOfFloat[2], arrayOfFloat[3]);
        setPicRatio(arrayOfFloat[4]);
      }
    }
    else if ((this.topX >= 0.0F) && (this.topY >= 0.0F) && (this.bottomX >= 0.0F) && (this.bottomY >= 0.0F) && (paramInt2 > 0) && (paramInt3 > 0))
    {
      if (needRotate(paramInt2, paramInt3)) {
        break label482;
      }
      f1 = this.bottomY - this.topY;
      f2 = this.picRatio * f1 * paramInt3 / paramInt2;
      if (this.topX < 0.0F) {
        this.topX = 0.0F;
      }
      if (this.topX + f2 > 1.0F) {
        this.topX = (1.0F - f2);
      }
      if (this.topY < 0.0F)
      {
        this.topY = 0.0F;
        this.bottomY = f1;
      }
      if (this.bottomY > 1.0F)
      {
        this.bottomY = 1.0F;
        this.topY = (this.bottomY - f1);
      }
      setPositions(AlgoUtils.calPositions(this.topX, this.bottomY, f2 + this.topX, this.topY, 1, 1));
      setTexCords(GlUtil.ORIGIN_TEX_COORDS);
    }
    for (;;)
    {
      super.beforeRender(paramInt1, paramInt2, paramInt3);
      return;
      f1 = this.randomHeight;
      f2 = this.picRatio * f1 * paramInt2 / paramInt3;
      arrayOfFloat[0] = ((float)Math.min(Math.max(this.random1 * (1.0D - f2), 0.0D), 1.0D - f2));
      arrayOfFloat[1] = ((float)Math.min(Math.max(this.random2 * (1.0D - f1), 0.0D), 1.0D - f1));
      arrayOfFloat[2] = arrayOfFloat[0];
      arrayOfFloat[3] = (arrayOfFloat[1] + this.randomHeight);
      arrayOfFloat[4] = this.picRatio;
      break;
      label482:
      f1 = this.bottomY - this.topY;
      f2 = this.picRatio * f1 * paramInt2 / paramInt3;
      if (1.0F - this.bottomY < 0.0F)
      {
        this.bottomY = 1.0F;
        this.topY = (this.bottomY - f1);
      }
      if (1.0F - this.topY > 1.0F)
      {
        this.topY = 0.0F;
        this.bottomY = f1;
      }
      if (this.topX + f2 > 1.0F) {
        this.topX = (1.0F - f2);
      }
      if (this.topX < 0.0F) {
        this.topX = 0.0F;
      }
      setPositions(AlgoUtils.calPositions(1.0F - this.bottomY, f2 + this.topX, 1.0F - this.topY, this.topX, 1, 1));
      setTexCords(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.topX >= 0.0F) && (this.topY >= 0.0F) && (this.bottomX >= 0.0F) && (this.bottomY >= 0.0F) && (paramInt2 > 0) && (paramInt3 > 0))
    {
      this.copyFilter.OnDrawFrameGLSL();
      this.copyFilter.renderTexture(paramInt1, paramInt2, paramInt3);
    }
    OnDrawFrameGLSL();
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void setBottom(float paramFloat1, float paramFloat2)
  {
    this.bottomX = paramFloat1;
    this.bottomY = paramFloat2;
  }
  
  public void setPicRatio(float paramFloat)
  {
    this.picRatio = paramFloat;
  }
  
  public void setRandomHeight(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.randomHeight = paramFloat1;
    this.random1 = paramFloat2;
    this.random2 = paramFloat3;
  }
  
  public void setRotateType(int paramInt)
  {
    this.rotateType = paramInt;
  }
  
  public void setTop(float paramFloat1, float paramFloat2)
  {
    this.topX = paramFloat1;
    this.topY = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.VideoCameraBlendFilter
 * JD-Core Version:    0.7.0.1
 */