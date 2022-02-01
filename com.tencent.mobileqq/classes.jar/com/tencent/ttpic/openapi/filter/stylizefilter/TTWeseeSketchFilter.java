package com.tencent.ttpic.openapi.filter.stylizefilter;

import java.util.Map;

public class TTWeseeSketchFilter
  extends TTStylizeFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform sampler2D inputImageTextureMaterial1;\nuniform sampler2D inputImageTextureMaterial2;\n\nvec4 lut(vec4 textureColor) {\n    highp float blueColor = textureColor.b * 63.0;\n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    lowp vec4 newColor1 = texture2D(inputImageTextureLUT, texPos1);\n    lowp vec4 newColor2 = texture2D(inputImageTextureLUT, texPos2);\n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    return newColor;\n}\n\nvoid main()\n{\n  vec4 originColor = texture2D(inputImageTexture, textureCoordinate);\n  //revert\n  vec4 revertColor = vec4(1.0 - originColor.r, 1.0 - originColor.g, 1.0 - originColor.b, 1.0);\n  \n  //minimumFilterOpenCV\n  for (int i = -2; i <= 2; i++) {\n    for (int j = -2; j <= 2; j++) {\n      vec2 fIdx = textureCoordinate + vec2(texelWidthOffset * float(i), texelHeightOffset * float(j));\n      vec4 near = texture2D(inputImageTexture, fIdx);\n      near = vec4(1.0 - near.r, 1.0 - near.g, 1.0 - near.b, 1.0);\n      revertColor = min(revertColor, near);\n    }\n  }\n  \n  //Dodge\n  vec4 dodge = originColor / (1.0 - revertColor);\n  \n  //40% alpha\n  vec4 alpha1 = mix(originColor, dodge, 0.4);\n  \n  //60% alpha\n  vec4 alpha2 = mix(originColor, alpha1, 0.6);\n  \n  //LUT\n  vec4 lutColor = lut(alpha2);\n  \n  //material1 multiply\n  vec4 material1 = texture2D(inputImageTextureMaterial1, textureCoordinate);\n  vec3 m1Res = material1.rgb * lutColor.rgb + lutColor.rgb * (1.0 - material1.a);\n  \n  //material2 alpha\n    vec4 material2 = texture2D(inputImageTextureMaterial2, textureCoordinate);\n    vec3 m2Res = mix(m1Res, vec3(1.0,1.0,1.0), material2.a);\n  \n  gl_FragColor = vec4(m2Res.r, m2Res.g, m2Res.b, 1.0);\n  \n}";
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n  gl_Position = position;\n  textureCoordinate = inputTextureCoordinate;\n}";
  
  public TTWeseeSketchFilter()
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n  gl_Position = position;\n  textureCoordinate = inputTextureCoordinate;\n}", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform sampler2D inputImageTextureMaterial1;\nuniform sampler2D inputImageTextureMaterial2;\n\nvec4 lut(vec4 textureColor) {\n    highp float blueColor = textureColor.b * 63.0;\n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    lowp vec4 newColor1 = texture2D(inputImageTextureLUT, texPos1);\n    lowp vec4 newColor2 = texture2D(inputImageTextureLUT, texPos2);\n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    return newColor;\n}\n\nvoid main()\n{\n  vec4 originColor = texture2D(inputImageTexture, textureCoordinate);\n  //revert\n  vec4 revertColor = vec4(1.0 - originColor.r, 1.0 - originColor.g, 1.0 - originColor.b, 1.0);\n  \n  //minimumFilterOpenCV\n  for (int i = -2; i <= 2; i++) {\n    for (int j = -2; j <= 2; j++) {\n      vec2 fIdx = textureCoordinate + vec2(texelWidthOffset * float(i), texelHeightOffset * float(j));\n      vec4 near = texture2D(inputImageTexture, fIdx);\n      near = vec4(1.0 - near.r, 1.0 - near.g, 1.0 - near.b, 1.0);\n      revertColor = min(revertColor, near);\n    }\n  }\n  \n  //Dodge\n  vec4 dodge = originColor / (1.0 - revertColor);\n  \n  //40% alpha\n  vec4 alpha1 = mix(originColor, dodge, 0.4);\n  \n  //60% alpha\n  vec4 alpha2 = mix(originColor, alpha1, 0.6);\n  \n  //LUT\n  vec4 lutColor = lut(alpha2);\n  \n  //material1 multiply\n  vec4 material1 = texture2D(inputImageTextureMaterial1, textureCoordinate);\n  vec3 m1Res = material1.rgb * lutColor.rgb + lutColor.rgb * (1.0 - material1.a);\n  \n  //material2 alpha\n    vec4 material2 = texture2D(inputImageTextureMaterial2, textureCoordinate);\n    vec3 m2Res = mix(m1Res, vec3(1.0,1.0,1.0), material2.a);\n  \n  gl_FragColor = vec4(m2Res.r, m2Res.g, m2Res.b, 1.0);\n  \n}");
  }
  
  public void updateLutPaths(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      updateBitmapTexture((String)paramMap.get("lut1"), "inputImageTextureLUT", 33986);
    }
  }
  
  public void updateMateriaPaths(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      updateBitmapTexture((String)paramMap.get("material1"), "inputImageTextureMaterial1", 33987);
      updateBitmapTexture((String)paramMap.get("material2"), "inputImageTextureMaterial2", 33988);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.TTWeseeSketchFilter
 * JD-Core Version:    0.7.0.1
 */