package com.tencent.mobileqq.guild.live.viewmodel.module;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGuildAnchorInfoVM$4
  implements IGetUserInfoCallback
{
  QQGuildAnchorInfoVM$4(QQGuildAnchorInfoVM paramQQGuildAnchorInfoVM, String paramString) {}
  
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    if (QLog.isColorLevel())
    {
      paramList1 = new StringBuilder();
      paramList1.append("fetchUserInfo result:");
      paramList1.append(paramInt);
      paramList1.append(" errMsg:");
      paramList1.append(paramString);
      QLog.i("QGL.QQGuildAnchorInfoVM", 1, paramList1.toString());
    }
    if (paramInt == 0)
    {
      paramString = QQGuildAnchorInfoVM.a(this.b, paramList, this.a);
      if (paramString != null) {
        QQGuildAnchorInfoVM.b(this.b, QQGuildUtil.a(paramString));
      }
    }
    else if (paramInt == 23000)
    {
      QQGuildAnchorInfoVM.d(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildAnchorInfoVM.4
 * JD-Core Version:    0.7.0.1
 */