package com.tencent.mobileqq.qcircle.api.hybird;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class QCircleHybirdFragment$QCircleHybirdBroadcastReceiver
  extends BroadcastReceiver
{
  private WeakReference<QCircleHybirdFragment> a;
  
  public QCircleHybirdFragment$QCircleHybirdBroadcastReceiver(QCircleHybirdFragment paramQCircleHybirdFragment)
  {
    this.a = new WeakReference(paramQCircleHybirdFragment);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (QCircleHybirdFragment)this.a.get();
    if ((paramContext != null) && (paramIntent != null))
    {
      Object localObject = paramIntent.getAction();
      if (TextUtils.equals((CharSequence)localObject, "action_update_web_user_follow_state")) {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("uin", paramIntent.getStringExtra("uin"));
          ((JSONObject)localObject).put("followstate", paramIntent.getIntExtra("followstate", 0));
          ((JSONObject)localObject).put("blackState", paramIntent.getIntExtra("blackstate", 0));
          if (paramContext.getWebView() == null) {
            return;
          }
          paramContext.getWebView().callJs(WebViewPlugin.toJsScript("updateQCircleFollowState", (JSONObject)localObject, null));
          return;
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      } else if (TextUtils.equals((CharSequence)localObject, "action_update_web_tag_follow_state")) {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("tagId", paramIntent.getStringExtra("tagId"));
          ((JSONObject)localObject).put("followstate", paramIntent.getIntExtra("followstate", 0));
          if (paramContext.getWebView() != null)
          {
            paramContext.getWebView().callJs(WebViewPlugin.toJsScript("updateQCircleTagFollowState", (JSONObject)localObject, null));
            return;
          }
        }
        catch (Exception paramContext)
        {
          QLog.e(QCircleHybirdFragment.b(), 1, "update tag follow state error.", paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdFragment.QCircleHybirdBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */