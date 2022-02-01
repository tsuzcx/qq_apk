package com.tencent.qcircle.shadow.core.runtime.qcircle.container;

import android.app.Activity;
import android.view.Window;

public abstract interface HostActivity
{
  public abstract Activity getImplementActivity();
  
  public abstract Window getImplementWindow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.qcircle.container.HostActivity
 * JD-Core Version:    0.7.0.1
 */