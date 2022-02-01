package com.tencent.mtt.abtestsdk.report;

import com.tencent.mtt.abtestsdk.utils.OkHttpHelper;
import java.util.Map;

class AttaReport$1
  implements Runnable
{
  AttaReport$1(AttaReport paramAttaReport, Map paramMap) {}
  
  public void run()
  {
    OkHttpHelper.getsInstance().postRequestWithFormBody("https://h.trace.qq.com/kv", this.val$params, 0, new AttaReport.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.report.AttaReport.1
 * JD-Core Version:    0.7.0.1
 */