package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class EmojiGifHelper$1
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      boolean bool = paramEIPCResult.data.getBoolean("res", false);
      paramEIPCResult = paramEIPCResult.data.getString("path", "");
      EmojiGifHelper.OnConvertListener localOnConvertListener = this.a;
      if (localOnConvertListener != null) {
        localOnConvertListener.a(bool, paramEIPCResult);
      }
    }
    else
    {
      paramEIPCResult = this.a;
      if (paramEIPCResult != null) {
        paramEIPCResult.a(false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiGifHelper.1
 * JD-Core Version:    0.7.0.1
 */