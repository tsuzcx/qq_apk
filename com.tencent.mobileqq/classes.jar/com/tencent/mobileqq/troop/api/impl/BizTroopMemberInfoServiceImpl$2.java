package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import mqq.app.AppRuntime;

class BizTroopMemberInfoServiceImpl$2
  implements Runnable
{
  BizTroopMemberInfoServiceImpl$2(BizTroopMemberInfoServiceImpl paramBizTroopMemberInfoServiceImpl, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    ((ITroopMemberInfoService)this.this$0.mApp.getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMember(this.a, this.b, this.c, -100, null, null, -100, -100, -100, -100L, -100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopMemberInfoServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */