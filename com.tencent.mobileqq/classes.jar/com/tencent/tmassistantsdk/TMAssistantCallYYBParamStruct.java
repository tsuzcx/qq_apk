package com.tencent.tmassistantsdk;

import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TMAssistantCallYYBParamStruct
{
  public static final String SOURCE_KEY = TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID;
  public String SNGAppId = "";
  public String actionFlag = "0";
  public String channelId = "";
  public String outerCallReportData;
  public String recommendId;
  public String source;
  public String taskApkId = "";
  public String taskAppId = "";
  public String taskPackageName = "";
  public int taskVersion = 0;
  public Map<String, Long> timePointMap = new ConcurrentHashMap();
  public String uin = "";
  public String uinType = "";
  public String via = "";
  
  public TMAssistantCallYYBParamStruct() {}
  
  public TMAssistantCallYYBParamStruct(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.SNGAppId = paramString1;
    this.taskAppId = paramString2;
    this.taskApkId = paramString3;
    this.taskVersion = paramInt;
    this.via = paramString4;
    this.taskPackageName = paramString5;
    this.uin = paramString6;
    this.uinType = paramString7;
    this.channelId = paramString8;
    this.actionFlag = paramString9;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("SNGAppId = ");
    localStringBuilder2.append(this.SNGAppId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",taskAppId = ");
    localStringBuilder2.append(this.taskAppId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",taskApkId = ");
    localStringBuilder2.append(this.taskApkId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",taskVersion = ");
    localStringBuilder2.append(this.taskVersion);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",via = ");
    localStringBuilder2.append(this.via);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",taskPackageName = ");
    localStringBuilder2.append(this.taskPackageName);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",uin = ");
    localStringBuilder2.append(this.uin);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",uinType = ");
    localStringBuilder2.append(this.uinType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",channelId = ");
    localStringBuilder2.append(this.channelId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",actionFlag = ");
    localStringBuilder2.append(this.actionFlag);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct
 * JD-Core Version:    0.7.0.1
 */