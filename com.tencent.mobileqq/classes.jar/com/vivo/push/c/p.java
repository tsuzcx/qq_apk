package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.b.h;
import com.vivo.push.b.x;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.e;
import com.vivo.push.m;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.z;
import java.util.HashMap;

final class p
  extends y
{
  p(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  protected final void a(com.vivo.push.o paramo)
  {
    Object localObject1 = (com.vivo.push.b.o)paramo;
    Object localObject2 = new h(String.valueOf(((com.vivo.push.b.o)localObject1).f()));
    e.a().a((com.vivo.push.o)localObject2);
    if (!ClientConfigManagerImpl.getInstance(this.a).isEnablePush())
    {
      localObject2 = new StringBuilder("command  ");
      ((StringBuilder)localObject2).append(paramo);
      ((StringBuilder)localObject2).append(" is ignore by disable push ");
      com.vivo.push.util.o.d("OnMessageTask", ((StringBuilder)localObject2).toString());
      paramo = new x(1020L);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("messageID", String.valueOf(((com.vivo.push.b.o)localObject1).f()));
      localObject1 = z.b(this.a, this.a.getPackageName());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((HashMap)localObject2).put("remoteAppId", localObject1);
      }
      paramo.a((HashMap)localObject2);
      e.a().a(paramo);
      return;
    }
    if ((e.a().g()) && (!a(z.d(this.a), ((com.vivo.push.b.o)localObject1).d(), ((com.vivo.push.b.o)localObject1).i())))
    {
      paramo = new x(1021L);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("messageID", String.valueOf(((com.vivo.push.b.o)localObject1).f()));
      localObject1 = z.b(this.a, this.a.getPackageName());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((HashMap)localObject2).put("remoteAppId", localObject1);
      }
      paramo.a((HashMap)localObject2);
      e.a().a(paramo);
      return;
    }
    paramo = ((com.vivo.push.b.o)localObject1).e();
    if (paramo != null)
    {
      int i = paramo.getTargetType();
      localObject1 = paramo.getTragetContent();
      localObject2 = new StringBuilder("tragetType is ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" ; target is ");
      ((StringBuilder)localObject2).append((String)localObject1);
      com.vivo.push.util.o.d("OnMessageTask", ((StringBuilder)localObject2).toString());
      m.b(new q(this, paramo));
      return;
    }
    com.vivo.push.util.o.a("OnMessageTask", " message is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.p
 * JD-Core Version:    0.7.0.1
 */