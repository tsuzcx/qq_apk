package com.tencent.tavkit.resample;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.IAVResample;
import java.nio.ByteBuffer;

public class TAVResample
  implements IAVResample
{
  private static final String TAG = "TAVResample";
  private long context;
  
  static
  {
    System.loadLibrary("tav-resample");
  }
  
  public TAVResample(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.context = nativeSetup(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private native void nativeRelease(long paramLong);
  
  private native byte[] nativeResample(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native byte[] nativeResampleByByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native long nativeSetup(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void updateSrcFormat(long paramLong, int paramInt1, int paramInt2);
  
  public void release()
  {
    nativeRelease(this.context);
    this.context = -1L;
  }
  
  @Nullable
  public byte[] resample(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramByteBuffer.isDirect()) {
      return nativeResample(this.context, paramByteBuffer, paramInt);
    }
    return nativeResampleByByteArray(this.context, paramByteBuffer.array(), paramInt);
  }
  
  public byte[] resample(byte[] paramArrayOfByte, int paramInt)
  {
    return nativeResampleByByteArray(this.context, paramArrayOfByte, paramInt);
  }
  
  public void updateSrcFormat(int paramInt1, int paramInt2)
  {
    updateSrcFormat(this.context, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.resample.TAVResample
 * JD-Core Version:    0.7.0.1
 */