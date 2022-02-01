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
  private WindowManager a;
  private Context b;
  private WindowManager.LayoutParams c = new WindowManager.LayoutParams();
  private View d = null;
  private boolean e = false;
  
  public ColorNoteSmallScreenToast(Context paramContext, View paramView)
  {
    this.b = paramContext;
    this.a = ((WindowManager)this.b.getSystemService("window"));
    paramContext = this.c;
    paramContext.height = -2;
    paramContext.width = -2;
    paramContext.format = -3;
    paramContext.windowAnimations = 0;
    paramContext.type = 2010;
    paramContext.gravity = 51;
    paramContext.setTitle("Toast");
    this.d = paramView;
    g();
  }
  
  private void g()
  {
    try
    {
      int i = ((Integer)this.c.getClass().getField("privateFlags").get(this.c)).intValue();
      this.c.getClass().getField("privateFlags").set(this.c, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        bool1 = this.e;
        bool2 = false;
        if (bool1) {
          break label391;
        }
        this.e = true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenToast", 2, "startHandler addView start");
          }
          this.a.addView(this.d, this.c);
          if (!QLog.isColorLevel()) {
            break label391;
          }
          QLog.d("ColorNoteSmallScreenToast", 2, "startHandler addView end");
        }
        catch (Exception localException)
        {
          this.e = false;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localException);
          QLog.d("ColorNoteSmallScreenToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (SecurityException localSecurityException)
        {
          this.e = false;
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
          this.e = false;
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
          this.a.updateViewLayout(this.d, this.c);
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
      if ((WindowManager.LayoutParams)this.d.getLayoutParams() != null)
      {
        bool2 = bool1;
        if (bool1) {
          bool2 = ColorNoteSmallScreenPermissionUtil.a(this.b);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler mIsVisibe = ");
        localStringBuilder1.append(this.e);
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
    try
    {
      if (this.e)
      {
        this.e = false;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler removeView start");
          }
          this.a.removeView(this.d);
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
  
  public void c()
  {
    if (this.e) {
      try
      {
        this.a.updateViewLayout(this.d, this.c);
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
  
  public boolean d()
  {
    return this.e;
  }
  
  public WindowManager.LayoutParams e()
  {
    return this.c;
  }
  
  public WindowManager f()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenToast
 * JD-Core Version:    0.7.0.1
 */