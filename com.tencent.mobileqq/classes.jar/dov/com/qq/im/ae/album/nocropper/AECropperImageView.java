package dov.com.qq.im.ae.album.nocropper;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import blmz;
import blna;
import blnb;
import blnc;
import blnd;
import blne;
import blnf;
import blng;
import blnh;
import blnl;
import bmbx;
import com.tencent.mobileqq.R.styleable;

public class AECropperImageView
  extends ImageView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  public Animator.AnimatorListener a;
  public Bitmap a;
  protected GestureDetector a;
  protected ScaleGestureDetector a;
  private blnf jdField_a_of_type_Blnf;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  public AECropperImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
    a(paramContext, null);
  }
  
  public AECropperImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
    a(paramContext, paramAttributeSet);
  }
  
  public AECropperImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
    a(paramContext, paramAttributeSet);
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = paramInt1 * 1.0F / paramInt2;
    if (f1 <= 0.3333333F) {
      return paramInt3 / (paramInt1 / 0.3333333F);
    }
    if (f1 >= 1.777778F) {
      return paramInt3 / (paramInt2 * 1.777778F);
    }
    if (f1 < 1.0F) {
      return paramInt3 * 1.0F / paramInt2;
    }
    return paramInt3 * 1.0F / paramInt1;
  }
  
  private float a(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[paramInt];
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f2 = a(localMatrix, 5);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new blnb(this, localMatrix, paramFloat1, f1, paramFloat2, f2));
    localValueAnimator.addListener(new blnc(this));
    localValueAnimator.start();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new blmz(this, paramFloat6, paramFloat5, paramFloat2, paramFloat1, paramFloat4, paramFloat3));
    localValueAnimator.addListener(new blna(this));
    localValueAnimator.start();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AECropperImageView);
      if (paramAttributeSet != null)
      {
        this.jdField_a_of_type_Int = paramAttributeSet.getColor(2, this.jdField_a_of_type_Int);
        this.jdField_d_of_type_Boolean = paramAttributeSet.getBoolean(0, true);
        if (!paramAttributeSet.getBoolean(1, false)) {
          break label110;
        }
      }
    }
    label110:
    for (this.jdField_b_of_type_Int = 2;; this.jdField_b_of_type_Int = 1)
    {
      paramAttributeSet.recycle();
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new blng(this, null), null, true);
      this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new blnh(this, null));
      setScaleType(ImageView.ScaleType.MATRIX);
      return;
    }
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      if (this.h) {
        bmbx.d("AECropperImageView", "Drawable is null. I can't fit anything");
      }
    }
    do
    {
      return;
      if (paramInt != 0) {
        break;
      }
    } while (!this.h);
    bmbx.d("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
    return;
    this.jdField_b_of_type_Int = 1;
    int j = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    float f1 = b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), getWidth());
    paramDrawable = new Matrix();
    paramDrawable.setScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2.0F);
    paramDrawable.postTranslate((paramInt - j) / 2, (paramInt - k) / 2);
    setImageMatrix(paramDrawable);
  }
  
  private void a(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    if (paramDrawable == null) {
      if (this.h) {
        bmbx.d("AECropperImageView", "Drawable is null. I can't fit anything");
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
      } while (!this.h);
      bmbx.d("AECropperImageView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
      return;
      this.jdField_b_of_type_Int = 2;
      if (paramBoolean) {
        break;
      }
      j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f1 = a(j, k, getWidth());
      localMatrix = new Matrix();
      localMatrix.setScale(f1, f1, j / 2.0F, k / 2.0F);
      localMatrix.postTranslate((paramInt - j) / 2, (paramInt - k) / 2);
      setImageMatrix(localMatrix);
      f1 = a(localMatrix, 2);
      f2 = a(localMatrix, 5);
      f3 = a(localMatrix, 0);
    } while (f3 >= this.jdField_a_of_type_Float);
    a(f1, getWidth() / 2 - this.jdField_a_of_type_Float * paramDrawable.getIntrinsicWidth() / 2.0F, f2, getHeight() / 2 - this.jdField_a_of_type_Float * paramDrawable.getIntrinsicHeight() / 2.0F, f3, this.jdField_a_of_type_Float);
    return;
    int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    float f1 = a(j, k, getWidth());
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f1, f1, j / 2.0F, k / 2.0F);
    localMatrix.postTranslate((paramInt - j) / 2, (paramInt - k) / 2);
    float f2 = a(localMatrix, 2);
    float f3 = a(localMatrix, 5);
    float f4 = a(getImageMatrix(), 0);
    float f5 = getWidth() / 2;
    f5 = paramDrawable.getIntrinsicWidth() * f1 / 2.0F;
    f5 = getHeight() / 2;
    f5 = paramDrawable.getIntrinsicHeight() * f1 / 2.0F;
    a(f2, f2, f3, f3, f4, f1);
  }
  
  private boolean a(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      bmbx.d("AECropperImageView", "Min zoom must be greater than 0");
      return false;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramFloat > this.jdField_b_of_type_Float))
    {
      bmbx.d("AECropperImageView", "Min zoom must not be greater than max zoom");
      this.jdField_b_of_type_Float = paramFloat;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Float = paramFloat;
    return true;
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 * 1.0F / paramInt2 <= 1.0F) {
      return paramInt3 * 1.0F / paramInt1;
    }
    return paramInt3 * 1.0F / paramInt2;
  }
  
  private void b(Drawable paramDrawable, int paramInt)
  {
    a(paramDrawable, paramInt, false);
  }
  
  private boolean c()
  {
    float f1 = 0.0F;
    float f5 = 0.0F;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f3 = a(localMatrix, 2);
    float f4 = a(localMatrix, 5);
    float f7 = a(localMatrix, 0);
    float f6 = a(localMatrix, 4);
    if (this.h)
    {
      bmbx.a("AECropperImageView", "onUp( tx = " + f3 + ", ty = " + f4 + ")");
      bmbx.a("AECropperImageView", "onUp() - scale: " + f7);
      bmbx.a("AECropperImageView", "onUp() - min, max, base zoom: " + this.jdField_a_of_type_Float + ", " + this.jdField_b_of_type_Float + ", " + this.jdField_c_of_type_Float);
      bmbx.a("AECropperImageView", "onUp() - imageview size: " + getWidth() + " " + getHeight());
      bmbx.a("AECropperImageView", "onUp() - drawable size: " + localDrawable.getIntrinsicWidth() + " " + localDrawable.getIntrinsicHeight());
      bmbx.a("AECropperImageView", "onUp() - scaled drawable size: " + localDrawable.getIntrinsicWidth() * f7 + " " + localDrawable.getIntrinsicHeight() * f6);
      bmbx.a("AECropperImageView", "onUp() - h diff: " + (localDrawable.getIntrinsicHeight() * f6 + f4 - getHeight()));
    }
    float f2;
    if ((f7 < this.jdField_a_of_type_Float) && (this.jdField_a_of_type_Float >= this.jdField_c_of_type_Float))
    {
      bmbx.b("AECropperImageView", "onUp(" + f7 + ", " + this.jdField_a_of_type_Float + ", " + this.jdField_c_of_type_Float + ") - 1 scaleX < mMinZoom && mMinZoom >= mBaseZoom");
      if (this.h) {
        bmbx.a("AECropperImageView", "onUp() - set scale to min zoom: " + this.jdField_a_of_type_Float);
      }
      f2 = getWidth() / 2 - this.jdField_a_of_type_Float * localDrawable.getIntrinsicWidth() / 2.0F;
      f1 = getHeight() / 2 - this.jdField_a_of_type_Float * localDrawable.getIntrinsicHeight() / 2.0F;
      if (localDrawable.getIntrinsicHeight() > localDrawable.getIntrinsicWidth()) {
        if (f4 >= 0.0F)
        {
          f1 = f5;
          if (!a()) {
            break label718;
          }
          a(f3, f2, f4, f1, f7, this.jdField_a_of_type_Float);
        }
      }
      for (;;)
      {
        return true;
        if (localDrawable.getIntrinsicHeight() * f6 + f4 <= getHeight())
        {
          f1 = getHeight() - this.jdField_a_of_type_Float * localDrawable.getIntrinsicHeight();
          break;
        }
        f1 = this.jdField_f_of_type_Float;
        f5 = this.jdField_a_of_type_Float / f6;
        f1 = this.jdField_f_of_type_Float + (f4 - f1) * f5;
        break;
        if (f3 >= 0.0F)
        {
          f2 = 0.0F;
          break;
        }
        if (localDrawable.getIntrinsicWidth() * f7 + f3 <= getWidth())
        {
          f2 = getWidth() - this.jdField_a_of_type_Float * localDrawable.getIntrinsicWidth();
          break;
        }
        f2 = (f3 - this.jdField_e_of_type_Float) * (this.jdField_a_of_type_Float / f7) + this.jdField_e_of_type_Float;
        break;
        label718:
        localMatrix.reset();
        localMatrix.setScale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
        localMatrix.postTranslate(f2, f1);
        setImageMatrix(localMatrix);
        invalidate();
        if (this.h) {
          bmbx.a("AECropperImageView", "onUp() - scale after invalidate: " + a(localMatrix));
        }
      }
    }
    if ((f7 <= this.jdField_c_of_type_Float) || (f7 <= this.jdField_d_of_type_Float))
    {
      bmbx.b("AECropperImageView", "onUp(" + f7 + ", " + this.jdField_a_of_type_Float + ", " + this.jdField_c_of_type_Float + ") - 2 scaleX <= mBaseZoom || scaleX <= mBaseZoomBigger");
      int j = localDrawable.getIntrinsicHeight();
      int k = localDrawable.getIntrinsicWidth();
      if (j <= k)
      {
        f1 = getHeight() / 2 - j * f7 / 2.0F;
        if (f3 >= 0.0F)
        {
          f2 = 0.0F;
          if (!a()) {
            break label1066;
          }
          localMatrix.reset();
          localMatrix.postScale(f7, f7);
          localMatrix.postTranslate(f3, f4);
          setImageMatrix(localMatrix);
          a(f2 - f3, f1 - f4);
        }
      }
      for (;;)
      {
        return true;
        f2 = getWidth() - localDrawable.getIntrinsicWidth() * f7;
        if (f3 < f2) {
          break;
        }
        for (;;)
        {
          f2 = f3;
        }
        f5 = getWidth() / 2 - k * f7 / 2.0F;
        f2 = f5;
        if (f4 >= 0.0F) {
          break;
        }
        f6 = getHeight() - localDrawable.getIntrinsicHeight() * f6;
        f2 = f5;
        f1 = f6;
        if (f4 < f6) {
          break;
        }
        f1 = f4;
        f2 = f5;
        break;
        label1066:
        localMatrix.reset();
        localMatrix.postScale(f7, f7);
        localMatrix.postTranslate(f2, f1);
        setImageMatrix(localMatrix);
        invalidate();
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (f7 > this.jdField_b_of_type_Float))
    {
      bmbx.b("AECropperImageView", "onUp(" + f7 + ", " + this.jdField_a_of_type_Float + ", " + this.jdField_c_of_type_Float + ") - 3 isMaxZoomSet && scaleX > mMaxZoom");
      if (this.h)
      {
        bmbx.a("AECropperImageView", "onUp() - set to max zoom");
        bmbx.a("AECropperImageView", "onUp() - isMaxZoomSet: " + this.jdField_a_of_type_Boolean);
      }
      if (a()) {
        d();
      }
      for (;;)
      {
        return true;
        localMatrix.postScale(this.jdField_b_of_type_Float / f7, this.jdField_b_of_type_Float / f7, this.jdField_e_of_type_Float, this.jdField_f_of_type_Float);
        setImageMatrix(localMatrix);
        invalidate();
        d();
      }
    }
    if (this.h) {
      bmbx.a("AECropperImageView", "onUp() - adjust to sides");
    }
    d();
    return true;
  }
  
  private void d()
  {
    float f1 = a(getImageMatrix());
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new blnd(this, f1));
    localValueAnimator.addListener(new blne(this));
    localValueAnimator.start();
  }
  
  private boolean d()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    float f2 = 0.0F;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return bool2;
    }
    Matrix localMatrix = getImageMatrix();
    float f1 = a(localMatrix, 2);
    float f3 = a(localMatrix, 5);
    float f5 = a(localMatrix, 0);
    float f4 = a(localMatrix, 4);
    if (f1 > 0.0F)
    {
      f1 = -f1;
      bool1 = true;
      label74:
      if (f3 <= 0.0F) {
        break label151;
      }
      f2 = -f3;
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      if (!a()) {
        break label186;
      }
      a(f1, f2);
      return bool1;
      f5 = getWidth() - f5 * localDrawable.getIntrinsicWidth();
      if (f1 < f5)
      {
        f1 = f5 - f1;
        bool1 = true;
        break label74;
      }
      f1 = 0.0F;
      break label74;
      label151:
      f4 = getHeight() - localDrawable.getIntrinsicHeight() * f4;
      if (f3 < f4)
      {
        f2 = f4 - f3;
        bool1 = true;
      }
    }
    label186:
    localMatrix.postTranslate(f1, f2);
    setImageMatrix(localMatrix);
    invalidate();
    return bool1;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public blnl a()
  {
    boolean bool = true;
    int k = 0;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      bmbx.d("AECropperImageView", "original image is not available");
      return null;
    }
    Object localObject = getImageMatrix();
    float f4 = a((Matrix)localObject, 2);
    float f5 = a((Matrix)localObject, 5);
    float f1 = a((Matrix)localObject, 0);
    if (this.h)
    {
      bmbx.a("AECropperImageView", "xTrans: " + f4 + ", yTrans: " + f5 + " , scale: " + f1);
      bmbx.a("AECropperImageView", "old bitmap: " + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + " " + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    }
    int j;
    if ((f4 > 0.0F) && (f5 > 0.0F) && (f1 <= this.jdField_a_of_type_Float))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() > this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth())
      {
        j = 0;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() <= this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) {
          break label258;
        }
      }
      for (;;)
      {
        return blnl.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_Boolean, k, j, this.jdField_a_of_type_Int);
        j = (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / 2;
        break;
        label258:
        k = (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2;
      }
    }
    float f2 = -f5 / f1;
    float f6 = getHeight() / f1;
    float f3 = -f4 / f1;
    float f7 = getWidth() / f1;
    if (this.h)
    {
      bmbx.a("AECropperImageView", "cropY: " + f2);
      bmbx.a("AECropperImageView", "Y: " + f6);
      bmbx.a("AECropperImageView", "cropX: " + f3);
      bmbx.a("AECropperImageView", "X: " + f7);
    }
    label547:
    int m;
    if (f2 + f6 > this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight())
    {
      f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() - f6;
      f1 = f2;
      if (this.h)
      {
        bmbx.a("AECropperImageView", "readjust cropY to: " + f2);
        f1 = f2;
      }
      if (f3 + f7 <= this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) {
        break label708;
      }
      f3 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() - f7;
      f2 = f3;
      if (this.h)
      {
        bmbx.a("AECropperImageView", "readjust cropX to: " + f3);
        f2 = f3;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() <= this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) {
        break label788;
      }
      if (f4 < 0.0F) {
        break label753;
      }
      localObject = new Rect(0, (int)f1, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), (int)(f1 + f6));
      m = (int)((f6 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2.0F);
      k = 1;
      j = 0;
      label617:
      if ((k == 0) || ((m == 0) && (j == 0))) {
        break label879;
      }
      k = 1;
      label635:
      if ((!this.jdField_d_of_type_Boolean) || (k == 0)) {
        break label885;
      }
    }
    for (;;)
    {
      return blnl.a((Rect)localObject, bool, m, j, this.jdField_a_of_type_Int);
      f1 = f2;
      if (f2 >= 0.0F) {
        break;
      }
      if (this.h) {
        bmbx.a("AECropperImageView", "readjust cropY to: " + 0.0F);
      }
      f1 = 0.0F;
      break;
      label708:
      f2 = f3;
      if (f3 >= 0.0F) {
        break label547;
      }
      if (this.h) {
        bmbx.a("AECropperImageView", "readjust cropX to: " + 0.0F);
      }
      f2 = 0.0F;
      break label547;
      label753:
      localObject = new Rect((int)f2, (int)f1, (int)(f2 + f7), (int)(f1 + f6));
      k = 0;
      m = 0;
      j = 0;
      break label617;
      label788:
      if (f5 >= 0.0F)
      {
        localObject = new Rect((int)f2, 0, (int)(f2 + f7), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        j = (int)((f7 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / 2.0F);
        m = 0;
        k = 1;
        break label617;
      }
      localObject = new Rect((int)f2, (int)f1, (int)(f2 + f7), (int)(f1 + f6));
      k = 0;
      m = 0;
      j = 0;
      break label617;
      label879:
      k = 0;
      break label635;
      label885:
      bool = false;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      b();
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.g) {
      bmbx.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = getDrawable();
    } while (localDrawable == null);
    a(localDrawable, getWidth(), paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = getImageMatrix();
    localMatrix.postTranslate(-paramFloat1, -paramFloat2);
    setImageMatrix(localMatrix);
    invalidate();
    return true;
  }
  
  public float b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), getWidth());
    }
    return 0.0F;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
    return 0;
  }
  
  public void b()
  {
    if (this.g) {
      bmbx.d("AECropperImageView", "Cropping current bitmap. Can't perform this action right now.");
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = getDrawable();
    } while (localDrawable == null);
    a(localDrawable, getWidth());
  }
  
  public boolean b()
  {
    return this.i;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    return 0;
  }
  
  public void c()
  {
    a(false);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h) {
      bmbx.a("AECropperImageView", "onLayout: " + paramBoolean + " [" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + "]");
    }
    Drawable localDrawable;
    if (this.jdField_c_of_type_Boolean)
    {
      localDrawable = getDrawable();
      if (localDrawable != null) {
        break label125;
      }
      if (this.h) {
        bmbx.d("AECropperImageView", "drawable is null");
      }
    }
    return;
    label125:
    if (getResources().getConfiguration().orientation == 2) {
      this.jdField_c_of_type_Float = ((paramInt3 - paramInt1) / Math.max(localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth()));
    }
    for (this.jdField_d_of_type_Float = ((paramInt3 - paramInt1) / Math.min(localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth()));; this.jdField_d_of_type_Float = ((paramInt4 - paramInt2) / Math.min(localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth())))
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Float > this.jdField_b_of_type_Float))
      {
        this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
        this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
        if (this.jdField_a_of_type_Float > this.jdField_b_of_type_Float)
        {
          bmbx.d("AECropperImageView", "min zoom is greater than max zoom. Changing min zoom = max zoom");
          a(this.jdField_b_of_type_Float);
        }
      }
      if ((this.jdField_a_of_type_Float <= 0.0F) || (!this.jdField_b_of_type_Boolean)) {
        a(this.jdField_c_of_type_Float);
      }
      this.jdField_c_of_type_Boolean = false;
      return;
      this.jdField_c_of_type_Float = ((paramInt4 - paramInt2) / Math.max(localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth()));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = getContext().getResources().getConfiguration().orientation;
    if ((j == 1) || (j == 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      bmbx.a("AECropperImageView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.g)
    {
      bmbx.a("AECropperImageView", "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    bmbx.a("AECropperImageView", "onTouchEvent(" + paramMotionEvent.getActionMasked() + ", " + paramMotionEvent.getAction() + ")");
    getParent().requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      bmbx.a("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_DOWN)");
      if (this.jdField_a_of_type_Blnf != null) {
        this.jdField_a_of_type_Blnf.a();
      }
    }
    this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    }
    bmbx.a("AECropperImageView", "onTouchEvent(MotionEvent.ACTION_UP)");
    if (this.jdField_a_of_type_Blnf != null) {
      this.jdField_a_of_type_Blnf.b();
    }
    return c();
  }
  
  public void setDEBUG(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setGestureCallback(blnf paramblnf)
  {
    this.jdField_a_of_type_Blnf = paramblnf;
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.g)
    {
      bmbx.d("AECropperImageView", "Cropping current bitmap. Can't set bitmap now");
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      super.setImageBitmap(null);
      return;
    }
    if ((paramBitmap.getHeight() > 1280) || ((paramBitmap.getWidth() > 1280) && (this.h))) {
      bmbx.c("AECropperImageView", "Bitmap size greater than 1280. This might cause memory issues");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    setMinZoom(a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), getWidth()));
    super.setImageBitmap(paramBitmap);
    if (this.jdField_b_of_type_Int == 2) {
      b(getDrawable(), getWidth());
    }
    for (;;)
    {
      requestLayout();
      return;
      a(getDrawable(), getWidth());
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      bmbx.d("AECropperImageView", "Max zoom must be greater than 0");
      return;
    }
    if ((this.jdField_a_of_type_Float > 0.0F) && (paramFloat < this.jdField_a_of_type_Float))
    {
      bmbx.d("AECropperImageView", "Max zoom must be greater than min zoom");
      return;
    }
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setMinZoom(float paramFloat)
  {
    if (a(paramFloat)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void setShowAnimation(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.nocropper.AECropperImageView
 * JD-Core Version:    0.7.0.1
 */