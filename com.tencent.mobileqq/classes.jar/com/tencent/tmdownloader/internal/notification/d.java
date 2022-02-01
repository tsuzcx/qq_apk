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
    Object localObject1 = null;
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return null;
      }
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = f1 / f2;
      float f4 = paramInt1;
      float f5 = paramInt2;
      float f6 = f4 / f5;
      Object localObject2 = new Matrix();
      if (f3 > f6)
      {
        f1 = f5 / f2;
        if ((f1 < 0.9F) || (f1 > 1.0F))
        {
          ((Matrix)localObject2).setScale(f1, f1);
          localObject1 = localObject2;
        }
      }
      else
      {
        f1 = f4 / f1;
        if ((f1 < 0.9F) || (f1 > 1.0F)) {
          break label135;
        }
      }
      break label148;
      label135:
      ((Matrix)localObject2).setScale(f1, f1);
      localObject1 = localObject2;
      label148:
      if (localObject1 != null) {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
      } else {
        localObject1 = paramBitmap;
      }
      if ((paramBoolean) && (localObject1 != paramBitmap) && (!GlobalUtil.isMIUI())) {
        paramBitmap.recycle();
      }
      int i = Math.max(0, ((Bitmap)localObject1).getWidth() - paramInt1);
      int j = Math.max(0, ((Bitmap)localObject1).getHeight() - paramInt2);
      localObject2 = Bitmap.createBitmap((Bitmap)localObject1, i / 2, j / 2, paramInt1, paramInt2);
      if ((localObject2 != localObject1) && ((paramBoolean) || (localObject1 != paramBitmap)) && (!GlobalUtil.isMIUI())) {
        ((Bitmap)localObject1).recycle();
      }
      return localObject2;
    }
    return null;
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject2 = null;
    try
    {
      localPackageInfo = GlobalUtil.getInstance().getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
    }
    catch (Exception localException)
    {
      PackageInfo localPackageInfo;
      label21:
      Object localObject1;
      break label21;
    }
    localPackageInfo = null;
    localObject1 = localObject2;
    if (localPackageInfo != null)
    {
      localObject1 = localPackageInfo.applicationInfo;
      if (Build.VERSION.SDK_INT >= 8)
      {
        ((ApplicationInfo)localObject1).sourceDir = paramString;
        ((ApplicationInfo)localObject1).publicSourceDir = paramString;
      }
      paramString = ((ApplicationInfo)localObject1).loadIcon(GlobalUtil.getInstance().getContext().getPackageManager());
      localObject1 = localObject2;
      if (paramString != null)
      {
        if ((paramString instanceof BitmapDrawable)) {
          return ((BitmapDrawable)paramString).getBitmap();
        }
        localObject1 = localObject2;
        if ((paramString instanceof StateListDrawable)) {
          localObject1 = ((BitmapDrawable)((StateListDrawable)paramString).getCurrent()).getBitmap();
        }
      }
    }
    return localObject1;
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
    Object localObject1 = paramMessage.getData();
    c localc = ApkDownloadManager.getInstance().queryDownloadInfo(((Bundle)localObject1).getString("url"));
    if (localc != null)
    {
      this.a.url = localc.b;
      this.a.title = localc.E;
      this.a.nKey = String.valueOf(localc.q);
      try
      {
        if (this.b == null)
        {
          this.b = a.a().a(this.a);
        }
        else
        {
          localObject1 = new RemoteViews(this.d.getPackageName(), this.c.c("qapp_center_notification"));
          a.a().a((RemoteViews)localObject1);
          ((RemoteViews)localObject1).setInt(this.c.d("notification_root"), "setBackgroundColor", -1);
          ((RemoteViews)localObject1).setInt(this.c.d("notification_title"), "setTextColor", -16777216);
          ((RemoteViews)localObject1).setInt(this.c.d("notification_progress"), "setTextColor", -12303292);
          ((RemoteViews)localObject1).setInt(this.c.d("notification_content"), "setTextColor", -12303292);
          this.b.contentView = ((RemoteViews)localObject1);
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init Notification ");
        localStringBuilder.append(localException);
        ab.c("SDK_NotificationHandler", localStringBuilder.toString());
      }
      if (this.b == null) {
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<handleMessage> msg.what = ");
      ((StringBuilder)localObject2).append(paramMessage.what);
      ab.c("SDK_NotificationHandler", ((StringBuilder)localObject2).toString());
      switch (paramMessage.what)
      {
      default: 
        break;
      case 6: 
        a.a().b(this.a.nKey);
        break;
      case 5: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(">>error:");
        ((StringBuilder)localObject2).append(this.a.url);
        ab.c("SDK_NotificationHandler", ((StringBuilder)localObject2).toString());
        this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
        this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 8);
        this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 8);
        this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload_error"));
        localObject2 = (String)paramMessage.obj;
        paramMessage = (Message)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramMessage = a(this.c.a("download_err_unknown"));
        }
        this.b.tickerText = a(this.c.a("notification_tickerText_download_err"), new Object[] { paramMessage });
        this.b.contentView.setTextViewText(this.c.d("notification_content"), a(this.c.a("notification_content_download_err_suffix"), new Object[] { paramMessage }));
        this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(localc.E, 18, true));
        paramMessage = this.a;
        paramMessage.notificationTypeId = 105;
        a(this.b, e.a(paramMessage), true);
        paramMessage = this.b;
        paramMessage.flags = 16;
        paramMessage.flags &= 0xFFFFFFFD;
        a.a().c(this.a.nKey);
        break;
      case 4: 
        paramMessage = new StringBuilder();
        paramMessage.append(">>complete:");
        paramMessage.append(this.a.url);
        ab.c("SDK_NotificationHandler", paramMessage.toString());
        this.b = a.a().a(this.a);
        paramMessage = this.b;
        if (paramMessage == null) {
          return;
        }
        paramMessage.tickerText = a(this.c.a("notification_tickerText_download_complete"));
        this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
        this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 8);
        this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 8);
        this.b.contentView.setTextViewText(this.c.d("notification_content"), a(this.c.a("notification_content_download_complete")));
        this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(localc.E, 18, true));
        paramMessage = this.a;
        paramMessage.notificationTypeId = 104;
        a(this.b, e.a(paramMessage), true);
        paramMessage = a(a(com.tencent.tmdownloader.internal.storage.d.a(localc.j)), 72, 72, true);
        if ((paramMessage != null) && (!paramMessage.isRecycled()))
        {
          this.b.contentView.setImageViewBitmap(this.c.d("notification_icon"), paramMessage);
        }
        else
        {
          ab.c("SDK_NotificationHandler", ">>download icon fail,so we use default notification icon");
          this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload"));
        }
        paramMessage = this.b;
        paramMessage.flags = 16;
        paramMessage.flags &= 0xFFFFFFFD;
        a.a().c(this.a.nKey);
        break;
      case 3: 
        paramMessage = new StringBuilder();
        paramMessage.append(">>pause:");
        paramMessage.append(this.a.url);
        ab.c("SDK_NotificationHandler", paramMessage.toString());
        this.b.tickerText = a(this.c.a("notification_content_download_pause"));
        this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
        this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 8);
        this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 8);
        this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload_pause"));
        this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(localc.E, 18, true));
        this.b.contentView.setTextViewText(this.c.d("notification_content"), a(this.c.a("notification_content_download_pause")));
        paramMessage = this.a;
        paramMessage.notificationTypeId = 103;
        a(this.b, e.a(paramMessage), true);
        paramMessage = this.b;
        paramMessage.flags = 16;
        paramMessage.flags &= 0xFFFFFFFD;
        a.a().c(this.a.nKey);
        break;
      case 2: 
        this.b.tickerText = a(this.c.a("notification_tickerText_download_prefix"), new Object[] { localc.E });
        this.b.contentView.setViewVisibility(this.c.d("notification_content"), 8);
        this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 0);
        this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 0);
        if (localc.i > 0L)
        {
          this.b.contentView.setProgressBar(this.c.d("notif_pro_bar"), 100, a(localc.h, localc.i), false);
          paramMessage = this.b.contentView;
          i = this.c.d("notification_progress");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(a(localc.h, localc.i) * 100 / 100);
          ((StringBuilder)localObject2).append("%");
          paramMessage.setTextViewText(i, ((StringBuilder)localObject2).toString());
        }
        this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload"));
        this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(a(this.c.a("notification_title_download_prefix"), new Object[] { localc.E }), 18, true));
        paramMessage = this.a;
        paramMessage.notificationTypeId = 102;
        a(this.b, e.a(paramMessage), true);
        if (!TextUtils.isEmpty(""))
        {
          this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
          this.b.contentView.setTextViewText(this.c.d("notification_content"), Html.fromHtml(""));
        }
        else
        {
          this.b.contentView.setViewVisibility(this.c.d("notification_content"), 8);
        }
        paramMessage = this.b;
        paramMessage.flags = 32;
        paramMessage.flags |= 0x2;
        break;
      case 1: 
        this.b.tickerText = a(this.c.a("notification_tickerText_download_prefix"), new Object[] { localc.E });
        this.b.contentView.setViewVisibility(this.c.d("notification_content"), 0);
        this.b.contentView.setViewVisibility(this.c.d("notif_pro_bar_layout"), 8);
        this.b.contentView.setViewVisibility(this.c.d("notification_progress"), 8);
        this.b.contentView.setTextViewText(this.c.d("notification_title"), g.a(a(this.c.a("notification_title_download_prefix"), new Object[] { localc.E }), 18, true));
        this.b.contentView.setTextViewText(this.c.d("notification_content"), a(this.c.a("download_wait")));
        this.b.contentView.setImageViewResource(this.c.d("notification_icon"), this.c.b("qfile_file_ufdownload"));
        paramMessage = this.a;
        paramMessage.notificationTypeId = 101;
        a(this.b, e.a(paramMessage), true);
        paramMessage = this.b;
        paramMessage.flags = 32;
        paramMessage.flags |= 0x2;
        a.a().c(this.a.nKey);
      }
      int i = a.a().a(this.a.nKey, this.a.url);
      paramMessage = new StringBuilder();
      paramMessage.append("notification id = ");
      paramMessage.append(i);
      ab.c("SDK_NotificationHandler", paramMessage.toString());
      this.b.when = a.a().b(this.a.nKey, this.a.url);
      a.a().a(i, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.notification.d
 * JD-Core Version:    0.7.0.1
 */