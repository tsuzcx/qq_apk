package com.tencent.mobileqq.leba.view;

import aebg;
import aebh;
import aebi;
import aebj;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

public class LebaFeedsDislikeMaskView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private View jdField_a_of_type_AndroidViewView;
  private LebaFeedsDislikeMaskView.Listener jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView$Listener;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private int jdField_c_of_type_Int = 1226998;
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  private int d;
  private int e;
  
  public LebaFeedsDislikeMaskView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public LebaFeedsDislikeMaskView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public LebaFeedsDislikeMaskView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_JavaLangObject = new LebaFeedsItemOutlineProvider(getContext());
      }
      super.setOutlineProvider((LebaFeedsItemOutlineProvider)this.jdField_a_of_type_JavaLangObject);
      super.setClipToOutline(true);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    try
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      if ((this.jdField_b_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    }
    catch (Exception localException2)
    {
      try
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllListeners();
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
        this.jdField_b_of_type_AndroidAnimationValueAnimator = null;
        if ((this.jdField_c_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_c_of_type_AndroidAnimationValueAnimator.isRunning())) {}
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllListeners();
            this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
            this.jdField_c_of_type_AndroidAnimationValueAnimator = null;
            this.jdField_a_of_type_Boolean = false;
            return;
            localException1 = localException1;
            QLog.e("LebaFeedsDislikeMaskView", 1, "clearAnim mGrayShowAnimator exception", localException1);
          }
          localException2 = localException2;
          QLog.e("LebaFeedsDislikeMaskView", 1, "clearAnim mGrayHideAnimator exception", localException2);
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            QLog.e("LebaFeedsDislikeMaskView", 1, "clearAnim mBlueAnimator exception", localException3);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.e = 0;
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidViewView.setScaleX(1.0F);
      this.jdField_a_of_type_AndroidViewView.setScaleY(1.0F);
      this.jdField_b_of_type_Int = -1;
      invalidate();
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(380L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aebg(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new aebh(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_b_of_type_Int = -1;
      a();
      invalidate();
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.e = 0;
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(380L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aebi(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new aebj(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1996488704);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i = getWidth();
    int j = getHeight();
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = ((int)Math.sqrt(i * i + j * j));
    }
    if (this.jdField_b_of_type_Int < 0) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i - this.jdField_b_of_type_Int, j - this.jdField_b_of_type_Int, this.jdField_b_of_type_Int + i, this.jdField_b_of_type_Int + j);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 180.0F, 90.0F, true, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    if (this.d <= 0) {
      this.d = Math.max(i, j);
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i / 2 - this.e, j / 2 - this.e, i / 2 + this.e, j / 2 + this.e);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, true, this.jdField_a_of_type_AndroidGraphicsPaint);
    super.onDraw(paramCanvas);
  }
  
  public void setButtonView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setListener(LebaFeedsDislikeMaskView.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView$Listener = paramListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsDislikeMaskView
 * JD-Core Version:    0.7.0.1
 */