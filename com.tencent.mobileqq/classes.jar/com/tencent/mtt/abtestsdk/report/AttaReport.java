package com.tencent.mtt.abtestsdk.report;

import com.tencent.mtt.abtestsdk.entity.AttaEntity;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ThreadPoolUtil;
import java.util.HashMap;
import java.util.Map;

public class AttaReport
{
  private static final String ATTAID_KEY = "attaid";
  public static final String ATTAID_VALUE = "04800015034";
  private static final String ATTA_POST_URL = "https://h.trace.qq.com/kv";
  private static final String TOKEN_KEY = "token";
  public static final String TOKEN_VALUE = "6299336879";
  
  private Map<String, String> createReportData(AttaEntity paramAttaEntity)
  {
    HashMap localHashMap = new HashMap();
    if (paramAttaEntity != null)
    {
      localHashMap.put("attaid", paramAttaEntity.getAttaId());
      localHashMap.put("token", paramAttaEntity.getAttaToken());
      localHashMap.put("eventcode", paramAttaEntity.getEventcode());
      localHashMap.put("guid", paramAttaEntity.getGuid());
      localHashMap.put("grayid", paramAttaEntity.getGrayid());
      localHashMap.put("platform", paramAttaEntity.getPlatform());
      localHashMap.put("bundleid", paramAttaEntity.getBundleid());
      localHashMap.put("bundlerversion", paramAttaEntity.getBundlerversion());
      localHashMap.put("eventtime", paramAttaEntity.getEventtime());
      localHashMap.put("eventpage", paramAttaEntity.getEventpage());
      localHashMap.put("osmodel", paramAttaEntity.getOsmodel());
      localHashMap.put("osversion", paramAttaEntity.getOsversion());
      localHashMap.put("devicebrand", paramAttaEntity.getDevicebrand());
      localHashMap.put("resolution", paramAttaEntity.getResolution());
      localHashMap.put("language", paramAttaEntity.getLanguage());
      localHashMap.put("sdkversion", paramAttaEntity.getSdkversion());
      localHashMap.put("channel", paramAttaEntity.getChannel());
      localHashMap.put("appid", paramAttaEntity.getAppid());
      localHashMap.put("isfirsthint", paramAttaEntity.getIsfirsthint());
      localHashMap.put("devicemodel", paramAttaEntity.getDevicemodel());
    }
    return localHashMap;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.report.AttaReport
 * JD-Core Version:    0.7.0.1
 */