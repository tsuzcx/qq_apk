package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
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
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KSongMicView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(5);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private KSongMicView.StatusListener jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView$StatusListener;
  private List<KSongMicView.CircleHolder> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private float jdField_b_of_type_Float = DisplayUtil.a(getContext(), 2.0F);
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public KSongMicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    int i = DisplayUtil.a(getContext(), 90.0F);
    this.c = i;
    this.jdField_b_of_type_Int = i;
    this.d = DisplayUtil.a(getContext(), 28.0F);
    this.e = DisplayUtil.a(getContext(), 36.5F);
    this.f = DisplayUtil.a(getContext(), 12.0F);
    this.g = DisplayUtil.a(getContext(), 100.0F);
    ViewCompat.setImportantForAccessibility(this, 1);
    setContentDescription(HardCodeUtil.a(R.string.bh));
    setClickable(true);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2)
  {
    KSongMicView.CircleHolder localCircleHolder = new KSongMicView.CircleHolder(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList.add(localCircleHolder);
  }
  
  private void c()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new KSongMicView.1(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilList.clear();
    a(a() * 0.93F, b(), 0.8F, 0.1F, 1.0F, 1.05F, 1.0F, 0.95F, 0, 30);
    a(a() * 1.03F, b() * 0.975F, 0.5F, 0.1F, 1.0F, 0.95F, 1.0F, 0.95F, 0, -30);
    a(a() * 1.03F, b() * 1.1F, 0.1F, 0.5F, 1.0F, 0.95F, 1.0F, 0.95F, 0, 30);
    a(a() * 1.07F, b() * 1.02F, 0.1F, 0.8F, 1.0F, 0.9F, 1.0F, 0.95F, 0, 30);
    c();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.1F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.1F, 1.0F }) });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Int = 0;
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
    int i = this.jdField_a_of_type_Int;
    float f2 = 1.0F;
    if (i == 3)
    {
      this.jdField_b_of_type_Float = DisplayUtil.a(getContext(), 1.0F);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        KSongMicView.CircleHolder localCircleHolder = (KSongMicView.CircleHolder)((Iterator)localObject).next();
        paramCanvas.save();
        f1 = localCircleHolder.jdField_a_of_type_Float;
        f2 = localCircleHolder.jdField_b_of_type_Float;
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
    }
    this.jdField_b_of_type_Float = DisplayUtil.a(getContext(), 1.0F);
    paramCanvas.save();
    paramCanvas.translate((getWidth() - a()) / 2, (getHeight() - b()) / 2);
    i = this.jdField_a_of_type_Int;
    if ((i != 0) && (i != 2)) {
      i = 127;
    } else {
      i = 255;
    }
    int j = this.jdField_a_of_type_Int;
    float f1 = f2;
    if (j != 0) {
      if (j == 2) {
        f1 = f2;
      } else {
        f1 = 0.95F;
      }
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
    j = this.jdField_a_of_type_Int;
    if ((j == 0) || (j == 1))
    {
      localObject = getResources().getDrawable(R.drawable.ab);
      int k = a();
      j = this.d;
      k = (k - j) / 2;
      ((Drawable)localObject).setBounds(k, k, j + k, this.e + k);
      ((Drawable)localObject).setAlpha(i);
      ((Drawable)localObject).draw(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    KSongMicView.StatusListener localStatusListener;
    if (i != 0)
    {
      if (((i == 1) || ((i != 2) && (i == 3))) && (this.jdField_a_of_type_Int == 1))
      {
        float f1 = this.jdField_a_of_type_Float;
        paramMotionEvent.getRawY();
        i = 0;
        if ((!QWalletTools.a(this, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (paramMotionEvent.getAction() == 3)) {
          i = 1;
        }
        if (i != 0)
        {
          localStatusListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView$StatusListener;
          if (localStatusListener != null) {
            localStatusListener.n();
          }
          b();
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_Int = 2;
          invalidate();
          localStatusListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView$StatusListener;
          if (localStatusListener != null) {
            localStatusListener.m();
          }
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    i = this.jdField_a_of_type_Int;
    if (i == 3) {
      return true;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_Int = 1;
      invalidate();
      localStatusListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView$StatusListener;
      if (localStatusListener != null) {
        localStatusListener.l();
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
    }
    return true;
  }
  
  public void setStatusListener(KSongMicView.StatusListener paramStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongMicView$StatusListener = paramStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongMicView
 * JD-Core Version:    0.7.0.1
 */