package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler;

class BindGroupFragment$4
  implements DialogInterface.OnClickListener
{
  BindGroupFragment$4(BindGroupFragment paramBindGroupFragment, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      BindGroupFragment.a(this.b, HardCodeUtil.a(2131899345));
      ((ITroopTokenHandler)BindGroupFragment.b(this.b).getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).a(Integer.valueOf(BindGroupFragment.c(this.b)).intValue(), Integer.valueOf(BindGroupFragment.d(this.b)).intValue(), Long.valueOf(this.a).longValue(), BindGroupFragment.e(this.b));
      return;
    }
    if (paramInt == 0) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment.4
 * JD-Core Version:    0.7.0.1
 */