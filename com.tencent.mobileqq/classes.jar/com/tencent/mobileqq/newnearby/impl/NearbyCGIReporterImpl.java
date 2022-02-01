package com.tencent.mobileqq.newnearby.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import okhttp3.Callback;
import org.json.JSONObject;

public class NearbyCGIReporterImpl
  implements INearbyCGIReporter
{
  private static final String REPORT_CONTENT_TYPE = "application/x-www-form-urlencoded";
  private static final String REPORT_HOST = "https://ias.nearby.qq.com/";
  private static final String REPORT_URL = "https://ias.nearby.qq.com/cgi-bin/nearby/report";
  private static final String TAG = "NearbyCGIReporter";
  private Callback mCallback = new NearbyCGIReporterImpl.1(this);
  
  public void reportByJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    ThreadManager.excute(new NearbyCGIReporterImpl.2(this, paramJSONObject), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyCGIReporterImpl
 * JD-Core Version:    0.7.0.1
 */