package com.tencent.qqmini.nativePlugins;

import aljq;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import bgho;
import bgkd;
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
  
  private JSONObject getParam(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("TimTeamPlugin", "Failed to parse jsonParams=" + parambgkd.b);
    }
    return null;
  }
  
  public void timSpace(bgkd parambgkd)
  {
    try
    {
      parambgkd = new JSONObject(getParam(parambgkd).getString("data")).getString("action");
      if (QMLog.isColorLevel()) {
        QMLog.d("TimTeamPlugin", "onInvoke|" + parambgkd);
      }
      if (TextUtils.equals(parambgkd, "showCoopSpaceProfile"))
      {
        parambgkd = this.mMiniAppContext.a();
        Intent localIntent = new Intent(parambgkd, AccountDetailActivity.class);
        localIntent.putExtra("uin", aljq.aV);
        parambgkd.startActivity(localIntent);
      }
      return;
    }
    catch (Exception parambgkd)
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