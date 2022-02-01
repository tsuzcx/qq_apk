package com.tencent.mobileqq.guild.message;

import android.os.Handler;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;

class GuildRandomGetMessageLoader$1
  implements Runnable
{
  GuildRandomGetMessageLoader$1(GuildRandomGetMessageLoader paramGuildRandomGetMessageLoader, RefreshMessageContext paramRefreshMessageContext, int paramInt1, String paramString, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3) {}
  
  public void run()
  {
    this.this$0.b.b(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("GuildRandomGetMessageLoader", 2, "refreshUnreadMessage begin");
    }
    RefreshMessageContext localRefreshMessageContext = this.a;
    int j = this.b;
    localRefreshMessageContext.r = j;
    localRefreshMessageContext.l = 0;
    GuildRandomGetMessageLoader.a(this.this$0, this.c, this.d, this.e, j, this.f, localRefreshMessageContext, this.g);
    boolean bool = GuildRandomGetMessageLoader.a(this.this$0, this.c, this.d, this.e, this.f, this.b);
    QLog.d("GuildRandomGetMessageLoader", 1, new Object[] { "refreshTroopUnreadMessage isSuccess:", Boolean.valueOf(bool) });
    if ((bool) && (this.h)) {
      this.this$0.b.a(this.d, this.c, this.i, this.this$0.b.a(this.c, this.d));
    }
    this.a.i = bool;
    if (this.g) {
      this.this$0.b.b.setChangeAndNotify(this.a);
    }
    this.this$0.b.b.getFacadeHandler().post(new GuildRandomGetMessageLoader.1.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("GuildRandomGetMessageLoader", 2, "refreshTroopUnreadMessage end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildRandomGetMessageLoader.1
 * JD-Core Version:    0.7.0.1
 */