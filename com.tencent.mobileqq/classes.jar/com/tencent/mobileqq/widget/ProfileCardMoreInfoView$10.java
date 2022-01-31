package com.tencent.mobileqq.widget;

import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;

class ProfileCardMoreInfoView$10
  implements Runnable
{
  ProfileCardMoreInfoView$10(ProfileCardMoreInfoView paramProfileCardMoreInfoView, TextView paramTextView) {}
  
  public void run()
  {
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("showPresentRed", 0).getBoolean("showRed", true);
    ThreadManagerV2.getUIHandlerV2().post(new ProfileCardMoreInfoView.10.1(this, Boolean.valueOf(bool)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.10
 * JD-Core Version:    0.7.0.1
 */