package com.tencent.mobileqq.data;

import agyv;
import java.util.Iterator;
import java.util.LinkedList;

public class RecommendCommonMessage$ArkMsgAppInfo
{
  public String appName = "";
  public String appPath = "";
  public String appVer = "0.0.0.1";
  public String appView = "";
  public boolean equalInputText;
  public String keyword = "";
  public agyv mArkContainer;
  public LinkedList<ArkMsgAppInfo> mOpenCardAppInfoList = new LinkedList();
  public String meta = "";
  
  public void doOnEvent(int paramInt)
  {
    Iterator localIterator = this.mOpenCardAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      ArkMsgAppInfo localArkMsgAppInfo = (ArkMsgAppInfo)localIterator.next();
      if (localArkMsgAppInfo != null) {
        localArkMsgAppInfo.doOnEvent(paramInt);
      }
    }
    if (this.mArkContainer != null)
    {
      this.mArkContainer.doOnEvent(paramInt);
      if (paramInt == 2) {
        this.mArkContainer = null;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ArkMsgAppInfo)) {
        return false;
      }
      paramObject = (ArkMsgAppInfo)paramObject;
    } while ((this.appName.equals(paramObject.appName)) && (this.appPath.equals(paramObject.appPath)) && (this.appView.equals(paramObject.appView)) && (this.keyword.equals(paramObject.keyword)) && (this.equalInputText == paramObject.equalInputText) && (this.meta.equals(paramObject.meta)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo
 * JD-Core Version:    0.7.0.1
 */