package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetSkinListRsp;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

class RedPacketManagerImpl$1$1
  implements Runnable
{
  RedPacketManagerImpl$1$1(RedPacketManagerImpl.1 param1, GetSkinListRsp paramGetSkinListRsp) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("rsp", this.jdField_a_of_type_WalletGetSkinListRsp);
    localBundle.putBoolean("isCache", true);
    if (RedPacketManagerImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$1.this$0).isEmpty()) {
      return;
    }
    Iterator localIterator = RedPacketManagerImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqQwalletHbImplRedPacketManagerImpl$1.this$0).iterator();
    while (localIterator.hasNext()) {
      ((BusinessObserver)localIterator.next()).onReceive(14, true, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.1.1
 * JD-Core Version:    0.7.0.1
 */