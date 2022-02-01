package com.tencent.mobileqq.kandian.base.imagecrop;

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
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.kandian.base.imagecrop.callback.OverlayViewChangeListener;
import com.tencent.mobileqq.kandian.base.imagecrop.util.RectUtils;

public class OverlayView
  extends View
{
  private float jdField_a_of_type_Float;
  protected int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private OverlayViewChangeListener jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropCallbackOverlayViewChangeListener;
  private boolean jdField_a_of_type_Boolean;
  protected float[] a;
  private float jdField_b_of_type_Float = -1.0F;
  protected int b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  protected float[] b;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
  private boolean jdField_c_of_type_Boolean;
  private float[] jdField_c_of_type_ArrayOfFloat = null;
  private int jdField_d_of_type_Int;
  private Paint jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f = 0;
  private int g = -1;
  private int h = getResources().getDimensionPixelSize(2131299251);
  private int i = getResources().getDimensionPixelSize(2131299252);
  private int j = getResources().getDimensionPixelSize(2131299250);
  
  public OverlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    double d1 = this.h;
    int m = -1;
    int k = 0;
    while (k < 8)
    {
      double d3 = Math.sqrt(Math.pow(paramFloat1 - this.jdField_a_of_type_ArrayOfFloat[k], 2.0D) + Math.pow(paramFloat2 - this.jdField_a_of_type_ArrayOfFloat[(k + 1)], 2.0D));
      double d2 = d1;
      if (d3 < d1)
      {
        m = k / 2;
        d2 = d3;
      }
      k += 2;
      d1 = d2;
    }
    if ((this.f == 1) && (m < 0) && (this.jdField_a_of_type_AndroidGraphicsRectF.contains(paramFloat1, paramFloat2))) {
      return 4;
    }
    return m;
  }
  
  private void a(float paramFloat1, float paramFloat2)
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
  
  private void b()
  {
    this.jdField_a_of_type_ArrayOfFloat = RectUtils.a(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_ArrayOfFloat = RectUtils.b(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_c_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height()) / 2.0F, Path.Direction.CW);
  }
  
  private void b(@NonNull TypedArray paramTypedArray)
  {
    int k = paramTypedArray.getDimensionPixelSize(5, getResources().getDimensionPixelSize(2131299247));
    int m = paramTypedArray.getColor(4, getResources().getColor(2131167356));
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(k);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(m);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(k * 3);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(m);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  private void c(@NonNull TypedArray paramTypedArray)
  {
    int k = paramTypedArray.getDimensionPixelSize(9, getResources().getDimensionPixelSize(2131299248));
    int m = paramTypedArray.getColor(6, getResources().getColor(2131167357));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(k);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(m);
    this.jdField_c_of_type_Int = paramTypedArray.getInt(8, 2);
    this.jdField_d_of_type_Int = paramTypedArray.getInt(7, 2);
  }
  
  @NonNull
  public RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  protected void a()
  {
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  protected void a(@NonNull TypedArray paramTypedArray)
  {
    this.jdField_c_of_type_Boolean = paramTypedArray.getBoolean(2, false);
    this.e = paramTypedArray.getColor(3, getResources().getColor(2131167358));
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    b(paramTypedArray);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(10, true);
    c(paramTypedArray);
    this.jdField_b_of_type_Boolean = paramTypedArray.getBoolean(11, true);
  }
  
  protected void a(@NonNull Canvas paramCanvas)
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
  
  protected void b(@NonNull Canvas paramCanvas)
  {
    int k;
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_c_of_type_ArrayOfFloat == null) && (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()))
      {
        this.jdField_c_of_type_ArrayOfFloat = new float[this.jdField_c_of_type_Int * 4 + this.jdField_d_of_type_Int * 4];
        int i2 = 0;
        int m = 0;
        int n;
        int i1;
        float f1;
        float f2;
        for (k = 0;; k = n + 1)
        {
          n = i2;
          i1 = k;
          if (m >= this.jdField_c_of_type_Int) {
            break;
          }
          localObject = this.jdField_c_of_type_ArrayOfFloat;
          n = k + 1;
          localObject[k] = this.jdField_a_of_type_AndroidGraphicsRectF.left;
          localObject = this.jdField_c_of_type_ArrayOfFloat;
          k = n + 1;
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
          f2 = m + 1.0F;
          localObject[n] = (f1 * (f2 / (this.jdField_c_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.top);
          localObject = this.jdField_c_of_type_ArrayOfFloat;
          n = k + 1;
          localObject[k] = this.jdField_a_of_type_AndroidGraphicsRectF.right;
          this.jdField_c_of_type_ArrayOfFloat[n] = (this.jdField_a_of_type_AndroidGraphicsRectF.height() * (f2 / (this.jdField_c_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.top);
          m += 1;
        }
        while (n < this.jdField_d_of_type_Int)
        {
          localObject = this.jdField_c_of_type_ArrayOfFloat;
          k = i1 + 1;
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
          f2 = n + 1.0F;
          localObject[i1] = (f1 * (f2 / (this.jdField_d_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.left);
          localObject = this.jdField_c_of_type_ArrayOfFloat;
          m = k + 1;
          localObject[k] = this.jdField_a_of_type_AndroidGraphicsRectF.top;
          localObject = this.jdField_c_of_type_ArrayOfFloat;
          k = m + 1;
          localObject[m] = (this.jdField_a_of_type_AndroidGraphicsRectF.width() * (f2 / (this.jdField_d_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.left);
          localObject = this.jdField_c_of_type_ArrayOfFloat;
          i1 = k + 1;
          localObject[k] = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
          n += 1;
        }
      }
      localObject = this.jdField_c_of_type_ArrayOfFloat;
      if (localObject != null) {
        paramCanvas.drawLines((float[])localObject, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    if (this.f != 0)
    {
      paramCanvas.save();
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
      localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
      k = this.j;
      ((RectF)localObject).inset(k, -k);
      paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
      localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
      k = this.j;
      ((RectF)localObject).inset(-k, k);
      paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
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
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty();
    boolean bool1 = false;
    if (!bool2)
    {
      if (this.f == 0) {
        return false;
      }
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      if ((paramMotionEvent.getAction() & 0xFF) == 0)
      {
        this.g = a(f2, f1);
        if (this.g != -1) {
          bool1 = true;
        }
        if (!bool1)
        {
          this.jdField_b_of_type_Float = -1.0F;
          this.jdField_c_of_type_Float = -1.0F;
          return bool1;
        }
        if (this.jdField_b_of_type_Float < 0.0F)
        {
          this.jdField_b_of_type_Float = f2;
          this.jdField_c_of_type_Float = f1;
        }
        return bool1;
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
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropCallbackOverlayViewChangeListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(this.jdField_a_of_type_AndroidGraphicsRectF);
        }
      }
    }
    return false;
  }
  
  public void setCircleDimmedLayer(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setCropFrameColor(@ColorInt int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setCropFrameStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt);
  }
  
  public void setCropGridColor(@ColorInt int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setCropGridColumnCount(@IntRange(from=0L) int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_c_of_type_ArrayOfFloat = null;
  }
  
  public void setCropGridRowCount(@IntRange(from=0L) int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_ArrayOfFloat = null;
  }
  
  public void setCropGridStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt);
  }
  
  public void setDimmedColor(@ColorInt int paramInt)
  {
    this.e = paramInt;
  }
  
  @Deprecated
  public void setFreestyleCropEnabled(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setFreestyleCropMode(int paramInt)
  {
    this.f = paramInt;
    postInvalidate();
  }
  
  public void setOverlayViewChangeListener(OverlayViewChangeListener paramOverlayViewChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropCallbackOverlayViewChangeListener = paramOverlayViewChangeListener;
  }
  
  public void setShowCropFrame(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setShowCropGrid(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Int > 0)
    {
      setupCropBounds();
      postInvalidate();
      return;
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void setupCropBounds()
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
      this.jdField_a_of_type_AndroidGraphicsRectF.set(getPaddingLeft() + k, getPaddingTop(), getPaddingLeft() + m + k, getPaddingTop() + this.jdField_b_of_type_Int);
    }
    else
    {
      k = (n - m) / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(getPaddingLeft(), getPaddingTop() + k, getPaddingLeft() + this.jdField_a_of_type_Int, getPaddingTop() + m + k);
    }
    OverlayViewChangeListener localOverlayViewChangeListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropCallbackOverlayViewChangeListener;
    if (localOverlayViewChangeListener != null) {
      localOverlayViewChangeListener.a(this.jdField_a_of_type_AndroidGraphicsRectF);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.OverlayView
 * JD-Core Version:    0.7.0.1
 */