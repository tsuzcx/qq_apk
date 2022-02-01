package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.net.URLDecoder;
import java.util.Arrays;
import org.json.JSONObject;

public class MQPSecJsPlugin
  extends VasWebviewJsPlugin
  implements SMSBodyObserver, MultiNameSpacePluginCompact
{
  public static final String KEY_FROM = "keyFrom";
  public static final String KEY_RANDSTR = "randstr";
  public static final String KEY_REG_UIN = "is_register_uin";
  public static final String KEY_REG_UIN_MSG = "register_uin_msg";
  public static final String NAMESPACE_DEV_LOCK = "EquipLockManager";
  public static final String NAMESPACE_PUZZLE_VERIFY_CODE = "CAPTCHA";
  public static final String NAMESPACE_SET_PWD = "SetPwdJsInterface";
  private static final String tag = "MQPSecJsPlugin";
  protected Activity activity = null;
  boolean isSubaccount;
  private boolean mIsCloseWeb = true;
  private boolean mOpenDevlockCalled = false;
  private int mSeq = -1;
  boolean needResult;
  private QQProgressDialog progressDialog = null;
  String resultMobileMask;
  boolean resultSetMobile = false;
  String resultSppkey = null;
  int resultState = 1;
  String resultUin;
  SmsContent smsContent = null;
  String subAccountUin;
  String tagRequest;
  private boolean waittingResponse = false;
  
  private void hideProgressDialog()
  {
    Activity localActivity = this.activity;
    if (localActivity == null) {
      return;
    }
    localActivity.runOnUiThread(new MQPSecJsPlugin.3(this));
  }
  
  private boolean onBackEvent()
  {
    if ((this.resultState == 2) && (!TextUtils.isEmpty(this.resultSppkey)) && (!this.mOpenDevlockCalled))
    {
      this.mOpenDevlockCalled = true;
      openEquipmentLock(this.resultUin, this.resultMobileMask, this.resultSppkey);
      return true;
    }
    if (!this.waittingResponse)
    {
      closeWeb(true);
      return false;
    }
    return true;
  }
  
  private void showProgressDialog()
  {
    this.mRuntime.a().runOnUiThread(new MQPSecJsPlugin.2(this));
  }
  
  public void changeEquipLockMobile(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 3;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    closeWeb(false);
  }
  
  public void closeWeb(boolean paramBoolean)
  {
    if (this.needResult)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("resultMobileMask", this.resultMobileMask);
      localIntent.putExtra("resultUin", this.resultUin);
      localIntent.putExtra("resultSppkey", this.resultSppkey);
      localIntent.putExtra("resultState", this.resultState);
      if (this.resultState == 2) {
        localIntent.putExtra("resultSetMobile", this.resultSetMobile);
      }
      if (paramBoolean) {
        this.activity.setResult(0, localIntent);
      } else {
        this.activity.setResult(-1, localIntent);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "close Web");
    }
    hideProgressDialog();
    this.activity.finish();
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "SetPwdJsInterface", "EquipLockManager", "CAPTCHA" };
  }
  
  protected long getPluginBusiness()
  {
    return 2149629952L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"EquipLockManager".equalsIgnoreCase(paramString2)) && (!"SetPwdJsInterface".equalsIgnoreCase(paramString2)) && (!"CAPTCHA".equalsIgnoreCase(paramString2))) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("pkg: ");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", method: ");
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener.append(", url: ");
      paramJsBridgeListener.append(URLDecoder.decode(paramString1));
      QLog.d("MQPSecJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ("openDevLock".equals(paramString3))
    {
      Object localObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (localObject == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest JSON = ");
        paramJsBridgeListener.append(((JSONObject)localObject).toString());
        QLog.d("MQPSecJsPlugin", 2, paramJsBridgeListener.toString());
      }
      try
      {
        paramJsBridgeListener = ((JSONObject)localObject).optString("callback");
        paramString1 = ((JSONObject)localObject).optString("devlockOpenSource");
        boolean bool = ((JSONObject)localObject).optBoolean("showAuthDevList");
        paramString2 = ((JSONObject)localObject).getString("title");
        paramString3 = ((JSONObject)localObject).getString("wording");
        paramVarArgs = ((JSONObject)localObject).getString("button");
        localObject = ((JSONObject)localObject).getString("jumpText");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("title", paramString2);
        localJSONObject.put("wording", paramString3);
        localJSONObject.put("image_res_id", 2130845085);
        localJSONObject.put("btn_text", paramVarArgs);
        localJSONObject.put("jump_text", localObject);
        localJSONObject.put("jump_url", "");
        openDevLock(bool, paramString1, localJSONObject.toString(), paramJsBridgeListener);
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("openDevLock parse url param failed");
          paramString1.append(paramJsBridgeListener.getMessage());
          QLog.i("MQPSecJsPlugin", 2, paramString1.toString());
        }
        return true;
      }
    }
    return call(paramString3, Arrays.asList(paramVarArgs));
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = Utils.c(paramString1, paramString2);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      callJs("_pushInputVcode", new String[] { paramString1 });
    }
  }
  
  public void handleWebError(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 1;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    closeWeb(false);
  }
  
  public void isNotNet()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin isNotNet ");
    }
    new Handler(this.activity.getMainLooper()).post(new MQPSecJsPlugin.4(this));
  }
  
  void onBindedToClient()
  {
    Object localObject = this.activity;
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getIntent();
    long l = ((Intent)localObject).getLongExtra("business", 0L);
    if ((0x8000 & l) != 0L)
    {
      localObject = ((Intent)localObject).getStringExtra("uin");
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", (String)localObject);
      sendRemoteReq(DataFactory.a("getA2", "", this.mOnRemoteResp.key, localBundle), true, false);
      hideProgressDialog();
      return;
    }
    if ((l & 0x200000) != 0L) {
      sendRemoteReq(DataFactory.a("puzzle_verify_code_clearProgressDialog", "", this.mOnRemoteResp.key, new Bundle()), true, false);
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.activity = this.mRuntime.a();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    SmsContent localSmsContent = this.smsContent;
    if (localSmsContent != null) {
      try
      {
        localSmsContent.a();
        this.smsContent = null;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    hideProgressDialog();
  }
  
  public void onLoadIsSetPsw(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SetPwdJsPlugin onLoadIsSetPsw isSet =");
      localStringBuilder.append(paramString);
      QLog.d("MQPSecJsPlugin", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (paramString.equals("1"))) {
      sendRemoteReq(DataFactory.a("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("cmd");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MQPSecJsPlugin", 2, "cmd is empty.");
        }
        return;
      }
      localObject2 = paramBundle.getBundle("response");
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("response:");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i("MQPSecJsPlugin", 2, ((StringBuilder)localObject3).toString());
      }
      if (((String)localObject1).equalsIgnoreCase("openEquipmentLock"))
      {
        if (((Bundle)localObject2).getInt("checkDevLockSms_ret") < 0)
        {
          hideProgressDialog();
          closeWeb(false);
        }
      }
      else if (((String)localObject1).equalsIgnoreCase("setWaitingResponse"))
      {
        this.waittingResponse = ((Bundle)localObject2).getBoolean("isWaiting", false);
        if (!this.waittingResponse) {
          hideProgressDialog();
        }
      }
      else
      {
        if (((String)localObject1).equalsIgnoreCase("setMobileResult"))
        {
          this.resultSetMobile = ((Bundle)localObject2).getBoolean("setMobileResult", false);
          return;
        }
        if ((((String)localObject1).equalsIgnoreCase("closeWeb")) && (this.mIsCloseWeb))
        {
          closeWeb(((Bundle)localObject2).getBoolean("isBack"));
          return;
        }
        if (((String)localObject1).equalsIgnoreCase("getA2"))
        {
          paramBundle = ((Bundle)localObject2).getString("A2");
          if (TextUtils.isEmpty(paramBundle))
          {
            if (QLog.isColorLevel()) {
              QLog.i("MQPSecJsPlugin", 2, "a2 is empty.");
            }
            return;
          }
          localObject1 = this.activity.getIntent().getStringExtra("url");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("MQPSecJsPlugin", 2, "url is empty.");
            }
            return;
          }
          localObject2 = Util.b((String)localObject1);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.i("MQPSecJsPlugin", 2, "domain is empty.");
            }
            return;
          }
          CookieSyncManager.createInstance(this.mRuntime.a().getContext());
          localObject3 = CookieManager.getInstance();
          ((CookieManager)localObject3).setAcceptCookie(true);
          ((CookieManager)localObject3).setCookie((String)localObject1, String.format("A2=%1$s; domain=%2$s; path=/", new Object[] { paramBundle, localObject2 }));
          CookieSyncManager.getInstance().sync();
          return;
        }
        if (((String)localObject1).equalsIgnoreCase("openDevLock"))
        {
          bool1 = ((Bundle)localObject2).getBoolean("auth_dev_open");
          localObject1 = ((Bundle)localObject2).getByteArray("devlock_roam_sig");
          paramBundle = paramBundle.getString("callbackid");
        }
      }
    }
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("result", 0);
      ((JSONObject)localObject2).put("devlockIsOpen", bool1);
      ((JSONObject)localObject2).put("sigDA2", HexUtil.bytes2HexStr((byte[])localObject1));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openDevLock callJS: ");
        ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
        QLog.i("MQPSecJsPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      super.callJs(paramBundle, new String[] { ((JSONObject)localObject2).toString() });
      return;
    }
    catch (Exception paramBundle) {}
    if (((String)localObject1).equalsIgnoreCase("queryDevLockStatus"))
    {
      bool1 = ((Bundle)localObject2).getBoolean("auth_dev_open");
      boolean bool2 = ((Bundle)localObject2).getBoolean("allow_set");
      localObject2 = ((Bundle)localObject2).getString("phone_num");
      localObject1 = "true";
      if (bool1) {
        paramBundle = "true";
      } else {
        paramBundle = "false";
      }
      if (!bool2) {
        localObject1 = "false";
      }
      callJs("_onQueryDevLockStatus", new String[] { paramBundle, localObject1, localObject2 });
    }
    return;
  }
  
  public void onTimeOut()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin onTimeOut");
    }
    hideProgressDialog();
  }
  
  public void onVerifyCAPTCHA(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (Integer.parseInt(paramString.getString("result")) != 0) {
          break label337;
        }
        bool1 = true;
        String str1 = paramString.getString("ticket");
        String str2 = paramString.optString("randstr");
        String str3 = paramString.optString("appid");
        paramString = this.activity;
        if (paramString == null) {
          break label349;
        }
        localObject2 = this.activity.getIntent();
        if (localObject2 == null) {
          break label349;
        }
        bool2 = ((Intent)localObject2).getBooleanExtra("is_register_uin", false);
        if (!bool2) {
          break label342;
        }
        i = ((Intent)localObject2).getIntExtra("register_uin_msg", 0);
        paramString = ((Intent)localObject2).getStringExtra("register_uin_class");
        localObject1 = ((Intent)localObject2).getStringExtra("keyFrom");
        localObject2 = ((Intent)localObject2).getStringExtra("process");
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("seq", this.mSeq);
        ((Bundle)localObject3).putBoolean("result", bool1);
        ((Bundle)localObject3).putString("ticket", str1);
        ((Bundle)localObject3).putString("randstr", str2);
        ((Bundle)localObject3).putString("appid", str3);
        ((Bundle)localObject3).putBoolean("is_register_uin", bool2);
        ((Bundle)localObject3).putString("keyFrom", (String)localObject1);
        if (bool2)
        {
          ((Bundle)localObject3).putInt("register_uin_msg", i);
          ((Bundle)localObject3).putString("register_uin_class", paramString);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((Bundle)localObject3).putString("process", (String)localObject2);
        }
        sendRemoteReq(DataFactory.a("puzzle_verify_code_setTicket", "", this.mOnRemoteResp.key, (Bundle)localObject3), true, false);
        if (this.activity != null)
        {
          this.activity.finish();
          return;
        }
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onVerifyCAPTCHA error:");
          ((StringBuilder)localObject1).append(paramString.getMessage());
          QLog.d("MQPSecJsPlugin", 2, ((StringBuilder)localObject1).toString());
        }
      }
      return;
      label337:
      boolean bool1 = false;
      continue;
      label342:
      paramString = null;
      int i = 0;
      continue;
      label349:
      Object localObject1 = null;
      paramString = (String)localObject1;
      Object localObject3 = paramString;
      boolean bool2 = false;
      i = 0;
      Object localObject2 = paramString;
      paramString = (String)localObject3;
    }
  }
  
  public void onWebMakeSureBack()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin onWebMakeSureBack");
    }
    showProgressDialog();
  }
  
  public void onWebMakeSureFinishBack(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SetPwdJsPlugin onWebMakeSureFinishBack isSuccess =");
      localStringBuilder.append(paramString);
      QLog.d("MQPSecJsPlugin", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (paramString.equals("1"))) {
      sendRemoteReq(DataFactory.a("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
    }
    hideProgressDialog();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    paramCustomWebView = this.activity;
    if (paramCustomWebView != null)
    {
      paramCustomWebView = paramCustomWebView.getIntent();
      long l = paramCustomWebView.getLongExtra("business", 0L);
      if ((0x4000 & l) != 0L)
      {
        this.tagRequest = paramCustomWebView.getStringExtra("tag");
        this.needResult = paramCustomWebView.getBooleanExtra("needResult", false);
        this.isSubaccount = paramCustomWebView.getBooleanExtra("isSubaccount", false);
        if (this.isSubaccount) {
          this.subAccountUin = paramCustomWebView.getStringExtra("subAccountUin");
        }
        try
        {
          this.smsContent = new SmsContent(null);
          this.smsContent.a(this.activity, this);
        }
        catch (Throwable paramCustomWebView)
        {
          paramCustomWebView.printStackTrace();
        }
        paramCustomWebView = (TextView)this.activity.findViewById(2131369202);
        if (paramCustomWebView != null) {
          paramCustomWebView.setOnClickListener(new MQPSecJsPlugin.1(this));
        }
      }
      else if ((l & 0x200000) != 0L)
      {
        this.mSeq = paramCustomWebView.getIntExtra("seq", -1);
      }
    }
  }
  
  public void openDevLock(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.mIsCloseWeb = false;
    Bundle localBundle = new Bundle();
    localBundle.putString("devlock_guide_config", paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      localBundle.putString("devlock_open_source", paramString1);
    } else {
      localBundle.putString("devlock_open_source", "Unknown");
    }
    localBundle.putBoolean("devlock_show_auth_dev_list", paramBoolean);
    sendRemoteReq(DataFactory.a("openDevLock", paramString3, this.mOnRemoteResp.key, localBundle), true, false);
  }
  
  public void openEquipmentLock(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 2;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    showProgressDialog();
    if (paramString3 != null) {
      paramString3 = paramString3.getBytes();
    } else {
      paramString3 = null;
    }
    this.waittingResponse = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("mobileMask", paramString2);
    localBundle.putByteArray("sppkey", paramString3);
    sendRemoteReq(DataFactory.a("openEquipmentLock", "", this.mOnRemoteResp.key, localBundle), true, false);
  }
  
  public void pushMobileResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushMobileResult uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" mobileMask=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" state=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" sppkey=");
      localStringBuilder.append(paramString4);
      QLog.d("MQPSecJsPlugin", 2, localStringBuilder.toString());
    }
    updateResult(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void pushMobileReturn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin pushMobileReturn");
    }
    this.activity.finish();
  }
  
  public void pushMobileReturn(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pushMobileReturn uin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" mobileMask=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" state=");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(" sppkey=");
      ((StringBuilder)localObject).append(paramString4);
      QLog.d("MQPSecJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString4))
    {
      updateResult(paramString1, paramString2, paramString3, paramString4);
      if ((this.resultState == 2) && (!TextUtils.isEmpty(this.resultSppkey)) && (!this.mOpenDevlockCalled))
      {
        this.mOpenDevlockCalled = true;
        openEquipmentLock(this.resultUin, this.resultMobileMask, this.resultSppkey);
        return;
      }
      closeWeb(false);
      return;
    }
    if ("1".equals(paramString3))
    {
      if (!this.mOpenDevlockCalled)
      {
        this.mOpenDevlockCalled = true;
        openEquipmentLock(paramString1, paramString2, paramString4);
      }
    }
    else
    {
      if (TextUtils.isEmpty(paramString4)) {
        localObject = "dummy";
      } else {
        localObject = paramString4;
      }
      updateResult(paramString1, paramString2, paramString3, (String)localObject);
      if (!TextUtils.isEmpty(paramString4)) {
        this.resultSppkey = paramString4;
      }
      closeWeb(false);
    }
  }
  
  public void queryDevLockStatus()
  {
    sendRemoteReq(DataFactory.a("queryDevLockStatus", "", this.mOnRemoteResp.key, null), true, false);
  }
  
  public void updateResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.resultUin = paramString1;
    int i;
    try
    {
      i = Integer.parseInt(paramString3);
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      i = 0;
    }
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString4;
    if (i != -4)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              this.resultState = 1;
              return;
            }
            this.resultState = 5;
            return;
          }
          this.resultState = 4;
          return;
        }
        this.resultState = 3;
        return;
      }
      this.resultState = 2;
      return;
    }
    this.resultState = 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin
 * JD-Core Version:    0.7.0.1
 */