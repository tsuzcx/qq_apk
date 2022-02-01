package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ExtendFriendNewEditFragment$20
  implements IExpandCmdCallback
{
  ExtendFriendNewEditFragment$20(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment) {}
  
  public void onProtocol(@Nullable ExpandReqInfo paramExpandReqInfo, @NotNull ExpandResponse paramExpandResponse)
  {
    if (paramExpandResponse.b() == 0)
    {
      QLog.d("ExtendFriendNewEditFragment", 1, "setExtendFriendInfo success");
      this.a.a(2, "保存成功", true);
      ExtendFriendNewEditFragment.a(this.a, true);
      return;
    }
    paramExpandReqInfo = new StringBuilder();
    paramExpandReqInfo.append("setExtendFriendInfo fail errorInfo:");
    paramExpandReqInfo.append(paramExpandResponse.d());
    QLog.e("ExtendFriendNewEditFragment", 1, paramExpandReqInfo.toString());
    this.a.a(1, "保存失败", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.20
 * JD-Core Version:    0.7.0.1
 */