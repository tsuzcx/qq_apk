package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

final class TroopBarPublishUtils$2
  implements QQPermissionCallback
{
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.b, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a(TroopBarUtils.a(this.b, AppConstants.SDCARD_IMG_SAVE, 1001));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.2
 * JD-Core Version:    0.7.0.1
 */