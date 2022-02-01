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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.camera.ui.ICaptureController;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.util.QIMAnimationUtils;
import mqq.os.MqqHandler;

public class AEMaterialPanel
  extends AbsBottomPanal
{
  public int a;
  private ICaptureController jdField_a_of_type_DovComQqImAeCameraUiICaptureController;
  private AEMaterialPanel.AEMaterialPanelListener jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
  private AEMaterialProviderView jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView;
  private VideoStoryCapturePartManager jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean b = false;
  private boolean c = false;
  
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
    return UIUtils.a(getContext(), 242.0F);
  }
  
  private void a(Runnable paramRunnable)
  {
    e();
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
    ((AnimatorSet)localObject).addListener(new AEMaterialPanel.3(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEMaterialPanel.4(this, paramRunnable));
    startAnimation((Animation)localObject);
    if (((getContext() instanceof Activity)) && (AECameraEntry.k(((Activity)getContext()).getIntent()))) {
      AEReportUtils.a(5, null);
    }
  }
  
  private void c(Runnable paramRunnable)
  {
    AEQLog.a("AEMaterialPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEMaterialPanel.5(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEMaterialPanel.6(this));
    startAnimation(paramRunnable);
  }
  
  private void e()
  {
    setTranslationY(a());
    setVisibility(8);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiICaptureController != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiICaptureController.a(false, 150);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager != null) {
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(131075, new Object[0]);
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = a();
    setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView = new AEMaterialProviderView(getContext(), this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      addView(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    b(null);
    if ((paramBoolean) && (paramString1 != null) && (paramString2 != null)) {
      a(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = (Activity)getContext();
      if ((AECameraEntry.k(((Activity)localObject).getIntent())) && (a()))
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
      if (this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager != null) {
        this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196613, new Object[0]);
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
  
  public boolean b()
  {
    return !a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialProviderView.a();
    }
  }
  
  public void setCaptureController(ICaptureController paramICaptureController)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiICaptureController = paramICaptureController;
  }
  
  public void setMaterialPanelListener(AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = paramAEMaterialPanelListener;
  }
  
  public void setPartManager(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager = paramVideoStoryCapturePartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel
 * JD-Core Version:    0.7.0.1
 */