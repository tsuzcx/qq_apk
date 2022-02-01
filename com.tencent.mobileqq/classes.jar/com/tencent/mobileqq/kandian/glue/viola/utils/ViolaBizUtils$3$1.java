package com.tencent.mobileqq.kandian.glue.viola.utils;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ViolaBizUtils$3$1
  implements Runnable
{
  ViolaBizUtils$3$1(ViolaBizUtils.3 param3, JSONObject paramJSONObject, JSONArray paramJSONArray) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject;
      try
      {
        this.a.put("uploadVideoList", this.b);
        this.a.put("errCode", this.this$0.b);
        this.a.put("errMsg", this.this$0.c);
        JSONObject localJSONObject = this.a;
        if (!this.this$0.d) {
          break label300;
        }
        i = 1;
        localJSONObject.put("hasVideoPublished", i);
        RIJQQAppInterfaceUtil.a();
      }
      catch (JSONException localJSONException)
      {
        localObject = ViolaBizUtils.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUploadingVideoInfo onResult, put uploadVideoList error =");
        localStringBuilder.append(QLog.getStackTraceString(localJSONException));
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
      String str;
      if (QLog.isColorLevel())
      {
        str = ViolaBizUtils.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getUploadingVideoInfo, onResult=");
        ((StringBuilder)localObject).append(this.a.toString());
        ((StringBuilder)localObject).append("errCode=");
        ((StringBuilder)localObject).append(this.this$0.b);
        ((StringBuilder)localObject).append("errMsg=");
        ((StringBuilder)localObject).append(this.this$0.c);
        QLog.i(str, 2, ((StringBuilder)localObject).toString());
      }
      if (this.this$0.b != 0)
      {
        str = ViolaBizUtils.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("responseUploadingVideoListerrCode=");
        ((StringBuilder)localObject).append(this.this$0.b);
        ((StringBuilder)localObject).append("errMsg=");
        ((StringBuilder)localObject).append(this.this$0.c);
        QLog.i(str, 1, ((StringBuilder)localObject).toString());
      }
      this.this$0.e.invokeJS(this.this$0.f, this.a);
      return;
      label300:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.3.1
 * JD-Core Version:    0.7.0.1
 */