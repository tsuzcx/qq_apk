package com.tencent.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import bkxo;
import blce;
import bldq;

class Gallery$FlingRunnable
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bldq jdField_a_of_type_Bldq;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  private float d;
  private float e;
  
  public Gallery$FlingRunnable(Gallery paramGallery)
  {
    this.jdField_a_of_type_Bldq = new bldq(paramGallery.getContext());
    this.jdField_a_of_type_Bldq.a(0.04F);
  }
  
  private float a(float paramFloat)
  {
    return bkxo.a(paramFloat);
  }
  
  private void a()
  {
    this.this$0.removeCallbacks(this);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bldq.a(true);
    this.jdField_a_of_type_Long = -1L;
    if (this.this$0.jdField_a_of_type_Blce != null) {
      this.this$0.jdField_a_of_type_Blce.b(this.this$0.mSelectedPosition);
    }
    if (this.this$0.j == 2)
    {
      this.this$0.b(this.this$0.mSelectedPosition, this.this$0.getChildAt(0), this.this$0);
      Gallery.b(this.this$0);
    }
    this.this$0.j = -1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bldq.a(paramInt1, 0, paramInt2, 0, -2147483648, 2147483647, 0, 0);
    return this.jdField_a_of_type_Bldq.d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    do
    {
      return;
      a();
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Bldq.a(0, 0, paramInt1, paramInt2, Gallery.b(this.this$0));
      this.this$0.post(this);
    } while (this.this$0.jdField_a_of_type_Blce == null);
    this.this$0.jdField_a_of_type_Blce.a(this.this$0.mSelectedPosition);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramFloat1 == paramFloat2) && (paramFloat3 == paramFloat4)) {
      return;
    }
    a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bldq.a(0, 0, paramInt1, paramInt2, Gallery.b(this.this$0));
    this.this$0.post(this);
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = (paramFloat2 - paramFloat1);
    this.e = (1.0F / Gallery.b(this.this$0));
    this.c = paramFloat3;
    this.d = (paramFloat4 - paramFloat3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    if (AnimationUtils.currentAnimationTimeMillis() - this.this$0.jdField_a_of_type_Long > 15L) {
      this.jdField_a_of_type_Bldq.a(this.this$0.jdField_a_of_type_Long + 15L, 0, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Gallery.a(this.this$0), Gallery.a(this.this$0));
    }
    for (;;)
    {
      this.this$0.post(this);
      if (this.this$0.jdField_a_of_type_Blce == null) {
        break;
      }
      this.this$0.jdField_a_of_type_Blce.a(this.this$0.mSelectedPosition);
      return;
      this.jdField_a_of_type_Bldq.a(0, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Gallery.a(this.this$0), Gallery.a(this.this$0));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.this$0.removeCallbacks(this);
    b(paramBoolean);
  }
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.this$0.mItemCount == 0)
    {
      b(true);
      return;
    }
    Gallery.b(this.this$0, false);
    Object localObject = this.jdField_a_of_type_Bldq;
    boolean bool = ((bldq)localObject).b();
    int i = ((bldq)localObject).a();
    int j = ((bldq)localObject).b();
    int k = this.jdField_a_of_type_Int;
    int m = this.jdField_b_of_type_Int;
    float f2;
    float f3;
    if (this.jdField_a_of_type_Long >= 0L)
    {
      int n = (int)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
      if (n >= Gallery.b(this.this$0)) {
        break label273;
      }
      f1 = a(n * this.e);
      f2 = this.jdField_a_of_type_Float + this.jdField_b_of_type_Float * f1;
      f3 = this.c;
    }
    for (float f1 = f1 * this.d + f3;; f1 = this.c + this.d)
    {
      Gallery.a(this.this$0, this.this$0.jdField_a_of_type_AndroidViewView, f2);
      Gallery.b(this.this$0, this.this$0.jdField_a_of_type_AndroidViewView, f1);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.this$0.a(i - k, j - m, false);
      if ((!bool) || (Gallery.a(this.this$0))) {
        break label298;
      }
      this.jdField_a_of_type_Int = i;
      this.jdField_b_of_type_Int = j;
      this.this$0.post(this);
      if ((this.this$0.j != 1) || (!this.this$0.a())) {
        break;
      }
      this.this$0.a(true, 1);
      return;
      label273:
      f1 = this.jdField_a_of_type_Float;
      f2 = this.jdField_b_of_type_Float + f1;
    }
    label298:
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.this$0.a())
      {
        f1 = 1.0F;
        if (this.this$0.jdField_a_of_type_AndroidViewView.getTag(2131296385) != null) {
          f1 = ((Float)this.this$0.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
        }
        f2 = this.this$0.a(this.this$0.jdField_a_of_type_AndroidViewView);
        localObject = this.this$0;
        if (f2 - f1 <= 1.E-005D) {
          break label404;
        }
        bool = true;
        Gallery.a((Gallery)localObject, bool);
      }
    }
    for (;;)
    {
      b(false);
      return;
      label404:
      bool = false;
      break;
      if (this.this$0.j == 1)
      {
        this.this$0.k = 0;
        if (this.this$0.a()) {
          Gallery.a(this.this$0, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.Gallery.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */