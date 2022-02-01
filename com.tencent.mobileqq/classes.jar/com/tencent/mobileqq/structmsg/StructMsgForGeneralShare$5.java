package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.SystemClock;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.sdk.report.SdkShareReporter;
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
    StructMsgForGeneralShare localStructMsgForGeneralShare;
    Object localObject3;
    label146:
    Context localContext;
    ChatFragment localChatFragment;
    Object localObject4;
    Object localObject2;
    if (SystemClock.uptimeMillis() - this.a >= 1000L)
    {
      this.a = SystemClock.uptimeMillis();
      Object localObject5 = paramView.findViewById(2131377989);
      if (localObject5 != null)
      {
        Object localObject1 = ((View)localObject5).getTag(2131377989);
        if ((localObject1 != null) && (StructMsgForGeneralShare.class.isInstance(localObject1)))
        {
          localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject1;
          localObject1 = paramView.getTag();
          if (localObject1 != null)
          {
            if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
            {
              localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
              break label146;
            }
            if (paramView.getTag(2131377986) == null) {
              break label1853;
            }
          }
          else
          {
            if (paramView.getTag(2131377986) == null) {
              break label1853;
            }
          }
          localObject3 = null;
          localContext = paramView.getContext();
          localChatFragment = ((BaseActivity)localContext).getChatFragment();
          if (localChatFragment != null) {
            localObject1 = localChatFragment.a();
          }
          for (;;)
          {
            break;
            localObject1 = BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {
              localObject1 = (QQAppInterface)localObject1;
            } else {
              localObject1 = null;
            }
          }
          if (localObject1 != null) {
            if ("micro_app".equals(localStructMsgForGeneralShare.mMsg_A_ActionData))
            {
              try
              {
                localObject3 = new JSONObject(localStructMsgForGeneralShare.mMsgActionData);
                localObject1 = ((JSONObject)localObject3).optString("appId");
                localObject3 = ((JSONObject)localObject3).optString("entryPath");
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label1853;
                }
                MiniAppLauncher.launchMiniApp(localContext, (String)localObject1, localStructMsgForGeneralShare, (String)localObject3);
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
            }
            else
            {
              AbsShareMsg.doReport(localThrowable, localStructMsgForGeneralShare);
              PublicAccountEventReport.a(localThrowable, 0, 4, localStructMsgForGeneralShare.message);
              Object localObject7;
              if ((localStructMsgForGeneralShare != null) && (localStructMsgForGeneralShare.message != null) && ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg")))) {
                try
                {
                  localObject7 = new JSONObject();
                  ((JSONObject)localObject7).put("puin", localStructMsgForGeneralShare.message.frienduin);
                  ((JSONObject)localObject7).put("type", localStructMsgForGeneralShare.index_type);
                  ((JSONObject)localObject7).put("index", localStructMsgForGeneralShare.index);
                  ((JSONObject)localObject7).put("name", localStructMsgForGeneralShare.index_name);
                  ((JSONObject)localObject7).put("net", String.valueOf(HttpUtil.getNetWorkType()));
                  ((JSONObject)localObject7).put("mobile_imei", DeviceInfoUtil.a());
                  ((JSONObject)localObject7).put("obj", "");
                  ((JSONObject)localObject7).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject7).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  IPAReportUtil localIPAReportUtil = (IPAReportUtil)QRoute.api(IPAReportUtil.class);
                  localObject6 = localStructMsgForGeneralShare.message.selfuin;
                  localObject7 = ((JSONObject)localObject7).toString();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("");
                  try
                  {
                    localStringBuilder.append(localStructMsgForGeneralShare.msgId);
                    localIPAReportUtil.reportClickEventForAdver(localThrowable, (String)localObject6, (String)localObject7, localStringBuilder.toString());
                  }
                  catch (JSONException localJSONException1) {}
                  localJSONException2.printStackTrace();
                }
                catch (JSONException localJSONException2) {}
              }
              Object localObject6 = (EcShopAssistantManager)localThrowable.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
              localObject4 = (EcshopReportHandler)localThrowable.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
              int i;
              if ((localStructMsgForGeneralShare.message != null) && (localObject6 != null) && (localObject4 != null) && (((EcShopAssistantManager)localObject6).a(localStructMsgForGeneralShare.message.senderuin)))
              {
                localObject6 = localStructMsgForGeneralShare.message;
                if (TextUtils.isEmpty(localStructMsgForGeneralShare.index)) {
                  i = 0;
                } else {
                  i = Integer.parseInt(localStructMsgForGeneralShare.index);
                }
                ((EcshopReportHandler)localObject4).a(false, (MessageRecord)localObject6, i, localStructMsgForGeneralShare.mMsgUrl);
              }
              if (localStructMsgForGeneralShare.msgId > 0L)
              {
                ReportController.b(localThrowable, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(localStructMsgForGeneralShare.msgId), "");
                ThreadManager.getSubThreadHandler().postDelayed(new StructMsgForGeneralShare.5.1(this, localStructMsgForGeneralShare, localThrowable), 0L);
              }
              localObject4 = localThrowable;
              if (QLog.isDevelopLevel()) {
                QLog.d(StructMsgForGeneralShare.access$000(), 4, "geneal struct msg onclick middle ........");
              }
              if ((localObject3 != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a != null)) {
                Util.a((AppRuntime)localObject4, "", "click", localStructMsgForGeneralShare.mSourceAppid, localStructMsgForGeneralShare.mMsgServiceID, Util.a(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int));
              }
              if (localStructMsgForGeneralShare.uinType == 0) {
                i = 0;
              } else if (localStructMsgForGeneralShare.uinType == 1) {
                i = 1;
              } else if (localStructMsgForGeneralShare.uinType == 3000) {
                i = 2;
              } else {
                i = 3;
              }
              localObject6 = localStructMsgForGeneralShare.mMsgUrl;
              localObject2 = localObject6;
              int j;
              if (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgUrl))
              {
                j = localStructMsgForGeneralShare.mMsgUrl.indexOf("article_id=");
                localObject2 = localObject6;
                if (j > 0)
                {
                  localObject7 = localStructMsgForGeneralShare.mMsgUrl.substring(j + 11);
                  j = ((String)localObject7).indexOf("&");
                  localObject2 = localObject6;
                  if (j >= 0) {
                    localObject2 = ((String)localObject7).substring(0, j);
                  }
                }
              }
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append(localStructMsgForGeneralShare.mMsgServiceID);
              ((StringBuilder)localObject6).append("");
              ReportController.b((AppRuntime)localObject4, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, ((StringBuilder)localObject6).toString(), "", "", "");
              if (localStructMsgForGeneralShare.uinType == 1008) {
                j = 2;
              } else {
                j = 1;
              }
              ReportController.b((AppRuntime)localObject4, "CliOper", "", "", "0X8004B5C", "0X8004B5C", j, 0, "", String.valueOf(i), (String)localObject2, localStructMsgForGeneralShare.source_puin);
              SdkShareReporter.b("1", localStructMsgForGeneralShare.uinType, localStructMsgForGeneralShare.mContentTitle, localStructMsgForGeneralShare.mSourceAppid);
              if ((localObject5 instanceof ViewGroup))
              {
                localObject2 = ((ViewGroup)localObject5).getChildAt(0);
                if ((localObject2 != null) && ((localObject2 instanceof TextViewWrapLayout)))
                {
                  localObject2 = ((View)localObject2).getTag(StructMsgForGeneralShare.access$200());
                  if ((localObject2 != null) && ((localObject2 instanceof StructMsgItemLayout2)))
                  {
                    localObject5 = new StringBuilder();
                    ((StringBuilder)localObject5).append(((StructMsgItemLayout2)localObject2).o);
                    ((StringBuilder)localObject5).append("");
                    ReportController.b((AppRuntime)localObject4, "dc00898", "", "", "0X8007C38", "0X8007C38", 0, 0, ((StringBuilder)localObject5).toString(), "", "", "");
                  }
                }
              }
              if ((localObject3 != null) && (localStructMsgForGeneralShare.hasFlag(16)))
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg click report.........");
                }
                ThreadManager.post(new StructMsgForGeneralShare.5.2(this, (StructingMsgItemBuilder.StructingMsgViewHolder)localObject3, (QQAppInterface)localObject4), 2, null, false);
              }
              if ((localStructMsgForGeneralShare != null) && (localObject3 != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a != null) && ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int == 1025) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int == 0)) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (BmqqSegmentUtil.c(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_JavaLangString)) && ((localStructMsgForGeneralShare.mMsgServiceID != 92) || (localStructMsgForGeneralShare.message == null))) {}
            }
          }
        }
      }
    }
    label1627:
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, String.format("click qidian bulk msg, taskId: %d", new Object[] { Integer.valueOf(Integer.parseInt(localStructMsgForGeneralShare.mQidianBulkTaskId)) }));
      }
      if (!localStructMsgForGeneralShare.mQidianBulkTaskId.equals("0"))
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("action", "click");
        ((JSONObject)localObject2).put("fromUin", localStructMsgForGeneralShare.message.frienduin);
        ((JSONObject)localObject2).put("toUin", ((QQAppInterface)localObject4).getCurrentAccountUin());
        ((JSONObject)localObject2).put("taskID", localStructMsgForGeneralShare.mQidianBulkTaskId);
        ((JSONObject)localObject2).put("clickURL", localStructMsgForGeneralShare.mMsgUrl);
        ((JSONObject)localObject2).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
        ((QidianHandler)((QQAppInterface)localObject4).getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(((JSONObject)localObject2).toString(), localStructMsgForGeneralShare.message.frienduin, "", 10009, 0);
      }
    }
    catch (Exception localException)
    {
      label1507:
      break label1507;
    }
    ((QidianManager)((QQAppInterface)localObject4).getManager(QQManagerFactory.QIDIAN_MANAGER)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl, 0, "");
    break label1627;
    if ((localStructMsgForGeneralShare != null) && (localObject3 != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a != null) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgAction)) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int == 1024)) {
      ((QidianManager)((QQAppInterface)localObject4).getManager(QQManagerFactory.QIDIAN_MANAGER)).a(localStructMsgForGeneralShare.mMsgAction, localStructMsgForGeneralShare.mMsg_A_ActionData, localStructMsgForGeneralShare.mMsgActionData, localStructMsgForGeneralShare.mMsgUrl, 1, "");
    }
    if ((localObject3 != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a)) && (localStructMsgForGeneralShare.message != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localStructMsgForGeneralShare.message.time);
      ((StringBuilder)localObject2).append("");
      ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.message.click", 0, 0, ((StringBuilder)localObject2).toString(), "", "", localStructMsgForGeneralShare.mMsgBrief);
    }
    if ((paramView != null) && (localObject3 != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a != null) && (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_JavaLangString)) && (localStructMsgForGeneralShare.message != null)) {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).reportStructClick(paramView.getContext(), localStructMsgForGeneralShare.message);
    }
    if (localChatFragment != null)
    {
      localObject2 = localChatFragment.a();
      if ((localObject2 instanceof PublicAccountChatPie)) {
        ((PublicAccountChatPie)localObject2).a.b();
      }
    }
    StructMsgForGeneralShare.onClickEvent((QQAppInterface)localObject4, localContext, localStructMsgForGeneralShare, paramView, new StructMsgForGeneralShare.GeneralClickHandler((QQAppInterface)localObject4, paramView, localStructMsgForGeneralShare));
    label1853:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5
 * JD-Core Version:    0.7.0.1
 */