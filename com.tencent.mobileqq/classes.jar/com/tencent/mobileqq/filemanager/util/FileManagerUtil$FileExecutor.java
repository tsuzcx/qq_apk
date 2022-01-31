package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class FileManagerUtil$FileExecutor
{
  static Executor a;
  
  static
  {
    ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
    localThreadPoolParams.jdField_a_of_type_JavaLangString = "fileassistant_pool";
    localThreadPoolParams.b = 2;
    localThreadPoolParams.c = 2;
    localThreadPoolParams.jdField_a_of_type_Int = 8;
    localThreadPoolParams.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
    localThreadPoolParams.d = 10;
    a = ThreadManager.newFreeThreadPool(localThreadPoolParams);
  }
  
  public static Executor a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor
 * JD-Core Version:    0.7.0.1
 */