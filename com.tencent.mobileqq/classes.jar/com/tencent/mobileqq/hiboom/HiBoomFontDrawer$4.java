package com.tencent.mobileqq.hiboom;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class HiBoomFontDrawer$4
  implements Runnable
{
  HiBoomFontDrawer$4(HiBoomFontDrawer paramHiBoomFontDrawer) {}
  
  public void run()
  {
    if (this.this$0.f == null) {
      return;
    }
    int i = 0;
    while (i < this.this$0.f.size())
    {
      HiBoomTextView localHiBoomTextView = (HiBoomTextView)((WeakReference)this.this$0.f.get(i)).get();
      if ((localHiBoomTextView != null) && (localHiBoomTextView.a == this.this$0.c))
      {
        localHiBoomTextView.c();
      }
      else
      {
        this.this$0.f.remove(i);
        i -= 1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.4
 * JD-Core Version:    0.7.0.1
 */