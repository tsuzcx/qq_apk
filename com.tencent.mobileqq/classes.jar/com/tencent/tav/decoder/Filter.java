package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.TextureInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class Filter
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
  private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  private TextureInfo _textureInfo = null;
  private int aPositionHandle;
  private int bgColor = -16777216;
  private int[] defaultViewport = new int[4];
  private int frameBuffer = -1;
  protected int program;
  private boolean renderForScreen = true;
  private int rendererHeight;
  private int rendererWidth;
  @NonNull
  private final int[] shaderIndexes = new int[2];
  private int stMatrixHandle;
  private FloatBuffer triangleVertices;
  private int uAlphaHandle;
  private int uMatrixHandle;
  private int uScreenSizeHandle;
  private int uTextureSizeHandle;
  
  private void initFrameBuffer()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(3553, i);
    RenderContext.checkEglError("glBindTexture mTextureID");
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    RenderContext.checkEglError("glTexParameter");
    GLES20.glTexImage2D(3553, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, 5121, null);
    this._textureInfo = new TextureInfo(i, 3553, this.rendererWidth, this.rendererHeight, null, 0);
    arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    int j = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, j);
    RenderContext.checkEglError("glBindFramebuffer frameBuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
    RenderContext.checkEglError("glCheckFramebufferStatus frameBuffer");
    if (GLES20.glCheckFramebufferStatus(36160) != 36053)
    {
      new RuntimeException("EGL error encountered: FramebufferStatus is not complete.").printStackTrace();
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    this.frameBuffer = j;
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo)
  {
    return applyFilter(paramTextureInfo, null, null, 1.0F);
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    return applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, 1.0F);
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat)
  {
    if ((!this.renderForScreen) && (this.frameBuffer == -1)) {
      initFrameBuffer();
    }
    if (this.program == 0) {
      initShaderForTextureInfo(paramTextureInfo);
    }
    RenderContext.checkEglError("onDrawFrame start");
    Rectangle localRectangle = new Rectangle(0.0F, 0.0F, paramTextureInfo.width, paramTextureInfo.height);
    float f1 = localRectangle.x;
    float f2 = localRectangle.y;
    float f3 = localRectangle.height;
    float f4 = localRectangle.x;
    float f5 = localRectangle.y;
    float f6 = localRectangle.x;
    float f7 = localRectangle.width;
    float f8 = localRectangle.y;
    float f9 = localRectangle.height;
    float f10 = localRectangle.x;
    float f11 = localRectangle.width;
    float f12 = localRectangle.y;
    this.triangleVertices.rewind();
    this.triangleVertices.put(new float[] { f1, f2 + f3, f4, f5, f6 + f7, f8 + f9, f10 + f11, f12 });
    GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
    if (this.frameBuffer != -1)
    {
      GLES20.glBindFramebuffer(36160, this.frameBuffer);
      GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
      GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
    }
    GLES20.glUseProgram(this.program);
    RenderContext.checkEglError("glUseProgram");
    GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, DecoderUtils.toOpenGL2DMatrix(paramMatrix2), 0);
    GLES20.glUniform1f(this.uAlphaHandle, paramFloat);
    prepareDraw(paramTextureInfo, DecoderUtils.toOpenGL2DMatrix(paramMatrix1));
    int i = this.bgColor;
    int j = this.bgColor;
    int k = this.bgColor;
    GLES20.glClearColor(((i & 0xFF0000) >> 16) / 255.0F, ((j & 0xFF00) >> 8) / 255.0F, (k & 0xFF) / 255.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glDrawArrays(5, 0, 4);
    RenderContext.checkEglError("glDrawArrays");
    finishDraw(paramTextureInfo);
    if (this.frameBuffer != -1)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
    }
    if (!this.renderForScreen) {
      return this._textureInfo;
    }
    return null;
  }
  
  public Filter clone()
  {
    return new Filter();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (Filter)paramObject;
    } while ((this.rendererHeight == paramObject.rendererHeight) && (this.rendererWidth == paramObject.rendererWidth) && (this.renderForScreen == paramObject.renderForScreen));
    return false;
  }
  
  protected void finishDraw(TextureInfo paramTextureInfo)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, 0);
  }
  
  public int getFrameBuffer()
  {
    return this.frameBuffer;
  }
  
  public int getRendererHeight()
  {
    return this.rendererHeight;
  }
  
  public int getRendererWidth()
  {
    return this.rendererWidth;
  }
  
  public int hashCode()
  {
    int j = this.program;
    int k = this.uScreenSizeHandle;
    int m = this.uTextureSizeHandle;
    int n = this.uMatrixHandle;
    int i1 = this.uAlphaHandle;
    int i2 = this.stMatrixHandle;
    int i3 = this.aPositionHandle;
    int i4 = this.rendererWidth;
    int i5 = this.rendererHeight;
    if (this.renderForScreen) {}
    for (int i = 1;; i = 0) {
      return ((i + (((((((((j + 0) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31 + this.frameBuffer) * 31 + Arrays.hashCode(this.defaultViewport);
    }
  }
  
  protected void initShaderForTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.textureType == 36197)
    {
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
      return;
    }
    initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
  }
  
  protected void initShaders(String paramString1, String paramString2)
  {
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.program = Program.createProgram(paramString1, paramString2, this.shaderIndexes);
    if (this.program == 0) {
      new RuntimeException("failed creating program").printStackTrace();
    }
    do
    {
      return;
      this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
      RenderContext.checkEglError("glGetAttribLocation aPosition");
      if (this.aPositionHandle == -1)
      {
        new RuntimeException("Could not get attribute location for aPosition").printStackTrace();
        return;
      }
      this.uMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
      RenderContext.checkEglError("glGetUniformLocation uMatrix");
      if (this.uMatrixHandle == -1)
      {
        new RuntimeException("Could not get uniform location for uMatrix").printStackTrace();
        return;
      }
      this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
      RenderContext.checkEglError("glGetUniformLocation uAlpha");
      if (this.uAlphaHandle == -1)
      {
        new RuntimeException("Could not get uniform location for uAlpha").printStackTrace();
        return;
      }
      this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
      RenderContext.checkEglError("glGetUniformLocation stMatrix");
      if (this.stMatrixHandle == -1)
      {
        new RuntimeException("Could not get uniform location for stMatrix").printStackTrace();
        return;
      }
      this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
      RenderContext.checkEglError("glGetUniformLocation uScreenSize");
      if (this.uScreenSizeHandle == -1)
      {
        new RuntimeException("Could not get uniform location for uScreenSize").printStackTrace();
        return;
      }
      this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
      RenderContext.checkEglError("glGetUniformLocation uTextureSize");
    } while (this.uTextureSizeHandle != -1);
    new RuntimeException("Could not get uniform location for uTextureSize").printStackTrace();
  }
  
  protected void prepareDraw(TextureInfo paramTextureInfo, float[] paramArrayOfFloat)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTextureInfo.textureType, paramTextureInfo.textureID);
    this.triangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, this.triangleVertices);
    RenderContext.checkEglError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.aPositionHandle);
    RenderContext.checkEglError("glEnableVertexAttribArray aPositionHandle");
    GLES20.glUniformMatrix3fv(this.uMatrixHandle, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform2f(this.uTextureSizeHandle, paramTextureInfo.width, paramTextureInfo.height);
    GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
  }
  
  public void release()
  {
    if (this.frameBuffer != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.frameBuffer }, 0);
      this.frameBuffer = -1;
    }
    if (this._textureInfo != null)
    {
      GLES20.glDeleteTextures(1, new int[] { this._textureInfo.textureID }, 0);
      this._textureInfo = null;
    }
    if (this.program > 0)
    {
      GLES20.glDeleteProgram(this.program);
      this.program = 0;
    }
    int i = 0;
    while (i < this.shaderIndexes.length)
    {
      if (this.shaderIndexes[i] > 0)
      {
        GLES20.glDeleteShader(this.shaderIndexes[i]);
        this.shaderIndexes[i] = 0;
      }
      i += 1;
    }
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
  }
  
  public void setRenderForScreen(boolean paramBoolean)
  {
    this.renderForScreen = paramBoolean;
  }
  
  public void setRendererHeight(int paramInt)
  {
    this.rendererHeight = paramInt;
  }
  
  public void setRendererWidth(int paramInt)
  {
    this.rendererWidth = paramInt;
  }
  
  public TextureInfo textureInfo()
  {
    return this._textureInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.Filter
 * JD-Core Version:    0.7.0.1
 */