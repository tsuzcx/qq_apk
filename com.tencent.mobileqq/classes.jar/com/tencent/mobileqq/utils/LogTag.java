package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class LogTag
{
  public static final String a;
  private static ThreadLocal a;
  public static final String b;
  public static final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = PhotoListActivity.class.getSimpleName();
    b = AlbumListActivity.class.getSimpleName();
    c = PhotoPreviewActivity.class.getSimpleName();
    jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  }
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      LinkedList localLinkedList2 = (LinkedList)jdField_a_of_type_JavaLangThreadLocal.get();
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        jdField_a_of_type_JavaLangThreadLocal.set(localLinkedList1);
      }
      localLinkedList1.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = (LinkedList)jdField_a_of_type_JavaLangThreadLocal.get();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedList();
        jdField_a_of_type_JavaLangThreadLocal.set(localObject1);
        ((LinkedList)localObject1).addFirst(Long.valueOf(SystemClock.uptimeMillis()));
      }
      localObject2 = new StringBuilder();
      int i = 1;
      while (i < ((LinkedList)localObject1).size())
      {
        ((StringBuilder)localObject2).append("    ");
        i += 1;
      }
      if (((LinkedList)jdField_a_of_type_JavaLangThreadLocal.get()).size() != 0) {}
    }
    else
    {
      return;
    }
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(":cost ");
    ((StringBuilder)localObject2).append(SystemClock.uptimeMillis() - ((Long)((LinkedList)jdField_a_of_type_JavaLangThreadLocal.get()).removeFirst()).longValue());
    ((StringBuilder)localObject2).append("ms");
    QLog.i(paramString1, 2, ((StringBuilder)localObject2).toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("PreUploadVideo");
      localStringBuilder.append("[").append(paramString1).append("] ");
      if (paramString2 != null) {
        localStringBuilder.append("status:").append(paramString2).append(" ");
      }
      localStringBuilder.append("content:").append(paramString3);
      QLog.i("PreUploadVideo", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.LogTag
 * JD-Core Version:    0.7.0.1
 */