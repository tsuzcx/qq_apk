package com.tencent.ttpic.openapi.filter.stylizefilter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import java.util.Map;

public class TTGrayPencilFilter
  extends TTStylizeFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\n \nhighp float mean = 0.92;\nhighp float contrast = 1.5;\nhighp vec3 thre = vec3(0.2,0.34,0.51);\n \nvoid main() {\n    //dodge\n    highp vec4 origin = texture2D(inputImageTexture, textureCoordinate);\n    highp vec4 blend = texture2D(inputImageTexture2, textureCoordinate);\n    highp int targetGray = int((0.299 * origin.r + 0.587 * origin.g + 0.114 * origin.b) * 255.0);\n    highp int blendGray = int((0.299 * blend.r + 0.587 * blend.g + 0.114 * blend.b) * 255.0);\n    blendGray = targetGray * 256 / blendGray;\n    if (blendGray > 250)\n    {\n        blendGray = 255;\n    }\n         \n    highp float value = float(blendGray) / 255.0;\n  \n    //darken\n    highp float darkenEdge = (value - mean) * contrast + mean;\n    \n    //grayPencil\n    highp vec3 edgeVec3 = vec3(darkenEdge,darkenEdge,darkenEdge);\n    highp vec3 material1Vec3 = texture2D(inputImageTexture3, textureCoordinate).rgb;\n    highp vec3 material2Vec3 = texture2D(inputImageTexture4, textureCoordinate).rgb;\n    \n    highp float gray = 0.299 * origin.r + 0.587 * origin.g + 0.114 * origin.b;\n    lowp int count = 0;\n\n    if (gray < thre.x)\n    {\n        edgeVec3 = vec3(edgeVec3.r * edgeVec3.r, edgeVec3.g * edgeVec3.g, edgeVec3.b * edgeVec3.b);\n    }\n\n     if (gray < thre.y)\n     {\n         edgeVec3 = vec3(material1Vec3.r * edgeVec3.r, material1Vec3.g * edgeVec3.g, material1Vec3.b * edgeVec3.b);\n         count += 1;\n     }\n\n     if (gray < thre.z)\n     {\n         edgeVec3 = vec3(material2Vec3.r * edgeVec3.r, material2Vec3.g * edgeVec3.g, material2Vec3.b * edgeVec3.b);\n         count += 1;\n     }\n     \n     if (count > 0) {\n       edgeVec3 = edgeVec3 + gray * (1.0 - edgeVec3);\n     }\n     if (count > 1) {\n       edgeVec3 = edgeVec3 + gray * (1.0 - edgeVec3);\n     }\n      \n     gl_FragColor = vec4(edgeVec3, 1.0);\n     \n}";
  private static final String VERTEX_SHADER = "attribute vec3 position;\n attribute vec2 inputTextureCoordinate;\n\n varying vec2 textureCoordinate;\n\n void main() {\n     gl_Position = vec4(position, 1.0);\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public TTGrayPencilFilter()
  {
    super("attribute vec3 position;\n attribute vec2 inputTextureCoordinate;\n\n varying vec2 textureCoordinate;\n\n void main() {\n     gl_Position = vec4(position, 1.0);\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\n \nhighp float mean = 0.92;\nhighp float contrast = 1.5;\nhighp vec3 thre = vec3(0.2,0.34,0.51);\n \nvoid main() {\n    //dodge\n    highp vec4 origin = texture2D(inputImageTexture, textureCoordinate);\n    highp vec4 blend = texture2D(inputImageTexture2, textureCoordinate);\n    highp int targetGray = int((0.299 * origin.r + 0.587 * origin.g + 0.114 * origin.b) * 255.0);\n    highp int blendGray = int((0.299 * blend.r + 0.587 * blend.g + 0.114 * blend.b) * 255.0);\n    blendGray = targetGray * 256 / blendGray;\n    if (blendGray > 250)\n    {\n        blendGray = 255;\n    }\n         \n    highp float value = float(blendGray) / 255.0;\n  \n    //darken\n    highp float darkenEdge = (value - mean) * contrast + mean;\n    \n    //grayPencil\n    highp vec3 edgeVec3 = vec3(darkenEdge,darkenEdge,darkenEdge);\n    highp vec3 material1Vec3 = texture2D(inputImageTexture3, textureCoordinate).rgb;\n    highp vec3 material2Vec3 = texture2D(inputImageTexture4, textureCoordinate).rgb;\n    \n    highp float gray = 0.299 * origin.r + 0.587 * origin.g + 0.114 * origin.b;\n    lowp int count = 0;\n\n    if (gray < thre.x)\n    {\n        edgeVec3 = vec3(edgeVec3.r * edgeVec3.r, edgeVec3.g * edgeVec3.g, edgeVec3.b * edgeVec3.b);\n    }\n\n     if (gray < thre.y)\n     {\n         edgeVec3 = vec3(material1Vec3.r * edgeVec3.r, material1Vec3.g * edgeVec3.g, material1Vec3.b * edgeVec3.b);\n         count += 1;\n     }\n\n     if (gray < thre.z)\n     {\n         edgeVec3 = vec3(material2Vec3.r * edgeVec3.r, material2Vec3.g * edgeVec3.g, material2Vec3.b * edgeVec3.b);\n         count += 1;\n     }\n     \n     if (count > 0) {\n       edgeVec3 = edgeVec3 + gray * (1.0 - edgeVec3);\n     }\n     if (count > 1) {\n       edgeVec3 = edgeVec3 + gray * (1.0 - edgeVec3);\n     }\n      \n     gl_FragColor = vec4(edgeVec3, 1.0);\n     \n}");
    setTexture2(0);
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void updateMateriaPaths(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0)) {
      return;
    }
    updateBitmapTexture((String)paramMap.get("material1"), "inputImageTexture3", 33987);
    updateBitmapTexture((String)paramMap.get("material2"), "inputImageTexture4", 33988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.TTGrayPencilFilter
 * JD-Core Version:    0.7.0.1
 */