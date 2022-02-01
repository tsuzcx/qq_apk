package com.tencent.xweb.extension.video;

import android.widget.TextView;

class e$3
  implements Runnable
{
  e$3(e parame, boolean paramBoolean, double paramDouble) {}
  
  public void run()
  {
    if ((this.a) && (e.a(this.c) != 0.0D)) {
      e.k(this.c).a((int)(this.b / e.a(this.c) * 100.0D), false);
    }
    e.l(this.c).setText(e.a(this.c, this.b));
    e.n(this.c).setText(e.m(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e.3
 * JD-Core Version:    0.7.0.1
 */