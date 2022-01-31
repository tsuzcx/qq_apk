package com.tencent.qqmini.nativePlugins;

import alof;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import bglv;
import bgok;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TimTeamPlugin
  extends BaseJsPlugin
{
  public static final String ACTION_SHOW_PROFILE = "showCoopSpaceProfile";
  public static final String PLUGIN_NAME = "tim_space";
  public static final String TAG = "TimTeamPlugin";
  
  private JSONObject getParam(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TimTeamPlugin", "Failed to parse jsonParams=" + parambgok.b);
    }
    return null;
  }
  
  public void timSpace(bgok parambgok)
  {
    try
    {
      parambgok = new JSONObject(getParam(parambgok).getString("data")).getString("action");
      if (QMLog.isColorLevel()) {
        QMLog.d("TimTeamPlugin", "onInvoke|" + parambgok);
      }
      if (TextUtils.equals(parambgok, "showCoopSpaceProfile"))
      {
        parambgok = this.mMiniAppContext.a();
        Intent localIntent = new Intent(parambgok, AccountDetailActivity.class);
        localIntent.putExtra("uin", alof.aV);
        parambgok.startActivity(localIntent);
      }
      return;
    }
    catch (Exception parambgok)
    {
      while (!QMLog.isColorLevel()) {}
      QMLog.w("TimTeamPlugin", "decode param error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TimTeamPlugin
 * JD-Core Version:    0.7.0.1
 */