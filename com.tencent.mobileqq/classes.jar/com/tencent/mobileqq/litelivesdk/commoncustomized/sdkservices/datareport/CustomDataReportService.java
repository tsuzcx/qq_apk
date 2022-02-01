package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.datareport.QualityReportTask;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.utils.LiveClientTypeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomDataReportService
  implements DataReportInterface
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private static ExecutorService b;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  DataReportInterface.DataReportAdapter jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter;
  private final String jdField_a_of_type_JavaLangString = "DataReportService";
  
  private int a(LoginInfo paramLoginInfo)
  {
    if ((paramLoginInfo != null) && (paramLoginInfo.loginType != null))
    {
      int i = CustomDataReportService.7.a[paramLoginInfo.loginType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return -1;
          }
          return 2;
        }
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  private void a()
  {
    new Thread(new CustomDataReportService.5(this)).start();
  }
  
  private static String b(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.keySet());
    Collections.sort(localArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < localArrayList.size())
    {
      String str1 = (String)localArrayList.get(i);
      String str2 = (String)paramMap.get(str1);
      if (i == localArrayList.size() - 1)
      {
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str2);
      }
      else
      {
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str2);
        localStringBuilder.append("&");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void b()
  {
    BeaconReport.getInstance().getQimei(new CustomDataReportService.6(this));
  }
  
  HashMap<String, String> a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getLoginInfo().getLoginInfo() != null) {
        paramMap.put("uid", String.valueOf(this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getLoginInfo().getLoginInfo().uid));
      }
      paramMap.put("userid", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getLoginInfo().getBusinessUid());
      paramMap.put("genid", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppInfo().getDeviceID());
      paramMap.put("uid_type", String.valueOf(a(this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getLoginInfo().getLoginInfo())));
      paramMap.put("fromid", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppInfo().getFromId());
      paramMap.put("source", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppInfo().getSource());
      paramMap.put("appid", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppInfo().getAppId());
      paramMap.put("appid_anchor", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppInfo().getAppId());
      paramMap.put("client_type", String.valueOf(this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppInfo().getClientType()));
      paramMap.put("appversion", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppVersion());
      if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.isInRoom())
      {
        paramMap.put("appid_anchor", String.valueOf(LiveClientTypeUtil.getAppIdFromClientType(this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAnchorClientType())));
        if (!paramMap.containsKey("anchor")) {
          paramMap.put("anchor", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAnchorId());
        }
        paramMap.put("nowid", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAnchorExplicitId());
        if (!paramMap.containsKey("roomid")) {
          paramMap.put("roomid", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getRoomId());
        }
        if (!paramMap.containsKey("program_id")) {
          paramMap.put("program_id", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getProgramId());
        }
        if (!paramMap.containsKey("room_type")) {
          paramMap.put("room_type", String.valueOf(this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getRoomType()));
        }
        if (!paramMap.containsKey("room_mode")) {
          paramMap.put("room_mode", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getRoomMode());
        }
      }
      else if ((!this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppInfo().isLiteSdk()) && (this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.isRoomAccessorNull()))
      {
        if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.isOutRoomHasRoomInfo())
        {
          paramMap.put("roomid", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getStartLiveRoomId());
          paramMap.put("program_id", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getStartLiveProgramId());
        }
        if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getLoginInfo().getLoginInfo() != null) {
          paramMap.put("anchor", String.valueOf(this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getLoginInfo().getLoginInfo().uid));
        }
      }
      paramMap.put("sdk_version", this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getAppVersion());
      paramMap.put("platform", "Android");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    return localHashMap;
  }
  
  public void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    paramMap.put("page", "quality_page");
    paramMap.put("page_desc", "质量上报页");
    paramMap.put("page_module", "HostQuality");
    paramMap.put("page_module_desc", "中台主播质量");
    paramMap.put("act_type", paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("#");
    ((StringBuilder)localObject).append("quality_page");
    ((StringBuilder)localObject).append("#");
    ((StringBuilder)localObject).append("HostQuality");
    localObject = ((StringBuilder)localObject).toString();
    LogInterface localLogInterface;
    StringBuilder localStringBuilder;
    if (paramString.equals("startLive"))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localLogInterface = this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportAnchorQualityEvent start act_type =");
      localStringBuilder.append(paramString);
      localLogInterface.i("DataReportService", localStringBuilder.toString(), new Object[0]);
    }
    else
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      paramMap.put("timelong", String.valueOf(l));
      localLogInterface = this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter.getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportAnchorQualityEvent act_type =");
      localStringBuilder.append(paramString);
      localStringBuilder.append(";time = ");
      localStringBuilder.append(l);
      localLogInterface.i("DataReportService", localStringBuilder.toString(), new Object[0]);
    }
    paramString = a(paramMap);
    b.submit(new CustomDataReportService.3(this, (String)localObject, paramString, paramBoolean));
  }
  
  public void a(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("act_type");
    String str2 = (String)paramMap.get("page");
    String str3 = (String)paramMap.get("page_module");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("#");
    localStringBuilder.append(str2);
    localStringBuilder.append("#");
    localStringBuilder.append(str3);
    str1 = localStringBuilder.toString();
    paramMap = a(paramMap);
    b.submit(new CustomDataReportService.2(this, str1, paramMap, paramBoolean));
  }
  
  public void b(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    paramMap.put("page", "quality_page");
    paramMap.put("page_desc", "质量上报页");
    paramMap.put("page_module", "audience");
    paramMap.put("page_module_desc", "中台观看质量");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append("quality_page");
    localStringBuilder.append("#");
    localStringBuilder.append("audience");
    paramString = localStringBuilder.toString();
    paramMap = a(paramMap);
    b.submit(new CustomDataReportService.4(this, paramString, paramMap, paramBoolean));
  }
  
  public void clearEventOutput() {}
  
  public void init(DataReportInterface.DataReportAdapter paramDataReportAdapter)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface$DataReportAdapter = paramDataReportAdapter;
    if (jdField_a_of_type_JavaUtilConcurrentExecutorService == null)
    {
      jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(3);
      paramDataReportAdapter.getLog().i("DataReportService", "DataReportService mProductThreadPool is null, create", new Object[0]);
    }
    if (b == null)
    {
      b = Executors.newFixedThreadPool(3);
      paramDataReportAdapter.getLog().i("DataReportService", "DataReportService mQualityThreadPool is null, create", new Object[0]);
    }
  }
  
  public QualityReportTask newAudQualityTask()
  {
    QualityReportTaskImpl localQualityReportTaskImpl = new QualityReportTaskImpl();
    localQualityReportTaskImpl.setDataReportService(this);
    localQualityReportTaskImpl.setQualityType(2);
    return localQualityReportTaskImpl;
  }
  
  public QualityReportTask newQualityTask()
  {
    QualityReportTaskImpl localQualityReportTaskImpl = new QualityReportTaskImpl();
    localQualityReportTaskImpl.setDataReportService(this);
    localQualityReportTaskImpl.setQualityType(1);
    return localQualityReportTaskImpl;
  }
  
  public QualityReportTask newQualityTaskCustom()
  {
    QualityReportTaskImpl localQualityReportTaskImpl = new QualityReportTaskImpl();
    localQualityReportTaskImpl.setDataReportService(this);
    localQualityReportTaskImpl.setQualityType(3);
    return localQualityReportTaskImpl;
  }
  
  public ReportTask newTask()
  {
    ReportTaskImpl localReportTaskImpl = new ReportTaskImpl();
    localReportTaskImpl.setDataReportService(this);
    return localReportTaskImpl;
  }
  
  public void onCreate(Context paramContext)
  {
    a();
  }
  
  public void onDestroy() {}
  
  public void reportEvent(String paramString)
  {
    reportEvent(paramString, true);
  }
  
  public void reportEvent(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap.put("page", paramString1);
      paramMap.put("page_module", paramString2);
      paramMap.put("act_type", paramString3);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("#");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("#");
    localStringBuilder.append(paramString2);
    reportEvent(localStringBuilder.toString(), true, paramMap);
  }
  
  public void reportEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    reportEvent(paramString, true, -1L, -1L, paramMap, paramBoolean, paramBoolean);
  }
  
  public void reportEvent(String paramString, boolean paramBoolean)
  {
    reportEvent(paramString, paramBoolean, null);
  }
  
  public void reportEvent(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramMap = a(paramMap);
    jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new CustomDataReportService.1(this, paramMap, paramString, paramBoolean2));
  }
  
  public void reportEvent(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    reportEvent(paramString, paramBoolean, -1L, -1L, paramMap, false, false);
  }
  
  public void setUserUid(String paramString)
  {
    UserAction.setUserID(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportService
 * JD-Core Version:    0.7.0.1
 */