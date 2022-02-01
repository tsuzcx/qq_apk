package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.util.VersionUtils;

public class BubbleVideoView
  extends BubbleImageView
{
  private static BubbleVideoView.DrawListener a;
  private Bitmap b;
  private boolean c;
  
  public BubbleVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BubbleVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(Canvas paramCanvas)
  {
    BubbleVideoView.DrawListener localDrawListener = jdField_a_of_type_ComTencentMobileqqWidgetBubbleVideoView$DrawListener;
    if (localDrawListener != null) {
      localDrawListener.a(this, paramCanvas);
    }
  }
  
  public static void setDrawListener(BubbleVideoView.DrawListener paramDrawListener)
  {
    jdField_a_of_type_ComTencentMobileqqWidgetBubbleVideoView$DrawListener = paramDrawListener;
  }
  
  protected void a()
  {
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("M821")) || (str.contains("A0001"))) {
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (a())
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if ((localObject != null) && ((((Bitmap)localObject).getWidth() != getWidth()) || (this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight() != getHeight())))
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {}
    }
    try
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label81:
      label102:
      label123:
      Paint localPaint;
      Bitmap localBitmap;
      break label81;
    }
    try
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label102;
    }
    try
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      break label123;
    }
    Object localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      localObject = new Canvas((Bitmap)localObject);
      ((Canvas)localObject).setDensity(getResources().getDisplayMetrics().densityDpi);
      localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      ((Canvas)localObject).drawPath(this.jdField_c_of_type_AndroidGraphicsPath, localPaint);
      localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if (localBitmap.getPixel(localBitmap.getWidth() >> 1, this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight() >> 1) != -16777216)
      {
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        ((Canvas)localObject).drawRect(0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight(), localPaint);
        this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      }
    }
    localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
      return;
      super.a(paramCanvas);
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void b()
  {
    this.e = f;
    if (VersionUtils.e()) {
      this.jdField_a_of_type_Int = 1;
    } else {
      this.jdField_a_of_type_Int = 2;
    }
    a();
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.g = true;
      Object localObject = (String)QConfigManager.a().a(462);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          String str = Build.MODEL.toUpperCase();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if ((localCharSequence != null) && (localCharSequence.length() > 0) && (str.contains(localCharSequence)))
            {
              this.g = false;
              break;
            }
            i += 1;
          }
        }
      }
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
      if (this.g) {
        this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      } else {
        this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      }
      this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_ArrayOfFloat = new float[8];
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_ArrayOfFloat = new float[8];
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    b(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public void setUseXfermodeBitmap(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleVideoView
 * JD-Core Version:    0.7.0.1
 */