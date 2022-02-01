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
  private final FetchInfoListManager.FetchInfoListener a;
  private final LinkedList<FetchInfoReq> b;
  private final LinkedList<FetchInfoReq> c;
  private final Handler d;
  private long e;
  
  public FetchInfoListManager(FetchInfoListManager.FetchInfoListener paramFetchInfoListener)
  {
    this.a = paramFetchInfoListener;
    this.b = new LinkedList();
    this.c = new LinkedList();
    this.d = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.e = 0L;
  }
  
  private void a(FetchInfoReq paramFetchInfoReq)
  {
    if (!paramFetchInfoReq.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FetchInfoListManager", 2, StringUtil.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner() ", paramFetchInfoReq.toString(), "非法请求" }));
      }
      return;
    }
    if ((!this.b.contains(paramFetchInfoReq)) && (!this.c.contains(paramFetchInfoReq)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, StringUtil.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner()", paramFetchInfoReq.toString() }));
      }
      this.b.addFirst(paramFetchInfoReq);
      if (!this.d.hasMessages(1))
      {
        long l = SystemClock.elapsedRealtime() - this.e;
        if ((l >= 0L) && (l <= 2000L))
        {
          this.d.sendEmptyMessageDelayed(1, 300L);
          return;
        }
        this.d.sendEmptyMessage(1);
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FetchInfoListManager", 4, StringUtil.makeLogMsg(new Object[] { "addToNeedFetchInfoListInner()", paramFetchInfoReq.toString(), "已经在队列中了" }));
    }
  }
  
  private void b()
  {
    if (this.b.isEmpty())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, "doFetchInfo fetch list is empty!");
      }
      return;
    }
    FetchInfoReq localFetchInfoReq;
    do
    {
      localFetchInfoReq = (FetchInfoReq)this.b.removeFirst();
    } while ((localFetchInfoReq == null) && (!this.b.isEmpty()));
    if (localFetchInfoReq == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FetchInfoListManager", 4, "doFetchInfo req is null !");
      }
      return;
    }
    this.e = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, String.format(Locale.getDefault(), "doFetchInfo type:%d  key: %s time:%d", new Object[] { Integer.valueOf(localFetchInfoReq.a), localFetchInfoReq.b, Long.valueOf(this.e) }));
    }
    if (localFetchInfoReq.a == 1)
    {
      ArrayList localArrayList = new ArrayList();
      b(localFetchInfoReq);
      localArrayList.add(localFetchInfoReq);
      int i = Math.min(this.b.size(), 20) - 1;
      while (i >= 0)
      {
        localFetchInfoReq = (FetchInfoReq)this.b.get(i);
        if ((localFetchInfoReq != null) && (localFetchInfoReq.a == 1))
        {
          this.b.remove(i);
          b(localFetchInfoReq);
          localArrayList.add(localFetchInfoReq);
        }
        i -= 1;
      }
      this.a.a(1, localArrayList);
    }
    else
    {
      b(localFetchInfoReq);
      this.a.a(localFetchInfoReq);
    }
    if (!this.b.isEmpty()) {
      this.d.sendEmptyMessage(1);
    }
  }
  
  private void b(FetchInfoReq paramFetchInfoReq)
  {
    if ((paramFetchInfoReq != null) && (!this.c.contains(paramFetchInfoReq)))
    {
      paramFetchInfoReq.f = SystemClock.elapsedRealtime();
      this.c.add(paramFetchInfoReq);
      if (!this.d.hasMessages(2)) {
        this.d.sendEmptyMessageDelayed(2, 30000L);
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
      localStringBuilder.append(this.c.size());
      localStringBuilder.append(" {");
    }
    else
    {
      localStringBuilder = null;
    }
    long l4 = SystemClock.elapsedRealtime();
    int i = this.c.size() - 1;
    long l2;
    for (long l1 = 30000L; i >= 0; l1 = l2)
    {
      FetchInfoReq localFetchInfoReq = (FetchInfoReq)this.c.get(i);
      if (localFetchInfoReq == null)
      {
        this.c.remove(localFetchInfoReq);
        l2 = l1;
      }
      else
      {
        long l3 = l4 - localFetchInfoReq.f;
        if ((l3 >= 0L) && (l3 < 30000L))
        {
          l2 = l1;
          if (l3 < l1) {
            l2 = l3;
          }
        }
        else
        {
          this.c.remove(localFetchInfoReq);
          l2 = l1;
          if (localStringBuilder != null)
          {
            localStringBuilder.append(", [");
            localStringBuilder.append(localFetchInfoReq.a);
            localStringBuilder.append(",");
            localStringBuilder.append(localFetchInfoReq.b);
            localStringBuilder.append("]");
            l2 = l1;
          }
        }
      }
      i -= 1;
    }
    if (!this.c.isEmpty()) {
      this.d.sendEmptyMessageDelayed(2, Math.max(1000L, l1));
    }
    if ((QLog.isDevelopLevel()) && (localStringBuilder != null))
    {
      localStringBuilder.append("}");
      localStringBuilder.append(" isEmpty: ");
      localStringBuilder.append(this.c.isEmpty());
      QLog.d("FetchInfoListManager", 4, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    this.b.clear();
    this.c.clear();
    this.d.removeCallbacksAndMessages(null);
    if (QLog.isDevelopLevel()) {
      QLog.i("FetchInfoListManager", 4, "clear");
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    paramString2 = new FetchInfoReq(paramInt, paramString1, paramString2, paramObject, paramBundle);
    paramString2 = this.d.obtainMessage(3, paramString2);
    this.d.sendMessage(paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchInfoListManager
 * JD-Core Version:    0.7.0.1
 */