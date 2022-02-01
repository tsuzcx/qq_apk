package cooperation.vip;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class VasC2SReporter
{
  private static VasC2SReporter jdField_a_of_type_CooperationVipVasC2SReporter = null;
  private final ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static VasC2SReporter a()
  {
    if (jdField_a_of_type_CooperationVipVasC2SReporter == null) {}
    try
    {
      if (jdField_a_of_type_CooperationVipVasC2SReporter == null) {
        jdField_a_of_type_CooperationVipVasC2SReporter = new VasC2SReporter();
      }
      return jdField_a_of_type_CooperationVipVasC2SReporter;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("VasC2SReporter", 1, "reportUrl is empty");
      return;
    }
    ThreadManager.excute(new VasC2SReporter.1(paramString), 128, null, false);
  }
  
  public String a(String paramString)
  {
    String str2 = "";
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = str2;
      if (bool) {
        str1 = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VasC2SReporter", 1, "getC2SReportUrlFromCache key:" + paramString + " url:" + str1 + " isContains:" + bool);
    }
    return str1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(TianShuReportData paramTianShuReportData)
  {
    if (paramTianShuReportData == null) {}
    for (;;)
    {
      return;
      if ((paramTianShuReportData.d == 100) || (paramTianShuReportData.d == 101) || (paramTianShuReportData.d == 117) || (paramTianShuReportData.d == 137) || (paramTianShuReportData.d == 139) || (paramTianShuReportData.d == 141) || (paramTianShuReportData.d == 202))
      {
        String str = "";
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTianShuReportData.g + "_" + paramTianShuReportData.d)) {
          str = a(paramTianShuReportData.g + "_" + paramTianShuReportData.d);
        }
        while (!TextUtils.isEmpty(str))
        {
          a(str);
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTianShuReportData.g)) {
            str = a(paramTianShuReportData.g);
          }
        }
      }
    }
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {}
    for (;;)
    {
      return;
      String str1 = String.valueOf(paramAdItem.iAdId.get());
      paramAdItem = paramAdItem.argList.get().iterator();
      while (paramAdItem.hasNext())
      {
        Object localObject = (TianShuAccess.MapEntry)paramAdItem.next();
        String str2 = ((TianShuAccess.MapEntry)localObject).key.get();
        if ((!TextUtils.isEmpty(str2)) && (str2.contains("thirdPartyReportURLForExposure")))
        {
          localObject = ((TianShuAccess.MapEntry)localObject).value.get();
          str2 = str2.replace("thirdPartyReportURLForExposure", str1);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, localObject);
          if (QLog.isColorLevel()) {
            QLog.i("VasC2SReporter", 1, "cacheC2SReportUrl adId:" + str1 + " key:" + str2 + " url:" + (String)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasC2SReporter
 * JD-Core Version:    0.7.0.1
 */