package dov.com.qq.im.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.tavcut.bean.CropConfig;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.util.AEQLog;

public class AEImageCropperMask
  extends View
{
  private static final int jdField_b_of_type_Int = Color.parseColor("#59C4C4C4");
  private static final int jdField_c_of_type_Int = ViewUtils.b(4.0F);
  private static final int jdField_d_of_type_Int = ViewUtils.b(16.0F);
  private float jdField_a_of_type_Float = 0.8F;
  public int a;
  private long jdField_a_of_type_Long = 200L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected GestureDetector a;
  private AEImageCropperContainer jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_b_of_type_Boolean = false;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_c_of_type_Boolean = true;
  private Rect jdField_d_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 268435455;
  private Rect jdField_e_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 200;
  private Rect jdField_f_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 3;
  private Rect jdField_g_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private int jdField_h_of_type_Int;
  private Rect jdField_h_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private int jdField_i_of_type_Int;
  private Rect jdField_i_of_type_AndroidGraphicsRect = null;
  private int jdField_j_of_type_Int = 0;
  private Rect jdField_j_of_type_AndroidGraphicsRect = null;
  private int jdField_k_of_type_Int = 0;
  private Rect jdField_k_of_type_AndroidGraphicsRect = null;
  private int l = 0;
  
  public AEImageCropperMask(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    a(paramContext, null);
  }
  
  public AEImageCropperMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  public AEImageCropperMask(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    int n = (int)(this.jdField_j_of_type_AndroidGraphicsRect.left - paramFloat1);
    int i2 = (int)(this.jdField_j_of_type_AndroidGraphicsRect.top - paramFloat2);
    int i1 = (int)(this.jdField_j_of_type_AndroidGraphicsRect.right - paramFloat1);
    int i3 = (int)(this.jdField_j_of_type_AndroidGraphicsRect.bottom - paramFloat2);
    Rect localRect = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.a().a();
    int m;
    if (n < localRect.left)
    {
      n = localRect.left;
      m = localRect.left + (this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left);
      if (i2 >= localRect.top) {
        break label211;
      }
      i2 = localRect.top;
      i1 = localRect.top + (this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top);
    }
    for (;;)
    {
      this.jdField_j_of_type_AndroidGraphicsRect = new Rect(n, i2, m, i1);
      invalidate();
      return;
      m = i1;
      if (i1 <= localRect.right) {
        break;
      }
      m = localRect.right;
      n = localRect.right - (this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left);
      break;
      label211:
      i1 = i3;
      if (i3 > localRect.bottom)
      {
        i1 = localRect.bottom;
        i2 = localRect.bottom - (this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top);
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    float f1 = 0.0F;
    float f2;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AECropperGridView);
      this.jdField_e_of_type_Int = paramAttributeSet.getColor(0, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_Float = paramAttributeSet.getFloat(1, 1.0F);
      f2 = this.jdField_a_of_type_Float * 255.0F;
      if (f2 >= 0.0F) {
        break label196;
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_Int = ((int)f1);
      this.jdField_g_of_type_Int = paramAttributeSet.getDimensionPixelOffset(2, this.jdField_g_of_type_Int);
      paramAttributeSet.recycle();
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(ViewUtils.b(2.0F));
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new AEImageCropperMask.GestureListener(this, null), null, true);
      return;
      label196:
      if (f2 > 255.0F) {
        f1 = 255.0F;
      } else {
        f1 = f2;
      }
    }
  }
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AEImageCropperMask.1(this, paramRect1, paramRect2));
    localValueAnimator.addListener(new AEImageCropperMask.2(this));
    localValueAnimator.start();
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) || (paramFloat2 == 0.0F)) {
      return;
    }
    int m = this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left;
    int n = this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top;
    float f1 = m * 1.0F / n;
    if (Math.abs(paramFloat2 / n) > Math.abs(paramFloat1 / m))
    {
      paramFloat1 = paramFloat1 / Math.abs(paramFloat1) * Math.abs(m * paramFloat2 / n);
      paramMotionEvent1 = new Rect(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top, this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
      paramMotionEvent2 = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.a().a();
      if ((this.jdField_j_of_type_Int != 0) || (paramFloat1 * paramFloat2 <= 0.0F)) {
        break label539;
      }
      paramMotionEvent1.left -= (int)paramFloat1;
      paramMotionEvent1.top -= (int)paramFloat2;
      if ((paramMotionEvent1.left >= paramMotionEvent2.left) || (paramMotionEvent1.top >= paramMotionEvent2.top)) {
        break label339;
      }
      if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) <= f1) {
        break label305;
      }
      paramMotionEvent1.left = paramMotionEvent2.left;
      paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
    }
    label539:
    for (;;)
    {
      this.jdField_j_of_type_AndroidGraphicsRect = paramMotionEvent1;
      invalidate();
      return;
      paramFloat2 = paramFloat2 / Math.abs(paramFloat2) * Math.abs(n * paramFloat1 / m);
      break;
      label305:
      paramMotionEvent1.top = paramMotionEvent2.top;
      paramMotionEvent1.left = (paramMotionEvent1.right - (int)(f1 * (paramMotionEvent1.bottom - paramMotionEvent1.top)));
      continue;
      label339:
      if (paramMotionEvent1.left < paramMotionEvent2.left)
      {
        paramMotionEvent1.left = paramMotionEvent2.left;
        paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
      }
      else if (paramMotionEvent1.top < paramMotionEvent2.top)
      {
        paramMotionEvent1.top = paramMotionEvent2.top;
        paramMotionEvent1.left = (paramMotionEvent1.right - (int)(f1 * (paramMotionEvent1.bottom - paramMotionEvent1.top)));
      }
      else if ((this.jdField_i_of_type_AndroidGraphicsRect != null) && ((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
      {
        paramMotionEvent1.left = (paramMotionEvent1.right - (int)((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / 5.0F));
        paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((this.jdField_i_of_type_AndroidGraphicsRect.bottom - this.jdField_i_of_type_AndroidGraphicsRect.top) * 1.0F / 5.0F));
        continue;
        if ((this.jdField_j_of_type_Int == 1) && (paramFloat1 * paramFloat2 < 0.0F))
        {
          paramMotionEvent1.top -= (int)paramFloat2;
          paramMotionEvent1.right -= (int)paramFloat1;
          if ((paramMotionEvent1.right > paramMotionEvent2.right) && (paramMotionEvent1.top < paramMotionEvent2.top))
          {
            if ((paramMotionEvent1.right - paramMotionEvent2.right) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) > f1)
            {
              paramMotionEvent1.right = paramMotionEvent2.right;
              paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
            }
            else
            {
              paramMotionEvent1.top = paramMotionEvent2.top;
              paramMotionEvent1.right = (paramMotionEvent1.left + (int)(f1 * (paramMotionEvent1.bottom - paramMotionEvent1.top)));
            }
          }
          else if (paramMotionEvent1.right > paramMotionEvent2.right)
          {
            paramMotionEvent1.right = paramMotionEvent2.right;
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else if (paramMotionEvent1.top < paramMotionEvent2.top)
          {
            paramMotionEvent1.top = paramMotionEvent2.top;
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)(f1 * (paramMotionEvent1.bottom - paramMotionEvent1.top)));
          }
          else if ((this.jdField_i_of_type_AndroidGraphicsRect != null) && ((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / 5.0F));
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((this.jdField_i_of_type_AndroidGraphicsRect.bottom - this.jdField_i_of_type_AndroidGraphicsRect.top) * 1.0F / 5.0F));
          }
        }
        else if ((this.jdField_j_of_type_Int == 2) && (paramFloat1 * paramFloat2 < 0.0F))
        {
          paramMotionEvent1.left -= (int)paramFloat1;
          paramMotionEvent1.bottom -= (int)paramFloat2;
          if ((paramMotionEvent1.left < paramMotionEvent2.left) && (paramMotionEvent1.bottom > paramMotionEvent2.bottom))
          {
            if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent1.bottom - paramMotionEvent2.bottom) > f1)
            {
              paramMotionEvent1.left = paramMotionEvent2.left;
              paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
            }
            else
            {
              paramMotionEvent1.bottom = paramMotionEvent2.bottom;
              paramMotionEvent1.left = (paramMotionEvent1.right - (int)(f1 * (paramMotionEvent1.bottom - paramMotionEvent1.top)));
            }
          }
          else if (paramMotionEvent1.left < paramMotionEvent2.left)
          {
            paramMotionEvent1.left = paramMotionEvent2.left;
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else if (paramMotionEvent1.bottom > paramMotionEvent2.bottom)
          {
            paramMotionEvent1.bottom = paramMotionEvent2.bottom;
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)(f1 * (paramMotionEvent1.bottom - paramMotionEvent1.top)));
          }
          else if ((this.jdField_i_of_type_AndroidGraphicsRect != null) && ((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / 5.0F));
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((this.jdField_i_of_type_AndroidGraphicsRect.bottom - this.jdField_i_of_type_AndroidGraphicsRect.top) * 1.0F / 5.0F));
          }
        }
        else if ((this.jdField_j_of_type_Int == 3) && (paramFloat1 * paramFloat2 > 0.0F))
        {
          paramMotionEvent1.right -= (int)paramFloat1;
          paramMotionEvent1.bottom -= (int)paramFloat2;
          if ((paramMotionEvent1.right > paramMotionEvent2.right) && (paramMotionEvent1.bottom > paramMotionEvent2.bottom))
          {
            if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) > f1)
            {
              paramMotionEvent1.right = paramMotionEvent2.right;
              paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
            }
            else
            {
              paramMotionEvent1.bottom = paramMotionEvent2.bottom;
              paramMotionEvent1.right = (paramMotionEvent1.left + (int)(f1 * (paramMotionEvent1.bottom - paramMotionEvent1.top)));
            }
          }
          else if (paramMotionEvent1.right > paramMotionEvent2.right)
          {
            paramMotionEvent1.right = paramMotionEvent2.right;
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else if (paramMotionEvent1.bottom > paramMotionEvent2.bottom)
          {
            paramMotionEvent1.bottom = paramMotionEvent2.bottom;
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)(f1 * (paramMotionEvent1.bottom - paramMotionEvent1.top)));
          }
          else if ((this.jdField_i_of_type_AndroidGraphicsRect != null) && ((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / 5.0F));
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((this.jdField_i_of_type_AndroidGraphicsRect.bottom - this.jdField_i_of_type_AndroidGraphicsRect.top) * 1.0F / 5.0F));
          }
        }
      }
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int m = this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left;
    int n = this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top;
    if ((paramMotionEvent.getX() - this.jdField_j_of_type_AndroidGraphicsRect.left < m * 1.0F / 3.0F) && (paramMotionEvent.getY() - this.jdField_j_of_type_AndroidGraphicsRect.top < n * 1.0F / 3.0F))
    {
      this.jdField_j_of_type_Int = 0;
      return true;
    }
    if ((paramMotionEvent.getX() - this.jdField_j_of_type_AndroidGraphicsRect.left > m * 2.0F / 3.0F) && (paramMotionEvent.getY() - this.jdField_j_of_type_AndroidGraphicsRect.top < n * 1.0F / 3.0F))
    {
      this.jdField_j_of_type_Int = 1;
      return true;
    }
    if ((paramMotionEvent.getX() - this.jdField_j_of_type_AndroidGraphicsRect.left < m * 1.0F / 3.0F) && (paramMotionEvent.getY() - this.jdField_j_of_type_AndroidGraphicsRect.top > n * 2.0F / 3.0F))
    {
      this.jdField_j_of_type_Int = 2;
      return true;
    }
    if ((paramMotionEvent.getX() - this.jdField_j_of_type_AndroidGraphicsRect.left > m * 2.0F / 3.0F) && (paramMotionEvent.getY() - this.jdField_j_of_type_AndroidGraphicsRect.top > n * 2.0F / 3.0F))
    {
      this.jdField_j_of_type_Int = 3;
      return true;
    }
    return false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    return (this.jdField_j_of_type_AndroidGraphicsRect != null) && (paramMotionEvent.getX() >= this.jdField_j_of_type_AndroidGraphicsRect.left - AEImageCropperContainer.jdField_a_of_type_Int) && (paramMotionEvent.getX() <= this.jdField_j_of_type_AndroidGraphicsRect.right + AEImageCropperContainer.jdField_a_of_type_Int) && (paramMotionEvent.getY() >= this.jdField_j_of_type_AndroidGraphicsRect.top - AEImageCropperContainer.jdField_a_of_type_Int) && (paramMotionEvent.getY() <= this.jdField_j_of_type_AndroidGraphicsRect.bottom + AEImageCropperContainer.jdField_a_of_type_Int);
  }
  
  public Rect a()
  {
    if (this.jdField_j_of_type_AndroidGraphicsRect != null) {
      return this.jdField_j_of_type_AndroidGraphicsRect;
    }
    return null;
  }
  
  public Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    switch (paramInt1)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      if (paramInt3 > paramInt2) {
        return new Rect((int)(paramInt4 - paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 - paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt4 + paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 + paramInt2 * this.jdField_b_of_type_Float) / 2);
      }
      return new Rect((int)(paramInt4 - paramInt3 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 - paramInt3 * this.jdField_b_of_type_Float) / 2, (int)(paramInt4 + paramInt3 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 + paramInt3 * this.jdField_b_of_type_Float) / 2);
    case 2: 
      if (paramInt3 * 3 >= paramInt2 * 4) {
        return new Rect((int)(paramInt4 - paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 - paramInt2 * this.jdField_b_of_type_Float * 4.0F / 3.0F) / 2, (int)(paramInt4 + paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 + paramInt2 * this.jdField_b_of_type_Float * 4.0F / 3.0F) / 2);
      }
      return new Rect((int)(paramInt4 - paramInt3 * this.jdField_b_of_type_Float * 3.0F / 4.0F) / 2, (int)(paramInt5 - paramInt3 * this.jdField_b_of_type_Float) / 2, (int)(paramInt4 + paramInt3 * this.jdField_b_of_type_Float * 3.0F / 4.0F) / 2, (int)(paramInt5 + paramInt3 * this.jdField_b_of_type_Float) / 2);
    case 3: 
      if (paramInt3 * 4 >= paramInt2 * 3) {
        return new Rect((int)(paramInt4 - paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 - paramInt2 * this.jdField_b_of_type_Float * 3.0F / 4.0F) / 2, (int)(paramInt4 + paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 + paramInt2 * this.jdField_b_of_type_Float * 3.0F / 4.0F) / 2);
      }
      return new Rect((int)(paramInt4 - paramInt3 * this.jdField_b_of_type_Float * 4.0F / 3.0F) / 2, (int)(paramInt5 - paramInt3 * this.jdField_b_of_type_Float) / 2, (int)(paramInt4 + paramInt3 * this.jdField_b_of_type_Float * 4.0F / 3.0F) / 2, (int)(paramInt5 + paramInt3 * this.jdField_b_of_type_Float) / 2);
    }
    if (paramInt3 * 16 >= paramInt2 * 9) {
      return new Rect((int)(paramInt4 - paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 - paramInt2 * this.jdField_b_of_type_Float * 9.0F / 16.0F) / 2, (int)(paramInt4 + paramInt2 * this.jdField_b_of_type_Float) / 2, (int)(paramInt5 + paramInt2 * this.jdField_b_of_type_Float * 9.0F / 16.0F) / 2);
    }
    return new Rect((int)(paramInt4 - paramInt3 * this.jdField_b_of_type_Float * 16.0F / 9.0F) / 2, (int)(paramInt5 - paramInt3 * this.jdField_b_of_type_Float) / 2, (int)(paramInt4 + paramInt3 * this.jdField_b_of_type_Float * 16.0F / 9.0F) / 2, (int)(paramInt5 + paramInt3 * this.jdField_b_of_type_Float) / 2);
  }
  
  public CropConfig a()
  {
    if ((this.jdField_k_of_type_Int == 0) || (this.l == 0)) {
      return new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
    }
    if (this.jdField_j_of_type_AndroidGraphicsRect == null) {
      return AEEditorCropperPanel.a(this.jdField_k_of_type_Int, this.l);
    }
    int m = (int)(getWidth() - this.jdField_k_of_type_Int * this.jdField_b_of_type_Float) / 2;
    int n = (int)(getHeight() - this.l * this.jdField_b_of_type_Float) / 2;
    int i1 = (int)(getWidth() + this.jdField_k_of_type_Int * this.jdField_b_of_type_Float) / 2;
    i1 = (int)(getHeight() + this.l * this.jdField_b_of_type_Float) / 2;
    return new CropConfig((this.jdField_j_of_type_AndroidGraphicsRect.left - m) / (this.jdField_k_of_type_Int * this.jdField_b_of_type_Float), (this.jdField_j_of_type_AndroidGraphicsRect.top - n) / (this.l * this.jdField_b_of_type_Float), (this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left) / (this.jdField_k_of_type_Int * this.jdField_b_of_type_Float), (this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top) / (this.l * this.jdField_b_of_type_Float));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_k_of_type_Int = paramInt2;
    this.l = paramInt3;
    this.jdField_a_of_type_Int = paramInt1;
    Rect localRect = a(paramInt1, paramInt2, paramInt3, getWidth(), getHeight());
    if (localRect == null)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_j_of_type_AndroidGraphicsRect = null;
      this.jdField_k_of_type_AndroidGraphicsRect = null;
      invalidate();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_k_of_type_AndroidGraphicsRect == null)
    {
      this.jdField_j_of_type_AndroidGraphicsRect = localRect;
      invalidate();
      this.jdField_k_of_type_AndroidGraphicsRect = this.jdField_j_of_type_AndroidGraphicsRect;
      return;
    }
    a(this.jdField_k_of_type_AndroidGraphicsRect, localRect);
  }
  
  public void a(AEImageCropperContainer paramAEImageCropperContainer, int paramInt1, Bitmap paramBitmap, CropConfig paramCropConfig, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer = paramAEImageCropperContainer;
    this.jdField_h_of_type_Int = paramInt2;
    this.jdField_i_of_type_Int = paramInt3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_k_of_type_Int = paramBitmap.getWidth();
    this.l = paramBitmap.getHeight();
    this.jdField_b_of_type_Float = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.a().a();
    paramAEImageCropperContainer = this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEImageCropperContainer.a().b();
    paramInt1 = (int)(paramAEImageCropperContainer.left + paramCropConfig.getX() * (paramAEImageCropperContainer.right - paramAEImageCropperContainer.left));
    paramInt2 = (int)(paramAEImageCropperContainer.top + paramCropConfig.getY() * (paramAEImageCropperContainer.bottom - paramAEImageCropperContainer.top));
    paramInt3 = (int)(paramAEImageCropperContainer.left + (paramCropConfig.getX() + paramCropConfig.getWidth()) * (paramAEImageCropperContainer.right - paramAEImageCropperContainer.left));
    float f1 = paramAEImageCropperContainer.top;
    float f2 = paramCropConfig.getY();
    float f3 = paramCropConfig.getHeight();
    int m = (int)((paramAEImageCropperContainer.bottom - paramAEImageCropperContainer.top) * (f2 + f3) + f1);
    if (this.jdField_a_of_type_Int == 0) {}
    for (this.jdField_j_of_type_AndroidGraphicsRect = null;; this.jdField_j_of_type_AndroidGraphicsRect = new Rect(paramInt1, paramInt2, paramInt3, m))
    {
      invalidate();
      return;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    if (this.jdField_j_of_type_AndroidGraphicsRect == null) {
      return;
    }
    int n = this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left;
    int m = this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top;
    paramCanvas.clipRect(this.jdField_j_of_type_AndroidGraphicsRect, Region.Op.XOR);
    paramCanvas.drawColor(jdField_b_of_type_Int);
    paramCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(ViewUtils.b(1.0F));
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(ViewUtils.b(0.5F));
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_j_of_type_AndroidGraphicsRect.left + n / 3, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left + n / 3, this.jdField_j_of_type_AndroidGraphicsRect.top + m);
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_j_of_type_AndroidGraphicsRect.left + n * 2 / 3, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left + n * 2 / 3, this.jdField_j_of_type_AndroidGraphicsRect.top + m);
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top + m / 3);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left + n, this.jdField_j_of_type_AndroidGraphicsRect.top + m / 3);
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top + m * 2 / 3);
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f1 = n + this.jdField_j_of_type_AndroidGraphicsRect.left;
    n = this.jdField_j_of_type_AndroidGraphicsRect.top;
    localPath.lineTo(f1, m * 2 / 3 + n);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.left - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.left + jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.left - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top, this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top + jdField_d_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.right - jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.right + jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.top, this.jdField_j_of_type_AndroidGraphicsRect.right + jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top + jdField_d_of_type_Int);
    this.jdField_e_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.left - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom, this.jdField_j_of_type_AndroidGraphicsRect.left + jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom + jdField_c_of_type_Int);
    this.jdField_f_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.left - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom - jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
    this.jdField_g_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.right - jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom, this.jdField_j_of_type_AndroidGraphicsRect.right + jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom + jdField_c_of_type_Int);
    this.jdField_h_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.bottom - jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.right + jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_e_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_f_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_g_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_h_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      AEQLog.a("CropperGridView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      AEQLog.a("CropperGridView", "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    AEQLog.a("CropperGridView", "onTouchEvent(" + paramMotionEvent.getActionMasked() + ", " + paramMotionEvent.getAction() + ")");
    getParent().requestDisallowInterceptTouchEvent(true);
    int m = paramMotionEvent.getActionMasked();
    if (m == 0) {
      if (b(paramMotionEvent))
      {
        if (!a(paramMotionEvent)) {
          break label171;
        }
        this.jdField_e_of_type_Boolean = true;
        this.jdField_f_of_type_Boolean = false;
        this.jdField_i_of_type_AndroidGraphicsRect = a(this.jdField_a_of_type_Int, this.jdField_k_of_type_Int, this.l, getWidth(), getHeight());
        AEReportUtils.f();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
      label171:
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      break;
      if (m == 1)
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_f_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperMask
 * JD-Core Version:    0.7.0.1
 */