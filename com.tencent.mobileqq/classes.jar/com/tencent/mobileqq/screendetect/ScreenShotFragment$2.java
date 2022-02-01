package com.tencent.mobileqq.screendetect;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class ScreenShotFragment$2
  implements QQPermissionCallback
{
  ScreenShotFragment$2(ScreenShotFragment paramScreenShotFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(ScreenShotFragment.a(this.a), this.a.getString(2131698910));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ScreenShotFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.2
 * JD-Core Version:    0.7.0.1
 */