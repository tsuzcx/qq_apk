package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/IExpandSPUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "canPopDialog", "", "popStateName", "", "getGreetLimitCode", "", "uin", "getGreetLimitString", "getGreetLimitTime", "", "setExtendFriendsConfigTaskId", "", "taskId", "setGreetLimit", "code", "tips", "setUserCategoryPullTime", "time", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandSPUtils
  extends QRouteApi
{
  public abstract boolean canPopDialog(@Nullable String paramString);
  
  public abstract int getGreetLimitCode(@NotNull String paramString);
  
  @Nullable
  public abstract String getGreetLimitString(@NotNull String paramString);
  
  public abstract long getGreetLimitTime(@NotNull String paramString);
  
  public abstract void setExtendFriendsConfigTaskId(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void setGreetLimit(@NotNull String paramString1, int paramInt, @Nullable String paramString2);
  
  public abstract void setUserCategoryPullTime(@Nullable String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils
 * JD-Core Version:    0.7.0.1
 */