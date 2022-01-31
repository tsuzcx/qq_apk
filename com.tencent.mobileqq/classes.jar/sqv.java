import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class sqv
  implements Runnable
{
  sqv(squ paramsqu, LottieComposition paramLottieComposition) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a instanceof ProfileBaseView))
    {
      ((ProfileBaseView)this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a).a = 1.0F;
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "update medal anim alpha [2]");
      }
    }
    View localView1;
    label77:
    View localView3;
    label83:
    View localView4;
    label90:
    View localView5;
    if (this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a == null)
    {
      localView2 = null;
      if (localView2 != null) {
        break label395;
      }
      localView1 = null;
      if (localView2 != null) {
        break label405;
      }
      localView3 = null;
      if (localView2 != null) {
        break label415;
      }
      localView4 = null;
      if (localView2 != null) {
        break label426;
      }
      localView5 = null;
      label97:
      if (localView2 != null) {
        break label437;
      }
    }
    label395:
    label405:
    label415:
    label426:
    label437:
    for (View localView2 = null;; localView2 = localView2.findViewById(2131372527))
    {
      if ((localView5 != null) && (localView2 != null) && (localView1 != null) && (localView3 != null) && (localView4 != null))
      {
        localView1.setAlpha(0.0F);
        localView3.setAlpha(0.0F);
        localView4.setAlpha(0.0F);
        ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("txtAlpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(700.0F / 1260.0F, 0.0F), Keyframe.ofFloat(820.0F / 1260.0F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe("redAlpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(1060.0F / 1260.0F, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
        localValueAnimator.setDuration(1260.0F);
        localValueAnimator.setRepeatCount(0);
        localValueAnimator.addUpdateListener(new sqw(this, localView1, localView3, localView4, localView5, localView2));
        localValueAnimator.start();
      }
      this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFitFullScreenXY();
      this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.forbiddenLayer();
      this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setComposition(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition);
      this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setRepeatCount(0);
      this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setProgress(0.0F);
      this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      return;
      localView2 = (View)this.jdField_a_of_type_Squ.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a.get("map_key_medal_container");
      break;
      localView1 = localView2.findViewById(2131372526);
      break label77;
      localView3 = localView2.findViewById(2131372529);
      break label83;
      localView4 = localView2.findViewById(2131372528);
      break label90;
      localView5 = localView2.findViewById(2131372524);
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sqv
 * JD-Core Version:    0.7.0.1
 */