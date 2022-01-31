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
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.p;
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
  private static a f = null;
  protected final ConcurrentHashMap<String, b> a = new ConcurrentHashMap();
  p b = null;
  protected AtomicInteger c;
  d d;
  protected long e = 0L;
  private NotificationManager g = null;
  private int h = 1;
  private c i;
  
  protected a()
  {
    d();
    this.c = new AtomicInteger(1);
    this.d = new d(Looper.getMainLooper());
  }
  
  public static a a()
  {
    try
    {
      if (f == null) {
        f = new a();
      }
      a locala = f;
      return locala;
    }
    finally {}
  }
  
  private void a(Message paramMessage)
  {
    if (this.d == null) {
      this.d = new d();
    }
    this.d.sendMessage(paramMessage);
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!this.a.containsKey(paramString1))
    {
      b localb = new b(this);
      localb.a = paramString1;
      localb.c = this.c.incrementAndGet();
      localb.b = paramString2;
      localb.d = (System.currentTimeMillis() + localb.c);
      a(localb);
      this.a.put(paramString1, localb);
    }
    return ((b)this.a.get(paramString1)).c;
  }
  
  public Notification a(NotifyParam paramNotifyParam)
  {
    if ((GlobalUtil.getInstance().getContext() == null) || (paramNotifyParam == null)) {
      return null;
    }
    ab.c("SDK_NotificationManager", "<getNotification> title = " + paramNotifyParam.title + ", content=" + paramNotifyParam.content);
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNotifyParam.title;
    localNotification.when = System.currentTimeMillis();
    RemoteViews localRemoteViews = new RemoteViews(GlobalUtil.getInstance().getContext().getPackageName(), this.b.c("qapp_center_notification"));
    a(localRemoteViews);
    localRemoteViews.setInt(this.b.d("notification_root"), "setBackgroundColor", -1);
    localRemoteViews.setInt(this.b.d("notification_title"), "setTextColor", -16777216);
    localRemoteViews.setInt(this.b.d("notification_progress"), "setTextColor", -12303292);
    localRemoteViews.setInt(this.b.d("notification_content"), "setTextColor", -12303292);
    localRemoteViews.setTextViewText(this.b.d("notification_title"), g.a(paramNotifyParam.title, 18, true, true));
    localNotification.icon = this.b.b("qfile_file_ufdownload_top");
    localNotification.contentView = localRemoteViews;
    return localNotification;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.g != null) {}
    try
    {
      this.g.notify(paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      ab.c("SDK_NotificationManager", "notify " + paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.i == null) || (this.i.a() == null)) {
      this.i = new c(this, GlobalUtil.getInstance().getContext());
    }
    if (this.i.c() != null) {
      paramRemoteViews.setTextColor(this.b.d("notification_title"), this.i.c().intValue());
    }
    if (this.i.a() != null)
    {
      paramRemoteViews.setTextColor(this.b.d("notification_content"), this.i.a().intValue());
      paramRemoteViews.setTextColor(this.b.d("notification_progress"), this.i.a().intValue());
    }
    if (this.i.b() > 0.0F)
    {
      paramRemoteViews.setFloat(this.b.d("notification_content"), "setTextSize", this.i.b());
      paramRemoteViews.setFloat(this.b.d("notification_progress"), "setTextSize", this.i.b());
      paramRemoteViews.setFloat(this.b.d("notification_title"), "setTextSize", this.i.d());
    }
    ApplicationInfo localApplicationInfo = GlobalUtil.getInstance().getContext().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int j = this.i.c().intValue();
      paramRemoteViews.setInt(this.b.d("notification_root"), "setBackgroundColor", (j & 0xFF000000) + (-1 - j));
      return;
    }
    catch (Exception paramRemoteViews) {}
  }
  
  protected void a(b paramb)
  {
    try
    {
      ab.a("SDK_NotificationManager", "***尝试  保存至本地：" + paramb.toString());
      Object localObject = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0);
      ab.d("SDK_NotificationManager", "***保存至本地：" + paramb.toString());
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramb.a, paramb.toString());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramb)
    {
      ab.c("SDK_NotificationManager", "saveToLocal>>>", paramb);
    }
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject = ApkDownloadManager.getInstance().queryDownloadInfo(paramString1);
    if ((localObject == null) || (((com.tencent.tmdownloader.internal.downloadservice.c)localObject).K != TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("onDownloadWait notify enter info.id=");
    if (localObject == null) {}
    for (localObject = "";; localObject = paramString1)
    {
      ab.a("SDK_NotificationManager", (String)localObject);
      localObject = this.d.obtainMessage();
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
    if (System.currentTimeMillis() - this.e > 1000L)
    {
      this.e = System.currentTimeMillis();
      localObject1 = ApkDownloadManager.getInstance().queryDownloadInfo(paramString);
      if ((localObject1 != null) && (((com.tencent.tmdownloader.internal.downloadservice.c)localObject1).K == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE)) {}
    }
    else
    {
      return;
    }
    Object localObject2 = new StringBuilder().append("onDownloading notify enter info.id=");
    if (localObject1 == null) {}
    for (Object localObject1 = "";; localObject1 = paramString)
    {
      ab.a("SDK_NotificationManager", (String)localObject1);
      localObject1 = this.d.obtainMessage();
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
    if (!this.a.containsKey(paramString1))
    {
      b localb = new b(this);
      localb.a = paramString1;
      localb.c = this.c.incrementAndGet();
      localb.b = paramString2;
      localb.d = (System.currentTimeMillis() + localb.c);
      a(localb);
      this.a.put(String.valueOf(paramString1), localb);
    }
    return ((b)this.a.get(String.valueOf(paramString1))).d;
  }
  
  public void b()
  {
    if (this != null) {
      ApkDownloadManager.getInstance().AddDownloadListener(this);
    }
  }
  
  public void b(String paramString)
  {
    ab.a("SDK_NotificationManager", "cancelBySendTime:" + paramString);
    if ((this.g != null) && (this.a.containsKey(paramString)))
    {
      this.g.cancel(((b)this.a.get(paramString)).c);
      this.a.remove(paramString);
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
    ab.a("SDK_NotificationManager", "cancelBySendTime:" + paramString);
    if ((this.g != null) && (this.a.containsKey(paramString))) {
      this.g.cancel(((b)this.a.get(paramString)).c);
    }
  }
  
  protected void d()
  {
    ab.a("SDK_NotificationManager", "------------从本地初始化ID------------");
    for (;;)
    {
      Map.Entry localEntry;
      try
      {
        Object localObject = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).getAll();
        if (localObject != null) {
          ab.a("SDK_NotificationManager", "%%%共有" + ((Map)localObject).size() + "条数据");
        }
        if ((localObject == null) || (((Map)localObject).size() <= 0)) {
          break;
        }
        localObject = ((Map)localObject).entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
        ab.a("SDK_NotificationManager", ">>>数据：key=" + (String)localEntry.getKey() + ",value=" + (String)localEntry.getValue());
        if (this.a.containsKey(localEntry.getKey()))
        {
          ab.d("SDK_NotificationManager", "列表已经包含，跳过");
          continue;
        }
        localb = e((String)localEntry.getValue());
      }
      catch (Exception localException)
      {
        ab.c("SDK_NotificationManager", "init id from local error:" + localException.getMessage(), localException);
        return;
      }
      b localb;
      if (localb != null)
      {
        ab.a("SDK_NotificationManager", ">>>转换为数据对象：" + localb.toString());
        this.h = Math.max(this.h, localb.c);
        ab.d("SDK_NotificationManager", ">>>initValue=" + this.h);
        this.a.put(localEntry.getKey(), localb);
      }
      else
      {
        ab.e("SDK_NotificationManager", "init id from local en.getValue() error:");
      }
    }
    ab.a("SDK_NotificationManager", "------------从本地初始化ID 结束------------");
  }
  
  protected void d(String paramString)
  {
    try
    {
      ab.a("SDK_NotificationManager", "&&&从本地删除 removeFromLocal:" + paramString);
      SharedPreferences.Editor localEditor = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    catch (Exception paramString)
    {
      ab.c("SDK_NotificationManager", "remove nid from local error:" + paramString.getMessage(), paramString);
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
      ab.a("SDK_NotificationManager", "&&&从本地清除 clearLocal");
      SharedPreferences.Editor localEditor = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      ab.c("SDK_NotificationManager", "clear nid from local error:" + localException.getMessage(), localException);
    }
  }
  
  protected void finalize()
  {
    ab.e("SDK_NotificationManager", "finalize 清理 sp数据");
    e();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.a
 * JD-Core Version:    0.7.0.1
 */