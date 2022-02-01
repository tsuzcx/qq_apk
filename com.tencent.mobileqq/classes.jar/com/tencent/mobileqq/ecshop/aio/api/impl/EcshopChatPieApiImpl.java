package com.tencent.mobileqq.ecshop.aio.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.ecshop.aio.EcshopQggChatPie;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieCallback;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieDelegate;
import com.tencent.mobileqq.ecshop.aio.api.IEcshopChatPieApi;
import org.jetbrains.annotations.NotNull;

public class EcshopChatPieApiImpl
  implements IEcshopChatPieApi
{
  @NotNull
  public IEcshopChatPieDelegate createEcshopChatPie(@NotNull Intent paramIntent, @NotNull IEcshopChatPieCallback paramIEcshopChatPieCallback)
  {
    return new EcshopQggChatPie(paramIntent, paramIEcshopChatPieCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.aio.api.impl.EcshopChatPieApiImpl
 * JD-Core Version:    0.7.0.1
 */