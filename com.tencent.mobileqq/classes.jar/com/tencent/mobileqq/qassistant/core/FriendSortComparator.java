package com.tencent.mobileqq.qassistant.core;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import java.util.Comparator;

public class FriendSortComparator
  implements Comparator<FriendItemInfo>
{
  private int a;
  
  public FriendSortComparator(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(@NonNull FriendItemInfo paramFriendItemInfo1, @NonNull FriendItemInfo paramFriendItemInfo2)
  {
    int i = this.a;
    if (i == 1)
    {
      if (paramFriendItemInfo1.l > paramFriendItemInfo2.l) {
        return -1;
      }
      if (paramFriendItemInfo1.l < paramFriendItemInfo2.l) {
        return 1;
      }
      if (paramFriendItemInfo1.h > paramFriendItemInfo2.h) {
        return -1;
      }
      if (paramFriendItemInfo1.h < paramFriendItemInfo2.h) {
        return 1;
      }
      if (paramFriendItemInfo1.g > paramFriendItemInfo2.g) {
        return -1;
      }
      if (paramFriendItemInfo1.g < paramFriendItemInfo2.g) {
        return 1;
      }
      if (paramFriendItemInfo1.j > paramFriendItemInfo2.j) {
        return -1;
      }
      if (paramFriendItemInfo1.j < paramFriendItemInfo2.j) {
        return 1;
      }
      if (paramFriendItemInfo1.k > paramFriendItemInfo2.k) {
        return -1;
      }
      if (paramFriendItemInfo1.k < paramFriendItemInfo2.k) {
        return 1;
      }
      return 0;
    }
    if (i == 2)
    {
      if (paramFriendItemInfo1.g > paramFriendItemInfo2.g) {
        return -1;
      }
      if (paramFriendItemInfo1.g < paramFriendItemInfo2.g) {
        return 1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.FriendSortComparator
 * JD-Core Version:    0.7.0.1
 */