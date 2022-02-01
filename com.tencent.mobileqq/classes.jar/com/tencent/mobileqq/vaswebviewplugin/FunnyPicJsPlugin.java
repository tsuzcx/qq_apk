package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import anvx;
import ascz;
import asdd;
import awcn;
import bifw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class FunnyPicJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "qutu";
  public static final String TAG = "FunnyPicJsPlugin";
  public Bundle mReqBundle;
  
  public FunnyPicJsPlugin()
  {
    this.mPluginNameSpace = "qutu";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FunnyPicJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"qutu".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramString2 = null;
    paramJsBridgeListener = paramString2;
    try
    {
      paramVarArgs = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramVarArgs == null) {
        return true;
      }
      paramJsBridgeListener = paramString2;
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = paramString2;
        QLog.d("FunnyPicJsPlugin", 2, "handleJsRequest JSON = " + paramVarArgs.toString());
      }
      paramJsBridgeListener = paramString2;
      paramString1 = paramVarArgs.optString("callback");
      paramJsBridgeListener = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        paramJsBridgeListener = paramString1;
        QLog.e("FunnyPicJsPlugin", 1, "callback id is null, so return");
        return true;
      }
      paramJsBridgeListener = paramString1;
      if ("getCurrentPkgInfo".equals(paramString3))
      {
        paramJsBridgeListener = paramString1;
        this.mReqBundle.clear();
        paramJsBridgeListener = paramString1;
        this.mReqBundle.putString("jsonContent", paramVarArgs.toString());
        paramJsBridgeListener = paramString1;
        super.sendRemoteReq(asdd.a("ipc_funnypic_query_info", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      }
      else
      {
        paramJsBridgeListener = paramString1;
        if ("addQutu".equals(paramString3))
        {
          paramJsBridgeListener = paramString1;
          paramString2 = this.mRuntime.a();
          if (paramString2 != null)
          {
            paramJsBridgeListener = paramString1;
            if (!NetworkUtil.isNetworkAvailable(paramString2))
            {
              paramJsBridgeListener = paramString1;
              paramString2 = new JSONObject();
              paramJsBridgeListener = paramString1;
              paramString2.put("result", 1);
              paramJsBridgeListener = paramString1;
              super.callJs(paramString1 + "(" + paramString2.toString() + ");");
              return true;
            }
          }
          paramJsBridgeListener = paramString1;
          if (!"mounted".equals(Environment.getExternalStorageState()))
          {
            paramJsBridgeListener = paramString1;
            QQToast.a(paramString2, anvx.a(2131704469), 0).a();
            paramJsBridgeListener = paramString1;
            paramString2 = new JSONObject();
            paramJsBridgeListener = paramString1;
            paramString2.put("result", 1);
            paramJsBridgeListener = paramString1;
            super.callJs(paramString1 + "(" + paramString2.toString() + ");");
            return true;
          }
          paramJsBridgeListener = paramString1;
          int j = paramVarArgs.getInt("action");
          paramJsBridgeListener = paramString1;
          paramString2 = paramVarArgs.getJSONArray("uids");
          paramJsBridgeListener = paramString1;
          int k = paramString2.length();
          int i = -1;
          if (k > 0)
          {
            paramJsBridgeListener = paramString1;
            i = ((JSONObject)paramString2.get(0)).getInt("pkgid");
          }
          paramJsBridgeListener = paramString1;
          paramString3 = new WebSSOAgent.UniSsoServerReqComm();
          paramJsBridgeListener = paramString1;
          paramString3.platform.set(109L);
          paramJsBridgeListener = paramString1;
          paramString3.osver.set(Build.VERSION.RELEASE);
          paramJsBridgeListener = paramString1;
          paramString3.mqqver.set("8.4.10");
          paramJsBridgeListener = paramString1;
          paramString2 = new WebSSOAgent.UniSsoServerReq();
          paramJsBridgeListener = paramString1;
          paramString2.comm.set(paramString3);
          paramJsBridgeListener = paramString1;
          JSONObject localJSONObject = new JSONObject();
          paramJsBridgeListener = paramString1;
          localJSONObject.put("appid", "10");
          paramJsBridgeListener = paramString1;
          paramString3 = String.valueOf(i);
          paramJsBridgeListener = paramString1;
          localJSONObject.put("itemid", paramString3);
          paramJsBridgeListener = paramString1;
          Object localObject = new JSONArray();
          paramJsBridgeListener = paramString1;
          ((JSONArray)localObject).put(localJSONObject);
          paramJsBridgeListener = paramString1;
          localJSONObject = new JSONObject();
          paramJsBridgeListener = paramString1;
          localJSONObject.put("itemlist", localObject);
          paramJsBridgeListener = paramString1;
          localJSONObject.put("authType", "1");
          paramJsBridgeListener = paramString1;
          paramString2.reqdata.set(localJSONObject.toString());
          paramJsBridgeListener = paramString1;
          paramString3 = new FunnyPicJsPlugin.1(this, paramString3, paramVarArgs, j, paramString1);
          paramJsBridgeListener = paramString1;
          paramVarArgs = this.mRuntime.a();
          if (paramVarArgs != null)
          {
            paramJsBridgeListener = paramString1;
            localObject = new NewIntent(this.mRuntime.a().getApp(), awcn.class);
            paramJsBridgeListener = paramString1;
            ((NewIntent)localObject).putExtra("extra_cmd", "AuthProxy.check");
            paramJsBridgeListener = paramString1;
            ((NewIntent)localObject).putExtra("extra_data", paramString2.toByteArray());
            paramJsBridgeListener = paramString1;
            ((NewIntent)localObject).setObserver(paramString3);
            paramJsBridgeListener = paramString1;
            paramVarArgs.startServlet((NewIntent)localObject);
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FunnyPicJsPlugin", 2, paramString1.getMessage());
      }
      try
      {
        paramString2 = new JSONObject();
        paramString2.put("result", 1);
        paramString2.put("message", paramString1.getMessage());
        super.callJs(paramJsBridgeListener + "(" + paramString2.toString() + ");");
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FunnyPicJsPlugin", 2, paramString1.getMessage());
        }
      }
    }
    return true;
  }
  
  public void onCreate()
  {
    this.mRuntime.a();
    this.mReqBundle = new Bundle();
    super.onCreate();
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject1;
    String str;
    int i;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject1 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      if ((localObject1 != null) && (!"ipc_funnypic_add".equals(localObject1))) {}
    }
    else
    {
      try
      {
        i = paramBundle.getInt("result", 0);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("result", i);
        Object localObject2 = paramBundle.getString("data");
        if (localObject2 != null) {
          ((JSONObject)localObject1).put("data", new JSONObject((String)localObject2));
        }
        if (i != 0)
        {
          localObject2 = paramBundle.getString("message");
          if (localObject2 != null) {
            ((JSONObject)localObject1).put("message", localObject2);
          }
        }
        boolean bool = paramBundle.getBoolean("openManagerActivity", false);
        localObject2 = this.mRuntime.a();
        if ((bool) && (localObject2 != null) && (!this.isDestroy) && (!((Activity)localObject2).isFinishing()))
        {
          ArrayList localArrayList1 = paramBundle.getStringArrayList("extra_key_pkgids");
          ArrayList localArrayList2 = paramBundle.getStringArrayList("extra_key_paths");
          ArrayList localArrayList3 = paramBundle.getStringArrayList("extra_key_md5s");
          i = paramBundle.getInt("extra_key_over_num");
          int j = paramBundle.getInt("extra_key_faile_count");
          paramBundle = new Intent(((Activity)localObject2).getApplicationContext(), FavEmosmManageActivity.class);
          paramBundle.setFlags(268435456);
          paramBundle.putExtra("extra_key_from_web", true);
          paramBundle.putStringArrayListExtra("extra_key_pkgids", localArrayList1);
          paramBundle.putStringArrayListExtra("extra_key_paths", localArrayList2);
          paramBundle.putStringArrayListExtra("extra_key_md5s", localArrayList3);
          paramBundle.putExtra("extra_key_faile_count", j);
          paramBundle.putExtra("extra_key_over_num", i);
          ((Activity)localObject2).startActivity(paramBundle);
        }
        super.callJs(str + "(" + ((JSONObject)localObject1).toString() + ");");
        return;
      }
      catch (Exception paramBundle)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("FunnyPicJsPlugin", 2, paramBundle.getMessage());
        return;
      }
    }
    if ("ipc_funnypic_query_info".equals(localObject1)) {
      for (;;)
      {
        try
        {
          i = paramBundle.getInt("result", 0);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("result", i);
          if (i != 0) {
            break label498;
          }
          paramBundle = paramBundle.getString("data");
          if (paramBundle != null) {
            ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
          }
          super.callJs(str + "(" + ((JSONObject)localObject1).toString() + ");");
          return;
        }
        catch (Exception paramBundle) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FunnyPicJsPlugin", 2, paramBundle.getMessage());
        return;
        label498:
        paramBundle = paramBundle.getString("message");
        if (paramBundle != null) {
          ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
        }
      }
    }
    super.onResponse(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin
 * JD-Core Version:    0.7.0.1
 */