package com.tencent.mobileqq.tribe.takevideo;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class TribePublishLauncher$1
  implements QQPermissionCallback
{
  TribePublishLauncher$1(AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      DialogUtil.a(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.takevideo.TribePublishLauncher.1
 * JD-Core Version:    0.7.0.1
 */