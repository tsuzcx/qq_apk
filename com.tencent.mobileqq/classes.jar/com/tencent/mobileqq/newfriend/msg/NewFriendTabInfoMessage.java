package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import java.util.ArrayList;

public class NewFriendTabInfoMessage
  extends NewFriendMessage
{
  public ArrayList<ConnectionsTabInfo> a;
  public boolean b = false;
  
  public NewFriendTabInfoMessage(ArrayList<ConnectionsTabInfo> paramArrayList, boolean paramBoolean)
  {
    this.a = paramArrayList;
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.NewFriendTabInfoMessage
 * JD-Core Version:    0.7.0.1
 */