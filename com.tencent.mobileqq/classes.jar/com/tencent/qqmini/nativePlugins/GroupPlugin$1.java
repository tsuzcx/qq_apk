package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GroupPlugin$1
  implements IActivityResultListener
{
  GroupPlugin$1(GroupPlugin paramGroupPlugin, RequestEvent paramRequestEvent) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20001)
    {
      ((IActivityResultManager)GroupPlugin.a(this.b).getManager(IActivityResultManager.class)).removeActivityResultListener(this);
      JSONArray localJSONArray = new JSONArray();
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
        paramInt1 = 0;
        while (paramInt1 < paramIntent.size())
        {
          ResultRecord localResultRecord = (ResultRecord)paramIntent.get(paramInt1);
          try
          {
            localJSONArray.put(new JSONObject().put("uin", localResultRecord.uin).put("name", localResultRecord.name));
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
          paramInt1 += 1;
        }
        paramInt1 = 1;
      }
      else
      {
        paramInt1 = 0;
      }
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("persons", localJSONArray);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.i("GroupPlugin", 2, String.format("evaluateCallback [ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS] %s", new Object[] { paramIntent }));
      }
      if (paramInt1 != 0)
      {
        this.a.ok(paramIntent);
        return false;
      }
      this.a.fail(paramIntent, "errDesc");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.GroupPlugin.1
 * JD-Core Version:    0.7.0.1
 */