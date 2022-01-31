package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

public class AlphaDrawable
  extends Drawable
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  int c = 255;
  int d = 0;
  int e = 0;
  int f = 0;
  
  public AlphaDrawable(Context paramContext)
  {
    c();
  }
  
  public AlphaDrawable(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), paramInt1);
      if (paramInt2 != 0) {
        this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), paramInt2);
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.c);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    setAlpha(51);
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != 0) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), paramInt1);
      if (paramInt2 != 0) {
        this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), paramInt2);
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    if (!this.jdField_a_of_type_JavaLangString.endsWith(paramString))
    {
      this.e = 0;
      this.c = 255;
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    setAlpha(255);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      if (this.c <= 0)
      {
        this.d = 0;
        if (this.d != 0) {
          break label146;
        }
        this.c += 5;
        if (this.c >= 255) {
          this.c = 255;
        }
      }
      for (;;)
      {
        setAlpha(this.c);
        if (this.c != 0) {
          break label171;
        }
        this.e += 1;
        if (this.e < 3) {
          break label171;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return false;
        if (this.c < 255) {
          break;
        }
        this.d = 1;
        break;
        label146:
        this.c -= 5;
        if (this.c <= 0) {
          this.c = 0;
        }
      }
      label171:
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 20);
      return false;
    }
    setAlpha(51);
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    super.invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.AlphaDrawable
 * JD-Core Version:    0.7.0.1
 */