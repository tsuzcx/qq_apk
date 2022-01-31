package com.tencent.mobileqq.profile.musicbox;

import android.content.SharedPreferences;
import android.os.Handler;
import atyz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class ProfileMusicBox$1
  implements Runnable
{
  public ProfileMusicBox$1(atyz paramatyz) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("showMusicBoxRed", 0);
    atyz.a(this.this$0, localSharedPreferences.getBoolean("showRed", true));
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBox.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBox.1
 * JD-Core Version:    0.7.0.1
 */