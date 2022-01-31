package com.tencent.qq.effect.alphavideo.videoplayer.view;

class GLTextureView$GLThreadManager
{
  private static String TAG = "GLThreadManager";
  private static final int kGLES_20 = 131072;
  private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
  private GLTextureView.GLThread mEglOwner;
  private boolean mGLESDriverCheckComplete;
  private int mGLESVersion;
  private boolean mGLESVersionCheckComplete;
  private boolean mLimitedGLESContexts;
  private boolean mMultipleGLESContextsAllowed;
  
  private void checkGLESVersion()
  {
    if (!this.mGLESVersionCheckComplete)
    {
      this.mGLESVersion = GLTextureView.access$700();
      if (this.mGLESVersion >= 131072) {
        this.mMultipleGLESContextsAllowed = true;
      }
      this.mGLESVersionCheckComplete = true;
    }
  }
  
  /* Error */
  public void checkGLDriver(javax.microedition.khronos.opengles.GL10 paramGL10)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 49	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:mGLESDriverCheckComplete	Z
    //   8: ifne +65 -> 73
    //   11: aload_0
    //   12: invokespecial 51	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:checkGLESVersion	()V
    //   15: aload_1
    //   16: sipush 7937
    //   19: invokeinterface 57 2 0
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 43	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:mGLESVersion	I
    //   29: ldc 9
    //   31: if_icmpge +23 -> 54
    //   34: aload_1
    //   35: ldc 12
    //   37: invokevirtual 63	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   40: ifne +36 -> 76
    //   43: iconst_1
    //   44: istore_2
    //   45: aload_0
    //   46: iload_2
    //   47: putfield 45	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:mMultipleGLESContextsAllowed	Z
    //   50: aload_0
    //   51: invokevirtual 66	java/lang/Object:notifyAll	()V
    //   54: aload_0
    //   55: getfield 45	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:mMultipleGLESContextsAllowed	Z
    //   58: ifne +23 -> 81
    //   61: iload_3
    //   62: istore_2
    //   63: aload_0
    //   64: iload_2
    //   65: putfield 68	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:mLimitedGLESContexts	Z
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 49	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:mGLESDriverCheckComplete	Z
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: iconst_0
    //   77: istore_2
    //   78: goto -33 -> 45
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	GLThreadManager
    //   0	91	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   44	39	2	bool1	boolean
    //   1	61	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	43	86	finally
    //   45	54	86	finally
    //   54	61	86	finally
    //   63	73	86	finally
  }
  
  public void releaseEglContextLocked(GLTextureView.GLThread paramGLThread)
  {
    if (this.mEglOwner == paramGLThread) {
      this.mEglOwner = null;
    }
    notifyAll();
  }
  
  public boolean shouldReleaseEGLContextWhenPausing()
  {
    try
    {
      boolean bool = this.mLimitedGLESContexts;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean shouldTerminateEGLWhenPausing()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 51	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:checkGLESVersion	()V
    //   6: aload_0
    //   7: getfield 45	com/tencent/qq/effect/alphavideo/videoplayer/view/GLTextureView$GLThreadManager:mMultipleGLESContextsAllowed	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifne +9 -> 21
    //   15: iconst_1
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	GLThreadManager
    //   10	13	1	bool	boolean
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
  
  public void threadExiting(GLTextureView.GLThread paramGLThread)
  {
    try
    {
      GLTextureView.GLThread.access$602(paramGLThread, true);
      if (this.mEglOwner == paramGLThread) {
        this.mEglOwner = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  public boolean tryAcquireEglContextLocked(GLTextureView.GLThread paramGLThread)
  {
    if ((this.mEglOwner != paramGLThread) && (this.mEglOwner != null))
    {
      checkGLESVersion();
      if (this.mMultipleGLESContextsAllowed) {
        return true;
      }
      if (this.mEglOwner != null) {
        this.mEglOwner.requestReleaseEglContextLocked();
      }
      return false;
    }
    this.mEglOwner = paramGLThread;
    notifyAll();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.GLTextureView.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */