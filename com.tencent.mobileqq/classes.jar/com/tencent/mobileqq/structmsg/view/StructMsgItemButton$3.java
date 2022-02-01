package com.tencent.mobileqq.structmsg.view;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.temp.api.impl.EcshopMessageApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IPublicQuickPayService;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class StructMsgItemButton$3
  implements View.OnClickListener
{
  StructMsgItemButton$3(StructMsgItemButton paramStructMsgItemButton) {}
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.a.aR >= 1000L)
    {
      this.a.aR = SystemClock.uptimeMillis();
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && (StructMsgItemButton.class.isInstance(localObject1)))
      {
        Object localObject2 = ((ViewGroup)paramView.getParent().getParent()).getTag(2131446476);
        if ((localObject2 != null) && (StructMsgForGeneralShare.class.isInstance(localObject2)))
        {
          StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)localObject2;
          StructMsgItemButton localStructMsgItemButton = (StructMsgItemButton)localObject1;
          Object localObject4 = paramView.getContext();
          if ((localObject4 instanceof BaseActivity))
          {
            localObject1 = ((BaseActivity)localObject4).getChatFragment();
            if (localObject1 != null) {
              localObject1 = ((ChatFragment)localObject1).j();
            }
            for (;;)
            {
              break;
              localObject1 = BaseApplicationImpl.getApplication().getRuntime();
              if ((localObject1 instanceof QQAppInterface)) {
                localObject1 = (QQAppInterface)localObject1;
              } else {
                localObject1 = null;
              }
            }
            if (localObject1 != null)
            {
              if (localStructMsgForGeneralShare.message != null) {
                localObject2 = localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg");
              } else {
                localObject2 = "0";
              }
              Object localObject5;
              if ("1".equals(localObject2)) {
                try
                {
                  Object localObject6 = new JSONObject();
                  ((JSONObject)localObject6).put("puin", localStructMsgForGeneralShare.message.frienduin);
                  ((JSONObject)localObject6).put("type", localStructMsgItemButton.n);
                  ((JSONObject)localObject6).put("index", localStructMsgItemButton.l);
                  ((JSONObject)localObject6).put("name", localStructMsgItemButton.m);
                  ((JSONObject)localObject6).put("net", String.valueOf(HttpUtil.getNetWorkType()));
                  ((JSONObject)localObject6).put("mobile_imei", DeviceInfoUtil.b());
                  ((JSONObject)localObject6).put("obj", "");
                  ((JSONObject)localObject6).put("gdt_cli_data", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                  ((JSONObject)localObject6).put("view_id", localStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                  localObject2 = (IPAReportUtil)QRoute.api(IPAReportUtil.class);
                  localObject5 = localStructMsgForGeneralShare.message.selfuin;
                  localObject6 = ((JSONObject)localObject6).toString();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("");
                  localStringBuilder.append(localStructMsgForGeneralShare.msgId);
                  ((IPAReportUtil)localObject2).reportClickEventForAdver((AppInterface)localObject1, (String)localObject5, (String)localObject6, localStringBuilder.toString());
                }
                catch (JSONException localJSONException)
                {
                  localJSONException.printStackTrace();
                }
              }
              Object localObject3 = new StructMsgClickHandler((QQAppInterface)localObject1, paramView, localStructMsgForGeneralShare.message);
              boolean bool = EcshopMessageApiImpl.enterGdtCanvasActivity((BaseQQAppInterface)localObject1, this.a, (Activity)localObject4);
              if (!bool) {
                if (localStructMsgItemButton.r())
                {
                  if (localStructMsgItemButton.q())
                  {
                    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Pb_account_lifeservice", localStructMsgForGeneralShare.uin, "0X80061FE", "0X80061FE", 0, 1, 0, "", "", "", "");
                    ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", ((QQAppInterface)localObject1).getAccount(), "wallet", "publicpaymsg.btn.click", 1, 0, localStructMsgForGeneralShare.uin, "", String.valueOf(localStructMsgForGeneralShare.msgId), "");
                    if (TextUtils.isEmpty(this.a.g)) {
                      localObject3 = this.a.f;
                    } else {
                      localObject3 = this.a.g;
                    }
                    try
                    {
                      localObject3 = new JSONObject((String)localObject3);
                      localObject5 = new StringBuilder();
                      ((StringBuilder)localObject5).append("orderId=");
                      ((StringBuilder)localObject5).append(((JSONObject)localObject3).optString("orderId"));
                      VACDReportUtil.b(((StringBuilder)localObject5).toString(), "qqwallet", "publicpaymsg.pay.click", null, null, 0, null);
                      ((IPublicQuickPayService)((QQAppInterface)localObject1).getRuntimeService(IPublicQuickPayService.class)).publicQuickPay(localStructMsgForGeneralShare.message.frienduin, (JSONObject)localObject3, (Context)localObject4, new StructMsgItemButton.3.1(this, localStructMsgForGeneralShare, (Context)localObject4));
                    }
                    catch (Exception localException)
                    {
                      if (!QLog.isColorLevel()) {
                        break label885;
                      }
                    }
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("pay error:");
                    ((StringBuilder)localObject4).append(localException.getMessage());
                    QLog.e("StructMsgItemButton", 2, ((StringBuilder)localObject4).toString());
                  }
                  else
                  {
                    paramView.setClickable(false);
                    paramView.setOnClickListener(null);
                    paramView.setOnTouchListener(null);
                    paramView.setOnLongClickListener(null);
                  }
                }
                else if (localStructMsgForGeneralShare.message != null)
                {
                  localStructMsgItemButton.d = EcShopAssistantManager.a(localStructMsgForGeneralShare.message.frienduin, localStructMsgItemButton.d, (QQAppInterface)localObject1);
                  if ("1".equals(localStructMsgForGeneralShare.message.getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                    bool = localException.a(localStructMsgItemButton.e, localStructMsgItemButton.d, localStructMsgItemButton.f, localStructMsgItemButton.g, localStructMsgItemButton.ao, new Object[] { Boolean.valueOf(true) });
                  } else {
                    bool = localException.a(localStructMsgItemButton.e, localStructMsgItemButton.d, localStructMsgItemButton.f, localStructMsgItemButton.g, localStructMsgForGeneralShare.msgId, new Object[0]);
                  }
                }
              }
              label885:
              if ((bool) && (localStructMsgForGeneralShare.message.istroop == 1008)) {
                ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).addPublicAccountToRu((AppInterface)localObject1, localStructMsgForGeneralShare.uin);
              }
              QidianManager localQidianManager = (QidianManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.QIDIAN_MANAGER);
              if (QidianManager.a(localStructMsgItemButton.g, localStructMsgItemButton.f, localStructMsgItemButton.d)) {
                localQidianManager.a(localStructMsgItemButton.e, localStructMsgItemButton.g, localStructMsgItemButton.f, localStructMsgItemButton.d, 2, "");
              }
              if ((localStructMsgForGeneralShare.message != null) && (QidianManager.a((QQAppInterface)localObject1, localStructMsgForGeneralShare.message))) {
                localQidianManager.j(localStructMsgItemButton.f);
              }
              if (localStructMsgForGeneralShare.msgId > 0L) {
                ThreadManager.getSubThreadHandler().postDelayed(new StructMsgItemButton.3.2(this, localStructMsgItemButton, localStructMsgForGeneralShare, (QQAppInterface)localObject1, bool), 0L);
              }
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemButton.3
 * JD-Core Version:    0.7.0.1
 */