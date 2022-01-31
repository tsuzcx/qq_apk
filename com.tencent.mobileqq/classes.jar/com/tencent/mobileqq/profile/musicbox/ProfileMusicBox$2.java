package com.tencent.mobileqq.profile.musicbox;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awom;
import bdiv;
import com.tencent.common.app.BaseApplicationImpl;

public class ProfileMusicBox$2
  implements Runnable
{
  public ProfileMusicBox$2(awom paramawom) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("showMusicBoxRed", 0).edit();
    localEditor.putBoolean("showRed", false);
    bdiv.a(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBox.2
 * JD-Core Version:    0.7.0.1
 */