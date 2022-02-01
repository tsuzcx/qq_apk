package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

final class FileManagerUtil$19
  implements CUKingCardHelper.CUKingDialogListener
{
  FileManagerUtil$19(FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.a.a();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.19
 * JD-Core Version:    0.7.0.1
 */