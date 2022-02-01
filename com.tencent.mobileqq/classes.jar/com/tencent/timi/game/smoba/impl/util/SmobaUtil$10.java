package com.tencent.timi.game.smoba.impl.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;

final class SmobaUtil$10
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ISmobaService)ServiceCenter.a(ISmobaService.class)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaUtil.10
 * JD-Core Version:    0.7.0.1
 */