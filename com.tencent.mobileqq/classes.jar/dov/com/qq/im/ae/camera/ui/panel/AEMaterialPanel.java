package dov.com.qq.im.ae.camera.ui.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import bikl;
import bioo;
import biop;
import bioq;
import bior;
import bios;
import biws;
import bjah;
import bjjp;
import com.tencent.qphone.base.util.QLog;
import vzl;

public class AEMaterialPanel
  extends FrameLayout
{
  public int a;
  private bikl jdField_a_of_type_Bikl;
  private bios jdField_a_of_type_Bios;
  private biws jdField_a_of_type_Biws;
  private AEMaterialProviderView jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView;
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
    return vzl.a(getContext(), 242.0F);
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
    ((AnimatorSet)localObject).addListener(new bioo(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = bjjp.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new biop(this, paramRunnable));
    startAnimation((Animation)localObject);
  }
  
  private void c(Runnable paramRunnable)
  {
    bjah.a("AEMaterialPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new bioq(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = bjjp.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new bior(this));
    startAnimation(paramRunnable);
  }
  
  private void d()
  {
    setTranslationY(a());
    setVisibility(8);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bikl != null) {
      this.jdField_a_of_type_Bikl.a(false, 150);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Biws != null) {
      this.jdField_a_of_type_Biws.a(131075, new Object[0]);
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = a();
    setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView = new AEMaterialProviderView(getContext(), this.jdField_a_of_type_Bios);
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
    a(paramBoolean, new AEMaterialPanel.1(this));
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
      if (this.jdField_a_of_type_Biws != null) {
        this.jdField_a_of_type_Biws.a(196613, new Object[0]);
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
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.a();
    }
  }
  
  public void setAECaptureController(bikl parambikl)
  {
    this.jdField_a_of_type_Bikl = parambikl;
  }
  
  public void setMaterialPanelListener(bios parambios)
  {
    this.jdField_a_of_type_Bios = parambios;
  }
  
  public void setPartManager(biws parambiws)
  {
    this.jdField_a_of_type_Biws = parambiws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel
 * JD-Core Version:    0.7.0.1
 */