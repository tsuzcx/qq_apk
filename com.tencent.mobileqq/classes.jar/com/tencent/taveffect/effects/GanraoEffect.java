package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.RandomUtils;
import com.tencent.taveffect.utils.TAVGLUtils;

public class GanraoEffect
  extends BaseEffect
{
  private static String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform vec4 shadowOffset;\nuniform int shadowColorInit;\nuniform int barNum;\nuniform mat4 barPositions;\nvoid main()\n{\n    vec2 originTexCoord = vTextureCoord;\n    vec2 adjustTexCoord = vTextureCoord;\n    vec2 offset = vec2(0.0, 0.0);\n    float flag = 0.0;\n    for (int i = 0;i < barNum;i++)\n    {\n        float diff1 = clamp(originTexCoord.y - barPositions[i].x, 0.0, 1.0);\n        float diff2 = clamp(barPositions[i].y - originTexCoord.y, 0.0, 1.0);\n        flag = clamp(diff1 * diff2 * 1e08, 0.0, 1.0);\n\n        offset = offset + flag * vec2(barPositions[i].z, 0.0);\n        adjustTexCoord = adjustTexCoord + offset;\n    }\n\n    vec4 videoColor = texture2D(sTexture, adjustTexCoord);\n    vec4 shadow = texture2D(sTexture, adjustTexCoord + shadowOffset.xy + offset);\n\n    float shadowColor = clamp(float(shadowColorInit), 1.0, 3.0);\n\n    vec4 finalColor = vec4(0.0, 0.0, 0.0, 1.0);\n\n    flag = abs(shadowColor - 1.0);\n    flag = abs(step(1.0, flag) - 1.0);\n    finalColor += flag * vec4(videoColor.r, videoColor.g, shadow.b, 0.0);\n\n    flag = abs(shadowColor - 2.0);\n    flag = abs(step(1.0, flag) - 1.0);\n    finalColor += flag * vec4(videoColor.r, shadow.g, videoColor.b, 0.0);\n\n    flag = abs(shadowColor - 3.0);\n    flag = abs(step(1.0, flag) - 1.0);\n    gl_FragColor = finalColor + flag * vec4(shadow.r, videoColor.g, videoColor.b, 0.0);\n}";
  private int barNumHandle;
  private int barPositionsHandle;
  private String columnCode = "    for (int i = 0;i < barNum;i++)\n    {\n        float diff1 = clamp(originTexCoord.x - barPositions[i].x, 0.0, 1.0);\n        float diff2 = clamp(barPositions[i].y - originTexCoord.x, 0.0, 1.0);\n        flag = clamp(diff1 * diff2 * 1e08, 0.0, 1.0);\n\n        offset = offset + flag * vec2(0.0, barPositions[i].z);\n        adjustTexCoord = adjustTexCoord + offset;\n    }\n";
  private float deltaTime = 0.02F;
  private float elpsedTime;
  private int flickCount;
  private float flickTime;
  private boolean init;
  private int shadowColorInitHandle;
  private int shadowOffsetHandle;
  
  private void generateRandomData()
  {
    float f1 = RandomUtils.randomFloat(0.0F, 0.01F);
    float f2 = RandomUtils.randomFloat(0.0F, 0.01F);
    float[] arrayOfFloat1 = new float[4];
    arrayOfFloat1[0] = f1;
    arrayOfFloat1[1] = f2;
    arrayOfFloat1[2] = 0.0F;
    arrayOfFloat1[3] = 0.0F;
    int k = RandomUtils.randomInt(1, 3);
    float[] arrayOfFloat2 = new float[16];
    int i = 0;
    f1 = 0.0F;
    if (i < k)
    {
      f2 = RandomUtils.randomFloat(f1, 0.9F);
      f1 = RandomUtils.randomFloat(0.05F + f2, 0.2F + f2);
      if (f1 <= 0.99F) {}
    }
    for (;;)
    {
      GLES20.glUniform4f(this.shadowOffsetHandle, arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2], arrayOfFloat1[3]);
      GLES20.glUniform1i(this.barNumHandle, i);
      GLES20.glUniformMatrix4fv(this.barPositionsHandle, 1, false, arrayOfFloat2, 0);
      GLES20.glUniform1i(this.shadowColorInitHandle, RandomUtils.randomInt(1, 2));
      return;
      float f3 = RandomUtils.randomFloat(0.005F, 0.02F);
      int m = RandomUtils.randomInt(1, 2);
      int j = m;
      if (m == 2) {
        j = -1;
      }
      setRowForMatrix4(arrayOfFloat2, i, f2, f1, f3 * j, 0.0F);
      i += 1;
      break;
      i = k;
    }
  }
  
  private void recover()
  {
    GLES20.glUniform1i(this.barNumHandle, 0);
    GLES20.glUniform4f(this.shadowOffsetHandle, 0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  private void setRowForMatrix4(float[] paramArrayOfFloat, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramInt *= 4;
    paramArrayOfFloat[paramInt] = paramFloat1;
    paramArrayOfFloat[(paramInt + 1)] = paramFloat2;
    paramArrayOfFloat[(paramInt + 2)] = paramFloat3;
    paramArrayOfFloat[(paramInt + 3)] = paramFloat4;
  }
  
  private void update()
  {
    this.elpsedTime += 0.05F;
    if (this.elpsedTime > 1.0F)
    {
      if (this.flickCount == 0) {
        this.flickCount = RandomUtils.randomInt(3, 7);
      }
      this.flickTime += 0.05F;
      if (this.flickTime > 0.06F)
      {
        generateRandomData();
        this.flickTime = 0.0F;
        this.flickCount -= 1;
        if (this.flickCount == 0)
        {
          recover();
          this.elpsedTime = 0.0F;
        }
      }
    }
  }
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    if (!this.init)
    {
      this.init = true;
      recover();
    }
    update();
  }
  
  public GanraoEffect clone()
  {
    return (GanraoEffect)cloneFilter(new GanraoEffect());
  }
  
  protected String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + FRAGMENT_SHADER_CODE;
    }
    return "uniform sampler2D " + FRAGMENT_SHADER_CODE;
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.barNumHandle = GLES20.glGetUniformLocation(this.program, "barNum");
    TAVGLUtils.checkEglError("glGetAttribLocation barNum");
    this.shadowOffsetHandle = GLES20.glGetUniformLocation(this.program, "shadowOffset");
    TAVGLUtils.checkEglError("glGetAttribLocation shadowOffset");
    this.barPositionsHandle = GLES20.glGetUniformLocation(this.program, "barPositions");
    TAVGLUtils.checkEglError("glGetAttribLocation barPositions");
    this.shadowColorInitHandle = GLES20.glGetUniformLocation(this.program, "shadowColorInit");
    TAVGLUtils.checkEglError("glGetAttribLocation shadowColorInit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.taveffect.effects.GanraoEffect
 * JD-Core Version:    0.7.0.1
 */