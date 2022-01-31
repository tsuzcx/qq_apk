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

public class lwx
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  QavPanel jdField_a_of_type_ComTencentAvUiQavPanel = null;
  SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference = null;
  lxb jdField_a_of_type_Lxb = null;
  lxc jdField_a_of_type_Lxc = null;
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
  
  public lwx(Context paramContext, VideoController paramVideoController, int paramInt, QavPanel paramQavPanel, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6)
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
    paramInt = mjg.a(paramContext);
    if (paramInt <= 320) {
      paramInt = paramContext.getResources().getDimensionPixelSize(2131166479) + paramContext.getResources().getDimensionPixelSize(2131166475);
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
      this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new lwy(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new lwz(this);
      this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new lxa(this);
      return;
      if (paramInt <= 480) {
        paramInt = paramContext.getResources().getDimensionPixelSize(2131166480) + paramContext.getResources().getDimensionPixelSize(2131166476);
      } else {
        paramInt = paramContext.getResources().getDimensionPixelSize(2131166482) + paramContext.getResources().getDimensionPixelSize(2131166478);
      }
    }
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(lxb paramlxb)
  {
    this.jdField_a_of_type_Lxb = paramlxb;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().aq) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.jdField_f_of_type_AndroidViewAnimationAnimation == null) || (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)) {
      if (this.jdField_a_of_type_Lxb != null)
      {
        this.jdField_a_of_type_Lxb.a();
        this.jdField_a_of_type_Lxb.b();
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
  
  public void a(lxc paramlxc)
  {
    this.jdField_a_of_type_Lxc = paramlxc;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ar) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.k == null))
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().aq = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().ar = false;
      }
      if (this.jdField_a_of_type_Lxc != null)
      {
        this.jdField_a_of_type_Lxc.a();
        this.jdField_a_of_type_Lxc.b();
      }
      return;
    }
    paramlxc = this.k;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel.getVisibility() != 0) {
      paramlxc = this.l;
    }
    paramlxc.setAnimationListener(this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(paramlxc);
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
    this.jdField_a_of_type_Lxb = null;
    this.jdField_a_of_type_Lxc = null;
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
 * Qualified Name:     lwx
 * JD-Core Version:    0.7.0.1
 */