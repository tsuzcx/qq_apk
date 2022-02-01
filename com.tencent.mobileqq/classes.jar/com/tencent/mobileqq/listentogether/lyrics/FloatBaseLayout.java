package com.tencent.mobileqq.listentogether.lyrics;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class FloatBaseLayout
  extends FrameLayout
{
  float jdField_a_of_type_Float;
  public int a;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  FloatLayoutCallback jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  public int b;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  float d;
  float e = 6.0F;
  
  public FloatBaseLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.e = AIOUtils.b(3.0F, getResources());
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getContext().getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    paramContext = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    paramContext.format = -3;
    paramContext.flags = 808;
    if (Build.VERSION.SDK_INT >= 26) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;
    } else {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002;
    }
    paramContext = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    paramContext.systemUiVisibility = 5892;
    paramContext.gravity = 85;
    paramContext.setTitle("FloatBaseLayout");
    paramContext = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    paramContext.x = 0;
    paramContext.y = 0;
    e();
  }
  
  private void e()
  {
    try
    {
      int i = ((Integer)this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").get(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams)).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").set(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x + this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width / 2;
  }
  
  public WindowManager.LayoutParams a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showOrUpdate updateViewLayout error: ");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("FloatBaseLayout", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x) || (paramInt2 != this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y))
    {
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("showOrUpdate mAdded: ");
      localStringBuilder1.append(this.jdField_a_of_type_Boolean);
      QLog.d("FloatBaseLayout", 2, localStringBuilder1.toString());
    }
    for (;;)
    {
      try
      {
        boolean bool2 = this.jdField_a_of_type_Boolean;
        bool1 = false;
        StringBuilder localStringBuilder2;
        if (!bool2)
        {
          int i = this.jdField_c_of_type_Int;
          if (i >= 4) {
            break label247;
          }
          try
          {
            this.jdField_a_of_type_AndroidViewWindowManager.addView(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
            this.jdField_a_of_type_Boolean = true;
            this.jdField_c_of_type_Int = 0;
          }
          catch (Throwable localThrowable1)
          {
            this.jdField_c_of_type_Int += 1;
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("showOrUpdate addView mExceptionCount:");
            localStringBuilder2.append(this.jdField_c_of_type_Int);
            localStringBuilder2.append(" error:");
            localStringBuilder2.append(localThrowable1.getMessage());
            QLog.e("FloatBaseLayout", 1, localStringBuilder2.toString());
            continue;
          }
        }
        else
        {
          bool2 = this.jdField_a_of_type_Boolean;
          if (!bool2) {
            break label247;
          }
          try
          {
            this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          }
          catch (Throwable localThrowable2)
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("showOrUpdate updateViewLayout error: ");
            localStringBuilder2.append(localThrowable2.getMessage());
            QLog.e("FloatBaseLayout", 1, localStringBuilder2.toString());
          }
        }
        return bool1;
      }
      finally {}
      label247:
      boolean bool1 = true;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x + this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback = null;
  }
  
  public boolean b()
  {
    try
    {
      boolean bool3 = this.jdField_a_of_type_Boolean;
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (bool3) {
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
          this.jdField_a_of_type_Boolean = false;
          bool1 = bool2;
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showOrUpdate addView error: ");
          localStringBuilder.append(localThrowable.getMessage());
          QLog.e("FloatBaseLayout", 1, localStringBuilder.toString());
          bool1 = false;
        }
      }
      this.jdField_c_of_type_Int = 0;
      return bool1;
    }
    finally {}
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
  }
  
  protected void c() {}
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void d() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label253;
          }
        }
        else
        {
          if ((Math.abs(f1 - this.jdField_c_of_type_Float) > this.e) && (Math.abs(f2 - this.d) > this.e) && (this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
          {
            this.jdField_b_of_type_Boolean = true;
            c();
          }
          localFloatLayoutCallback = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback;
          if ((localFloatLayoutCallback != null) && (this.jdField_b_of_type_Boolean)) {
            localFloatLayoutCallback.a((int)(f1 - this.jdField_a_of_type_Float), (int)(f2 - this.jdField_b_of_type_Float));
          }
          if (this.jdField_b_of_type_Boolean)
          {
            bool = true;
            break label253;
          }
          bool = super.dispatchTouchEvent(paramMotionEvent);
          break label253;
        }
      }
      FloatLayoutCallback localFloatLayoutCallback = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback;
      if ((localFloatLayoutCallback != null) && (this.jdField_b_of_type_Boolean)) {
        localFloatLayoutCallback.a();
      }
      if (this.jdField_b_of_type_Boolean)
      {
        d();
        bool = true;
      }
      else
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
    }
    else
    {
      this.jdField_c_of_type_Float = f1;
      this.d = f2;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = true;
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    label253:
    this.jdField_a_of_type_Float = f1;
    this.jdField_b_of_type_Float = f2;
    return bool;
  }
  
  public int e()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
  }
  
  public int g()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y;
  }
  
  public void setFloatLayoutCallback(FloatLayoutCallback paramFloatLayoutCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatLayoutCallback = paramFloatLayoutCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
 * JD-Core Version:    0.7.0.1
 */