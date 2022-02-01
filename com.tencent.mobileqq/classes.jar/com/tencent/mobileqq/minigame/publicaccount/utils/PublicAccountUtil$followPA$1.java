package com.tencent.mobileqq.minigame.publicaccount.utils;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/minigame/publicaccount/utils/PublicAccountUtil$followPA$1", "Lcom/tencent/biz/pubaccount/api/IPublicAccountObserver$OnCallback;", "onFollowPublicAccount", "", "isSuccess", "", "uin", "", "onUnfollowPublicAccount", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class PublicAccountUtil$followPA$1
  extends IPublicAccountObserver.OnCallback
{
  PublicAccountUtil$followPA$1(MiniAppTransferModule paramMiniAppTransferModule, int paramInt) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, @Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[followPA] onFollowPublicAccount isSuccess=");
      paramString.append(paramBoolean);
      QLog.d("PublicAccountUtil", 2, paramString.toString());
    }
    PublicAccountUtil.access$followPACallBack(PublicAccountUtil.INSTANCE, paramBoolean, this.$transferModule, this.$callbackId);
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, @Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[followPA] onUnfollowPublicAccount isSuccess=");
      paramString.append(paramBoolean);
      QLog.d("PublicAccountUtil", 2, paramString.toString());
    }
    PublicAccountUtil.access$followPACallBack(PublicAccountUtil.INSTANCE, paramBoolean, this.$transferModule, this.$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil.followPA.1
 * JD-Core Version:    0.7.0.1
 */