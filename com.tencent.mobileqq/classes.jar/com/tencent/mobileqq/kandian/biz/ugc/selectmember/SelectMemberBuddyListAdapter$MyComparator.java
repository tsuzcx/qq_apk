package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import java.util.Comparator;

class SelectMemberBuddyListAdapter$MyComparator
  implements Comparator<SelectMemberBuddyListAdapter.FriendHolder>
{
  public int a(SelectMemberBuddyListAdapter.FriendHolder paramFriendHolder)
  {
    if (paramFriendHolder.b != -1) {
      return paramFriendHolder.b;
    }
    Friends localFriends = paramFriendHolder.a;
    int k = OnlineStatusUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
    int j;
    if ((k != 6) && (k != 0)) {
      j = 65536;
    } else {
      j = 131072;
    }
    int i;
    if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
      i = 4096;
    } else if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
      i = 8192;
    } else if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
      i = 12288;
    } else {
      i = 16384;
    }
    if (k != 1) {
      if (k != 2) {
        if ((k != 3) && (k != 4))
        {
          if (k == 7) {
            break label167;
          }
          i = (int)localFriends.getLastLoginType() | i;
        }
      }
    }
    for (;;)
    {
      i |= j;
      break;
      i |= 0x1;
      continue;
      label167:
      i |= 0x3;
      continue;
      i |= 0x2;
    }
    paramFriendHolder.b = i;
    return i;
  }
  
  public int a(SelectMemberBuddyListAdapter.FriendHolder paramFriendHolder1, SelectMemberBuddyListAdapter.FriendHolder paramFriendHolder2)
  {
    return a(paramFriendHolder1) - a(paramFriendHolder2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.SelectMemberBuddyListAdapter.MyComparator
 * JD-Core Version:    0.7.0.1
 */