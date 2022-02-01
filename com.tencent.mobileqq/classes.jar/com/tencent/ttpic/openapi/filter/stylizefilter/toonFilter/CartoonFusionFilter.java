package com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter;

import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class CartoonFusionFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " varying highp vec2 textureCoordinate;\n // Origin/Cartoon background stylization filter\n uniform sampler2D inputImageTexture;// 原图（可能加上特殊效果了，如卡通画背景）\n // GAN cartoon output with alpha mask\n uniform sampler2D inputImageTexture2;// 结果图(结果图边缘也可能有透明)\n // Face feather alpha mask\n uniform sampler2D inputImageTexture3; // 羽化图\n uniform int drawMode; \n uniform int segmentMode; \n \n void main()\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate); // 原图（可能加上特殊效果了，如卡通画背景）\n    lowp vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate); // 结果图(结果图边缘也可能有透明)\n    lowp vec4 textureColor3 = texture2D(inputImageTexture3, textureCoordinate); // 羽化图\n    textureColor2.rgb = textureColor2.rgb * textureColor2.a + (1.0 - textureColor2.a) * textureColor.rgb;\n    lowp float alpha = textureColor3.r;\n    gl_FragColor.rgb = textureColor.rgb * (1.0 - alpha) + textureColor2.rgb * alpha;\n    gl_FragColor.a = textureColor.a + textureColor2.a - textureColor.a * textureColor2.a;\n    if (textureColor.a < 0.01){\n        gl_FragColor = textureColor;\n    }\n }";
  private FaceFeatherMaskFilterGroup faceFeatherMaskFilterGroup = new FaceFeatherMaskFilterGroup();
  private boolean isTexLoaded;
  private int[] texture = new int[1];
  
  public CartoonFusionFilter()
  {
    super(" varying highp vec2 textureCoordinate;\n // Origin/Cartoon background stylization filter\n uniform sampler2D inputImageTexture;// 原图（可能加上特殊效果了，如卡通画背景）\n // GAN cartoon output with alpha mask\n uniform sampler2D inputImageTexture2;// 结果图(结果图边缘也可能有透明)\n // Face feather alpha mask\n uniform sampler2D inputImageTexture3; // 羽化图\n uniform int drawMode; \n uniform int segmentMode; \n \n void main()\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate); // 原图（可能加上特殊效果了，如卡通画背景）\n    lowp vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate); // 结果图(结果图边缘也可能有透明)\n    lowp vec4 textureColor3 = texture2D(inputImageTexture3, textureCoordinate); // 羽化图\n    textureColor2.rgb = textureColor2.rgb * textureColor2.a + (1.0 - textureColor2.a) * textureColor.rgb;\n    lowp float alpha = textureColor3.r;\n    gl_FragColor.rgb = textureColor.rgb * (1.0 - alpha) + textureColor2.rgb * alpha;\n    gl_FragColor.a = textureColor.a + textureColor2.a - textureColor.a * textureColor2.a;\n    if (textureColor.a < 0.01){\n        gl_FragColor = textureColor;\n    }\n }");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
    addParam(new UniformParam.IntParam("drawMode", 4));
    addParam(new UniformParam.IntParam("segmentMode", 0));
  }
  
  public void apply()
  {
    super.apply();
    this.faceFeatherMaskFilterGroup.apply();
  }
  
  public void clear()
  {
    super.clear();
    this.faceFeatherMaskFilterGroup.clear();
  }
  
  public void init(String paramString) {}
  
  public Frame render(Frame paramFrame1, Frame paramFrame2, Frame paramFrame3)
  {
    this.faceFeatherMaskFilterGroup.setTextureID(paramFrame3.getTextureId());
    paramFrame3 = this.faceFeatherMaskFilterGroup.render(paramFrame1);
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramFrame2.getTextureId(), 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramFrame3.getTextureId(), 33987));
    paramFrame1 = RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height);
    paramFrame3.clear();
    return paramFrame1;
  }
  
  public Frame renderFeather(Frame paramFrame1, Frame paramFrame2, Frame paramFrame3)
  {
    this.faceFeatherMaskFilterGroup.setTextureID(paramFrame3.getTextureId());
    paramFrame3 = this.faceFeatherMaskFilterGroup.render(paramFrame1);
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramFrame2.getTextureId(), 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramFrame3.getTextureId(), 33987));
    paramFrame1 = RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height);
    paramFrame3.clear();
    return paramFrame1;
  }
  
  public void setSegmentMode(boolean paramBoolean)
  {
    addParam(new UniformParam.IntParam("segmentMode", 1));
  }
  
  public void updateFaceFeatherRadius(int paramInt1, int paramInt2)
  {
    this.faceFeatherMaskFilterGroup.updateRadius(paramInt1, paramInt2);
  }
  
  public void updateFaceFeatherWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.faceFeatherMaskFilterGroup.updateFaceFeatherWidthAndHeight(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter.CartoonFusionFilter
 * JD-Core Version:    0.7.0.1
 */