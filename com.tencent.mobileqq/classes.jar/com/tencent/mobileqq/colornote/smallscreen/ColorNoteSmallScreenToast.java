package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class ColorNoteSmallScreenToast
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView = null;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ColorNoteSmallScreenToast(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    paramContext = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    paramContext.height = -2;
    paramContext.width = -2;
    paramContext.format = -3;
    paramContext.windowAnimations = 0;
    paramContext.type = 2010;
    paramContext.gravity = 51;
    paramContext.setTitle("Toast");
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
  }
  
  private void c()
  {
    try
    {
      int i = ((Integer)this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").get(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams)).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").set(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public WindowManager.LayoutParams a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  public WindowManager a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler removeView start");
          }
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler removeView end");
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("stopHandler error : ");
            localStringBuilder.append(localIllegalArgumentException);
            QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        bool1 = this.jdField_a_of_type_Boolean;
        bool2 = false;
        if (bool1) {
          break label391;
        }
        this.jdField_a_of_type_Boolean = true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenToast", 2, "startHandler addView start");
          }
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          if (!QLog.isColorLevel()) {
            break label391;
          }
          QLog.d("ColorNoteSmallScreenToast", 2, "startHandler addView end");
        }
        catch (Exception localException)
        {
          this.jdField_a_of_type_Boolean = false;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localException);
          QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (SecurityException localSecurityException)
        {
          this.jdField_a_of_type_Boolean = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localSecurityException);
          QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (WindowManager.BadTokenException localBadTokenException)
        {
          this.jdField_a_of_type_Boolean = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localBadTokenException);
          QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          if (!QLog.isColorLevel()) {
            break label391;
          }
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startHandler error : ");
        localStringBuilder2.append(localIllegalStateException);
        QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder2.toString());
      }
      finally {}
      boolean bool2 = bool1;
      if ((WindowManager.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams() != null)
      {
        bool2 = bool1;
        if (bool1) {
          bool2 = ColorNoteSmallScreenPermissionUtil.a(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler mIsVisibe = ");
        localStringBuilder1.append(this.jdField_a_of_type_Boolean);
        QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler result = ");
        localStringBuilder1.append(bool2);
        QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder1.toString());
      }
      return bool2;
      label391:
      boolean bool1 = true;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("layout error : ");
          localStringBuilder.append(localIllegalArgumentException);
          QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenToast
 * JD-Core Version:    0.7.0.1
 */