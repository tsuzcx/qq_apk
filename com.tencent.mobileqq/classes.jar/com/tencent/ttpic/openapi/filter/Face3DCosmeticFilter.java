package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.initializer.Face3DLibInitializer;
import com.tencent.ttpic.util.AlgoUtils;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Face3DCosmeticFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 v_uvTexCoords;\nvarying vec2 v_inputTexCoords;\nvoid main()\n{\n    gl_FragColor = texture2D(inputImageTexture, v_uvTexCoords); \n}\n";
  private static final int PER_FLOAT_BYTE = 4;
  private static final int PER_INT_BYTE = 4;
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 uvTexCoords;\nvarying vec2 v_uvTexCoords;\nvarying vec2 v_inputTexCoords;\nuniform vec2 faceDetSize; \nuniform mat4 matrix; \nvoid main()\n{\n  vec4 pos = matrix * position; \n  gl_Position = vec4(pos.x / faceDetSize.x * 2.0 - 1.0, pos.y / faceDetSize.y * 2.0 - 1.0, -pos.z / 2.0 / max(faceDetSize.x, faceDetSize.y), 1.0);\n  v_uvTexCoords = vec2(uvTexCoords.x, 1.0 - uvTexCoords.y);\n  v_inputTexCoords = vec2(pos.x / faceDetSize.x, pos.y / faceDetSize.y); \n}\n";
  private int[] mBuffer = new int[2];
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private int[] mDepthBuffer = new int[1];
  private int[] mFrameBuffer = new int[1];
  private int[] mTexture = new int[1];
  private FloatBuffer mVertexBuffer;
  private int updateVideoHeight;
  private int updateVideoWidth;
  
  public Face3DCosmeticFilter()
  {
    super("attribute vec4 position;\nattribute vec2 uvTexCoords;\nvarying vec2 v_uvTexCoords;\nvarying vec2 v_inputTexCoords;\nuniform vec2 faceDetSize; \nuniform mat4 matrix; \nvoid main()\n{\n  vec4 pos = matrix * position; \n  gl_Position = vec4(pos.x / faceDetSize.x * 2.0 - 1.0, pos.y / faceDetSize.y * 2.0 - 1.0, -pos.z / 2.0 / max(faceDetSize.x, faceDetSize.y), 1.0);\n  v_uvTexCoords = vec2(uvTexCoords.x, 1.0 - uvTexCoords.y);\n  v_inputTexCoords = vec2(pos.x / faceDetSize.x, pos.y / faceDetSize.y); \n}\n", "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 v_uvTexCoords;\nvarying vec2 v_inputTexCoords;\nvoid main()\n{\n    gl_FragColor = texture2D(inputImageTexture, v_uvTexCoords); \n}\n");
    initParams();
  }
  
  private void clearGLResources()
  {
    GLES20.glDeleteTextures(this.mTexture.length, this.mTexture, 0);
    GLES20.glDeleteFramebuffers(this.mFrameBuffer.length, this.mFrameBuffer, 0);
    GLES20.glDeleteRenderbuffers(this.mDepthBuffer.length, this.mDepthBuffer, 0);
    GLES20.glDeleteBuffers(this.mBuffer.length, this.mBuffer, 0);
    this.mCopyFilter.ClearGLSL();
  }
  
  private void initGLResources()
  {
    GLES20.glGenTextures(this.mTexture.length, this.mTexture, 0);
    GLES20.glGenFramebuffers(this.mFrameBuffer.length, this.mFrameBuffer, 0);
    GLES20.glGenRenderbuffers(this.mDepthBuffer.length, this.mDepthBuffer, 0);
    GLES20.glGenBuffers(this.mBuffer.length, this.mBuffer, 0);
    this.mCopyFilter.apply();
  }
  
  private void updateGLResources()
  {
    if ((this.width == 0) || (this.height == 0) || (this.mTexture[0] <= 0) || (!isValid())) {}
    while ((this.updateVideoWidth == this.width) && (this.updateVideoHeight == this.height)) {
      return;
    }
    this.updateVideoWidth = this.width;
    this.updateVideoHeight = this.height;
    GLES20.glActiveTexture(33989);
    GLES20.glBindTexture(3553, this.mTexture[0]);
    GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
    GLES20.glBindRenderbuffer(36161, this.mDepthBuffer[0]);
    GLES20.glRenderbufferStorage(36161, 33189, this.width, this.height);
    GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mDepthBuffer[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mTexture[0], 0);
    if (GLES20.glCheckFramebufferStatus(36160) != 36053) {}
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glBindTexture(3553, 0);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    initGLResources();
    updateVideoSize(this.width, this.height, this.mFaceDetScale);
    this.mVertexBuffer = FloatBuffer.wrap(Face3DLibInitializer.face3DUV);
    GLES20.glBindBuffer(34962, this.mBuffer[0]);
    GLES20.glBufferData(34962, this.mVertexBuffer.capacity() * 4, this.mVertexBuffer, 35048);
    GLES20.glBindBuffer(34962, 0);
    IntBuffer localIntBuffer = IntBuffer.wrap(Face3DLibInitializer.face3DIndices);
    GLES20.glBindBuffer(34963, this.mBuffer[1]);
    GLES20.glBufferData(34963, localIntBuffer.capacity() * 4, localIntBuffer, 35044);
    GLES20.glBindBuffer(34963, 0);
  }
  
  public void OnDrawFrameGLSL()
  {
    OnDrawFrameGLSLSuper();
    GLES20.glBindBuffer(34962, this.mBuffer[0]);
    GLES20.glBufferSubData(34962, 0, 41376, this.mVertexBuffer);
    GLES20.glEnableVertexAttribArray(getAttribParam("position").handle);
    GLES20.glVertexAttribPointer(getAttribParam("position").handle, 3, 5126, false, 12, 0);
    GLES20.glEnableVertexAttribArray(getAttribParam("uvTexCoords").handle);
    GLES20.glVertexAttribPointer(getAttribParam("uvTexCoords").handle, 2, 5126, false, 8, 41376);
    GLES20.glBindBuffer(34963, this.mBuffer[1]);
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    return this.mCopyFilter.RenderProcess(this.mTexture[0], paramInt2, paramInt3);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    this.mCopyFilter.RenderProcess(this.mTexture[0], paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    clearGLResources();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam(new AttributeParam("uvTexCoords", GlUtil.EMPTY_POSITIONS));
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float2fParam("faceDetSize", 180.0F, 240.0F));
    addParam(new UniformParam.Mat4Param("matrix", new float[16]));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    GLES20.glEnable(2884);
    GLES20.glFrontFace(2305);
    GLES20.glCullFace(1028);
    GLES20.glEnable(2929);
    GLES20.glDepthFunc(513);
    GLES20.glDepthMask(true);
    GLES20.glClear(256);
    GLES20.glDisable(3042);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    GLES20.glDrawElements(4, 20208, 5125, 0);
    GLES20.glBindBuffer(34962, 0);
    GLES20.glBindBuffer(34963, 0);
    GLES20.glDisable(2929);
    GLES20.glDisable(2884);
    return true;
  }
  
  public void updatePreview(Object paramObject)
  {
    float[] arrayOfFloat;
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      super.updatePreview(paramObject);
      arrayOfFloat = paramObject.face3DVerticesArray;
      if ((arrayOfFloat != null) && (arrayOfFloat.length >= 10344)) {
        break label35;
      }
    }
    label35:
    while ((!AlgoUtils.isFace3DPointsValid(arrayOfFloat)) || (this.width == 0) || (this.height == 0) || (this.mTexture[0] <= 0) || (!isValid())) {
      return;
    }
    this.mVertexBuffer.put(paramObject.face3DVerticesArray, 0, paramObject.face3DVerticesArray.length).position(0);
    addParam(new UniformParam.Mat4Param("matrix", paramObject.face3DRotationArray));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("faceDetSize", (int)(paramInt1 * paramDouble), (int)(paramInt2 * paramDouble)));
    updateGLResources();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.Face3DCosmeticFilter
 * JD-Core Version:    0.7.0.1
 */