package com.tencent.mobileqq.werewolves;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

class WerewolvesPluginManager$1
  extends Handler
{
  WerewolvesPluginManager$1(WerewolvesPluginManager paramWerewolvesPluginManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    int j = paramMessage.what;
    if ((j != 1) && (j != 2)) {
      return;
    }
    ((WerewolvesHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).notifyUI(3, true, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesPluginManager.1
 * JD-Core Version:    0.7.0.1
 */