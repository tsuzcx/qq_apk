package com.tencent.mobileqq.vashealth;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class HealthBusinessPlugin$4
  implements BusinessObserver
{
  HealthBusinessPlugin$4(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, new Object[] { "[followUin] onReceive, isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!paramBoolean)
      {
        QLog.e("HealthBusinessPlugin", 1, "[followUin] onReceive isSuccess=false");
        localJSONObject.put("code", -1);
      }
      else
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject = new mobileqq_mp.FollowResponse();
          ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
          paramBundle = (mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get();
          paramInt = paramBundle.ret_code.get();
          paramBundle = paramBundle.err_info.get();
          localJSONObject.put("code", 0);
          localObject = new JSONObject();
          if (paramInt == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("HealthBusinessPlugin", 2, "[followUin] onReceive, follow success");
            }
            ((JSONObject)localObject).put("follow", true);
          }
          else
          {
            QLog.e("HealthBusinessPlugin", 1, new Object[] { "[followUin] onReceive, follow failed, retCode=", Integer.valueOf(paramInt), ", errInfo=", paramBundle });
            ((JSONObject)localObject).put("follow", false);
          }
          localJSONObject.put("response", localObject);
        }
        else
        {
          QLog.e("HealthBusinessPlugin", 1, "[followUin] data null");
          localJSONObject.put("code", -1);
        }
      }
      this.b.callJs(this.a, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.e("HealthBusinessPlugin", 1, "[followUin] parse data error=", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.4
 * JD-Core Version:    0.7.0.1
 */