package com.tencent.mobileqq.now.roport;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class ReportCenter$1
  implements Callback
{
  ReportCenter$1(ReportCenter paramReportCenter) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("ReportCenter", 4, paramIOException, new Object[0]);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if ((paramResponse != null) && (paramResponse.code() == 200)) {
      QLog.i("ReportCenter", 4, "data report success.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.roport.ReportCenter.1
 * JD-Core Version:    0.7.0.1
 */