package com.tencent.mobileqq.relationx.util;

import android.content.DialogInterface.OnDismissListener;

public abstract class UnLeakOnDismissListenerWrapper
  implements DialogInterface.OnDismissListener
{
  public DialogInterface.OnDismissListener a()
  {
    return new UnLeakOnDismissListenerWrapper.UnLeakOnDismissListener(this, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.util.UnLeakOnDismissListenerWrapper
 * JD-Core Version:    0.7.0.1
 */