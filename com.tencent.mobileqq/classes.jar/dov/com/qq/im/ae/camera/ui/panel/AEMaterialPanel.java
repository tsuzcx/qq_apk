package dov.com.qq.im.ae.camera.ui.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import bkpa;
import bkti;
import bktj;
import bktk;
import bktl;
import bktm;
import bkwm;
import blbm;
import blfg;
import blva;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import xod;

public class AEMaterialPanel
  extends FrameLayout
{
  public int a;
  private bkpa jdField_a_of_type_Bkpa;
  private bktm jdField_a_of_type_Bktm;
  private blbm jdField_a_of_type_Blbm;
  private AEMaterialProviderView jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AEMaterialPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEMaterialPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEMaterialPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = a();
  }
  
  private int a()
  {
    return xod.a(getContext(), 242.0F);
  }
  
  private void a(Runnable paramRunnable)
  {
    d();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.setVisibility(8);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  @TargetApi(12)
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView == null) {
      a();
    }
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F }));
    ((AnimatorSet)localObject).addListener(new bkti(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = blva.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new bktj(this, paramRunnable));
    startAnimation((Animation)localObject);
  }
  
  private void c(Runnable paramRunnable)
  {
    blfg.a("AEMaterialPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bktk(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = blva.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new bktl(this));
    startAnimation(paramRunnable);
  }
  
  private void d()
  {
    setTranslationY(a());
    setVisibility(8);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bkpa != null) {
      this.jdField_a_of_type_Bkpa.a(false, 150);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Blbm != null) {
      this.jdField_a_of_type_Blbm.a(131075, new Object[0]);
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = a();
    setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView = new AEMaterialProviderView(getContext(), this.jdField_a_of_type_Bktm);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      addView(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    b(null);
    if ((paramBoolean) && (paramString1 != null) && (paramString2 != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.a(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = (Activity)getContext();
      if (bkwm.i(((Activity)localObject).getIntent()))
      {
        MqqHandler localMqqHandler = ThreadManager.getUIHandler();
        localObject = new AEMaterialPanel.1(this, (Activity)localObject);
        this.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject);
        localMqqHandler.postDelayed((Runnable)localObject, 300L);
      }
    }
    a(paramBoolean, new AEMaterialPanel.2(this));
  }
  
  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!a()) {
      return;
    }
    if (paramBoolean) {
      c(paramRunnable);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Blbm != null) {
        this.jdField_a_of_type_Blbm.a(196613, new Object[0]);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AEMaterialPanel", 2, "panel closed");
      return;
      a(paramRunnable);
    }
  }
  
  public boolean a()
  {
    if (getVisibility() == 8) {}
    while ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEMaterialPanel", 2, "onDestroy()");
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.b();
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.a();
    }
  }
  
  public void setAECaptureController(bkpa parambkpa)
  {
    this.jdField_a_of_type_Bkpa = parambkpa;
  }
  
  public void setMaterialPanelListener(bktm parambktm)
  {
    this.jdField_a_of_type_Bktm = parambktm;
  }
  
  public void setPartManager(blbm paramblbm)
  {
    this.jdField_a_of_type_Blbm = paramblbm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel
 * JD-Core Version:    0.7.0.1
 */