package com.tencent.qq.effect.alphavideo.videoplayer.view;

import javax.microedition.khronos.opengles.GL10;

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
  
  public void checkGLDriver(GL10 paramGL10)
  {
    for (;;)
    {
      try
      {
        if (!this.mGLESDriverCheckComplete)
        {
          checkGLESVersion();
          paramGL10 = paramGL10.glGetString(7937);
          int i = this.mGLESVersion;
          boolean bool2 = false;
          if (i < 131072)
          {
            if (!paramGL10.startsWith("Q3Dimension MSM7500 "))
            {
              bool1 = true;
              this.mMultipleGLESContextsAllowed = bool1;
              notifyAll();
            }
          }
          else
          {
            bool1 = bool2;
            if (!this.mMultipleGLESContextsAllowed) {
              bool1 = true;
            }
            this.mLimitedGLESContexts = bool1;
            this.mGLESDriverCheckComplete = true;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
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
  
  public boolean shouldTerminateEGLWhenPausing()
  {
    try
    {
      checkGLESVersion();
      boolean bool = this.mMultipleGLESContextsAllowed;
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    GLTextureView.GLThread localGLThread = this.mEglOwner;
    if ((localGLThread != paramGLThread) && (localGLThread != null))
    {
      checkGLESVersion();
      if (this.mMultipleGLESContextsAllowed) {
        return true;
      }
      paramGLThread = this.mEglOwner;
      if (paramGLThread != null) {
        paramGLThread.requestReleaseEglContextLocked();
      }
      return false;
    }
    this.mEglOwner = paramGLThread;
    notifyAll();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.GLTextureView.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */