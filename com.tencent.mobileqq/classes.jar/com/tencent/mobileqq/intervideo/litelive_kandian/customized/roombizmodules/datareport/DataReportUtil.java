package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataReportUtil
{
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<String, String> paramMap)
  {
    try
    {
      Object localObject = BizEngineMgr.getInstance().getLiveEngine();
      if (localObject != null)
      {
        DataReportInterface localDataReportInterface = (DataReportInterface)BizEngineMgr.getInstance().getLiveEngine().getService(DataReportInterface.class);
        if (localDataReportInterface != null)
        {
          localObject = new RealDataReportTask();
          ((RealDataReportTask)localObject).setDataReportService(localDataReportInterface);
          ((RealDataReportTask)localObject).setPage(paramString1).setModule(paramString3).setActType(paramString5).setPageDesc(paramString2).setModuleDesc(paramString4).setActTypeDesc(paramString6);
          if (paramMap != null)
          {
            paramString1 = paramMap.keySet().iterator();
            while (paramString1.hasNext())
            {
              paramString2 = (String)paramString1.next();
              ((RealDataReportTask)localObject).addKeyValue(paramString2, (String)paramMap.get(paramString2));
            }
          }
          ((RealDataReportTask)localObject).send();
          return;
        }
        QLog.e("DataReportUtil", 1, "DataReportInterface null");
        return;
      }
      QLog.e("DataReportUtil", 1, "getLiveEngine null");
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<String, String> paramMap)
  {
    try
    {
      Object localObject = BizEngineMgr.getInstance().getLiveEngine();
      if (localObject != null)
      {
        localObject = (DataReportInterface)BizEngineMgr.getInstance().getLiveEngine().getService(DataReportInterface.class);
        if (localObject != null)
        {
          localObject = ((DataReportInterface)localObject).newTask();
          ((ReportTask)localObject).setPage(paramString1).setModule(paramString3).setActType(paramString5).setPageDesc(paramString2).setModuleDesc(paramString4).setActTypeDesc(paramString6);
          if (paramMap != null)
          {
            paramString1 = paramMap.keySet().iterator();
            while (paramString1.hasNext())
            {
              paramString2 = (String)paramString1.next();
              ((ReportTask)localObject).addKeyValue(paramString2, (String)paramMap.get(paramString2));
            }
          }
          ((ReportTask)localObject).send();
          return;
        }
        QLog.e("DataReportUtil", 1, "DataReportInterface null");
        return;
      }
      QLog.e("DataReportUtil", 1, "getLiveEngine null");
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.DataReportUtil
 * JD-Core Version:    0.7.0.1
 */