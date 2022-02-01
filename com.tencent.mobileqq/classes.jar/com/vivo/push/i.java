package com.vivo.push;

import com.vivo.push.util.b;

final class i
  implements IPushActionListener
{
  i(e parame) {}
  
  public final void onStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      e.a(this.a, "");
      e.b(this.a).a("APP_TOKEN", "");
      e.c(this.a);
      e.d(this.a);
      return;
    }
    e.a(this.a, null);
    e.b(this.a).b("APP_TOKEN");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.i
 * JD-Core Version:    0.7.0.1
 */