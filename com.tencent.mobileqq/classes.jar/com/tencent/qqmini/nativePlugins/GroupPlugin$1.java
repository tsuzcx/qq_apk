package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
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
    JSONArray localJSONArray;
    if (paramInt1 == 20001)
    {
      ActivityResultManager.g().removeActivityResultListener(this);
      localJSONArray = new JSONArray();
      if ((paramIntent == null) || (paramInt2 != -1)) {
        break label191;
      }
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramIntent.size())
        {
          ResultRecord localResultRecord = (ResultRecord)paramIntent.get(paramInt1);
          try
          {
            localJSONArray.put(new JSONObject().put("uin", localResultRecord.uin).put("name", localResultRecord.name));
            paramInt1 += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              localJSONException2.printStackTrace();
            }
          }
        }
      }
    }
    label191:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("persons", localJSONArray);
        if (QLog.isColorLevel()) {
          QLog.i("GroupPlugin", 2, String.format("evaluateCallback [ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS] %s", new Object[] { paramIntent }));
        }
        if (paramInt1 != 0)
        {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(paramIntent);
          return false;
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail(paramIntent, "errDesc");
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.GroupPlugin.1
 * JD-Core Version:    0.7.0.1
 */