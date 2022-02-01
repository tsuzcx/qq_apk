package com.tencent.mobileqq.winkpublish.widget.multitouchimg;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
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
  private OnDoubleTapListener A;
  private View.OnLongClickListener B;
  private OnScaleBeginListener C;
  private OnScaleEndListener D;
  private OnScaleChangedListener E;
  private OnSingleFlingListener F;
  private OnViewDragListener G;
  private PhotoViewAttacher.FlingRunnable H;
  private int I = 2;
  private int J = 2;
  private float K;
  private float L;
  private float M;
  private boolean N = true;
  private ImageView.ScaleType O = ImageView.ScaleType.FIT_CENTER;
  private OnGestureListener P = new PhotoViewAttacher.1(this);
  private Interpolator h = new AccelerateDecelerateInterpolator();
  private int i = f;
  private float j = d;
  private float k = c;
  private float l = b;
  private boolean m = true;
  private boolean n = false;
  private ImageView o;
  private GestureDetector p;
  private CustomGestureDetector q;
  private final Matrix r = new Matrix();
  private final Matrix s = new Matrix();
  private final Matrix t = new Matrix();
  private final RectF u = new RectF();
  private final float[] v = new float[9];
  private OnMatrixChangedListener w;
  private OnPhotoTapListener x;
  private OnOutsidePhotoTapListener y;
  private OnViewTapListener z;
  
  public PhotoViewAttacher(ImageView paramImageView)
  {
    this.o = paramImageView;
    paramImageView.setOnTouchListener(this);
    paramImageView.addOnLayoutChangeListener(this);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.K = 0.0F;
    this.q = new CustomGestureDetector(paramImageView.getContext(), this.P);
    this.p = new GestureDetector(paramImageView.getContext(), new PhotoViewAttacher.2(this));
    this.p.setOnDoubleTapListener(new PhotoViewAttacher.3(this));
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.v);
    return this.v[paramInt];
  }
  
  private int a(ImageView paramImageView)
  {
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private void a(Matrix paramMatrix)
  {
    this.o.setImageMatrix(paramMatrix);
    if (this.w != null)
    {
      paramMatrix = b(paramMatrix);
      if (paramMatrix != null) {
        this.w.a(paramMatrix);
      }
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    float f1 = a(this.o);
    float f2 = b(this.o);
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
    this.r.reset();
    float f3 = i1;
    float f5 = f1 / f3;
    float f4 = i2;
    float f6 = f2 / f4;
    if (this.O == ImageView.ScaleType.CENTER)
    {
      this.r.postTranslate((f1 - f3) / 2.0F, (f2 - f4) / 2.0F);
    }
    else if (this.O == ImageView.ScaleType.CENTER_CROP)
    {
      f5 = Math.max(f5, f6);
      this.r.postScale(f5, f5);
      this.r.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    }
    else if (this.O == ImageView.ScaleType.CENTER_INSIDE)
    {
      f5 = Math.min(1.0F, Math.min(f5, f6));
      this.r.postScale(f5, f5);
      this.r.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    }
    else
    {
      paramDrawable = new RectF(0.0F, 0.0F, f3, f4);
      localObject = new RectF(0.0F, 0.0F, f1, f2);
      if ((int)this.K % 180 != 0) {
        paramDrawable = new RectF(0.0F, 0.0F, f4, f3);
      }
      i1 = PhotoViewAttacher.4.a[this.O.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4) {
              this.r.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
            }
          }
          else {
            this.r.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          }
        }
        else {
          this.r.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
        }
      }
      else {
        this.r.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
      }
    }
    n();
  }
  
  private int b(ImageView paramImageView)
  {
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private RectF b(Matrix paramMatrix)
  {
    Drawable localDrawable = this.o.getDrawable();
    if (localDrawable != null)
    {
      this.u.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramMatrix.mapRect(this.u);
      return this.u;
    }
    return null;
  }
  
  private Matrix m()
  {
    this.s.set(this.r);
    this.s.postConcat(this.t);
    return this.s;
  }
  
  private void n()
  {
    this.t.reset();
    b(this.K);
    a(m());
    p();
  }
  
  private void o()
  {
    if (p()) {
      a(m());
    }
  }
  
  private boolean p()
  {
    RectF localRectF = b(m());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f4 = localRectF.width();
    float f2 = b(this.o);
    float f3 = 0.0F;
    int i1;
    if (f1 <= f2)
    {
      i1 = PhotoViewAttacher.4.a[this.O.ordinal()];
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
      this.J = 2;
    }
    else if (localRectF.top > 0.0F)
    {
      this.J = 0;
      f1 = -localRectF.top;
    }
    else if (localRectF.bottom < f2)
    {
      this.J = 1;
      f1 = f2 - localRectF.bottom;
    }
    else
    {
      this.J = -1;
      f1 = 0.0F;
    }
    f2 = a(this.o);
    if (f4 <= f2)
    {
      i1 = PhotoViewAttacher.4.a[this.O.ordinal()];
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
      this.I = 2;
    }
    else if (localRectF.left > 0.0F)
    {
      this.I = 0;
      f2 = -localRectF.left;
    }
    else if (localRectF.right < f2)
    {
      f2 -= localRectF.right;
      this.I = 1;
    }
    else
    {
      this.I = -1;
      f2 = f3;
    }
    this.t.postTranslate(f2, f1);
    return true;
  }
  
  private void q()
  {
    PhotoViewAttacher.FlingRunnable localFlingRunnable = this.H;
    if (localFlingRunnable != null)
    {
      localFlingRunnable.a();
      this.H = null;
    }
  }
  
  public RectF a()
  {
    p();
    return b(m());
  }
  
  public void a(float paramFloat)
  {
    this.t.setRotate(paramFloat % 360.0F);
    o();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Util.a(paramFloat1, paramFloat2, paramFloat3);
    this.j = paramFloat1;
    this.k = paramFloat2;
    this.l = paramFloat3;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if ((paramFloat1 >= this.j) && (paramFloat1 <= this.l))
    {
      if (paramBoolean)
      {
        this.o.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, e(), paramFloat1, paramFloat2, paramFloat3));
        return;
      }
      this.t.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      o();
      return;
    }
    throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    a(paramFloat, this.o.getRight() / 2, this.o.getBottom() / 2, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.p.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  public void a(View.OnClickListener paramOnClickListener) {}
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.B = paramOnLongClickListener;
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    if ((Util.a(paramScaleType)) && (paramScaleType != this.O))
    {
      this.O = paramScaleType;
      g();
    }
  }
  
  public void a(OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.A = paramOnDoubleTapListener;
  }
  
  public void a(OnMatrixChangedListener paramOnMatrixChangedListener)
  {
    this.w = paramOnMatrixChangedListener;
  }
  
  public void a(OnOutsidePhotoTapListener paramOnOutsidePhotoTapListener)
  {
    this.y = paramOnOutsidePhotoTapListener;
  }
  
  public void a(OnPhotoTapListener paramOnPhotoTapListener)
  {
    this.x = paramOnPhotoTapListener;
  }
  
  public void a(OnScaleBeginListener paramOnScaleBeginListener)
  {
    this.C = paramOnScaleBeginListener;
    CustomGestureDetector localCustomGestureDetector = this.q;
    if (localCustomGestureDetector != null) {
      localCustomGestureDetector.a(paramOnScaleBeginListener);
    }
  }
  
  public void a(OnScaleChangedListener paramOnScaleChangedListener)
  {
    this.E = paramOnScaleChangedListener;
  }
  
  public void a(OnScaleEndListener paramOnScaleEndListener)
  {
    this.D = paramOnScaleEndListener;
    CustomGestureDetector localCustomGestureDetector = this.q;
    if (localCustomGestureDetector != null) {
      localCustomGestureDetector.a(paramOnScaleEndListener);
    }
  }
  
  public void a(OnSingleFlingListener paramOnSingleFlingListener)
  {
    this.F = paramOnSingleFlingListener;
  }
  
  public void a(OnViewDragListener paramOnViewDragListener)
  {
    this.G = paramOnViewDragListener;
  }
  
  public void a(OnViewTapListener paramOnViewTapListener)
  {
    this.z = paramOnViewTapListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.m) && (!this.q.a()) && (!this.n))
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
        i1 = this.J;
        if ((i1 == 2) || ((i1 == 0) && (paramFloat2 >= 8.0F)) || ((this.J == 1) && (paramFloat2 <= -8.0F)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedToDisAllowInterceptEvent vertical solp false mAllowParentInterceptOnEdge:");
          localStringBuilder.append(this.m);
          localStringBuilder.append(" isScaling:");
          localStringBuilder.append(this.q.a());
          localStringBuilder.append(" mBlockParentIntercept:");
          localStringBuilder.append(this.n);
          localStringBuilder.append(" getScale:");
          localStringBuilder.append(e());
          localStringBuilder.append(" mHorizontalScrollEdge:");
          localStringBuilder.append(this.I);
          localStringBuilder.append(" mVerticalScrollEdge:");
          localStringBuilder.append(this.J);
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
        i1 = this.I;
        if ((i1 == 2) || ((i1 == 0) && (paramFloat1 >= 8.0F)) || ((this.I == 1) && (paramFloat1 <= -8.0F)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNeedToDisAllowInterceptEvent horizontal solp false mAllowParentInterceptOnEdge:");
          localStringBuilder.append(this.m);
          localStringBuilder.append(" isScaling:");
          localStringBuilder.append(this.q.a());
          localStringBuilder.append(" mBlockParentIntercept:");
          localStringBuilder.append(this.n);
          localStringBuilder.append(" getScale:");
          localStringBuilder.append(e());
          localStringBuilder.append(" mHorizontalScrollEdge:");
          localStringBuilder.append(this.I);
          localStringBuilder.append(" mVerticalScrollEdge:");
          localStringBuilder.append(this.J);
          localStringBuilder.append(" dx:");
          localStringBuilder.append(paramFloat1);
          localStringBuilder.append(" dy:");
          localStringBuilder.append(paramFloat2);
          QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
          return false;
        }
      }
      if (((this.J == 0) && (this.I == 0) && (paramFloat2 >= 8.0F) && (paramFloat1 >= 8.0F)) || ((this.J == 0) && (this.I == 1) && (paramFloat2 >= 8.0F) && (paramFloat1 <= -8.0F)) || ((this.J == 1) && (this.I == 0) && (paramFloat2 <= -8.0F) && (paramFloat1 >= 8.0F)) || ((this.J == 1) && (this.I == 1) && (paramFloat2 <= -8.0F) && (paramFloat1 <= -8.0F)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedToDisAllowInterceptEvent corner slop false mAllowParentInterceptOnEdge:");
        localStringBuilder.append(this.m);
        localStringBuilder.append(" isScaling:");
        localStringBuilder.append(this.q.a());
        localStringBuilder.append(" mBlockParentIntercept:");
        localStringBuilder.append(this.n);
        localStringBuilder.append(" getScale:");
        localStringBuilder.append(e());
        localStringBuilder.append(" mHorizontalScrollEdge:");
        localStringBuilder.append(this.I);
        localStringBuilder.append(" mVerticalScrollEdge:");
        localStringBuilder.append(this.J);
        localStringBuilder.append(" dx:");
        localStringBuilder.append(paramFloat1);
        localStringBuilder.append(" dy:");
        localStringBuilder.append(paramFloat2);
        QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNeedToDisAllowInterceptEvent default:true mAllowParentInterceptOnEdge:");
      localStringBuilder.append(this.m);
      localStringBuilder.append(" isScaling:");
      localStringBuilder.append(this.q.a());
      localStringBuilder.append(" mBlockParentIntercept:");
      localStringBuilder.append(this.n);
      localStringBuilder.append(" getScale:");
      localStringBuilder.append(e());
      localStringBuilder.append(" mHorizontalScrollEdge:");
      localStringBuilder.append(this.I);
      localStringBuilder.append(" mVerticalScrollEdge:");
      localStringBuilder.append(this.J);
      localStringBuilder.append(" dx:");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(" dy:");
      localStringBuilder.append(paramFloat2);
      QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNeedToDisAllowInterceptEvent true mAllowParentInterceptOnEdge:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" isScaling:");
    localStringBuilder.append(this.q.a());
    localStringBuilder.append(" mBlockParentIntercept:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" getScale:");
    localStringBuilder.append(e());
    localStringBuilder.append(" mHorizontalScrollEdge:");
    localStringBuilder.append(this.I);
    localStringBuilder.append(" mVerticalScrollEdge:");
    localStringBuilder.append(this.J);
    localStringBuilder.append(" dx:");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" dy:");
    localStringBuilder.append(paramFloat2);
    QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
    return true;
  }
  
  public float b()
  {
    return this.j;
  }
  
  public void b(float paramFloat)
  {
    this.t.postRotate(paramFloat % 360.0F);
    o();
  }
  
  public void b(boolean paramBoolean)
  {
    this.N = paramBoolean;
    g();
  }
  
  public float c()
  {
    return this.k;
  }
  
  public void c(float paramFloat)
  {
    Util.a(paramFloat, this.k, this.l);
    this.j = paramFloat;
  }
  
  public float d()
  {
    return this.l;
  }
  
  public void d(float paramFloat)
  {
    Util.a(this.j, paramFloat, this.l);
    this.k = paramFloat;
  }
  
  public float e()
  {
    return (float)Math.sqrt((float)Math.pow(a(this.t, 0), 2.0D) + (float)Math.pow(a(this.t, 3), 2.0D));
  }
  
  public void e(float paramFloat)
  {
    Util.a(this.j, this.k, paramFloat);
    this.l = paramFloat;
  }
  
  public ImageView.ScaleType f()
  {
    return this.O;
  }
  
  public void f(float paramFloat)
  {
    a(paramFloat, false);
  }
  
  public void g()
  {
    if (this.N)
    {
      a(this.o.getDrawable());
      return;
    }
    n();
  }
  
  public Matrix h()
  {
    return this.s;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8)) {
      a(this.o.getDrawable());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool4 = this.N;
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
            if (e() < this.j)
            {
              f1 = e();
              f2 = e;
              if (f1 < f2) {
                f1 = f2;
              }
              localObject = a();
              if (localObject == null) {
                break label471;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("postAnimationZoom minscale event:");
              localStringBuilder.append(paramMotionEvent.getAction());
              localStringBuilder.append(" scale:");
              localStringBuilder.append(e());
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
              if (e() <= this.l) {
                break label471;
              }
              f1 = e();
              f2 = a;
              if (f1 > f2) {
                f1 = f2;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("postAnimationZoom maxscale event:");
              ((StringBuilder)localObject).append(paramMotionEvent.getAction());
              ((StringBuilder)localObject).append(" scale:");
              ((StringBuilder)localObject).append(e());
              ((StringBuilder)localObject).append(" startScale:");
              ((StringBuilder)localObject).append(f1);
              ((StringBuilder)localObject).append(" mMaxScale:");
              ((StringBuilder)localObject).append(this.l);
              ((StringBuilder)localObject).append(" scaleX:");
              ((StringBuilder)localObject).append(this.L);
              ((StringBuilder)localObject).append(" scaleY:");
              ((StringBuilder)localObject).append(this.M);
              QLog.d("PhotoViewAttacher", 4, ((StringBuilder)localObject).toString());
              paramView.post(new PhotoViewAttacher.AnimatedZoomRunnable(this, f1, this.l, this.L, this.M));
            }
            bool1 = true;
            break label474;
          }
        }
        else
        {
          paramView = paramView.getParent();
          if (paramView != null) {
            paramView.requestDisallowInterceptTouchEvent(true);
          }
          q();
        }
        label471:
        bool1 = false;
        label474:
        paramView = this.q;
        if (paramView != null)
        {
          boolean bool5 = paramView.a();
          boolean bool6 = this.q.b();
          bool4 = this.q.a(paramMotionEvent);
          if ((!bool5) && (!this.q.a())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if ((!bool6) && (!this.q.b())) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          i1 = paramMotionEvent.getPointerCount();
          if (((bool1) && (bool2)) || (i1 > 1)) {
            bool3 = true;
          }
          this.n = bool3;
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
          paramView.append(this.n);
          QLog.d("PhotoViewAttacher", 4, paramView.toString());
          bool2 = bool4;
        }
        else
        {
          bool2 = bool1;
        }
        paramView = this.p;
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
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.multitouchimg.PhotoViewAttacher
 * JD-Core Version:    0.7.0.1
 */