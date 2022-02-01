package com.tencent.mobileqq.kandian.biz.common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyFeedsMsgRecord;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ReadInJoyManager$NotifyReceiver$1
  implements Runnable
{
  ReadInJoyManager$NotifyReceiver$1(ReadInJoyManager.NotifyReceiver paramNotifyReceiver, Intent paramIntent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyManager.a, 2, String.format("receive %s", new Object[] { this.a.getAction() }));
    }
    long l1;
    if (this.a.getAction().equalsIgnoreCase("notify_main_feeds_msg_newfeeds_read"))
    {
      if (ReadInJoyManager.a(this.b.a) == null) {
        return;
      }
      l1 = ReadInJoyManager.a(this.b.a).getLong("config_feeds_newfeeds_leba_max_id", 0L);
      localObject1 = ReadInJoyManager.a(this.b.a).edit();
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_read_id", l1);
      RIJSPUtils.a((SharedPreferences.Editor)localObject1, true);
      ReadInJoyManager.b(this.b.a);
    }
    else if (this.a.getAction().equals("notify_main_feeds_msg_newcomment_read"))
    {
      l1 = this.a.getExtras().getLong("read_id");
      if (ReadInJoyManager.a(this.b.a) == null) {
        return;
      }
      long l2 = ReadInJoyManager.a(this.b.a).getLong("config_feeds_newcomment_leba_max_id", 0L);
      long l3 = ReadInJoyManager.a(this.b.a).getLong("config_feeds_newcomment_leba_read_id", 0L);
      if (l1 < l3) {
        l1 = l3;
      }
      if (l2 <= l1) {
        l1 = l2;
      }
      localObject1 = ReadInJoyManager.a(this.b.a).edit();
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_read_id", l1);
      RIJSPUtils.a((SharedPreferences.Editor)localObject1, true);
      ReadInJoyManager.b(this.b.a);
    }
    else
    {
      Object localObject2;
      if (this.a.getAction().equals("notify_main_feeds_msg_publish_fail"))
      {
        localObject1 = new ReadInJoyFeedsMsgRecord();
        ((ReadInJoyFeedsMsgRecord)localObject1).c = 999999;
        ((ReadInJoyFeedsMsgRecord)localObject1).d = this.a.getExtras().getLong("feed_owner");
        ((ReadInJoyFeedsMsgRecord)localObject1).n = this.a.getExtras().getInt("fail_reason");
        localObject2 = new ArrayList();
        ((List)localObject2).add(localObject1);
        this.b.a.a((List)localObject2);
      }
      else if (this.a.getAction().equals("notify_main_feeds_msg_republish"))
      {
        if (ReadInJoyManager.a(this.b.a) == null) {
          return;
        }
        l1 = ReadInJoyManager.a(this.b.a).getLong("config_feeds_publishfail_leba_max_id", 0L);
        localObject1 = ReadInJoyManager.a(this.b.a).edit();
        ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_read_id", l1);
        RIJSPUtils.a((SharedPreferences.Editor)localObject1, true);
        ReadInJoyManager.b(this.b.a);
      }
      else if (this.a.getAction().equals("notify_main_new_channel_clear"))
      {
        if (ReadInJoyManager.a(this.b.a) == null) {
          return;
        }
        localObject1 = ReadInJoyManager.a(this.b.a).edit();
        ((SharedPreferences.Editor)localObject1).putInt("config_new_channel_notify_flag", -1);
        RIJSPUtils.a((SharedPreferences.Editor)localObject1, true);
        ReadInJoyManager.c(this.b.a);
      }
      else if (this.a.getAction().equals("notify_main_guide_clear"))
      {
        if (ReadInJoyManager.a(this.b.a) == null) {
          return;
        }
        localObject1 = ReadInJoyManager.a(this.b.a).edit();
        ((SharedPreferences.Editor)localObject1).putInt("config_notify_guide_flag", -1);
        ((SharedPreferences.Editor)localObject1).putLong("config_notify_guide_updated_time", NetConnInfoCenter.getServerTime());
        ((SharedPreferences.Editor)localObject1).putInt("readinjoy_push_channel_article_flag", -1);
        ((SharedPreferences.Editor)localObject1).putLong("readinjoy_push_channel_article_updated_time", NetConnInfoCenter.getServerTime());
        RIJSPUtils.a((SharedPreferences.Editor)localObject1, true);
        ReadInJoyManager.c(this.b.a);
      }
      else if (this.a.getAction().equals("config_local_channel_flag"))
      {
        ConfigServlet.c(ReadInJoyManager.d(this.b.a), ReadInJoyManager.d(this.b.a).getCurrentAccountUin());
      }
      else
      {
        int i;
        int j;
        if (this.a.getAction().equals("config_follow_uin"))
        {
          i = this.a.getIntExtra("follow_uin_position", -1);
          j = this.a.getIntExtra("follow_uin_smooth_dx", 0);
          localObject1 = this.a.getStringExtra("follow_uin");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ReadInJoyLogicEngine.a().c().request0x978(ReadInJoyManager.d(this.b.a).getAccount(), (String)localObject1, true, "", new ReadInJoyManager.ReadInJoyPublicAccountObserver(i, j, (String)localObject1));
          }
        }
        else
        {
          boolean bool = this.a.getAction().equals("config_update_app_setting");
          localObject1 = null;
          if (bool)
          {
            localObject1 = ReadInJoyHelper.f((QQAppInterface)RIJQQAppInterfaceUtil.e());
            if ((localObject1 != null) && (((LebaViewItem)localObject1).f != 0))
            {
              ((LebaViewItem)localObject1).f = 0;
              localObject2 = (ILebaHelperService)ReadInJoyManager.d(this.b.a).getRuntimeService(ILebaHelperService.class, "");
              if (localObject2 != null)
              {
                ((ILebaHelperService)localObject2).updateAppSetting(ReadInJoyManager.d(this.b.a), ((LebaViewItem)localObject1).b.uiResId, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
                ((ILebaHelperService)localObject2).netSetPluginState(String.valueOf(((LebaViewItem)localObject1).b.uiResId), true, NetConnInfoCenter.getServerTimeMillis());
                ((ILebaHelperService)localObject2).notifySetPluginState(1, true, null);
              }
              else
              {
                QLog.d(ReadInJoyManager.a, 1, "onReceive lebaHelperService == null");
              }
            }
          }
          else
          {
            Object localObject3;
            if (this.a.getAction().equals("readInJoy_video_play_real_time_report"))
            {
              localObject1 = this.a.getExtras();
              if (localObject1 != null)
              {
                localObject2 = ((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_AID");
                localObject3 = ((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_VID");
                i = ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RTYPE");
                j = ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RCODE");
                ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).doVideoPlayRealtimeReport((String)localObject2, (String)localObject3, i, j);
              }
            }
            else if (this.a.getAction().equals("notify_main_share_friend_video"))
            {
              ForwardUtils.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), null, ReadInJoyManager.d(this.b.a).getApp(), this.a, null);
            }
            else if (this.a.getAction().equals("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO"))
            {
              localObject2 = this.a.getExtras();
              if (localObject2 != null)
              {
                localObject3 = BaseApplicationImpl.getApplication().getRuntime();
                if ((localObject3 instanceof QQAppInterface)) {
                  localObject1 = (QQAppInterface)localObject3;
                }
                localObject3 = ((Bundle)localObject2).getString("VIDEO_REPORT_TOUIN");
                String str = ((Bundle)localObject2).getString("VIDEO_REPORT_SUBACTION");
                i = ((Bundle)localObject2).getInt("VIDEO_REPORT_FROM_TYPE");
                j = ((Bundle)localObject2).getInt("VIDEO_REPORT_RESULT");
                PublicAccountReportUtils.c((AppInterface)localObject1, (String)localObject3, str, ((Bundle)localObject2).getString("VIDEO_REPORT_ACTION_NAME"), i, j, ((Bundle)localObject2).getString("VIDEO_REPORT_R2"), ((Bundle)localObject2).getString("VIDEO_REPORT_R3"), ((Bundle)localObject2).getString("VIDEO_REPORT_R4"), ((Bundle)localObject2).getString("VIDEO_REPORT_R5"), ((Bundle)localObject2).getBoolean("VIDEO_REPORT_SHOULD_ENCODE"));
              }
            }
          }
        }
      }
    }
    Object localObject1 = new Intent("notify_main_feeds_msg_response");
    BaseApplication.getContext().sendBroadcast((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager.NotifyReceiver.1
 * JD-Core Version:    0.7.0.1
 */