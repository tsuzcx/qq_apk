package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationResult;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

class UserOperationModule$3$1
  implements Runnable
{
  UserOperationModule$3$1(UserOperationModule.3 param3) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.rpt_follow_operation_result.get().iterator();
    while (localIterator.hasNext())
    {
      oidb_cmd0x978.OneFollowOperationResult localOneFollowOperationResult = (oidb_cmd0x978.OneFollowOperationResult)localIterator.next();
      ReadInJoyLogicEngine.a().c(localOneFollowOperationResult.uint64_dst_uin.get(), localOneFollowOperationResult.enum_follow_status.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.3.1
 * JD-Core Version:    0.7.0.1
 */