package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import java.lang.ref.WeakReference;

class MessengerService$IncomingHandler$22
  implements ThemeDiyStyleLogic.StyleCallBack
{
  MessengerService$IncomingHandler$22(MessengerService.IncomingHandler paramIncomingHandler) {}
  
  public int a(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    paramResData = (MessengerService)this.a.a.get();
    Bundle localBundle;
    if (paramResData != null)
    {
      localBundle = new Bundle();
      localBundle.putString("themeId", paramBundle.getString("themeId"));
      if (paramInt2 != 4) {
        break label73;
      }
    }
    label73:
    for (paramInt1 = 0;; paramInt1 = -2)
    {
      localBundle.putInt("themeStatus", paramInt1);
      paramBundle.putBundle("response", localBundle);
      paramResData.a(paramBundle);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.22
 * JD-Core Version:    0.7.0.1
 */