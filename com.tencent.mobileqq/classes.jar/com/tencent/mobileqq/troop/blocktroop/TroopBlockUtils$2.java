package com.tencent.mobileqq.troop.blocktroop;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class TroopBlockUtils$2
  implements DialogInterface.OnClickListener
{
  TroopBlockUtils$2(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (ITroopMngHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    if ((NetworkUtil.isNetSupport(this.a.getApp().getApplicationContext())) && (paramDialogInterface != null))
    {
      paramDialogInterface.b(this.b);
      return;
    }
    if (paramDialogInterface != null)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131892157), 0).show();
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131889057), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils.2
 * JD-Core Version:    0.7.0.1
 */