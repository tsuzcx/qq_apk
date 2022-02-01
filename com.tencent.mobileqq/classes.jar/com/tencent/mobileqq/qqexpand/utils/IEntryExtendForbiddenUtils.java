package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandForbiddenInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/IEntryExtendForbiddenUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDialogMessage", "Landroid/text/SpannableStringBuilder;", "activity", "Landroid/app/Activity;", "tip", "", "isForbidForever", "", "remainingTime", "", "isForbidden", "getForbiddenInfo", "Lcom/tencent/mobileqq/qqexpand/bean/profile/ExpandForbiddenInfo;", "app", "Lmqq/app/AppRuntime;", "isNeedShowDiaLog", "context", "Landroid/content/Context;", "isNetSupport", "showDialog", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEntryExtendForbiddenUtils
  extends QRouteApi
{
  @Nullable
  public abstract SpannableStringBuilder getDialogMessage(@Nullable Activity paramActivity, @Nullable String paramString, boolean paramBoolean1, long paramLong, boolean paramBoolean2);
  
  @NotNull
  public abstract ExpandForbiddenInfo getForbiddenInfo(@NotNull AppRuntime paramAppRuntime);
  
  public abstract boolean isNeedShowDiaLog(@NotNull Context paramContext, @NotNull AppRuntime paramAppRuntime);
  
  public abstract boolean isNetSupport(@NotNull Context paramContext);
  
  public abstract void showDialog(@NotNull Activity paramActivity, @NotNull AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils
 * JD-Core Version:    0.7.0.1
 */