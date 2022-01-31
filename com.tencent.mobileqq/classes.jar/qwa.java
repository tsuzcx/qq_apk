import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class qwa
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new qwd(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = true;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public qwa(Activity paramActivity, AppRuntime paramAppRuntime, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.d = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.e = paramBoolean2;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378749));
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramView1, paramView2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  @TargetApi(11)
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideofeedsUserGuideController", 2, "hide user guide");
    }
    b();
    this.jdField_a_of_type_AndroidOsHandler.post(new VideofeedsUserGuideController.1(this));
  }
  
  @TargetApi(11)
  public void a(VideoInfo paramVideoInfo)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = true;
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) || (this.c) || (this.e));
      i = bhvh.K(this.jdField_a_of_type_MqqAppAppRuntime);
    } while (i >= 3);
    bhvh.C(this.jdField_a_of_type_MqqAppAppRuntime, i + 1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideofeedsUserGuideController", 2, "show user guide");
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378756);
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {
      localTextView.setText(ajyc.a(2131716161));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      }
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null) {
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      }
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new qwb(this));
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new qwc(this));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideofeedsUserGuideController.4(this), 300L);
      return;
      localTextView.setText(ajyc.a(2131716160));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  @TargetApi(11)
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().setAnimationListener(null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        Iterator localIterator = this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations().iterator();
        while (localIterator.hasNext())
        {
          Animator localAnimator = (Animator)localIterator.next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwa
 * JD-Core Version:    0.7.0.1
 */