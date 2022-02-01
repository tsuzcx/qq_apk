import android.os.Bundle;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.AdReportManager.1;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class ohu
{
  private static final Vector<String> jdField_a_of_type_JavaUtilVector = new Vector();
  private static volatile ohu jdField_a_of_type_Ohu;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private ohu()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(371);
    if (localAladdinConfig.getIntegerFromString("ad_new_report", 0) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (localAladdinConfig.getIntegerFromString("soft_new_report", 0) != 1) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ohu a()
  {
    if (jdField_a_of_type_Ohu == null) {}
    try
    {
      if (jdField_a_of_type_Ohu == null) {
        jdField_a_of_type_Ohu = new ohu();
      }
      return jdField_a_of_type_Ohu;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdReportManager", 2, paramString1 + paramString2);
    }
  }
  
  private void a(String paramString, ohw paramohw, ReportAction paramReportAction)
  {
    Bundle localBundle1 = new Bundle();
    HttpUtil.addCookie(localBundle1);
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = paramohw.a().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle2.putString(str, (String)paramohw.a().get(str));
    }
    a("action:" + paramReportAction.getValue() + ",reportUrl:" + paramString + ",reportData:", paramohw.a());
    localBundle2.putInt("PostBodyType", 1);
    paramString = HttpUtil.postUrlForByteWithJson(BaseApplication.getContext(), paramString, paramohw.a(), localBundle1);
    if (paramString == null)
    {
      a("action:" + paramReportAction.getValue() + ",report result: ", "bytes null");
      return;
    }
    paramString = new String(paramString);
    a("action:" + paramReportAction.getValue() + ",report result:", paramString);
  }
  
  private void a(String paramString1, ohw paramohw, String paramString2, ReportAction paramReportAction)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilVector.contains(paramString2)) {
        return;
      }
      a(paramString1, paramohw, paramReportAction);
      jdField_a_of_type_JavaUtilVector.add(paramString2);
      return;
    }
  }
  
  private static boolean b(ufw paramufw)
  {
    return (paramufw.b()) && (oik.a(paramufw) == ReportAction.EXPOSE) && (paramufw.a() == ExposeMode.LOOSE);
  }
  
  private static boolean b(ufw paramufw, String paramString)
  {
    return (b(paramufw)) && (jdField_a_of_type_JavaUtilVector.contains(paramString));
  }
  
  public void a(ufw paramufw)
  {
    if (paramufw == null) {}
    String str;
    do
    {
      return;
      str = oik.b(paramufw);
    } while (b(paramufw, str));
    ThreadManager.post(new AdReportManager.1(this, paramufw, str), 5, null, true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean d()
  {
    return (!this.jdField_a_of_type_Boolean) || (!this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohu
 * JD-Core Version:    0.7.0.1
 */