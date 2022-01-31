package dov.com.qq.im.cropvideo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RegionView
  extends View
{
  int jdField_a_of_type_Int = 1711276032;
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c;
  int d;
  int e;
  int f = 1;
  
  public RegionView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RegionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RegionView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.e;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b == 0) {
      this.b = getWidth();
    }
    if (this.c == 0) {
      this.c = getHeight();
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = ((getWidth() - this.b) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.right = ((getWidth() + this.b) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.top = ((getHeight() - this.c) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = ((getHeight() + this.c) / 2);
    if (this.f == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      localObject = new Path();
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() * 0.5F;
      ((Path)localObject).moveTo(getWidth(), f1);
      ((Path)localObject).addArc(new RectF(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom), 0.0F, -360.0F);
      ((Path)localObject).moveTo(getWidth(), f1);
      ((Path)localObject).lineTo(getWidth(), getHeight());
      ((Path)localObject).lineTo(0.0F, getHeight());
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(getWidth(), 0.0F);
      ((Path)localObject).moveTo(getWidth(), f1);
      ((Path)localObject).close();
      paramCanvas.drawPath((Path)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845632);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, f1, this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, f1, this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    while (1 != this.f)
    {
      float f1;
      return;
    }
    Object localObject = new Rect[8];
    localObject[0] = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top);
    localObject[1] = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left, 0, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top);
    localObject[2] = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, 0, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.top);
    localObject[3] = new Rect(0, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    localObject[4] = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    localObject[5] = new Rect(0, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.left, getHeight());
    localObject[6] = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.right, getHeight());
    localObject[7] = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom, getWidth(), getHeight());
    Rect localRect = new Rect();
    localRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
    localRect.left -= 2;
    localRect.right += 2;
    localRect.top -= 2;
    localRect.bottom += 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i = 0;
    while (i < localObject.length)
    {
      paramCanvas.drawRect(localObject[i], this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845632);
    paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawRect(localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setClipHeight(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setClipWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setMaskColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMaskShapeType(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setTargetHeight(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setTargetWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setUsedARGB(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.RegionView
 * JD-Core Version:    0.7.0.1
 */