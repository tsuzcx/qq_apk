package com.tencent.ttpic.openapi.filter;

import android.graphics.Color;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class BGColorCropFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp vec4 clearColor;\n \n void main()\n {\n     if(textureCoordinate.x < -0.05 || textureCoordinate.x > 1.05 || textureCoordinate.y < -0.05 || textureCoordinate.y > 1.05)\n     {\n         gl_FragColor = vec4(clearColor[0], clearColor[1], clearColor[2], clearColor[3]);\n     }\n     else\n     {\n         gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n     }\n }";
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 tMat;\nvoid main(void)\n{\n   gl_Position = Projection * Modelview *position;\n   vec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\n   textureCoordinate = tmp.xy;\n}";
  
  public BGColorCropFilter()
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 tMat;\nvoid main(void)\n{\n   gl_Position = Projection * Modelview *position;\n   vec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\n   textureCoordinate = tmp.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp vec4 clearColor;\n \n void main()\n {\n     if(textureCoordinate.x < -0.05 || textureCoordinate.x > 1.05 || textureCoordinate.y < -0.05 || textureCoordinate.y > 1.05)\n     {\n         gl_FragColor = vec4(clearColor[0], clearColor[1], clearColor[2], clearColor[3]);\n     }\n     else\n     {\n         gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n     }\n }");
    addParam(new UniformParam.Float4fParam("clearColor", 255.0F, 0.0F, 0.0F, 0.0F));
  }
  
  public void apply()
  {
    super.apply();
  }
  
  public void setBackgroundColor(String paramString)
  {
    float[] arrayOfFloat = new float[4];
    float[] tmp5_4 = arrayOfFloat;
    tmp5_4[0] = 0.0F;
    float[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0.0F;
    float[] tmp13_9 = tmp9_5;
    tmp13_9[2] = 0.0F;
    float[] tmp17_13 = tmp13_9;
    tmp17_13[3] = 0.0F;
    tmp17_13;
    try
    {
      int i = Color.parseColor(paramString.replace("0x", "#"));
      arrayOfFloat[0] = (i >> 24 & 0xFF);
      arrayOfFloat[1] = (i >> 16 & 0xFF);
      arrayOfFloat[2] = (i >> 8 & 0xFF);
      arrayOfFloat[3] = (i & 0xFF);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    addParam(new UniformParam.Float4fParam("clearColor", arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BGColorCropFilter
 * JD-Core Version:    0.7.0.1
 */