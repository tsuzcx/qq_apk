package cooperation.vip.ad;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;

public class TianshuReportUtils
{
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      try
      {
        TianShuReportData localTianShuReportData = new TianShuReportData();
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject == null) {
          break label249;
        }
        localObject = ((AppRuntime)localObject).getAccount();
        long l = System.currentTimeMillis() / 1000L;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("_");
        localStringBuilder.append(l);
        localTianShuReportData.b = localStringBuilder.toString();
        localTianShuReportData.d = paramInt;
        localTianShuReportData.jdField_e_of_type_Int = 1;
        localTianShuReportData.g = paramString1;
        localTianShuReportData.jdField_a_of_type_Long = l;
        localTianShuReportData.jdField_a_of_type_Int = 1;
        localTianShuReportData.jdField_e_of_type_JavaLangString = paramString3;
        localTianShuReportData.f = paramString4;
        localTianShuReportData.i = "";
        localTianShuReportData.l = paramString2;
        TianShuManager.getInstance().report(localTianShuReportData);
        if (QLog.isDevelopLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("report appId:");
          paramString2.append(paramString3);
          paramString2.append(" adId:");
          paramString2.append(paramString1);
          paramString2.append(" actionId:");
          paramString2.append(paramInt);
          QLog.i("TianshuReportUtils", 4, paramString2.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("report exception");
        paramString2.append(paramString1.toString());
        QLog.e("TianshuReportUtils", 1, paramString2.toString());
      }
      return;
      label249:
      Object localObject = "";
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramInt, paramString, "", "tianshu.47", "");
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    a(paramInt, paramString1, paramString2, "tianshu.31", "");
  }
  
  public static void b(String paramString, int paramInt)
  {
    a(paramInt, paramString, "", "tianshu.185", "");
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    a(paramInt, paramString1, paramString2, "tianshu.150", "");
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    a(paramInt, paramString1, paramString2, "tianshu.32", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuReportUtils
 * JD-Core Version:    0.7.0.1
 */