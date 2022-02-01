package com.tencent.qg.sdk;

class QGJavaScriptView$GLThreadManager
{
  private static String TAG = "GLThreadManager";
  
  public void releaseEglContextLocked(QGJavaScriptView.GLThread paramGLThread)
  {
    notifyAll();
  }
  
  public void threadExiting(QGJavaScriptView.GLThread paramGLThread)
  {
    try
    {
      QGJavaScriptView.GLThread.access$202(paramGLThread, true);
      notifyAll();
      return;
    }
    finally
    {
      paramGLThread = finally;
      throw paramGLThread;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */