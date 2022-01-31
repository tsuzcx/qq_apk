package com.tencent.vbox.encode;

import android.util.Log;
import com.tencent.vbox.util.FrameUtil;
import java.io.File;

public class VboxSoftEncoder
  extends VboxEncoder
{
  public static final String TAG = VboxSoftEncoder.class.getSimpleName();
  private long handler;
  private int height;
  private boolean initialized = false;
  private String path;
  private byte[] rgba;
  private int width;
  
  public VboxSoftEncoder(String paramString, int paramInt1, int paramInt2)
  {
    this.handler = initEncoder(paramString, paramInt1, paramInt2);
    this.path = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    if (this.handler == 0L)
    {
      this.initialized = false;
      return;
    }
    this.initialized = true;
  }
  
  private native long initEncoder(String paramString, int paramInt1, int paramInt2);
  
  private native boolean optimize(String paramString1, String paramString2);
  
  private native int releaseEncoder(long paramLong);
  
  private native int writeFrame(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  public void release()
  {
    if (!this.initialized) {
      return;
    }
    releaseEncoder(this.handler);
    Log.i(TAG, "soft encoder release over");
    Log.i(TAG, "optimize file");
    String str = this.path + ".optimized";
    if (optimize(this.path, str))
    {
      new File(this.path).delete();
      new File(str).renameTo(new File(this.path));
    }
    this.initialized = false;
  }
  
  public int writeFrame(int paramInt, long paramLong)
  {
    if (!this.initialized) {
      return -1;
    }
    if ((this.rgba == null) || (this.rgba.length == 0)) {
      this.rgba = new byte[this.width * this.height * 4];
    }
    FrameUtil.textureToRgba(paramInt, this.width, this.height, this.rgba);
    writeFrame(this.handler, this.rgba, paramLong);
    return 0;
  }
  
  public int writeFrame(byte[] paramArrayOfByte, long paramLong)
  {
    if (!this.initialized) {
      return -1;
    }
    return writeFrame(this.handler, paramArrayOfByte, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.encode.VboxSoftEncoder
 * JD-Core Version:    0.7.0.1
 */