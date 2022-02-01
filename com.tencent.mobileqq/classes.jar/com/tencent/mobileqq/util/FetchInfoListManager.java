package com.tencent.mobileqq.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class FetchInfoListManager
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final FetchInfoListManager.FetchInfoListener jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener;
  private final LinkedList<FetchInfoReq> jdField_a_of_type_JavaUtilLinkedList;
  private final LinkedList<FetchInfoReq> b;
  
  public FetchInfoListManager(FetchInfoListManager.FetchInfoListener paramFetchInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener = paramFetchInfoListener;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.b = new LinkedList();
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(FetchInfoReq paramFetchInfoReq)
  {
    if (!paramFetchInfoReq.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FetchInfoListManager", 2, StringUtil.a(new Object[] { "addToNeedFetchInfoListInner() ", paramFetchInfoReq.toString(), "非法请求" }));
      }
      return;
    }
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramFetchInfoReq)) && (!this.b.contains(paramFetchInfoReq)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, StringUtil.a(new Object[] { "addToNeedFetchInfoListInner()", paramFetchInfoReq.toString() }));
      }
      this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramFetchInfoReq);
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))
      {
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if ((l >= 0L) && (l <= 2000L))
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 300L);
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FetchInfoListManager", 4, StringUtil.a(new Object[] { "addToNeedFetchInfoListInner()", paramFetchInfoReq.toString(), "已经在队列中了" }));
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, "doFetchInfo fetch list is empty!");
      }
      return;
    }
    FetchInfoReq localFetchInfoReq;
    do
    {
      localFetchInfoReq = (FetchInfoReq)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
    } while ((localFetchInfoReq == null) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()));
    if (localFetchInfoReq == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, "doFetchInfo req is null !");
      }
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, String.format(Locale.getDefault(), "doFetchInfo type:%d  key: %s time:%d", new Object[] { Integer.valueOf(localFetchInfoReq.jdField_a_of_type_Int), localFetchInfoReq.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) }));
    }
    if (localFetchInfoReq.jdField_a_of_type_Int == 1)
    {
      ArrayList localArrayList = new ArrayList();
      b(localFetchInfoReq);
      localArrayList.add(localFetchInfoReq);
      int i = Math.min(this.jdField_a_of_type_JavaUtilLinkedList.size(), 20) - 1;
      while (i >= 0)
      {
        localFetchInfoReq = (FetchInfoReq)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
        if ((localFetchInfoReq != null) && (localFetchInfoReq.jdField_a_of_type_Int == 1))
        {
          this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
          b(localFetchInfoReq);
          localArrayList.add(localFetchInfoReq);
        }
        i -= 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener.a(1, localArrayList);
    }
    else
    {
      b(localFetchInfoReq);
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener.a(localFetchInfoReq);
    }
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  private void b(FetchInfoReq paramFetchInfoReq)
  {
    if ((paramFetchInfoReq != null) && (!this.b.contains(paramFetchInfoReq)))
    {
      paramFetchInfoReq.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.b.add(paramFetchInfoReq);
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 30000L);
      }
    }
  }
  
  private void c()
  {
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("dealTimeOut  size:");
      localStringBuilder.append(this.b.size());
      localStringBuilder.append(" {");
    }
    else
    {
      localStringBuilder = null;
    }
    long l4 = SystemClock.elapsedRealtime();
    int i = this.b.size() - 1;
    long l2;
    for (long l1 = 30000L; i >= 0; l1 = l2)
    {
      FetchInfoReq localFetchInfoReq = (FetchInfoReq)this.b.get(i);
      if (localFetchInfoReq == null)
      {
        this.b.remove(localFetchInfoReq);
        l2 = l1;
      }
      else
      {
        long l3 = l4 - localFetchInfoReq.jdField_a_of_type_Long;
        if ((l3 >= 0L) && (l3 < 30000L))
        {
          l2 = l1;
          if (l3 < l1) {
            l2 = l3;
          }
        }
        else
        {
          this.b.remove(localFetchInfoReq);
          l2 = l1;
          if (localStringBuilder != null)
          {
            localStringBuilder.append(", [");
            localStringBuilder.append(localFetchInfoReq.jdField_a_of_type_Int);
            localStringBuilder.append(",");
            localStringBuilder.append(localFetchInfoReq.jdField_a_of_type_JavaLangString);
            localStringBuilder.append("]");
            l2 = l1;
          }
        }
      }
      i -= 1;
    }
    if (!this.b.isEmpty()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, Math.max(1000L, l1));
    }
    if ((QLog.isDevelopLevel()) && (localStringBuilder != null))
    {
      localStringBuilder.append("}");
      localStringBuilder.append(" isEmpty: ");
      localStringBuilder.append(this.b.isEmpty());
      QLog.d("FetchInfoListManager", 4, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.b.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (QLog.isDevelopLevel()) {
      QLog.i("FetchInfoListManager", 4, "clear");
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    paramString2 = new FetchInfoReq(paramInt, paramString1, paramString2, paramObject, paramBundle);
    paramString2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramString2);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.i("FetchInfoListManager", 4, String.format(Locale.getDefault(), "addToNeedFetchInfoList [%d, %s]", new Object[] { Integer.valueOf(paramInt), paramString1 }));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      if ((paramMessage.obj instanceof FetchInfoReq))
      {
        a((FetchInfoReq)paramMessage.obj);
        return true;
      }
    }
    else
    {
      if (paramMessage.what == 1)
      {
        b();
        return true;
      }
      if (paramMessage.what == 2) {
        c();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchInfoListManager
 * JD-Core Version:    0.7.0.1
 */