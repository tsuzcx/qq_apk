package com.tencent.mtt.abtestsdk.report;

import com.tencent.mtt.abtestsdk.entity.AttaEntity;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.OkHttpClient.Builder;

public class AttaReport
{
  private static final String TAG = "ttaReport";
  private String attId = "04800015034";
  private String attToken = "6299336879";
  private final OkHttpClient.Builder builder = new OkHttpClient.Builder();
  
  private Map<String, String> createReportData(AttaEntity paramAttaEntity)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("attaid", this.attId);
    localHashMap.put("token", this.attToken);
    if (paramAttaEntity != null)
    {
      localHashMap.put("eventcode", paramAttaEntity.eventcode);
      localHashMap.put("guid", paramAttaEntity.guid);
      localHashMap.put("grayid", paramAttaEntity.grayid);
      localHashMap.put("platform", paramAttaEntity.platform);
      localHashMap.put("bundleid", paramAttaEntity.bundleid);
      localHashMap.put("bundlerversion", paramAttaEntity.bundlerversion);
      localHashMap.put("eventtime", paramAttaEntity.eventtime);
      localHashMap.put("eventpage", paramAttaEntity.eventpage);
      localHashMap.put("osmodel", paramAttaEntity.osmodel);
      localHashMap.put("osversion", paramAttaEntity.osversion);
      localHashMap.put("devicebrand", paramAttaEntity.devicebrand);
      localHashMap.put("resolution", paramAttaEntity.resolution);
      localHashMap.put("language", paramAttaEntity.language);
      localHashMap.put("sdkversion", paramAttaEntity.sdkversion);
      localHashMap.put("channel", paramAttaEntity.channel);
      localHashMap.put("appid", paramAttaEntity.appid);
      localHashMap.put("isfirsthint", paramAttaEntity.isfirsthint);
      localHashMap.put("devicemodel", paramAttaEntity.devicemodel);
    }
    return localHashMap;
  }
  
  public static AttaReport getInstance()
  {
    return AttaReport.AttaReportHolder.access$100();
  }
  
  public void report(AttaEntity paramAttaEntity)
  {
    if (paramAttaEntity == null) {
      return;
    }
    paramAttaEntity = createReportData(paramAttaEntity);
    ABTestLog.debug("atta report params is:" + paramAttaEntity.toString(), new Object[0]);
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    localExecutorService.execute(new AttaReport.1(this, paramAttaEntity));
    localExecutorService.shutdown();
  }
  
  public void setAttId(String paramString)
  {
    this.attId = paramString;
  }
  
  public void setAttToken(String paramString)
  {
    this.attToken = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.report.AttaReport
 * JD-Core Version:    0.7.0.1
 */