package com.tencent.mobileqq.profile.musicbox;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import auxa;
import bbkb;
import com.tencent.common.app.BaseApplicationImpl;

public class ProfileMusicBox$2
  implements Runnable
{
  public ProfileMusicBox$2(auxa paramauxa) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("showMusicBoxRed", 0).edit();
    localEditor.putBoolean("showRed", false);
    bbkb.a(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBox.2
 * JD-Core Version:    0.7.0.1
 */