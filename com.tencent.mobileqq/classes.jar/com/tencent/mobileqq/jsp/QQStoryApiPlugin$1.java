package com.tencent.mobileqq.jsp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QQStoryApiPlugin$1
  extends BroadcastReceiver
{
  QQStoryApiPlugin$1(QQStoryApiPlugin paramQQStoryApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    Bundle localBundle = paramIntent.getExtras();
    boolean bool = "com.tencent.mobileqq.action.dispatch_event_do_like".equals(paramContext);
    int j = 1;
    int k = 1;
    int i = 1;
    Object localObject = "doSubscibe";
    paramIntent = null;
    JSONObject localJSONObject1;
    label183:
    JSONObject localJSONObject2;
    if (bool)
    {
      try
      {
        paramContext = new JSONObject();
        try
        {
          if (!localBundle.getBoolean("doLike")) {
            break label550;
          }
          paramContext.put("doLike", i);
          paramContext.put("vid", localBundle.getString("vid"));
          paramContext.put("uin", localBundle.getLong("uin"));
          paramIntent = paramContext;
        }
        catch (JSONException localJSONException1) {}
        paramIntent = paramContext;
      }
      catch (JSONException localJSONException2)
      {
        paramContext = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("QQStoryApiPlugin", 2, QLog.getStackTraceString(localJSONException2));
        paramIntent = paramContext;
      }
      localJSONObject1 = new JSONObject();
      paramContext = "doLike";
    }
    else if ("com.tencent.mobileqq.action.dispatch_event_comment".equals(paramContext))
    {
      try
      {
        paramContext = new JSONObject();
        try
        {
          if (!localJSONObject1.getBoolean("doComment")) {
            break label555;
          }
          i = j;
          paramContext.put("doComment", i);
          paramContext.put("vid", localJSONObject1.getString("vid"));
          paramContext.put("commentID", localJSONObject1.getInt("commentID"));
          paramContext.put("uin", localJSONObject1.getLong("uin"));
          paramContext.put("selfuin", localJSONObject1.getLong("selfuin"));
          paramIntent = paramContext;
        }
        catch (JSONException localJSONException3) {}
        paramIntent = paramContext;
      }
      catch (JSONException localJSONException4)
      {
        paramContext = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("QQStoryApiPlugin", 2, QLog.getStackTraceString(localJSONException4));
        paramIntent = paramContext;
      }
      localJSONObject2 = new JSONObject();
      paramContext = "doComment";
    }
    else if (!"com.tencent.mobileqq.action.dispatch_event_subscribe".equals(paramContext)) {}
    for (;;)
    {
      try
      {
        paramContext = new JSONObject();
        try
        {
          if (!localJSONObject2.getBoolean("doSubscibe")) {
            break label560;
          }
          i = k;
          paramContext.put("doSubscibe", i);
          paramContext.put("vid", localJSONObject2.getString("vid"));
          paramContext.put("commentID", localJSONObject2.getInt("commentID"));
          paramContext.put("uin", localJSONObject2.getLong("uin"));
          paramContext.put("selfuin", localJSONObject2.getLong("selfuin"));
          paramIntent = paramContext;
        }
        catch (JSONException localJSONException5) {}
        paramIntent = paramContext;
      }
      catch (JSONException localJSONException6)
      {
        paramContext = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("QQStoryApiPlugin", 2, QLog.getStackTraceString(localJSONException6));
        paramIntent = paramContext;
      }
      JSONObject localJSONObject3 = new JSONObject();
      paramContext = (Context)localObject;
      break label450;
      localJSONObject3 = null;
      paramContext = localJSONObject3;
      label450:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("StoryApi method = ");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(", data = ");
        ((StringBuilder)localObject).append(paramIntent);
        ((StringBuilder)localObject).append(", source = ");
        ((StringBuilder)localObject).append(localJSONObject3);
        QLog.w("QQStoryApiPlugin", 2, ((StringBuilder)localObject).toString());
      }
      if ((!TextUtils.isEmpty(paramContext)) && (paramIntent != null) && (localJSONObject3 != null)) {
        this.a.dispatchJsEvent(paramContext, paramIntent, localJSONObject3);
      }
      return;
      label550:
      i = 0;
      break;
      label555:
      i = 0;
      break label183;
      label560:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQStoryApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */