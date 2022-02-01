package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;

public class FeatherBlurFilter
{
  public static final String NO_FILTER_FRAGMENT_SHADER = "precision highp float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvoid main() {\n    vec2 lTextureCoord = vec2(vTextureCoord.x,vTextureCoord.y);\n    vec2 textureOffset = vec2(texelWidthOffset,texelHeightOffset);\n    vec4 color = texture2D(uTexture, lTextureCoord);\n    float redValue   = color.r;\n    int featherWidth = 4;\n    bool needFeather  = false;\n    int i = 0;\n    float edgeIndex = 0.0;\n    for(i = -featherWidth/2;i <= featherWidth/2;i++)\n    {\n        float index = float(i);\n        vec2  texCoordAround = vec2(lTextureCoord.x + index * textureOffset.x,lTextureCoord.y);\n        vec4  texValAround   = texture2D(uTexture, texCoordAround);\n        float redAround      = texValAround.r;\n        vec2  texCoordAroundleft = vec2(lTextureCoord.x + (index-1.0) * textureOffset.x,lTextureCoord.y);\n        vec4  texValAroundleft   = texture2D(uTexture, texCoordAroundleft);\n        float redAroundleft      = texValAroundleft.r;\n        vec2  texCoordAroundright = vec2(lTextureCoord.x + (index+1.0) * textureOffset.x,lTextureCoord.y);\n        vec4  texValAroundright   = texture2D(uTexture, texCoordAroundright);\n        float redAroundright      = texValAroundright.r;\n        if(redAround == redAroundleft && redAround == redAroundright){\n           continue;\n        }\n        needFeather = ((redValue == 1.0 && redAround == 0.0) || (redValue == 0.0 && redAround == 1.0));\n        if(needFeather){\n           if(redValue == 1.0){\n               if(index < 0.0){\n                   edgeIndex = index + 1.0;\n               }else{\n                   edgeIndex = index - 1.0;\n               }\n           }else{\n               edgeIndex = index;\n           }\n           if(edgeIndex == 0.0){\n               color.a = 0.5;\n           }else{\n               float featherWidthFloat = float(featherWidth);\n               if(redValue == 0.0){\n                   color.a = 1.0 - abs(edgeIndex/featherWidthFloat);\n               }else{\n                   color.a = 0.5 + abs(edgeIndex/featherWidthFloat);\n               }\n           }\n        }\n    }\n    gl_FragColor = color;\n}\n";
  public static final String NO_FILTER_VERTEX_SHADER = "precision highp float;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying   vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n";
  private static final String TAG = "FeatherBlurFilter";
  private float mHeightStepRatio = 1.0F;
  private boolean mIsInitialized;
  private float mOutputHeight;
  private float mOutputWidth;
  private int mProgram;
  private float mWidthStepRatio = 1.0F;
  
