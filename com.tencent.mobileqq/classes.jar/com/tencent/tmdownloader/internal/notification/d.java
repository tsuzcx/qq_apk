package com.tencent.tmdownloader.internal.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.p;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.c;

public class d
  extends Handler
{
  NotifyParam a;
  Notification b;
  private p c = null;
  private Context d = null;
  
  public d()
  {
    a();
  }
  
  public d(Looper paramLooper)
  {
    super(paramLooper);
    a();
  }
  
  private int a(long paramLong1, long paramLong2)
  {
    return (int)((float)paramLong1 * 100.0F / (float)paramLong2);
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        localObject1 = localObject2;
      }
    }
    else {
      return localObject1;
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    float f3 = f1 / f2;
    float f4 = paramInt1 / paramInt2;
    localObject2 = new Matrix();
    if (f3 > f4)
    {
      f1 = paramInt2 / f2;
      if (f1 >= 0.9F)
      {
        localObject1 = localBitmap;
        if (f1 <= 1.0F) {}
      }
      else
      {
        ((Matrix)localObject2).setScale(f1, f1);
        localObject1 = localObject2;
      }
      label112:
      if (localObject1 == null) {
        break label286;
      }
    }
    label286:
    for (localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);; localObject2 = paramBitmap)
    {
      if ((paramBoolean) && (localObject2 != paramBitmap) && (!GlobalUtil.isMIUI())) {
        paramBitmap.recycle();
      }
      int i = Math.max(0, ((Bitmap)localObject2).getWidth() - paramInt1);
      int j = Math.max(0, ((Bitmap)localObject2).getHeight() - paramInt2);
      localBitmap = Bitmap.createBitmap((Bitmap)localObject2, i / 2, j / 2, paramInt1, paramInt2);
      localObject1 = localBitmap;
      if (localBitmap == localObject2) {
        break;
      }
      if (!paramBoolean)
      {
        localObject1 = localBitmap;
        if (localObject2 == paramBitmap) {
          break;
        }
      }
      localObject1 = localBitmap;
      if (GlobalUtil.isMIUI()) {
        break;
      }
      ((Bitmap)localObject2).recycle();
      return localBitmap;
      f1 = paramInt1 / f1;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        ((Matrix)localObject2).setScale(f1, f1);
        localObject1 = localObject2;
        break label112;
      }
      localObject1 = null;
      break label112;
    }
  }
  
  private Bitmap a(String paramString)
  {
    try
    {
      Object localObject1 = GlobalUtil.getInstance().getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localObject1 != null)
      {
        localObject1 = ((PackageInfo)localObject1).applicationInfo;
        if (Build.VERSION.SDK_INT >= 8)
        {
          ((ApplicationInfo)localObject1).sourceDir = paramString;
          ((ApplicationInfo)localObject1).publicSourceDir = paramString;
        }
        paramString = ((ApplicationInfo)localObject1).loadIcon(GlobalUtil.getInstance().getContext().getPackageManager());
        if (paramString != null) {
          if ((paramString instanceof BitmapDrawable)) {
            return ((BitmapDrawable)paramString).getBitmap();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
      if ((paramString instanceof StateListDrawable)) {
        return ((BitmapDrawable)((StateListDrawable)paramString).getCurrent()).getBitmap();
      }
    }
    return null;
  }
  
  private void a()
  {
    this.a = new NotifyParam();
    this.d = GlobalUtil.getInstance().getContext();
    this.c = new p(this.d);
  }
  
  private void a(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(this.c.d("notification_root"), paramPendingIntent);
        return;
      }
      paramNotification.contentIntent = paramPendingIntent;
      return;
    }
    paramNotification.contentIntent = paramPendingIntent;
  }
  
  protected String a(int paramInt)
  {
    try
    {
      String str = this.d.getString(paramInt);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.d.getString(paramInt, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return "";
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject = paramMessage.getData();
    c localc = ApkDownloadManager.getInstance().queryDownloadInfo(((Bundle)localObject).getString("url"));
    if (localc != null)
    {
      this.a.url = localc.b;
      this.a.title = localc.E;
      this.a.nKey = String.valueOf(localc.q);
    }
    try
    {
      if (this.b == null) {
        this.b = a.a().a(this.a);
      }
      while (this.b == null)
      {
        return;
        localObject = new RemoteViews(this.d.getPackageName(), this.c.c("qapp_center_notification"));
        a.a().a((RemoteViews)localObject);
        ((RemoteViews)localObject).setInt(this.c.d("notification_root"), "setBackgroundColor", -1);
        ((RemoteViews)localObject).setInt(this.c.d("notification_title"), "setTextColor", -16777216);
        ((RemoteViews)localObject).setInt(this.c.d("notification_progress"), "setTextColor", -12303292);
        ((RemoteViews)localObject).setInt(this.c.d("notification_content"), "setTextColor", -12303292);
        this.b.contentView = ((RemoteViews)localObject);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.c("SDK_NotificationHandler", "init Notification " + localException);
      }
      ab.c("SDK_NotificationHandler", "<handleMessage> msg.what = " + paramMessage.what);
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      int i = a.a().a(this.a.nKey, this.a.url);
      ab.c("SDK_NotificationHandler", "notification id = " + i);
      this.b.when = a.a().b(this.a.nKey, this.a.url);
      a.a().a(i, this.b);
      return;
      this.b.tickerText = a(this.c.a("notification_tickerText_download_prefix"), new Object[] { localc.E });
      this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
      this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 8);
      this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 8);
      this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(a(this.c.a("notification_title_download_prefix"), new Object[] { localc.E }), 18, true));
      this.b.contentView.setTextViewText(this.c.d("notification_content"), a(this.c.a("download_wait")));
      this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload"));
      this.a.notificationTypeId = 101;
      a(this.b, e.a(this.a), true);
      this.b.flags = 32;
      paramMessage = this.b;
      paramMessage.flags |= 0x2;
      a.a().c(this.a.nKey);
      continue;
      this.b.tickerText = a(this.c.a("notification_tickerText_download_prefix"), new Object[] { localc.E });
      this.b.contentView.setViewVisibility(this.c.d("notification_content"), 8);
      this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 0);
      this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 0);
      if (localc.i > 0L)
      {
        this.b.contentView.setProgressBar(this.c.d("notif_pro_bar"), 100, a(localc.h, localc.i), false);
        this.b.contentView.setTextViewText(this.c.d("notification_progress"), a(localc.h, localc.i) * 100 / 100 + "%");
      }
      this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload"));
      this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(a(this.c.a("notification_title_download_prefix"), new Object[] { localc.E }), 18, true));
      this.a.notificationTypeId = 102;
      a(this.b, e.a(this.a), true);
      if (!TextUtils.isEmpty(""))
      {
        this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
        this.b.contentView.setTextViewText(this.c.d("notification_content"), Html.fromHtml(""));
      }
      for (;;)
      {
        this.b.flags = 32;
        paramMessage = this.b;
        paramMessage.flags |= 0x2;
        break;
        this.b.contentView.setViewVisibility(this.c.d("notification_content"), 8);
      }
      ab.c("SDK_NotificationHandler", ">>pause:" + this.a.url);
      this.b.tickerText = a(this.c.a("notification_content_download_pause"));
      this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
      this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 8);
      this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 8);
      this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload_pause"));
      this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(localc.E, 18, true));
      this.b.contentView.setTextViewText(this.c.d("notification_content"), a(this.c.a("notification_content_download_pause")));
      this.a.notificationTypeId = 103;
      a(this.b, e.a(this.a), true);
      this.b.flags = 16;
      paramMessage = this.b;
      paramMessage.flags &= 0xFFFFFFFD;
      a.a().c(this.a.nKey);
      continue;
      ab.c("SDK_NotificationHandler", ">>complete:" + this.a.url);
      this.b = a.a().a(this.a);
      if (this.b == null) {
        break;
      }
      this.b.tickerText = a(this.c.a("notification_tickerText_download_complete"));
      this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
      this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 8);
      this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 8);
      this.b.contentView.setTextViewText(this.c.d("notification_content"), a(this.c.a("notification_content_download_complete")));
      this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(localc.E, 18, true));
      this.a.notificationTypeId = 104;
      a(this.b, e.a(this.a), true);
      paramMessage = a(a(com.tencent.tmdownloader.internal.storage.d.a(localc.j)), 72, 72, true);
      if ((paramMessage != null) && (!paramMessage.isRecycled())) {
        this.b.contentView.setImageViewBitmap(this.c.d("notification_icon"), paramMessage);
      }
      for (;;)
      {
        this.b.flags = 16;
        paramMessage = this.b;
        paramMessage.flags &= 0xFFFFFFFD;
        a.a().c(this.a.nKey);
        break;
        ab.c("SDK_NotificationHandler", ">>download icon fail,so we use default notification icon");
        this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload"));
      }
      ab.c("SDK_NotificationHandler", ">>error:" + this.a.url);
      this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
      this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 8);
      this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 8);
      this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload_error"));
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (TextUtils.isEmpty(str)) {
        paramMessage = a(this.c.a("download_err_unknown"));
      }
      this.b.tickerText = a(this.c.a("notification_tickerText_download_err"), new Object[] { paramMessage });
      this.b.contentView.setTextViewText(this.c.d("notification_content"), a(this.c.a("notification_content_download_err_suffix"), new Object[] { paramMessage }));
      this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(localc.E, 18, true));
      this.a.notificationTypeId = 105;
      a(this.b, e.a(this.a), true);
      this.b.flags = 16;
      paramMessage = this.b;
      paramMessage.flags &= 0xFFFFFFFD;
      a.a().c(this.a.nKey);
      continue;
      a.a().b(this.a.nKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.d
 * JD-Core Version:    0.7.0.1
 */