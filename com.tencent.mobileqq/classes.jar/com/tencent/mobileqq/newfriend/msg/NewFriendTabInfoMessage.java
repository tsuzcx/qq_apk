package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import java.util.ArrayList;

public class NewFriendTabInfoMessage
  extends NewFriendMessage
{
  public ArrayList<ConnectionsTabInfo> a;
  public boolean a;
  
  public NewFriendTabInfoMessage(ArrayList<ConnectionsTabInfo> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.NewFriendTabInfoMessage
 * JD-Core Version:    0.7.0.1
 */