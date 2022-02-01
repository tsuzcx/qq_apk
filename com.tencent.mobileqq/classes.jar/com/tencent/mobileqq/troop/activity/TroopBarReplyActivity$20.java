package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class TroopBarReplyActivity$20
  implements QQPermissionCallback
{
  TroopBarReplyActivity$20(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity.20
 * JD-Core Version:    0.7.0.1
 */