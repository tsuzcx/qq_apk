package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.os.Handler;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.qphone.base.util.QLog;

class ProfileColorScreenComponent$ColorScreenLoader$1
  implements OnCompositionLoadedListener
{
  ProfileColorScreenComponent$ColorScreenLoader$1(ProfileColorScreenComponent.ColorScreenLoader paramColorScreenLoader) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if ((QLog.isColorLevel()) || (paramLottieComposition == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompositionLoaded: composition= ");
      localStringBuilder.append(paramLottieComposition);
      QLog.d("ProfileColorScreenComponent", 1, localStringBuilder.toString());
    }
    if (paramLottieComposition == null)
    {
      VasMonitorHandler.a(ProfileColorScreenComponent.access$500(this.this$1.this$0), "individual_v2_colorscreen_parse_fail", "0", "", Integer.toString(ProfileColorScreenComponent.ColorScreenLoader.access$600(this.this$1)), null, null, 0.0F, 0.0F);
      paramLottieComposition = new StringBuilder();
      paramLottieComposition.append("id:");
      paramLottieComposition.append(ProfileColorScreenComponent.ColorScreenLoader.access$600(this.this$1));
      VasMonitorDT.a("individual_v2_colorscreen_parse_fail", paramLottieComposition.toString());
      return;
    }
    ProfileColorScreenComponent.ColorScreenLoader.access$702(this.this$1, paramLottieComposition);
    if (ProfileColorScreenComponent.access$800(this.this$1.this$0) != null) {
      ProfileColorScreenComponent.access$800(this.this$1.this$0).postDelayed(this.this$1, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader.1
 * JD-Core Version:    0.7.0.1
 */