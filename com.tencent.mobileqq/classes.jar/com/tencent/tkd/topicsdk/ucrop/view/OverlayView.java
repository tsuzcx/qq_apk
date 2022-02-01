package com.tencent.tkd.topicsdk.ucrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import com.tencent.tkd.topicsdk.ucrop.R.color;
import com.tencent.tkd.topicsdk.ucrop.R.dimen;
import com.tencent.tkd.topicsdk.ucrop.R.styleable;
import com.tencent.tkd.topicsdk.ucrop.callback.OverlayViewChangeListener;
import com.tencent.tkd.topicsdk.ucrop.util.RectUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/view/OverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "circleDimmedLayer", "", "getCircleDimmedLayer", "()Z", "setCircleDimmedLayer", "(Z)V", "value", "cropGridColumnCount", "getCropGridColumnCount", "()I", "setCropGridColumnCount", "(I)V", "cropGridRowCount", "getCropGridRowCount", "setCropGridRowCount", "cropViewRect", "Landroid/graphics/RectF;", "getCropViewRect", "()Landroid/graphics/RectF;", "mFreestyleCropMode", "freestyleCropMode", "getFreestyleCropMode", "setFreestyleCropMode", "gridPoints", "", "mCircularPath", "Landroid/graphics/Path;", "mCropFrameCornersPaint", "Landroid/graphics/Paint;", "mCropFramePaint", "mCropGridCenter", "mCropGridCorners", "mCropGridPaint", "mCropRectCornerTouchAreaLineLength", "mCropRectMinSize", "mCurrentTouchCornerIndex", "mDimmedColor", "getMDimmedColor", "setMDimmedColor", "mDimmedStrokePaint", "mFreestyleCropMode$annotations", "()V", "mPreviousTouchX", "", "mPreviousTouchY", "mShouldSetupCropBounds", "mTempRect", "mThisHeight", "mThisWidth", "mTouchPointThreshold", "overlayViewChangeListener", "Lcom/tencent/tkd/topicsdk/ucrop/callback/OverlayViewChangeListener;", "getOverlayViewChangeListener", "()Lcom/tencent/tkd/topicsdk/ucrop/callback/OverlayViewChangeListener;", "setOverlayViewChangeListener", "(Lcom/tencent/tkd/topicsdk/ucrop/callback/OverlayViewChangeListener;)V", "showCropFrame", "getShowCropFrame", "setShowCropFrame", "showCropGrid", "getShowCropGrid", "setShowCropGrid", "targetAspectRatio", "drawCanvasCropGrid", "", "canvas", "Landroid/graphics/Canvas;", "drawCanvasCropViewRect", "drawCropGrid", "drawDimmedLayer", "getCurrentTouchIndex", "touchX", "touchY", "init", "initCropFrameStyle", "a", "Landroid/content/res/TypedArray;", "initCropGridStyle", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "processStyledAttributes", "setCropFrameColor", "color", "setCropFrameStrokeWidth", "width", "setCropGridColor", "setCropGridCornerColor", "setCropGridStrokeWidth", "setTargetAspectRatio", "setupCropBounds", "updateCropViewRect", "updateGridPoints", "Companion", "FreestyleMode", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class OverlayView
  extends View
{
  public static final OverlayView.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  @NotNull
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  @Nullable
  private OverlayViewChangeListener jdField_a_of_type_ComTencentTkdTopicsdkUcropCallbackOverlayViewChangeListener;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private float jdField_b_of_type_Float = -1.0F;
  private int jdField_b_of_type_Int;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private float jdField_c_of_type_Float = -1.0F;
  @IntRange(from=0L)
  private int jdField_c_of_type_Int;
  private final Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
  private boolean jdField_c_of_type_Boolean;
  private float[] jdField_c_of_type_ArrayOfFloat;
  @IntRange(from=0L)
  private int jdField_d_of_type_Int;
  private final Paint jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
  private boolean jdField_d_of_type_Boolean;
  @ColorInt
  private int e;
  private int f;
  private int g = -1;
  private int h = getResources().getDimensionPixelSize(R.dimen.jdField_d_of_type_Int);
  private int i = getResources().getDimensionPixelSize(R.dimen.e);
  private int j = getResources().getDimensionPixelSize(R.dimen.jdField_c_of_type_Int);
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkUcropViewOverlayView$Companion = new OverlayView.Companion(null);
  }
  
  @JvmOverloads
  public OverlayView(@Nullable Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public OverlayView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public OverlayView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private final int a(float paramFloat1, float paramFloat2)
  {
    double d1 = this.h;
    int k = -1;
    int m = 0;
    while (m < 8)
    {
      double d2 = paramFloat1;
      float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      if (arrayOfFloat == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCropGridCorners");
      }
      double d3 = arrayOfFloat[m];
      Double.isNaN(d2);
      Double.isNaN(d3);
      d2 = Math.pow(d2 - d3, 2.0D);
      d3 = paramFloat2;
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      if (arrayOfFloat == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCropGridCorners");
      }
      double d4 = arrayOfFloat[(m + 1)];
      Double.isNaN(d3);
      Double.isNaN(d4);
      d3 = Math.sqrt(d2 + Math.pow(d3 - d4, 2.0D));
      d2 = d1;
      if (d3 < d1)
      {
        k = m / 2;
        d2 = d3;
      }
      m += 2;
      d1 = d2;
    }
    m = k;
    if (this.f == 1)
    {
      m = k;
      if (k < 0)
      {
        m = k;
        if (this.jdField_a_of_type_AndroidGraphicsRectF.contains(paramFloat1, paramFloat2)) {
          m = 4;
        }
      }
    }
    return m;
  }
  
  private final void a()
  {
    int k = this.jdField_a_of_type_Int;
    float f1 = k;
    float f2 = this.jdField_a_of_type_Float;
    int m = (int)(f1 / f2);
    int n = this.jdField_b_of_type_Int;
    if (m > n)
    {
      m = (int)(n * f2);
      k = (k - m) / 2;
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      f1 = getPaddingLeft();
      f2 = k;
      ((RectF)localObject).set(f1 + f2, getPaddingTop(), getPaddingLeft() + m + f2, getPaddingTop() + this.jdField_b_of_type_Int);
    }
    else
    {
      k = (n - m) / 2;
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      f1 = getPaddingLeft();
      f2 = getPaddingTop();
      float f3 = k;
      ((RectF)localObject).set(f1, f2 + f3, getPaddingLeft() + this.jdField_a_of_type_Int, getPaddingTop() + m + f3);
    }
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropCallbackOverlayViewChangeListener;
    if (localObject != null) {
      ((OverlayViewChangeListener)localObject).a(this.jdField_a_of_type_AndroidGraphicsRectF);
    }
    b();
  }
  
  private final void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    int k = this.g;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k == 4)
            {
              this.jdField_b_of_type_AndroidGraphicsRectF.offset(paramFloat1 - this.jdField_b_of_type_Float, paramFloat2 - this.jdField_c_of_type_Float);
              if ((this.jdField_b_of_type_AndroidGraphicsRectF.left > getLeft()) && (this.jdField_b_of_type_AndroidGraphicsRectF.top > getTop()) && (this.jdField_b_of_type_AndroidGraphicsRectF.right < getRight()) && (this.jdField_b_of_type_AndroidGraphicsRectF.bottom < getBottom()))
              {
                this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF);
                b();
                postInvalidate();
              }
            }
          }
          else {
            this.jdField_b_of_type_AndroidGraphicsRectF.set(paramFloat1, this.jdField_a_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.right, paramFloat2);
          }
        }
        else {
          this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top, paramFloat1, paramFloat2);
        }
      }
      else {
        this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left, paramFloat2, paramFloat1, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
      }
    }
    else {
      this.jdField_b_of_type_AndroidGraphicsRectF.set(paramFloat1, paramFloat2, this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    }
    paramFloat1 = this.jdField_b_of_type_AndroidGraphicsRectF.height();
    paramFloat2 = this.i;
    int m = 0;
    if (paramFloat1 >= paramFloat2) {
      k = 1;
    } else {
      k = 0;
    }
    if (this.jdField_b_of_type_AndroidGraphicsRectF.width() >= this.i) {
      m = 1;
    }
    RectF localRectF2 = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (m != 0) {
      paramFloat1 = this.jdField_b_of_type_AndroidGraphicsRectF.left;
    } else {
      paramFloat1 = localRectF2.left;
    }
    RectF localRectF1;
    if (k != 0) {
      localRectF1 = this.jdField_b_of_type_AndroidGraphicsRectF;
    } else {
      localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    }
    paramFloat2 = localRectF1.top;
    if (m != 0) {
      localRectF1 = this.jdField_b_of_type_AndroidGraphicsRectF;
    } else {
      localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    }
    float f1 = localRectF1.right;
    if (k != 0) {
      localRectF1 = this.jdField_b_of_type_AndroidGraphicsRectF;
    } else {
      localRectF1 = this.jdField_a_of_type_AndroidGraphicsRectF;
    }
    localRectF2.set(paramFloat1, paramFloat2, f1, localRectF1.bottom);
    if ((k != 0) || (m != 0))
    {
      b();
      postInvalidate();
    }
  }
  
  private final void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.jdField_c_of_type_Boolean) {
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.DIFFERENCE);
    } else {
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
    }
    paramCanvas.drawColor(this.e);
    paramCanvas.restore();
    if (this.jdField_c_of_type_Boolean) {
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height()) / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private final void b()
  {
    this.jdField_a_of_type_ArrayOfFloat = RectUtils.a(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_ArrayOfFloat = RectUtils.b(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_c_of_type_ArrayOfFloat = ((float[])null);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height()) / 2.0F, Path.Direction.CW);
  }
  
  private final void b(TypedArray paramTypedArray)
  {
    int k = paramTypedArray.getDimensionPixelSize(R.styleable.f, getResources().getDimensionPixelSize(R.dimen.jdField_a_of_type_Int));
    int m = paramTypedArray.getColor(R.styleable.e, getResources().getColor(R.color.jdField_a_of_type_Int));
    paramTypedArray = this.jdField_c_of_type_AndroidGraphicsPaint;
    float f1 = k;
    paramTypedArray.setStrokeWidth(f1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(m);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(f1 * 3);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(m);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  private final void b(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {
      c(paramCanvas);
    }
    if (this.jdField_b_of_type_Boolean) {
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    if (this.f != 0) {
      d(paramCanvas);
    }
  }
  
  private final void c()
  {
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  private final void c(TypedArray paramTypedArray)
  {
    int k = paramTypedArray.getDimensionPixelSize(R.styleable.j, getResources().getDimensionPixelSize(R.dimen.jdField_b_of_type_Int));
    int m = paramTypedArray.getColor(R.styleable.g, getResources().getColor(R.color.jdField_b_of_type_Int));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(k);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(m);
    setCropGridRowCount(paramTypedArray.getInt(R.styleable.i, 2));
    setCropGridColumnCount(paramTypedArray.getInt(R.styleable.h, 2));
  }
  
  private final void c(Canvas paramCanvas)
  {
    if ((this.jdField_c_of_type_ArrayOfFloat == null) && (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()))
    {
      int i1 = this.jdField_c_of_type_Int;
      arrayOfFloat = new float[i1 * 4 + this.jdField_d_of_type_Int * 4];
      int n = 0;
      int m = 0;
      int k = 0;
      float f1;
      while (m < i1)
      {
        f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height() * ((m + 1.0F) / (this.jdField_c_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.top;
        int i2 = k + 1;
        arrayOfFloat[k] = this.jdField_a_of_type_AndroidGraphicsRectF.left;
        k = i2 + 1;
        arrayOfFloat[i2] = f1;
        i2 = k + 1;
        arrayOfFloat[k] = this.jdField_a_of_type_AndroidGraphicsRectF.right;
        k = i2 + 1;
        arrayOfFloat[i2] = f1;
        m += 1;
      }
      i1 = this.jdField_d_of_type_Int;
      m = k;
      k = n;
      while (k < i1)
      {
        f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() * ((k + 1.0F) / (this.jdField_d_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.left;
        n = m + 1;
        arrayOfFloat[m] = f1;
        m = n + 1;
        arrayOfFloat[n] = this.jdField_a_of_type_AndroidGraphicsRectF.top;
        n = m + 1;
        arrayOfFloat[m] = f1;
        m = n + 1;
        arrayOfFloat[n] = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
        k += 1;
      }
      this.jdField_c_of_type_ArrayOfFloat = arrayOfFloat;
    }
    float[] arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
    if ((arrayOfFloat != null) && (arrayOfFloat != null)) {
      paramCanvas.drawLines(arrayOfFloat, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  private final void d(Canvas paramCanvas)
  {
    paramCanvas.save();
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    int k = this.j;
    localRectF.inset(k, -k);
    paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    k = this.j;
    localRectF.inset(-k, k);
    paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  @NotNull
  public final RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public final void a(@NotNull TypedArray paramTypedArray)
  {
    Intrinsics.checkParameterIsNotNull(paramTypedArray, "a");
    this.jdField_c_of_type_Boolean = paramTypedArray.getBoolean(R.styleable.jdField_c_of_type_Int, false);
    this.e = paramTypedArray.getColor(R.styleable.jdField_d_of_type_Int, getResources().getColor(R.color.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    b(paramTypedArray);
    this.jdField_b_of_type_Boolean = paramTypedArray.getBoolean(R.styleable.k, true);
    c(paramTypedArray);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(R.styleable.l, true);
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int k = getHeight();
      int m = getPaddingBottom();
      this.jdField_a_of_type_Int = (paramInt3 - paramInt4 - paramInt1);
      this.jdField_b_of_type_Int = (k - m - paramInt2);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        setTargetAspectRatio(this.jdField_a_of_type_Float);
      }
    }
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty())
    {
      if (this.f == 0) {
        return false;
      }
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      int k = paramMotionEvent.getAction();
      boolean bool = true;
      if ((k & 0xFF) == 0)
      {
        this.g = a(f2, f1);
        if (this.g == -1) {
          bool = false;
        }
        if (!bool)
        {
          this.jdField_b_of_type_Float = -1.0F;
          this.jdField_c_of_type_Float = -1.0F;
          return bool;
        }
        if (this.jdField_b_of_type_Float < 0)
        {
          this.jdField_b_of_type_Float = f2;
          this.jdField_c_of_type_Float = f1;
        }
        return bool;
      }
      if (((paramMotionEvent.getAction() & 0xFF) == 2) && (paramMotionEvent.getPointerCount() == 1) && (this.g != -1))
      {
        f2 = Math.min(Math.max(f2, getPaddingLeft()), getWidth() - getPaddingRight());
        f1 = Math.min(Math.max(f1, getPaddingTop()), getHeight() - getPaddingBottom());
        a(f2, f1);
        this.jdField_b_of_type_Float = f2;
        this.jdField_c_of_type_Float = f1;
        return true;
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 1)
      {
        this.jdField_b_of_type_Float = -1.0F;
        this.jdField_c_of_type_Float = -1.0F;
        this.g = -1;
        paramMotionEvent = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropCallbackOverlayViewChangeListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(this.jdField_a_of_type_AndroidGraphicsRectF);
        }
      }
    }
    return false;
  }
  
  public final void setCircleDimmedLayer(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final void setCropFrameColor(@ColorInt int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public final void setCropFrameStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt);
  }
  
  public final void setCropGridColor(@ColorInt int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public final void setCropGridColumnCount(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_c_of_type_ArrayOfFloat = ((float[])null);
  }
  
  public final void setCropGridCornerColor(@ColorInt int paramInt)
  {
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public final void setCropGridRowCount(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_ArrayOfFloat = ((float[])null);
  }
  
  public final void setCropGridStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt);
  }
  
  public final void setFreestyleCropMode(int paramInt)
  {
    this.f = paramInt;
    postInvalidate();
  }
  
  public final void setMDimmedColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void setOverlayViewChangeListener(@Nullable OverlayViewChangeListener paramOverlayViewChangeListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropCallbackOverlayViewChangeListener = paramOverlayViewChangeListener;
  }
  
  public final void setShowCropFrame(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final void setShowCropGrid(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void setTargetAspectRatio(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Int > 0)
    {
      a();
      postInvalidate();
      return;
    }
    this.jdField_d_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.OverlayView
 * JD-Core Version:    0.7.0.1
 */