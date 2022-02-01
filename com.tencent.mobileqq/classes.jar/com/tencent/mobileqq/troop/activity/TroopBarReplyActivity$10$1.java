package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class TroopBarReplyActivity$10$1
  implements QQPermissionCallback
{
  TroopBarReplyActivity$10$1(TroopBarReplyActivity.10 param10) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    TroopBarReplyActivity.a(this.a.a, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.10.1
 * JD-Core Version:    0.7.0.1
 */