package dov.com.tencent.mobileqq.richmedia.capture.view;

import aepi;
import alud;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bnls;
import bnlt;
import bnlu;
import bnlv;
import bnlw;
import bnlx;
import bnsw;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class CameraCaptureButtonLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 10000.0F;
  private int jdField_a_of_type_Int = aepi.a(45.0F, getResources());
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new bnlv(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bnlu(this);
  private View jdField_a_of_type_AndroidViewView;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bnlw jdField_a_of_type_Bnlw;
  private bnlx jdField_a_of_type_Bnlx;
  private CameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = aepi.a(70.0F, getResources());
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public AtomicBoolean b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  
  public CameraCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    c();
  }
  
  public CameraCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    c();
  }
  
  private void a(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_a_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_a_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams(localLayoutParams);
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131560972, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366521);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366603));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365797));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)findViewById(2131364908));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366505));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366506));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167194), 100, getResources().getColor(2131165332));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(4.5F);
  }
  
  @TargetApi(11)
  private void d()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    bnsw.a(this.jdField_b_of_type_AndroidWidgetImageView, 0.1F, 1.0F, 0.1F, 1.2F, 400, null);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.1333F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bnls(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bnlt(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  private void e()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      Animation localAnimation = this.jdField_b_of_type_AndroidWidgetImageView.getAnimation();
      if (localAnimation != null)
      {
        localAnimation.cancel();
        localAnimation.setAnimationListener(null);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  private void f()
  {
    a(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_Bnlx;
    if (localObject != null)
    {
      this.jdField_a_of_type_Boolean = ((bnlx)localObject).a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress, this.jdField_a_of_type_Long, this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_Boolean) {
        h();
      }
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    boolean bool;
    if ((float)l >= this.jdField_a_of_type_Float)
    {
      bool = true;
      label72:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label189;
      }
    }
    label189:
    for (int i = 100;; i = (int)((float)l / this.jdField_a_of_type_Float * 100.0F))
    {
      localObject = (int)l / 1000 + alud.a(2131701689);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CameraCaptureLayout", 2, "updateProgress percent:" + i + ", time:" + (String)localObject);
      break;
      bool = false;
      break label72;
    }
  }
  
  private void h()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if ((this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 1))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      e();
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        continue;
        if (this.jdField_c_of_type_Int == 2) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void b()
  {
    f();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void setCaptureButtonProgressInterceptor(bnlx parambnlx)
  {
    this.jdField_a_of_type_Bnlx = parambnlx;
  }
  
  public void setFunctionFlag(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */