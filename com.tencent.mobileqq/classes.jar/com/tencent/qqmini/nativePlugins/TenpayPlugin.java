package com.tencent.qqmini.nativePlugins;

import alud;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import bglv;
import bgok;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayPlugin
  extends BaseJsPlugin
{
  public static final String PLUGIN_NAME = "openTenpayView";
  public static final String TAG = "TenpayPlugin";
  private TenpayPlugin.TenpayRecevicer payRecevicer;
  
  private JSONObject getParam(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TenpayPlugin", "Failed to parse jsonParams=" + parambgok.b);
    }
    return null;
  }
  
  public void openTenpayView(bgok parambgok)
  {
    JSONObject localJSONObject = getParam(parambgok);
    this.payRecevicer = new TenpayPlugin.TenpayRecevicer(this, parambgok, new Handler(Looper.getMainLooper()));
    QLog.e("TenpayPlugin", 1, "param: " + localJSONObject.toString());
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("json", localJSONObject.getString("data"));
      localBundle.putString("callbackSn", "0");
      localBundle.putInt("payparmas_paytype", 1);
      if (!PayBridgeActivity.a(this.mMiniAppContext.a(), 5, localBundle, this.payRecevicer)) {
        parambgok.a(alud.a(2131715239));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      parambgok.a(alud.a(2131715238));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin
 * JD-Core Version:    0.7.0.1
 */