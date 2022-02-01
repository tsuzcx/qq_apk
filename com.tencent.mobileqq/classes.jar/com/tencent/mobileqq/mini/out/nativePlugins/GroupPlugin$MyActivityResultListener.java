package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GroupPlugin$MyActivityResultListener
  implements MiniAppController.ActivityResultListener
{
  private GroupPlugin$MyActivityResultListener(GroupPlugin paramGroupPlugin) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10)
    {
      JSONArray localJSONArray = new JSONArray();
      boolean bool;
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
        bool = true;
      }
      else
      {
        bool = false;
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
      JSContext localJSContext = this.this$0.mJsContext;
      if (QLog.isColorLevel()) {
        QLog.i("GroupPlugin", 2, String.format("evaluateCallback [ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS] %s", new Object[] { paramIntent }));
      }
      if (localJSContext != null) {
        localJSContext.evaluateCallback(bool, paramIntent, "errDesc");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin.MyActivityResultListener
 * JD-Core Version:    0.7.0.1
 */