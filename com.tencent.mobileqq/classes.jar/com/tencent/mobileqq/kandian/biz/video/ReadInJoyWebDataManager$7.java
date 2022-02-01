package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReadInJoyWebDataManager$7
  implements ReadInJoyWebDataManager.HttpFetchBizCallback
{
  ReadInJoyWebDataManager$7(ReadInJoyWebDataManager paramReadInJoyWebDataManager) {}
  
  public void a(JSONObject paramJSONObject)
  {
    ReadInJoyWebDataManager.a(this.a, paramJSONObject.toString());
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("preLoadMsgBox HttpFetchBizCallback jsonRetData result");
      paramJSONObject.append(ReadInJoyWebDataManager.a(this.a));
      QLog.w("ReadInJoyWebDataManager", 2, paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager.7
 * JD-Core Version:    0.7.0.1
 */