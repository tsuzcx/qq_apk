package com.tencent.vbox.encode;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.vbox.egl.EglHelper;
import com.tencent.vbox.encode.hard.VideoGenerator;
import java.nio.ByteBuffer;

public class VboxHardEncoder
  extends VboxEncoder
{
  public static final String TAG = VboxHardEncoder.class.getSimpleName();
  private EglHelper eglHelper;
  private Frame frame;
  private int height;
  private boolean initialized;
  private int texture;
  private BaseFilter updownFilter;
  private int updownTexture;
  private VideoGenerator videoGenerator;
  private int width;
  
  public VboxHardEncoder(String paramString, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.videoGenerator = new VideoGenerator(paramString, paramInt1, paramInt2);
  }
  
  private void init()
  {
    int[] arrayOfInt = new int[2];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.texture = arrayOfInt[0];
    this.updownTexture = arrayOfInt[1];
    this.videoGenerator.prepare(this.updownTexture);
    this.frame = new Frame();
    this.updownFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
    this.updownFilter.applyFilterChain(false, 0.0F, 0.0F);
    this.updownFilter.setRotationAndFlip(180, 1, 0);
  }
  
  public void release()
  {
    GLES20.glDeleteTextures(2, new int[] { this.texture, this.updownTexture }, 0);
    this.frame.clear();
    this.updownFilter.ClearGLSL();
    this.videoGenerator.stop();
    if (this.eglHelper != null)
    {
      this.eglHelper.saveRenderState();
      this.eglHelper.makeCurrent();
      this.eglHelper.destroy();
      this.eglHelper.restoreRenderState();
      this.eglHelper = null;
    }
    Log.i(TAG, "hard encoder release over");
  }
  
  public int writeFrame(int paramInt, long paramLong)
  {
    if (!this.initialized)
    {
      init();
      this.initialized = true;
    }
    this.updownFilter.RenderProcess(paramInt, this.width, this.height, this.updownTexture, 0.0D, this.frame);
    this.videoGenerator.encodeFrame(paramLong);
    return 0;
  }
  
  public int writeFrame(byte[] paramArrayOfByte, long paramLong)
  {
    if (!this.initialized)
    {
      this.eglHelper = new EglHelper();
      this.eglHelper.setup();
      this.eglHelper.saveRenderState();
      this.eglHelper.makeCurrent();
      init();
      this.eglHelper.restoreRenderState();
      this.initialized = true;
    }
    this.eglHelper.saveRenderState();
    this.eglHelper.makeCurrent();
    GLES20.glBindTexture(3553, this.texture);
    GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    this.updownFilter.RenderProcess(this.texture, this.width, this.height, this.updownTexture, 0.0D, this.frame);
    this.videoGenerator.encodeFrame(paramLong);
    this.eglHelper.restoreRenderState();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.encode.VboxHardEncoder
 * JD-Core Version:    0.7.0.1
 */