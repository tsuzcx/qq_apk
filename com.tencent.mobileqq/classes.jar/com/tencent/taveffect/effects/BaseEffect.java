package com.tencent.taveffect.effects;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.taveffect.core.TAVBaseFilter;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;
import com.tencent.taveffect.utils.TAVMatrixUtils;
import com.tencent.taveffect.utils.TVTGLProgramUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public abstract class BaseEffect
  extends TAVBaseFilter
{
  protected static final int FLOAT_SIZE_BYTES = 4;
  protected static final String FRAGMENT_SHADER_PREFIX = "uniform sampler2D ";
  protected static final String FRAGMENT_SHADER_PREFIX_OES = " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ";
  protected static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  protected static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
  protected static String VERTEX_SHADER_CODE = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  private int aPositionHandle;
  private float curFrameTime;
  protected float deltaTime;
  private int[] fbo = new int[1];
  private float lastFrameTime;
  protected TAVTextureInfo outputTextureInfo;
  protected int[] textureID = new int[1];
  protected FloatBuffer triangleVertices;
  private int uScreenSizeHandle;
  private int uTextureSizeHandle;
  
  private void bindFramebuffer()
  {
    GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
    if (this.fbo[0] == 0)
    {
      GLES20.glGenTextures(1, this.textureID, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.textureID[0]);
      GLES20.glTexImage2D(3553, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, 5121, null);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glBindTexture(3553, 0);
      GLES20.glGenFramebuffers(1, this.fbo, 0);
      GLES20.glBindFramebuffer(36160, this.fbo[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureID[0], 0);
      GLES20.glClear(16384);
      GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
      return;
    }
    GLES20.glBindFramebuffer(36160, this.fbo[0]);
    GLES20.glClear(16384);
    GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
  }
  
  private void finishDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTAVTextureInfo.textureType, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
    this.lastFrameTime = this.curFrameTime;
  }
  
  protected void afterDraw(TAVTextureInfo paramTAVTextureInfo) {}
  
  public TAVTextureInfo applyNewTexture(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.lastFrameTime == 0.0F) {
      this.lastFrameTime = ((float)SystemClock.uptimeMillis());
    }
    this.curFrameTime = ((float)SystemClock.uptimeMillis());
    this.deltaTime = ((this.curFrameTime - this.lastFrameTime) / 1000.0F);
    if ((this.rendererWidth == 0) || (this.rendererHeight == 0)) {
      Log.w(this.TAG, "rendererWidth = " + this.rendererWidth + ", rendererHeight = " + this.rendererHeight);
    }
    if ((paramTAVTextureInfo.textureType != this.textureType) || (this.program == 0)) {
      initShader(paramTAVTextureInfo);
    }
    bindFramebuffer();
    useProgram();
    beforeDraw(paramTAVTextureInfo);
    onDraw(paramTAVTextureInfo);
    afterDraw(paramTAVTextureInfo);
    finishDraw(paramTAVTextureInfo);
    return getOutputTextureInfo(paramTAVTextureInfo);
  }
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo) {}
  
  protected abstract String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo);
  
  protected TAVTextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.outputTextureInfo == null) {
      this.outputTextureInfo = new TAVTextureInfo();
    }
    this.outputTextureInfo.setFrameTimeUs(paramTAVTextureInfo.frameTimeUs);
    this.outputTextureInfo.setWidth(this.rendererWidth);
    this.outputTextureInfo.setHeight(this.rendererHeight);
    this.outputTextureInfo.setPreRotation(paramTAVTextureInfo.getPreRotation());
    this.outputTextureInfo.setTextureType(3553);
    this.outputTextureInfo.setTextureID(this.textureID[0]);
    return this.outputTextureInfo;
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    String str = getFragmentShaderCode(paramTAVTextureInfo);
    this.vertexShaderCode = VERTEX_SHADER_CODE;
    this.fragmentShaderCode = str;
    this.program = TVTGLProgramUtils.createProgram(VERTEX_SHADER_CODE, str);
    if (this.program == 0)
    {
      new RuntimeException("failed creating program").printStackTrace();
      return;
    }
    this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
    TAVGLUtils.checkEglError("glGetAttribLocation aPosition");
    this.xyMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
    TAVGLUtils.checkEglError("glGetUniformLocation uMatrix");
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    TAVGLUtils.checkEglError("glGetUniformLocation stMatrix");
    this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
    TAVGLUtils.checkEglError("glGetUniformLocation uScreenSize");
    this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
    TAVGLUtils.checkEglError("glGetUniformLocation uTextureSize");
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    TAVGLUtils.checkEglError("glGetUniformLocation stMatrix");
    this.textureType = paramTAVTextureInfo.textureType;
  }
  
  protected void onDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    this.cropRect = new TAVRectangle(0.0F, 0.0F, paramTAVTextureInfo.width, paramTAVTextureInfo.height);
    float f1 = this.cropRect.x;
    float f2 = this.cropRect.y;
    float f3 = this.cropRect.height;
    float f4 = this.cropRect.x;
    float f5 = this.cropRect.y;
    float f6 = this.cropRect.x;
    float f7 = this.cropRect.width;
    float f8 = this.cropRect.y;
    float f9 = this.cropRect.height;
    float f10 = this.cropRect.x;
    float f11 = this.cropRect.width;
    float f12 = this.cropRect.y;
    this.triangleVertices.rewind();
    this.triangleVertices.put(new float[] { f1, f2 + f3, f4, f5, f6 + f7, f8 + f9, f10 + f11, f12 });
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTAVTextureInfo.textureType, paramTAVTextureInfo.textureID);
    this.triangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, this.triangleVertices);
    TAVGLUtils.checkEglError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.aPositionHandle);
    TAVGLUtils.checkEglError("glEnableVertexAttribArray aPositionHandle");
    GLES20.glUniformMatrix3fv(this.xyMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.xyMatrix), 0);
    GLES20.glUniform2f(this.uTextureSizeHandle, paramTAVTextureInfo.width, paramTAVTextureInfo.height);
    GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
    GLES20.glDrawArrays(5, 0, 4);
    TAVGLUtils.checkEglError("glDrawArrays");
  }
  
  public void release()
  {
    if (this.textureID[0] != 0)
    {
      GLES20.glDeleteTextures(1, this.textureID, 0);
      this.textureID[0] = 0;
    }
    if (this.fbo[0] != 0)
    {
      GLES20.glDeleteFramebuffers(1, this.fbo, 0);
      this.fbo[0] = 0;
    }
    GLES20.glDeleteProgram(this.program);
    this.program = 0;
    this.xyMatrix = null;
    this.stMatrix = null;
    this.cropRect = null;
  }
  
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, TAVRectangle paramTAVRectangle, float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  protected void useProgram()
  {
    GLES20.glUseProgram(this.program);
    TAVGLUtils.checkEglError("glUseProgram");
    GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.stMatrix), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.taveffect.effects.BaseEffect
 * JD-Core Version:    0.7.0.1
 */