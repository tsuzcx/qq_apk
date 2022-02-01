package com.vivo.push.b;

import com.vivo.push.a;

public final class b
  extends c
{
  private String a;
  private String b;
  private String c;
  private String d;
  private boolean e = false;
  
  public b(boolean paramBoolean, String paramString)
  {
    super(i, paramString);
  }
  
  public final void c(a parama)
  {
    super.c(parama);
    parama.a("sdk_clients", this.a);
    parama.a("sdk_version", 800L);
    parama.a("BaseAppCommand.EXTRA_APPID", this.c);
    parama.a("BaseAppCommand.EXTRA_APPKEY", this.b);
    parama.a("PUSH_REGID", this.d);
  }
  
  public final void d()
  {
    this.c = null;
  }
  
  public final void d(a parama)
  {
    super.d(parama);
    this.a = parama.a("sdk_clients");
    this.c = parama.a("BaseAppCommand.EXTRA_APPID");
    this.b = parama.a("BaseAppCommand.EXTRA_APPKEY");
    this.d = parama.a("PUSH_REGID");
  }
  
  public final void e()
  {
    this.b = null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AppCommand:");
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.b
 * JD-Core Version:    0.7.0.1
 */