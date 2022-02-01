package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.repo.account.api.BaseOx978RespCallBack;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationResult;

class UserOperationModule$4
  implements Runnable
{
  UserOperationModule$4(UserOperationModule paramUserOperationModule, BaseOx978RespCallBack paramBaseOx978RespCallBack, String paramString, oidb_cmd0x978.OneFollowOperationResult paramOneFollowOperationResult) {}
  
  public void run()
  {
    ((Ox978RespCallBack)this.a).a(true, this.b, this.c.enum_follow_status.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.4
 * JD-Core Version:    0.7.0.1
 */