package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

abstract interface RunnableHandler
{
  public abstract void postRunnable(Runnable paramRunnable);
  
  public abstract void runnableFailAndReleaseCache();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.RunnableHandler
 * JD-Core Version:    0.7.0.1
 */