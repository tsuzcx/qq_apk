package com.tencent.mobileqq.nearby.report;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class TurtleReportCenter$1
  implements Callback
{
  TurtleReportCenter$1(TurtleReportCenter paramTurtleReportCenter) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("TurtleReportCenter", 4, paramIOException, new Object[0]);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if ((paramResponse != null) && (paramResponse.code() == 200)) {
      QLog.i("TurtleReportCenter", 4, "data report success.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.TurtleReportCenter.1
 * JD-Core Version:    0.7.0.1
 */