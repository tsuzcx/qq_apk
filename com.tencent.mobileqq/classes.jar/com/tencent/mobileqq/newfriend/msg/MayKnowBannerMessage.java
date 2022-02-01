package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;

public class MayKnowBannerMessage
  extends NewFriendMessage
{
  public ConnectsExplorationBanner a;
  
  public MayKnowBannerMessage(ConnectsExplorationBanner paramConnectsExplorationBanner)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationBanner = paramConnectsExplorationBanner;
    this.jdField_a_of_type_Long = paramConnectsExplorationBanner.timestamp;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectsExplorationBanner.uin;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.MayKnowBannerMessage
 * JD-Core Version:    0.7.0.1
 */