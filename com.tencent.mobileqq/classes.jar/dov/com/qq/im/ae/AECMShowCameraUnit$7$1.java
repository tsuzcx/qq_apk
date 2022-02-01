package dov.com.qq.im.ae;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;
import dov.com.qq.im.ae.util.AEQLog;

class AECMShowCameraUnit$7$1
  implements Animator.AnimatorListener
{
  AECMShowCameraUnit$7$1(AECMShowCameraUnit.7 param7) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(1.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowCameraUnit.a(this.a.this$0).setTag(Integer.valueOf(2));
    AECMShowCameraUnit.a(this.a.this$0).setClickable(true);
    AEQLog.a(this.a.this$0.b, "MakeFaceFail -> animationStart: 设置为蓝色背景");
    AECMShowCameraUnit.a(this.a.this$0).setBackgroundDrawable(this.a.this$0.a().getResources().getDrawable(2130837603));
    AECMShowCameraUnit.a(this.a.this$0).setTextColor(-1);
    AECMShowCameraUnit.a(this.a.this$0).setText(2131690960);
    AECMShowCameraUnit.a(this.a.this$0).setVisibility(0);
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(0.0F);
    if (this.a.a == 4) {
      AECMShowCameraUnit.a(this.a.this$0).a(2, this.a.this$0.a().getResources().getString(2131689685));
    }
    for (;;)
    {
      AECMShowCameraUnit.a(this.a.this$0).setVisibility(8);
      AECMShowCameraUnit.a(this.a.this$0).setVisibility(8);
      return;
      AECMShowCameraUnit.a(this.a.this$0).a(2, this.a.this$0.a().getResources().getString(2131690964));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.7.1
 * JD-Core Version:    0.7.0.1
 */