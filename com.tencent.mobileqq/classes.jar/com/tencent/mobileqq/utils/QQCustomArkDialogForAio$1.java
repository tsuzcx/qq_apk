package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;

class QQCustomArkDialogForAio$1
  implements ArkAppContainer.ArkAppModuleCallback
{
  QQCustomArkDialogForAio$1(QQCustomArkDialogForAio paramQQCustomArkDialogForAio) {}
  
  public boolean a(ArkAppContainer paramArkAppContainer)
  {
    if (this.a.isShowing())
    {
      this.a.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialogForAio.1
 * JD-Core Version:    0.7.0.1
 */