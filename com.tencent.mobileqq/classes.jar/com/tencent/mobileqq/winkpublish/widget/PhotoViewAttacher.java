package com.tencent.mobileqq.winkpublish.widget;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.CustomGestureDetector;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnDoubleTapListener;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnGestureListener;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnMatrixChangedListener;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnScaleChangedListener;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnSingleFlingListener;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnViewDragListener;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnViewTapListener;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.Util;
import com.tencent.qphone.base.util.QLog;

public class PhotoViewAttacher
  implements View.OnLayoutChangeListener, View.OnTouchListener
{
  private static float a = 7.0F;
  private static float b = 3.5F;
  private static float c = 1.75F;
  private static float d = 1.0F;
  private static float e = 0.6F;
  private static int f = 200;
  private static int g = 1;
  private OnSingleFlingListener A;
  private OnViewDragListener B;
  private PhotoViewAttacher.FlingRunnable C;
  private int D;
  private int E;
  private float F;
  private float G;
  private float H;
  private boolean I;
  private ImageView.ScaleType J;
  private OnGestureListener K;
  private Interpolator h;
  private int i;
  private float j;
  private float k;
  private boolean l;
  private boolean m;
  private ImageView n;
  private GestureDetector o;
  private CustomGestureDetector p;
  private final Matrix q;
  private final Matrix r;
  private final Matrix s;
  private final RectF t;
  private final float[] u;
  private OnMatrixChangedListener v;
  private OnViewTapListener w;
  private OnDoubleTapListener x;
  private View.OnLongClickListener y;
  private OnScaleChangedListener z;
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.u);
    return this.u[paramInt];
  }
  
  private int a(ImageView paramImageView)
  {
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private void a(Matrix paramMatrix)
  {
    this.n.setImageMatrix(paramMatrix);
    if (this.v != null)
    {
      paramMatrix = b(paramMatrix);
      if (paramMatrix != null) {
        this.v.a(paramMatrix);
      }
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    float f1 = a(this.n);
    float f2 = b(this.n);
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateBaseMatrix viewWidth:");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(" viewHeight:");
    ((StringBuilder)localObject).append(f2);
    ((StringBuilder)localObject).append(" drawableWidth:");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" drawableHeight:");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(" drawableHash:");
    ((StringBuilder)localObject).append(paramDrawable.hashCode());
    QLog.d("PhotoViewAttacher", 4, ((StringBuilder)localObject).toString());
    this.q.reset();
    float f3 = i1;
    float f5 = f1 / f3;
    float f4 = i2;
    float f6 = f2 / f4;
    if (this.J == ImageView.ScaleType.CENTER)
    {
      this.q.postTranslate((f1 - f3) / 2.0F, (f2 - f4) / 2.0F);
    }
    else if (this.J == ImageView.ScaleType.CENTER_CROP)
    {
      f5 = Math.max(f5, f6);
      this.q.postScale(f5, f5);
      this.q.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    }
    else if (this.J == ImageView.ScaleType.CENTER_INSIDE)
    {
      f5 = Math.min(1.0F, Math.min(f5, f6));
      this.q.postScale(f5, f5);
      this.q.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    }
    else
    {
      paramDrawable = new RectF(0.0F, 0.0F, f3, f4);
      localObject = new RectF(0.0F, 0.0F, f1, f2);
      if ((int)this.F % 180 != 0) {
        paramDrawable = new RectF(0.0F, 0.0F, f4, f3);
      }
      i1 = PhotoViewAttacher.4.a[this.J.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4) {
              this.q.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
            }
          }
          else {
            this.q.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          }
        }
        else {
          this.q.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
        }
      }
      else {
        this.q.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
      }
    }
    h();
  }
  
  private int b(ImageView paramImageView)
  {
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private RectF b(Matrix paramMatrix)
  {
    Drawable localDrawable = this.n.getDrawable();
    if (localDrawable != null)
    {
      this.t.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramMatrix.mapRect(this.t);
      return this.t;
    }
    return null;
  }
  
  private Matrix g()
  {
    this.r.set(this.q);
    this.r.postConcat(this.s);
    return this.r;
  }
  
  private void h()
  {
    this.s.reset();
    a(this.F);
    a(g());
    j();
  }
  
  private void i()
  {
    if (j()) {
      a(g());
    }
  }
  
  private boolean j()
  {
    RectF localRectF = b(g());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f4 = localRectF.width();
    float f2 = b(this.n);
    float f3 = 0.0F;
    int i1;
    if (f1 <= f2)
    {
      i1 = PhotoViewAttacher.4.a[this.J.ordinal()];
      if (i1 != 2)
      {
        if (i1 != 3) {
          f2 = (f2 - f1) / 2.0F;
        }
        for (f1 = localRectF.top;; f1 = localRectF.top)
        {
          f1 = f2 - f1;
          break;
          f2 -= f1;
        }
      }
      f1 = -localRectF.top;
      this.E = 2;
    }
    else if (localRectF.top > 0.0F)
    {
      this.E = 0;
      f1 = -localRectF.top;
    }
    else if (localRectF.bottom < f2)
    {
      this.E = 1;
      f1 = f2 - localRectF.bottom;
    }
    else
    {
      this.E = -1;
      f1 = 0.0F;
    }
    f2 = a(this.n);
    if (f4 <= f2)
    {
      i1 = PhotoViewAttacher.4.a[this.J.ordinal()];
      if (i1 != 2)
      {
        if (i1 != 3) {
          f3 = (f2 - f4) / 2.0F;
        }
        for (f2 = localRectF.left;; f2 = localRectF.left)
        {
          f2 = f3 - f2;
          break;
          f3 = f2 - f4;
        }
      }
      f2 = -localRectF.left;
      this.D = 2;
    }
    else if (localRectF.left > 0.0F)
    {
      this.D = 0;
      f2 = -localRectF.left;
    }
    else if (localRectF.right < f2)
    {
      f2 -= localRectF.right;
      this.D = 1;
    }
    else
    {
      this.D = -1;
      f2 = f3;
    }
    this.s.postTranslate(f2, f1);
    return true;
  }
  
  private void k()
  {
    PhotoViewAttacher.FlingRunnable localFlingRunnable = this.C;
    if (localFlingRunnable != null)
    {
      localFlingRunnable.a();
      this.C = null;
    }
  }
  
  public RectF a()
  {
    j();
    return b(g());
  }
  
  public void a(float paramFloat)
  {
    this.s.postRotate(paramFloat % 360.0F);
    i();
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.l) && (!this.p.a()) && (!this.m))
    {
      int i1;
      if ((Math.abs(paramFloat2) > 8.0F) && (Math.abs(paramFloat2) > Math.abs(paramFloat1))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2;
      if ((Math.abs(paramFloat1) > 8.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2))) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if ((i1 != 0) && (Math.abs(paramFloat2) * 0.6F > Math.abs(paramFloat1)))
      {
        i1 = this.E;
        if ((i1 == 2) || ((i1 == 0) && (paramFloat2 >= 8.0F)) || ((this.E == 1) && (paramFloat2 <= -8.0F)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedToDisAllowInterceptEvent vertical solp false mAllowParentInterceptOnEdge:");
          localStringBuilder.append(this.l);
          localStringBuilder.append(" isScaling:");
          localStringBuilder.append(this.p.a());
          localStringBuilder.append(" mBlockParentIntercept:");
          localStringBuilder.append(this.m);
          localStringBuilder.append(" getScale:");
          localStringBuilder.append(b());
          localStringBuilder.append(" mHorizontalScrollEdge:");
          localStringBuilder.append(this.D);
          localStringBuilder.append(" mVerticalScrollEdge:");
          localStringBuilder.append(this.E);
          localStringBuilder.append(" dx:");
          localStringBuilder.append(paramFloat1);
          localStringBuilder.append(" dy:");
          localStringBuilder.append(paramFloat2);
          QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
          return false;
        }
      }
      if ((i2 != 0) && (0.6F * Math.abs(paramFloat1) > Math.abs(paramFloat2)))
      {
        i1 = this.D;
        if ((i1 == 2) || ((i1 == 0) && (paramFloat1 >= 8.0F)) || ((this.D == 1) && (paramFloat1 <= -8.0F)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedToDisAllowInterceptEvent horizontal solp false mAllowParentInterceptOnEdge:");
          localStringBuilder.append(this.l);
          localStringBuilder.append(" isScaling:");
          localStringBuilder.append(this.p.a());
          localStringBuilder.append(" mBlockParentIntercept:");
          localStringBuilder.append(this.m);
          localStringBuilder.append(" getScale:");
          localStringBuilder.append(b());
          localStringBuilder.append(" mHorizontalScrollEdge:");
          localStringBuilder.append(this.D);
          localStringBuilder.append(" mVerticalScrollEdge:");
          localStringBuilder.append(this.E);
          localStringBuilder.append(" dx:");
          localStringBuilder.append(paramFloat1);
          localStringBuilder.append(" dy:");
          localStringBuilder.append(paramFloat2);
          QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
          return false;
        }
      }
      if (((this.E == 0) && (this.D == 0) && (paramFloat2 >= 8.0F) && (paramFloat1 >= 8.0F)) || ((this.E == 0) && (this.D == 1) && (paramFloat2 >= 8.0F) && (paramFloat1 <= -8.0F)) || ((this.E == 1) && (this.D == 0) && (paramFloat2 <= -8.0F) && (paramFloat1 >= 8.0F)) || ((this.E == 1) && (this.D == 1) && (paramFloat2 <= -8.0F) && (paramFloat1 <= -8.0F)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedToDisAllowInterceptEvent corner slop false mAllowParentInterceptOnEdge:");
        localStringBuilder.append(this.l);
        localStringBuilder.append(" isScaling:");
        localStringBuilder.append(this.p.a());
        localStringBuilder.append(" mBlockParentIntercept:");
        localStringBuilder.append(this.m);
        localStringBuilder.append(" getScale:");
        localStringBuilder.append(b());
        localStringBuilder.append(" mHorizontalScrollEdge:");
        localStringBuilder.append(this.D);
        localStringBuilder.append(" mVerticalScrollEdge:");
        localStringBuilder.append(this.E);
        localStringBuilder.append(" dx:");
        localStringBuilder.append(paramFloat1);
        localStringBuilder.append(" dy:");
        localStringBuilder.append(paramFloat2);
        QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNeedToDisAllowInterceptEvent default:true mAllowParentInterceptOnEdge:");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" isScaling:");
      localStringBuilder.append(this.p.a());
      localStringBuilder.append(" mBlockParentIntercept:");
      localStringBuilder.append(this.m);
      localStringBuilder.append(" getScale:");
      localStringBuilder.append(b());
      localStringBuilder.append(" mHorizontalScrollEdge:");
      localStringBuilder.append(this.D);
      localStringBuilder.append(" mVerticalScrollEdge:");
      localStringBuilder.append(this.E);
      localStringBuilder.append(" dx:");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(" dy:");
      localStringBuilder.append(paramFloat2);
      QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNeedToDisAllowInterceptEvent true mAllowParentInterceptOnEdge:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" isScaling:");
    localStringBuilder.append(this.p.a());
    localStringBuilder.append(" mBlockParentIntercept:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" getScale:");
    localStringBuilder.append(b());
    localStringBuilder.append(" mHorizontalScrollEdge:");
    localStringBuilder.append(this.D);
    localStringBuilder.append(" mVerticalScrollEdge:");
    localStringBuilder.append(this.E);
    localStringBuilder.append(" dx:");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" dy:");
    localStringBuilder.append(paramFloat2);
    QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
    return true;
  }
  
  public float b()
  {
    return (float)Math.sqrt((float)Math.pow(a(this.s, 0), 2.0D) + (float)Math.pow(a(this.s, 3), 2.0D));
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8)) {
      a(this.n.getDrawable());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool4 = this.I;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (bool4)
    {
      bool1 = bool2;
      if (Util.a((ImageView)paramView))
      {
        int i1 = paramMotionEvent.getAction();
        if (i1 != 0)
        {
          if ((i1 == 1) || (i1 == 3))
          {
            float f1;
            float f2;
            Object localObject;
            if (b() < this.j)
            {
              f1 = b();
              f2 = e;
              if (f1 < f2) {
                f1 = f2;
              }
              localObject = a();
              if (localObject == null) {
                break label469;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("postAnimationZoom minscale event:");
              localStringBuilder.append(paramMotionEvent.getAction());
              localStringBuilder.append(" scale:");
              localStringBuilder.append(b());
              localStringBuilder.append(" startScale:");
              localStringBuilder.append(f1);
              localStringBuilder.append(" mMinScale:");
              localStringBuilder.append(this.j);
              localStringBuilder.append(" rect:");
              localStringBuilder.append(((RectF)localObject).toString());
              QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
              paramView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, f1, this.j, ((RectF)localObject).centerX(), ((RectF)localObject).centerY()));
            }
            else
            {
              if (b() <= this.k) {
                break label469;
              }
              f1 = b();
              f2 = a;
              if (f1 > f2) {
                f1 = f2;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("postAnimationZoom maxscale event:");
              ((StringBuilder)localObject).append(paramMotionEvent.getAction());
              ((StringBuilder)localObject).append(" scale:");
              ((StringBuilder)localObject).append(b());
              ((StringBuilder)localObject).append(" startScale:");
              ((StringBuilder)localObject).append(f1);
              ((StringBuilder)localObject).append(" mMaxScale:");
              ((StringBuilder)localObject).append(this.k);
              ((StringBuilder)localObject).append(" scaleX:");
              ((StringBuilder)localObject).append(this.G);
              ((StringBuilder)localObject).append(" scaleY:");
              ((StringBuilder)localObject).append(this.H);
              QLog.d("PhotoViewAttacher", 4, ((StringBuilder)localObject).toString());
              paramView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, f1, this.k, this.G, this.H));
            }
            bool1 = true;
            break label472;
          }
        }
        else
        {
          paramView = paramView.getParent();
          if (paramView != null) {
            paramView.requestDisallowInterceptTouchEvent(true);
          }
          k();
        }
        label469:
        bool1 = false;
        label472:
        paramView = this.p;
        if (paramView != null)
        {
          boolean bool5 = paramView.a();
          boolean bool6 = this.p.b();
          bool4 = this.p.a(paramMotionEvent);
          if ((!bool5) && (!this.p.a())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if ((!bool6) && (!this.p.b())) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          i1 = paramMotionEvent.getPointerCount();
          if (((bool1) && (bool2)) || (i1 > 1)) {
            bool3 = true;
          }
          this.m = bool3;
          paramView = new StringBuilder();
          paramView.append("onTouch scaleDragDetector wasScaling:");
          paramView.append(bool5);
          paramView.append(" wasDragging:");
          paramView.append(bool6);
          paramView.append(" didntScale:");
          paramView.append(bool1);
          paramView.append(" didntDrag:");
          paramView.append(bool2);
          paramView.append(" mBlockParentIntercept:");
          paramView.append(this.m);
          QLog.d("PhotoViewAttacher", 4, paramView.toString());
          bool2 = bool4;
        }
        else
        {
          bool2 = bool1;
        }
        paramView = this.o;
        bool1 = bool2;
        if (paramView != null)
        {
          bool1 = bool2;
          if (paramView.onTouchEvent(paramMotionEvent)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.PhotoViewAttacher
 * JD-Core Version:    0.7.0.1
 */