package com.tencent.mobileqq.newnearby.impl;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class NearbyCGIReporterImpl$1
  implements Callback
{
  NearbyCGIReporterImpl$1(NearbyCGIReporterImpl paramNearbyCGIReporterImpl) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("NearbyCGIReporter", 4, paramIOException, new Object[0]);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if ((paramResponse != null) && (paramResponse.code() == 200)) {
      QLog.i("NearbyCGIReporter", 4, "data report success.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyCGIReporterImpl.1
 * JD-Core Version:    0.7.0.1
 */