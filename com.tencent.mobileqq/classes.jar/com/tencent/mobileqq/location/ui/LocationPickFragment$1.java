package com.tencent.mobileqq.location.ui;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.QQPermissionCallback;

class LocationPickFragment$1
  implements QQPermissionCallback
{
  LocationPickFragment$1(LocationPickFragment paramLocationPickFragment, QBaseActivity paramQBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a).setOnDismissListener(new LocationPickFragment.1.1(this));
    paramArrayOfString = this.a.getIntent();
    paramArrayOfInt = paramArrayOfString.getStringExtra("uin");
    paramInt = paramArrayOfString.getIntExtra("uintype", -1);
    LocationShareRoomManager.a().a(paramInt, paramArrayOfInt, LocationHandler.a().b(), 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationPickFragment.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.1
 * JD-Core Version:    0.7.0.1
 */