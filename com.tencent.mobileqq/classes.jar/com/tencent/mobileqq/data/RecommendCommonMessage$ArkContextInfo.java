package com.tencent.mobileqq.data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class RecommendCommonMessage$ArkContextInfo
{
  public String appName;
  public String context = "";
  public LinkedList contextAppInfoList = new LinkedList();
  public int contextMatchType;
  public boolean equalInputText;
  public String keyword = "";
  public String meta;
  public String rawMeta;
  public LinkedHashMap rawSemantic = new LinkedHashMap();
  public LinkedHashMap semantic = new LinkedHashMap();
  
  public RecommendCommonMessage.ArkMsgAppInfo getAppInfoByPosition(int paramInt)
  {
    Iterator localIterator = this.contextAppInfoList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)localIterator.next();
      int j = localArkMsgAppInfo.getArkCardSize();
      if (paramInt == i) {
        return localArkMsgAppInfo;
      }
      if (paramInt < i + j) {
        return localArkMsgAppInfo.getAppInfoByPosition(paramInt - i);
      }
      i += j;
    }
    return null;
  }
  
  public int getArkCardSize()
  {
    Iterator localIterator = this.contextAppInfoList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)localIterator.next();
      if (localArkMsgAppInfo == null) {
        break label45;
      }
      i = localArkMsgAppInfo.getArkCardSize() + i;
    }
    label45:
    for (;;)
    {
      break;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo
 * JD-Core Version:    0.7.0.1
 */