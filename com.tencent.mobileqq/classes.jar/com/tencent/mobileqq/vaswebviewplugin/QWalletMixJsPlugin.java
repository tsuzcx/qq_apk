package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils.QQNotifyListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletMixJsPlugin
  extends VasWebviewJsPlugin
  implements QQNotifyUtils.QQNotifyListener
{
  public static final String ERROR_MSG_PARAM_ERROR = "params error";
  public static final String ERROR_MSG_UNKNOWN_ERROR = "client_unknown_error";
  public static final int ERROR_RETURN_CODE_PARAM_ERROR = 4;
  public static final int ERROR_RETURN_CODE_UNKNOWN_ERROR = -100;
  private static final String METHOD_ACTION_BATCH_SUBSCRIBE = "batchSubscribe";
  private static final String METHOD_ACTION_DELETE_NOTIFY = "delete";
  public static final String METHOD_ACTION_NOTIFY_NEW_SUBSCRIBE = "newSubscribe";
  public static final String METHOD_ACTION_NOTIFY_QUERY = "query";
  private static final String METHOD_ACTION_NPTITY_SUBSCRIBE = "subscribe";
  private static final String METHOD_ACTION_REMOVE_NOTIFY = "remove";
  private static final String METHOD_NAME_QQ_NOTIFY = "qqNotify";
  public static final String OBJECT_NAME_QWALLET_MIX = "qw_mix";
  public static final String PARAMS_BUSINESS_ID = "busiid";
  public static final String PARAMS_CALLBACK_ID = "callback_id";
  public static final String PARAMS_DOMAIN = "domain";
  public static final String PARAMS_ERROR_MSG = "retmsg";
  public static final String PARAMS_HAS_SUBSCRIBE = "has_subscribe";
  public static final String PARAMS_MSG_ID = "msgid";
  public static final String PARAMS_RETURN_CODE = "retcode";
  private static final String TAG = QWalletMixJsPlugin.class.getSimpleName();
  public static SparseArray<String> mFirstUrls = new SparseArray();
  public static ArrayList<Integer> mSequence = new ArrayList();
  private AppInterface app;
  private String mCallback;
  private Context mContext;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  public QWalletMixJsPlugin()
  {
    this.mPluginNameSpace = "qw_mix";
  }
  
  private void batchSubscribeNotify(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONArray("msg_id_list");
    paramJSONObject = paramJSONObject.optString("domain");
    if (this.mRuntime != null) {
      paramJSONObject = Uri.parse(this.mRuntime.a().getUrl()).getHost();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i < ((JSONArray)localObject).length()) {
          try
          {
            localArrayList.add(((JSONArray)localObject).getString(i));
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, localJSONException, new Object[0]);
              }
            }
          }
        }
      }
      localObject = (IQQReminderService)this.app.getRuntimeService(IQQReminderService.class, "");
      if (localObject == null) {
        return;
      }
      ((IQQReminderService)localObject).sendBatchSubscribeReminder(localArrayList, paramJSONObject, new QWalletMixJsPlugin.2(this));
      return;
    }
  }
  
  private void deleteNotify(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if ((StringUtil.a(str)) || (StringUtil.a(str))) {
      handJsError("4", "params error");
    }
    Handler localHandler;
    IQQReminderService localIQQReminderService;
    do
    {
      return;
      localHandler = new Handler(Looper.getMainLooper());
      localIQQReminderService = (IQQReminderService)this.app.getRuntimeService(IQQReminderService.class, "");
    } while (localIQQReminderService == null);
    localIQQReminderService.sendDelReminderListById(str, 0L, 2, new QWalletMixJsPlugin.1(this, localHandler, paramJSONObject, str));
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
  
  private void handJsResult(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("retcode", paramInt);
      doCallback(localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean handleQQNotifyJsAPi(String paramString)
  {
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.optString("action");
      localJSONObject = localJSONObject.optJSONObject("params");
      if ("subscribe".equals(paramString))
      {
        subscribeNotify(localJSONObject);
        return true;
      }
      if ("delete".equals(paramString))
      {
        deleteNotify(localJSONObject);
        return true;
      }
    }
    catch (Exception paramString)
    {
      JSONObject localJSONObject;
      if (QLog.isColorLevel())
      {
        QLog.e(TAG, 1, "handleQQNotifyJsAPi", paramString);
        return true;
        if ("newSubscribe".equals(paramString))
        {
          newSubscribeRecurrentNotifyFragment(localJSONObject);
          return true;
        }
        if ("query".equals(paramString))
        {
          queryBusinessHasSet(localJSONObject);
          return true;
        }
        if ("remove".equals(paramString))
        {
          deleteNotify(localJSONObject);
          return true;
        }
        if ("batchSubscribe".equals(paramString)) {
          batchSubscribeNotify(localJSONObject);
        }
      }
    }
    return true;
  }
  
  private void newSubscribeRecurrentNotifyFragment(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if (StringUtil.a(str1)) {
      handJsError("4", "params error");
    }
    while (this.mRuntime == null) {
      return;
    }
    String str2 = Uri.parse(this.mRuntime.a().getUrl()).getHost();
    QQNotifyUtils.a(this.mRuntime.a(), str1, str2, paramJSONObject, QQNotifySettingBaseFragment.a);
  }
  
  private void notifydelMsgUI(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("busiid", paramString1);
    localBundle.putString("msgid", paramString2);
    paramString1 = DataFactory.a("ipc_cmd_is_qq_notify_all_notify", this.mCallback, this.mOnRemoteResp.key, localBundle);
    WebIPCOperator.a().a(paramString1);
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
  
  private void queryBusinessHasSet(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if (StringUtil.a(str)) {
      handJsError("4", "params error");
    }
    while (this.mRuntime == null) {
      return;
    }
    QQNotifyUtils.a(str, Uri.parse(this.mRuntime.a().getUrl()).getHost(), paramJSONObject, this);
  }
  
  private void subscribeNotify(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if ((StringUtil.a(str1)) || (StringUtil.a(str1))) {
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
        break label136;
      }
    }
    label136:
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
    if ((paramInt == -1) && (getRequestCode(paramByte) == QQNotifySettingBaseFragment.a)) {}
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
  
  public void queryHasSetNotify(Bundle paramBundle1, Bundle paramBundle2)
  {
    doCallback(QQNotifyUtils.a(paramBundle1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin
 * JD-Core Version:    0.7.0.1
 */