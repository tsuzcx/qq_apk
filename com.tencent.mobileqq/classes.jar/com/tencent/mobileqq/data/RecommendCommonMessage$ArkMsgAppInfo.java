package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
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
  public ArkAioContainerWrapper mArkContainer;
  public LinkedList mOpenCardAppInfoList = new LinkedList();
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
  
  public ArkMsgAppInfo getAppInfoByPosition(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    Iterator localIterator = this.mOpenCardAppInfoList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ArkMsgAppInfo localArkMsgAppInfo = (ArkMsgAppInfo)localIterator.next();
      int j = localArkMsgAppInfo.getArkCardSize();
      if (paramInt == i + j) {
        return localArkMsgAppInfo;
      }
      if (paramInt < i + j) {
        return localArkMsgAppInfo.getAppInfoByPosition(paramInt - i - 1);
      }
      i += j;
    }
    return null;
  }
  
  public int getArkCardSize()
  {
    Iterator localIterator = this.mOpenCardAppInfoList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ArkMsgAppInfo localArkMsgAppInfo = (ArkMsgAppInfo)localIterator.next();
      if (localArkMsgAppInfo == null) {
        break label47;
      }
      i = localArkMsgAppInfo.getArkCardSize() + i;
    }
    label47:
    for (;;)
    {
      break;
      return i + 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo
 * JD-Core Version:    0.7.0.1
 */