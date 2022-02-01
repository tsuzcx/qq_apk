package com.tencent.xweb.skia_canvas;

class NativeRunnable
  implements Runnable
{
  private boolean mHasRun;
  private final long mNativePeer;
  
  private NativeRunnable(long paramLong)
  {
    this.mNativePeer = paramLong;
  }
  
  static NativeRunnable Create(long paramLong)
  {
    return new NativeRunnable(paramLong);
  }
  
  private native void releaseNative(long paramLong);
  
  private native void runNative(long paramLong);
  
  protected void finalize()
  {
    super.finalize();
    if (!this.mHasRun) {
      releaseNative(this.mNativePeer);
    }
  }
  
  public void run()
  {
    if (!this.mHasRun)
    {
      runNative(this.mNativePeer);
      releaseNative(this.mNativePeer);
      this.mHasRun = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.NativeRunnable
 * JD-Core Version:    0.7.0.1
 */