package com.tencent.mobileqq.minigame.task;

import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;

class GpkgLoadAsyncTask$1$1
  implements Runnable
{
  GpkgLoadAsyncTask$1$1(GpkgLoadAsyncTask.1 param1) {}
  
  public void run()
  {
    MiniAppFileManager.getInstance().deleteTmpFileNeed2DeleteAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask.1.1
 * JD-Core Version:    0.7.0.1
 */