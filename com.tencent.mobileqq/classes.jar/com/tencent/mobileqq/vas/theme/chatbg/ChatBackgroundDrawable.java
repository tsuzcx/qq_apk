package com.tencent.mobileqq.vas.theme.chatbg;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

public class ChatBackgroundDrawable
  extends BitmapDrawable
{
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  
  public ChatBackgroundDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  protected Rect a(Rect paramRect)
  {
    if (getBitmap() == null) {
      return this.jdField_a_of_type_AndroidGraphicsRect;
    }
    int i = getBitmap().getHeight();
    int j = getBitmap().getWidth();
    if (paramRect == null) {
      return new Rect(0, 0, j, i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dstRect = ");
    localStringBuilder.append(paramRect);
    QLog.d("chatbg", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("img width = ");
    localStringBuilder.append(j);
    localStringBuilder.append(" img height = ");
    localStringBuilder.append(i);
    QLog.d("chatbg", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Int < paramRect.height()) {
      this.jdField_a_of_type_Int = paramRect.height();
    }
    int k;
    double d;
    if (this.jdField_a_of_type_Int / paramRect.width() >= i / j)
    {
      int m = paramRect.width();
      k = this.jdField_a_of_type_Int;
      m = m * i / k;
      d = j - m;
      Double.isNaN(d);
      j = (int)(d * 0.5D);
      if (k > paramRect.height()) {
        i = getBitmap().getHeight() * paramRect.height() / this.jdField_a_of_type_Int;
      }
      paramRect = new Rect(j, 0, m + j, i);
    }
    else
    {
      k = paramRect.height() * j / paramRect.width();
      d = i - this.jdField_a_of_type_Int * j / paramRect.width();
      Double.isNaN(d);
      i = (int)(d * 0.5D);
      paramRect = new Rect(0, i, j, k + i);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" result = ");
    localStringBuilder.append(paramRect);
    localStringBuilder.append(" chatWindowHeight ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("chatbg", 1, localStringBuilder.toString());
    return paramRect;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localObject = getBounds();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, (Rect)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = a(getBounds());
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable
 * JD-Core Version:    0.7.0.1
 */