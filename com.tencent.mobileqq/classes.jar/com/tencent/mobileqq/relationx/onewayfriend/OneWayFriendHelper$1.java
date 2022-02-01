package com.tencent.mobileqq.relationx.onewayfriend;

import android.text.TextUtils;

class OneWayFriendHelper$1
  extends OneWayFriendObserver
{
  OneWayFriendHelper$1(OneWayFriendHelper paramOneWayFriendHelper) {}
  
  public void a(boolean paramBoolean, OneWayFriendResult paramOneWayFriendResult)
  {
    if (TextUtils.equals(OneWayFriendHelper.a(this.a), String.valueOf(paramOneWayFriendResult.a)))
    {
      if ((paramBoolean) && (paramOneWayFriendResult.b)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramOneWayFriendResult = this.a;
      OneWayFriendHelper.a(paramOneWayFriendResult, OneWayFriendHelper.a(paramOneWayFriendResult), paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */