package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;

public class ExpFilterV2
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nprecision highp int;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float width;\nuniform float height;\nuniform int uniform_w;\nuniform int uniform_h;\n\nvoid main()\n{\n  int x = int(floor(textureCoordinate.x * width));\n  int y = int(floor(textureCoordinate.y * height));\n  float posx = float(x) * float(uniform_w) / width;\n  float posy = float(y) * float(uniform_h) / height;\n\n  int dx = int(floor(posx));\n  int dy = int(floor(posy));\n  int dx2 = dx + 1;\n  int dy2 = dy + 1;\n  if (dx < 0) dx = 0;\n  if (dy < 0) dy = 0;\n  if (dx2 == uniform_w) dx2 = dx;\n  if (dy2 == uniform_h) dy2 = dy;\n  \n  \n  float ratioX = posx - float(dx);\n  float ratioY = posy - float(dy);\n  \n  float x1 = 0.5 / float(uniform_w) * (2.0 * float(dx) + 1.0);\n  float y1 = 0.5 / float(uniform_h) * (2.0 * float(dy) + 1.0);\n  float x2 = 0.5 / float(uniform_w) * (2.0 * float(dx2) + 1.0);\n  float y2 = 0.5 / float(uniform_h) * (2.0 * float(dy) + 1.0);\n  float x3 = 0.5 / float(uniform_w) * (2.0 * float(dx2) + 1.0);\n  float y3 = 0.5 / float(uniform_h) * (2.0 * float(dy2) + 1.0);\n  float x4 = 0.5 / float(uniform_w) * (2.0 * float(dx) + 1.0);\n  float y4 = 0.5 / float(uniform_h) * (2.0 * float(dy2) + 1.0);\n  \n  float sampleX = (x1 * (1.0 - ratioX) * (1.0 - ratioY) +\n                    x2 * ratioX * (1.0 - ratioY) +\n                    x3 * ratioX * ratioY +\n                    x4 * (1.0 - ratioX) * ratioY);\n  float sampleY = (y1 * (1.0 - ratioX) * (1.0 - ratioY) +\n                    y2 * ratioX * (1.0 - ratioY) +\n                    y3 * ratioX * ratioY +\n                    y4 * (1.0 - ratioX) * ratioY);\n\n  vec4 sampleColor = texture2D(inputImageTexture, vec2(sampleX, sampleY));\n\n        float diff = sampleColor.r * 50.0 - 25.0;\n        if (diff > 5.0) { \n           diff = 5.0; \n        } \n        if (diff < -5.0) { \n           diff = -5.0; \n        } \n        diff = exp(diff);\n        diff = diff/(diff + 1.0);\n        float r = step(0.3, diff) * diff;\n        \n  \n  gl_FragColor = vec4(r, r, r, 1.0);\n}";
  
  public ExpFilterV2()
  {
    super("precision highp float;\nprecision highp int;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float width;\nuniform float height;\nuniform int uniform_w;\nuniform int uniform_h;\n\nvoid main()\n{\n  int x = int(floor(textureCoordinate.x * width));\n  int y = int(floor(textureCoordinate.y * height));\n  float posx = float(x) * float(uniform_w) / width;\n  float posy = float(y) * float(uniform_h) / height;\n\n  int dx = int(floor(posx));\n  int dy = int(floor(posy));\n  int dx2 = dx + 1;\n  int dy2 = dy + 1;\n  if (dx < 0) dx = 0;\n  if (dy < 0) dy = 0;\n  if (dx2 == uniform_w) dx2 = dx;\n  if (dy2 == uniform_h) dy2 = dy;\n  \n  \n  float ratioX = posx - float(dx);\n  float ratioY = posy - float(dy);\n  \n  float x1 = 0.5 / float(uniform_w) * (2.0 * float(dx) + 1.0);\n  float y1 = 0.5 / float(uniform_h) * (2.0 * float(dy) + 1.0);\n  float x2 = 0.5 / float(uniform_w) * (2.0 * float(dx2) + 1.0);\n  float y2 = 0.5 / float(uniform_h) * (2.0 * float(dy) + 1.0);\n  float x3 = 0.5 / float(uniform_w) * (2.0 * float(dx2) + 1.0);\n  float y3 = 0.5 / float(uniform_h) * (2.0 * float(dy2) + 1.0);\n  float x4 = 0.5 / float(uniform_w) * (2.0 * float(dx) + 1.0);\n  float y4 = 0.5 / float(uniform_h) * (2.0 * float(dy2) + 1.0);\n  \n  float sampleX = (x1 * (1.0 - ratioX) * (1.0 - ratioY) +\n                    x2 * ratioX * (1.0 - ratioY) +\n                    x3 * ratioX * ratioY +\n                    x4 * (1.0 - ratioX) * ratioY);\n  float sampleY = (y1 * (1.0 - ratioX) * (1.0 - ratioY) +\n                    y2 * ratioX * (1.0 - ratioY) +\n                    y3 * ratioX * ratioY +\n                    y4 * (1.0 - ratioX) * ratioY);\n\n  vec4 sampleColor = texture2D(inputImageTexture, vec2(sampleX, sampleY));\n\n        float diff = sampleColor.r * 50.0 - 25.0;\n        if (diff > 5.0) { \n           diff = 5.0; \n        } \n        if (diff < -5.0) { \n           diff = -5.0; \n        } \n        diff = exp(diff);\n        diff = diff/(diff + 1.0);\n        float r = step(0.3, diff) * diff;\n        \n  \n  gl_FragColor = vec4(r, r, r, 1.0);\n}");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new Param.FloatParam("width", 0.0F));
    addParam(new Param.FloatParam("height", 0.0F));
    addParam(new Param.IntParam("uniform_w", 0));
    addParam(new Param.IntParam("uniform_h", 0));
  }
  
  public void updateParam(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    addParam(new Param.FloatParam("width", paramFloat1));
    addParam(new Param.FloatParam("height", paramFloat2));
    addParam(new Param.IntParam("uniform_w", paramInt1));
    addParam(new Param.IntParam("uniform_h", paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.ExpFilterV2
 * JD-Core Version:    0.7.0.1
 */