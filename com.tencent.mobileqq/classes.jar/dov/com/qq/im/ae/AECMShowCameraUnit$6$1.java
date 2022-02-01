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

class AECMShowCameraUnit$6$1
  implements Animator.AnimatorListener
{
  AECMShowCameraUnit$6$1(AECMShowCameraUnit.6 param6) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(1.0F);
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(255);
    AECMShowCameraUnit.a(this.a.this$0).setVisibility(8);
    AEQLog.a(this.a.this$0.b, "MakeFaceSucc -> onAnimationEnd: 设置为蓝色背景");
    AECMShowCameraUnit.a(this.a.this$0).setBackgroundDrawable(this.a.this$0.a().getResources().getDrawable(2130837603));
    AECMShowCameraUnit.a(this.a.this$0).setTextColor(-1);
    AECMShowCameraUnit.a(this.a.this$0).setText(2131690958);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowCameraUnit.a(this.a.this$0).setVisibility(8);
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(0.0F);
    AECMShowCameraUnit.a(this.a.this$0).setTag(Integer.valueOf(1));
    AECMShowCameraUnit.a(this.a.this$0).setClickable(true);
    AEQLog.a(this.a.this$0.b, "MakeFaceSucc -> onAnimationStart: 设置为蓝色背景");
    AECMShowCameraUnit.a(this.a.this$0).setBackgroundDrawable(this.a.this$0.a().getResources().getDrawable(2130837603));
    AECMShowCameraUnit.a(this.a.this$0).setTextColor(-1);
    AECMShowCameraUnit.a(this.a.this$0).setText(2131690958);
    AECMShowCameraUnit.a(this.a.this$0).setVisibility(0);
    AECMShowCameraUnit.a(this.a.this$0).setImageDrawable(this.a.this$0.a().getResources().getDrawable(2130837670));
    AECMShowCameraUnit.a(this.a.this$0).setTag(Integer.valueOf(4));
    AECMShowCameraUnit.a(this.a.this$0).setAlpha(0);
    AECMShowCameraUnit.a(this.a.this$0).setVisibility(0);
    AECMShowCameraUnit.a(this.a.this$0).setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECMShowCameraUnit.6.1
 * JD-Core Version:    0.7.0.1
 */