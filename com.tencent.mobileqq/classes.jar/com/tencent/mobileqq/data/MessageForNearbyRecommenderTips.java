package com.tencent.mobileqq.data;

import amrf;

public class MessageForNearbyRecommenderTips
  extends ChatMessage
{
  public boolean readFlag;
  public String strBrief = "";
  public long uRecommendTime;
  
  protected void doParse()
  {
    try
    {
      MessageForNearbyRecommenderTips.NearbyRecommenderInfo localNearbyRecommenderInfo = (MessageForNearbyRecommenderTips.NearbyRecommenderInfo)amrf.a(this.msgData);
      if (localNearbyRecommenderInfo != null)
      {
        this.uRecommendTime = localNearbyRecommenderInfo.uRecommendTime;
        this.readFlag = localNearbyRecommenderInfo.readFlag;
        this.strBrief = localNearbyRecommenderInfo.strBrief;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
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
      this.msgData = amrf.a(localNearbyRecommenderInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyRecommenderTips
 * JD-Core Version:    0.7.0.1
 */