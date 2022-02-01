package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;

public class MessageForNearbyRecommenderTips
  extends ChatMessage
{
  public boolean readFlag;
  public String strBrief = "";
  public long uRecommendTime;
  
  protected void doParse()
  {
    Object localObject;
    try
    {
      MessageForNearbyRecommenderTips.NearbyRecommenderInfo localNearbyRecommenderInfo = (MessageForNearbyRecommenderTips.NearbyRecommenderInfo)MessagePkgUtils.a(this.msgData);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject != null)
    {
      this.uRecommendTime = localObject.uRecommendTime;
      this.readFlag = localObject.readFlag;
      this.strBrief = localObject.strBrief;
    }
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    MessageForNearbyRecommenderTips.NearbyRecommenderInfo localNearbyRecommenderInfo = new MessageForNearbyRecommenderTips.NearbyRecommenderInfo();
    localNearbyRecommenderInfo.uRecommendTime = this.uRecommendTime;
    localNearbyRecommenderInfo.readFlag = this.readFlag;
    localNearbyRecommenderInfo.strBrief = this.strBrief;
    try
    {
      this.msgData = MessagePkgUtils.a(localNearbyRecommenderInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyRecommenderTips
 * JD-Core Version:    0.7.0.1
 */