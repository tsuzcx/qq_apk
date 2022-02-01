package com.tencent.mtt.abtestsdk.report;

import com.tencent.mtt.abtestsdk.entity.AttaEntity;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ThreadPoolUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AttaReport
{
  private static final String ATTAID_KEY = "attaid";
  public static final String ATTAID_VALUE = "04800015034";
  private static final String ATTA_POST_URL = "https://h.trace.qq.com/kv";
  private static final String TOKEN_KEY = "token";
  public static final String TOKEN_VALUE = "6299336879";
  
  private Map<String, String> createReportData(AttaEntity paramAttaEntity)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (paramAttaEntity != null)
    {
      localConcurrentHashMap.put("attaid", paramAttaEntity.getAttaId());
      localConcurrentHashMap.put("token", paramAttaEntity.getAttaToken());
      localConcurrentHashMap.put("eventcode", paramAttaEntity.getEventcode());
      localConcurrentHashMap.put("guid", paramAttaEntity.getGuid());
      localConcurrentHashMap.put("grayid", paramAttaEntity.getGrayid());
      localConcurrentHashMap.put("platform", paramAttaEntity.getPlatform());
      localConcurrentHashMap.put("bundleid", paramAttaEntity.getBundleid());
      localConcurrentHashMap.put("bundlerversion", paramAttaEntity.getBundlerversion());
      localConcurrentHashMap.put("eventtime", paramAttaEntity.getEventtime());
      localConcurrentHashMap.put("eventpage", paramAttaEntity.getEventpage());
      localConcurrentHashMap.put("osmodel", paramAttaEntity.getOsmodel());
      localConcurrentHashMap.put("osversion", paramAttaEntity.getOsversion());
      localConcurrentHashMap.put("devicebrand", paramAttaEntity.getDevicebrand());
      localConcurrentHashMap.put("resolution", paramAttaEntity.getResolution());
      localConcurrentHashMap.put("language", paramAttaEntity.getLanguage());
      localConcurrentHashMap.put("sdkversion", paramAttaEntity.getSdkversion());
      localConcurrentHashMap.put("channel", paramAttaEntity.getChannel());
      localConcurrentHashMap.put("appid", paramAttaEntity.getAppid());
      localConcurrentHashMap.put("isfirsthint", paramAttaEntity.getIsfirsthint());
      localConcurrentHashMap.put("devicemodel", paramAttaEntity.getDevicemodel());
    }
    return localConcurrentHashMap;
  }
  
  public static AttaReport getInstance()
  {
    return AttaReport.AttaReportHolder.access$000();
  }
  
  public void report(AttaEntity paramAttaEntity)
  {
    if (paramAttaEntity == null) {
      return;
    }
    paramAttaEntity = createReportData(paramAttaEntity);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("atta report params is:");
    localStringBuilder.append(paramAttaEntity.toString());
    ABTestLog.debug(localStringBuilder.toString(), new Object[0]);
    ThreadPoolUtil.execute(new AttaReport.1(this, paramAttaEntity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.report.AttaReport
 * JD-Core Version:    0.7.0.1
 */