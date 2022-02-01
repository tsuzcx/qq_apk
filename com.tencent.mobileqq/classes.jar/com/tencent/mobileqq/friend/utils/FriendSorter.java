package com.tencent.mobileqq.friend.utils;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;
import java.util.LinkedList;

public class FriendSorter
{
  public static Comparator<Groups> a = new FriendSorter.1();
  
  public static int a(String paramString1, String paramString2)
  {
    int j = 0;
    int k = paramString2.charAt(0);
    int i;
    if (((k >= 65) && (k <= 90)) || ((k >= 97) && (k <= 122))) {
      i = 65536;
    } else if ((k >= 48) && (k <= 57)) {
      i = 262144;
    } else {
      i = 131072;
    }
    if (paramString1.charAt(0) >= 'ÿ') {
      j = 1;
    }
    return k << 8 | i | 0x0 | j;
  }
  
  public static String a(Friends paramFriends)
  {
    String str = paramFriends.getFriendNick();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("-");
    localStringBuilder.append(paramFriends.uin);
    return localStringBuilder.toString();
  }
  
  public static LinkedList<Groups> a(LinkedList<Groups> paramLinkedList, Groups paramGroups)
  {
    if (paramLinkedList == null) {
      return null;
    }
    paramLinkedList = new LinkedList(paramLinkedList);
    if (paramLinkedList.size() == 0)
    {
      paramLinkedList.add(paramGroups);
      return paramLinkedList;
    }
    int i = 0;
    int j = paramLinkedList.size() - 1;
    while (i <= j)
    {
      int k = (i + j) / 2;
      Groups localGroups = (Groups)paramLinkedList.get(k);
      if (paramGroups.seqid > localGroups.seqid) {
        i = k + 1;
      } else {
        j = k - 1;
      }
    }
    paramLinkedList.add(j + 1, paramGroups);
    return paramLinkedList;
  }
  
  public static void b(Friends paramFriends)
  {
    String str = a(paramFriends);
    paramFriends.mCompareSpell = ChnToSpell.b(str, 1);
    paramFriends.mComparePartInt = a(str, paramFriends.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.utils.FriendSorter
 * JD-Core Version:    0.7.0.1
 */