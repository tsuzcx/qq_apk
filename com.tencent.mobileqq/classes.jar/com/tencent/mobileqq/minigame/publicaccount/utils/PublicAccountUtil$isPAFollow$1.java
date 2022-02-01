package com.tencent.mobileqq.minigame.publicaccount.utils;

import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublicAccountUtil$isPAFollow$1
  implements Runnable
{
  PublicAccountUtil$isPAFollow$1(IPublicAccountDataManager paramIPublicAccountDataManager, long paramLong, Bundle paramBundle, MiniAppTransferModule paramMiniAppTransferModule, int paramInt) {}
  
  public final void run()
  {
    IPublicAccountDetail localIPublicAccountDetail = this.$pam.findAccountDetailInfo(String.valueOf(this.$pAUin));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isPAFollow] accountDetail followType=");
      int i;
      if (localIPublicAccountDetail != null) {
        i = localIPublicAccountDetail.getFollowType();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("PublicAccountUtil", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.$result;
    boolean bool = true;
    if ((localIPublicAccountDetail == null) || (localIPublicAccountDetail.getFollowType() != 1)) {
      bool = false;
    }
    ((Bundle)localObject).putBoolean("pa_is_follow", bool);
    this.$transferModule.callbackResult(this.$callbackId, EIPCResult.createResult(0, this.$result));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil.isPAFollow.1
 * JD-Core Version:    0.7.0.1
 */