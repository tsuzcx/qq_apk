package com.vivo.push.d;

import java.util.ArrayList;

public class a
{
  private static String[] a = { "com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test", "com.vivo.hybrid" };
  private static volatile a c = null;
  private ArrayList<String> b = null;
  
  public static a a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new a();
        }
      }
      finally {}
    }
    return c;
  }
  
  public final ArrayList<String> b()
  {
    return new ArrayList(this.b);
  }
  
  public final boolean c()
  {
    ArrayList localArrayList = this.b;
    return (localArrayList != null) && (localArrayList.size() != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.d.a
 * JD-Core Version:    0.7.0.1
 */