package com.tencent.viola.vinstance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.viola.ui.view.VFrameLayout;

public class VInstanceView
  extends VFrameLayout
{
  public VInstanceView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  @Nullable
  public VInstance getComponent()
  {
    return (VInstance)super.getComponent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstanceView
 * JD-Core Version:    0.7.0.1
 */