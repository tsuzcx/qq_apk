package com.tencent.mobileqq.profilecard.bussiness.presentwall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;

class ProfilePresentWallComponent$1$1
  implements Runnable
{
  ProfilePresentWallComponent$1$1(ProfilePresentWallComponent.1 param1) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("showPresentRed", 0).edit();
    localEditor.putBoolean("showRed", false);
    SharedPreUtils.a(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent.1.1
 * JD-Core Version:    0.7.0.1
 */