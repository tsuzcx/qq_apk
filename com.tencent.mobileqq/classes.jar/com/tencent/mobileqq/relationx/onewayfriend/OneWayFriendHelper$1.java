package com.tencent.mobileqq.relationx.onewayfriend;

import android.text.TextUtils;

class OneWayFriendHelper$1
  extends OneWayFriendObserver
{
  OneWayFriendHelper$1(OneWayFriendHelper paramOneWayFriendHelper) {}
  
  public void a(boolean paramBoolean, OneWayFriendResult paramOneWayFriendResult)
  {
    if (TextUtils.equals(OneWayFriendHelper.a(this.a), String.valueOf(paramOneWayFriendResult.jdField_a_of_type_Long))) {
      if ((!paramBoolean) || (!paramOneWayFriendResult.jdField_a_of_type_Boolean)) {
        break label49;
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      OneWayFriendHelper.a(this.a, OneWayFriendHelper.a(this.a), paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */