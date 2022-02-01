package com.tencent.mobileqq.qwallet.transaction.impl;

import Wallet.PfaFriendRsp;

class ToPayManagerImpl$1$1
  implements Runnable
{
  ToPayManagerImpl$1$1(ToPayManagerImpl.1 param1, PfaFriendRsp paramPfaFriendRsp) {}
  
  public void run()
  {
    boolean bool;
    if (this.a != null) {
      bool = true;
    } else {
      bool = false;
    }
    ToPayManagerImpl.onGetRecomendList(bool, this.a, true);
    if (this.b.c) {
      ToPayManagerImpl.refreshFromNet(this.b.a, this.b.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl.1.1
 * JD-Core Version:    0.7.0.1
 */