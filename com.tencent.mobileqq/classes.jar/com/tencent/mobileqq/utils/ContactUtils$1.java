package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;

final class ContactUtils$1
  implements Runnable
{
  ContactUtils$1(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ContactUtils.OnGetTroopMemberNameCallback paramOnGetTroopMemberNameCallback) {}
  
  public void run()
  {
    String str = ContactUtils.getTroopMemberName(this.val$app, this.val$troopUin, this.val$memberUin, true);
    if (this.val$troopMemberNameCallback != null) {
      this.val$troopMemberNameCallback.onGetTroopMemberName(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactUtils.1
 * JD-Core Version:    0.7.0.1
 */