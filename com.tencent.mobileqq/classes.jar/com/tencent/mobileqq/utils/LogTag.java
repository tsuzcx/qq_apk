package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class LogTag
{
  private static ThreadLocal<LinkedList<Long>> a = new ThreadLocal();
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      LinkedList localLinkedList2 = (LinkedList)a.get();
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        a.set(localLinkedList1);
      }
      localLinkedList1.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      Object localObject2 = (LinkedList)a.get();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedList();
        a.set(localObject1);
        ((LinkedList)localObject1).addFirst(Long.valueOf(SystemClock.uptimeMillis()));
      }
      localObject2 = new StringBuilder();
      int i = 1;
      while (i < ((LinkedList)localObject1).size())
      {
        ((StringBuilder)localObject2).append("    ");
        i += 1;
      }
      if (((LinkedList)a.get()).size() == 0) {
        return;
      }
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(":cost ");
      ((StringBuilder)localObject2).append(SystemClock.uptimeMillis() - ((Long)((LinkedList)a.get()).removeFirst()).longValue());
      ((StringBuilder)localObject2).append("ms");
      QLog.i(paramString1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("PreUploadVideo");
      localStringBuilder.append("[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("] ");
      if (paramString2 != null)
      {
        localStringBuilder.append("status:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" ");
      }
      localStringBuilder.append("content:");
      localStringBuilder.append(paramString3);
      QLog.i("PreUploadVideo", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.LogTag
 * JD-Core Version:    0.7.0.1
 */