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
  private int jdField_a_of_type_Int;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  
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
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    if (Build.VERSION.SDK_INT >= 26) {}
    for (this.jdField_a_of_type_Int = 2038;; this.jdField_a_of_type_Int = 2002)
    {
      setId(2131381754);
      setBackgroundColor(paramContext.getResources().getColor(2131167305));
      return;
    }
  }
  
  private WindowManager.LayoutParams a()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = this.jdField_a_of_type_Int;
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
      if (this.jdField_a_of_type_AndroidViewWindowManager != null)
      {
        WindowManager.LayoutParams localLayoutParams = a();
        this.jdField_a_of_type_AndroidViewWindowManager.addView(this, localLayoutParams);
      }
      return;
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
      if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoicePanelContainer
 * JD-Core Version:    0.7.0.1
 */