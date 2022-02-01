package com.tencent.qqmusic.mediaplayer;

class CommonPlayer$1
  implements QMThreadExecutor
{
  public void execute(Runnable paramRunnable, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    paramRunnable = new Thread(paramRunnable, "decoder");
    paramRunnable.setUncaughtExceptionHandler(paramUncaughtExceptionHandler);
    paramRunnable.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.1
 * JD-Core Version:    0.7.0.1
 */