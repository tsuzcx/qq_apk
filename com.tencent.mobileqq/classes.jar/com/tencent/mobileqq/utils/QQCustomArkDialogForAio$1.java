package com.tencent.mobileqq.utils;

import agnx;
import agoa;

class QQCustomArkDialogForAio$1
  implements agoa
{
  QQCustomArkDialogForAio$1(QQCustomArkDialogForAio paramQQCustomArkDialogForAio) {}
  
  public boolean closeView(agnx paramagnx)
  {
    if (this.this$0.isShowing())
    {
      this.this$0.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean openCardView(agnx paramagnx, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialogForAio.1
 * JD-Core Version:    0.7.0.1
 */