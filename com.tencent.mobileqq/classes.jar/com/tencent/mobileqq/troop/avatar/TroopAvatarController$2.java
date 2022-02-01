package com.tencent.mobileqq.troop.avatar;

import mqq.observer.AccountObserver;

class TroopAvatarController$2
  extends AccountObserver
{
  TroopAvatarController$2(TroopAvatarController paramTroopAvatarController) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      TroopAvatarController.b(this.a, null);
      TroopAvatarController.a(this.a, null);
      this.a.d();
      return;
    }
    paramString2 = this.a;
    paramString2.u = paramString1;
    paramString2.a(TroopAvatarController.a(paramString2), this.a.s);
    TroopAvatarController.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarController.2
 * JD-Core Version:    0.7.0.1
 */