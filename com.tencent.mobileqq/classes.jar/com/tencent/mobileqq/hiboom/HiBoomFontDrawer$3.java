package com.tencent.mobileqq.hiboom;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class HiBoomFontDrawer$3
  implements Runnable
{
  HiBoomFontDrawer$3(HiBoomFontDrawer paramHiBoomFontDrawer) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    int i = 0;
    while (i < this.this$0.a.size())
    {
      HiBoomTextView localHiBoomTextView = (HiBoomTextView)((WeakReference)this.this$0.a.get(i)).get();
      if ((localHiBoomTextView != null) && (localHiBoomTextView.a == this.this$0.b))
      {
        localHiBoomTextView.a();
      }
      else
      {
        this.this$0.a.remove(i);
        i -= 1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.3
 * JD-Core Version:    0.7.0.1
 */