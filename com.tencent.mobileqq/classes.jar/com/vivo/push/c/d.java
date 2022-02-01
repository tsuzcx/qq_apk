package com.vivo.push.c;

import android.text.TextUtils;
import com.vivo.push.b.i;
import com.vivo.push.m;
import com.vivo.push.o;

final class d
  extends y
{
  d(o paramo)
  {
    super(paramo);
  }
  
  protected final void a(o paramo)
  {
    paramo = (i)paramo;
    String str = paramo.e();
    com.vivo.push.e.a().a(paramo.g(), paramo.h(), new Object[] { str });
    if ((TextUtils.isEmpty(paramo.g())) && (!TextUtils.isEmpty(str))) {
      com.vivo.push.e.a().a(str);
    }
    m.b(new e(this, str, paramo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.d
 * JD-Core Version:    0.7.0.1
 */