import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.av.VideoController;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanelSoundWaveView;
import java.lang.ref.SoftReference;

public class mho
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  QavPanel jdField_a_of_type_ComTencentAvUiQavPanel = null;
  SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference = null;
  mhs jdField_a_of_type_Mhs = null;
  mht jdField_a_of_type_Mht = null;
  View jdField_b_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  View jdField_c_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_c_of_type_AndroidViewAnimationAnimation = null;
  View jdField_d_of_type_AndroidViewView = null;
  Animation jdField_d_of_type_AndroidViewAnimationAnimation = null;
  View jdField_e_of_type_AndroidViewView = null;
  Animation jdField_e_of_type_AndroidViewAnimationAnimation = null;
  View jdField_f_of_type_AndroidViewView = null;
  Animation jdField_f_of_type_AndroidViewAnimationAnimation = null;
  View jdField_g_of_type_AndroidViewView = null;
  Animation jdField_g_of_type_AndroidViewAnimationAnimation = null;
  Animation h = null;
  Animation i = null;
  Animation j = null;
  Animation k = null;
  Animation l = null;
  Animation m = null;
  
  public mho(Context paramContext, VideoController paramVideoController, int paramInt, QavPanel paramQavPanel, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = paramQavPanel;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_c_of_type_AndroidViewView = paramView3;
    this.jdField_d_of_type_AndroidViewView = paramView4;
    this.jdField_e_of_type_AndroidViewView = paramView5;
    this.jdField_g_of_type_AndroidViewView = paramView6;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    paramVideoController = new DecelerateInterpolator();
    paramQavPanel = new AccelerateInterpolator();
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(620);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setInterpolator(paramVideoController);
    this.h = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    this.h.setDuration(620);
    this.h.setInterpolator(paramQavPanel);
    paramInt = muf.a(paramContext);
    if (paramInt <= 320) {
      paramInt = paramContext.getResources().getDimensionPixelSize(2131297568) + paramContext.getResources().getDimensionPixelSize(2131297564);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -paramInt, 1, 0.0F);
      this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(620);
      this.jdField_d_of_type_AndroidViewAnimationAnimation.setInterpolator(paramVideoController);
      this.i = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 0, -paramInt);
      this.i.setDuration(620);
      this.i.setInterpolator(paramQavPanel);
      this.jdField_e_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_e_of_type_AndroidViewAnimationAnimation.setDuration(620);
      this.j = new AlphaAnimation(1.0F, 0.0F);
      this.j.setDuration(620);
      this.jdField_f_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      this.jdField_f_of_type_AndroidViewAnimationAnimation.setDuration(620);
      this.jdField_f_of_type_AndroidViewAnimationAnimation.setInterpolator(paramVideoController);
      this.k = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
      this.k.setDuration(620);
      this.k.setInterpolator(paramQavPanel);
      this.l = new AlphaAnimation(0.0F, 0.0F);
      this.l.setDuration(620);
      this.jdField_g_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 0.0F);
      this.jdField_g_of_type_AndroidViewAnimationAnimation.setDuration(620);
      this.m = new AlphaAnimation(0.0F, 0.0F);
      this.m.setDuration(620);
      this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new mhp(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new mhq(this);
      this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new mhr(this);
      return;
      if (paramInt <= 480) {
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297569) + paramContext.getResources().getDimensionPixelSize(2131297565);
      } else {
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297571) + paramContext.getResources().getDimensionPixelSize(2131297567);
      }
    }
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(mhs parammhs)
  {
    this.jdField_a_of_type_Mhs = parammhs;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().aq) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.jdField_f_of_type_AndroidViewAnimationAnimation == null) || (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)) {
      if (this.jdField_a_of_type_Mhs != null)
      {
        this.jdField_a_of_type_Mhs.a();
        this.jdField_a_of_type_Mhs.b();
      }
    }
    do
    {
      return;
      this.jdField_f_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
    } while (this.jdField_g_of_type_AndroidViewView == null);
    this.jdField_g_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  public void a(mht parammht)
  {
    this.jdField_a_of_type_Mht = parammht;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ar) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.k == null))
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().aq = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().ar = false;
      }
      if (this.jdField_a_of_type_Mht != null)
      {
        this.jdField_a_of_type_Mht.a();
        this.jdField_a_of_type_Mht.b();
      }
      return;
    }
    parammht = this.k;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel.getVisibility() != 0) {
      parammht = this.l;
    }
    parammht.setAnimationListener(this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(parammht);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel.a() != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a().startAnimation(this.m);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.h);
    }
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.i);
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_c_of_type_AndroidViewView.startAnimation(this.i);
    }
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.j);
    }
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.startAnimation(this.j);
    }
    if ((this.jdField_g_of_type_AndroidViewView != null) && (this.jdField_g_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_g_of_type_AndroidViewView.startAnimation(this.j);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().ar = true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_c_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_c_of_type_AndroidViewAnimationAnimation.cancel();
    }
    if (this.jdField_d_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_d_of_type_AndroidViewAnimationAnimation.cancel();
    }
    if (this.jdField_e_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_e_of_type_AndroidViewAnimationAnimation.cancel();
    }
    if (this.jdField_f_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_f_of_type_AndroidViewAnimationAnimation.cancel();
    }
    if (this.jdField_g_of_type_AndroidViewAnimationAnimation != null) {
      this.jdField_g_of_type_AndroidViewAnimationAnimation.cancel();
    }
    if (this.h != null) {
      this.h.cancel();
    }
    if (this.i != null) {
      this.i.cancel();
    }
    if (this.j != null) {
      this.j.cancel();
    }
    if (this.k != null) {
      this.k.cancel();
    }
    if (this.l != null) {
      this.l.cancel();
    }
    if (this.m != null) {
      this.m.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_d_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_e_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_f_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_g_of_type_AndroidViewAnimationAnimation = null;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.jdField_a_of_type_Mhs = null;
    this.jdField_a_of_type_Mht = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_g_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mho
 * JD-Core Version:    0.7.0.1
 */