package com.tencent.tmdownloader.internal.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.widget.RemoteViews;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  implements h
{
  static final String a = a.class.getName();
  private static a g = null;
  protected final ConcurrentHashMap<String, b> b = new ConcurrentHashMap();
  k c = null;
  protected AtomicInteger d;
  d e;
  protected long f = 0L;
  private NotificationManager h = null;
  private int i = 1;
  private c j;
  
  protected a()
  {
    d();
    this.d = new AtomicInteger(1);
    this.e = new d(Looper.getMainLooper());
  }
  
  public static a a()
  {
    try
    {
      if (g == null) {
        g = new a();
      }
      a locala = g;
      return locala;
    }
    finally {}
  }
  
  private void a(Message paramMessage)
  {
    if (this.e == null) {
      this.e = new d();
    }
    this.e.sendMessage(paramMessage);
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!this.b.containsKey(paramString1))
    {
      b localb = new b(this);
      localb.a = paramString1;
      localb.c = this.d.incrementAndGet();
      localb.b = paramString2;
      localb.d = (System.currentTimeMillis() + localb.c);
      a(localb);
      this.b.put(paramString1, localb);
    }
    return ((b)this.b.get(paramString1)).c;
  }
  
  public Notification a(NotifyParam paramNotifyParam)
  {
    if ((GlobalUtil.getInstance().getContext() == null) || (paramNotifyParam == null)) {
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNotifyParam.title;
    localNotification.when = System.currentTimeMillis();
    RemoteViews localRemoteViews = new RemoteViews(GlobalUtil.getInstance().getContext().getPackageName(), this.c.c("qapp_center_notification"));
    a(localRemoteViews);
    localRemoteViews.setTextViewText(this.c.d("notification_title"), g.a(paramNotifyParam.title, 18, true, true));
    localNotification.icon = this.c.b("qfile_file_ufdownload_top");
    localNotification.contentView = localRemoteViews;
    return localNotification;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.h != null) {}
    try
    {
      this.h.notify(paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      r.c(a, "notify " + paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.j == null) || (this.j.a() == null)) {
      this.j = new c(this, GlobalUtil.getInstance().getContext());
    }
    if (this.j.c() != null) {
      paramRemoteViews.setTextColor(this.c.d("notification_title"), this.j.c().intValue());
    }
    if (this.j.a() != null)
    {
      paramRemoteViews.setTextColor(this.c.d("notification_content"), this.j.a().intValue());
      paramRemoteViews.setTextColor(this.c.d("notification_progress"), this.j.a().intValue());
    }
    if (this.j.b() > 0.0F)
    {
      paramRemoteViews.setFloat(this.c.d("notification_content"), "setTextSize", this.j.b());
      paramRemoteViews.setFloat(this.c.d("notification_progress"), "setTextSize", this.j.b());
      paramRemoteViews.setFloat(this.c.d("notification_title"), "setTextSize", this.j.d());
    }
    ApplicationInfo localApplicationInfo = GlobalUtil.getInstance().getContext().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int k = this.j.c().intValue();
      paramRemoteViews.setInt(this.c.d("notification_root"), "setBackgroundColor", (k & 0xFF000000) + (-1 - k));
      return;
    }
    catch (Exception paramRemoteViews) {}
  }
  
  protected void a(b paramb)
  {
    try
    {
      r.a(a, "***尝试  保存至本地：" + paramb.toString());
      Object localObject = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0);
      r.d(a, "***保存至本地：" + paramb.toString());
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramb.a, paramb.toString());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramb)
    {
      r.c(a, "saveToLocal>>>", paramb);
    }
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject = ApkDownloadManager.getInstance().queryDownloadInfo(paramString1);
    if ((localObject == null) || (((com.tencent.tmdownloader.internal.downloadservice.c)localObject).L != TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE)) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder().append("onDownloadWait notify enter info.id=");
    if (localObject == null) {}
    for (localObject = "";; localObject = paramString1)
    {
      r.a(str, (String)localObject);
      localObject = this.e.obtainMessage();
      ((Message)localObject).what = paramInt1;
      ((Message)localObject).obj = paramString2;
      paramString2 = new Bundle();
      paramString2.putString("url", paramString1);
      ((Message)localObject).setData(paramString2);
      a((Message)localObject);
      return;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (System.currentTimeMillis() - this.f > 1000L)
    {
      this.f = System.currentTimeMillis();
      localObject1 = ApkDownloadManager.getInstance().queryDownloadInfo(paramString);
      if ((localObject1 != null) && (((com.tencent.tmdownloader.internal.downloadservice.c)localObject1).L == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE)) {}
    }
    else
    {
      return;
    }
    Object localObject2 = a;
    StringBuilder localStringBuilder = new StringBuilder().append("onDownloading notify enter info.id=");
    if (localObject1 == null) {}
    for (Object localObject1 = "";; localObject1 = paramString)
    {
      r.a((String)localObject2, (String)localObject1);
      localObject1 = this.e.obtainMessage();
      ((Message)localObject1).what = 2;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("url", paramString);
      ((Message)localObject1).setData((Bundle)localObject2);
      a((Message)localObject1);
      return;
    }
  }
  
  public long b(String paramString1, String paramString2)
  {
    if (!this.b.containsKey(paramString1))
    {
      b localb = new b(this);
      localb.a = paramString1;
      localb.c = this.d.incrementAndGet();
      localb.b = paramString2;
      localb.d = (System.currentTimeMillis() + localb.c);
      a(localb);
      this.b.put(String.valueOf(paramString1), localb);
    }
    return ((b)this.b.get(String.valueOf(paramString1))).d;
  }
  
  public void b()
  {
    if (this != null) {
      ApkDownloadManager.getInstance().AddDownloadListener(this);
    }
  }
  
  public void b(String paramString)
  {
    r.a(a, "cancelBySendTime:" + paramString);
    if ((this.h != null) && (this.b.containsKey(paramString)))
    {
      this.h.cancel(((b)this.b.get(paramString)).c);
      this.b.remove(paramString);
      d(paramString);
    }
  }
  
  public void c()
  {
    if (this != null) {
      ApkDownloadManager.getInstance().RemoveDownloadListener(this);
    }
  }
  
  public void c(String paramString)
  {
    r.a(a, "cancelBySendTime:" + paramString);
    if ((this.h != null) && (this.b.containsKey(paramString))) {
      this.h.cancel(((b)this.b.get(paramString)).c);
    }
  }
  
  protected void d()
  {
    r.a(a, "------------从本地初始化ID------------");
    for (;;)
    {
      Map.Entry localEntry;
      try
      {
        Object localObject = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).getAll();
        if (localObject != null) {
          r.a(a, "%%%共有" + ((Map)localObject).size() + "条数据");
        }
        if ((localObject == null) || (((Map)localObject).size() <= 0)) {
          break;
        }
        localObject = ((Map)localObject).entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
        r.a(a, ">>>数据：key=" + (String)localEntry.getKey() + ",value=" + (String)localEntry.getValue());
        if (this.b.containsKey(localEntry.getKey()))
        {
          r.d(a, "列表已经包含，跳过");
          continue;
        }
        localb = e((String)localEntry.getValue());
      }
      catch (Exception localException)
      {
        r.c(a, "init id from local error:" + localException.getMessage(), localException);
        return;
      }
      b localb;
      if (localb != null)
      {
        r.a(a, ">>>转换为数据对象：" + localb.toString());
        this.i = Math.max(this.i, localb.c);
        r.d(a, ">>>initValue=" + this.i);
        this.b.put(localEntry.getKey(), localb);
      }
      else
      {
        r.e(a, "init id from local en.getValue() error:");
      }
    }
    r.a(a, "------------从本地初始化ID 结束------------");
  }
  
  protected void d(String paramString)
  {
    try
    {
      r.a(a, "&&&从本地删除 removeFromLocal:" + paramString);
      SharedPreferences.Editor localEditor = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      r.c(a, "remove nid from local error:" + paramString.getMessage(), paramString);
    }
  }
  
  public b e(String paramString)
  {
    paramString = paramString.split(",");
    if (paramString.length < 4) {
      return null;
    }
    b localb = new b(this);
    localb.c = Integer.parseInt(paramString[0]);
    localb.b = paramString[1];
    localb.a = paramString[2];
    return localb;
  }
  
  public void e()
  {
    try
    {
      r.a(a, "&&&从本地清除 clearLocal");
      SharedPreferences.Editor localEditor = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      r.c(a, "clear nid from local error:" + localException.getMessage(), localException);
    }
  }
  
  protected void finalize()
  {
    r.e(a, "finalize 清理 sp数据");
    e();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.a
 * JD-Core Version:    0.7.0.1
 */