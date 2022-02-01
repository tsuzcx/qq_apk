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
    if (paramCall != null) {
      paramCall = new String(paramCall.bytes(), "utf-8").trim();
    } else {
      paramCall = null;
    }
    paramResponse = new StringBuilder();
    paramResponse.append("res from net: ");
    paramResponse.append(paramCall);
    paramResponse.append("  atta report finished");
    ABTestLog.debug(paramResponse.toString(), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.report.AttaReport.1.1
 * JD-Core Version:    0.7.0.1
 */