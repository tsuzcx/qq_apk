package com.tencent.mobileqq.troop.createNewTroop;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import java.util.Comparator;

class ContactListAdapter$MyComparator
  implements Comparator<ContactListAdapter.FriendHolder>
{
  public int a(ContactListAdapter.FriendHolder paramFriendHolder)
  {
    if (paramFriendHolder.jdField_a_of_type_Int != -1) {
      return paramFriendHolder.jdField_a_of_type_Int;
    }
    Friends localFriends = paramFriendHolder.jdField_a_of_type_ComTencentMobileqqDataFriends;
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
    paramFriendHolder.jdField_a_of_type_Int = i;
    return i;
  }
  
  public int a(ContactListAdapter.FriendHolder paramFriendHolder1, ContactListAdapter.FriendHolder paramFriendHolder2)
  {
    return a(paramFriendHolder1) - a(paramFriendHolder2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.MyComparator
 * JD-Core Version:    0.7.0.1
 */