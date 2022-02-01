package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.image.AggregateAvatarUrlDrawable;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

final class KandianSubscribeManager$5
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  KandianSubscribeManager$5(long paramLong, AggregateAvatarUrlDrawable paramAggregateAvatarUrlDrawable) {}
  
  public void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2)
  {
    QLog.d(KandianSubscribeManager.a, 2, "onLoadUserInfoFailed");
  }
  
  public void onLoadUserInfoSucceed(@Nullable String paramString, @Nullable ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (TextUtils.equals(paramString, String.valueOf(this.a)))
    {
      if (paramReadInJoyUserInfo == null) {
        return;
      }
      this.b.a(ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager.5
 * JD-Core Version:    0.7.0.1
 */