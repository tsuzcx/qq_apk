package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class TransferAppInfo
  extends PlusPanelAppInfo
{
  TransferAppInfo() {}
  
  public TransferAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839299;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 211;
    }
    return 0;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 515;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130211;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131717134);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    paramPlusPanelViewModel.a("chat_tool_qwallettransfer", localQQAppInterface.getCurrentAccountUin());
    paramPlusPanelViewModel.b(paramBaseChatPie);
    Intent localIntent = new Intent(paramBaseChatPie.a(), TransactionActivity.class);
    localIntent.putExtra("come_from", 2);
    int j = 0;
    int i = 0;
    paramPlusPanelViewModel = null;
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("targetNickname", paramSessionInfo.d);
        localJSONObject.put("sign", "");
        if (j != 0) {
          localJSONObject.put("source", j);
        }
        localJSONObject.put("groupType", i);
        if (!TextUtils.isEmpty(paramPlusPanelViewModel)) {
          localJSONObject.put("groupUin", paramPlusPanelViewModel);
        }
      }
      catch (JSONException paramPlusPanelViewModel)
      {
        for (;;)
        {
          paramPlusPanelViewModel.printStackTrace();
        }
      }
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#aio");
      localIntent.putExtra("isJumpToH5", false);
      localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "sessionType=" + paramSessionInfo.jdField_a_of_type_Int, 0, null));
      paramBaseChatPie.a().startActivity(localIntent);
      ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOclick", 0, 0, "", "", "", "");
      AIOPanelUtiles.a(localQQAppInterface, "0X8005CB0", paramSessionInfo.jdField_a_of_type_Int);
      return;
      j = 5;
      i = 3;
      paramPlusPanelViewModel = paramSessionInfo.b;
      continue;
      j = 5;
      i = 4;
      paramPlusPanelViewModel = paramSessionInfo.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TransferAppInfo
 * JD-Core Version:    0.7.0.1
 */