package com.tencent.mobileqq.profile.musicbox;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awsv;
import bdne;
import com.tencent.common.app.BaseApplicationImpl;

public class ProfileMusicBox$2
  implements Runnable
{
  public ProfileMusicBox$2(awsv paramawsv) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("showMusicBoxRed", 0).edit();
    localEditor.putBoolean("showRed", false);
    bdne.a(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBox.2
 * JD-Core Version:    0.7.0.1
 */