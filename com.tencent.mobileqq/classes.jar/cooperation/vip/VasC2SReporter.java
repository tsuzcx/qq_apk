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
  private static VasC2SReporter b;
  private final ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  
  public static VasC2SReporter a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new VasC2SReporter();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void b(String paramString)
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
    boolean bool = this.a.containsKey(paramString);
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (bool)) {
      str = (String)this.a.get(paramString);
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
  
  public void a(TianShuReportData paramTianShuReportData)
  {
    if (paramTianShuReportData == null) {
      return;
    }
    if ((paramTianShuReportData.p == 100) || (paramTianShuReportData.p == 101) || (paramTianShuReportData.p == 117) || (paramTianShuReportData.p == 137) || (paramTianShuReportData.p == 139) || (paramTianShuReportData.p == 141) || (paramTianShuReportData.p == 202))
    {
      Object localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTianShuReportData.h);
      localStringBuilder.append("_");
      localStringBuilder.append(paramTianShuReportData.p);
      if (((ConcurrentHashMap)localObject).containsKey(localStringBuilder.toString()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramTianShuReportData.h);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramTianShuReportData.p);
        paramTianShuReportData = a(((StringBuilder)localObject).toString());
      }
      else if (this.a.containsKey(paramTianShuReportData.h))
      {
        paramTianShuReportData = a(paramTianShuReportData.h);
      }
      else
      {
        paramTianShuReportData = "";
      }
      if (!TextUtils.isEmpty(paramTianShuReportData)) {
        b(paramTianShuReportData);
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
        this.a.put(str2, localObject);
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
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.VasC2SReporter
 * JD-Core Version:    0.7.0.1
 */