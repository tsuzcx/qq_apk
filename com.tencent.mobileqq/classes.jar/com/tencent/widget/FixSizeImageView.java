package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import bcwc;
import bhtp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class FixSizeImageView
  extends ThemeImageView
  implements bhtp
{
  protected float a;
  protected long a;
  protected Bitmap a;
  protected Paint a;
  protected Rect a;
  protected boolean a;
  protected float b;
  protected Paint b;
  protected boolean b;
  protected float c;
  
  public FixSizeImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_a_of_type_Long = 5L;
  }
  
  public FixSizeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_a_of_type_Long = 5L;
  }
  
  public FixSizeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_a_of_type_Long = 5L;
  }
  
  protected static Bitmap a(long paramLong)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = null;
    long l = System.currentTimeMillis();
    int i = -1;
    Object localObject = "";
    if (paramLong == 1L)
    {
      i = 2130849770;
      localObject = "StatusIcon_TroopPermanentBlockStatusBigIconKey";
      if (i >= 0) {
        break label58;
      }
      localObject = localBitmap1;
    }
    label58:
    do
    {
      return localObject;
      if (paramLong != 2L) {
        break;
      }
      i = 2130849772;
      localObject = "StatusIcon_TroopTmpBlockStatusBigIcon";
      break;
      if (BaseApplicationImpl.sImageCache != null) {
        localBitmap2 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject);
      }
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        localBitmap2 = bcwc.b(BaseApplicationImpl.getApplication().getResources(), i);
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put(localObject, localBitmap2);
            localBitmap1 = localBitmap2;
          }
        }
      }
      localObject = localBitmap1;
    } while (!QLog.isColorLevel());
    QLog.i("FixSizeImageView", 2, "getTroopCreditStatusIcon:" + (System.currentTimeMillis() - l));
    return localBitmap1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bhxo = null;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == paramLong) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FixSizeImageView", 2, "showTroopCreditStatus:" + paramLong);
    }
    if ((paramLong == 2L) || (paramLong == 1L))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
    }
    for (this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramLong);; this.jdField_a_of_type_AndroidGraphicsBitmap = null)
    {
      invalidate();
      return;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Float == -1.0F) || (this.jdField_b_of_type_Float == -1.0F))
      {
        i = getWidth() - getPaddingLeft() - getPaddingRight();
        this.jdField_a_of_type_Float = (getPaddingLeft() + i * 0.5F);
        j = getHeight() - getPaddingTop() - getPaddingBottom();
        this.jdField_b_of_type_Float = (getPaddingTop() + j * 0.5F);
        this.c = (Math.max(i, j) / 2);
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#B2000000"));
      }
      paramCanvas.drawCircle(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        if (this.jdField_a_of_type_AndroidGraphicsRect == null)
        {
          i = getWidth() - getPaddingRight();
          j = getHeight() - getPaddingBottom();
          this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), j - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), i, j);
        }
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      b(paramCanvas);
    }
  }
  
  public void requestLayout() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.FixSizeImageView
 * JD-Core Version:    0.7.0.1
 */