package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;

class MessengerService$IncomingHandler$8
  extends CallBacker
{
  MessengerService$IncomingHandler$8(MessengerService.IncomingHandler paramIncomingHandler, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 15L) && ("cardWZ.zip".equals(paramString1)))
    {
      if (this.a.l != null)
      {
        paramString1 = new Bundle();
        this.a.l.putString("cmd", "card_download_wzry_template");
        paramString1.putInt("result", paramInt1);
        paramString1.putString("message", paramString3);
        this.a.l.putBundle("response", paramString1);
        paramString1 = this.a;
        paramString1.a(paramString1.l);
        this.a.l = null;
      }
      paramString1 = (IVasQuickUpdateService)this.b.getRuntimeService(IVasQuickUpdateService.class, "");
      if (paramString1 != null) {
        paramString1.removeCallBacker(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.8
 * JD-Core Version:    0.7.0.1
 */