package com.tencent.mobileqq.qwallet.transaction;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.observer.BusinessObserver;

public class NotifyMsgObserver
  implements BusinessObserver
{
  public void a(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 1) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("btype");
      String str = paramBundle.getString("bid");
      if ((((INotifyMsgApi)QRoute.api(INotifyMsgApi.class)).checkBusinessType(paramInt)) && (!TextUtils.isEmpty(str))) {
        a(paramInt, str, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.NotifyMsgObserver
 * JD-Core Version:    0.7.0.1
 */