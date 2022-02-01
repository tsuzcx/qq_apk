package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

class OldBigDataChannelManager$1
  extends AccountObserver
{
  OldBigDataChannelManager$1(OldBigDataChannelManager paramOldBigDataChannelManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.getFileThreadHandler().post(new OldBigDataChannelManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.OldBigDataChannelManager.1
 * JD-Core Version:    0.7.0.1
 */