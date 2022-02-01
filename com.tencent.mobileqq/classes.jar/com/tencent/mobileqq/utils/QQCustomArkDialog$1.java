package com.tencent.mobileqq.utils;

import afvi;
import afvl;

class QQCustomArkDialog$1
  implements afvl
{
  QQCustomArkDialog$1(QQCustomArkDialog paramQQCustomArkDialog) {}
  
  public boolean closeView(afvi paramafvi)
  {
    if (this.this$0.isShowing())
    {
      this.this$0.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean openCardView(afvi paramafvi, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.1
 * JD-Core Version:    0.7.0.1
 */