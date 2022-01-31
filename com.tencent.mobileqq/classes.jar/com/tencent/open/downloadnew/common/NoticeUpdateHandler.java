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
        paramNotification.contentView.setOnClickPendingIntent(2131365683, paramPendingIntent);
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
    Object localObject2 = ((Bundle)localObject1).getString(DownloadConstants.jdField_a_of_type_JavaLangString);
    LogUtility.a("NoticeUpdateHandler", "+++++what:" + paramMessage.what + "+++++" + localObject1);
    localObject2 = DownloadManager.a().a((String)localObject2);
    if (localObject2 != null)
    {
      if (((DownloadInfo)localObject2).j == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
        LogUtility.c("NoticeUpdateHandler", "notification isShowNotification=" + ((DownloadInfo)localObject2).j);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString = ((DownloadInfo)localObject2).jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_JavaLangString = ((DownloadInfo)localObject2).e;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.d = ((DownloadInfo)localObject2).d;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f = ((DownloadInfo)localObject2).f;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_AndroidContentIntent = ((DownloadInfo)localObject2).jdField_a_of_type_AndroidContentIntent;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_Long = ((DownloadInfo)localObject2).jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_g_of_type_JavaLangString = ((DownloadInfo)localObject2).jdField_g_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.e = ((DownloadInfo)localObject2).c;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppNotification == null)
        {
          this.jdField_a_of_type_AndroidAppNotification = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
          if (this.jdField_a_of_type_AndroidAppNotification == null) {
            break;
          }
        }
        switch (paramMessage.what)
        {
        default: 
          int i = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          long l = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidAppNotification.when = l;
          AppNotificationManager.a().a(i, this.jdField_a_of_type_AndroidAppNotification);
          LogUtility.c("NoticeUpdateHandler", "notify key=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f + " type=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int + "appid=" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
          return;
          localObject1 = new RemoteViews(CommonDataAdapter.a().a().getPackageName(), 2130969244);
          AppNotificationManager.a().a((RemoteViews)localObject1);
          this.jdField_a_of_type_AndroidAppNotification.contentView = ((RemoteViews)localObject1);
          continue;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("NoticeUpdateHandler", "init Notification>>>", localException);
        continue;
        LogUtility.b("NoticeUpdateHandler", ">>downloading:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        LogUtility.c("NoticeUpdateHandler", "size = " + ((DownloadInfo)localObject2).jdField_g_of_type_Int + " content = ");
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131428550, new Object[] { ((DownloadInfo)localObject2).e });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365688, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365689, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365687, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setProgressBar(2131365690, 100, ((DownloadInfo)localObject2).jdField_g_of_type_Int, false);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365687, ((DownloadInfo)localObject2).jdField_g_of_type_Int * 100 / 100 + "%");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131365684, 2130841628);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365686, StringAddition.a(a(2131428553, new Object[] { ((DownloadInfo)localObject2).e }), 18, true));
        a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        if (!TextUtils.isEmpty(""))
        {
          this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365688, 0);
          this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365688, Html.fromHtml(""));
          this.jdField_a_of_type_AndroidAppNotification.flags = 32;
          paramMessage = this.jdField_a_of_type_AndroidAppNotification;
          paramMessage.flags |= 0x2;
          continue;
        }
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365688, 8);
        continue;
        this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131428550, new Object[] { ((DownloadInfo)localObject2).e });
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365688, 0);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365689, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365687, 8);
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365686, StringAddition.a(a(2131428553, new Object[] { ((DownloadInfo)localObject2).e }), 18, true));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365688, a(2131428559));
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131365684, 2130841628);
        a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(2, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
        this.jdField_a_of_type_AndroidAppNotification.flags = 32;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags |= 0x2;
        AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
        continue;
        LogUtility.b("NoticeUpdateHandler", ">>complete:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_b_of_type_Int = 3;
        this.jdField_a_of_type_AndroidAppNotification = AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam);
      }
      if (this.jdField_a_of_type_AndroidAppNotification == null) {
        break;
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131428551);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365688, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365689, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365687, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365688, a(2131428558));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365686, StringAddition.a(((DownloadInfo)localObject2).e, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), false);
      paramMessage = ImageUtil.a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      if (paramMessage != null) {
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewBitmap(2131365684, paramMessage);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppNotification.flags = 16;
        paramMessage = this.jdField_a_of_type_AndroidAppNotification;
        paramMessage.flags &= 0xFFFFFFFD;
        AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
        break;
        LogUtility.b("NoticeUpdateHandler", ">>download icon fail,so we use default notification icon");
        this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131365684, 2130841628);
      }
      LogUtility.b("NoticeUpdateHandler", ">>pause:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131428556);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365688, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365689, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365687, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131365684, 2130841631);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365686, StringAddition.a(((DownloadInfo)localObject2).e, 18, true));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365688, a(2131428556));
      a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
      continue;
      LogUtility.b("NoticeUpdateHandler", ">>error:" + this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365688, 0);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365689, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setViewVisibility(2131365687, 8);
      this.jdField_a_of_type_AndroidAppNotification.contentView.setImageViewResource(2131365684, 2130841629);
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (TextUtils.isEmpty(str)) {
        paramMessage = a(2131428562);
      }
      this.jdField_a_of_type_AndroidAppNotification.tickerText = a(2131428552, new Object[] { paramMessage });
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365688, a(2131428557, new Object[] { paramMessage }));
      this.jdField_a_of_type_AndroidAppNotification.contentView.setTextViewText(2131365686, StringAddition.a(((DownloadInfo)localObject2).e, 18, true));
      a(this.jdField_a_of_type_AndroidAppNotification, IntentFactory.a(1, this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam), true);
      this.jdField_a_of_type_AndroidAppNotification.flags = 16;
      paramMessage = this.jdField_a_of_type_AndroidAppNotification;
      paramMessage.flags &= 0xFFFFFFFD;
      AppNotificationManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
    }
    AppNotificationManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeParam.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.NoticeUpdateHandler
 * JD-Core Version:    0.7.0.1
 */