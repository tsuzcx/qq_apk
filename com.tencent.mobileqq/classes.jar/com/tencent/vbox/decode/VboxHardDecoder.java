package com.tencent.vbox.decode;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.vbox.egl.EglHelper;
import com.tencent.vbox.util.FrameUtil;
import java.lang.reflect.Field;

public class VboxHardDecoder
  extends VboxDecoder
{
  public static final String TAG = VboxHardDecoder.class.getSimpleName();
  private EglHelper eglHelper;
  private Frame frame = new Frame();
  private final float[] mSTMatrix = new float[16];
  private MediaCodecDecoder mediaCodecDecoder;
  private int oesTexture;
  private Field onFrameAvailableHandlerField;
  private int rgbaTexture;
  private Handler stHandler = null;
  private SurfaceTexture surfaceTexture;
  private SurfaceTextureFilter surfaceTextureFilter;
  int[] tid;
  
  public VboxHardDecoder(String paramString)
  {
    this.mediaCodecDecoder = new MediaCodecDecoder(paramString);
    this.width = this.mediaCodecDecoder.getWidth();
    this.height = this.mediaCodecDecoder.getHeight();
    this.rotation = this.mediaCodecDecoder.getRotation();
    if (this.rotation / 90 % 2 != 0)
    {
      this.rotatedHeight = this.width;
      this.rotatedWidth = this.height;
      return;
    }
    this.rotatedWidth = this.width;
    this.rotatedHeight = this.height;
  }
  
  private void init()
  {
    this.surfaceTexture = new SurfaceTexture(this.oesTexture);
    this.surfaceTexture.setOnFrameAvailableListener(new VboxHardDecoder.1(this));
    this.mediaCodecDecoder.setSurface(new Surface(this.surfaceTexture));
    this.mediaCodecDecoder.start();
    this.surfaceTextureFilter = new SurfaceTextureFilter();
    this.surfaceTextureFilter.applyFilterChain(false, 0.0F, 0.0F);
    try
    {
      this.onFrameAvailableHandlerField = SurfaceTexture.class.getDeclaredField("mOnFrameAvailableHandler");
      this.onFrameAvailableHandlerField.setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      for (;;)
      {
        try
        {
          this.stHandler = ((Handler)this.onFrameAvailableHandlerField.get(this.surfaceTexture));
          return;
        }
        catch (Exception localException) {}
        localNoSuchFieldException1 = localNoSuchFieldException1;
        Log.e(TAG, "onFrameAvailableHandlerField 'mOnFrameAvailableHandler' could not be found");
        try
        {
          this.onFrameAvailableHandlerField = SurfaceTexture.class.getDeclaredField("mEventHandler");
          this.onFrameAvailableHandlerField.setAccessible(true);
          Log.i(TAG, "onFrameAvailableHandlerField 'mEventHandler' found");
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          Log.e(TAG, "onFrameAvailableHandlerField 'mEventHandler' could not be found");
        }
      }
    }
  }
  
  private int obtain()
  {
    int i = 0;
    int j = i;
    try
    {
      if (!this.stHandler.hasMessages(0))
      {
        i += 1;
        j = i;
        Thread.sleep(1L);
        j = i;
      }
      else
      {
        j = i;
        this.stHandler.removeMessages(0);
        j = i;
        Log.i(TAG, "has message, count = " + i);
      }
    }
    catch (Exception localException) {}
    do
    {
      this.surfaceTexture.updateTexImage();
      this.surfaceTexture.getTransformMatrix(this.mSTMatrix);
      this.surfaceTextureFilter.updateMatrix(this.mSTMatrix);
      this.surfaceTextureFilter.setRotationAndFlip(180 - this.rotation, 1, 0);
      this.surfaceTextureFilter.RenderProcess(this.oesTexture, this.width, this.height, this.rotatedWidth, this.rotatedHeight, this.rgbaTexture, 0.0D, this.frame);
      return 0;
      i = j;
      if (j < 1000) {
        break;
      }
      i = j;
    } while (i < 1000);
    return -1;
  }
  
  public int getFrameBytes(int paramInt)
  {
    int i = this.mediaCodecDecoder.decodeNext(paramInt);
    if (i < 0) {
      return i;
    }
    this.eglHelper.saveRenderState();
    this.eglHelper.makeCurrent();
    i = obtain();
    if (i == 0)
    {
      FrameUtil.textureToRgba(this.rgbaTexture, this.rotatedWidth, this.rotatedHeight, this.rgba);
      this.index = paramInt;
    }
    this.eglHelper.restoreRenderState();
    return i;
  }
  
  public int getFrameTexture(int paramInt)
  {
    this.mediaCodecDecoder.decodeNext(paramInt);
    int i = obtain();
    if (i == 0) {
      this.index = paramInt;
    }
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
    if (this.eglHelper != null)
    {
      this.eglHelper.saveRenderState();
      this.eglHelper.makeCurrent();
      this.eglHelper.destroy();
      this.eglHelper.restoreRenderState();
      this.eglHelper = null;
    }
    if (this.frame != null) {
      this.frame.clear();
    }
    if (this.surfaceTextureFilter != null) {
      this.surfaceTextureFilter.clearGLSLSelf();
    }
    if (this.surfaceTexture != null) {
      this.surfaceTexture.release();
    }
    if (this.tid != null) {
      GLES20.glDeleteTextures(this.tid.length, this.tid, 0);
    }
    this.mediaCodecDecoder.release();
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
    this.oesTexture = this.tid[0];
    this.rgbaTexture = this.tid[1];
    init();
    this.eglHelper.restoreRenderState();
  }
  
  public void setTexture(int paramInt)
  {
    this.rgbaTexture = paramInt;
    this.tid = new int[1];
    GLES20.glGenTextures(this.tid.length, this.tid, 0);
    this.oesTexture = this.tid[0];
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.decode.VboxHardDecoder
 * JD-Core Version:    0.7.0.1
 */