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
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppActivity;
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
  private static final String TAG = "QWalletMixJsPlugin";
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
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((JSONArray)localObject).length())
    {
      try
      {
        localArrayList.add(((JSONArray)localObject).getString(i));
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, localJSONException, new Object[0]);
        }
      }
      i += 1;
    }
    localObject = (IQQReminderService)this.app.getRuntimeService(IQQReminderService.class, "");
    if (localObject == null) {
      return;
    }
    ((IQQReminderService)localObject).sendBatchSubscribeReminder(localArrayList, paramJSONObject, new QWalletMixJsPlugin.2(this));
  }
  
  private void deleteNotify(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if ((!StringUtil.isEmpty(str)) && (!StringUtil.isEmpty(str)))
    {
      Object localObject = new Handler(Looper.getMainLooper());
      IQQReminderService localIQQReminderService = (IQQReminderService)this.app.getRuntimeService(IQQReminderService.class, "");
      if (localIQQReminderService == null) {
        return;
      }
      localIQQReminderService.sendDelReminderListById(str, 0L, 2, new QWalletMixJsPlugin.1(this, (Handler)localObject, paramJSONObject, str));
      paramJSONObject = (IQQReminderCalendarService)this.app.getRuntimeService(IQQReminderCalendarService.class, "");
      localObject = new CalendarEntity();
      ((CalendarEntity)localObject).msg_id = str;
      paramJSONObject.deleteCalendarAlarm((AppActivity)this.mRuntime.d(), (CalendarEntity)localObject);
      return;
    }
    handJsError("4", "params error");
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handJsError: ");
      localStringBuilder.append(paramString2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("retcode", paramString1);
      ((JSONObject)localObject).put("retmsg", paramString2);
      doCallback(((JSONObject)localObject).toString());
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
      JSONObject localJSONObject = new JSONObject(paramString);
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
      if ("batchSubscribe".equals(paramString))
      {
        batchSubscribeNotify(localJSONObject);
        return true;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 1, "handleQQNotifyJsAPi", paramString);
      }
    }
    return true;
  }
  
  private void newSubscribeRecurrentNotifyFragment(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if (StringUtil.isEmpty(str1))
    {
      handJsError("4", "params error");
      return;
    }
    if (this.mRuntime != null)
    {
      String str2 = Uri.parse(this.mRuntime.a().getUrl()).getHost();
      QQNotifyUtils.a(this.mRuntime.d(), str1, str2, paramJSONObject, QQNotifySettingBaseFragment.a);
    }
  }
  
  private void notifydelMsgUI(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("busiid", paramString1);
    localBundle.putString("msgid", paramString2);
    paramString1 = DataFactory.a("ipc_cmd_is_qq_notify_all_notify", this.mCallback, this.mOnRemoteResp.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString1);
  }
  
  private void parseCallback(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.toLowerCase().indexOf("callback") < 0) {
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
  }
  
  private void queryBusinessHasSet(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if (StringUtil.isEmpty(str))
    {
      handJsError("4", "params error");
      return;
    }
    if (this.mRuntime != null) {
      QQNotifyUtils.a(str, Uri.parse(this.mRuntime.a().getUrl()).getHost(), paramJSONObject, this);
    }
  }
  
  private void subscribeNotify(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("msgid");
    paramJSONObject = paramJSONObject.optString("busiid");
    if ((!StringUtil.isEmpty(str1)) && (!StringUtil.isEmpty(str1)))
    {
      if (this.mRuntime != null)
      {
        String str2 = Uri.parse(this.mRuntime.a().getUrl()).getHost();
        QQNotifySettingInnerFragment.a(this.mRuntime.d(), str1, paramJSONObject, str2);
      }
      return;
    }
    handJsError("4", "params error");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleJsRequeste pkgName :");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" method: ");
      localStringBuilder.append(paramString3);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append(" arg: ");
        paramJsBridgeListener.append(paramVarArgs[0]);
        paramJsBridgeListener = paramJsBridgeListener.toString();
      }
      else
      {
        paramJsBridgeListener = "";
      }
      localStringBuilder.append(paramJsBridgeListener);
      QLog.i(paramString1, 2, localStringBuilder.toString());
    }
    if (("qw_mix".equals(paramString2)) && ("qqNotify".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      parseCallback(paramVarArgs[0]);
      return handleQQNotifyJsAPi(paramVarArgs[0]);
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resultCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" requestCode: ");
      localStringBuilder.append(getRequestCode(paramByte));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramInt == -1) && (getRequestCode(paramByte) == QQNotifySettingBaseFragment.a)) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", paramIntent.getIntExtra("errorCode", 0));
        ((JSONObject)localObject).put("retmsg", paramIntent.getStringExtra("msg"));
        doCallback(((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.d();
      if (localActivity != null)
      {
        this.app = this.mRuntime.b();
        if (QLog.isColorLevel())
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("is QQAppInterface: ");
          localStringBuilder.append(this.app instanceof QQAppInterface);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.mContext = localActivity.getApplicationContext();
      }
    }
  }
  
  protected void onDestroy()
  {
    if ((this.mRuntime != null) && (this.mRuntime.d() != null))
    {
      localObject = this.mRuntime.d();
      mFirstUrls.remove(localObject.hashCode());
      mSequence.remove(Integer.valueOf(localObject.hashCode()));
    }
    Object localObject = this.mMainHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if ((this.mRuntime != null) && (this.mRuntime.d() != null))
    {
      Activity localActivity = this.mRuntime.d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin
 * JD-Core Version:    0.7.0.1
 */