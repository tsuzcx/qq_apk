package com.tencent.mobileqq.kandian.glue.account;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog.DialogClick;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "params", "", "kotlin.jvm.PlatformType", "click"}, k=3, mv={1, 1, 16})
final class RIJUserLevelDenyCallback$showErrorDialog$1
  implements RIJUserLevelDialog.DialogClick
{
  RIJUserLevelDenyCallback$showErrorDialog$1(Context paramContext, UserLevelInfo paramUserLevelInfo) {}
  
  public final void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoAccountUserLevelInfo.jumpUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.account.RIJUserLevelDenyCallback.showErrorDialog.1
 * JD-Core Version:    0.7.0.1
 */