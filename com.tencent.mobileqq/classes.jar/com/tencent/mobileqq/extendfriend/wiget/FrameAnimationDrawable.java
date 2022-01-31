package com.tencent.mobileqq.extendfriend.wiget;

import ackd;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class FrameAnimationDrawable
  extends Drawable
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 1000L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public FrameAnimationDrawable()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void c()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int))
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int];
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localObject = ExtendFriendResourceUtil.a((String)localObject, localOptions);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
        ThreadManager.getUIHandler().post(new ackd(this));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FrameAnimationDrawable", 2, "updateCurBitmap fail.", localException);
    }
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null)
    {
      i = 0;
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != 0) {
        break label43;
      }
    }
    label43:
    for (paramLong = 0L;; paramLong = this.jdField_a_of_type_Long / this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Long = paramLong;
      return;
      i = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    int i = 0;
    b();
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != 0) {
        break label56;
      }
    }
    label56:
    for (long l = 0L;; l = this.jdField_a_of_type_Long / this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Long = l;
      c();
      return;
      i = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      break;
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((paramCanvas != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Int %= this.jdField_b_of_type_Int;
      }
      if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int))
      {
        long l1 = System.currentTimeMillis();
        c();
        if (this.jdField_b_of_type_Boolean)
        {
          long l2 = System.currentTimeMillis();
          l1 = Math.max(this.jdField_b_of_type_Long - (l2 - l1), 0L);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, l1);
        }
      }
      else
      {
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.FrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */