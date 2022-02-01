package dov.com.qq.im.ae.camera.ui.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.ICaptureController;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.data.AEWatermarkMaterialManager;
import dov.com.qq.im.ae.data.AEWatermarkMaterialManager.IWatermarkMgrListener;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.util.QIMAnimationUtils;
import mqq.os.MqqHandler;

public class AEWaterMarkPanel
  extends AbsBottomPanal
{
  public int a;
  private ICaptureController jdField_a_of_type_DovComQqImAeCameraUiICaptureController;
  private AEWaterMarkPanel.AEWaterMarkPanelListener jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener;
  AEWaterMarkProviderView jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEWatermarkMaterialManager.IWatermarkMgrListener jdField_a_of_type_DovComQqImAeDataAEWatermarkMaterialManager$IWatermarkMgrListener;
  private VideoStoryCapturePartManager jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean b = false;
  private boolean c = false;
  
  public AEWaterMarkPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEWaterMarkPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = a();
  }
  
  public AEWaterMarkPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = a();
  }
  
  private int a()
  {
    return UIUtils.a(getContext(), 195.0F);
  }
  
  private void a(Runnable paramRunnable)
  {
    g();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView.setVisibility(8);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  private void b(Runnable paramRunnable)
  {
    AEQLog.a("AEWaterMarkPanel", "in close panel animation.");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEWaterMarkPanel.3(this, paramRunnable));
    localAnimatorSet.setDuration(300L).start();
    paramRunnable = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView, 1.0F, 0.0F);
    paramRunnable.setStartOffset(0L);
    paramRunnable.setDuration(100L);
    paramRunnable.setAnimationListener(new AEWaterMarkPanel.4(this));
    startAnimation(paramRunnable);
  }
  
  @TargetApi(12)
  private void c(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView == null) {
      h();
    }
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F }));
    ((AnimatorSet)localObject).addListener(new AEWaterMarkPanel.7(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEWaterMarkPanel.8(this, paramRunnable));
    startAnimation((Animation)localObject);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiICaptureController != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiICaptureController.a(false, 150);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager != null) {
      this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(131075, new Object[0]);
    }
  }
  
  private void g()
  {
    setTranslationY(a());
    setVisibility(8);
  }
  
  @TargetApi(11)
  private void h()
  {
    AEQLog.a("AEWaterMarkPanel", "watermark loadView");
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = a();
    setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView == null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView = new AEWaterMarkProviderView(getContext(), this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener);
      addView(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView);
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView != null) {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView.setCaptureRadio(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      }
      i();
      this.jdField_a_of_type_DovComQqImAeDataAEWatermarkMaterialManager$IWatermarkMgrListener = new AEWaterMarkPanel.5(this);
      AEWatermarkMaterialManager.a().a(this.jdField_a_of_type_DovComQqImAeDataAEWatermarkMaterialManager$IWatermarkMgrListener);
    }
  }
  
  private void i()
  {
    ThreadManager.excute(new AEWaterMarkPanel.6(this), 64, null, false);
  }
  
  public void a()
  {
    c(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = (Activity)getContext();
      if ((AECameraEntry.k(((Activity)localObject).getIntent())) && (a()))
      {
        MqqHandler localMqqHandler = ThreadManager.getUIHandler();
        localObject = new AEWaterMarkPanel.1(this, (Activity)localObject);
        this.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject);
        localMqqHandler.postDelayed((Runnable)localObject, 300L);
      }
    }
    a(paramBoolean, new AEWaterMarkPanel.2(this));
  }
  
  public void a(boolean paramBoolean, Runnable paramRunnable)
  {
    if (!a()) {
      return;
    }
    if (paramBoolean) {
      b(paramRunnable);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager != null) {
        this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(196613, new Object[0]);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AEWaterMarkPanel", 2, "panel closed");
      return;
      a(paramRunnable);
    }
  }
  
  public boolean a()
  {
    if (getVisibility() == 8) {}
    while ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView.getVisibility() != 0)) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEWaterMarkPanel", 2, "onDestroy()");
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_DovComQqImAeDataAEWatermarkMaterialManager$IWatermarkMgrListener != null) {
      AEWatermarkMaterialManager.a().b(this.jdField_a_of_type_DovComQqImAeDataAEWatermarkMaterialManager$IWatermarkMgrListener);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c() {}
  
  public void setCaptureController(ICaptureController paramICaptureController)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiICaptureController = paramICaptureController;
  }
  
  public void setCaptureRadio(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    AEQLog.a("AEWaterMarkPanel", "setCaptureRadio " + paramRatio);
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkProviderView.setCaptureRadio(paramRatio);
    }
  }
  
  public void setMaterialPanelListener(AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = paramAEWaterMarkPanelListener;
  }
  
  public void setPartManager(VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager = paramVideoStoryCapturePartManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel
 * JD-Core Version:    0.7.0.1
 */