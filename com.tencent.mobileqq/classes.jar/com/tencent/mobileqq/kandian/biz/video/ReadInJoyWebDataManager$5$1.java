package com.tencent.mobileqq.kandian.biz.video;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebDataManager$5$1
  implements HttpWebCgiAsyncTask.Callback
{
  ReadInJoyWebDataManager$5$1(ReadInJoyWebDataManager.5 param5) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      this.a.this$0.a(this.a.b, Integer.toString(ReadInJoyWebDataManager.b));
      try
      {
        if ((this.a.c != null) && ((this.a.c instanceof ReadInJoyWebDataManager.HttpFetchBizCallback))) {
          this.a.c.a(paramJSONObject);
        }
        paramBundle = paramJSONObject.toString();
        ReadInJoyWebDataManager.a(this.a.this$0, this.a.b, paramBundle);
        if (this.a.d != null)
        {
          this.a.d.put("data", paramBundle);
          this.a.this$0.a(this.a.a, this.a.d.toString(), "", this.a.d);
        }
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doSendRequestWithExtraHeader:storeParams putData JSONException :");
          localStringBuilder.append(paramBundle);
          QLog.w("ReadInJoyWebDataManager", 2, localStringBuilder.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("doSendRequestWithExtraHeader:return result :");
        paramBundle.append(paramJSONObject);
        QLog.w("ReadInJoyWebDataManager", 2, paramBundle.toString());
      }
    }
    else
    {
      this.a.this$0.a(this.a.b, Integer.toString(ReadInJoyWebDataManager.a));
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:return result null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager.5.1
 * JD-Core Version:    0.7.0.1
 */