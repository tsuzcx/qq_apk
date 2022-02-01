package dov.com.qq.im.ae.gif;

import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AEGifTipsPopupPart
  extends VideoStoryBasePart
{
  private static List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "Xiaomi_MI 4C" });
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131689827), HardCodeUtil.a(2131689828), HardCodeUtil.a(2131689829) };
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private boolean jdField_b_of_type_Boolean;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private boolean jdField_c_of_type_Boolean;
  
  private String a()
  {
    int i = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    int j = jdField_a_of_type_ArrayOfJavaLangString.length;
    return jdField_a_of_type_ArrayOfJavaLangString[(i % j)];
  }
  
  private void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 15.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(new AEGifTipsPopupPart.2(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  private void a(Runnable paramRunnable)
  {
    QLog.d("AEGifTipsPopupPart", 4, "###  showup tips");
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator(3.0F));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.5F, 1, 0.0F, 0, this.jdField_b_of_type_AndroidViewView.getY() + this.jdField_b_of_type_AndroidViewView.getHeight() / 2 - this.jdField_a_of_type_AndroidViewView.getY(), 1, 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator(3.0F));
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setAnimationListener(new AEGifTipsPopupPart.3(this, paramRunnable));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a()) {}
    label145:
    for (;;)
    {
      return;
      this.jdField_c_of_type_Boolean = false;
      QLog.d("AEGifTipsPopupPart", 4, "###  show tips, random = " + paramBoolean1);
      if (this.jdField_b_of_type_Boolean)
      {
        if (paramBoolean1) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
        }
        for (;;)
        {
          if ((a(this.jdField_a_of_type_AndroidViewAnimationAnimation)) || (a(this.jdField_b_of_type_AndroidViewAnimationAnimation))) {
            break label145;
          }
          if (a(this.jdField_c_of_type_AndroidViewAnimationAnimation))
          {
            this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
            this.jdField_c_of_type_AndroidViewAnimationAnimation.cancel();
            this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
          }
          if (this.jdField_a_of_type_AndroidViewView == null) {
            break;
          }
          if (!paramBoolean2) {
            break label147;
          }
          a(new AEGifTipsPopupPart.1(this));
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
        }
      }
    }
    label147:
    a();
  }
  
  private static boolean a()
  {
    String str = Build.MANUFACTURER + "_" + Build.MODEL;
    return jdField_a_of_type_JavaUtilList.contains(str);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private String b()
  {
    return jdField_a_of_type_ArrayOfJavaLangString[0];
  }
  
  private void b()
  {
    QLog.d("AEGifTipsPopupPart", 4, "###  hide tips");
    this.jdField_c_of_type_Boolean = true;
    if (a(this.jdField_a_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    }
    if (a(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0);
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F);
    localScaleAnimation.setDuration(300L);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator(3.0F));
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.5F, 1, 0.0F, 0, this.jdField_b_of_type_AndroidViewView.getY() + this.jdField_b_of_type_AndroidViewView.getHeight() / 2 - this.jdField_a_of_type_AndroidViewView.getY());
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator(3.0F));
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setAnimationListener(new AEGifTipsPopupPart.4(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
  
  private boolean b()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (AECameraPrefsUtil.a().a("has_enter_aio_gif", false, 0)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    AECameraPrefsUtil.a().a("has_enter_aio_gif", true, 0);
  }
  
  private void d()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while ((a()) || (a(this.jdField_a_of_type_AndroidViewAnimationAnimation)) || (a(this.jdField_b_of_type_AndroidViewAnimationAnimation))) {
      return;
    }
    boolean bool = b();
    QLog.d("AEGifTipsPopupPart", 4, "###  showIfFirstTimeEnter， first = " + bool);
    if (bool)
    {
      a(false, false);
      c();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    if (a(this.jdField_a_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    }
    if (a(this.jdField_b_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    }
    if (a(this.jdField_c_of_type_AndroidViewAnimationAnimation))
    {
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.cancel();
      this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
    }
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  public void initView()
  {
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2131367155);
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131367926);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367927));
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
  }
  
  public void onActivityResume()
  {
    d();
    super.onActivityResume();
  }
  
  public void onDestroy()
  {
    e();
    super.onDestroy();
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGifTipsPopupPart
 * JD-Core Version:    0.7.0.1
 */