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
      if (paramFriendItemInfo1.e > paramFriendItemInfo2.e) {
        return -1;
      }
      if (paramFriendItemInfo1.e < paramFriendItemInfo2.e) {
        return 1;
      }
      if (paramFriendItemInfo1.jdField_a_of_type_Float > paramFriendItemInfo2.jdField_a_of_type_Float) {
        return -1;
      }
      if (paramFriendItemInfo1.jdField_a_of_type_Float < paramFriendItemInfo2.jdField_a_of_type_Float) {
        return 1;
      }
      if (paramFriendItemInfo1.jdField_a_of_type_Long > paramFriendItemInfo2.jdField_a_of_type_Long) {
        return -1;
      }
      if (paramFriendItemInfo1.jdField_a_of_type_Long < paramFriendItemInfo2.jdField_a_of_type_Long) {
        return 1;
      }
      if (paramFriendItemInfo1.c > paramFriendItemInfo2.c) {
        return -1;
      }
      if (paramFriendItemInfo1.c < paramFriendItemInfo2.c) {
        return 1;
      }
      if (paramFriendItemInfo1.d > paramFriendItemInfo2.d) {
        return -1;
      }
      if (paramFriendItemInfo1.d < paramFriendItemInfo2.d) {
        return 1;
      }
      return 0;
    }
    if (i == 2)
    {
      if (paramFriendItemInfo1.jdField_a_of_type_Long > paramFriendItemInfo2.jdField_a_of_type_Long) {
        return -1;
      }
      if (paramFriendItemInfo1.jdField_a_of_type_Long < paramFriendItemInfo2.jdField_a_of_type_Long) {
        return 1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.FriendSortComparator
 * JD-Core Version:    0.7.0.1
 */