package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class StructMsgItemPAVideo$1
  implements View.OnClickListener
{
  StructMsgItemPAVideo$1(StructMsgItemPAVideo paramStructMsgItemPAVideo) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.getContext();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("file_send_path", StructMsgItemPAVideo.a(this.a));
    ((Bundle)localObject3).putInt("video_play_caller", 2);
    ((Bundle)localObject3).putLong("message_click_start", System.currentTimeMillis());
    try
    {
      localObject1 = AIOUtils.a(paramView);
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject1;
      label54:
      StructMsgForGeneralShare localStructMsgForGeneralShare;
      break label54;
    }
    localObject1 = null;
    if (localObject1 != null) {
      localObject1 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
    } else {
      localObject1 = "";
    }
    ((Bundle)localObject3).putString("ad_gdt", (String)localObject1);
    localStructMsgForGeneralShare = this.a.a(paramView);
    if (localStructMsgForGeneralShare == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("structmsg.StructMsgItemVideoForPA", 2, "StructMsgForGeneralShare == NULL");
      }
    }
    else
    {
      ((Bundle)localObject3).putString("msg_id", String.valueOf(localStructMsgForGeneralShare.msgId));
      if ((StructMsgItemPAVideo.b(this.a) != null) && (!StructMsgItemPAVideo.b(this.a).equals("")))
      {
        ((Bundle)localObject3).putString("struct_msg_video_info", StructMsgItemPAVideo.b(this.a));
        ((Bundle)localObject3).putString("from_uin", localStructMsgForGeneralShare.currentAccountUin);
        ((Bundle)localObject3).putInt("from_uin_type", 1008);
        ((Bundle)localObject3).putString("from_session_uin", localStructMsgForGeneralShare.uin);
      }
    }
    try
    {
      localObject1 = new JSONObject(StructMsgItemPAVideo.b(this.a)).getString("file_uuid");
    }
    catch (Exception localException)
    {
      label224:
      Object localObject4;
      break label224;
    }
    localObject1 = "";
    localObject4 = new Intent((Context)localObject2, ShortVideoPlayActivity.class);
    ((Intent)localObject4).putExtras((Bundle)localObject3);
    ((Context)localObject2).startActivity((Intent)localObject4);
    localObject2 = ((BaseActivity)localObject2).getChatFragment().a();
    ReportController.b((AppRuntime)localObject2, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9A", "0X8005C9A", 0, 1, 0, localStructMsgForGeneralShare.uin, localStructMsgForGeneralShare.currentAccountUin, StructMsgItemPAVideo.a(this.a), (String)localObject1);
    if ((localStructMsgForGeneralShare.message != null) && ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg")))) {
      try
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("puin", localStructMsgForGeneralShare.message.frienduin);
        ((JSONObject)localObject4).put("type", this.a.l);
        ((JSONObject)localObject4).put("index", this.a.j);
        ((JSONObject)localObject4).put("name", this.a.k);
        ((JSONObject)localObject4).put("net", String.valueOf(HttpUtil.getNetWorkType()));
        ((JSONObject)localObject4).put("mobile_imei", DeviceInfoUtil.a());
        ((JSONObject)localObject4).put("obj", "");
        ((JSONObject)localObject4).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
        ((JSONObject)localObject4).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
        localObject1 = (IPAReportUtil)QRoute.api(IPAReportUtil.class);
        localObject3 = localStructMsgForGeneralShare.message.selfuin;
        localObject4 = ((JSONObject)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localStructMsgForGeneralShare.msgId);
        ((IPAReportUtil)localObject1).reportClickEventForAdver((AppInterface)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo.1
 * JD-Core Version:    0.7.0.1
 */