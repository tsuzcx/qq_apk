package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.p;

public final class q
  extends v
{
  protected InsideNotificationItem a;
  private String b;
  
  public q()
  {
    super(4);
  }
  
  protected final void c(a parama)
  {
    super.c(parama);
    this.b = p.b(this.a);
    parama.a("notification_v1", this.b);
  }
  
  public final InsideNotificationItem d()
  {
    return this.a;
  }
  
  protected final void d(a parama)
  {
    super.d(parama);
    this.b = parama.a("notification_v1");
    if (!TextUtils.isEmpty(this.b))
    {
      this.a = p.a(this.b);
      parama = this.a;
      if (parama != null) {
        parama.setMsgId(f());
      }
    }
  }
  
  public final String e()
  {
    if (TextUtils.isEmpty(this.b))
    {
      InsideNotificationItem localInsideNotificationItem = this.a;
      if (localInsideNotificationItem == null) {
        return null;
      }
      return p.b(localInsideNotificationItem);
    }
    return this.b;
  }
  
  public final String toString()
  {
    return "OnNotifyArrivedCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.q
 * JD-Core Version:    0.7.0.1
 */