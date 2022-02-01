package com.tencent.mobileqq.kandian.repo.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.report.UserActionReportUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.FeedExpInfo;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.FeedScrollStateInfo;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.GestureEvent;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ActiveZoneFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedExpInfo;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedScrollStateInfo;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsCtxFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsExpFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureEvent;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureFeature;
import tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ReqBody;

class UserOperationModule$7
  implements Runnable
{
  UserOperationModule$7(UserOperationModule paramUserOperationModule, UserActionCollector paramUserActionCollector, Context paramContext) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new oidb_cmd0xde0.ReqBody();
      Object localObject2 = new oidb_cmd0xde0.ActiveZoneFeature();
      ((oidb_cmd0xde0.ActiveZoneFeature)localObject2).top.set(this.a.t[0]);
      ((oidb_cmd0xde0.ActiveZoneFeature)localObject2).bottom.set(this.a.t[1]);
      ((oidb_cmd0xde0.ReqBody)localObject1).active_zone.set((MessageMicro)localObject2);
      localObject2 = new oidb_cmd0xde0.FeedsCtxFeature();
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_device_id.set(RIJDeviceUtil.a());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_device_model.set(UserActionReportUtils.getDeviceModel());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_enter_reason.set(this.a.p);
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_headset.set(UserActionReportUtils.isHasHeadset(this.b));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_lightness.set((float)UserActionReportUtils.getScreenLightness(this.b));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_network_type.set(UserOperationModule.access$100(this.this$0));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_power.set((float)UserActionReportUtils.getBatteryLevel());
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_screen_info.set(UserActionReportUtils.getScreenSizeInfo(this.b));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_volume.set((float)UserActionReportUtils.getDeviceVolume(this.b));
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).timestamp.set(System.currentTimeMillis() / 1000L);
      ((oidb_cmd0xde0.FeedsCtxFeature)localObject2).ctx_scene.set(this.a.q);
      ((oidb_cmd0xde0.ReqBody)localObject1).ctx_feature.set((MessageMicro)localObject2);
      localObject2 = new StringBuilder("UserActionCollector: ");
      Object localObject3 = new oidb_cmd0xde0.GestureFeature();
      Iterator localIterator = new ArrayList(this.a.n).iterator();
      Object localObject5;
      Object localObject4;
      while (localIterator.hasNext())
      {
        localObject5 = (UserActionCollector.GestureEvent)localIterator.next();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(localObject5);
        ((StringBuilder)localObject4).append("\n");
        ((StringBuilder)localObject2).append(((StringBuilder)localObject4).toString());
        localObject4 = new oidb_cmd0xde0.GestureEvent();
        if (!TextUtils.isEmpty(((UserActionCollector.GestureEvent)localObject5).g))
        {
          ((oidb_cmd0xde0.GestureEvent)localObject4).ges_click_point.set(((UserActionCollector.GestureEvent)localObject5).g);
        }
        else
        {
          ((oidb_cmd0xde0.GestureEvent)localObject4).ges_scroll_direction.set(((UserActionCollector.GestureEvent)localObject5).a);
          ((oidb_cmd0xde0.GestureEvent)localObject4).ges_scroll_distance.set((float)((UserActionCollector.GestureEvent)localObject5).c);
          ((oidb_cmd0xde0.GestureEvent)localObject4).ges_scroll_mills.set(((UserActionCollector.GestureEvent)localObject5).d);
          ((oidb_cmd0xde0.GestureEvent)localObject4).ges_scroll_speed.set(((UserActionCollector.GestureEvent)localObject5).e);
          if (!TextUtils.isEmpty(((UserActionCollector.GestureEvent)localObject5).f)) {
            ((oidb_cmd0xde0.GestureEvent)localObject4).ges_scroll_downNup.set(((UserActionCollector.GestureEvent)localObject5).f);
          }
          localObject5 = ((UserActionCollector.GestureEvent)localObject5).h.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            UserActionCollector.FeedScrollStateInfo localFeedScrollStateInfo = (UserActionCollector.FeedScrollStateInfo)((Iterator)localObject5).next();
            oidb_cmd0xde0.FeedScrollStateInfo localFeedScrollStateInfo1 = new oidb_cmd0xde0.FeedScrollStateInfo();
            localFeedScrollStateInfo1.enter_active_zone_speed.set((float)localFeedScrollStateInfo.g);
            if (!TextUtils.isEmpty(localFeedScrollStateInfo.a)) {
              localFeedScrollStateInfo1.feeds_id.set(localFeedScrollStateInfo.a);
            }
            localFeedScrollStateInfo1.start_top.set(localFeedScrollStateInfo.c);
            localFeedScrollStateInfo1.start_bottom.set(localFeedScrollStateInfo.e);
            localFeedScrollStateInfo1.stop_top.set(localFeedScrollStateInfo.d);
            localFeedScrollStateInfo1.stop_bottom.set(localFeedScrollStateInfo.f);
            ((oidb_cmd0xde0.GestureEvent)localObject4).get_scroll_feeds_info.add(localFeedScrollStateInfo1);
          }
        }
        ((oidb_cmd0xde0.GestureFeature)localObject3).gesture_event.add((MessageMicro)localObject4);
      }
      ((oidb_cmd0xde0.ReqBody)localObject1).usr_gesture_feature.set((MessageMicro)localObject3);
      localObject3 = new oidb_cmd0xde0.FeedsExpFeature();
      ((oidb_cmd0xde0.FeedsExpFeature)localObject3).exp_chnl_duration.set(this.a.h());
      ((oidb_cmd0xde0.FeedsExpFeature)localObject3).exp_first_scrn_duration.set(this.a.f());
      ((oidb_cmd0xde0.FeedsExpFeature)localObject3).exp_last_scrn_duration.set(this.a.g());
      ((oidb_cmd0xde0.FeedsExpFeature)localObject3).is_user_active.set(this.a.u);
      localIterator = this.a.l.iterator();
      while (localIterator.hasNext())
      {
        localObject4 = (UserActionCollector.FeedExpInfo)localIterator.next();
        localObject5 = new oidb_cmd0xde0.FeedExpInfo();
        if (!TextUtils.isEmpty(((UserActionCollector.FeedExpInfo)localObject4).a)) {
          ((oidb_cmd0xde0.FeedExpInfo)localObject5).feeds_id.set(((UserActionCollector.FeedExpInfo)localObject4).a);
        }
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).exp_duration.set(((UserActionCollector.FeedExpInfo)localObject4).k);
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).exp_duration_in_active_zone.set(((UserActionCollector.FeedExpInfo)localObject4).l);
        if (!TextUtils.isEmpty(((UserActionCollector.FeedExpInfo)localObject4).m)) {
          ((oidb_cmd0xde0.FeedExpInfo)localObject5).exp_orientation.set(((UserActionCollector.FeedExpInfo)localObject4).m);
        }
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).exp_pos_in_list.set(((UserActionCollector.FeedExpInfo)localObject4).h);
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).feed_card_height.set(((UserActionCollector.FeedExpInfo)localObject4).e);
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).is_clicked.set(((UserActionCollector.FeedExpInfo)localObject4).i);
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).is_first_scrn.set(((UserActionCollector.FeedExpInfo)localObject4).f);
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).is_last_scrn.set(((UserActionCollector.FeedExpInfo)localObject4).g);
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).style.set(((UserActionCollector.FeedExpInfo)localObject4).c);
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).word_cnt_for_display.set(((UserActionCollector.FeedExpInfo)localObject4).d);
        ((oidb_cmd0xde0.FeedExpInfo)localObject5).read_duratiion.set(((UserActionCollector.FeedExpInfo)localObject4).j);
        if (!TextUtils.isEmpty(((UserActionCollector.FeedExpInfo)localObject4).b)) {
          ((oidb_cmd0xde0.FeedExpInfo)localObject5).rec_reason.set(((UserActionCollector.FeedExpInfo)localObject4).b);
        }
        ((oidb_cmd0xde0.FeedsExpFeature)localObject3).exp_feeds.add((MessageMicro)localObject5);
      }
      ((oidb_cmd0xde0.ReqBody)localObject1).feeds_exp_feature.set((MessageMicro)localObject3);
      ((StringBuilder)localObject2).append("\nFeedsExpInfo : ");
      ((StringBuilder)localObject2).append("stayDuration : ");
      ((StringBuilder)localObject2).append(((oidb_cmd0xde0.FeedsExpFeature)localObject3).exp_chnl_duration.get());
      ((StringBuilder)localObject2).append(", hasOpt : ");
      ((StringBuilder)localObject2).append(((oidb_cmd0xde0.FeedsExpFeature)localObject3).is_user_active.get());
      ((StringBuilder)localObject2).append(", enter2Scroll : ");
      ((StringBuilder)localObject2).append(((oidb_cmd0xde0.FeedsExpFeature)localObject3).exp_first_scrn_duration.get());
      ((StringBuilder)localObject2).append(", scroll2exit : ");
      ((StringBuilder)localObject2).append(((oidb_cmd0xde0.FeedsExpFeature)localObject3).exp_last_scrn_duration.get());
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(this.a.l);
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xde0", 3552, 0, ((oidb_cmd0xde0.ReqBody)localObject1).toByteArray());
      this.this$0.sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      AIOUtils.a("UserOperationModule", "report exception!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.7
 * JD-Core Version:    0.7.0.1
 */