package com.tencent.xweb.xwalk;

import com.tencent.xweb.h;
import org.xwalk.core.XWalkHttpAuthHandler;

public class g$j
  implements h
{
  XWalkHttpAuthHandler a;
  
  public g$j(XWalkHttpAuthHandler paramXWalkHttpAuthHandler)
  {
    this.a = paramXWalkHttpAuthHandler;
  }
  
  public void a()
  {
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.j
 * JD-Core Version:    0.7.0.1
 */