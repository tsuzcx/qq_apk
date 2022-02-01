package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSsoJsPlugin
  implements WadlCmdListener, NativePlugin
{
  public static final String EVENT_QUERY_WEBSSO = "requestWebSSO";
  public static final String KEY_CMD = "cmd";
  public static final String KEY_RET = "ret";
  public static final String KEY_RSP = "rsp";
  public static final String KEY_SEQ = "mini_seq";
  private static final String TAG = "WebSsoJsPlugin";
  SparseArray<JSContext> callbackMap = new SparseArray();
  private int seq = 0;
  
  public WebSsoJsPlugin()
  {
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
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
    WadlCommConfig localWadlCommConfig = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
    if (localWadlCommConfig != null) {
      return localWadlCommConfig.a();
    }
    return GameCenterUtil.a;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("mini_seq", -1);
    } else {
      i = -1;
    }
    if (i == -1) {
      return;
    }
    JSContext localJSContext = (JSContext)this.callbackMap.get(i);
    this.callbackMap.remove(i);
    if (localJSContext == null) {
      return;
    }
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
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    boolean bool;
    if (paramLong == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    localJSContext.evaluateCallback(bool, paramJSONObject, "");
  }
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    if (paramJSContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("WebSsoJsPlugin", 2, paramJSONObject.toString());
      }
      if (!"requestWebSSO".equals(paramJSONObject.optString("api_name"))) {}
    }
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("data");
      paramJSONObject = localJSONObject.getString("webssoCmdId");
      localJSONObject = localJSONObject.getJSONObject("webssoReq");
      Object localObject = getFilterCmds();
      if ((!TextUtils.isEmpty(paramJSONObject)) && (localObject != null) && (((HashSet)localObject).contains(paramJSONObject)))
      {
        int i = genSeq();
        this.callbackMap.put(i, paramJSContext);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("mini_seq", i);
        ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestWebSso(paramJSONObject, localJSONObject, (Bundle)localObject);
        return;
      }
      paramJSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.a(2131716369));
      return;
    }
    catch (Throwable paramJSONObject)
    {
      label159:
      break label159;
    }
    paramJSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.a(2131716368));
    if (QLog.isColorLevel()) {
      QLog.w("WebSsoJsPlugin", 2, "requestWebSSO,decode param error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.WebSsoJsPlugin
 * JD-Core Version:    0.7.0.1
 */