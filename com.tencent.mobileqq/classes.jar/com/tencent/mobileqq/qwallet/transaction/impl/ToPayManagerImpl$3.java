package com.tencent.mobileqq.qwallet.transaction.impl;

import Wallet.PfaFriendRsp;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qroute.QRoute;

final class ToPayManagerImpl$3
  extends Handler
{
  ToPayManagerImpl$3(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QWalletAuthHandler$TYPE_GET_RECENT_LIST())
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof PfaFriendRsp)) {
          localObject1 = (PfaFriendRsp)paramMessage.obj;
        }
      }
      int i = paramMessage.arg1;
      boolean bool2 = false;
      boolean bool1;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramMessage.arg2 == 1) {
        bool2 = true;
      }
      ToPayManagerImpl.onGetRecomendList(bool1, (PfaFriendRsp)localObject1, bool2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */