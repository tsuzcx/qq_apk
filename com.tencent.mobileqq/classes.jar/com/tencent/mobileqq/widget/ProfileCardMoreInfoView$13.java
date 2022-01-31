package com.tencent.mobileqq.widget;

import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.lang.ref.WeakReference;

class ProfileCardMoreInfoView$13
  implements Runnable
{
  ProfileCardMoreInfoView$13(ProfileCardMoreInfoView paramProfileCardMoreInfoView, WeakReference paramWeakReference) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("showPresentRed", 0);
    if (localSharedPreferences != null)
    {
      boolean bool = localSharedPreferences.getBoolean("showRed", true);
      ThreadManagerV2.getUIHandlerV2().post(new ProfileCardMoreInfoView.13.1(this, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.13
 * JD-Core Version:    0.7.0.1
 */