package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;

public class MayKnowBannerMessage
  extends NewFriendMessage
{
  public ConnectsExplorationBanner a;
  
  public MayKnowBannerMessage(ConnectsExplorationBanner paramConnectsExplorationBanner)
  {
    this.a = paramConnectsExplorationBanner;
    this.d = paramConnectsExplorationBanner.timestamp;
  }
  
  public String a()
  {
    return this.a.uin;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.MayKnowBannerMessage
 * JD-Core Version:    0.7.0.1
 */