package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profile.like.OnPraiseSetCallback;
import com.tencent.mobileqq.profile.like.PraiseManager;
import java.lang.ref.WeakReference;

class MessengerService$IncomingHandler$22
  implements OnPraiseSetCallback
{
  MessengerService$IncomingHandler$22(MessengerService.IncomingHandler paramIncomingHandler) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    MessengerService localMessengerService = (MessengerService)this.a.a.get();
    if (localMessengerService != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt2);
      localBundle.putInt("code", paramInt1);
      localBundle.putString("url", paramString);
      paramBundle.putBundle("response", localBundle);
      localMessengerService.a(paramBundle);
      if ((paramInt1 == 0) && (MessengerService.e(localMessengerService) != null) && ((MessengerService.f(localMessengerService) instanceof QQAppInterface))) {
        ((PraiseManager)((QQAppInterface)MessengerService.g(localMessengerService)).getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).a(paramInt2, true, "from_praise_mall");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.22
 * JD-Core Version:    0.7.0.1
 */