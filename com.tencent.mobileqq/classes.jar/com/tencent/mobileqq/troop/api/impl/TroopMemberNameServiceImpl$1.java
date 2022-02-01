package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.troop.api.ITroopMemberNameService.OnGetTroopMemberNameCallback;

class TroopMemberNameServiceImpl$1
  implements Runnable
{
  TroopMemberNameServiceImpl$1(TroopMemberNameServiceImpl paramTroopMemberNameServiceImpl, String paramString1, String paramString2, ITroopMemberNameService.OnGetTroopMemberNameCallback paramOnGetTroopMemberNameCallback) {}
  
  public void run()
  {
    String str = this.this$0.getTroopMemberName(this.a, this.b, true, false);
    ITroopMemberNameService.OnGetTroopMemberNameCallback localOnGetTroopMemberNameCallback = this.c;
    if (localOnGetTroopMemberNameCallback != null) {
      localOnGetTroopMemberNameCallback.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberNameServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */