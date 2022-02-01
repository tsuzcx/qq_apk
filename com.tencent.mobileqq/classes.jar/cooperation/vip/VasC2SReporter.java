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
  private static VasC2SReporter jdField_a_of_type_CooperationVipVasC2SReporter;
  private final ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static VasC2SReporter a()
  {
    if (jdField_a_of_type_CooperationVipVasC2SReporter == null) {
      try
      {
        if (jdField_a_of_type_CooperationVipVasC2SReporter == null) {
          jdField_a_of_type_CooperationVipVasC2SReporter = new VasC2SReporter();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationVipVasC2SReporter;
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
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (bool)) {
      str = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    } else {
      str = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getC2SReportUrlFromCache key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" url:");
      localStringBuilder.append(str);
      localStringBuilder.append(" isContains:");
      localStringBuilder.append(bool);
      QLog.i("VasC2SReporter", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(TianShuReportData paramTianShuReportData)
  {
    if (paramTianShuReportData == null) {
      return;
    }
    if ((paramTianShuReportData.d == 100) || (paramTianShuReportData.d == 101) || (paramTianShuReportData.d == 117) || (paramTianShuReportData.d == 137) || (paramTianShuReportData.d == 139) || (paramTianShuReportData.d == 141) || (paramTianShuReportData.d == 202))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTianShuReportData.g);
      localStringBuilder.append("_");
      localStringBuilder.append(paramTianShuReportData.d);
      if (((ConcurrentHashMap)localObject).containsKey(localStringBuilder.toString()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramTianShuReportData.g);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramTianShuReportData.d);
        paramTianShuReportData = a(((StringBuilder)localObject).toString());
      }
      else if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTianShuReportData.g))
      {
        paramTianShuReportData = a(paramTianShuReportData.g);
      }
      else
      {
        paramTianShuReportData = "";
      }
      if (!TextUtils.isEmpty(paramTianShuReportData)) {
        a(paramTianShuReportData);
      }
    }
  }
  
  public void a(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {
      return;
    }
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cacheC2SReportUrl adId:");
          localStringBuilder.append(str1);
          localStringBuilder.append(" key:");
          localStringBuilder.append(str2);
          localStringBuilder.append(" url:");
          localStringBuilder.append((String)localObject);
          QLog.i("VasC2SReporter", 1, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.VasC2SReporter
 * JD-Core Version:    0.7.0.1
 */