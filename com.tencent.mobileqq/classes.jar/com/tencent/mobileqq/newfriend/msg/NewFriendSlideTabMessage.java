package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import java.util.ArrayList;

public class NewFriendSlideTabMessage
  extends NewFriendMessage
{
  public ArrayList<ConnectionsTabInfo> a;
  
  public NewFriendSlideTabMessage(ArrayList<ConnectionsTabInfo> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.NewFriendSlideTabMessage
 * JD-Core Version:    0.7.0.1
 */