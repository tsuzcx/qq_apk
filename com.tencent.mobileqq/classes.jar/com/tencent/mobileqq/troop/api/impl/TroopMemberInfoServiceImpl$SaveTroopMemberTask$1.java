package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;

class TroopMemberInfoServiceImpl$SaveTroopMemberTask$1
  implements Runnable
{
  TroopMemberInfoServiceImpl$SaveTroopMemberTask$1(TroopMemberInfoServiceImpl.SaveTroopMemberTask paramSaveTroopMemberTask) {}
  
  public void run()
  {
    this.a.this$0.notifyChangeMember(this.a.a.troopuin, this.a.a.memberuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.SaveTroopMemberTask.1
 * JD-Core Version:    0.7.0.1
 */