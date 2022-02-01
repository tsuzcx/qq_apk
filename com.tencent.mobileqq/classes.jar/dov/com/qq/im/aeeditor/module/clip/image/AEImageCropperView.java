package dov.com.qq.im.aeeditor.module.clip.image;

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
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.R.styleable;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;

public class AEImageCropperView
  extends ImageView
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = -1;
  Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = null;
  public Bitmap a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  protected GestureDetector a;
  protected ScaleGestureDetector a;
  private AEEditorImageInfo jdField_a_of_type_DovComQqImAeeditorDataAEEditorImageInfo;
  private AEImageCropperView.GestureCallback jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView$GestureCallback;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean = true;
  private float jdField_f_of_type_Float;
  private boolean jdField_f_of_type_Boolean = false;
  private float jdField_g_of_type_Float;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  private boolean i = true;
  
  public AEImageCropperView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AEImageCropperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AEImageCropperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private float a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Int == 0) {
      return a(paramInt1, paramInt2, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    Rect localRect2 = AEImageCropperMask.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect(0, 0, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    if (paramInt1 * 1.0F / paramInt2 <= (localRect1.right - localRect1.left) * 1.0F / (localRect1.bottom - localRect1.top)) {
      return (localRect1.right - localRect1.left) * 1.0F / paramInt1;
    }
    return (localRect1.bottom - localRect1.top) * 1.0F / paramInt2;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt1 * 1.0F / paramInt2;
    float f2 = paramInt3 * 1.0F / paramInt4;
    if (f1 <= 0.3333333F) {
      return paramInt4 * 0.3333333F / paramInt1;
    }
    if (f1 >= 1.777778F) {
      return paramInt3 / 1.777778F / paramInt2;
    }
    if (f1 < f2) {
      return paramInt4 * 1.0F / paramInt2;
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
    localValueAnimator.addUpdateListener(new AEImageCropperView.3(this, localMatrix, paramFloat1, f1, paramFloat2, f2));
    localValueAnimator.addListener(new AEImageCropperView.4(this));
    localValueAnimator.start();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AEImageCropperView.1(this, paramFloat6, paramFloat5, paramFloat2, paramFloat1, paramFloat4, paramFloat3));
    localValueAnimator.addListener(new AEImageCropperView.2(this));
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
        paramAttributeSet.recycle();
      }
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new AEImageCropperView.GestureListener(this, null), null, true);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new AEImageCropperView.ScaleListener(this, null));
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      if (this.h) {
        AEQLog.d("AEImageCropperView", "Drawable is null. I can't fit anything");
      }
    }
    do
    {
      return;
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_d_of_type_Int != 0)) {
        break;
      }
    } while (!this.h);
    AEQLog.d("AEImageCropperView", "VideoFrame Dimension is 0. I'm quite boggled by it.");
    return;
    int j = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    setMinZoom(a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()));
    if (this.jdField_b_of_type_Int == 0)
    {
      j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      this.jdField_g_of_type_Float = a(j, k, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      paramDrawable = new Matrix();
      paramDrawable.setScale(this.jdField_g_of_type_Float, this.jdField_g_of_type_Float, j / 2.0F, k / 2.0F);
      paramDrawable.postTranslate((this.jdField_c_of_type_Int - j) / 2, (this.jdField_d_of_type_Int - k) / 2);
      setImageMatrix(paramDrawable);
      return;
    }
    float f1 = a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    paramDrawable = new Matrix();
    paramDrawable.setScale(f1, f1, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2.0F);
    paramDrawable.postTranslate((this.jdField_c_of_type_Int - j) / 2, (this.jdField_d_of_type_Int - k) / 2);
    setImageMatrix(paramDrawable);
  }
  
  private boolean a(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      AEQLog.d("AEImageCropperView", "Min zoom must be greater than 0");
      return false;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramFloat > this.jdField_b_of_type_Float))
    {
      AEQLog.d("AEImageCropperView", "Min zoom must not be greater than max zoom");
      this.jdField_b_of_type_Float = paramFloat;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Float = paramFloat;
    return true;
  }
  
  private boolean b()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f3 = a(localMatrix, 2);
    float f4 = a(localMatrix, 5);
    float f7 = a(localMatrix, 0);
    float f5 = a(localMatrix, 4);
    Rect localRect2 = AEImageCropperMask.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect(0, 0, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    float f6 = localDrawable.getIntrinsicWidth() * 1.0F / localDrawable.getIntrinsicHeight();
    float f8 = (localRect1.right - localRect1.left) * 1.0F / (localRect1.bottom - localRect1.top);
    if (this.h)
    {
      AEQLog.a("AEImageCropperView", "onUp( tx = " + f3 + ", ty = " + f4 + ")");
      AEQLog.a("AEImageCropperView", "onUp() - scale: " + f7);
      AEQLog.a("AEImageCropperView", "onUp() - min, max, base zoom: " + this.jdField_a_of_type_Float + ", " + this.jdField_b_of_type_Float + ", " + this.jdField_c_of_type_Float);
      AEQLog.a("AEImageCropperView", "onUp() - imageview size: " + this.jdField_c_of_type_Int + " " + this.jdField_d_of_type_Int);
      AEQLog.a("AEImageCropperView", "onUp() - drawable size: " + localDrawable.getIntrinsicWidth() + " " + localDrawable.getIntrinsicHeight());
      AEQLog.a("AEImageCropperView", "onUp() - scaled drawable size: " + localDrawable.getIntrinsicWidth() * f7 + " " + localDrawable.getIntrinsicHeight() * f5);
      AEQLog.a("AEImageCropperView", "onUp() - h diff: " + (localDrawable.getIntrinsicHeight() * f5 + f4 - getHeight()));
    }
    float f1;
    float f2;
    if ((f7 < this.jdField_a_of_type_Float) && (this.jdField_a_of_type_Float >= this.jdField_c_of_type_Float))
    {
      AEQLog.b("AEImageCropperView", "onUp(" + f7 + ", " + this.jdField_a_of_type_Float + ", " + this.jdField_c_of_type_Float + ") - 1 scaleX < mMinZoom && mMinZoom >= mBaseZoom");
      if (this.h) {
        AEQLog.a("AEImageCropperView", "onUp() - set scale to min zoom: " + this.jdField_a_of_type_Float);
      }
      f1 = this.jdField_c_of_type_Int / 2 - this.jdField_a_of_type_Float * localDrawable.getIntrinsicWidth() / 2.0F;
      f2 = this.jdField_d_of_type_Int / 2 - this.jdField_a_of_type_Float * localDrawable.getIntrinsicHeight() / 2.0F;
      if (f8 >= f6) {
        if (f4 >= localRect1.top)
        {
          f2 = localRect1.top;
          if (!a()) {
            break label816;
          }
          a(f3, f1, f4, f2, f7, this.jdField_a_of_type_Float);
        }
      }
      for (;;)
      {
        return true;
        if (localDrawable.getIntrinsicHeight() * f5 + f4 <= localRect1.bottom)
        {
          f2 = localRect1.bottom - this.jdField_a_of_type_Float * localDrawable.getIntrinsicHeight();
          break;
        }
        f2 = this.jdField_f_of_type_Float;
        f5 = this.jdField_a_of_type_Float / f5;
        f2 = this.jdField_f_of_type_Float + (f4 - f2) * f5;
        break;
        if (f3 >= 0.0F)
        {
          f1 = 0.0F;
          break;
        }
        if (localDrawable.getIntrinsicWidth() * f7 + f3 <= this.jdField_c_of_type_Int)
        {
          f1 = this.jdField_c_of_type_Int - this.jdField_a_of_type_Float * localDrawable.getIntrinsicWidth();
          break;
        }
        f1 = this.jdField_e_of_type_Float;
        f5 = this.jdField_a_of_type_Float / f7;
        f1 = this.jdField_e_of_type_Float + (f3 - f1) * f5;
        break;
        label816:
        localMatrix.reset();
        localMatrix.setScale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
        localMatrix.postTranslate(f1, f2);
        setImageMatrix(localMatrix);
        invalidate();
        if (this.h) {
          AEQLog.a("AEImageCropperView", "onUp() - scale after invalidate: " + a(localMatrix));
        }
      }
    }
    if ((f7 <= this.jdField_c_of_type_Float) || (f7 <= this.jdField_d_of_type_Float))
    {
      AEQLog.b("AEImageCropperView", "onUp(" + f7 + ", " + this.jdField_a_of_type_Float + ", " + this.jdField_c_of_type_Float + ") - 2 scaleX <= mBaseZoom || scaleX <= mBaseZoomBigger");
      int j = localDrawable.getIntrinsicHeight();
      int k = localDrawable.getIntrinsicWidth();
      if (f8 >= f6)
      {
        f2 = this.jdField_c_of_type_Int / 2 - k * f7 / 2.0F;
        if (f4 >= localRect1.top)
        {
          f1 = localRect1.top;
          if (!a()) {
            break label1196;
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
        if (localDrawable.getIntrinsicHeight() * f5 + f4 <= localRect1.bottom)
        {
          f1 = localRect1.bottom - localDrawable.getIntrinsicHeight() * f5;
          break;
        }
        f1 = f4;
        break;
        f5 = this.jdField_d_of_type_Int / 2 - j * f7 / 2.0F;
        if (f3 >= 0.0F)
        {
          f2 = 0.0F;
          f1 = f5;
          break;
        }
        f6 = this.jdField_c_of_type_Int - localDrawable.getIntrinsicWidth() * f7;
        f1 = f5;
        f2 = f6;
        if (f3 < f6) {
          break;
        }
        f2 = f3;
        f1 = f5;
        break;
        label1196:
        localMatrix.reset();
        localMatrix.postScale(f7, f7);
        localMatrix.postTranslate(f2, f1);
        setImageMatrix(localMatrix);
        invalidate();
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (f7 > this.jdField_b_of_type_Float))
    {
      AEQLog.b("AEImageCropperView", "onUp(" + f7 + ", " + this.jdField_a_of_type_Float + ", " + this.jdField_c_of_type_Float + ") - 3 isMaxZoomSet && scaleX > mMaxZoom");
      if (this.h)
      {
        AEQLog.a("AEImageCropperView", "onUp() - set to max zoom");
        AEQLog.a("AEImageCropperView", "onUp() - isMaxZoomSet: " + this.jdField_a_of_type_Boolean);
      }
      if (a()) {
        c();
      }
      for (;;)
      {
        return true;
        localMatrix.postScale(this.jdField_b_of_type_Float / f7, this.jdField_b_of_type_Float / f7, this.jdField_e_of_type_Float, this.jdField_f_of_type_Float);
        setImageMatrix(localMatrix);
        invalidate();
        c();
      }
    }
    if (this.h) {
      AEQLog.a("AEImageCropperView", "onUp() - adjust to sides");
    }
    c();
    return true;
  }
  
  private void c()
  {
    float f1 = a(getImageMatrix());
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AEImageCropperView.5(this, f1));
    localValueAnimator.addListener(new AEImageCropperView.6(this));
    localValueAnimator.start();
  }
  
  private boolean c()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return false;
    }
    Matrix localMatrix = getImageMatrix();
    float f3 = a(localMatrix, 2);
    float f4 = a(localMatrix, 5);
    float f5 = a(localMatrix, 0);
    float f1 = a(localMatrix, 4);
    Rect localRect2 = AEImageCropperMask.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect(0, 0, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    float f2;
    if (f4 >= localRect1.top)
    {
      f1 = localRect1.top;
      if (f3 < localRect1.left) {
        break label237;
      }
      f2 = localRect1.left;
    }
    for (;;)
    {
      if (!a()) {
        break label283;
      }
      localMatrix.reset();
      localMatrix.postScale(f5, f5);
      localMatrix.postTranslate(f3, f4);
      setImageMatrix(localMatrix);
      a(f2 - f3, f1 - f4);
      return false;
      if (localDrawable.getIntrinsicHeight() * f1 + f4 <= localRect1.bottom)
      {
        f1 = localRect1.bottom - f1 * localDrawable.getIntrinsicHeight();
        break;
      }
      f1 = f4;
      break;
      label237:
      if (localDrawable.getIntrinsicWidth() * f5 + f3 <= localRect1.right) {
        f2 = localRect1.right - localDrawable.getIntrinsicWidth() * f5;
      } else {
        f2 = f3;
      }
    }
    label283:
    localMatrix.reset();
    localMatrix.postScale(f5, f5);
    localMatrix.postTranslate(f2, f1);
    setImageMatrix(localMatrix);
    invalidate();
    return false;
  }
  
  public float a()
  {
    return this.jdField_g_of_type_Float;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
    return 0;
  }
  
  public Rect a()
  {
    double d1;
    int n;
    int m;
    int k;
    int j;
    if (this.jdField_b_of_type_AndroidGraphicsRect == null)
    {
      d1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 1.0F / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      if (d1 > 0.333333343267441D) {
        break label133;
      }
      n = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
      m = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
      k = AEImageCropperContainer.jdField_a_of_type_Int;
      j = this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(n, k, m, j);
      return this.jdField_b_of_type_AndroidGraphicsRect;
      label133:
      if (d1 >= 1.777777791023254D)
      {
        n = AEImageCropperContainer.jdField_a_of_type_Int;
        m = this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int;
        k = (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F);
        j = (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F);
      }
      else
      {
        n = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
        m = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
        k = (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F);
        j = (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_g_of_type_Boolean) {
      AEQLog.d("AEImageCropperView", "Cropping current bitmap. Can't perform this action right now.");
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = getDrawable();
    } while (localDrawable == null);
    a(localDrawable);
  }
  
  public void a(AEEditorImageInfo paramAEEditorImageInfo, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    paramAEEditorImageInfo.a = null;
    this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorImageInfo = paramAEEditorImageInfo;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    setImageBitmap(paramBitmap);
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
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    return 0;
  }
  
  public Rect b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      int j = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
      int k = (int)((this.jdField_c_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_g_of_type_Float) / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(j, (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F), k, (int)((this.jdField_d_of_type_Int + AEImageCropperContainer.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_g_of_type_Float) / 2.0F));
    }
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void b()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      AEQLog.d("AEImageCropperView", "Cropping current bitmap. Can't perform this action right now.");
      return;
    }
    setImageBitmap(null);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h) {
      AEQLog.a("AEImageCropperView", "onLayout: " + paramBoolean + " [" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + "]");
    }
    Drawable localDrawable;
    if (this.jdField_c_of_type_Boolean)
    {
      localDrawable = getDrawable();
      if (localDrawable != null) {
        break label125;
      }
      if (this.h) {
        AEQLog.d("AEImageCropperView", "drawable is null");
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
          AEQLog.d("AEImageCropperView", "min zoom is greater than max zoom. Changing min zoom = max zoom");
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
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      AEQLog.a("AEImageCropperView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      AEQLog.a("AEImageCropperView", "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    AEQLog.a("AEImageCropperView", "onTouchEvent(" + paramMotionEvent.getActionMasked() + ", " + paramMotionEvent.getAction() + ")");
    getParent().requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      AEQLog.a("AEImageCropperView", "onTouchEvent(MotionEvent.ACTION_DOWN)");
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView$GestureCallback != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView$GestureCallback.a();
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
    AEQLog.a("AEImageCropperView", "onTouchEvent(MotionEvent.ACTION_UP)");
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView$GestureCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView$GestureCallback.b();
    }
    return b();
  }
  
  public void setAEEditorImageInfo(AEEditorImageInfo paramAEEditorImageInfo)
  {
    this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorImageInfo = paramAEEditorImageInfo;
  }
  
  public void setDEBUG(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setGestureCallback(AEImageCropperView.GestureCallback paramGestureCallback)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperView$GestureCallback = paramGestureCallback;
  }
  
  public void setGestureEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (this.jdField_g_of_type_Boolean)
    {
      AEQLog.d("AEImageCropperView", "Cropping current bitmap. Can't set bitmap now");
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
      AEQLog.c("AEImageCropperView", "Bitmap size greater than 1280. This might cause memory issues");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    super.setImageBitmap(paramBitmap);
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorImageInfo.a != null) {
      setImageMatrix(this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorImageInfo.a);
    }
    for (;;)
    {
      requestLayout();
      return;
      a();
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      AEQLog.d("AEImageCropperView", "Max zoom must be greater than 0");
      return;
    }
    if ((this.jdField_a_of_type_Float > 0.0F) && (paramFloat < this.jdField_a_of_type_Float))
    {
      AEQLog.d("AEImageCropperView", "Max zoom must be greater than min zoom");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperView
 * JD-Core Version:    0.7.0.1
 */