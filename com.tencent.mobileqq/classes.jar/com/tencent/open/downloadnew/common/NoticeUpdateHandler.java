package com.tencent.open.downloadnew.common;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;

public class NoticeUpdateHandler
  extends Handler
{
  protected NoticeParam a = new NoticeParam();
  protected Notification b;
  
  public NoticeUpdateHandler() {}
  
  public NoticeUpdateHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  protected String a(int paramInt)
  {
    return CommonDataAdapter.a().b().getString(paramInt);
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    return CommonDataAdapter.a().b().getString(paramInt, paramVarArgs);
  }
  
  protected void a(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(2131439458, paramPendingIntent);
        return;
      }
      paramNotification.contentIntent = paramPendingIntent;
      return;
    }
    paramNotification.contentIntent = paramPendingIntent;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject1 = paramMessage.getData();
    Object localObject3 = ((Bundle)localObject1).getString(DownloadConstants.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+++++what:");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append("+++++");
    localStringBuilder.append(localObject1);
    LogUtility.a("NoticeUpdateHandler", localStringBuilder.toString());
    localObject3 = DownloadManager.b().d((String)localObject3);
    if (localObject3 != null)
    {
      if (((DownloadInfo)localObject3).C == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("notification isShowNotification=");
        paramMessage.append(((DownloadInfo)localObject3).C);
        LogUtility.c("NoticeUpdateHandler", paramMessage.toString());
        return;
      }
      this.a.a = ((DownloadInfo)localObject3).c;
      this.a.b = ((DownloadInfo)localObject3).f;
      this.a.d = ((DownloadInfo)localObject3).e;
      localObject1 = this.a;
      ((NoticeParam)localObject1).f = 1;
      ((NoticeParam)localObject1).h = ((DownloadInfo)localObject3).g;
      localObject1 = this.a;
      ((NoticeParam)localObject1).g = 1;
      ((NoticeParam)localObject1).j = ((DownloadInfo)localObject3).u;
      this.a.i = ((DownloadInfo)localObject3).i;
      this.a.k = ((DownloadInfo)localObject3).h;
      this.a.e = ((DownloadInfo)localObject3).d;
      try
      {
        if (this.b == null)
        {
          this.b = AppNotificationManager.a().b(this.a);
        }
        else
        {
          localObject1 = new RemoteViews(CommonDataAdapter.a().b().getPackageName(), 2131625678);
          AppNotificationManager.a().a((RemoteViews)localObject1);
          ((RemoteViews)localObject1).setInt(2131439458, "setBackgroundColor", -1);
          ((RemoteViews)localObject1).setInt(2131439460, "setTextColor", -16777216);
          ((RemoteViews)localObject1).setInt(2131439454, "setTextColor", -12303292);
          ((RemoteViews)localObject1).setInt(2131439447, "setTextColor", -12303292);
          this.b.contentView = ((RemoteViews)localObject1);
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("NoticeUpdateHandler", "init Notification>>>", localException);
      }
      if (this.b == null) {
        return;
      }
      int i = paramMessage.what;
      Object localObject2;
      if (i != -2)
      {
        if (i != 6)
        {
          if (i != 20)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 4)
                {
                  paramMessage = new StringBuilder();
                  paramMessage.append(">>complete:");
                  paramMessage.append(this.a.a);
                  LogUtility.b("NoticeUpdateHandler", paramMessage.toString());
                  this.a.g = 3;
                  this.b = AppNotificationManager.a().b(this.a);
                  paramMessage = this.b;
                  if (paramMessage == null) {
                    return;
                  }
                  paramMessage.tickerText = a(2131892204);
                  this.b.contentView.setViewVisibility(2131439447, 0);
                  this.b.contentView.setViewVisibility(2131439441, 8);
                  this.b.contentView.setViewVisibility(2131439454, 8);
                  this.b.contentView.setTextViewText(2131439447, a(2131892184));
                  this.b.contentView.setTextViewText(2131439460, StringAddition.a(((DownloadInfo)localObject3).f, 18, true));
                  a(this.b, IntentFactory.a(4, this.a), false);
                  paramMessage = ImageUtil.a(this.a.a);
                  if (paramMessage != null)
                  {
                    this.b.contentView.setImageViewBitmap(2131439448, paramMessage);
                  }
                  else
                  {
                    LogUtility.b("NoticeUpdateHandler", ">>download icon fail,so we use default notification icon");
                    this.b.contentView.setImageViewResource(2131439448, 2130845750);
                  }
                  paramMessage = this.b;
                  paramMessage.flags = 16;
                  paramMessage.flags &= 0xFFFFFFFD;
                  AppNotificationManager.a().b(this.a.h);
                }
              }
              else
              {
                paramMessage = new StringBuilder();
                paramMessage.append(">>pause:");
                paramMessage.append(this.a.a);
                LogUtility.b("NoticeUpdateHandler", paramMessage.toString());
                this.b.tickerText = a(2131892186);
                this.b.contentView.setViewVisibility(2131439447, 0);
                this.b.contentView.setViewVisibility(2131439441, 8);
                this.b.contentView.setViewVisibility(2131439454, 8);
                this.b.contentView.setImageViewResource(2131439448, 2130845753);
                this.b.contentView.setTextViewText(2131439460, StringAddition.a(((DownloadInfo)localObject3).f, 18, true));
                this.b.contentView.setTextViewText(2131439447, a(2131892186));
                a(this.b, IntentFactory.a(1, this.a), true);
                paramMessage = this.b;
                paramMessage.flags = 16;
                paramMessage.flags &= 0xFFFFFFFD;
                AppNotificationManager.a().b(this.a.h);
              }
            }
            else
            {
              paramMessage = new StringBuilder();
              paramMessage.append(">>downloading:");
              paramMessage.append(this.a.a);
              LogUtility.b("NoticeUpdateHandler", paramMessage.toString());
              paramMessage = new StringBuilder();
              paramMessage.append("size = ");
              paramMessage.append(((DownloadInfo)localObject3).t);
              paramMessage.append(" content = ");
              LogUtility.c("NoticeUpdateHandler", paramMessage.toString());
              this.b.tickerText = a(2131892206, new Object[] { ((DownloadInfo)localObject3).f });
              this.b.contentView.setViewVisibility(2131439447, 8);
              this.b.contentView.setViewVisibility(2131439441, 0);
              this.b.contentView.setViewVisibility(2131439454, 0);
              this.b.contentView.setProgressBar(2131439440, 100, ((DownloadInfo)localObject3).t, false);
              paramMessage = this.b.contentView;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(((DownloadInfo)localObject3).t * 100 / 100);
              ((StringBuilder)localObject2).append("%");
              paramMessage.setTextViewText(2131439454, ((StringBuilder)localObject2).toString());
              this.b.contentView.setImageViewResource(2131439448, 2130845750);
              this.b.contentView.setTextViewText(2131439460, StringAddition.a(a(2131892210, new Object[] { ((DownloadInfo)localObject3).f }), 18, true));
              a(this.b, IntentFactory.a(2, this.a), true);
              if (!TextUtils.isEmpty(""))
              {
                this.b.contentView.setViewVisibility(2131439447, 0);
                this.b.contentView.setTextViewText(2131439447, Html.fromHtml(""));
              }
              else
              {
                this.b.contentView.setViewVisibility(2131439447, 8);
              }
              paramMessage = this.b;
              paramMessage.flags = 32;
              paramMessage.flags |= 0x2;
            }
          }
          else
          {
            this.b.tickerText = a(2131892206, new Object[] { ((DownloadInfo)localObject3).f });
            this.b.contentView.setViewVisibility(2131439447, 0);
            this.b.contentView.setViewVisibility(2131439441, 8);
            this.b.contentView.setViewVisibility(2131439454, 8);
            this.b.contentView.setTextViewText(2131439460, StringAddition.a(a(2131892210, new Object[] { ((DownloadInfo)localObject3).f }), 18, true));
            this.b.contentView.setTextViewText(2131439447, a(2131888806));
            this.b.contentView.setImageViewResource(2131439448, 2130845750);
            a(this.b, IntentFactory.a(2, this.a), true);
            paramMessage = this.b;
            paramMessage.flags = 32;
            paramMessage.flags |= 0x2;
            AppNotificationManager.a().b(this.a.h);
          }
        }
        else {
          AppNotificationManager.a().a(this.a.h);
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(">>error:");
        ((StringBuilder)localObject2).append(this.a.a);
        LogUtility.b("NoticeUpdateHandler", ((StringBuilder)localObject2).toString());
        this.b.contentView.setViewVisibility(2131439447, 0);
        this.b.contentView.setViewVisibility(2131439441, 8);
        this.b.contentView.setViewVisibility(2131439454, 8);
        this.b.contentView.setImageViewResource(2131439448, 2130845751);
        localObject2 = (String)paramMessage.obj;
        paramMessage = (Message)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramMessage = a(2131888798);
        }
        this.b.tickerText = a(2131892205, new Object[] { paramMessage });
        this.b.contentView.setTextViewText(2131439447, a(2131892185, new Object[] { paramMessage }));
        this.b.contentView.setTextViewText(2131439460, StringAddition.a(((DownloadInfo)localObject3).f, 18, true));
        a(this.b, IntentFactory.a(1, this.a), true);
        paramMessage = this.b;
        paramMessage.flags = 16;
        paramMessage.flags &= 0xFFFFFFFD;
        AppNotificationManager.a().b(this.a.h);
      }
      i = AppNotificationManager.a().a(this.a.h, this.a.g, this.a.a);
      long l = AppNotificationManager.a().b(this.a.h, this.a.g, this.a.a);
      this.b.when = l;
      AppNotificationManager.a().a(i, this.b);
      paramMessage = new StringBuilder();
      paramMessage.append("notify key=");
      paramMessage.append(this.a.h);
      paramMessage.append(" type=");
      paramMessage.append(this.a.g);
      paramMessage.append("appid=");
      paramMessage.append(this.a.a);
      LogUtility.c("NoticeUpdateHandler", paramMessage.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.NoticeUpdateHandler
 * JD-Core Version:    0.7.0.1
 */