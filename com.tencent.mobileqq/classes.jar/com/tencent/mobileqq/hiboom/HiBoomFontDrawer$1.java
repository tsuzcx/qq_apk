package com.tencent.mobileqq.hiboom;

import java.util.concurrent.atomic.AtomicBoolean;

class HiBoomFontDrawer$1
  implements Runnable
{
  HiBoomFontDrawer$1(HiBoomFontDrawer paramHiBoomFontDrawer, boolean paramBoolean) {}
  
  public void run()
  {
    HiBoomFontDrawer localHiBoomFontDrawer = this.this$0;
    localHiBoomFontDrawer.b = localHiBoomFontDrawer.d(this.a);
    if ((this.this$0.b != 1) && (this.this$0.b != 3))
    {
      if (this.this$0.b == 2)
      {
        if (!this.this$0.b(this.a)) {}
      }
      else if (this.this$0.b == 4) {
        this.this$0.a();
      }
    }
    else {
      this.this$0.c(this.a);
    }
    if (this.this$0.g.get()) {
      HiBoomFontDrawer.a(this.this$0);
    }
    this.this$0.h.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1
 * JD-Core Version:    0.7.0.1
 */