package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Int1sParam;
import com.tencent.filter.BaseFilter;

public class MapFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform int map[256];\n\nvoid main()\n{\n    int index = int(texture2D (inputImageTexture, textureCoordinate).r * 255.0);\n\n    int color = map[index];\n\n    int r = (color >> 24) & 0xff;\n\n    int g = (color >> 16) & 0xff;\n    int b = (color >> 8) & 0xff;\n    int a = color & 0xff;\n    gl_FragColor = vec4(r / 255.0, g / 255.0, b / 255.0, a / 255.0);\n\n}";
  
  public MapFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform int map[256];\n\nvoid main()\n{\n    int index = int(texture2D (inputImageTexture, textureCoordinate).r * 255.0);\n\n    int color = map[index];\n\n    int r = (color >> 24) & 0xff;\n\n    int g = (color >> 16) & 0xff;\n    int b = (color >> 8) & 0xff;\n    int a = color & 0xff;\n    gl_FragColor = vec4(r / 255.0, g / 255.0, b / 255.0, a / 255.0);\n\n}");
    initParam();
  }
  
  public void initParam()
  {
    addParam(new UniformParam.Int1sParam("map", new int[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.MapFilter
 * JD-Core Version:    0.7.0.1
 */