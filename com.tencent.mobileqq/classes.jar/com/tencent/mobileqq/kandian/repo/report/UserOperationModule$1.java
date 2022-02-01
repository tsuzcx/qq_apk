package com.tencent.mobileqq.kandian.repo.report;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class UserOperationModule$1
  implements Runnable
{
  UserOperationModule$1(UserOperationModule paramUserOperationModule, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      QLog.i("UserOperationModule", 1, "avatarUrl is empty, request userInfo");
      ReadInJoyUserInfoModule localReadInJoyUserInfoModule = UserOperationModule.getUserInfoModule();
      if (localReadInJoyUserInfoModule == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b);
      localReadInJoyUserInfoModule.a(localArrayList, new UserOperationModule.1.1(this));
      return;
    }
    UserOperationModule.access$000(this.this$0, this.c, this.a, this.b, 2, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.1
 * JD-Core Version:    0.7.0.1
 */