package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;

public class ExpFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() {\n   vec2 c = vec2(textureCoordinate.x * 16.0 / 15.0, textureCoordinate.y * 24.0 / 23.0); \n   if (c.x > 1.0) { \n       c.x = 1.0; \n   } \n   if (c.y > 1.0) { \n       c.y = 1.0; \n   } \n   float value = texture2D(inputImageTexture, c).r; \n   float diff = exp(value * 100.0 - 50.0); \n   float alpha = diff / (1.0 + diff); \n   gl_FragColor = vec4(alpha, alpha, alpha, 1.0); \n}";
  
  public ExpFilter()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() {\n   vec2 c = vec2(textureCoordinate.x * 16.0 / 15.0, textureCoordinate.y * 24.0 / 23.0); \n   if (c.x > 1.0) { \n       c.x = 1.0; \n   } \n   if (c.y > 1.0) { \n       c.y = 1.0; \n   } \n   float value = texture2D(inputImageTexture, c).r; \n   float diff = exp(value * 100.0 - 50.0); \n   float alpha = diff / (1.0 + diff); \n   gl_FragColor = vec4(alpha, alpha, alpha, 1.0); \n}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.ExpFilter
 * JD-Core Version:    0.7.0.1
 */