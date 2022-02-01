package com.tencent.mobileqq.kandian.biz.debug;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyDropFrameHelper$2
  implements Runnable
{
  ReadInJoyDropFrameHelper$2(ReadInJoyDropFrameHelper paramReadInJoyDropFrameHelper, String paramString, double paramDouble) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = ReadInJoyDropFrameHelper.b(this.this$0);
      localJSONObject.put("channelId", this.a);
      localJSONObject.put("fluency", this.b);
      PublicAccountReportUtils.a(RIJQQAppInterfaceUtil.a(), "", "0X8009EFE", "0X8009EFE", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.2
 * JD-Core Version:    0.7.0.1
 */