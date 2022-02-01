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
    int k = paramString2.charAt(0);
    int i;
    if (((k >= 65) && (k <= 90)) || ((k >= 97) && (k <= 122)))
    {
      i = 65536;
      if (paramString1.charAt(0) < 'ÿ') {
        break label89;
      }
    }
    label89:
    for (int j = 1;; j = 0)
    {
      return j | k << 8 | i | 0x0;
      if ((k >= 48) && (k <= 57))
      {
        i = 262144;
        break;
      }
      i = 131072;
      break;
    }
  }
  
  public static String a(Friends paramFriends)
  {
    String str = paramFriends.getFriendNick();
    return str + "-" + paramFriends.uin;
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
    int j = 0;
    int i = paramLinkedList.size() - 1;
    if (j <= i)
    {
      int k = (j + i) / 2;
      Groups localGroups = (Groups)paramLinkedList.get(k);
      if (paramGroups.seqid > localGroups.seqid) {
        j = k + 1;
      }
      for (;;)
      {
        break;
        i = k - 1;
      }
    }
    paramLinkedList.add(i + 1, paramGroups);
    return paramLinkedList;
  }
  
  public static void a(Friends paramFriends)
  {
    String str = a(paramFriends);
    paramFriends.mCompareSpell = ChnToSpell.a(str, 1);
    paramFriends.mComparePartInt = a(str, paramFriends.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.utils.FriendSorter
 * JD-Core Version:    0.7.0.1
 */