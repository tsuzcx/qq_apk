package com.tencent.mobileqq.triton.render.c;

import android.widget.TextView;
import java.util.Locale;

class b$a
  implements Runnable
{
  b$a(b paramb, float paramFloat) {}
  
  public void run()
  {
    if (b.a(this.b) != null) {
      b.a(this.b).setText(String.format(Locale.US, "%.1f", new Object[] { Float.valueOf(this.a) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.c.b.a
 * JD-Core Version:    0.7.0.1
 */