package com.tencent.qqmini.sdk.report;

import bgxl;
import bgxm;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class MiniAppReportManager2$2
  implements Runnable
{
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        bgxl.a(false);
        long l = System.currentTimeMillis();
        Iterator localIterator = bgxl.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (bgxm)((Map.Entry)localObject).getValue();
          if ((((bgxm)localObject).jdField_d_of_type_Int == 0) && (l - ((bgxm)localObject).jdField_d_of_type_Long > bgxl.jdField_a_of_type_Long)) {
            bgxl.a((bgxm)localObject);
          }
          if (((bgxm)localObject).jdField_d_of_type_Int == 0) {
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            bgxl.b();
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("MiniAppReportManager2", "", localThrowable);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppReportManager2.2
 * JD-Core Version:    0.7.0.1
 */