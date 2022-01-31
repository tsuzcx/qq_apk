package com.tencent.mobileqq.data;

import com.tencent.mobileqq.leba.LebaUtils;
import com.tencent.mobileqq.leba.UITemplate.BaseUITemplateInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import tencent.im.DynamicFeeds.DynamicFeeds.FeedsItem_Resp;

public class LebaFeedInfo
  extends Entity
{
  public long feedID;
  public int serverUpdateTime;
  public int showFlag = 1;
  public String strFeedCookie;
  public String strTemplatData;
  public int templateId = -1;
  @notColumn
  public BaseUITemplateInfo templateInfo;
  public int uiLoadDayTimestamp;
  public int uiResID = -1;
  
  public static LebaFeedInfo convFeedInfo(DynamicFeeds.FeedsItem_Resp paramFeedsItem_Resp, boolean paramBoolean)
  {
    if (paramFeedsItem_Resp == null) {
      return null;
    }
    LebaFeedInfo localLebaFeedInfo = new LebaFeedInfo();
    localLebaFeedInfo.feedID = paramFeedsItem_Resp.ulFeedID.get();
    localLebaFeedInfo.strTemplatData = paramFeedsItem_Resp.strTemplatData.get();
    localLebaFeedInfo.serverUpdateTime = paramFeedsItem_Resp.uiUpdateTime.get();
    localLebaFeedInfo.uiLoadDayTimestamp = LebaUtils.b(localLebaFeedInfo.serverUpdateTime);
    localLebaFeedInfo.strFeedCookie = paramFeedsItem_Resp.strFeedCookie.get();
    localLebaFeedInfo.uiResID = paramFeedsItem_Resp.uiResID.get();
    localLebaFeedInfo.doParseUIInfo();
    int i;
    if (localLebaFeedInfo.templateInfo != null)
    {
      i = localLebaFeedInfo.templateInfo.a;
      localLebaFeedInfo.templateId = i;
      if ((paramBoolean) || (!isArkFeed(localLebaFeedInfo))) {
        break label127;
      }
    }
    label127:
    for (localLebaFeedInfo.showFlag = -1;; localLebaFeedInfo.showFlag = 1)
    {
      return localLebaFeedInfo;
      i = -1;
      break;
    }
  }
  
  public static boolean isArkFeed(LebaFeedInfo paramLebaFeedInfo)
  {
    if ((paramLebaFeedInfo == null) || (paramLebaFeedInfo.templateInfo == null)) {}
    while (paramLebaFeedInfo.templateInfo.a != 3) {
      return false;
    }
    return true;
  }
  
  public void doParseUIInfo()
  {
    this.templateInfo = BaseUITemplateInfo.a(this.strTemplatData);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof LebaFeedInfo)) && (this.feedID == ((LebaFeedInfo)paramObject).feedID);
  }
  
  public int hashCode()
  {
    return String.valueOf(this.feedID).hashCode();
  }
  
  public String toString()
  {
    return this.feedID + "|" + this.serverUpdateTime + "|" + this.uiLoadDayTimestamp + "|" + this.showFlag + "|" + this.templateId + "|" + this.uiResID + "\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.LebaFeedInfo
 * JD-Core Version:    0.7.0.1
 */