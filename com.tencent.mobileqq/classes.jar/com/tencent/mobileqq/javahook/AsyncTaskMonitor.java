package com.tencent.mobileqq.javahook;

import android.os.AsyncTask;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class AsyncTaskMonitor
{
  private static Map<AsyncTask, AsyncTaskMonitor.AsyncTaskMonitorResult> jdField_a_of_type_JavaUtilMap;
  private static Set<Class> jdField_a_of_type_JavaUtilSet = new HashSet();
  private static Set<Class> b = new HashSet();
  
  static
  {
    try
    {
      Class localClass1 = Class.forName("com.tencent.image.NativeGifImage$NativeDecodeFrameTask");
      Class localClass2 = Class.forName("com.tencent.image.NativeGifIndex8$NativeDecodeFrameTask");
      Class localClass3 = Class.forName("com.tencent.mobileqq.vas.PendantInfo$DecodeNextFrameTask");
      b.add(localClass1);
      b.add(localClass2);
      b.add(localClass3);
      jdField_a_of_type_JavaUtilMap = new WeakHashMap();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
  }
  
  private static void b(AsyncTask paramAsyncTask, AsyncTaskMonitor.AsyncTaskMonitorResult paramAsyncTaskMonitorResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncTask Log : ");
      localStringBuilder.append("class = ").append(paramAsyncTask.getClass().getName()).append(" ; ");
      localStringBuilder.append("thread name = ").append(paramAsyncTaskMonitorResult.jdField_a_of_type_JavaLangString).append(" ; ");
      localStringBuilder.append("wait time = ").append(paramAsyncTaskMonitorResult.b - paramAsyncTaskMonitorResult.jdField_a_of_type_Long).append(" ; ");
      localStringBuilder.append("doInBackground cost time = ").append(paramAsyncTaskMonitorResult.c - paramAsyncTaskMonitorResult.b).append(" ; ");
      QLog.d("AsyncTaskMonitor", 2, localStringBuilder.toString());
    }
  }
  
  private static void b(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "doInBackground", new Object[] { [Ljava.lang.Object.class, new AsyncTaskMonitor.2() });
      return;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.AsyncTaskMonitor
 * JD-Core Version:    0.7.0.1
 */