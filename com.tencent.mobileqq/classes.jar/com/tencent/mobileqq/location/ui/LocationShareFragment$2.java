package com.tencent.mobileqq.location.ui;

import android.app.Dialog;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class LocationShareFragment$2
  implements QQPermissionCallback
{
  LocationShareFragment$2(LocationShareFragment paramLocationShareFragment, QBaseActivity paramQBaseActivity, int paramInt1, String paramString, int paramInt2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = DialogUtil.a(this.a);
    if (paramArrayOfString != null) {
      paramArrayOfString.setOnDismissListener(new LocationShareFragment.2.1(this));
    }
    LocationShareRoomManager.a().a(this.b, this.c, this.d, 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationShareFragment.c(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareFragment.2
 * JD-Core Version:    0.7.0.1
 */