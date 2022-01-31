package com.tencent.vbox.encode.hard;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.FloatBuffer;

@TargetApi(18)
public class SurfaceRender
{
  private static final String TAG = SurfaceRender.class.getSimpleName();
  private EncoderSurface mEncoderSurface;
  private int mFboTexH;
  private int mFboTexId;
  private int mFboTexW;
  private int mProgram = -1;
  private EGLContext mSavedEglContext = null;
  private EGLDisplay mSavedEglDisplay = null;
  private EGLSurface mSavedEglDrawSurface = null;
  private EGLSurface mSavedEglReadSurface = null;
  private final FloatBuffer mVtxBuf = GlUtil.createSquareVtx();
  private int maPositionHandle = -1;
  private int maTexCoordHandle = -1;
  private int muSamplerHandle = -1;
  
  public SurfaceRender(int paramInt1, int paramInt2, int paramInt3, EncoderSurface paramEncoderSurface)
  {
    this.mFboTexW = paramInt1;
    this.mFboTexH = paramInt2;
    this.mFboTexId = paramInt3;
    this.mEncoderSurface = paramEncoderSurface;
    saveRenderState();
    this.mEncoderSurface.makeCurrent();
    initGL();
    restoreRenderState();
  }
  
  private void initGL()
  {
    GlUtil.checkGlError("initGL_S");
    this.mProgram = GlUtil.createProgram("attribute vec4 aPosition;\nattribute vec4 aTexCoord;\nvarying   vec2 vTexCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTexCoord   = aTexCoord.xy;\n}\n", "precision mediump float;\nuniform sampler2D uSampler;\nvarying vec2      vTexCoord;\nvoid main() {\n  gl_FragColor = texture2D(uSampler, vTexCoord);\n}\n");
    this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
    this.maTexCoordHandle = GLES20.glGetAttribLocation(this.mProgram, "aTexCoord");
    this.muSamplerHandle = GLES20.glGetUniformLocation(this.mProgram, "uSampler");
    GLES20.glDisable(2929);
    GLES20.glDisable(2884);
    GLES20.glDisable(3042);
    GlUtil.checkGlError("initGL_E");
  }
  
  private void restoreRenderState()
  {
    if (!EGL14.eglMakeCurrent(this.mSavedEglDisplay, this.mSavedEglDrawSurface, this.mSavedEglReadSurface, this.mSavedEglContext)) {
      Log.e(TAG, "eglMakeCurrent failed");
    }
  }
  
  private void saveRenderState()
  {
    this.mSavedEglDisplay = EGL14.eglGetCurrentDisplay();
    this.mSavedEglDrawSurface = EGL14.eglGetCurrentSurface(12377);
    this.mSavedEglReadSurface = EGL14.eglGetCurrentSurface(12378);
    this.mSavedEglContext = EGL14.eglGetCurrentContext();
  }
  
  public void draw()
  {
    GLES20.glFinish();
    saveRenderState();
    GlUtil.checkGlError("draw_S");
    this.mEncoderSurface.makeCurrent();
    GLES20.glViewport(0, 0, this.mFboTexW, this.mFboTexH);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.mProgram);
    this.mVtxBuf.position(0);
    GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mVtxBuf);
    GLES20.glEnableVertexAttribArray(this.maPositionHandle);
    this.mVtxBuf.position(3);
    GLES20.glVertexAttribPointer(this.maTexCoordHandle, 2, 5126, false, 20, this.mVtxBuf);
    GLES20.glEnableVertexAttribArray(this.maTexCoordHandle);
    GLES20.glUniform1i(this.muSamplerHandle, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.mFboTexId);
    GLES20.glDrawArrays(5, 0, 4);
    this.mEncoderSurface.swapBuffers();
    GlUtil.checkGlError("draw_E");
    restoreRenderState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.encode.hard.SurfaceRender
 * JD-Core Version:    0.7.0.1
 */