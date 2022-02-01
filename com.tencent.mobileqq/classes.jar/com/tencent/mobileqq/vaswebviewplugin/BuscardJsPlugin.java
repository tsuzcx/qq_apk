package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import anvx;
import bifw;
import bkys;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardHelper;
import cooperation.buscard.BuscardProxyService;
import nro;
import org.json.JSONException;
import org.json.JSONObject;

public class BuscardJsPlugin
  extends VasWebviewJsPlugin
  implements ServiceConnection, Handler.Callback
{
  private static final String KEY_FROM = "webfrom";
  private static final String KEY_H5CALLBACKID = "callback";
  public static final String KEY_ISNEED_WRITE = "needwritecard";
  public static final String KEY_NFC_DICARD = "tagDiscovered";
  public static final String KEY_NFC_ERR = "disconnect";
  public static final String KEY_NFC_RESULT = "nfc_result";
  public static final String KEY_PARAMS = "params";
  private static final String KEY_RESULT = "result";
  public static final String KEY_RR_RESPONSE = "service_response";
  public static final int MSG_AUTH_RESP = 7;
  public static final int MSG_DI_CARD = 3;
  public static final int MSG_GETSTATUS = 8;
  public static final int MSG_INIT = 5;
  public static final int MSG_REQ_TO_BUSCARD_SERVICE = 2;
  public static final int MSG_RESPONESE_FROM_BUSCARD_SERVICE = 1;
  public static final int MSG_SERVICE_STARTED = 6;
  public static final int MSG_UNINIT = 4;
  public static final String NAME_SPACE = "nfc";
  private static final String TAG = "BuscardJsPlugin";
  private Handler mHandler = new bkys(this);
  private Messenger mMessenger = new Messenger(this.mHandler);
  private Messenger mService;
  ResultReceiver resultReceiver = new BuscardJsPlugin.1(this, this.mHandler);
  
  public BuscardJsPlugin()
  {
    this.mPluginNameSpace = "nfc";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuscardJsPlugin", 2, "handleJsRequest:" + paramString1);
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      if ("nfcInit".equals(paramString3))
      {
        init(paramJsBridgeListener);
        return true;
      }
      if ("nfcTranceive".equals(paramString3))
      {
        paramString1 = new Bundle();
        paramString1.putString("params", paramJsBridgeListener.toString());
        sendMessage(2, paramString1, true, paramJsBridgeListener.optString("callback"));
        return true;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
      return true;
    }
    if ("nfcUnInit".equals(paramString3))
    {
      paramString1 = new Bundle();
      paramString1.putString("params", paramJsBridgeListener.toString());
      sendMessage(4, paramString1, true, paramJsBridgeListener.optString("callback"));
      return true;
    }
    if ("getNfcStatus".equals(paramString3))
    {
      paramString1 = new Bundle();
      paramString1.putString("params", paramJsBridgeListener.toString());
      sendMessage(8, paramString1, true, paramJsBridgeListener.optString("callback"));
    }
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      Object localObject1;
      String str;
      Object localObject2;
      do
      {
        do
        {
          return true;
          localObject1 = paramMessage.getData();
          if (localObject1 == null) {
            break;
          }
          paramMessage = ((Bundle)localObject1).getString("result");
          str = ((Bundle)localObject1).getString("webfrom");
          localObject1 = ((Bundle)localObject1).getString("callback");
          localObject2 = this.mRuntime.a();
        } while (localObject2 == null);
        localObject2 = ((WebViewFragment)localObject2).getCurrentUrl();
        if (QLog.isColorLevel()) {
          QLog.i("BuscardJsPlugin", 2, "callJs. callbackUrl:" + str + ",currentUrl:" + (String)localObject2);
        }
      } while ((localObject2 == null) || (!((String)localObject2).equals(str)) || (TextUtils.isEmpty((CharSequence)localObject1)));
      if (!TextUtils.isEmpty(paramMessage)) {}
      try
      {
        str = new JSONObject(paramMessage).optString("interface", "");
        if ((!TextUtils.isEmpty(str)) && ("nfcUnInit".equals(str)))
        {
          BaseApplicationImpl.getContext().unbindService(this);
          if (QLog.isColorLevel()) {
            QLog.i("BuscardJsPlugin", 2, "nfcUnInit. unbindService");
          }
        }
        callJs((String)localObject1, new String[] { paramMessage });
        return true;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BuscardJsPlugin", 2, "uinit json exception!" + localThrowable.getStackTrace());
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("BuscardJsPlugin", 2, "handleMessage, bundle is null!");
    return true;
  }
  
  protected void handleReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("BuscardJsPlugin", 2, "handleReceiveResult,resultCode:" + paramInt + ",resultData:" + paramBundle);
          }
          switch (paramInt)
          {
          default: 
            return;
          case -2: 
            if (!paramBundle.containsKey("nfcIntent")) {
              break;
            }
          case 4: 
            for (paramBundle = (Intent)paramBundle.get("nfcIntent"); paramBundle != null; paramBundle = new Intent())
            {
              try
              {
                if (TextUtils.isEmpty(paramBundle.getStringExtra("params"))) {
                  break;
                }
                paramBundle = new JSONObject(paramBundle.getStringExtra("params")).optString("callback");
                if (TextUtils.isEmpty(paramBundle)) {
                  break;
                }
                localObject = new JSONObject();
                ((JSONObject)localObject).put("retcode", -8);
                ((JSONObject)localObject).put("retmsg", anvx.a(2131700738));
                callJs(paramBundle, new String[] { ((JSONObject)localObject).toString() });
                return;
              }
              catch (JSONException paramBundle) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("BuscardJsPlugin", 2, "" + paramBundle.getStackTrace());
              return;
              if (QLog.isColorLevel()) {
                QLog.d("BuscardJsPlugin", 2, "STATE_INSTALLED.startService");
              }
              if (paramBundle.containsKey("nfcIntent")) {}
              for (paramBundle = (Intent)paramBundle.get("nfcIntent");; paramBundle = new Intent())
              {
                paramBundle.putExtra("result", this.resultReceiver);
                BuscardHelper.a(this.mRuntime.a(), paramBundle, null);
                return;
              }
            }
          }
          if (paramBundle.getInt("service_response") != 6) {
            break;
          }
        } while (this.mService != null);
        BuscardHelper.a(this.mRuntime.a(), new Intent(), this);
      } while (!QLog.isColorLevel());
      QLog.i("BuscardJsPlugin", 2, "bindService");
      return;
      localObject = paramBundle.getString("callback");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    callJs((String)localObject, new String[] { paramBundle.getString("nfc_result") });
  }
  
  public void init(JSONObject paramJSONObject)
  {
    if (this.mService != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("params", paramJSONObject.toString());
      sendMessage(5, (Bundle)localObject, true, paramJSONObject.optString("callback"));
      return;
    }
    Object localObject = new Intent("com.tencent.mobileqq.action.buscard");
    Activity localActivity = this.mRuntime.a();
    ((Intent)localObject).setClass(localActivity, JumpActivity.class);
    ((Intent)localObject).putExtra("result", this.resultReceiver);
    ((Intent)localObject).putExtra("params", paramJSONObject.toString());
    if (this.mRuntime.a() != null) {}
    for (paramJSONObject = this.mRuntime.a().getCurrentUrl();; paramJSONObject = "")
    {
      ((Intent)localObject).putExtra("webfrom", paramJSONObject);
      localActivity.startActivity((Intent)localObject);
      return;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    int i = 0;
    Object localObject1;
    boolean bool;
    if ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))
    {
      localObject1 = this.mRuntime.a();
      Object localObject2 = this.mRuntime.a();
      if (localObject2 == null) {
        break label282;
      }
      localObject2 = ((WebViewFragment)localObject2).getCurrentUrl();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label282;
      }
      bool = nro.a().a((String)localObject2, "nfc.nfcInit");
      localObject2 = Uri.parse((String)localObject2);
      if (!((Uri)localObject2).isHierarchical()) {
        break label276;
      }
      localObject2 = ((Uri)localObject2).getQueryParameter("usenfc");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!"1".equals(localObject2))) {
        break label276;
      }
    }
    for (;;)
    {
      if ((!bool) || (i != 0)) {
        BuscardHelper.a(this.mRuntime.a().getCurrentAccountUin(), (Activity)localObject1, paramIntent);
      }
      for (;;)
      {
        super.onActivityResult(paramIntent, paramByte, paramInt);
        return;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putParcelable("params", paramIntent.getParcelableExtra("android.nfc.extra.TAG"));
        sendMessage(3, (Bundle)localObject1, true, "");
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("retcode", 0);
          ((JSONObject)localObject1).put("retmsg", "");
          ((JSONObject)localObject1).put("interface", "tagDiscovered");
          dispatchJsEvent("tagDiscovered", (JSONObject)localObject1, new JSONObject());
        }
        catch (JSONException localJSONException) {}
        if (QLog.isColorLevel()) {
          QLog.e("BuscardJsPlugin", 2, "" + localJSONException.getStackTrace());
        }
      }
      label276:
      i = 1;
      continue;
      label282:
      bool = false;
      i = 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    localBaseApplication.unbindService(this);
    localBaseApplication.stopService(new Intent(localBaseApplication, BuscardProxyService.class));
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuscardJsPlugin", 2, "onServiceConnected.");
    }
    this.mService = new Messenger(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuscardJsPlugin", 2, "onServiceDisconnected.");
    }
    this.mService = null;
    dispatchJsEvent("disconnect", null, null);
  }
  
  public void sendMessage(int paramInt, Bundle paramBundle, boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (this.mService == null)
    {
      if (!QLog.isColorLevel()) {
        break label265;
      }
      QLog.w("BuscardJsPlugin", 2, "mService null!");
      paramInt = 0;
    }
    for (;;)
    {
      if ((paramInt == 0) && (paramBoolean)) {
        paramBundle = new JSONObject();
      }
      try
      {
        paramBundle.put("retcode", -7);
        paramBundle.put("retmsg", "service连接失败");
        paramBundle = paramBundle.toString();
        if (!TextUtils.isEmpty(paramString)) {
          callJs(paramString, new String[] { paramBundle });
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.i("BuscardJsPlugin", 2, "send msg " + paramInt);
        }
        try
        {
          Message localMessage = Message.obtain(this.mHandler, paramInt);
          localMessage.replyTo = this.mMessenger;
          Object localObject = this.mRuntime.a();
          if (localObject != null)
          {
            localObject = ((WebViewFragment)localObject).getCurrentUrl();
            if (paramBundle != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("BuscardJsPlugin", 2, "currentUrl:" + (String)localObject);
              }
              paramBundle.putString("webfrom", (String)localObject);
            }
          }
          localMessage.setData(paramBundle);
          this.mService.send(localMessage);
          paramInt = i;
        }
        catch (RemoteException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BuscardJsPlugin", 2, "" + paramBundle.getStackTrace());
          }
        }
        label265:
        paramInt = 0;
      }
      catch (JSONException paramBundle)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("BuscardJsPlugin", 2, "" + paramBundle.getStackTrace());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin
 * JD-Core Version:    0.7.0.1
 */