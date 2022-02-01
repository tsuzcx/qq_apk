package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.FBO;
import java.util.LinkedList;

public abstract class BaseRenderObj
{
  protected static final String TAG = "BaseRenderObj";
  private final LinkedList<Runnable> mPreDrawTaskList = new LinkedList();
  protected int surfaceHeight;
  protected int surfaceWidth;
  
  public void addPreDrawTask(Runnable paramRunnable)
  {
    synchronized (this.mPreDrawTaskList)
    {
      this.mPreDrawTaskList.addLast(paramRunnable);
      return;
    }
  }
  
  public FBO createFBO()
  {
    return FBO.newInstance().create(this.surfaceWidth, this.surfaceHeight);
  }
  
  public abstract void destroy();
  
  public abstract void init();
  
  public abstract void onDrawFrame(int paramInt);
  
  public void onPreDrawElements()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
  }
  
  public void onRenderObjChanged(int paramInt1, int paramInt2)
  {
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
  }
  
  public void runPreDrawTasks()
  {
    while (!this.mPreDrawTaskList.isEmpty()) {
      ((Runnable)this.mPreDrawTaskList.removeFirst()).run();
    }
  }
  
  public void setUniform1f(int paramInt, String paramString, float paramFloat)
  {
    GLES20.glUniform1f(GLES20.glGetUniformLocation(paramInt, paramString), paramFloat);
  }
  
  void setViewport()
  {
    GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.BaseRenderObj
 * JD-Core Version:    0.7.0.1
 */