package com.tencent.widget;

import java.lang.ref.WeakReference;

final class TCWNumberPicker$AutoIncDecRunnable
  implements Runnable
{
  final WeakReference<TCWNumberPicker> a;
  
  public TCWNumberPicker$AutoIncDecRunnable(TCWNumberPicker paramTCWNumberPicker)
  {
    this.a = new WeakReference(paramTCWNumberPicker);
  }
  
  public void run()
  {
    TCWNumberPicker localTCWNumberPicker = (TCWNumberPicker)this.a.get();
    if (localTCWNumberPicker != null) {
      TCWNumberPicker.a(localTCWNumberPicker, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker.AutoIncDecRunnable
 * JD-Core Version:    0.7.0.1
 */