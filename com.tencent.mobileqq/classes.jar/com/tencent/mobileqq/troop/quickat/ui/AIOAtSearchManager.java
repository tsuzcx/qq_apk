package com.tencent.mobileqq.troop.quickat.ui;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AIOAtSearchManager
  implements Handler.Callback
{
  List<TroopMemberInfo> a = new ArrayList(0);
  private final SessionInfo b;
  private ConcurrentHashMap<String, Runnable> c = new ConcurrentHashMap(1);
  private AIOAtSearchManager.RefreshUIListener d;
  private Handler e = new Handler(Looper.getMainLooper(), this);
  private QQAppInterface f;
  private HandlerThread g;
  private Handler h;
  
  public AIOAtSearchManager(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.f = paramQQAppInterface;
    this.b = paramSessionInfo;
    this.g = new HandlerThread("AIOAtSearchManager");
    this.g.start();
    this.h = new Handler(this.g.getLooper());
  }
  
  public List<TroopMemberInfo> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.a);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(AIOAtSearchManager.RefreshUIListener paramRefreshUIListener)
  {
    this.d = paramRefreshUIListener;
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    c();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new AIOAtSearchManager.AtSearchRunnable(str, a(), this.e, this.f, paramBoolean1, this.b, paramBoolean2);
    this.c.put(str, paramString);
    this.h.post(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("taa putTask: ");
      paramString.append(System.currentTimeMillis());
      QLog.e("AIOAtSearchManager", 2, paramString.toString());
    }
  }
  
  public void a(List<TroopMemberInfo> paramList)
  {
    if (paramList != null) {
      try
      {
        if (!paramList.isEmpty())
        {
          this.a = paramList;
          return;
        }
      }
      finally {}
    }
  }
  
  public boolean b()
  {
    try
    {
      if (this.a != null)
      {
        boolean bool = this.a.isEmpty();
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AIOAtSearchManager.AtSearchRunnable)this.c.get(localObject);
      if (localObject != null)
      {
        ((AIOAtSearchManager.AtSearchRunnable)localObject).a = true;
        this.h.removeCallbacks((Runnable)localObject);
      }
    }
    this.c.clear();
    this.e.removeMessages(1);
  }
  
  public void d()
  {
    c();
    this.g.quit();
    this.h.removeCallbacksAndMessages(null);
    this.e.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("taa handleMessage  ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.e("AIOAtSearchManager", 2, localStringBuilder.toString());
    }
    if (this.d == null) {
      return true;
    }
    if (paramMessage.what != 1) {
      return true;
    }
    paramMessage = (SearchTask.SearchResult)paramMessage.obj;
    if (!this.c.containsKey(paramMessage.a)) {
      return true;
    }
    this.d.a(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager
 * JD-Core Version:    0.7.0.1
 */