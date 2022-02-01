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
    paramDialogInterface = (ITroopMngHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) && (paramDialogInterface != null))
    {
      paramDialogInterface.b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramDialogInterface != null)
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131694475), 0).a();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131692085), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils.2
 * JD-Core Version:    0.7.0.1
 */