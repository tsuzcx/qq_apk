package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class UserOperationModule$1$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  UserOperationModule$1$1(UserOperationModule.1 param1) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handle0x978Resp onLoadUserInfoFailed, uin=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString2);
    QLog.e("UserOperationModule", 1, localStringBuilder.toString());
    UserOperationModule.access$000(this.a.this$0, this.a.c, "", this.a.b, 2, this.a.d);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null) {
      paramString = paramReadInJoyUserInfo.faceUrl;
    } else {
      paramString = "";
    }
    UserOperationModule.access$000(this.a.this$0, this.a.c, paramString, this.a.b, 2, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.1.1
 * JD-Core Version:    0.7.0.1
 */