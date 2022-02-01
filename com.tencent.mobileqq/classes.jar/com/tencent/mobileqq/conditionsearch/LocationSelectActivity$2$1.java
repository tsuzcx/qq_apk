package com.tencent.mobileqq.conditionsearch;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class LocationSelectActivity$2$1
  implements QQPermissionCallback
{
  LocationSelectActivity$2$1(LocationSelectActivity.2 param2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.this$0, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationSelectActivity.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity.2.1
 * JD-Core Version:    0.7.0.1
 */