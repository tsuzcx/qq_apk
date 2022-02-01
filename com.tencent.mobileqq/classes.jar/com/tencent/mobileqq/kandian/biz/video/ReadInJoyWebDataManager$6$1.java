package com.tencent.mobileqq.kandian.biz.video;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReadInJoyWebDataManager$6$1
  implements HttpWebCgiAsyncTask.Callback
{
  ReadInJoyWebDataManager$6$1(ReadInJoyWebDataManager.6 param6) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    QLog.w("ReadInJoyWebDataManager", 2, Long.toString(Thread.currentThread().getId()));
    if (paramJSONObject != null)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("sendLog result:");
        paramBundle.append(paramJSONObject.toString());
        QLog.w("ReadInJoyWebDataManager", 2, paramBundle.toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      paramBundle = new StringBuilder();
      paramBundle.append("sendLog result Exception :");
      paramBundle.append(paramJSONObject);
      QLog.w("ReadInJoyWebDataManager", 2, paramBundle.toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("ReadInJoyWebDataManager", 2, "sendLog result null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager.6.1
 * JD-Core Version:    0.7.0.1
 */