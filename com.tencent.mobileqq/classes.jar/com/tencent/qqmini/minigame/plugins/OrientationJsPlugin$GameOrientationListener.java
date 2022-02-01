package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OrientationJsPlugin$GameOrientationListener
  extends OrientationEventListener
{
  public OrientationJsPlugin$GameOrientationListener(OrientationJsPlugin paramOrientationJsPlugin, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    String str = null;
    if ((paramInt <= 350) && (paramInt >= 10))
    {
      if ((paramInt > 80) && (paramInt < 100)) {
        str = "landscapeReverse";
      } else if ((paramInt <= 170) || (paramInt >= 190)) {
        if ((paramInt > 260) && (paramInt < 280)) {
          str = "landscape";
        }
      }
    }
    else {
      str = "portrait";
    }
    if ((str != null) && (!str.equals(OrientationJsPlugin.access$000(this.this$0))))
    {
      OrientationJsPlugin.access$002(this.this$0, str);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("value", str);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OrientationChange call back error:");
        localStringBuilder.append(localJSONException.toString());
        QMLog.e("OrientationJsPlugin", localStringBuilder.toString());
      }
      OrientationJsPlugin.access$100(this.this$0, "onDeviceOrientationChange", localJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OrientationJsPlugin.GameOrientationListener
 * JD-Core Version:    0.7.0.1
 */