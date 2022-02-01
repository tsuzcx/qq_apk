package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import java.lang.ref.WeakReference;

class MessengerService$IncomingHandler$21
  implements ThemeDiyStyleLogic.StyleCallBack
{
  MessengerService$IncomingHandler$21(MessengerService.IncomingHandler paramIncomingHandler) {}
  
  public int a(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    paramResData = (MessengerService)this.a.a.get();
    if (paramResData != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("themeId", paramBundle.getString("themeId"));
      if (paramInt2 == 4) {
        paramInt1 = 0;
      } else {
        paramInt1 = -2;
      }
      localBundle.putInt("themeStatus", paramInt1);
      paramBundle.putBundle("response", localBundle);
      paramResData.a(paramBundle);
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.21
 * JD-Core Version:    0.7.0.1
 */