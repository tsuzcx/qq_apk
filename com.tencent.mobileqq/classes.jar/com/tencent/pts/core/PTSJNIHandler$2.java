package com.tencent.pts.core;

final class PTSJNIHandler$2
  implements Runnable
{
  PTSJNIHandler$2(long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3) {}
  
  public void run()
  {
    PTSJNIHandler.access$100(this.val$callbackPtr, this.val$statusCode, this.val$buffer, this.val$bufferLength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.PTSJNIHandler.2
 * JD-Core Version:    0.7.0.1
 */