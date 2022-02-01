package com.tencent.mobileqq.pluspanel.appinfo;

import ahpt;
import ahvi;
import android.content.Intent;
import android.text.TextUtils;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class TransferAppInfo
  extends PlusPanelAppInfo
{
  public TransferAppInfo() {}
  
  public TransferAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839230;
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
    return BaseApplicationImpl.getContext().getString(2131716639);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramahvi.a("chat_tool_qwallettransfer", localQQAppInterface.getCurrentAccountUin());
    paramahvi.b(paramBaseChatPie);
    Intent localIntent = new Intent(paramBaseChatPie.getActivity(), TransactionActivity.class);
    localIntent.putExtra("come_from", 2);
    int j = 0;
    int i = 0;
    paramahvi = null;
    switch (paramSessionInfo.curType)
    {
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("targetUin", paramSessionInfo.curFriendUin);
        localJSONObject.put("targetNickname", paramSessionInfo.curFriendNick);
        localJSONObject.put("sign", "");
        if (j != 0) {
          localJSONObject.put("source", j);
        }
        localJSONObject.put("groupType", i);
        if (!TextUtils.isEmpty(paramahvi)) {
          localJSONObject.put("groupUin", paramahvi);
        }
      }
      catch (JSONException paramahvi)
      {
        for (;;)
        {
          paramahvi.printStackTrace();
        }
      }
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#aio");
      localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "sessionType=" + paramSessionInfo.curType, 0, null));
      paramBaseChatPie.getActivity().startActivity(localIntent);
      bdla.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOclick", 0, 0, "", "", "", "");
      ahpt.a(localQQAppInterface, "0X8005CB0", paramSessionInfo.curType);
      return;
      j = 5;
      i = 3;
      paramahvi = paramSessionInfo.troopUin;
      continue;
      j = 5;
      i = 4;
      paramahvi = paramSessionInfo.troopUin;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TransferAppInfo
 * JD-Core Version:    0.7.0.1
 */