package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

class QrAgentLoginManager$2
  extends WtloginObserver
{
  QrAgentLoginManager$2(QrAgentLoginManager paramQrAgentLoginManager) {}
  
  private void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("QrAgentLoginManager", 1, "startOpenUrlWebView context is null");
      return;
    }
    if (paramBaseActivity.app != null)
    {
      QLog.d("QrAgentLoginManager", 1, "startOpenUrlWebView cancelCode");
      QrAgentLoginManager.a(this.a, paramBaseActivity.app, QrAgentLoginManager.a(this.a));
    }
    String str = QrAgentLoginManager.b(this.a);
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramBaseActivity.startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null)
    {
      QLog.e("QrAgentLoginManager", 1, "OnException null== BaseActivity.sTopActivity");
      return;
    }
    Intent localIntent = new Intent(localBaseActivity, QRLoginAuthActivity.class);
    localIntent.putExtra("QR_CODE_STRING", QrAgentLoginManager.a(this.a));
    if (paramBoolean)
    {
      localIntent.putExtra("KEY_ERROR_MSG", QRLoginAuthActivity.c);
      if (localBaseActivity.app != null) {
        QrAgentLoginManager.a(this.a, localBaseActivity.app, QrAgentLoginManager.a(this.a));
      }
    }
    if (localBaseActivity.getIntent().getBooleanExtra("QRDecode", false))
    {
      localBaseActivity.startActivityForResult(localIntent, 2);
      return;
    }
    localBaseActivity.startActivity(localIntent);
  }
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrAgentLoginManager", 2, "OnCloseCode userAccount=" + paramString + " ret=" + paramInt);
    }
    paramArrayOfByte1 = BaseActivity.sTopActivity;
    if (paramInt == 0)
    {
      if (AuthorityUtil.a(paramArrayOfByte1)) {
        paramArrayOfByte1.finish();
      }
      QIPCClientHelper.getInstance().callServer("QR_LOGIN_QIPC_MODULE_NAME", "QIPC_SHOW_TOAST_ACTION", null, null);
    }
    while (!AuthorityUtil.a(paramArrayOfByte1)) {
      return;
    }
    paramWUserSigInfo = new Intent(paramArrayOfByte1, QRLoginAuthActivity.class);
    paramWUserSigInfo.putExtra("QR_CODE_STRING", BaseApplicationImpl.context.getSharedPreferences("SP_QR_AGENT_LOGIN", 4).getString("KEY_QR_AGENT_LOGIN_CODE" + paramString, ""));
    paramWUserSigInfo.putExtra("KEY_QR_CODE_EXPIRED", true);
    paramArrayOfByte1.startActivity(paramWUserSigInfo);
    paramArrayOfByte1.finish();
  }
  
  public void onException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrAgentLoginManager", 2, "OnException e=" + paramString);
    }
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrAgentLoginManager", 2, "OnVerifyCode userAccount=" + paramString + " ret=" + paramInt + " appName: " + paramArrayOfByte1);
    }
    if (paramInt != 0) {
      QrAgentLoginManager.a(this.a, paramArrayOfByte2);
    }
    while ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    if (paramInt < paramArrayList.size())
    {
      int j;
      for (;;)
      {
        try
        {
          paramString = HexUtil.hexStr2Bytes((String)paramArrayList.get(paramInt));
          int i = util.buf_to_int16(paramString, 0);
          j = util.buf_to_int16(paramString, 2);
          if (i == 54)
          {
            if ((!QrAgentLoginManager.a(this.a)) || (!QrAgentLoginManager.b(this.a))) {
              break label221;
            }
            if (BaseActivity.sTopActivity != null) {
              break label211;
            }
            paramString = null;
            ReportController.b(paramString, "dc00898", "", "", "0X800B5A6", "0X800B5A6", 0, 0, "", "", "", "");
            a(BaseActivity.sTopActivity);
            return;
          }
        }
        catch (Throwable paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QrAgentLoginManager", 2, "OnVerifyCode: failed. ", paramString);
          }
          paramInt += 1;
        }
        break;
        label211:
        paramString = BaseActivity.sTopActivity.app;
      }
      label221:
      paramArrayOfByte1 = new byte[j];
      System.arraycopy(paramString, 4, paramArrayOfByte1, 0, j);
      paramString = new String(paramArrayOfByte1);
      if (QLog.isColorLevel()) {
        QLog.i("QrAgentLoginManager", 2, "OnVerifyCode: invoked.  appidJson: " + paramString);
      }
      paramString = new JSONObject(paramString);
      paramLong = paramString.optLong("open_appid");
      paramArrayOfByte1 = paramString.optString("comefrom");
      paramString = paramArrayOfByte1;
      if ("app".equals(paramArrayOfByte1)) {
        paramString = "android";
      }
      this.a.a(paramLong, paramString);
      return;
    }
    if ((QrAgentLoginManager.a(this.a)) && (QrAgentLoginManager.c(this.a))) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.QrAgentLoginManager.2
 * JD-Core Version:    0.7.0.1
 */