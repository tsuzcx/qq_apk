package com.tencent.mobileqq.flashshow.report.datong;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

final class FSDaTongLoginReporter$2
  implements Runnable
{
  FSDaTongLoginReporter$2(HashMap paramHashMap) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.i("FSDaTongLoginReporter", 1, "schemaLoginReport  attrs == null");
      return;
    }
    if (FSDaTongLoginReporter.b((HashMap)localObject)) {
      return;
    }
    localObject = new FSDTParamBuilder().a();
    FSDaTongLoginReporter.a(this.a, (Map)localObject);
    FSDaTongLoginReporter.b(this.a, (Map)localObject);
    VideoReport.reportEvent("ks_login", (Map)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.datong.FSDaTongLoginReporter.2
 * JD-Core Version:    0.7.0.1
 */