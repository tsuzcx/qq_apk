package com.tencent.mobileqq.msf.sdk.b;

public class e$c
  extends e.a
{
  public static final String b = "msf.core.DeadObjectException";
  
  public static c b()
  {
    return e.c.a.a();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = String.valueOf(System.currentTimeMillis() + "_" + paramString1 + "_" + paramString4 + " " + paramString2 + "_" + paramString3);
    a("uin", String.valueOf(paramString1));
    a("type", String.valueOf(paramString2));
    a("msg", String.valueOf(str));
    a("exception", String.valueOf(paramString3));
    a("processName", String.valueOf(paramString4));
    a("msf.core.DeadObjectException", true, 0L, 0L, true);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b.e.c
 * JD-Core Version:    0.7.0.1
 */