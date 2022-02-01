package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bbhl;
import bpns;
import bpoo;
import bppf;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import java.util.concurrent.atomic.AtomicBoolean;
import ykv;

public class QIMCameraStoryCaptureButtonLayout
  extends QIMCameraSegmentCaptureButtonLayoutNew
  implements bpns
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bppf jdField_a_of_type_Bppf;
  private DragAnimationMgr jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr;
  private QIMCameraStoryCaptureButtonLayout.RunnableLW jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$RunnableLW = new QIMCameraStoryCaptureButtonLayout.RunnableLW(this, null);
  private long jdField_b_of_type_Long;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ObjectAnimator c;
  private ObjectAnimator d;
  private boolean g;
  private boolean h = true;
  
  public QIMCameraStoryCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QIMCameraStoryCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if ((this.g) && (this.jdField_b_of_type_Long != 0L)) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.b(paramMotionEvent);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_AndroidWidgetImageView.getAlpha() != 1.0F) && ((this.jdField_a_of_type_AndroidAnimationObjectAnimator == null) || (!this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()))) {}
    }
    while ((this.jdField_a_of_type_AndroidWidgetImageView.getAlpha() == 0.0F) || ((this.jdField_b_of_type_AndroidAnimationObjectAnimator != null) && (this.jdField_b_of_type_AndroidAnimationObjectAnimator.isRunning())))
    {
      return;
      if (paramBoolean2)
      {
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
        {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator = DragAnimationMgr.c(this.jdField_a_of_type_AndroidWidgetImageView, null);
          return;
        }
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      return;
    }
    if (paramBoolean2)
    {
      if (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null)
      {
        this.jdField_b_of_type_AndroidAnimationObjectAnimator = DragAnimationMgr.b(this.jdField_a_of_type_AndroidWidgetImageView, null);
        return;
      }
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.0F);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    if (this.jdField_a_of_type_AndroidViewMotionEvent != null) {
      this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
    }
    this.jdField_a_of_type_AndroidViewMotionEvent = paramMotionEvent;
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.jdField_b_of_type_AndroidWidgetImageView.getAlpha() != 1.0F) && ((this.jdField_c_of_type_AndroidAnimationObjectAnimator == null) || (!this.jdField_c_of_type_AndroidAnimationObjectAnimator.isRunning()))) {}
    }
    while ((this.jdField_b_of_type_AndroidWidgetImageView.getAlpha() == 0.0F) || ((this.jdField_d_of_type_AndroidAnimationObjectAnimator != null) && (this.jdField_d_of_type_AndroidAnimationObjectAnimator.isRunning())))
    {
      return;
      if (paramBoolean2)
      {
        if (this.jdField_c_of_type_AndroidAnimationObjectAnimator == null)
        {
          this.jdField_c_of_type_AndroidAnimationObjectAnimator = DragAnimationMgr.c(this.jdField_b_of_type_AndroidWidgetImageView, null);
          return;
        }
        this.jdField_c_of_type_AndroidAnimationObjectAnimator.start();
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      return;
    }
    if (paramBoolean2)
    {
      if (this.jdField_d_of_type_AndroidAnimationObjectAnimator == null)
      {
        this.jdField_d_of_type_AndroidAnimationObjectAnimator = DragAnimationMgr.b(this.jdField_b_of_type_AndroidWidgetImageView, null);
        return;
      }
      this.jdField_d_of_type_AndroidAnimationObjectAnimator.start();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.0F);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "onDownUINeedChange method");
    }
    if (this.jdField_a_of_type_Bppf != null) {
      this.jdField_a_of_type_Bppf.a();
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a(paramMotionEvent);
    c(paramMotionEvent);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$RunnableLW, 100L);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "onUpUINeedChange:leftDirection-" + paramBoolean1 + " selected:" + paramBoolean2);
    }
    if (paramBoolean2) {
      if (paramBoolean1)
      {
        if (this.jdField_a_of_type_Bppf != null) {
          this.jdField_a_of_type_Bppf.a(1);
        }
        setEnableSegment(false);
      }
    }
    for (;;)
    {
      if (!this.g) {
        q();
      }
      if (this.jdField_a_of_type_Bppf != null) {
        this.jdField_a_of_type_Bppf.a(paramBoolean1, paramBoolean2);
      }
      return;
      if (this.jdField_a_of_type_Bppf != null) {
        this.jdField_a_of_type_Bppf.a(2);
      }
      int i = -1;
      if (this.jdField_a_of_type_Bppf != null) {
        i = this.jdField_a_of_type_Bppf.a();
      }
      ykv.a("clk_lock", bbhl.jdField_a_of_type_Int, 0, new String[] { "" + i });
      continue;
      if (this.f) {
        g(false);
      }
    }
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraStoryCaptureButtonLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", segmentShot:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isOver:" + this.jdField_a_of_type_Boolean);
    }
    int i = paramMotionEvent.getAction();
    f();
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (this.e) {
            break;
          }
        } while ((this.jdField_a_of_type_Bpoo == null) || ((paramMotionEvent.getAction() & 0xFF) != 0));
        return false;
        if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)
        {
          r();
          return false;
        }
        switch (i & 0xFF)
        {
        case 4: 
        default: 
          return false;
        }
      } while (this.jdField_b_of_type_Boolean);
      if (this.g)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        return true;
      }
      if ((this.jdField_a_of_type_Bpoo != null) && (this.jdField_a_of_type_Bpoo.g())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QIMCameraStoryCaptureButtonLayout", 2, "[segmentCapture] ignore down action, capture not ready");
    return false;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a(false);
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 1))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label341;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
    for (;;)
    {
      a(paramMotionEvent);
      this.jdField_c_of_type_Boolean = true;
      return true;
      label341:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 100L);
    }
    if ((this.g) && (this.jdField_b_of_type_Long != 0L) && (this.jdField_b_of_type_Long - System.currentTimeMillis() < 50L))
    {
      q();
      setLockStatus(false);
      this.jdField_b_of_type_Long = 0L;
      return true;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a(paramMotionEvent);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$RunnableLW);
    return true;
    if (this.jdField_a_of_type_Bpoo != null) {
      this.jdField_a_of_type_Bpoo.a();
    }
    if ((this.g) && (this.jdField_b_of_type_Long != 0L)) {
      return true;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.b(paramMotionEvent);
    c(paramMotionEvent);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "execute rollBackAnimationEnd method");
    }
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setDrawCenterCircle(true);
    if (this.g) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(3);
    }
    for (;;)
    {
      h(false);
      if (this.jdField_a_of_type_Bppf != null) {
        this.jdField_a_of_type_Bppf.b(this.f, this.g);
      }
      return;
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(0);
    }
  }
  
  public void c()
  {
    u();
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "haveMoveInvalid:" + paramBoolean);
    }
    if (paramBoolean)
    {
      g(true);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setDrawCenterCircle(false);
    }
  }
  
  protected void e()
  {
    super.e();
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131364286);
    int i = ViewUtils.dip2px(45.0F);
    int j = ViewUtils.dip2px(60.0F);
    int k = ViewUtils.dip2px(17.0F);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.setMargins(j, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(k);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844415);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844595);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
    localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.setMargins(0, 0, j, 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setTranslationY(k);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844415);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844593);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    localRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr = new DragAnimationMgr();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a((ViewGroup)this.jdField_c_of_type_AndroidViewView, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a(this);
    this.f = false;
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "showStatusButton:" + paramBoolean + " mIsSegment:" + this.f + " mEnableSegment:" + this.h + " mLockStatus:" + this.g);
    }
    if (((!this.f) && (this.h)) || (!paramBoolean)) {
      b(paramBoolean, true);
    }
    if ((!this.g) || (!paramBoolean)) {
      c(paramBoolean, true);
    }
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "startCaptureAnimationEnd method");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a(true);
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "showStatusButtonWithAnim:" + paramBoolean + " mIsSegment:" + this.f + " mEnableSegment:" + this.h + " mLockStatus:" + this.g);
    }
    if (((!this.f) && (this.h)) || (!paramBoolean)) {
      b(paramBoolean, false);
    }
    if ((!this.g) || (!paramBoolean)) {
      c(paramBoolean, false);
    }
  }
  
  public void h_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "onEnterRegion method,leftDirection:" + paramBoolean);
    }
    if (paramBoolean)
    {
      setSegment(true);
      if (this.jdField_a_of_type_Bppf != null) {
        this.jdField_a_of_type_Bppf.a(3);
      }
    }
    do
    {
      return;
      setLockStatus(true);
    } while (this.jdField_a_of_type_Bppf == null);
    this.jdField_a_of_type_Bppf.a(4);
  }
  
  public void i_(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "onExitRegion method,leftDirection:" + paramBoolean);
    }
    if (paramBoolean)
    {
      setSegment(false);
      if (this.jdField_a_of_type_Bppf != null) {
        this.jdField_a_of_type_Bppf.a(5);
      }
    }
    do
    {
      return;
      setLockStatus(false);
    } while (this.jdField_a_of_type_Bppf == null);
    this.jdField_a_of_type_Bppf.a(6);
  }
  
  protected void j()
  {
    super.j();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.b();
  }
  
  public void k()
  {
    super.k();
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setDrawCenterCircle(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.b();
    h(false);
  }
  
  public void setCaptureStatusChangeListener(bppf parambppf)
  {
    this.jdField_a_of_type_Bppf = parambppf;
  }
  
  public void setDrawCenterCircle(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setDrawCenterCircle(paramBoolean);
  }
  
  public void setEnableSegment(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "setEnableSegment:" + paramBoolean);
    }
    this.h = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a(0);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a(2);
  }
  
  public void setLockStatus(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "setLockStatus:" + paramBoolean);
    }
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      setSelectLock(paramBoolean);
    }
  }
  
  public void setSegment(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "setSegment:" + paramBoolean);
    }
    super.setSegment(paramBoolean);
    setSelectPause(paramBoolean);
  }
  
  public void setSelectLock(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844416);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844592);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130844415);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844593);
  }
  
  public void setSelectPause(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844416);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844594);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130844415);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */