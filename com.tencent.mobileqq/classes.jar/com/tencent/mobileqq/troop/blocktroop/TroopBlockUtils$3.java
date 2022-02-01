package com.tencent.mobileqq.troop.blocktroop;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class TroopBlockUtils$3
  implements DialogInterface.OnClickListener
{
  TroopBlockUtils$3(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if ((NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) && (paramDialogInterface != null))
    {
      paramDialogInterface.j(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramDialogInterface != null)
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131694510), 0).a();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131692165), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils.3
 * JD-Core Version:    0.7.0.1
 */