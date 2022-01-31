package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import aqnb;
import auae;
import audm;
import axlk;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class OcrImageTextView
  extends ImageView
{
  private static String jdField_a_of_type_JavaLangString = "OcrImageTextView";
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private auae jdField_a_of_type_Auae;
  public Runnable a;
  private List<audm> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  
  public OcrImageTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OcrImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OcrImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new OcrImageTextView.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public static float a(int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    float f2 = paramPaint.getTextSize();
    float f1 = paramPaint.measureText(paramString);
    paramInt1 = (int)(paramInt1 * 0.95D);
    paramInt2 = (int)(paramInt2 * 0.95D);
    if (f1 > paramInt1)
    {
      f2 -= 1.0F;
      for (f3 = f1;; f3 = paramPaint.measureText(paramString))
      {
        f1 = f2;
        if (f3 <= paramInt1) {
          break;
        }
        f2 -= 1.0F;
        paramPaint.setTextSize(f2);
      }
    }
    f2 += 1.0F;
    for (float f3 = f1;; f3 = paramPaint.measureText(paramString))
    {
      f1 = f2;
      if (f3 >= paramInt1) {
        break;
      }
      f2 += 1.0F;
      paramPaint.setTextSize(f2);
    }
    paramString = paramPaint.getFontMetrics();
    f2 = paramString.descent;
    f3 = paramString.ascent;
    f3 = f2 - f3;
    f2 = f1;
    for (f1 = f3; f1 > paramInt2; f1 = paramString.descent - paramString.ascent)
    {
      f2 -= 1.0F;
      paramPaint.setTextSize(f2);
      paramString = paramPaint.getFontMetrics();
    }
    return f2 - 1.0F;
  }
  
  private void a(List<aqnb> paramList, int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new OcrImageTextView.1(this, paramList, paramInt1, paramString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-38294);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(30.0F);
  }
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = -2;
    audm localaudm;
    if (localIterator.hasNext())
    {
      localaudm = (audm)localIterator.next();
      if (!localaudm.jdField_b_of_type_Boolean) {
        break label154;
      }
      if (i < 0)
      {
        localStringBuilder.append(localaudm.jdField_a_of_type_JavaLangString.trim());
        i = localaudm.h;
      }
    }
    label154:
    for (;;)
    {
      break;
      if (localaudm.h == i)
      {
        localStringBuilder.append(localaudm.jdField_a_of_type_JavaLangString.trim());
      }
      else
      {
        localStringBuilder.append("\n\n").append(localaudm.jdField_a_of_type_JavaLangString.trim());
        i = localaudm.h;
        continue;
        return localStringBuilder.toString();
      }
    }
  }
  
  public List<audm> a(List<aqnb> paramList, int paramInt1, int paramInt2, String paramString)
  {
    a();
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      int i = 0;
      while (i < paramList.size())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { paramList.get(i) });
        i += 1;
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
      this.jdField_a_of_type_Float = (axlk.e(getContext()) / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
      this.jdField_b_of_type_Float = this.jdField_a_of_type_Float;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "scaleX=" + this.jdField_a_of_type_Float + " scaleY=" + this.jdField_b_of_type_Float + " getWidth=" + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + ", " + getWidth() + " getHeight=" + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + ", " + getHeight() + " ocrWidth=" + paramInt1 + " ocrHeight=" + paramInt2 + " hardware accelerate: " + isHardwareAccelerated());
      }
    }
    a(paramList, paramInt1, paramInt2, paramString);
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      audm localaudm = (audm)localIterator.next();
      if ((localaudm != null) && (localaudm.jdField_a_of_type_AndroidGraphicsBitmap != null))
      {
        localaudm.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        localaudm.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(int paramInt1, audm paramaudm, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextSize();
    if (paramInt1 <= 0) {
      return;
    }
    if (paramaudm.jdField_a_of_type_Float > 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramaudm.jdField_a_of_type_Float);
      return;
    }
    paramaudm.jdField_a_of_type_Float = a(paramInt1, paramaudm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt2);
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramaudm.jdField_a_of_type_JavaLangString, 0, paramaudm.jdField_a_of_type_JavaLangString.length(), localRect);
    paramaudm.j = ((paramInt1 - localRect.width()) / 2);
    paramaudm.k = ((paramInt2 - localRect.height()) / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramaudm.jdField_a_of_type_Float);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    requestLayout();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_b_of_type_Float <= paramInt;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((audm)localIterator.next()).jdField_b_of_type_Boolean) {
        return true;
      }
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.jdField_a_of_type_Boolean) {}
    audm localaudm;
    Rect localRect;
    int i;
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localaudm = (audm)localIterator.next();
          if (localaudm.jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            a(localaudm.jdField_b_of_type_Int, localaudm, localaudm.c);
            if (localaudm.jdField_a_of_type_AndroidGraphicsRect == null)
            {
              localRect = new Rect();
              this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(localaudm.jdField_a_of_type_JavaLangString, 0, localaudm.jdField_a_of_type_JavaLangString.length(), localRect);
              localaudm.jdField_a_of_type_AndroidGraphicsRect = localRect;
            }
            paramCanvas.save();
            paramCanvas.translate(((Point)localaudm.jdField_a_of_type_JavaUtilList.get(0)).x, ((Point)localaudm.jdField_a_of_type_JavaUtilList.get(0)).y);
            paramCanvas.rotate(localaudm.jdField_a_of_type_Int);
            localRect = new Rect();
            localRect.set(0, 0, localaudm.jdField_b_of_type_Int, localaudm.c);
            i = localaudm.jdField_a_of_type_AndroidGraphicsRect.height();
            if (!localaudm.d) {
              break label328;
            }
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(localaudm.m);
            paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
            if (localaudm.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
              paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
            }
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(localaudm.n);
            paramCanvas.drawText(localaudm.jdField_a_of_type_JavaLangString, localaudm.j, i, this.jdField_a_of_type_AndroidGraphicsPaint);
            paramCanvas.restore();
          }
        }
      }
    }
    label328:
    paramCanvas.drawBitmap(localaudm.jdField_a_of_type_AndroidGraphicsBitmap, localRect, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (localaudm.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
      paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (localaudm.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    }
    for (;;)
    {
      paramCanvas.drawText(localaudm.jdField_a_of_type_JavaLangString, localaudm.j, i, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMeasure isRequestOcr=" + this.jdField_b_of_type_Boolean);
    }
    if ((getDrawable() == null) || (((BitmapDrawable)getDrawable()).getBitmap() == null))
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    Bitmap localBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
    if (localBitmap == null)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    paramInt1 = localBitmap.getWidth();
    paramInt2 = localBitmap.getHeight();
    float f = axlk.e(getContext()) / paramInt1;
    paramInt1 = (int)(paramInt2 * f);
    super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(axlk.e(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
  
  public void setHideAnimLisnter(auae paramauae)
  {
    this.jdField_a_of_type_Auae = paramauae;
  }
  
  public void setShowTextMask(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView
 * JD-Core Version:    0.7.0.1
 */