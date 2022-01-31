package com.tencent.qqmini.sdk.report;

import beos;
import beyo;
import beyu;
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
      Object localObject = (beos)localIterator.next();
      if ((localObject != null) && (((beos)localObject).a() != null))
      {
        MiniAppInfo localMiniAppInfo = ((beos)localObject).a();
        if ((localMiniAppInfo.launchParam == null) || (!this.jdField_a_of_type_Boolean) || ((localMiniAppInfo.launchParam.a != 3009) && (localMiniAppInfo.launchParam.a != 3010)))
        {
          String str1 = beyu.a(localMiniAppInfo);
          String str2 = this.jdField_a_of_type_JavaLangString;
          String str3 = this.b;
          int i = ((beos)localObject).a();
          if (this.jdField_a_of_type_Boolean) {}
          for (localObject = ((beos)localObject).a();; localObject = null)
          {
            beyu.b(localMiniAppInfo, str1, str2, "page_view", str3, String.valueOf(i), (String)localObject);
            break;
          }
        }
      }
    }
    beyo.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.12
 * JD-Core Version:    0.7.0.1
 */