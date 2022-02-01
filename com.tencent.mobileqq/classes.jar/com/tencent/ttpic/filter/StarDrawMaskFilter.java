package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;

public class StarDrawMaskFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n\nuniform vec2        texSize;\nuniform sampler2D   inputImageTexture;        \nvarying vec2        textureCoordinate;\n \nuniform int iteration; \nuniform vec2 direction; \nuniform float sizeScale; \n \nvec3 drawMask(sampler2D inputImage, vec2 texCoord, vec2 pixelSize, vec2 drawDirection, float attenuation) \n{ \n  vec2 texCoordSample = vec2(0.0); \n  vec3 cOut = vec3(0.0); \n  float b = pow(6.0, float(iteration));  \n  float rOut; \n  float gOut; \n  float bOut; \n  for (int s = 0; s < 6; s++) \n  { \n    float weight = pow(attenuation, b * float(s)); \n    texCoordSample = texCoord + (drawDirection * b * float(s) * pixelSize)*1.3; \n    rOut = clamp(weight,0.0,1.0) * texture2D (inputImage, texCoordSample).r; \n         \n    texCoordSample = texCoord + (drawDirection * b * float(s) * pixelSize)*1.3; \n    gOut = clamp(weight,0.0,1.0) * texture2D (inputImage, texCoordSample).g; \n         \n    texCoordSample = texCoord + (drawDirection * b * float(s) * pixelSize)*1.3; \n    bOut = clamp(weight,0.0,1.0) * texture2D (inputImage, texCoordSample).b; \n             \n    cOut += vec3(rOut,gOut,bOut); \n  } \n  return clamp(cOut * sizeScale,0.0,1.0); \n} \n\nvoid main( void ) \n{\n  float attenuation = 0.90; \n  float scale = 0.0015 * sizeScale; \n  vec2 pixelSize = vec2(scale, scale * texSize.x / texSize.y); \n  vec3 color = drawMask(inputImageTexture,textureCoordinate.xy, pixelSize, direction, attenuation); \n  gl_FragColor = vec4(color.rgb, 1.0);\n}\n";
  
  public StarDrawMaskFilter()
  {
    super("precision highp float;\n\nuniform vec2        texSize;\nuniform sampler2D   inputImageTexture;        \nvarying vec2        textureCoordinate;\n \nuniform int iteration; \nuniform vec2 direction; \nuniform float sizeScale; \n \nvec3 drawMask(sampler2D inputImage, vec2 texCoord, vec2 pixelSize, vec2 drawDirection, float attenuation) \n{ \n  vec2 texCoordSample = vec2(0.0); \n  vec3 cOut = vec3(0.0); \n  float b = pow(6.0, float(iteration));  \n  float rOut; \n  float gOut; \n  float bOut; \n  for (int s = 0; s < 6; s++) \n  { \n    float weight = pow(attenuation, b * float(s)); \n    texCoordSample = texCoord + (drawDirection * b * float(s) * pixelSize)*1.3; \n    rOut = clamp(weight,0.0,1.0) * texture2D (inputImage, texCoordSample).r; \n         \n    texCoordSample = texCoord + (drawDirection * b * float(s) * pixelSize)*1.3; \n    gOut = clamp(weight,0.0,1.0) * texture2D (inputImage, texCoordSample).g; \n         \n    texCoordSample = texCoord + (drawDirection * b * float(s) * pixelSize)*1.3; \n    bOut = clamp(weight,0.0,1.0) * texture2D (inputImage, texCoordSample).b; \n             \n    cOut += vec3(rOut,gOut,bOut); \n  } \n  return clamp(cOut * sizeScale,0.0,1.0); \n} \n\nvoid main( void ) \n{\n  float attenuation = 0.90; \n  float scale = 0.0015 * sizeScale; \n  vec2 pixelSize = vec2(scale, scale * texSize.x / texSize.y); \n  vec3 color = drawMask(inputImageTexture,textureCoordinate.xy, pixelSize, direction, attenuation); \n  gl_FragColor = vec4(color.rgb, 1.0);\n}\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.Float2fParam("texSize", 720.0F, 960.0F));
    addParam(new UniformParam.IntParam("iteration", 0));
    addParam(new UniformParam.Float2fParam("direction", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("sizeScale", 1.0F));
  }
  
  public void setDirection(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.Float2fParam("direction", paramFloat1, paramFloat2));
  }
  
  public void setIteration(int paramInt)
  {
    addParam(new UniformParam.IntParam("iteration", paramInt));
  }
  
  public void setScale(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("sizeScale", paramFloat));
  }
  
  public void setTexSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.Float2fParam("texSize", paramFloat1, paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.StarDrawMaskFilter
 * JD-Core Version:    0.7.0.1
 */