package com.tencent.mtt.abtestsdk.report;

import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

class AttaReport$1$1
  implements Callback
{
  AttaReport$1$1(AttaReport.1 param1) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    ABTestLog.warn(paramIOException.getMessage(), new Object[0]);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    paramCall = paramResponse.body();
    if (paramCall != null) {}
    for (paramCall = new String(paramCall.bytes(), "utf-8").trim();; paramCall = null)
    {
      ABTestLog.debug("res from net: " + paramCall + "  atta report finished", new Object[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.report.AttaReport.1.1
 * JD-Core Version:    0.7.0.1
 */