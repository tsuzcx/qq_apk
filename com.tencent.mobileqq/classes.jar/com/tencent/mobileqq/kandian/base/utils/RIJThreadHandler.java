package com.tencent.mobileqq.kandian.base.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public class RIJThreadHandler
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static ReadInJoySSOHandlerThread jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadInJoySSOHandlerThread;
  private static String jdField_a_of_type_JavaLangString = null;
  private static Queue<Integer> jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
  private static Handler b;
  
  public static Handler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadInJoySSOHandlerThread == null)
      {
        jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadInJoySSOHandlerThread = new ReadInJoySSOHandlerThread("kandian_network_thread");
        jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadInJoySSOHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsReadInJoySSOHandlerThread.getLooper());
      }
      Handler localHandler = jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  public static String a()
  {
    String str2 = jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "0";
    }
    return str1;
  }
  
  public static List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = jdField_a_of_type_JavaUtilQueue;
    if (localObject != null)
    {
      localObject = ((Queue)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((Integer)((Iterator)localObject).next());
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    Queue localQueue = jdField_a_of_type_JavaUtilQueue;
    if (localQueue != null) {
      localQueue.clear();
    }
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilQueue == null) {
      jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
    }
    if (!jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt)))
    {
      jdField_a_of_type_JavaUtilQueue.poll();
      jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    }
  }
  
  public static void a(long paramLong)
  {
    a();
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static void a(String paramString, Runnable paramRunnable, ExecutorService paramExecutorService)
  {
    if ((paramExecutorService != null) && (!paramExecutorService.isShutdown()))
    {
      paramExecutorService.execute(paramRunnable);
      return;
    }
    QLog.d("RIJThreadHandler", 2, new Object[] { paramString, " runInSubThread failed, executorService is null or shutdown." });
  }
  
  public static boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static Handler b()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new Handler(Looper.getMainLooper());
        }
      }
      finally {}
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler
 * JD-Core Version:    0.7.0.1
 */