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
  public boolean equalInputText = false;
  public String keyword = "";
  public ArkAioContainerWrapper mArkContainer;
  public LinkedList<ArkMsgAppInfo> mOpenCardAppInfoList = new LinkedList();
  public String meta = "";
  
  public void doOnEvent(int paramInt)
  {
    Object localObject = this.mOpenCardAppInfoList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArkMsgAppInfo localArkMsgAppInfo = (ArkMsgAppInfo)((Iterator)localObject).next();
      if (localArkMsgAppInfo != null) {
        localArkMsgAppInfo.doOnEvent(paramInt);
      }
    }
    localObject = this.mArkContainer;
    if (localObject != null)
    {
      ((ArkAioContainerWrapper)localObject).doOnEvent(paramInt);
      if (paramInt == 2) {
        this.mArkContainer = null;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ArkMsgAppInfo)) {
      return false;
    }
    paramObject = (ArkMsgAppInfo)paramObject;
    return (this.appName.equals(paramObject.appName)) && (this.appPath.equals(paramObject.appPath)) && (this.appView.equals(paramObject.appView)) && (this.keyword.equals(paramObject.keyword)) && (this.equalInputText == paramObject.equalInputText) && (this.meta.equals(paramObject.meta));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo
 * JD-Core Version:    0.7.0.1
 */