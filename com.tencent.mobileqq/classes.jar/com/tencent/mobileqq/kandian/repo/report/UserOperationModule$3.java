package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.account.api.BaseOx978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.follow.BatchFollowModel;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

class UserOperationModule$3
  implements Runnable
{
  UserOperationModule$3(UserOperationModule paramUserOperationModule, ArrayList paramArrayList, oidb_cmd0x978.RspFollowOperationResult paramRspFollowOperationResult, BaseOx978RespCallBack paramBaseOx978RespCallBack) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(((BatchFollowModel)this.a.get(i)).a, ((BatchFollowModel)this.a.get(i)).c);
      i += 1;
    }
    ThreadManager.post(new UserOperationModule.3.1(this), 5, null, true);
    ((UserOperationModule.BatchFollowCallBack)this.c).a(true, this.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.3
 * JD-Core Version:    0.7.0.1
 */