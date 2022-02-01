package com.tencent.mobileqq.qwallet.impl;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IPublicQuickPayService;
import com.tencent.mobileqq.qwallet.IPublicQuickPayService.QQWalletPayCompletionImp;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicQuickPayServiceImpl
  implements IPublicQuickPayService
{
  public static final String TAG = "PublicQuickPayService";
  private Dialog mCustomSingleButtonDialog;
  private BaseQQAppInterface mQQAppInterface;
  
  private void doCallback(IPublicQuickPayService.QQWalletPayCompletionImp paramQQWalletPayCompletionImp, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramQQWalletPayCompletionImp != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("retCode", paramInt);
      localBundle.putString("retMsg", paramString1);
      localBundle.putString("payTime", paramString2);
      localBundle.putString("orderId", paramString3);
      paramQQWalletPayCompletionImp.a(localBundle);
    }
  }
  
  private void showDialog(Context paramContext)
  {
    Dialog localDialog = this.mCustomSingleButtonDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.mCustomSingleButtonDialog.dismiss();
    }
    this.mCustomSingleButtonDialog = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).DialogUtils$createNewUpgradeYYBInstalledDialog(paramContext, HardCodeUtil.a(R.string.by), "", HardCodeUtil.a(R.string.z), new PublicQuickPayServiceImpl.2(this), null, null);
    this.mCustomSingleButtonDialog.show();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mQQAppInterface = ((BaseQQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public boolean publicQuickPay(String paramString, JSONObject paramJSONObject, Context paramContext, IPublicQuickPayService.QQWalletPayCompletionImp paramQQWalletPayCompletionImp)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject1 = this.mQQAppInterface;
      String str1 = "";
      if (!((IQWalletConfigService)((BaseQQAppInterface)localObject1).getRuntimeService(IQWalletConfigService.class, "")).isPublicAccountSupportPay(paramString))
      {
        showDialog(paramContext);
        doCallback(paramQQWalletPayCompletionImp, -4, "auth failed!", null, null);
        return false;
      }
      paramString = paramJSONObject.optString("appId");
      String str2 = paramJSONObject.optString("orderId");
      Object localObject2 = paramJSONObject.optString("expireTime");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("appId", paramString);
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        if (Long.parseLong((String)localObject2) <= NetConnInfoCenter.getServerTimeMillis() / 1000L)
        {
          showDialog(paramContext);
          doCallback(paramQQWalletPayCompletionImp, -6, "expireTime overdue", null, null);
          return false;
        }
        paramContext = new PublicQuickPayServiceImpl.1(this, new Handler(), paramContext, paramQQWalletPayCompletionImp, str2);
        ((Bundle)localObject1).putParcelable("_qwallet_payresult_receiver", paramContext);
        try
        {
          paramQQWalletPayCompletionImp = new JSONObject();
          paramQQWalletPayCompletionImp.put("tokenId", paramJSONObject.optString("tokenId"));
          str2 = paramJSONObject.optString("bargainor_id", "0");
          paramJSONObject = paramJSONObject.optString("channel", "other");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("appid#");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("|bargainor_id#");
          ((StringBuilder)localObject2).append(str2);
          ((StringBuilder)localObject2).append("|channel#");
          ((StringBuilder)localObject2).append(paramJSONObject);
          paramQQWalletPayCompletionImp.put("appInfo", ((StringBuilder)localObject2).toString());
          paramString = paramQQWalletPayCompletionImp.toString();
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          paramString = str1;
        }
        ((Bundle)localObject1).putString("payparmas_json", paramString);
        ((Bundle)localObject1).putInt("payparmas_paytype", 9);
        ((Bundle)localObject1).putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "publicpaymsg.pay.result", "payinvoke", null, 0, null));
        ((Bundle)localObject1).putInt("pay_requestcode", 9);
        PayBridgeActivity.newPay(this.mQQAppInterface, QBaseActivity.sTopActivity, paramContext, 9, (Bundle)localObject1);
        if (QLog.isColorLevel()) {
          QLog.e("PublicQuickPayService", 2, "open OpenPayActivity success");
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublicQuickPayService", 2, "publicQuickPay parameters parse error");
      }
      showDialog(paramContext);
      doCallback(paramQQWalletPayCompletionImp, -4, "params parse error", null, null);
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("jsonParams=");
      paramContext.append(paramJSONObject);
      paramContext.append(", puin=");
      paramContext.append(paramString);
      QLog.e("PublicQuickPayService", 2, paramContext.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.PublicQuickPayServiceImpl
 * JD-Core Version:    0.7.0.1
 */