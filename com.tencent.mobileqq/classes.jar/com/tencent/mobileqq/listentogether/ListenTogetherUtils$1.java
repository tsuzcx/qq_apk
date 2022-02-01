package com.tencent.mobileqq.listentogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

final class ListenTogetherUtils$1
  implements DialogInterface.OnClickListener
{
  ListenTogetherUtils$1(int paramInt1, String paramString1, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 1)
    {
      ((ListenTogetherHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(this.a, this.b, this.c, this.d);
      paramDialogInterface.dismiss();
      if (this.d == 1) {
        paramDialogInterface = "clk_openframe_open";
      } else {
        paramDialogInterface = "clk_joinbar_open";
      }
      if (this.a == 1) {
        bool1 = true;
      }
      ListenTogetherUtils.a(bool1, paramDialogInterface, this.b);
      return;
    }
    if (paramInt == 0)
    {
      paramDialogInterface.dismiss();
      if (this.d == 1) {
        paramDialogInterface = "clk_openframe_cancel";
      } else {
        paramDialogInterface = "clk_joinbar_cancel";
      }
      bool1 = bool2;
      if (this.a == 1) {
        bool1 = true;
      }
      ListenTogetherUtils.a(bool1, paramDialogInterface, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherUtils.1
 * JD-Core Version:    0.7.0.1
 */