package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

class QQFileTempUtilsImpl$9
  implements CUKingCardHelper.CUKingDialogListener
{
  QQFileTempUtilsImpl$9(QQFileTempUtilsImpl paramQQFileTempUtilsImpl, FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      this.a.b();
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileTempUtilsImpl.9
 * JD-Core Version:    0.7.0.1
 */