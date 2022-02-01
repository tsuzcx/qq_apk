package com.tencent.mobileqq.friend.utils;

import com.tencent.mobileqq.data.Groups;
import java.util.Comparator;

final class FriendSorter$1
  implements Comparator<Groups>
{
  public int a(Groups paramGroups1, Groups paramGroups2)
  {
    return paramGroups1.seqid - paramGroups2.seqid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.utils.FriendSorter.1
 * JD-Core Version:    0.7.0.1
 */