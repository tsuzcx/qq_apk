package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class OpenWeiyunVipHelperImpl$1
  implements DialogInterface.OnClickListener
{
  OpenWeiyunVipHelperImpl$1(OpenWeiyunVipHelperImpl paramOpenWeiyunVipHelperImpl, int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.c.isNonVipSpaceOverErrorCode(this.a))
    {
      this.c.startOpenWeiyunVipCompareH5(this.b, null, false);
      return;
    }
    this.c.startOpenQQVipH5(this.b, "mvip.n.a.zcwy_popup", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.OpenWeiyunVipHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */