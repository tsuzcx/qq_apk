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
    paramString2 = (MessengerService)this.a.a.get();
    if (paramString2 == null) {}
    do
    {
      do
      {
        return;
      } while ((paramLong != 15L) || (!paramString1.startsWith("card.")));
      paramString1 = new Bundle();
    } while ((this == null) || (this.a.a.get() == null) || (paramString2.d == null));
    paramString2.d.putString("cmd", "card_download");
    paramString1.putInt("result", paramInt1);
    paramString1.putString("message", paramString3);
    paramString2.d.putBundle("response", paramString1);
    paramString2.a(paramString2.d);
    paramString2.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.1
 * JD-Core Version:    0.7.0.1
 */