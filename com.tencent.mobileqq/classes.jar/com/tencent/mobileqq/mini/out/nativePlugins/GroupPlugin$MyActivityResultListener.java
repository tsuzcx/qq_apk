package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
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
    Object localObject;
    if (paramInt1 == 10)
    {
      localObject = new JSONArray();
      if ((paramIntent == null) || (paramInt2 != -1)) {
        break label184;
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
            ((JSONArray)localObject).put(new JSONObject().put("uin", localResultRecord.uin).put("name", localResultRecord.name));
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
    label184:
    for (boolean bool = true;; bool = false)
    {
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("persons", localObject);
        localObject = this.this$0.mJsContext;
        if (QLog.isColorLevel()) {
          QLog.i("GroupPlugin", 2, String.format("evaluateCallback [ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS] %s", new Object[] { paramIntent }));
        }
        if (localObject != null) {
          ((JSContext)localObject).evaluateCallback(bool, paramIntent, "errDesc");
        }
        return false;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin.MyActivityResultListener
 * JD-Core Version:    0.7.0.1
 */