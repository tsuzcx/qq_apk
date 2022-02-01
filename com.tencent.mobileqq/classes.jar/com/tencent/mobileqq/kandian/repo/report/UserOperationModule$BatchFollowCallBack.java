package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.repo.account.api.BaseOx978RespCallBack;
import com.tencent.mobileqq.kandian.repo.follow.BatchFollowModel;
import java.util.ArrayList;

public abstract interface UserOperationModule$BatchFollowCallBack
  extends BaseOx978RespCallBack
{
  public abstract void a(boolean paramBoolean, ArrayList<BatchFollowModel> paramArrayList, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.BatchFollowCallBack
 * JD-Core Version:    0.7.0.1
 */