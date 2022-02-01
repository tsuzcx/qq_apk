package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

class QQFileTempUtilsImpl$6
  implements CUKingCardHelper.CUKingDialogListener
{
  QQFileTempUtilsImpl$6(QQFileTempUtilsImpl paramQQFileTempUtilsImpl, FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFMDialogUtil$FMDialogInterface.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFMDialogUtil$FMDialogInterface.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileTempUtilsImpl.6
 * JD-Core Version:    0.7.0.1
 */