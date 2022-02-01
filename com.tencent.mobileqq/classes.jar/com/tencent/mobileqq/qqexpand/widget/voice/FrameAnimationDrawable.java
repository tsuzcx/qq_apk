package com.tencent.mobileqq.qqexpand.widget.voice;

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
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

@Deprecated
public class FrameAnimationDrawable
  extends Drawable
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 1000L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private final Handler jdField_a_of_type_AndroidOsHandler;
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
    int i = this.jdField_a_of_type_Int;
    if ((i >= 0) && (i < this.jdField_b_of_type_Int))
    {
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = ExpandResourceUtil.a((String)localObject, localOptions);
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
            ThreadManager.getUIHandler().post(new FrameAnimationDrawable.1(this));
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.e("FrameAnimationDrawable", 2, "updateCurBitmap fail.", localException);
        }
      }
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
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (arrayOfString == null) {
      i = 0;
    } else {
      i = arrayOfString.length;
    }
    this.jdField_b_of_type_Int = i;
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      paramLong = 0L;
    } else {
      paramLong = this.jdField_a_of_type_Long / i;
    }
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    b();
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    paramArrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (paramArrayOfString != null) {
      i = paramArrayOfString.length;
    }
    this.jdField_b_of_type_Int = i;
    i = this.jdField_b_of_type_Int;
    long l;
    if (i == 0) {
      l = 0L;
    } else {
      l = this.jdField_a_of_type_Long / i;
    }
    this.jdField_b_of_type_Long = l;
    c();
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
    if (paramCanvas != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
          this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
        }
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10) {
      return true;
    }
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Int %= this.jdField_b_of_type_Int;
    }
    int i = this.jdField_a_of_type_Int;
    if ((i >= 0) && (i < this.jdField_b_of_type_Int))
    {
      long l1 = System.currentTimeMillis();
      c();
      if (this.jdField_b_of_type_Boolean)
      {
        long l2 = System.currentTimeMillis();
        l1 = Math.max(this.jdField_b_of_type_Long - (l2 - l1), 0L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, l1);
        return true;
      }
    }
    else
    {
      this.jdField_b_of_type_Boolean = false;
    }
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.FrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */