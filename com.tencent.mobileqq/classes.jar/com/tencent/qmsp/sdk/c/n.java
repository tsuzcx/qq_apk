package com.tencent.qmsp.sdk.c;

import org.json.JSONObject;

public class n
  implements d, e
{
  private static volatile n a;
  
  private n()
  {
    f.a(3L, new n.a(this));
  }
  
  public static n b()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new n();
        }
      }
      finally {}
    }
    return a;
  }
  
  public String a()
  {
    return "Rpt";
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    new JSONObject();
    if ((paramLong1 == 1L) || (paramLong1 == 2L)) {
      com.tencent.qmsp.sdk.a.f.a(paramString, (int)paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.n
 * JD-Core Version:    0.7.0.1
 */