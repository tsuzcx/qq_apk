package com.tencent.qqmini.sdk.report;

import besl;
import bexz;
import beya;
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
        bexz.a(false);
        long l = System.currentTimeMillis();
        Iterator localIterator = bexz.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (beya)((Map.Entry)localObject).getValue();
          if ((((beya)localObject).jdField_d_of_type_Int == 0) && (l - ((beya)localObject).jdField_d_of_type_Long > bexz.jdField_a_of_type_Long)) {
            bexz.a((beya)localObject);
          }
          if (((beya)localObject).jdField_d_of_type_Int == 0) {
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            bexz.b();
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        besl.d("MiniAppReportManager2", "", localThrowable);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppReportManager2.2
 * JD-Core Version:    0.7.0.1
 */