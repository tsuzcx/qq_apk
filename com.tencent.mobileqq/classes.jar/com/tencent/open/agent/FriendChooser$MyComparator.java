package com.tencent.open.agent;

import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class FriendChooser$MyComparator
  implements Comparator<Friend>
{
  protected FriendChooser$MyComparator(FriendChooser paramFriendChooser) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return paramFriend1.j.compareToIgnoreCase(paramFriend2.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.MyComparator
 * JD-Core Version:    0.7.0.1
 */