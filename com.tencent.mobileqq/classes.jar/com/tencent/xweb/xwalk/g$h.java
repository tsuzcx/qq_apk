package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;
import com.tencent.xweb.o;

public class g$h
  implements o
{
  ValueCallback<Boolean> a;
  
  public g$h(ValueCallback<Boolean> paramValueCallback)
  {
    this.a = paramValueCallback;
  }
  
  public void a()
  {
    this.a.onReceiveValue(Boolean.valueOf(true));
  }
  
  public void b()
  {
    this.a.onReceiveValue(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.h
 * JD-Core Version:    0.7.0.1
 */