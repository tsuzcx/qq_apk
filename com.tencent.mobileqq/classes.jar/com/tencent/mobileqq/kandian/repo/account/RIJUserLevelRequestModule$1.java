package com.tencent.mobileqq.kandian.repo.account;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;

class RIJUserLevelRequestModule$1
  implements Runnable
{
  RIJUserLevelRequestModule$1(RIJUserLevelRequestModule paramRIJUserLevelRequestModule, oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(new RIJUserLevelRequestModule.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.RIJUserLevelRequestModule.1
 * JD-Core Version:    0.7.0.1
 */