package com.tencent.mobileqq.mini.out.nativePlugins;

import ajyc;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayPlugin
  implements NativePlugin
{
  public static final String PLUGIN_NAME = "openTenpayView";
  public static final String TAG = "TenpayPlugin";
  private NativePlugin.JSContext jsContext;
  private TenpayPlugin.TenpayRecevicer payRecevicer;
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    this.jsContext = paramJSContext;
    this.payRecevicer = new TenpayPlugin.TenpayRecevicer(this, new Handler(Looper.getMainLooper()));
    QLog.e("TenpayPlugin", 1, "param: " + paramJSONObject.toString());
    try
    {
      paramJSContext = new Bundle();
      paramJSContext.putString("json", paramJSONObject.getString("data"));
      paramJSContext.putString("callbackSn", "0");
      paramJSContext.putInt("payparmas_paytype", 1);
      if (!PayBridgeActivity.a(this.jsContext.getActivity(), 5, paramJSContext, this.payRecevicer)) {
        this.jsContext.evaluateCallback(false, null, ajyc.a(2131714844));
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      this.jsContext.evaluateCallback(false, null, ajyc.a(2131714843));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin
 * JD-Core Version:    0.7.0.1
 */