package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.o;

public final class p
  extends o
{
  private String a;
  private String b;
  private byte[] c;
  private long d;
  private InsideNotificationItem e;
  
  public p()
  {
    super(5);
  }
  
  public p(String paramString, long paramLong, InsideNotificationItem paramInsideNotificationItem)
  {
    super(5);
    this.a = paramString;
    this.d = paramLong;
    this.e = paramInsideNotificationItem;
  }
  
  protected final void c(a parama)
  {
    parama.a("package_name", this.a);
    parama.a("notify_id", this.d);
    parama.a("notification_v1", com.vivo.push.util.p.b(this.e));
    parama.a("open_pkg_name", this.b);
    parama.a("open_pkg_name_encode", this.c);
  }
  
  public final String d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    this.a = parama.a("package_name");
    this.d = parama.b("notify_id", -1L);
    this.b = parama.a("open_pkg_name");
    this.c = parama.b("open_pkg_name_encode");
    parama = parama.a("notification_v1");
    if (!TextUtils.isEmpty(parama)) {
      this.e = com.vivo.push.util.p.a(parama);
    }
    parama = this.e;
    if (parama != null) {
      parama.setMsgId(this.d);
    }
  }
  
  public final long e()
  {
    return this.d;
  }
  
  public final InsideNotificationItem f()
  {
    return this.e;
  }
  
  public final String toString()
  {
    return "OnNotificationClickCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.p
 * JD-Core Version:    0.7.0.1
 */