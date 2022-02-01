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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString3);
    localObject = String.valueOf(((StringBuilder)localObject).toString());
    a("uin", String.valueOf(paramString1));
    a("type", String.valueOf(paramString2));
    a("msg", String.valueOf(localObject));
    a("exception", String.valueOf(paramString3));
    a("processName", String.valueOf(paramString4));
    a("msf.core.DeadObjectException", true, 0L, 0L, true);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b.e.c
 * JD-Core Version:    0.7.0.1
 */