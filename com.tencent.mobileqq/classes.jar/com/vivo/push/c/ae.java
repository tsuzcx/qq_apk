package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.b.u;
import com.vivo.push.b.x;
import com.vivo.push.util.NotifyAdapterUtil;
import com.vivo.push.util.z;
import java.util.HashMap;

final class ae
  extends y
{
  ae(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  protected final void a(com.vivo.push.o paramo)
  {
    paramo = (u)paramo;
    if ((com.vivo.push.e.a().g()) && (!a(z.d(this.a), paramo.e(), paramo.i())))
    {
      com.vivo.push.util.o.d("OnUndoMsgTask", " vertify msg is error ");
      localObject1 = new x(1021L);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("messageID", String.valueOf(paramo.f()));
      paramo = z.b(this.a, this.a.getPackageName());
      if (!TextUtils.isEmpty(paramo)) {
        ((HashMap)localObject2).put("remoteAppId", paramo);
      }
      ((x)localObject1).a((HashMap)localObject2);
      com.vivo.push.e.a().a((com.vivo.push.o)localObject1);
      return;
    }
    boolean bool = NotifyAdapterUtil.repealNotifyById(this.a, paramo.d());
    Object localObject1 = new StringBuilder("undo message ");
    ((StringBuilder)localObject1).append(paramo.d());
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(bool);
    com.vivo.push.util.o.d("OnUndoMsgTask", ((StringBuilder)localObject1).toString());
    if (bool)
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder("回收client通知成功, 上报埋点 1031, messageId = ");
      ((StringBuilder)localObject2).append(paramo.d());
      com.vivo.push.util.o.b((Context)localObject1, ((StringBuilder)localObject2).toString());
      com.vivo.push.util.e.a(this.a, paramo.d(), 1031L);
      return;
    }
    localObject1 = new StringBuilder("undo message fail，messageId = ");
    ((StringBuilder)localObject1).append(paramo.d());
    com.vivo.push.util.o.d("OnUndoMsgTask", ((StringBuilder)localObject1).toString());
    localObject1 = this.a;
    Object localObject2 = new StringBuilder("回收client通知失败，messageId = ");
    ((StringBuilder)localObject2).append(paramo.d());
    com.vivo.push.util.o.c((Context)localObject1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.ae
 * JD-Core Version:    0.7.0.1
 */