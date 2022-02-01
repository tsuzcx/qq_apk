package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.repo.account.api.BaseOx978RespCallBack;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;

class UserOperationModule$5
  implements Runnable
{
  UserOperationModule$5(UserOperationModule paramUserOperationModule, boolean paramBoolean, BaseOx978RespCallBack paramBaseOx978RespCallBack, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      UserOperationModule.BatchFollowCallBack localBatchFollowCallBack = (UserOperationModule.BatchFollowCallBack)this.jdField_a_of_type_ComTencentMobileqqKandianRepoAccountApiBaseOx978RespCallBack;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("");
      localBatchFollowCallBack.a(false, null, localStringBuilder.toString());
      return;
    }
    ((Ox978RespCallBack)this.jdField_a_of_type_ComTencentMobileqqKandianRepoAccountApiBaseOx978RespCallBack).a(false, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.5
 * JD-Core Version:    0.7.0.1
 */