package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

final class TroopBarPublishUtils$3
  implements QQPermissionCallback
{
  TroopBarPublishUtils$3(BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      DialogUtil.a(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.3
 * JD-Core Version:    0.7.0.1
 */