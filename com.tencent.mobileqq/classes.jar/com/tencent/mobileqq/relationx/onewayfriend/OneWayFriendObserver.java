package com.tencent.mobileqq.relationx.onewayfriend;

import com.tencent.mobileqq.app.BusinessObserver;

public class OneWayFriendObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, OneWayFriendResult paramOneWayFriendResult) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean, (OneWayFriendResult)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendObserver
 * JD-Core Version:    0.7.0.1
 */