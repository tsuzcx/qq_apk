package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.tfs.mini.ServiceInitAsyncTask;

class AppLoaderManager$1
  implements Runnable
{
  AppLoaderManager$1(AppLoaderManager paramAppLoaderManager) {}
  
  public void run()
  {
    this.this$0.serviceInitTask.doOnServiceError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */