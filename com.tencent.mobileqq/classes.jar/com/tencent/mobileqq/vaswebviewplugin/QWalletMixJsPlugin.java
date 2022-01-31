package com.tencent.mobileqq.vaswebviewplugin;

import acib;
import acic;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import baip;
import bbac;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletMixJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String METHOD_ACTION_NPTITY_SUBSCRIBE = "subscribe";
  private static final String METHOD_NAME_QQ_NOTIFY = "qqNotify";
  public static final String OBJECT_NAME_QWALLET_MIX = "qw_mix";
  private static final String TAG = QWalletMixJsPlugin.class.getSimpleName();
  public static SparseArray<String> mFirstUrls = new SparseArray();
  public static ArrayList<Integer> mSequence = new ArrayList();
  private AppInterface app;
  private String mCallback;
  private Context mContext;
  private FakeUrl mFakeUrl;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private acic mReminderDataManager;
  
  public QWalletMixJsPlugin()
  {
    this.mPluginNameSpace = "qw_mix";
  }
  
  private void doCallback(String paramString)
  {
    doCallback(this.mCallback, paramString);
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private void handJsError(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handJsError: " + paramString2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retcode", paramString1);
      localJSONObject.put("retmsg", paramString2);
      doCallback(localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean handleQQNotifyJsAPi(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.optString("action");
      localJSONObject = localJSONObject.optJSONObject("params");
      if ("subscribe".equals(paramString)) {
        subscribeNotify(localJSONObject);
      }
      label37:
      return true;
    }
    catch (Exception paramString)
    {
      break label37;
    }
  }
  
  private void parseCallback(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.toLowerCase().indexOf("callback") < 0)) {
      return;
    }
    try
    {
      this.mCallback = new JSONObject(paramString).optString("callback");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void subscribeNotify(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if ((baip.a(str1)) || (baip.a(str1))) {
      handJsError("4", "params error");
    }
    while (this.mRuntime == null) {
      return;
    }
    String str2 = Uri.parse(this.mRuntime.a().getUrl()).getHost();
    QQNotifySettingInnerFragment.a(this.mRuntime.a(), str1, paramJSONObject, str2);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramString1 = TAG;
      localStringBuilder = new StringBuilder().append("handleJsRequeste pkgName :").append(paramString2).append(" method: ").append(paramString3);
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        break label133;
      }
    }
    label133:
    for (paramJsBridgeListener = " arg: " + paramVarArgs[0];; paramJsBridgeListener = "")
    {
      QLog.i(paramString1, 2, paramJsBridgeListener);
      if ((!"qw_mix".equals(paramString2)) || (!"qqNotify".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        break;
      }
      parseCallback(paramVarArgs[0]);
      return handleQQNotifyJsAPi(paramVarArgs[0]);
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "resultCode: " + paramInt + " requestCode: " + getRequestCode(paramByte));
    }
    if ((paramInt == -1) && (getRequestCode(paramByte) == 48128)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retcode", paramIntent.getIntExtra("errorCode", 0));
      localJSONObject.put("retmsg", paramIntent.getStringExtra("msg"));
      doCallback(localJSONObject.toString());
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null)
      {
        this.app = this.mRuntime.a();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "is QQAppInterface: " + (this.app instanceof QQAppInterface));
        }
        this.mReminderDataManager = new acic(this.app);
        acib.a(this.app);
        this.mContext = localActivity.getApplicationContext();
      }
    }
  }
  
  public void onDestroy()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      Activity localActivity = this.mRuntime.a();
      mFirstUrls.remove(localActivity.hashCode());
      mSequence.remove(Integer.valueOf(localActivity.hashCode()));
    }
    if (this.mMainHandler != null) {
      this.mMainHandler.removeCallbacksAndMessages(null);
    }
    acib.a();
    super.onDestroy();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      Activity localActivity = this.mRuntime.a();
      Intent localIntent = localActivity.getIntent();
      if (localIntent != null)
      {
        String str = localIntent.getStringExtra("homepage");
        paramCustomWebView = str;
        if (TextUtils.isEmpty(str)) {
          paramCustomWebView = localIntent.getStringExtra("url");
        }
        if (paramCustomWebView != null)
        {
          mFirstUrls.append(localActivity.hashCode(), paramCustomWebView);
          mSequence.add(0, Integer.valueOf(localActivity.hashCode()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin
 * JD-Core Version:    0.7.0.1
 */