package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ColorNoteSmallScreenFullToast
  extends RelativeLayout
  implements View.OnClickListener
{
  boolean a = false;
  private WindowManager b;
  private Context c;
  private WindowManager.LayoutParams d = new WindowManager.LayoutParams();
  private ImageView e;
  private RelativeLayout.LayoutParams f;
  private ColorNoteSmallScreenFullToast.IColorNoteSmallScreenFullToastListener g;
  
  public ColorNoteSmallScreenFullToast(Context paramContext, ColorNoteSmallScreenFullToast.IColorNoteSmallScreenFullToastListener paramIColorNoteSmallScreenFullToastListener)
  {
    super(paramContext);
    this.c = paramContext;
    this.g = paramIColorNoteSmallScreenFullToastListener;
    this.b = ((WindowManager)this.c.getSystemService("window"));
    paramIColorNoteSmallScreenFullToastListener = this.d;
    paramIColorNoteSmallScreenFullToastListener.height = -1;
    paramIColorNoteSmallScreenFullToastListener.width = -1;
    paramIColorNoteSmallScreenFullToastListener.format = -3;
    paramIColorNoteSmallScreenFullToastListener.windowAnimations = 0;
    paramIColorNoteSmallScreenFullToastListener.gravity = 51;
    paramIColorNoteSmallScreenFullToastListener.setTitle("Toast");
    this.d.flags = 768;
    if (Build.VERSION.SDK_INT >= 26) {
      this.d.type = 2038;
    } else {
      this.d.type = 2002;
    }
    this.e = new ImageView(paramContext);
    this.e.setContentDescription(paramContext.getResources().getString(2131887841));
    this.e.setBackgroundResource(2130839429);
    this.e.setVisibility(8);
    this.f = new RelativeLayout.LayoutParams(Utils.a(24.0F, paramContext.getResources()), Utils.a(24.0F, paramContext.getResources()));
    addView(this.e, this.f);
    setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (paramInt1 - Utils.a(12.0F, getResources()));
      localObject = new int[2];
      getLocationOnScreen((int[])localObject);
      this.f.topMargin = (paramInt2 - Utils.a(5.5F, getResources()) - localObject[1]);
      this.e.requestLayout();
    }
    if (this.e.getVisibility() == 8) {
      this.e.setVisibility(0);
    }
    this.e.setAlpha(0.0F);
    this.e.animate().alpha(1.0F).setDuration(150L).setInterpolator(new LinearInterpolator()).start();
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        bool1 = this.a;
        bool2 = false;
        if (bool1) {
          break label382;
        }
        this.a = true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler addView start");
          }
          this.b.addView(this, this.d);
          if (!QLog.isColorLevel()) {
            break label382;
          }
          QLog.d("ColorNoteSmallScreenFullToast", 2, "startHandler addView end");
        }
        catch (Exception localException)
        {
          this.a = false;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localException);
          QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (SecurityException localSecurityException)
        {
          this.a = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localSecurityException);
          QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (WindowManager.BadTokenException localBadTokenException)
        {
          this.a = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localBadTokenException);
          QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          this.b.updateViewLayout(this, this.d);
          if (!QLog.isColorLevel()) {
            break label382;
          }
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startHandler error : ");
        localStringBuilder2.append(localIllegalStateException);
        QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder2.toString());
      }
      finally {}
      boolean bool2 = bool1;
      if ((WindowManager.LayoutParams)getLayoutParams() != null)
      {
        bool2 = bool1;
        if (bool1) {
          bool2 = ColorNoteSmallScreenPermissionUtil.a(this.c);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler mIsVisibe = ");
        localStringBuilder1.append(this.a);
        QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler result = ");
        localStringBuilder1.append(bool2);
        QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder1.toString());
      }
      return bool2;
      label382:
      boolean bool1 = true;
    }
  }
  
  public void b()
  {
    try
    {
      if (this.a)
      {
        this.a = false;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView start");
          }
          if (this.f != null)
          {
            this.f.leftMargin = 0;
            this.f.topMargin = 0;
            this.e.requestLayout();
          }
          this.e.setVisibility(8);
          this.b.removeView(this);
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView end");
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("stopHandler error : ");
            localStringBuilder.append(localIllegalArgumentException);
            QLog.d("ColorNoteSmallScreenFullToast", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.g;
      if (paramKeyEvent != null) {
        paramKeyEvent.a();
      }
      b();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    b();
    ColorNoteSmallScreenFullToast.IColorNoteSmallScreenFullToastListener localIColorNoteSmallScreenFullToastListener;
    if (paramView == this)
    {
      localIColorNoteSmallScreenFullToastListener = this.g;
      if (localIColorNoteSmallScreenFullToastListener != null) {
        localIColorNoteSmallScreenFullToastListener.b();
      }
    }
    else if (paramView == this.e)
    {
      localIColorNoteSmallScreenFullToastListener = this.g;
      if (localIColorNoteSmallScreenFullToastListener != null) {
        localIColorNoteSmallScreenFullToastListener.d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenFullToast
 * JD-Core Version:    0.7.0.1
 */