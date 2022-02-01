package com.tencent.mobileqq.kandian.glue.report;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.image.AggregateAvatarUrlDrawable;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

final class RIJTransMergeKanDianReport$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  RIJTransMergeKanDianReport$1(long paramLong, AggregateAvatarUrlDrawable paramAggregateAvatarUrlDrawable) {}
  
  public void onLoadUserInfoFailed(@Nullable String paramString1, @Nullable String paramString2)
  {
    QLog.d("RIJTransMergeKanDianReport", 2, "onLoadUserInfoFailed");
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
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.1
 * JD-Core Version:    0.7.0.1
 */