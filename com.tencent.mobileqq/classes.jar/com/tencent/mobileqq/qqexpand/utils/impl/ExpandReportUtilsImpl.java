package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/impl/ExpandReportUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/IExpandReportUtils;", "()V", "getManageTestPlanParams", "", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "initReport", "", "onUserActionToTunnel", "event", "isSucc", "", "longElapse", "", "longSize", "params", "", "immediat", "var9", "reportEnterExpandClick", "from", "reportEnterExpandPage", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandReportUtilsImpl
  implements IExpandReportUtils
{
  @Nullable
  public String getManageTestPlanParams(@NotNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "appInterface");
    return ExpandReportUtils.a(paramBaseQQAppInterface);
  }
  
  public void initReport() {}
  
  public void onUserActionToTunnel(@NotNull String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, @Nullable Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "event");
    ExpandReportUtils.a(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public void onUserActionToTunnel(@NotNull String paramString, boolean paramBoolean, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "event");
    ExpandReportUtils.a(paramString, paramBoolean, paramMap);
  }
  
  public void reportEnterExpandClick(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "from");
    ExpandReportUtils.b(paramString);
  }
  
  public void reportEnterExpandPage(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "from");
    ExpandReportUtils.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.ExpandReportUtilsImpl
 * JD-Core Version:    0.7.0.1
 */