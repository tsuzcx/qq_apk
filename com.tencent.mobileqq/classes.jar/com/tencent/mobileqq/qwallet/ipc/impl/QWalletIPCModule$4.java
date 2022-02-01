package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiGifHelper.OnConvertListener;
import eipc.EIPCResult;

class QWalletIPCModule$4
  implements EmojiGifHelper.OnConvertListener
{
  QWalletIPCModule$4(QWalletIPCModule paramQWalletIPCModule, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("res", paramBoolean);
    localBundle.putString("path", paramString);
    this.b.callbackResult(this.a, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.4
 * JD-Core Version:    0.7.0.1
 */