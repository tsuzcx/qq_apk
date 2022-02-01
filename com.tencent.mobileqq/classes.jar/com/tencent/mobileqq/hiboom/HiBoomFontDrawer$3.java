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
    label13:
    HiBoomTextView localHiBoomTextView;
    if (i < this.this$0.a.size())
    {
      localHiBoomTextView = (HiBoomTextView)((WeakReference)this.this$0.a.get(i)).get();
      if ((localHiBoomTextView != null) && (localHiBoomTextView.a == this.this$0.b)) {
        break label89;
      }
      this.this$0.a.remove(i);
      i -= 1;
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label89:
      localHiBoomTextView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.3
 * JD-Core Version:    0.7.0.1
 */