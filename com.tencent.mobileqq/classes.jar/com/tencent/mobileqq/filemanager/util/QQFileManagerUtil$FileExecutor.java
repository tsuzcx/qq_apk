package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class QQFileManagerUtil$FileExecutor
{
  static Executor a;
  
  static
  {
    ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
    localThreadPoolParams.poolThreadName = "fileassistant_pool";
    localThreadPoolParams.corePoolsize = 2;
    localThreadPoolParams.maxPooolSize = 2;
    localThreadPoolParams.priority = 8;
    localThreadPoolParams.queue = new LinkedBlockingQueue();
    localThreadPoolParams.keepAliveTime = 10;
    a = ThreadManager.newFreeThreadPool(localThreadPoolParams);
  }
  
  public static Executor a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor
 * JD-Core Version:    0.7.0.1
 */