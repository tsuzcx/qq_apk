package com.tencent.vbox.decode;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.vbox.egl.EglHelper;
import com.tencent.vbox.util.FrameUtil;
import com.tencent.vbox.util.VMeasure;
import java.nio.ByteBuffer;

public class VboxRgbDecoder
  extends VboxDecoder
{
  public static final String TAG = VboxRgbDecoder.class.getSimpleName();
  private BaseFilter copyFilter;
  private EglHelper eglHelper;
  private Frame frame = new Frame();
  private long handler;
  private byte[] rgb;
  private int[] rgbTexture = new int[1];
  private int rgbaTexture;
  private int[] tid;
  
  public VboxRgbDecoder(String paramString)
  {
    int[] arrayOfInt = new int[2];
    this.handler = initDecoder(paramString, arrayOfInt);
    this.width = arrayOfInt[0];
    this.height = arrayOfInt[1];
    this.rotation = getRotation(this.handler);
    if (this.rotation / 90 % 2 != 0)
    {
      this.rotatedHeight = this.width;
      this.rotatedWidth = this.height;
    }
    for (;;)
    {
      this.rgb = new byte[this.width * this.height * 3];
      this.index = -1;
      return;
      this.rotatedWidth = this.width;
      this.rotatedHeight = this.height;
    }
  }
  
  private native int getFrame(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native int getRotation(long paramLong);
  
  private native long initDecoder(String paramString, int[] paramArrayOfInt);
  
  private void initYuv24ToRgbFilter()
  {
    this.copyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
    this.copyFilter.apply();
    this.copyFilter.setRotationAndFlip(-this.rotation, 0, 0);
  }
  
  private native void releaseDecoder(long paramLong);
  
  private void rgbToRGBATexture()
  {
    VMeasure.start();
    GLES20.glBindTexture(3553, this.rgbTexture[0]);
    GLES20.glTexImage2D(3553, 0, 6407, this.width, this.height, 0, 6407, 5121, ByteBuffer.wrap(this.rgb));
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    Log.v(TAG, "upload cost " + VMeasure.cost());
    VMeasure.start();
    this.copyFilter.RenderProcess(this.rgbTexture[0], this.width, this.height, this.rotatedWidth, this.rotatedHeight, this.rgbaTexture, 0.0D, this.frame);
    Log.v(TAG, "render process cost " + VMeasure.cost());
  }
  
  public int getFrameBytes(int paramInt)
  {
    this.eglHelper.saveRenderState();
    this.eglHelper.makeCurrent();
    int i = getFrame(this.handler, this.rgb, paramInt);
    rgbToRGBATexture();
    FrameUtil.textureToRgba(this.rgbaTexture, this.rotatedWidth, this.rotatedHeight, this.rgba);
    this.eglHelper.restoreRenderState();
    this.index = paramInt;
    return i;
  }
  
  public int getFrameTexture(int paramInt)
  {
    int i = getFrame(this.handler, this.rgb, paramInt);
    rgbToRGBATexture();
    this.index = paramInt;
    return i;
  }
  
  public int getNextFrameBytes()
  {
    this.index += 1;
    return getFrameBytes(this.index);
  }
  
  public int getNextFrameTexture()
  {
    this.index += 1;
    return getFrameTexture(this.index);
  }
  
  public void releaseDecoder()
  {
    if (this.tid != null) {
      GLES20.glDeleteTextures(this.tid.length, this.tid, 0);
    }
    GLES20.glDeleteTextures(this.rgbTexture.length, this.rgbTexture, 0);
    if (this.eglHelper != null)
    {
      this.eglHelper.saveRenderState();
      this.eglHelper.makeCurrent();
      this.eglHelper.destroy();
      this.eglHelper.restoreRenderState();
      this.eglHelper = null;
    }
    if (this.copyFilter != null) {
      this.copyFilter.clearGLSLSelf();
    }
    if (this.frame != null) {
      this.frame.clear();
    }
    releaseDecoder(this.handler);
  }
  
  public void setBytes(byte[] paramArrayOfByte)
  {
    this.rgba = paramArrayOfByte;
    this.eglHelper = new EglHelper();
    this.eglHelper.setup();
    this.eglHelper.saveRenderState();
    this.eglHelper.makeCurrent();
    this.tid = new int[2];
    GLES20.glGenTextures(this.tid.length, this.tid, 0);
    this.rgbTexture[0] = this.tid[0];
    this.rgbaTexture = this.tid[1];
    initYuv24ToRgbFilter();
    this.eglHelper.restoreRenderState();
  }
  
  public void setTexture(int paramInt)
  {
    this.rgbaTexture = paramInt;
    GLES20.glGenTextures(this.rgbTexture.length, this.rgbTexture, 0);
    initYuv24ToRgbFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.decode.VboxRgbDecoder
 * JD-Core Version:    0.7.0.1
 */