package dov.com.tencent.mobileqq.richmedia.capture.view;

import ajyc;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import bcpw;
import bkvr;
import bkvs;
import bkvt;
import bkvu;
import blbz;
import com.tencent.qphone.base.util.QLog;

public class DragAnimationMgr
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bkvt jdField_a_of_type_Bkvt;
  private bkvu jdField_a_of_type_Bkvu = new bkvu();
  private DragAnimationMgr.DragViewIcon jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  
  private int a()
  {
    int i = -1;
    if (this.jdField_a_of_type_Int == 0) {
      i = Math.max(this.c.getHeight(), this.jdField_b_of_type_AndroidViewView.getHeight());
    }
    do
    {
      return i;
      if (this.jdField_a_of_type_Int != -1) {
        break;
      }
    } while (!this.jdField_a_of_type_Boolean);
    return blbz.a(40.0F);
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_b_of_type_AndroidViewView.getHeight();
    }
    return this.c.getHeight();
  }
  
  public static ObjectAnimator a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F });
    paramView.setDuration(150L);
    if (paramAnimatorListenerAdapter != null) {
      paramView.addListener(paramAnimatorListenerAdapter);
    }
    paramView.start();
    return paramView;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unKnown test=" + this.jdField_a_of_type_Boolean;
    case 0: 
      return "BI_DIRECTION";
    case 2: 
      return "RIGHT_DIRECTION";
    }
    return "LEFT_DIRECTION";
  }
  
  private void a(float paramFloat)
  {
    int i = 0;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkvu.jdField_a_of_type_Float = (Math.max(i, paramFloat) / 4.0F);
      if (this.jdField_a_of_type_Bkvu.jdField_a_of_type_Float <= 0.0F) {
        this.jdField_a_of_type_Bkvu.jdField_a_of_type_Float = blbz.a(1.0F);
      }
      return;
      i = this.c.getWidth() / 2;
      continue;
      i = this.jdField_b_of_type_AndroidViewView.getWidth() / 2;
      continue;
      i = Math.max(this.c.getWidth(), this.jdField_b_of_type_AndroidViewView.getWidth()) / 2;
    }
  }
  
  public static void a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a(true, paramView, paramAnimatorListenerAdapter, paramView.getHeight());
  }
  
  private void a(DragAnimationMgr.DragViewIcon paramDragViewIcon, int paramInt)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(paramDragViewIcon, "offset", new int[] { paramInt, 0 });
    localObjectAnimator.setStartDelay(125L);
    localObjectAnimator.setDuration(330L);
    paramDragViewIcon.jdField_b_of_type_Boolean = true;
    localObjectAnimator.addListener(new bkvs(this, paramDragViewIcon));
    localObjectAnimator.start();
  }
  
  private void a(DragAnimationMgr.DragViewIcon paramDragViewIcon, int paramInt1, int paramInt2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramDragViewIcon = ObjectAnimator.ofInt(paramDragViewIcon, "offset", new int[] { paramInt1, paramInt2 });
    paramDragViewIcon.setDuration(100L);
    paramDragViewIcon.addListener(paramAnimatorListenerAdapter);
    paramDragViewIcon.start();
  }
  
  private static void a(boolean paramBoolean, View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter, int paramInt)
  {
    ObjectAnimator localObjectAnimator;
    if (paramBoolean) {
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    }
    for (paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramInt, 0.0F });; paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramInt }))
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(localObjectAnimator).with(paramView);
      localAnimatorSet.setDuration(270L);
      if (paramAnimatorListenerAdapter != null) {
        localAnimatorSet.addListener(paramAnimatorListenerAdapter);
      }
      localAnimatorSet.start();
      return;
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_Bkvt != null) {
      if (paramBoolean1) {
        this.jdField_a_of_type_Bkvt.a(paramBoolean2);
      }
    }
    while (!this.jdField_a_of_type_Boolean)
    {
      return;
      this.jdField_a_of_type_Bkvt.b(paramBoolean2);
      return;
    }
    if (paramBoolean1)
    {
      bcpw.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.getContext(), ajyc.a(2131703515) + paramBoolean2, 0).a();
      return;
    }
    bcpw.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.getContext(), ajyc.a(2131703514) + paramBoolean2 + " max:" + paramBoolean3, 0).a();
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int <= 2));
  }
  
  public static ObjectAnimator b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    return a(paramView, paramAnimatorListenerAdapter);
  }
  
  public static void b(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a(false, paramView, paramAnimatorListenerAdapter, paramView.getHeight());
  }
  
  public static ObjectAnimator c(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    paramView.setDuration(150L);
    if (paramAnimatorListenerAdapter != null) {
      paramView.addListener(paramAnimatorListenerAdapter);
    }
    paramView.start();
    return paramView;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon == null)
    {
      int i = a();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon = new DragAnimationMgr.DragViewIcon(this, this.jdField_a_of_type_AndroidViewView.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
      localLayoutParams.addRule(15, -1);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setTranslationY(blbz.a(17.0F));
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.a(-65536);
      }
    }
    for (;;)
    {
      d();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setVisibility(0);
      return;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.b(0);
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    int i = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.a();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "upScreenAnimation: currentOffset=" + i + " mAnimationDirection=" + a(this.jdField_a_of_type_Int));
      }
      if (this.jdField_a_of_type_Bkvt != null) {
        this.jdField_a_of_type_Bkvt.a(false, false);
      }
    }
    boolean bool1;
    label184:
    do
    {
      return;
      if (i < 0) {}
      for (bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DragAnimationMgr", 2, "upScreenAnimation: leftDirection=" + bool1 + " mAnimationDirection=" + a(this.jdField_a_of_type_Int));
        }
        if (!bool1) {
          break label184;
        }
        if (this.jdField_a_of_type_Int != 2) {
          break label211;
        }
        if (this.jdField_a_of_type_Bkvt == null) {
          break;
        }
        this.jdField_a_of_type_Bkvt.a(true, false);
        return;
      }
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
    } while (this.jdField_a_of_type_Bkvt == null);
    this.jdField_a_of_type_Bkvt.a(false, false);
    return;
    label211:
    int j = DragAnimationMgr.DragViewIcon.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon);
    float f1 = paramMotionEvent.getRawY();
    float f2 = Math.abs(f1 - this.jdField_a_of_type_Bkvu.jdField_c_of_type_Float);
    int k = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() / 2;
    if (QLog.isColorLevel()) {
      QLog.i("DragAnimationMgr", 2, "upScreenAnimation: currentY=" + f1 + " startY=" + this.jdField_a_of_type_Bkvu.jdField_c_of_type_Float + " moveYOffset=" + f2 + " parentHeightHalf=" + k);
    }
    boolean bool2 = bool3;
    if (j < this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.jdField_e_of_type_Int)
    {
      bool2 = bool3;
      if (f2 <= k) {
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DragAnimationMgr", 2, "upScreenAnimation: leftDirection=" + bool1 + " inRegion=" + bool2);
    }
    if (this.jdField_a_of_type_Bkvt != null) {
      this.jdField_a_of_type_Bkvt.a(bool1, bool2);
    }
    if (j <= 5)
    {
      a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon, i);
      return;
    }
    j = DragAnimationMgr.DragViewIcon.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon, i);
    a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon, i, j, new bkvr(this));
  }
  
  public static void c(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a(true, paramView, paramAnimatorListenerAdapter, -paramView.getHeight());
  }
  
  private void d()
  {
    int j = 0;
    int i = this.jdField_a_of_type_AndroidViewView.getLeft();
    int k = this.jdField_a_of_type_AndroidViewView.getWidth() / 2 + i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_Boolean)
      {
        j = (int)(blbz.a(40.0F) * 3.5F);
        i = j;
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.jdField_c_of_type_Int = j;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.jdField_d_of_type_Int = i;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.jdField_e_of_type_Int = ((int)this.jdField_a_of_type_Bkvu.jdField_a_of_type_Float);
      return;
      i = Math.abs(k - (this.c.getLeft() + this.c.getWidth() / 2));
      continue;
      j = Math.abs(k - (this.jdField_b_of_type_AndroidViewView.getLeft() + this.jdField_b_of_type_AndroidViewView.getWidth() / 2));
      i = 0;
      continue;
      i = this.c.getLeft();
      int n = this.c.getWidth() / 2;
      j = this.jdField_b_of_type_AndroidViewView.getLeft();
      int m = this.jdField_b_of_type_AndroidViewView.getWidth() / 2;
      i = Math.abs(k - (i + n));
      j = Math.abs(k - (m + j));
      continue;
      i = 0;
    }
  }
  
  public static void d(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    a(false, paramView, paramAnimatorListenerAdapter, -paramView.getHeight());
  }
  
  private void e()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.b(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setVisibility(8);
  }
  
  protected void a()
  {
    if (!this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean)
    {
      float f = Math.abs(this.jdField_a_of_type_Bkvu.f);
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchMoveUser: absMoveInter=" + f + " limit=" + bkvu.jdField_c_of_type_Int);
      }
      if (f > bkvu.jdField_c_of_type_Int) {
        this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean = false;
      }
    }
    int j;
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchMoveUser: [big] mAnimationDirection=" + this.jdField_a_of_type_Int + " xDiff=" + this.jdField_a_of_type_Bkvu.f);
      }
      if ((this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bkvt != null)) {
        this.jdField_a_of_type_Bkvt.c();
      }
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchMoveUser: hasMoved=" + this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean + " mAnimationDirection=" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean)
      {
        j = (int)(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.a() + this.jdField_a_of_type_Bkvu.f);
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          i = j;
        }
      }
      break;
    }
    for (;;)
    {
      if (Math.abs(i) >= bkvu.jdField_b_of_type_Int) {
        break label396;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.b(0);
      return;
      if (this.jdField_a_of_type_Bkvu.f <= 0.0F) {
        break;
      }
      this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean = true;
      break;
      if (this.jdField_a_of_type_Bkvu.f >= 0.0F) {
        break;
      }
      this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean = true;
      break;
      this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean = true;
      break;
      i = j;
      if (j < 0)
      {
        i = 0;
        continue;
        i = j;
        if (j > 0) {
          i = 0;
        }
      }
    }
    label396:
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.b(i);
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (!a()) {
      this.jdField_a_of_type_Int = i;
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    boolean bool = a();
    if (!bool) {
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchDown: valid=" + bool + " mAnimationDirection=" + this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Bkvu.jdField_b_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_a_of_type_Bkvu.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_a_of_type_Bkvu.jdField_d_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_a_of_type_Bkvu.jdField_e_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_a_of_type_Bkvu.h = paramMotionEvent.getRawX();
      this.jdField_a_of_type_Bkvu.i = paramMotionEvent.getRawY();
      this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bkvu.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Bkvu.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bkvu.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Bkvu.jdField_e_of_type_Int = 0;
      a(bkvu.jdField_a_of_type_Int);
      c();
      if (this.jdField_a_of_type_Bkvt != null) {
        this.jdField_a_of_type_Bkvt.a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("DragAnimationMgr", 2, "longTouchDown: hasMoved=" + this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean + " startX=" + this.jdField_a_of_type_Bkvu.jdField_b_of_type_Float);
  }
  
  public void a(ViewGroup paramViewGroup, View paramView1, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.c = paramView3;
    this.jdField_a_of_type_Int = 0;
    if (paramView2 == null)
    {
      if (paramView3 == null)
      {
        this.jdField_a_of_type_Int = -1;
        return;
      }
      this.jdField_a_of_type_Int = 2;
      return;
    }
    if (paramView3 == null)
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(bkvt parambkvt)
  {
    this.jdField_a_of_type_Bkvt = parambkvt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = a();
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchUp: valid=" + bool + " mAnimationDirection=" + this.jdField_a_of_type_Int);
      }
      return false;
    }
    c(paramMotionEvent);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.b(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.setVisibility(8);
    }
  }
  
  protected void b(MotionEvent paramMotionEvent)
  {
    boolean bool = a();
    if (!bool) {
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchDown: valid=" + bool + " mAnimationDirection=" + this.jdField_a_of_type_Int);
      }
    }
    label540:
    do
    {
      return;
      this.jdField_a_of_type_Bkvu.h = paramMotionEvent.getRawX();
      this.jdField_a_of_type_Bkvu.i = paramMotionEvent.getRawY();
      this.jdField_a_of_type_Bkvu.f = (this.jdField_a_of_type_Bkvu.h - this.jdField_a_of_type_Bkvu.jdField_d_of_type_Float);
      this.jdField_a_of_type_Bkvu.g = (this.jdField_a_of_type_Bkvu.i - this.jdField_a_of_type_Bkvu.jdField_e_of_type_Float);
      if (QLog.isColorLevel()) {
        QLog.i("DragAnimationMgr", 2, "longTouchDown: hasMoved=" + this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean + " startX=" + this.jdField_a_of_type_Bkvu.jdField_b_of_type_Float + "  xDiff=" + this.jdField_a_of_type_Bkvu.f + "  lastX=" + this.jdField_a_of_type_Bkvu.jdField_d_of_type_Float);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DragAnimationMgr", 2, "handleTouch hasCheckLong" + this.jdField_a_of_type_Bkvu.jdField_c_of_type_Boolean);
        }
        if (!this.jdField_a_of_type_Bkvu.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_Bkvu.jdField_c_of_type_Boolean = true;
          if (Math.abs(this.jdField_a_of_type_Bkvu.f) <= bkvu.jdField_d_of_type_Int) {
            break label540;
          }
        }
        for (this.jdField_a_of_type_Bkvu.jdField_b_of_type_Boolean = false;; this.jdField_a_of_type_Bkvu.jdField_b_of_type_Boolean = true)
        {
          if (this.jdField_a_of_type_Bkvt != null) {
            this.jdField_a_of_type_Bkvt.c(this.jdField_a_of_type_Bkvu.jdField_b_of_type_Boolean);
          }
          if (QLog.isColorLevel()) {
            QLog.i("DragAnimationMgr", 2, "handleTouch enableMoved" + this.jdField_a_of_type_Bkvu.jdField_b_of_type_Boolean);
          }
          if (QLog.isColorLevel()) {
            QLog.i("DragAnimationMgr", 2, "handleTouch enableMoved" + this.jdField_a_of_type_Bkvu.jdField_b_of_type_Boolean);
          }
          if (this.jdField_a_of_type_Bkvu.jdField_b_of_type_Boolean)
          {
            a();
            if (this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Bkvu.jdField_d_of_type_Float = this.jdField_a_of_type_Bkvu.h;
              this.jdField_a_of_type_Bkvu.jdField_e_of_type_Float = this.jdField_a_of_type_Bkvu.i;
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("DragAnimationMgr", 2, "handleTouch[Adsorption] xDiff=" + this.jdField_a_of_type_Bkvu.f + " currentX=" + this.jdField_a_of_type_Bkvu.h + " yDiff=" + this.jdField_a_of_type_Bkvu.g + " currentY=" + this.jdField_a_of_type_Bkvu.i);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("DragAnimationMgr", 2, "handleTouch mCaptureAnimationEnd=false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr
 * JD-Core Version:    0.7.0.1
 */