package com.tencent.qqmini.sdk.report;

import bgpm;
import bgya;
import bgyg;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.List;

public final class SDKMiniProgramLpReportDC04239$12
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bgpm)localIterator.next();
      if ((localObject != null) && (((bgpm)localObject).a() != null))
      {
        MiniAppInfo localMiniAppInfo = ((bgpm)localObject).a();
        if ((localMiniAppInfo.launchParam == null) || (!this.jdField_a_of_type_Boolean) || ((localMiniAppInfo.launchParam.scene != 3009) && (localMiniAppInfo.launchParam.scene != 3010)))
        {
          String str1 = bgyg.a(localMiniAppInfo);
          String str2 = this.jdField_a_of_type_JavaLangString;
          String str3 = this.b;
          int i = ((bgpm)localObject).a();
          if (this.jdField_a_of_type_Boolean) {}
          for (localObject = ((bgpm)localObject).a();; localObject = null)
          {
            bgyg.b(localMiniAppInfo, str1, str2, "page_view", str3, String.valueOf(i), (String)localObject);
            break;
          }
        }
      }
    }
    bgya.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.12
 * JD-Core Version:    0.7.0.1
 */