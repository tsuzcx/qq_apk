package com.tencent.mobileqq.kandian.repo.feeds.api.impl;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.api.IFeedsRefreshUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/impl/FeedsRefreshUtilImpl;", "Lcom/tencent/mobileqq/kandian/repo/feeds/api/IFeedsRefreshUtil;", "()V", "getContentFlushNumDay", "", "currentTimeMillis", "", "getContentFlushNumProcess", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FeedsRefreshUtilImpl
  implements IFeedsRefreshUtil
{
  private static final int CLEAR_TIME_HOUR = 4;
  public static final FeedsRefreshUtilImpl.Companion Companion = new FeedsRefreshUtilImpl.Companion(null);
  @NotNull
  public static final String SP_KEY_CONTENT_FLUSH_NUM_DAY = "sp_key_rij_content_flush_num_day";
  @NotNull
  public static final String SP_KEY_CONTENT_FLUSH_NUM_DAY_UPDATE_DATE = "sp_key_rij_content_flush_num_day_update_date";
  @NotNull
  public static final String TAG = "FeedsRefreshUtilImpl";
  private static int contentFlushNumProcess;
  
  public int getContentFlushNumDay(long paramLong)
  {
    if (FeedsRefreshUtilImpl.Companion.a(Companion, paramLong)) {
      return 0;
    }
    Object localObject = RIJSPUtils.a("sp_key_rij_content_flush_num_day", Integer.valueOf(0));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…CONTENT_FLUSH_NUM_DAY, 0)");
    return ((Number)localObject).intValue();
  }
  
  public int getContentFlushNumProcess(long paramLong)
  {
    if (FeedsRefreshUtilImpl.Companion.a(Companion, paramLong)) {
      return 0;
    }
    return contentFlushNumProcess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.impl.FeedsRefreshUtilImpl
 * JD-Core Version:    0.7.0.1
 */