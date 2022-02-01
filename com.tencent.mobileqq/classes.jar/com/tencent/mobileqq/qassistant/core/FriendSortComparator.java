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
    if (this.a == 1) {
      if (paramFriendItemInfo1.e <= paramFriendItemInfo2.e) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return -1;
              if (paramFriendItemInfo1.e < paramFriendItemInfo2.e) {
                return 1;
              }
            } while (paramFriendItemInfo1.jdField_a_of_type_Float > paramFriendItemInfo2.jdField_a_of_type_Float);
            if (paramFriendItemInfo1.jdField_a_of_type_Float < paramFriendItemInfo2.jdField_a_of_type_Float) {
              return 1;
            }
          } while (paramFriendItemInfo1.jdField_a_of_type_Long > paramFriendItemInfo2.jdField_a_of_type_Long);
          if (paramFriendItemInfo1.jdField_a_of_type_Long < paramFriendItemInfo2.jdField_a_of_type_Long) {
            return 1;
          }
        } while (paramFriendItemInfo1.c > paramFriendItemInfo2.c);
        if (paramFriendItemInfo1.c < paramFriendItemInfo2.c) {
          return 1;
        }
      } while (paramFriendItemInfo1.d > paramFriendItemInfo2.d);
      if (paramFriendItemInfo1.d < paramFriendItemInfo2.d) {
        return 1;
      }
      return 0;
      if (this.a != 2) {
        break;
      }
    } while (paramFriendItemInfo1.jdField_a_of_type_Long > paramFriendItemInfo2.jdField_a_of_type_Long);
    if (paramFriendItemInfo1.jdField_a_of_type_Long < paramFriendItemInfo2.jdField_a_of_type_Long) {
      return 1;
    }
    return 0;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.FriendSortComparator
 * JD-Core Version:    0.7.0.1
 */