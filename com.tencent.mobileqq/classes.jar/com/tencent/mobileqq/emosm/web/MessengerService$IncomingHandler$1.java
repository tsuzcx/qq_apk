package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import java.lang.ref.WeakReference;

class MessengerService$IncomingHandler$1
  extends CallBacker
{
  MessengerService$IncomingHandler$1(MessengerService.IncomingHandler paramIncomingHandler) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramString2 = (MessengerService)this.a.b.get();
    if (paramString2 == null) {
      return;
    }
    if ((paramLong == 15L) && (paramString1.startsWith("card.")))
    {
      paramString1 = new Bundle();
      if (this.a.b.get() == null) {
        return;
      }
      if (paramString2.v != null)
      {
        paramString2.v.putString("cmd", "card_download");
        paramString1.putInt("result", paramInt1);
        paramString1.putString("message", paramString3);
        paramString2.v.putBundle("response", paramString1);
        paramString2.a(paramString2.v);
        paramString2.v = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.1
 * JD-Core Version:    0.7.0.1
 */