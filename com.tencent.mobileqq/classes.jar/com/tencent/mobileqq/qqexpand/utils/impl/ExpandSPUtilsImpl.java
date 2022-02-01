package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.mobileqq.qqexpand.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/impl/ExpandSPUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/IExpandSPUtils;", "()V", "canPopDialog", "", "popStateName", "", "getGreetLimitCode", "", "uin", "getGreetLimitString", "getGreetLimitTime", "", "setExtendFriendsConfigTaskId", "", "taskId", "setGreetLimit", "code", "tips", "setUserCategoryPullTime", "time", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandSPUtilsImpl
  implements IExpandSPUtils
{
  public boolean canPopDialog(@Nullable String paramString)
  {
    return ExpandSharePreUtils.d(paramString);
  }
  
  public int getGreetLimitCode(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    return ExpandSharePreUtils.g(paramString);
  }
  
  @Nullable
  public String getGreetLimitString(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    return ExpandSharePreUtils.h(paramString);
  }
  
  public long getGreetLimitTime(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    return ExpandSharePreUtils.i(paramString);
  }
  
  public void setExtendFriendsConfigTaskId(@Nullable String paramString1, @Nullable String paramString2)
  {
    ExpandSharePreUtils.a(paramString1, paramString2);
  }
  
  public void setGreetLimit(@NotNull String paramString1, int paramInt, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    ExpandSharePreUtils.a(paramString1, paramInt, paramString2);
  }
  
  public void setUserCategoryPullTime(@Nullable String paramString, long paramLong)
  {
    ExpandSharePreUtils.b(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.ExpandSPUtilsImpl
 * JD-Core Version:    0.7.0.1
 */