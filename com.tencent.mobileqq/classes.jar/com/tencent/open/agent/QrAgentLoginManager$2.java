package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
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
  
  private void a(QBaseActivity paramQBaseActivity)
  {
    if (paramQBaseActivity == null)
    {
      QLog.d("QrAgentLoginManager", 1, "startOpenUrlWebView context is null");
      return;
    }
    if (paramQBaseActivity.getAppRuntime() != null)
    {
      QLog.d("QrAgentLoginManager", 1, "startOpenUrlWebView cancelCode");
      QrAgentLoginManager.a(this.a, (QQAppInterface)paramQBaseActivity.getAppRuntime(), QrAgentLoginManager.e(this.a));
    }
    QLog.d("QrAgentLoginManager", 1, "startOpenUrlWebView");
    String str = QrAgentLoginManager.f(this.a);
    Intent localIntent = new Intent(paramQBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramQBaseActivity.startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null)
    {
      QLog.e("QrAgentLoginManager", 1, "OnException null== QBaseActivity.sTopActivity");
      return;
    }
    Intent localIntent = new Intent(localQBaseActivity, QRLoginAuthActivity.class);
    localIntent.putExtra("QR_CODE_STRING", QrAgentLoginManager.d(this.a));
    if (paramBoolean)
    {
      localIntent.putExtra("KEY_ERROR_MSG", QRLoginAuthActivity.c);
      if (localQBaseActivity.getAppRuntime() != null) {
        QrAgentLoginManager.a(this.a, (QQAppInterface)localQBaseActivity.getAppRuntime(), QrAgentLoginManager.e(this.a));
      }
    }
    if (localQBaseActivity.getIntent().getBooleanExtra("fromPicQRDecode", false))
    {
      localQBaseActivity.startActivityForResult(localIntent, 2);
      return;
    }
    localQBaseActivity.startActivity(localIntent);
  }
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    QLog.d("QrAgentLoginManager", 1, new Object[] { "OnCloseCode userAccount=", MsfSdkUtils.getShortUin(paramString), " ret=", Integer.valueOf(paramInt) });
    paramArrayOfByte1 = QBaseActivity.sTopActivity;
    if (paramInt == 0)
    {
      if (AuthorityUtil.a(paramArrayOfByte1)) {
        paramArrayOfByte1.finish();
      }
      QIPCClientHelper.getInstance().callServer("QR_LOGIN_QIPC_MODULE_NAME", "QIPC_SHOW_TOAST_ACTION", null, null);
      return;
    }
    if (AuthorityUtil.a(paramArrayOfByte1))
    {
      paramWUserSigInfo = new Intent(paramArrayOfByte1, QRLoginAuthActivity.class);
      paramArrayOfByte2 = BaseApplicationImpl.context.getSharedPreferences("SP_QR_AGENT_LOGIN", 4);
      paramErrMsg = new StringBuilder();
      paramErrMsg.append("KEY_QR_AGENT_LOGIN_CODE");
      paramErrMsg.append(paramString);
      paramWUserSigInfo.putExtra("QR_CODE_STRING", paramArrayOfByte2.getString(paramErrMsg.toString(), ""));
      paramWUserSigInfo.putExtra("KEY_QR_CODE_EXPIRED", true);
      paramArrayOfByte1.startActivity(paramWUserSigInfo);
      paramArrayOfByte1.finish();
    }
  }
  
  public void onException(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WtloginObserver OnException : ");
    localStringBuilder.append(paramString);
    QLog.d("QrAgentLoginManager", 1, localStringBuilder.toString());
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    boolean bool2 = false;
    paramErrMsg = MsfSdkUtils.getShortUin(paramString);
    if (paramArrayOfByte1 == null) {
      paramString = "";
    } else {
      paramString = new String(paramArrayOfByte1);
    }
    QLog.d("QrAgentLoginManager", 1, new Object[] { "OnVerifyCode userAccount=", paramErrMsg, " ret=", Integer.valueOf(paramInt), " appName: ", paramString });
    if (paramInt != 0)
    {
      QrAgentLoginManager.a(this.a, paramArrayOfByte2);
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramInt = 0;
      if (paramInt >= paramArrayList.size()) {}
    }
    label396:
    for (;;)
    {
      try
      {
        paramString = HexUtil.hexStr2Bytes((String)paramArrayList.get(paramInt));
        int i = util.buf_to_int16(paramString, 0);
        int j = util.buf_to_int16(paramString, 2);
        if (i == 54)
        {
          if ((QrAgentLoginManager.a(this.a)) && (QrAgentLoginManager.b(this.a)))
          {
            if (QBaseActivity.sTopActivity == null)
            {
              paramString = null;
              break label396;
            }
            paramString = QBaseActivity.sTopActivity.getAppRuntime();
            break label396;
            ReportController.b(paramString, "dc00898", "", "", "0X800B5A6", "0X800B5A6", 0, 0, "", "", "", "");
            a(QBaseActivity.sTopActivity);
            return;
          }
          paramArrayOfByte1 = new byte[j];
          System.arraycopy(paramString, 4, paramArrayOfByte1, 0, j);
          paramString = new String(paramArrayOfByte1);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("OnVerifyCode: invoked.  appidJson: ");
            paramArrayOfByte1.append(paramString);
            QLog.i("QrAgentLoginManager", 2, paramArrayOfByte1.toString());
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
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QrAgentLoginManager", 2, "OnVerifyCode: failed. ", paramString);
        }
        paramInt += 1;
      }
      break;
      boolean bool1 = bool2;
      if (QrAgentLoginManager.a(this.a))
      {
        bool1 = bool2;
        if (QrAgentLoginManager.c(this.a)) {
          bool1 = true;
        }
      }
      a(bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.QrAgentLoginManager.2
 * JD-Core Version:    0.7.0.1
 */