  public void destroy()
  {
    if (this.mIsInitialized)
    {
      this.mIsInitialized = false;
      GLES20.glDeleteProgram(this.mProgram);
      this.mProgram = 0;
    }
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = this.mProgram;
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null) {
      arrayOfFloat = BigHeadBuckler.sGIdentity;
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null) {
      paramArrayOfFloat1 = BigHeadBuckler.sGIdentity;
    }
    GLES20.glUseProgram(i);
    int j = GLES20.glGetAttribLocation(i, "aPosition");
    int k = GLES20.glGetAttribLocation(i, "aTextureCoord");
    int m = GLES20.glGetUniformLocation(i, "uMVPMatrix");
    int n = GLES20.glGetUniformLocation(i, "uTextureMatrix");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, GpuGaussianBlurFilter.VERTEXT_BUF);
    GLES20.glEnableVertexAttribArray(j);
    GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, GpuGaussianBlurFilter.TEXTURE_BUF);
    GLES20.glEnableVertexAttribArray(k);
    GLES20.glUniformMatrix4fv(m, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(n, 1, false, arrayOfFloat, 0);
    j = GLES20.glGetUniformLocation(i, "texelWidthOffset");
    k = GLES20.glGetUniformLocation(i, "texelHeightOffset");
    GLES20.glUniform1f(j, this.mWidthStepRatio / this.mOutputWidth);
    GLES20.glUniform1f(k, this.mHeightStepRatio / this.mOutputHeight);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "uTexture"), 0);
    GLES20.glDrawArrays(5, 0, 4);
    paramInt = GLES20.glGetError();
    if (paramInt == 0) {
      return;
    }
    paramArrayOfFloat1 = new StringBuilder();
    paramArrayOfFloat1.append("error =");
    paramArrayOfFloat1.append(paramInt);
    throw new RuntimeException(paramArrayOfFloat1.toString());
  }
  
  public int getProgram()
  {
    return this.mProgram;
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    if (this.mIsInitialized) {
      return;
    }
    this.mProgram = GlUtil.createProgram("precision highp float;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying   vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision highp float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvoid main() {\n    vec2 lTextureCoord = vec2(vTextureCoord.x,vTextureCoord.y);\n    vec2 textureOffset = vec2(texelWidthOffset,texelHeightOffset);\n    vec4 color = texture2D(uTexture, lTextureCoord);\n    float redValue   = color.r;\n    int featherWidth = 4;\n    bool needFeather  = false;\n    int i = 0;\n    float edgeIndex = 0.0;\n    for(i = -featherWidth/2;i <= featherWidth/2;i++)\n    {\n        float index = float(i);\n        vec2  texCoordAround = vec2(lTextureCoord.x + index * textureOffset.x,lTextureCoord.y);\n        vec4  texValAround   = texture2D(uTexture, texCoordAround);\n        float redAround      = texValAround.r;\n        vec2  texCoordAroundleft = vec2(lTextureCoord.x + (index-1.0) * textureOffset.x,lTextureCoord.y);\n        vec4  texValAroundleft   = texture2D(uTexture, texCoordAroundleft);\n        float redAroundleft      = texValAroundleft.r;\n        vec2  texCoordAroundright = vec2(lTextureCoord.x + (index+1.0) * textureOffset.x,lTextureCoord.y);\n        vec4  texValAroundright   = texture2D(uTexture, texCoordAroundright);\n        float redAroundright      = texValAroundright.r;\n        if(redAround == redAroundleft && redAround == redAroundright){\n           continue;\n        }\n        needFeather = ((redValue == 1.0 && redAround == 0.0) || (redValue == 0.0 && redAround == 1.0));\n        if(needFeather){\n           if(redValue == 1.0){\n               if(index < 0.0){\n                   edgeIndex = index + 1.0;\n               }else{\n                   edgeIndex = index - 1.0;\n               }\n           }else{\n               edgeIndex = index;\n           }\n           if(edgeIndex == 0.0){\n               color.a = 0.5;\n           }else{\n               float featherWidthFloat = float(featherWidth);\n               if(redValue == 0.0){\n                   color.a = 1.0 - abs(edgeIndex/featherWidthFloat);\n               }else{\n                   color.a = 0.5 + abs(edgeIndex/featherWidthFloat);\n               }\n           }\n        }\n    }\n    gl_FragColor = color;\n}\n");
    if (this.mProgram == 0)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failed creating program ");
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      localObject = new RuntimeException(((StringBuilder)localObject).toString());
      if (SLog.isEnable()) {
        SLog.e("FeatherBlurFilter", "FeatherBlurFilter FeatherBlurFilter failed!", (Throwable)localObject);
      }
    }
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
    this.mIsInitialized = true;
  }
  
  public void setStepRatio(float paramFloat1, float paramFloat2)
  {
    this.mWidthStepRatio = paramFloat1;
    this.mHeightStepRatio = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.FeatherBlurFilter
 * JD-Core Version:    0.7.0.1
 */