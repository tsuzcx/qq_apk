package com.tencent.ttpic.recorder;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.util.LogUtil;
import com.tencent.vtool.SoftVideoDecoder;
import java.nio.ByteBuffer;

public class SoftwareDecoder
  implements IVideoDecoder
{
  private static final String TAG = SoftwareDecoder.class.getSimpleName();
  private final SoftVideoDecoder mDecoder;
  private boolean mNeedUpdate = false;
  private final int mTexture;
  private final Object mUpdateLock = new Object();
  private byte[][] mVideoFrameData = new byte[2][];
  private int mVideoFrameDataIndex = 0;
  
  static
  {
    System.loadLibrary("soft_decoder");
  }
  
  public SoftwareDecoder(String paramString, int paramInt)
  {
    Log.i(TAG, "file name: " + paramString);
    this.mDecoder = new SoftVideoDecoder(paramString);
    this.mTexture = paramInt;
  }
  
  public void decodeFrame(long paramLong)
  {
    synchronized (this.mUpdateLock)
    {
      int i = (this.mVideoFrameDataIndex + 1) % this.mVideoFrameData.length;
      byte[] arrayOfByte2 = this.mVideoFrameData[i];
      byte[] arrayOfByte1;
      if (arrayOfByte2 != null)
      {
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2.length == getWidth() * getHeight() * 4) {}
      }
      else
      {
        arrayOfByte1 = new byte[getWidth() * getHeight() * 4];
      }
      this.mDecoder.getRGBFrame(arrayOfByte1, paramLong);
      this.mVideoFrameData[i] = arrayOfByte1;
      this.mVideoFrameDataIndex = i;
      this.mNeedUpdate = true;
      return;
    }
  }
  
  public long getDuration()
  {
    return this.mDecoder.getDuration();
  }
  
  public int getHeight()
  {
    return this.mDecoder.getHeight();
  }
  
  public int getRotation()
  {
    return this.mDecoder.getRotation();
  }
  
  public int getWidth()
  {
    return this.mDecoder.getWidth();
  }
  
  public boolean isLive()
  {
    return this.mDecoder.isLive();
  }
  
  public void release()
  {
    Object localObject1 = this.mUpdateLock;
    int i = 0;
    try
    {
      while (i < this.mVideoFrameData.length)
      {
        this.mVideoFrameData[i] = null;
        i += 1;
      }
      this.mDecoder.release();
      return;
    }
    finally {}
  }
  
  public void reset()
  {
    seek(0L);
  }
  
  public int seek(long paramLong)
  {
    return this.mDecoder.seek(paramLong);
  }
  
  public void updateFrame()
  {
    synchronized (this.mUpdateLock)
    {
      if ((this.mVideoFrameData[this.mVideoFrameDataIndex] != null) && (this.mVideoFrameData[this.mVideoFrameDataIndex].length == getWidth() * getHeight() * 4))
      {
        if (this.mNeedUpdate)
        {
          this.mNeedUpdate = false;
          GLES20.glActiveTexture(33988);
          GLES20.glBindTexture(3553, this.mTexture);
          GLES20.glTexImage2D(3553, 0, 6407, getWidth(), getHeight(), 0, 6407, 5121, ByteBuffer.wrap(this.mVideoFrameData[this.mVideoFrameDataIndex]));
          GLES20.glTexParameteri(3553, 10240, 9729);
          GLES20.glTexParameteri(3553, 10241, 9729);
          GLES20.glTexParameteri(3553, 10242, 33071);
          GLES20.glTexParameteri(3553, 10243, 33071);
        }
        return;
      }
      LogUtil.e(TAG, "mVideoFrameData[mVideoFrameDataIndex] is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.SoftwareDecoder
 * JD-Core Version:    0.7.0.1
 */