package com.tencent.trackrecordlib.f;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

public class d
  implements View.OnKeyListener
{
  private View.OnKeyListener a;
  private b.a b;
  
  public d(View.OnKeyListener paramOnKeyListener, b.a parama)
  {
    this.a = paramOnKeyListener;
    this.b = parama;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    Log.d("OnKeyListenerProxy", "---------------OnKeyListenerProxy-------------");
    Object localObject = this.b;
    if (localObject != null) {
      ((b.a)localObject).a(paramView, paramInt, paramKeyEvent);
    }
    localObject = this.a;
    return (localObject != null) && (((View.OnKeyListener)localObject).onKey(paramView, paramInt, paramKeyEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.f.d
 * JD-Core Version:    0.7.0.1
 */