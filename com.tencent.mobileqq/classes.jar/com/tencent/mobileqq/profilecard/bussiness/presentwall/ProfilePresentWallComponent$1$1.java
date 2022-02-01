package com.tencent.mobileqq.profilecard.bussiness.presentwall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import azov;
import bgsg;
import com.tencent.common.app.BaseApplicationImpl;

public class ProfilePresentWallComponent$1$1
  implements Runnable
{
  public ProfilePresentWallComponent$1$1(azov paramazov) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("showPresentRed", 0).edit();
    localEditor.putBoolean("showRed", false);
    bgsg.a(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent.1.1
 * JD-Core Version:    0.7.0.1
 */