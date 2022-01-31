package com.tencent.mobileqq.mini.out.nativePlugins;

import ajya;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import bdov;
import bdow;
import bicx;
import bicy;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSsoJsPlugin
  implements bicx, NativePlugin
{
  public static final String EVENT_QUERY_WEBSSO = "requestWebSSO";
  public static final String KEY_CMD = "cmd";
  public static final String KEY_RET = "ret";
  public static final String KEY_RSP = "rsp";
  public static final String KEY_SEQ = "mini_seq";
  private static final String TAG = "WebSsoJsPlugin";
  SparseArray<NativePlugin.JSContext> callbackMap = new SparseArray();
  private int seq;
  
  public WebSsoJsPlugin()
  {
    bicy.a().a(this);
  }
  
  private int genSeq()
  {
    try
    {
      int i = this.seq;
      this.seq = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public HashSet<String> getFilterCmds()
  {
    bdov localbdov = (bdov)bdow.a().a("comminfo");
    if (localbdov != null) {
      return localbdov.a();
    }
    return bicy.a;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("mini_seq", -1);
      if (i != -1) {
        break label26;
      }
    }
    label26:
    NativePlugin.JSContext localJSContext;
    do
    {
      return;
      i = -1;
      break;
      localJSContext = (NativePlugin.JSContext)this.callbackMap.get(i);
      this.callbackMap.remove(i);
    } while (localJSContext == null);
    paramIntent = paramJSONObject;
    if (paramJSONObject == null) {
      paramIntent = new JSONObject();
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("cmd", paramString);
      paramJSONObject.put("ret", paramLong);
      paramJSONObject.put("rsp", paramIntent);
      if (paramLong == 0L)
      {
        bool = true;
        localJSContext.evaluateCallback(bool, paramJSONObject, "");
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
        continue;
        boolean bool = false;
      }
    }
  }
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    if (paramJSContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("WebSsoJsPlugin", 2, paramJSONObject.toString());
      }
      if ("requestWebSSO".equals(paramJSONObject.optString("api_name"))) {
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject("data");
          paramJSONObject = localJSONObject.getString("webssoCmdId");
          localJSONObject = localJSONObject.getJSONObject("webssoReq");
          Object localObject = getFilterCmds();
          if ((TextUtils.isEmpty(paramJSONObject)) || (localObject == null) || (!((HashSet)localObject).contains(paramJSONObject)))
          {
            paramJSContext.evaluateCallback(false, new JSONObject(), ajya.a(2131716901));
            return;
          }
          int i = genSeq();
          this.callbackMap.put(i, paramJSContext);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("mini_seq", i);
          bicy.a().a(paramJSONObject, localJSONObject, (Bundle)localObject);
          return;
        }
        catch (Throwable paramJSONObject)
        {
          paramJSContext.evaluateCallback(false, new JSONObject(), ajya.a(2131716900));
          if (QLog.isColorLevel()) {
            QLog.w("WebSsoJsPlugin", 2, "requestWebSSO,decode param error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.WebSsoJsPlugin
 * JD-Core Version:    0.7.0.1
 */