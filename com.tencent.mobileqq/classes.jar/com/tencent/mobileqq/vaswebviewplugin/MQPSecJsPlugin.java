package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import anxi;
import anxk;
import aqyp;
import aqyt;
import bftf;
import bgtp;
import bguj;
import bgve;
import bgzi;
import bhht;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.net.URLDecoder;
import java.util.Arrays;
import npn;
import org.json.JSONObject;

public class MQPSecJsPlugin
  extends VasWebviewJsPlugin
  implements anxi, bgtp
{
  public static final String KEY_FROM = "keyFrom";
  public static final String NAMESPACE_DEV_LOCK = "EquipLockManager";
  public static final String NAMESPACE_PUZZLE_VERIFY_CODE = "CAPTCHA";
  public static final String NAMESPACE_SET_PWD = "SetPwdJsInterface";
  private static final String tag = "MQPSecJsPlugin";
  protected Activity activity;
  boolean isSubaccount;
  private boolean mIsCloseWeb = true;
  private boolean mOpenDevlockCalled;
  private int mSeq = -1;
  boolean needResult;
  private bhht progressDialog;
  String resultMobileMask;
  boolean resultSetMobile = false;
  String resultSppkey = null;
  int resultState = 1;
  String resultUin;
  anxk smsContent = null;
  String subAccountUin;
  String tagRequest;
  private boolean waittingResponse;
  
  private void hideProgressDialog()
  {
    if (this.activity == null) {
      return;
    }
    this.activity.runOnUiThread(new MQPSecJsPlugin.3(this));
  }
  
  private boolean onBackEvent()
  {
    if ((this.resultState == 2) && (!TextUtils.isEmpty(this.resultSppkey)) && (!this.mOpenDevlockCalled))
    {
      this.mOpenDevlockCalled = true;
      openEquipmentLock(this.resultUin, this.resultMobileMask, this.resultSppkey);
    }
    while (this.waittingResponse) {
      return true;
    }
    closeWeb(true);
    return false;
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
    Intent localIntent;
    if (this.needResult)
    {
      localIntent = new Intent();
      localIntent.putExtra("resultMobileMask", this.resultMobileMask);
      localIntent.putExtra("resultUin", this.resultUin);
      localIntent.putExtra("resultSppkey", this.resultSppkey);
      localIntent.putExtra("resultState", this.resultState);
      if (this.resultState == 2) {
        localIntent.putExtra("resultSetMobile", this.resultSetMobile);
      }
      if (!paramBoolean) {
        break label117;
      }
      this.activity.setResult(0, localIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MQPSecJsPlugin", 2, "close Web");
      }
      hideProgressDialog();
      this.activity.finish();
      return;
      label117:
      this.activity.setResult(-1, localIntent);
    }
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "SetPwdJsInterface", "EquipLockManager", "CAPTCHA" };
  }
  
  protected long getPluginBusiness()
  {
    return 2149629952L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("EquipLockManager".equalsIgnoreCase(paramString2)) || ("SetPwdJsInterface".equalsIgnoreCase(paramString2)) || ("CAPTCHA".equalsIgnoreCase(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MQPSecJsPlugin", 2, "pkg: " + paramString2 + ", method: " + paramString3 + ", url: " + URLDecoder.decode(paramString1));
      }
      if ("openDevLock".equals(paramString3))
      {
        Object localObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (localObject == null) {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MQPSecJsPlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject).toString());
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
          localJSONObject.put("image_res_id", 2130844974);
          localJSONObject.put("btn_text", paramVarArgs);
          localJSONObject.put("jump_text", localObject);
          localJSONObject.put("jump_url", "");
          openDevLock(bool, paramString1, localJSONObject.toString(), paramJsBridgeListener);
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MQPSecJsPlugin", 2, "openDevLock parse url param failed" + paramJsBridgeListener.getMessage());
          }
          return true;
        }
      }
      return call(paramString3, Arrays.asList(paramVarArgs));
    }
    return false;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = bftf.c(paramString1, paramString2);
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
    if (this.activity == null) {}
    long l;
    do
    {
      return;
      Object localObject = this.activity.getIntent();
      l = ((Intent)localObject).getLongExtra("business", 0L);
      if ((0x8000 & l) != 0L)
      {
        localObject = ((Intent)localObject).getStringExtra("uin");
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", (String)localObject);
        sendRemoteReq(aqyt.a("getA2", "", this.mOnRemoteResp.key, localBundle), true, false);
        hideProgressDialog();
        return;
      }
    } while ((0x200000 & l) == 0L);
    sendRemoteReq(aqyt.a("puzzle_verify_code_clearProgressDialog", "", this.mOnRemoteResp.key, new Bundle()), true, false);
  }
  
  public void onCreate()
  {
    super.onCreate();
    bguj localbguj = this.mRuntime.a(this.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzi))) {
      this.activity = this.mRuntime.a();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.smsContent != null) {}
    try
    {
      this.smsContent.a();
      this.smsContent = null;
      hideProgressDialog();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void onLoadIsSetPsw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin onLoadIsSetPsw isSet =" + paramString);
    }
    if ((paramString != null) && (paramString.equals("1"))) {
      sendRemoteReq(aqyt.a("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("cmd");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label37;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MQPSecJsPlugin", 2, "cmd is empty.");
      }
    }
    label37:
    label374:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject2 = paramBundle.getBundle("response");
                if (QLog.isColorLevel()) {
                  QLog.i("MQPSecJsPlugin", 2, "response:" + (String)localObject1);
                }
                if (!((String)localObject1).equalsIgnoreCase("openEquipmentLock")) {
                  break;
                }
              } while (((Bundle)localObject2).getInt("checkDevLockSms_ret") >= 0);
              hideProgressDialog();
              closeWeb(false);
              return;
              if (!((String)localObject1).equalsIgnoreCase("setWaitingResponse")) {
                break;
              }
              this.waittingResponse = ((Bundle)localObject2).getBoolean("isWaiting", false);
            } while (this.waittingResponse);
            hideProgressDialog();
            return;
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
            if (!((String)localObject1).equalsIgnoreCase("getA2")) {
              break label374;
            }
            paramBundle = ((Bundle)localObject2).getString("A2");
            if (!TextUtils.isEmpty(paramBundle)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("MQPSecJsPlugin", 2, "a2 is empty.");
          return;
          localObject1 = this.activity.getIntent().getStringExtra("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("MQPSecJsPlugin", 2, "url is empty.");
        return;
        localObject2 = npn.b((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("MQPSecJsPlugin", 2, "domain is empty.");
      return;
      CookieSyncManager.createInstance(this.mRuntime.a().getContext());
      CookieManager localCookieManager = CookieManager.getInstance();
      localCookieManager.setAcceptCookie(true);
      localCookieManager.setCookie((String)localObject1, String.format("A2=%1$s; domain=%2$s; path=/", new Object[] { paramBundle, localObject2 }));
      CookieSyncManager.getInstance().sync();
      return;
      if (((String)localObject1).equalsIgnoreCase("openDevLock"))
      {
        bool1 = ((Bundle)localObject2).getBoolean("auth_dev_open");
        localObject1 = ((Bundle)localObject2).getByteArray("devlock_roam_sig");
        paramBundle = paramBundle.getString("callbackid");
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("result", 0);
          ((JSONObject)localObject2).put("devlockIsOpen", bool1);
          ((JSONObject)localObject2).put("sigDA2", HexUtil.bytes2HexStr((byte[])localObject1));
          if (QLog.isColorLevel()) {
            QLog.i("MQPSecJsPlugin", 2, "openDevLock callJS: " + ((JSONObject)localObject2).toString());
          }
          super.callJs(paramBundle, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
        catch (Exception paramBundle)
        {
          return;
        }
      }
    } while (!((String)localObject1).equalsIgnoreCase("queryDevLockStatus"));
    boolean bool1 = ((Bundle)localObject2).getBoolean("auth_dev_open");
    boolean bool2 = ((Bundle)localObject2).getBoolean("allow_set");
    Object localObject2 = ((Bundle)localObject2).getString("phone_num");
    if (bool1)
    {
      paramBundle = "true";
      if (!bool2) {
        break label599;
      }
    }
    label599:
    for (Object localObject1 = "true";; localObject1 = "false")
    {
      callJs("_onQueryDevLockStatus", new String[] { paramBundle, localObject1, localObject2 });
      return;
      paramBundle = "false";
      break;
    }
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
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (Integer.parseInt(paramString.getString("result")) == 0)
        {
          bool1 = true;
          String str1 = paramString.getString("ticket");
          String str2 = paramString.optString("randstr");
          String str3 = paramString.optString("appid");
          if (this.activity == null) {
            break label342;
          }
          localObject2 = this.activity.getIntent();
          if (localObject2 == null) {
            break label342;
          }
          bool2 = ((Intent)localObject2).getBooleanExtra("is_register_uin", false);
          if (!bool2) {
            break label335;
          }
          i = ((Intent)localObject2).getIntExtra("register_uin_msg", 0);
          paramString = ((Intent)localObject2).getStringExtra("register_uin_class");
          localObject1 = ((Intent)localObject2).getStringExtra("keyFrom");
          localObject3 = ((Intent)localObject2).getStringExtra("process");
          localObject2 = paramString;
          paramString = (String)localObject3;
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
            ((Bundle)localObject3).putString("register_uin_class", (String)localObject2);
          }
          if (!TextUtils.isEmpty(paramString)) {
            ((Bundle)localObject3).putString("process", paramString);
          }
          sendRemoteReq(aqyt.a("puzzle_verify_code_setTicket", "", this.mOnRemoteResp.key, (Bundle)localObject3), true, false);
          if (this.activity != null) {
            this.activity.finish();
          }
          return;
        }
      }
      catch (Throwable paramString)
      {
        boolean bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MQPSecJsPlugin", 2, "onVerifyCAPTCHA error:" + paramString.getMessage());
        return;
      }
      bool1 = false;
      continue;
      label335:
      paramString = null;
      int i = 0;
      continue;
      label342:
      Object localObject2 = null;
      i = 0;
      boolean bool2 = false;
      Object localObject3 = null;
      paramString = (String)localObject1;
      localObject1 = localObject3;
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
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "SetPwdJsPlugin onWebMakeSureFinishBack isSuccess =" + paramString);
    }
    if ((paramString != null) && (paramString.equals("1"))) {
      sendRemoteReq(aqyt.a("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
    }
    hideProgressDialog();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    long l;
    if (this.activity != null)
    {
      paramCustomWebView = this.activity.getIntent();
      l = paramCustomWebView.getLongExtra("business", 0L);
      if ((0x4000 & l) == 0L) {
        break label155;
      }
      this.tagRequest = paramCustomWebView.getStringExtra("tag");
      this.needResult = paramCustomWebView.getBooleanExtra("needResult", false);
      this.isSubaccount = paramCustomWebView.getBooleanExtra("isSubaccount", false);
      if (this.isSubaccount) {
        this.subAccountUin = paramCustomWebView.getStringExtra("subAccountUin");
      }
    }
    label155:
    while ((l & 0x200000) == 0L) {
      try
      {
        this.smsContent = new anxk(null);
        this.smsContent.a(this.activity, this);
        paramCustomWebView = (TextView)this.activity.findViewById(2131369068);
        if (paramCustomWebView != null) {
          paramCustomWebView.setOnClickListener(new MQPSecJsPlugin.1(this));
        }
        return;
      }
      catch (Throwable paramCustomWebView)
      {
        for (;;)
        {
          paramCustomWebView.printStackTrace();
        }
      }
    }
    this.mSeq = paramCustomWebView.getIntExtra("seq", -1);
  }
  
  public void openDevLock(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.mIsCloseWeb = false;
    Bundle localBundle = new Bundle();
    localBundle.putString("devlock_guide_config", paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      localBundle.putString("devlock_open_source", paramString1);
    }
    for (;;)
    {
      localBundle.putBoolean("devlock_show_auth_dev_list", paramBoolean);
      sendRemoteReq(aqyt.a("openDevLock", paramString3, this.mOnRemoteResp.key, localBundle), true, false);
      return;
      localBundle.putString("devlock_open_source", "Unknown");
    }
  }
  
  public void openEquipmentLock(String paramString1, String paramString2, String paramString3)
  {
    this.resultState = 2;
    this.resultUin = paramString1;
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString3;
    showProgressDialog();
    byte[] arrayOfByte = null;
    if (paramString3 != null) {
      arrayOfByte = paramString3.getBytes();
    }
    this.waittingResponse = true;
    paramString3 = new Bundle();
    paramString3.putString("uin", paramString1);
    paramString3.putString("mobileMask", paramString2);
    paramString3.putByteArray("sppkey", arrayOfByte);
    sendRemoteReq(aqyt.a("openEquipmentLock", "", this.mOnRemoteResp.key, paramString3), true, false);
  }
  
  public void pushMobileResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "pushMobileResult uin=" + paramString1 + " mobileMask=" + paramString2 + " state=" + paramString3 + " sppkey=" + paramString4);
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
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecJsPlugin", 2, "pushMobileReturn uin=" + paramString1 + " mobileMask=" + paramString2 + " state=" + paramString3 + " sppkey=" + paramString4);
    }
    if (TextUtils.isEmpty(paramString4))
    {
      updateResult(paramString1, paramString2, paramString3, paramString4);
      if ((this.resultState == 2) && (!TextUtils.isEmpty(this.resultSppkey)) && (!this.mOpenDevlockCalled))
      {
        this.mOpenDevlockCalled = true;
        openEquipmentLock(this.resultUin, this.resultMobileMask, this.resultSppkey);
      }
    }
    do
    {
      return;
      closeWeb(false);
      return;
      if (!"1".equals(paramString3)) {
        break;
      }
    } while (this.mOpenDevlockCalled);
    this.mOpenDevlockCalled = true;
    openEquipmentLock(paramString1, paramString2, paramString4);
    return;
    if (TextUtils.isEmpty(paramString4)) {}
    for (String str = "dummy";; str = paramString4)
    {
      updateResult(paramString1, paramString2, paramString3, str);
      if (!TextUtils.isEmpty(paramString4)) {
        this.resultSppkey = paramString4;
      }
      closeWeb(false);
      return;
    }
  }
  
  public void queryDevLockStatus()
  {
    sendRemoteReq(aqyt.a("queryDevLockStatus", "", this.mOnRemoteResp.key, null), true, false);
  }
  
  public void updateResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.resultUin = paramString1;
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramString3);
      i = j;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
      this.resultState = 2;
      return;
    }
    this.resultMobileMask = paramString2;
    this.resultSppkey = paramString4;
    switch (i)
    {
    case -3: 
    case -2: 
    case -1: 
    case 0: 
    default: 
      this.resultState = 1;
      return;
    case 1: 
    case 2: 
      this.resultState = 3;
      return;
    case 3: 
      this.resultState = 4;
      return;
    case 4: 
      this.resultState = 5;
      return;
    }
    this.resultState = 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin
 * JD-Core Version:    0.7.0.1
 */