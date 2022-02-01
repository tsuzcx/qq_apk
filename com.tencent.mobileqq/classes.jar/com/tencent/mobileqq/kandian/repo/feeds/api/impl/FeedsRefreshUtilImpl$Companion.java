package com.tencent.mobileqq.kandian.repo.feeds.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/impl/FeedsRefreshUtilImpl$Companion;", "", "()V", "CLEAR_TIME_HOUR", "", "SP_KEY_CONTENT_FLUSH_NUM_DAY", "", "SP_KEY_CONTENT_FLUSH_NUM_DAY_UPDATE_DATE", "TAG", "contentFlushNumProcess", "isNeedToResetData", "", "currentTimeMillis", "", "recordChannelRefreshTimes", "", "channelId", "storeUpdateDate", "updateContentFlushNum", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FeedsRefreshUtilImpl$Companion
{
  private final boolean b(long paramLong)
  {
    String str1 = (String)RIJSPUtils.b("sp_key_rij_content_flush_num_day_update_date", "");
    long l = 14400000;
    String str2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong - l));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateContentFlushNumDay], lastUpdateDate = ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", updateDate = ");
    localStringBuilder.append(str2);
    QLog.i("FeedsRefreshUtilImpl", 1, localStringBuilder.toString());
    return TextUtils.equals((CharSequence)str1, (CharSequence)str2) ^ true;
  }
  
  private final void c(long paramLong)
  {
    long l = 14400000;
    RIJSPUtils.a("sp_key_rij_content_flush_num_day_update_date", new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong - l)));
  }
  
  public final void a(int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      ((Companion)this).a(paramLong);
    }
  }
  
  public final void a(long paramLong)
  {
    Object localObject = (Companion)this;
    boolean bool = ((Companion)localObject).b(paramLong);
    Integer localInteger = Integer.valueOf(0);
    if (bool)
    {
      FeedsRefreshUtilImpl.access$setContentFlushNumProcess$cp(0);
      RIJSPUtils.a("sp_key_rij_content_flush_num_day", localInteger);
    }
    FeedsRefreshUtilImpl.access$setContentFlushNumProcess$cp(FeedsRefreshUtilImpl.access$getContentFlushNumProcess$cp() + 1);
    RIJSPUtils.a("sp_key_rij_content_flush_num_day", Integer.valueOf(((Integer)RIJSPUtils.b("sp_key_rij_content_flush_num_day", localInteger)).intValue() + 1));
    ((Companion)localObject).c(paramLong);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[updateContentFlushNum] timeStamp = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(", contentFlushNumProcess = ");
    ((StringBuilder)localObject).append(FeedsRefreshUtilImpl.access$getContentFlushNumProcess$cp());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(", contentFlushNumDay = ");
    ((StringBuilder)localObject).append((Integer)RIJSPUtils.b("sp_key_rij_content_flush_num_day", localInteger));
    QLog.i("FeedsRefreshUtilImpl", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.impl.FeedsRefreshUtilImpl.Companion
 * JD-Core Version:    0.7.0.1
 */