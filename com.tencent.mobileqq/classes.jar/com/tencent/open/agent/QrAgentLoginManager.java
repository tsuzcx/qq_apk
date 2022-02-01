package com.tencent.open.agent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.agent.util.QRLoginAuthUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class QrAgentLoginManager
{
  private static volatile QrAgentLoginManager jdField_a_of_type_ComTencentOpenAgentQrAgentLoginManager;
  public static boolean a = true;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<OnQRHandleResultCallback> jdField_a_of_type_JavaLangRefWeakReference;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new QrAgentLoginManager.2(this);
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  private QrAgentLoginManager()
  {
    a();
  }
  
  public static QrAgentLoginManager a()
  {
    if (jdField_a_of_type_ComTencentOpenAgentQrAgentLoginManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentOpenAgentQrAgentLoginManager == null) {
          jdField_a_of_type_ComTencentOpenAgentQrAgentLoginManager = new QrAgentLoginManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentOpenAgentQrAgentLoginManager;
  }
  
  @Nullable
  private static OpenSDKAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof OpenSDKAppInterface)) {
      return (OpenSDKAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private String a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      QLog.e("QrAgentLoginManager", 1, "getConfigOpenUrl, mLocalQrLoginConfig is null");
      return "https://connect.qq.com";
    }
    try
    {
      String str = new JSONObject(this.jdField_b_of_type_JavaLangString).optString("openUrl", "https://connect.qq.com");
      return str;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("QrAgentLoginManager", 1, "getConfigOpenUrl JSONException, ", localJSONException);
    }
    return "https://connect.qq.com";
  }
  
  private void a()
  {
    int j = BaseApplicationImpl.sProcessId;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0) {
      QIPCServerHelper.getInstance().register(new QrAgentLoginManager.1(this, "QR_LOGIN_QIPC_MODULE_NAME"));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramQQAppInterface == null)
    {
      QLog.d("QrAgentLoginManager", 1, "cancelCode, but app interface is null");
      return;
    }
    WtloginManager localWtloginManager = (WtloginManager)paramQQAppInterface.getManager(1);
    if (localWtloginManager == null)
    {
      QLog.d("QrAgentLoginManager", 1, "cancelCode, but wtloginManager is null");
      return;
    }
    localWtloginManager.cancelCode(paramQQAppInterface.getCurrentAccountUin(), 16L, paramArrayOfByte);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      paramArrayOfByte = new String(paramArrayOfByte);
    } else {
      paramArrayOfByte = HardCodeUtil.a(2131711138);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onQRCodeExpired: invoked.  error: ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.i("QrAgentLoginManager", 2, ((StringBuilder)localObject).toString());
    }
    paramArrayOfByte = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = (OnQRHandleResultCallback)paramArrayOfByte.get();
    }
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(false);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("QR_CODE_STRING", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("KEY_QR_CODE_EXPIRED", true);
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject == null) {
      localObject = BaseApplicationImpl.context;
    }
    localIntent.setClass((Context)localObject, QRLoginAuthActivity.class);
    ((Context)localObject).startActivity(localIntent);
    if (paramArrayOfByte != null) {
      paramArrayOfByte.b();
    }
  }
  
  private boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      QLog.e("QrAgentLoginManager", 1, "configShieldQQLogin, mLocalQrLoginConfig is null");
      return true;
    }
    try
    {
      boolean bool = new JSONObject(this.jdField_b_of_type_JavaLangString).optBoolean("shieldQQLogin", true);
      return bool;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("QrAgentLoginManager", 1, "configShieldQQLogin JSONException, ", localJSONException);
    }
    return true;
  }
  
  private boolean b()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      QLog.e("QrAgentLoginManager", 1, "configShieldOpenLogin, mLocalQrLoginConfig is null");
      return false;
    }
    try
    {
      boolean bool = new JSONObject(this.jdField_b_of_type_JavaLangString).optBoolean("shieldOpenLogin", false);
      return bool;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("QrAgentLoginManager", 1, "configShieldOpenLogin JSONException, ", localJSONException);
    }
    return false;
  }
  
  public void a(long paramLong, String paramString)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    Intent localIntent = new Intent(localQBaseActivity, AgentActivity.class);
    localIntent.putExtra("key_action", "action_login");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_login_by_qr_scan", true);
    localBundle.putString("client_id", String.valueOf(paramLong));
    localBundle.putString("sdkp", paramString);
    localBundle.putLong("KEY_ONLINE_STATUS", this.jdField_a_of_type_Long);
    localBundle.putByteArray("key_qr_code", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("key_params", localBundle);
    localQBaseActivity.startActivity(localIntent);
  }
  
  public void a(Bundle paramBundle, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, OnQRHandleResultCallback paramOnQRHandleResultCallback, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestQRLogin: invoked.  qrCodeStr: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QrAgentLoginManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Long = paramQQAppInterface.getOnlineStauts();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnQRHandleResultCallback);
    this.jdField_a_of_type_JavaLangString = paramString;
    paramOnQRHandleResultCallback = BaseApplicationImpl.context.getSharedPreferences("SP_QR_AGENT_LOGIN", 4).edit();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("KEY_QR_AGENT_LOGIN_CODE");
    ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentUin());
    paramOnQRHandleResultCallback.putString(((StringBuilder)localObject).toString(), this.jdField_a_of_type_JavaLangString).apply();
    paramOnQRHandleResultCallback = (WtloginManager)paramQQAppInterface.getManager(1);
    int i = paramString.indexOf("?k=") + 3;
    localObject = paramString.substring(i, i + 32);
    this.jdField_a_of_type_ArrayOfByte = QRLoginAuthUtil.a(((String)localObject).getBytes(), ((String)localObject).length());
    paramString = paramString.substring(paramString.indexOf("&f=") + 3);
    paramQQAppInterface = paramQQAppInterface.getAccount();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestQRLogin: invoked.  userAccount: ");
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append(" carAppIdString: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" content: ");
      localStringBuilder.append((String)localObject);
      QLog.i("QrAgentLoginManager", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_JavaLangString = SharedPreUtils.a("local_qr_login_config");
    }
    paramString = this.jdField_a_of_type_ArrayOfByte;
    localObject = this.jdField_a_of_type_MqqObserverWtloginObserver;
    paramOnQRHandleResultCallback.verifyCode(paramQQAppInterface, 16L, true, paramString, new int[] { 3, 5, 32, 54 }, 1, (WtloginObserver)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.QrAgentLoginManager
 * JD-Core Version:    0.7.0.1
 */