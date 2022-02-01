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
  private static a f;
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
    if ((GlobalUtil.getInstance().getContext() != null) && (paramNotifyParam != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getNotification> title = ");
      ((StringBuilder)localObject).append(paramNotifyParam.title);
      ((StringBuilder)localObject).append(", content=");
      ((StringBuilder)localObject).append(paramNotifyParam.content);
      ab.c("SDK_NotificationManager", ((StringBuilder)localObject).toString());
      localObject = new Notification();
      ((Notification)localObject).tickerText = paramNotifyParam.title;
      ((Notification)localObject).when = System.currentTimeMillis();
      RemoteViews localRemoteViews = new RemoteViews(GlobalUtil.getInstance().getContext().getPackageName(), this.b.c("qapp_center_notification"));
      a(localRemoteViews);
      localRemoteViews.setInt(this.b.d("notification_root"), "setBackgroundColor", -1);
      localRemoteViews.setInt(this.b.d("notification_title"), "setTextColor", -16777216);
      localRemoteViews.setInt(this.b.d("notification_progress"), "setTextColor", -12303292);
      localRemoteViews.setInt(this.b.d("notification_content"), "setTextColor", -12303292);
      localRemoteViews.setTextViewText(this.b.d("notification_title"), g.a(paramNotifyParam.title, 18, true, true));
      ((Notification)localObject).icon = this.b.b("qfile_file_ufdownload_top");
      ((Notification)localObject).contentView = localRemoteViews;
      return localObject;
    }
    return null;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    Object localObject = this.g;
    if (localObject != null) {
      try
      {
        ((NotificationManager)localObject).notify(paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notify ");
        ((StringBuilder)localObject).append(paramNotification);
        ab.c("SDK_NotificationManager", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    Object localObject = this.i;
    if ((localObject == null) || (((c)localObject).a() == null)) {
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
    localObject = GlobalUtil.getInstance().getContext().getApplicationInfo();
    if ((localObject != null) && (((ApplicationInfo)localObject).targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int j = this.i.c().intValue();
      paramRemoteViews.setInt(this.b.d("notification_root"), "setBackgroundColor", -1 - j + (j & 0xFF000000));
      return;
    }
    catch (Exception paramRemoteViews) {}
  }
  
  protected void a(b paramb)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("***尝试  保存至本地：");
      ((StringBuilder)localObject).append(paramb.toString());
      ab.a("SDK_NotificationManager", ((StringBuilder)localObject).toString());
      localObject = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("***保存至本地：");
      localStringBuilder.append(paramb.toString());
      ab.d("SDK_NotificationManager", localStringBuilder.toString());
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
    if (localObject != null)
    {
      if (((com.tencent.tmdownloader.internal.downloadservice.c)localObject).K != TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadWait notify enter info.id=");
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = paramString1;
      }
      localStringBuilder.append((String)localObject);
      ab.a("SDK_NotificationManager", localStringBuilder.toString());
      localObject = this.d.obtainMessage();
      ((Message)localObject).what = paramInt1;
      ((Message)localObject).obj = paramString2;
      paramString2 = new Bundle();
      paramString2.putString("url", paramString1);
      ((Message)localObject).setData(paramString2);
      a((Message)localObject);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (System.currentTimeMillis() - this.e > 1000L)
    {
      this.e = System.currentTimeMillis();
      Object localObject1 = ApkDownloadManager.getInstance().queryDownloadInfo(paramString);
      if (localObject1 != null)
      {
        if (((com.tencent.tmdownloader.internal.downloadservice.c)localObject1).K != TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
          return;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDownloading notify enter info.id=");
        if (localObject1 == null) {
          localObject1 = "";
        } else {
          localObject1 = paramString;
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ab.a("SDK_NotificationManager", ((StringBuilder)localObject2).toString());
        localObject1 = this.d.obtainMessage();
        ((Message)localObject1).what = 2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("url", paramString);
        ((Message)localObject1).setData((Bundle)localObject2);
        a((Message)localObject1);
      }
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
    ApkDownloadManager.getInstance().AddDownloadListener(this);
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelBySendTime:");
    localStringBuilder.append(paramString);
    ab.a("SDK_NotificationManager", localStringBuilder.toString());
    if ((this.g != null) && (this.a.containsKey(paramString)))
    {
      this.g.cancel(((b)this.a.get(paramString)).c);
      this.a.remove(paramString);
      d(paramString);
    }
  }
  
  public void c()
  {
    ApkDownloadManager.getInstance().RemoveDownloadListener(this);
  }
  
  public void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelBySendTime:");
    localStringBuilder.append(paramString);
    ab.a("SDK_NotificationManager", localStringBuilder.toString());
    if ((this.g != null) && (this.a.containsKey(paramString))) {
      this.g.cancel(((b)this.a.get(paramString)).c);
    }
  }
  
  protected void d()
  {
    ab.a("SDK_NotificationManager", "------------从本地初始化ID------------");
    try
    {
      Object localObject1 = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).getAll();
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("%%%共有");
        ((StringBuilder)localObject2).append(((Map)localObject1).size());
        ((StringBuilder)localObject2).append("条数据");
        ab.a("SDK_NotificationManager", ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(">>>数据：key=");
          ((StringBuilder)localObject3).append((String)((Map.Entry)localObject2).getKey());
          ((StringBuilder)localObject3).append(",value=");
          ((StringBuilder)localObject3).append((String)((Map.Entry)localObject2).getValue());
          ab.a("SDK_NotificationManager", ((StringBuilder)localObject3).toString());
          if (this.a.containsKey(((Map.Entry)localObject2).getKey()))
          {
            ab.d("SDK_NotificationManager", "列表已经包含，跳过");
          }
          else
          {
            localObject3 = e((String)((Map.Entry)localObject2).getValue());
            if (localObject3 != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(">>>转换为数据对象：");
              localStringBuilder.append(((b)localObject3).toString());
              ab.a("SDK_NotificationManager", localStringBuilder.toString());
              this.h = Math.max(this.h, ((b)localObject3).c);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(">>>initValue=");
              localStringBuilder.append(this.h);
              ab.d("SDK_NotificationManager", localStringBuilder.toString());
              this.a.put(((Map.Entry)localObject2).getKey(), localObject3);
            }
            else
            {
              ab.e("SDK_NotificationManager", "init id from local en.getValue() error:");
            }
          }
        }
      }
      ab.a("SDK_NotificationManager", "------------从本地初始化ID 结束------------");
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init id from local error:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      ab.c("SDK_NotificationManager", ((StringBuilder)localObject2).toString(), localException);
    }
  }
  
  protected void d(String paramString)
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("&&&从本地删除 removeFromLocal:");
      ((StringBuilder)localObject).append(paramString);
      ab.a("SDK_NotificationManager", ((StringBuilder)localObject).toString());
      localObject = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remove nid from local error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      ab.c("SDK_NotificationManager", ((StringBuilder)localObject).toString(), paramString);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear nid from local error:");
      localStringBuilder.append(localException.getMessage());
      ab.c("SDK_NotificationManager", localStringBuilder.toString(), localException);
    }
  }
  
  protected void finalize()
  {
    ab.e("SDK_NotificationManager", "finalize 清理 sp数据");
    e();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.a
 * JD-Core Version:    0.7.0.1
 */