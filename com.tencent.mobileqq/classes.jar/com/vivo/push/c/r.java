package com.vivo.push.c;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.vivo.push.b.h;
import com.vivo.push.b.q;
import com.vivo.push.b.x;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.m;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.z;
import java.util.HashMap;

public final class r
  extends y
{
  r(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  protected final void a(com.vivo.push.o paramo)
  {
    if (paramo == null)
    {
      com.vivo.push.util.o.a("OnNotificationArrivedTask", "command is null");
      return;
    }
    boolean bool = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
    paramo = (q)paramo;
    if (!com.vivo.push.util.s.d(this.a, this.a.getPackageName()))
    {
      localObject1 = new x(2101L);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("messageID", String.valueOf(paramo.f()));
      paramo = z.b(this.a, this.a.getPackageName());
      if (!TextUtils.isEmpty(paramo)) {
        ((HashMap)localObject2).put("remoteAppId", paramo);
      }
      ((x)localObject1).a((HashMap)localObject2);
      com.vivo.push.e.a().a((com.vivo.push.o)localObject1);
      return;
    }
    Object localObject1 = new h(String.valueOf(paramo.f()));
    com.vivo.push.e.a().a((com.vivo.push.o)localObject1);
    localObject1 = new StringBuilder("PushMessageReceiver ");
    ((StringBuilder)localObject1).append(this.a.getPackageName());
    ((StringBuilder)localObject1).append(" isEnablePush :");
    ((StringBuilder)localObject1).append(bool);
    com.vivo.push.util.o.d("OnNotificationArrivedTask", ((StringBuilder)localObject1).toString());
    if (!bool)
    {
      localObject1 = new x(1020L);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("messageID", String.valueOf(paramo.f()));
      paramo = z.b(this.a, this.a.getPackageName());
      if (!TextUtils.isEmpty(paramo)) {
        ((HashMap)localObject2).put("remoteAppId", paramo);
      }
      ((x)localObject1).a((HashMap)localObject2);
      com.vivo.push.e.a().a((com.vivo.push.o)localObject1);
      return;
    }
    if ((com.vivo.push.e.a().g()) && (!a(z.d(this.a), paramo.e(), paramo.i())))
    {
      localObject1 = new x(1021L);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("messageID", String.valueOf(paramo.f()));
      paramo = z.b(this.a, this.a.getPackageName());
      if (!TextUtils.isEmpty(paramo)) {
        ((HashMap)localObject2).put("remoteAppId", paramo);
      }
      ((x)localObject1).a((HashMap)localObject2);
      com.vivo.push.e.a().a((com.vivo.push.o)localObject1);
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject1 = (NotificationManager)this.a.getSystemService("notification");
      if ((localObject1 != null) && (!((NotificationManager)localObject1).areNotificationsEnabled()))
      {
        localObject1 = new StringBuilder("pkg name : ");
        ((StringBuilder)localObject1).append(this.a.getPackageName());
        ((StringBuilder)localObject1).append(" notify switch is false");
        com.vivo.push.util.o.b("OnNotificationArrivedTask", ((StringBuilder)localObject1).toString());
        com.vivo.push.util.o.b(this.a, "通知开关关闭，导致通知无法展示，请到设置页打开应用通知开关");
        localObject1 = new x(2104L);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("messageID", String.valueOf(paramo.f()));
        paramo = z.b(this.a, this.a.getPackageName());
        if (!TextUtils.isEmpty(paramo)) {
          ((HashMap)localObject2).put("remoteAppId", paramo);
        }
        ((x)localObject1).a((HashMap)localObject2);
        com.vivo.push.e.a().a((com.vivo.push.o)localObject1);
        return;
      }
      if ((Build.VERSION.SDK_INT < 26) || (localObject1 == null)) {}
    }
    try
    {
      localObject1 = ((NotificationManager)localObject1).getNotificationChannel("vivo_push_channel");
      if ((localObject1 == null) || (((NotificationChannel)localObject1).getImportance() != 0)) {
        break label737;
      }
      localObject1 = new StringBuilder("pkg name : ");
      ((StringBuilder)localObject1).append(this.a.getPackageName());
      ((StringBuilder)localObject1).append(" notify channel switch is false");
      com.vivo.push.util.o.b("OnNotificationArrivedTask", ((StringBuilder)localObject1).toString());
      com.vivo.push.util.o.b(this.a, "通知通道开关关闭，导致通知无法展示，请到设置页打开应用通知开关");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("messageID", String.valueOf(paramo.f()));
      localObject2 = z.b(this.a, this.a.getPackageName());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((HashMap)localObject1).put("remoteAppId", localObject2);
      }
      com.vivo.push.util.e.a(2121L, (HashMap)localObject1);
      return;
    }
    catch (Exception localException)
    {
      label729:
      int i;
      StringBuilder localStringBuilder;
      break label729;
    }
    com.vivo.push.util.o.b("OnNotificationArrivedTask", "判断通知通道出现系统错误");
    label737:
    localObject1 = paramo.d();
    if (localObject1 != null)
    {
      i = ((InsideNotificationItem)localObject1).getTargetType();
      localObject2 = ((InsideNotificationItem)localObject1).getTragetContent();
      localStringBuilder = new StringBuilder("tragetType is ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ; target is ");
      localStringBuilder.append((String)localObject2);
      com.vivo.push.util.o.d("OnNotificationArrivedTask", localStringBuilder.toString());
      m.b(new s(this, (InsideNotificationItem)localObject1, paramo));
      return;
    }
    com.vivo.push.util.o.a("OnNotificationArrivedTask", "notify is null");
    localObject1 = this.a;
    Object localObject2 = new StringBuilder("通知内容为空，");
    ((StringBuilder)localObject2).append(paramo.f());
    com.vivo.push.util.o.c((Context)localObject1, ((StringBuilder)localObject2).toString());
    com.vivo.push.util.e.a(this.a, paramo.f(), 1027L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.r
 * JD-Core Version:    0.7.0.1
 */