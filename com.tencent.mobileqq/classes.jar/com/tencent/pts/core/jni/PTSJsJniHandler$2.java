package com.tencent.pts.core.jni;

final class PTSJsJniHandler$2
  implements Runnable
{
  PTSJsJniHandler$2(long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3) {}
  
  public void run()
  {
    PTSJsJniHandler.access$100(this.val$callbackPtr, this.val$statusCode, this.val$buffer, this.val$bufferLength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.jni.PTSJsJniHandler.2
 * JD-Core Version:    0.7.0.1
 */