package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordMicView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 10000;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(5);
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private RecordMicView.StatusListener jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView$StatusListener;
  private List<RecordMicView.CircleHolder> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private float jdField_b_of_type_Float = DisplayUtil.a(getContext(), 2.0F);
  private int jdField_b_of_type_Int = 0;
  private int c;
  private int d;
  private int e;
  
  public RecordMicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    int i = DisplayUtil.a(getContext(), 120.0F);
    this.d = i;
    this.c = i;
    this.e = DisplayUtil.a(getContext(), 33.0F);
    ViewCompat.setImportantForAccessibility(this, 1);
    setContentDescription(HardCodeUtil.a(R.string.bX));
    setClickable(true);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2)
  {
    RecordMicView.CircleHolder localCircleHolder = new RecordMicView.CircleHolder(DisplayUtil.a(getContext(), paramFloat1), DisplayUtil.a(getContext(), paramFloat2), paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList.add(localCircleHolder);
  }
  
  private void d()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new RecordMicView.1(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList.clear();
    a(112.0F, 120.0F, 0.8F, 0.1F, 1.0F, 1.05F, 1.0F, 0.95F, 0, 30);
    a(124.0F, 117.0F, 0.5F, 0.1F, 1.0F, 0.95F, 1.0F, 0.95F, 0, -30);
    a(124.0F, 132.0F, 0.1F, 0.5F, 1.0F, 0.95F, 1.0F, 0.95F, 0, 30);
    a(128.0F, 122.0F, 0.1F, 0.8F, 1.0F, 0.9F, 1.0F, 0.95F, 0, 30);
    d();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.1F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.1F, 1.0F }) });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RecordMicView.2(this), this.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Int = 0;
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.jdField_b_of_type_Int;
    int i = 127;
    float f1 = 1.0F;
    if (j == 2)
    {
      this.jdField_b_of_type_Float = DisplayUtil.a(getContext(), 1.0F);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecordMicView.CircleHolder localCircleHolder = (RecordMicView.CircleHolder)((Iterator)localObject).next();
        paramCanvas.save();
        f1 = localCircleHolder.jdField_a_of_type_Float;
        float f2 = localCircleHolder.jdField_b_of_type_Float;
        f1 = (getWidth() - f1) / 2.0F;
        f2 = (getHeight() - f2) / 2.0F;
        i = (int)(localCircleHolder.c * 255.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-3405);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        float f3 = this.jdField_b_of_type_Float;
        localRectF.set(f3 * 0.5F + f1, f3 * 0.5F + f2, getWidth() - this.jdField_b_of_type_Float * 0.5F - f1, getHeight() - this.jdField_b_of_type_Float * 0.5F - f2);
        paramCanvas.scale(localCircleHolder.d, localCircleHolder.e, getWidth() / 2, getHeight() / 2);
        paramCanvas.rotate(localCircleHolder.jdField_a_of_type_Int, getWidth() / 2, getHeight() / 2);
        paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.restore();
      }
      paramCanvas.save();
      paramCanvas.translate((getWidth() - a()) / 2, (getHeight() - b()) / 2);
      localObject = getResources().getDrawable(R.drawable.af);
      ((Drawable)localObject).setBounds(0, 0, a(), b());
      ((Drawable)localObject).setAlpha(127);
      ((Drawable)localObject).draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    this.jdField_b_of_type_Float = DisplayUtil.a(getContext(), 2.0F);
    paramCanvas.save();
    paramCanvas.translate((getWidth() - a()) / 2, (getHeight() - b()) / 2);
    if (this.jdField_b_of_type_Int == 0) {
      i = 255;
    }
    if (this.jdField_b_of_type_Int != 0) {
      f1 = 0.95F;
    }
    paramCanvas.scale(f1, f1, getWidth() / 2, getHeight() / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16728412);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, a(), b());
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
    paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-3405);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    f1 = this.jdField_b_of_type_Float;
    ((RectF)localObject).set(f1 * 0.5F, f1 * 0.5F, a() - this.jdField_b_of_type_Float * 0.5F, b() - this.jdField_b_of_type_Float * 0.5F);
    paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    localObject = getResources().getDrawable(R.drawable.af);
    ((Drawable)localObject).setBounds(0, 0, a(), b());
    ((Drawable)localObject).setAlpha(i);
    ((Drawable)localObject).draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    RecordMicView.StatusListener localStatusListener;
    if (i != 0)
    {
      if (((i == 1) || ((i != 2) && (i == 3))) && (this.jdField_b_of_type_Int == 1))
      {
        float f1 = this.jdField_a_of_type_Float;
        float f2 = paramMotionEvent.getRawY();
        i = 0;
        if (f1 - f2 > this.e) {
          i = 1;
        }
        if (i != 0)
        {
          localStatusListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView$StatusListener;
          if (localStatusListener != null) {
            localStatusListener.d();
          }
          c();
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          if (this.jdField_a_of_type_Boolean) {
            a();
          } else {
            c();
          }
          localStatusListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView$StatusListener;
          if (localStatusListener != null) {
            localStatusListener.b();
          }
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    i = this.jdField_b_of_type_Int;
    if (i == 2) {
      return true;
    }
    if (i == 0)
    {
      this.jdField_b_of_type_Int = 1;
      invalidate();
      b();
      localStatusListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView$StatusListener;
      if (localStatusListener != null) {
        localStatusListener.a();
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
    }
    return true;
  }
  
  public void setRecordTime(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setStatusListener(RecordMicView.StatusListener paramStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplRecordMicView$StatusListener = paramStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.RecordMicView
 * JD-Core Version:    0.7.0.1
 */