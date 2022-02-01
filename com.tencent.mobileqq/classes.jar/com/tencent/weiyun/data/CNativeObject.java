package com.tencent.weiyun.data;

class CNativeObject
{
  protected static final int INVALID_NATIVE_PTR = 0;
  protected long nativePtr = 0L;
  
  protected CNativeObject(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  protected boolean isNative()
  {
    return this.nativePtr != 0L;
  }
  
  public void releaseNative()
  {
    long l = this.nativePtr;
    if (l != 0L)
    {
      this.nativePtr = 0L;
      CBundleReader.deleteBundle(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.data.CNativeObject
 * JD-Core Version:    0.7.0.1
 */