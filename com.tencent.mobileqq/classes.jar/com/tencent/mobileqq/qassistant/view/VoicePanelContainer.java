package com.tencent.mobileqq.qassistant.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

public class VoicePanelContainer
  extends FrameLayout
{
  private WindowManager a;
  private int b;
  
  public VoicePanelContainer(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoicePanelContainer(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoicePanelContainer(@NonNull Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = ((WindowManager)paramContext.getSystemService("window"));
    if (Build.VERSION.SDK_INT >= 26) {
      this.b = 2038;
    } else {
      this.b = 2002;
    }
    setId(2131449975);
    setBackgroundColor(paramContext.getResources().getColor(2131168376));
  }
  
  private WindowManager.LayoutParams c()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = this.b;
    localLayoutParams.format = 1;
    localLayoutParams.gravity = 80;
    localLayoutParams.flags = 16777384;
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    if (Build.VERSION.SDK_INT >= 28) {
      localLayoutParams.layoutInDisplayCutoutMode = 2;
    }
    return localLayoutParams;
  }
  
  public void a()
  {
    try
    {
      if (this.a != null)
      {
        WindowManager.LayoutParams localLayoutParams = c();
        this.a.addView(this, localLayoutParams);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b()
  {
    try
    {
      if (this.a != null)
      {
        this.a.removeView(this);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoicePanelContainer
 * JD-Core Version:    0.7.0.1
 */