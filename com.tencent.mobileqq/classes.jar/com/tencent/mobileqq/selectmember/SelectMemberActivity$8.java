package com.tencent.mobileqq.selectmember;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class SelectMemberActivity$8
  implements Runnable
{
  SelectMemberActivity$8(SelectMemberActivity paramSelectMemberActivity, String paramString) {}
  
  public void run()
  {
    AppInterface localAppInterface = this.this$0.app;
    String str1 = this.a;
    String str2 = this.this$0.mGroupCode;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getMemberType(this.this$0.app, this.this$0.app.getCurrentAccountUin(), this.this$0.mGroupCode));
    localStringBuilder.append("");
    ReportController.b(localAppInterface, "dc00899", "invite_friend", "", "friend_list", str1, 0, 0, str2, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.8
 * JD-Core Version:    0.7.0.1
 */