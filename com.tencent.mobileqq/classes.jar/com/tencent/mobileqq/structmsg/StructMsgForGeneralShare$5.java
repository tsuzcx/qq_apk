package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

final class StructMsgForGeneralShare$5
  implements View.OnClickListener
{
  long a;
  
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick start ........");
    }
    if (SystemClock.uptimeMillis() - this.a < 1000L) {}
    label1667:
    label1802:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a = SystemClock.uptimeMillis();
      View localView = paramView.findViewById(2131378578);
      if (localView != null)
      {
        Object localObject1 = localView.getTag(2131378578);
        if ((localObject1 != null) && (StructMsgForGeneralShare.class.isInstance(localObject1)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject1;
          localObject1 = paramView.getTag();
          Object localObject3;
          Context localContext;
          ChatFragment localChatFragment;
          if (localObject1 != null) {
            if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
            {
              localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
              localContext = paramView.getContext();
              localChatFragment = ((FragmentActivity)localContext).getChatFragment();
              if (localChatFragment == null) {
                break label253;
              }
              localObject1 = localChatFragment.a();
            }
          }
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                if (localObject1 == null) {
                  break label1802;
                }
                if (!"micro_app".equals(localStructMsgForGeneralShare.mMsg_A_ActionData)) {
                  break label284;
                }
                try
                {
                  localObject3 = new JSONObject(localStructMsgForGeneralShare.mMsgActionData);
                  localObject1 = ((JSONObject)localObject3).optString("appId");
                  localObject3 = ((JSONObject)localObject3).optString("entryPath");
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break;
                  }
                  MiniAppLauncher.launchMiniApp(localContext, (String)localObject1, localStructMsgForGeneralShare, (String)localObject3);
                }
                catch (Throwable localThrowable)
                {
                  localThrowable.printStackTrace();
                }
              }
              break;
              if (paramView.getTag(2131378575) == null) {
                break;
              }
              do
              {
                localObject3 = null;
                break;
              } while (paramView.getTag(2131378575) != null);
              break;
              label253:
              localObject2 = BaseApplicationImpl.getApplication().getRuntime();
              if ((localObject2 != null) && ((localObject2 instanceof QQAppInterface)))
              {
                localObject2 = (QQAppInterface)localObject2;
                continue;
                label284:
                AbsShareMsg.doReport((QQAppInterface)localObject2, localStructMsgForGeneralShare);
                PublicAccountEventReport.a((QQAppInterface)localObject2, 0, 4, localStructMsgForGeneralShare.message);
                if ((localStructMsgForGeneralShare != null) && (localStructMsgForGeneralShare.message != null) && ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg")))) {}
                try
                {
                  Object localObject4 = new JSONObject();
                  ((JSONObject)localObject4).put("puin", localStructMsgForGeneralShare.message.frienduin);
                  ((JSONObject)localObject4).put("type", localStructMsgForGeneralShare.index_type);
                  ((JSONObject)localObject4).put("index", localStructMsgForGeneralShare.index);
                  ((JSONObject)localObject4).put("name", localStructMsgForGeneralShare.index_name);
                  ((JSONObject)localObject4).put("net", String.valueOf(HttpUtil.getNetWorkType()));
                  ((JSONObject)localObject4).put("mobile_imei", DeviceInfoUtil.a());
                  ((JSONObject)localObject4).put("obj", "");
                  ((JSONObject)localObject4).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject4).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  ((IPAReportUtil)QRoute.api(IPAReportUtil.class)).reportClickEventForAdver((AppInterface)localObject2, localStructMsgForGeneralShare.message.selfuin, ((JSONObject)localObject4).toString(), "" + localStructMsgForGeneralShare.msgId);
                  Object localObject5 = (EcShopAssistantManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
                  localObject4 = (EcshopReportHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
                  if ((localStructMsgForGeneralShare.message != null) && (localObject5 != null) && (localObject4 != null) && (((EcShopAssistantManager)localObject5).a(localStructMsgForGeneralShare.message.senderuin)))
                  {
                    localObject5 = localStructMsgForGeneralShare.message;
                    if (TextUtils.isEmpty(localStructMsgForGeneralShare.index))
                    {
                      i = 0;
                      ((EcshopReportHandler)localObject4).a(false, (MessageRecord)localObject5, i, localStructMsgForGeneralShare.mMsgUrl);
                    }
                  }
                  else
                  {
                    if (localStructMsgForGeneralShare.msgId > 0L)
                    {
                      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForGeneralShare.msgId), "");
                      ThreadManager.getSubThreadHandler().postDelayed(new StructMsgForGeneralShare.5.1(this, localStructMsgForGeneralShare, (QQAppInterface)localObject2), 0L);
                    }
                    if (QLog.isDevelopLevel()) {
                      QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick middle ........");
                    }
                    if ((localObject3 != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a != null)) {
                      Util.a((AppRuntime)localObject2, "", "click", localStructMsgForGeneralShare.mSourceAppid, localStructMsgForGeneralShare.mMsgServiceID, Util.a(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int));
                    }
                    if (localStructMsgForGeneralShare.uinType != 0) {
                      break label1667;
                    }
                    i = 0;
                    localObject4 = localStructMsgForGeneralShare.mMsgUrl;
                    if (TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgUrl)) {
                      break label1795;
                    }
                    j = localStructMsgForGeneralShare.mMsgUrl.indexOf("article_id=");
                    if (j <= 0) {
                      break label1795;
                    }
                    localObject5 = localStructMsgForGeneralShare.mMsgUrl.substring("article_id=".length() + j);
                    j = ((String)localObject5).indexOf("&");
                    if (j < 0) {
                      break label1795;
                    }
                    localObject4 = ((String)localObject5).substring(0, j);
                    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, localStructMsgForGeneralShare.mMsgServiceID + "", "", "", "");
                    if (localStructMsgForGeneralShare.uinType != 1008) {
                      break label1702;
                    }
                    j = 2;
                    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004B5C", "0X8004B5C", j, 0, "", String.valueOf(i), (String)localObject4, localStructMsgForGeneralShare.source_puin);
                    ReportController.b(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, 0, "1", ForwardUtils.b(localStructMsgForGeneralShare.uinType), localStructMsgForGeneralShare.mContentTitle, String.valueOf(localStructMsgForGeneralShare.mSourceAppid));
                    if (QLog.isColorLevel()) {
                      QLog.d(StructMsgForGeneralShare.access$000(), 2, new Object[] { "图文分享内容点击=", "0X800A630", ", mContentTitle=" + localStructMsgForGeneralShare.mContentTitle, ", uinType=", ForwardUtils.b(localStructMsgForGeneralShare.uinType) });
                    }
                    if ((localView instanceof ViewGroup))
                    {
                      localObject4 = ((ViewGroup)localView).getChildAt(0);
                      if ((localObject4 != null) && ((localObject4 instanceof TextViewWrapLayout)))
                      {
                        localObject4 = ((View)localObject4).getTag(StructMsgForGeneralShare.access$200());
                        if ((localObject4 != null) && ((localObject4 instanceof StructMsgItemLayout2))) {
                          ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X8007C38", "0X8007C38", 0, 0, ((StructMsgItemLayout2)localObject4).o + "", "", "", "");
                        }
                      }
                    }
                    if ((localObject3 != null) && (localStructMsgForGeneralShare.hasFlag(16)))
                    {
                      if (QLog.isDevelopLevel()) {
                        QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg click report.........");
                      }
                      ThreadManager.post(new StructMsgForGeneralShare.5.2(this, (StructingMsgItemBuilder.StructingMsgViewHolder)localObject3, (QQAppInterface)localObject2), 2, null, false);
                    }
                    if ((localStructMsgForGeneralShare != null) && (localObject3 != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a != null) && ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int == 1025) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int == 0)) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (BmqqSegmentUtil.b(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_JavaLangString)) && ((localStructMsgForGeneralShare.mMsgServiceID != 92) || (localStructMsgForGeneralShare.message == null))) {}
                  }
                  try
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d(StructMsgForGeneralShare.access$000(), 2, String.format("click qidian bulk msg, taskId: %d", new Object[] { Integer.valueOf(Integer.parseInt(localStructMsgForGeneralShare.mQidianBulkTaskId)) }));
                    }
                    if (!localStructMsgForGeneralShare.mQidianBulkTaskId.equals("0"))
                    {
                      localObject4 = new JSONObject();
                      ((JSONObject)localObject4).put("action", "click");
                      ((JSONObject)localObject4).put("fromUin", localStructMsgForGeneralShare.message.frienduin);
                      ((JSONObject)localObject4).put("toUin", ((QQAppInterface)localObject2).getCurrentAccountUin());
                      ((JSONObject)localObject4).put("taskID", localStructMsgForGeneralShare.mQidianBulkTaskId);
                      ((JSONObject)localObject4).put("clickURL", localStructMsgForGeneralShare.mMsgUrl);
                      ((JSONObject)localObject4).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
                      ((QidianHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(((JSONObject)localObject4).toString(), localStructMsgForGeneralShare.message.frienduin, "", 10009, 0);
                    }
                  }
                  catch (Exception localException)
                  {
                    label1462:
                    break label1462;
                  }
                  ((QidianManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.QIDIAN_MANAGER)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl, 0, "");
                  if ((localObject3 != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a)) && (localStructMsgForGeneralShare.message != null)) {
                    ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.message.click", 0, 0, localStructMsgForGeneralShare.message.time + "", "", "", localStructMsgForGeneralShare.mMsgBrief);
                  }
                  if (localChatFragment != null)
                  {
                    localObject3 = localChatFragment.a();
                    if ((localObject3 instanceof PublicAccountChatPie)) {
                      ((PublicAccountChatPie)localObject3).a.b();
                    }
                  }
                  StructMsgForGeneralShare.onClickEvent((QQAppInterface)localObject2, localContext, localStructMsgForGeneralShare, paramView, new StructMsgForGeneralShare.GeneralClickHandler((QQAppInterface)localObject2, paramView, localStructMsgForGeneralShare));
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    int j;
                    localJSONException.printStackTrace();
                    continue;
                    int i = Integer.parseInt(localStructMsgForGeneralShare.index);
                    continue;
                    if (localStructMsgForGeneralShare.uinType == 1)
                    {
                      i = 1;
                    }
                    else if (localStructMsgForGeneralShare.uinType == 3000)
                    {
                      i = 2;
                    }
                    else
                    {
                      i = 3;
                      continue;
                      label1702:
                      j = 1;
                      continue;
                      if ((localStructMsgForGeneralShare != null) && (localObject3 != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a != null) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int == 1024)) {
                        ((QidianManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.QIDIAN_MANAGER)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl, 1, "");
                      }
                    }
                  }
                }
              }
            }
            Object localObject2 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5
 * JD-Core Version:    0.7.0.1
 */