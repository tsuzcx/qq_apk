package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils.FileModelOpenVideoBrowser;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

class QQFileTempUtilsImpl$11
  implements CUKingCardHelper.CUKingDialogListener
{
  QQFileTempUtilsImpl$11(QQFileTempUtilsImpl paramQQFileTempUtilsImpl, IQQFileTempUtils.FileModelOpenVideoBrowser paramFileModelOpenVideoBrowser, Activity paramActivity, int paramInt) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {
      this.a.a(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileTempUtilsImpl.11
 * JD-Core Version:    0.7.0.1
 */