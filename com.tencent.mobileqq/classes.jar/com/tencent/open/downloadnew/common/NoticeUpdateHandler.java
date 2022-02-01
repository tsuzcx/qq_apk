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
  protected Notification a;
  protected NoticeParam a;
  
  public NoticeUpdateHandler()
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  public NoticeUpdateHandler(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam = new NoticeParam();
  }
  
  protected String a(int paramInt)
  {
    return CommonDataAdapter.a().a().getString(paramInt);
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    return CommonDataAdapter.a().a().getString(paramInt, paramVarArgs);
  }
  
  protected void a(Notification paramNotification, PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT > 10)
      {
        paramNotification.contentView.setOnClickPendingIntent(2131372000, paramPendingIntent);
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
    Object localObject3 = ((Bundle)localObject1).getString(DownloadConstants.jdField_b_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+++++what:");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append("+++++");
    localStringBuilder.append(localObject1);
    LogUtility.a("NoticeUpdateHandler", localStringBuilder.toString());
    localObject3 = DownloadManager.a().a((String)localObject3);
    if (localObject3 != null)
    {
      if (((DownloadInfo)localObject3).i == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("notification isShowNotification=");
        paramMessage.append(((DownloadInfo)localObject3).i);
        LogUtility.c("NoticeUpdateHandler", paramMessage.toString());
        return;
      }
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString = ((DownloadInfo)localObject3).c;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_JavaLangString = ((DownloadInfo)localObject3).jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d = ((DownloadInfo)localObject3).e;
      localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam;
      ((NoticeParam)localObject1).jdField_a_of_type_Int = 1;
      ((NoticeParam)localObject1).jdField_f_of_type_JavaLangString = ((DownloadInfo)localObject3).g;
      localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam;
      ((NoticeParam)localObject1).jdField_b_of_type_Int = 1;
      ((NoticeParam)localObject1).jdField_a_of_type_AndroidContentIntent = ((DownloadInfo)localObject3).jdField_a_of_type_AndroidContentIntent;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_Long = ((DownloadInfo)localObject3).jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.g = ((DownloadInfo)localObject3).h;
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e = ((DownloadInfo)localObject3).d;
      try
      {
        if (this.jdField_a_of_type_AndroidAppNotification == null)
        {
          this.jdField_a_of_type_AndroidAppNotification = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
        }
        else
        {
          localObject1 = new RemoteViews(CommonDataAdapter.a().a().getPackageName(), 2131559649);
          AppNotificationManager.a().a((RemoteViews)localObject1);
          ((RemoteViews)localObject1).setInt(2131372000, "setBackgroundColor", -1);
          ((RemoteViews)localObject1).setInt(2131372002, "setTextColor", -16777216);
          ((RemoteViews)localObject1).setInt(2131371996, "setTextColor", -12303292);
          ((RemoteViews)localObject1).setInt(2131371990, "setTextColor", -12303292);
          this.jdField_a_of_type_AndroidAppNotification.contentView = ((RemoteViews)localObject1);
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("NoticeUpdateHandler", "init Notification>>>", localException);
      }
      if (this.jdField_a_of_type_AndroidAppNotification == null) {
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
                  paramMessage.append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
                  LogUtility.b("NoticeUpdateHandler", paramMessage.toString());
                  this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 3;
                  this.jdField_a_of_type_AndroidAppNotification = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
                  paramMessage = this.jdField_a_of_type_AndroidAppNotification;
                  if (paramMessage == null) {
                    return;
                  }
                  paramMessage.tickerText = a(2131694521);
                  this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371990, 0);
                  this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371985, 8);
                  this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371996, 8);
                  this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371990, a(2131694501));
                  this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372002, StringAddition.a(((DownloadInfo)localObject3).jdField_f_of_type_JavaLangString, 18, true));
                  a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), false);
                  paramMessage = ImageUtil.a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
                  if (paramMessage != null)
                  {
                    this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewBitmap(2131371991, paramMessage);
                  }
                  else
                  {
                    LogUtility.b("NoticeUpdateHandler", ">>download icon fail,so we use default notification icon");
                    this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371991, 2130844432);
                  }
                  paramMessage = this.jdField_a_of_type_AndroidAppNotification;
                  paramMessage.flags = 16;
                  paramMessage.flags &= 0xFFFFFFFD;
                  AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
                }
              }
              else
              {
                paramMessage = new StringBuilder();
                paramMessage.append(">>pause:");
                paramMessage.append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
                LogUtility.b("NoticeUpdateHandler", paramMessage.toString());
                this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694503);
                this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371990, 0);
                this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371985, 8);
                this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371996, 8);
                this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371991, 2130844435);
                this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372002, StringAddition.a(((DownloadInfo)localObject3).jdField_f_of_type_JavaLangString, 18, true));
                this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371990, a(2131694503));
                a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
                paramMessage = this.jdField_a_of_type_AndroidAppNotification;
                paramMessage.flags = 16;
                paramMessage.flags &= 0xFFFFFFFD;
                AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
              }
            }
            else
            {
              paramMessage = new StringBuilder();
              paramMessage.append(">>downloading:");
              paramMessage.append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
              LogUtility.b("NoticeUpdateHandler", paramMessage.toString());
              paramMessage = new StringBuilder();
              paramMessage.append("size = ");
              paramMessage.append(((DownloadInfo)localObject3).jdField_f_of_type_Int);
              paramMessage.append(" content = ");
              LogUtility.c("NoticeUpdateHandler", paramMessage.toString());
              this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694523, new Object[] { ((DownloadInfo)localObject3).jdField_f_of_type_JavaLangString });
              this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371990, 8);
              this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371985, 0);
              this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371996, 0);
              this.jdField_a_of_type_AndroidAppNotification.contentView.setProgressBar(2131371984, 100, ((DownloadInfo)localObject3).jdField_f_of_type_Int, false);
              paramMessage = this.jdField_a_of_type_AndroidAppNotification.contentView;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(((DownloadInfo)localObject3).jdField_f_of_type_Int * 100 / 100);
              ((StringBuilder)localObject2).append("%");
              paramMessage.setTextViewText(2131371996, ((StringBuilder)localObject2).toString());
              this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371991, 2130844432);
              this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372002, StringAddition.a(a(2131694527, new Object[] { ((DownloadInfo)localObject3).jdField_f_of_type_JavaLangString }), 18, true));
              a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
              if (!TextUtils.isEmpty(""))
              {
                this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371990, 0);
                this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371990, Html.fromHtml(""));
              }
              else
              {
                this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371990, 8);
              }
              paramMessage = this.jdField_a_of_type_AndroidAppNotification;
              paramMessage.flags = 32;
              paramMessage.flags |= 0x2;
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694523, new Object[] { ((DownloadInfo)localObject3).jdField_f_of_type_JavaLangString });
            this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371990, 0);
            this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371985, 8);
            this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371996, 8);
            this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372002, StringAddition.a(a(2131694527, new Object[] { ((DownloadInfo)localObject3).jdField_f_of_type_JavaLangString }), 18, true));
            this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371990, a(2131691841));
            this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371991, 2130844432);
            a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
            paramMessage = this.jdField_a_of_type_AndroidAppNotification;
            paramMessage.flags = 32;
            paramMessage.flags |= 0x2;
            AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
          }
        }
        else {
          AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(">>error:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        LogUtility.b("NoticeUpdateHandler", ((StringBuilder)localObject2).toString());
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371990, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371985, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131371996, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131371991, 2130844433);
        localObject2 = (String)paramMessage.obj;
        paramMessage = (Message)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramMessage = a(2131691835);
        }
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131694522, new Object[] { paramMessage });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131371990, a(2131694502, new Object[] { paramMessage }));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131372002, StringAddition.a(((DownloadInfo)localObject3).jdField_f_of_type_JavaLangString, 18, true));
        a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags = 16;
        paramMessage.flags &= 0xFFFFFFFD;
        AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
      }
      i = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      long l = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.when = l;
      AppNotificationManager.a().a(i, this.jdField_a_of_type_AndroidAppNotification);
      paramMessage = new StringBuilder();
      paramMessage.append("notify key=");
      paramMessage.append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_f_of_type_JavaLangString);
      paramMessage.append(" type=");
      paramMessage.append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int);
      paramMessage.append("appid=");
      paramMessage.append(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      LogUtility.c("NoticeUpdateHandler", paramMessage.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.NoticeUpdateHandler
 * JD-Core Version:    0.7.0.1
 */