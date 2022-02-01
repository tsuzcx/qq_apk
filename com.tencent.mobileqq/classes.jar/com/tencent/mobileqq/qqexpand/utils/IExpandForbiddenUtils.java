package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandForbiddenInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/IExpandForbiddenUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getForbidDialogMessage", "Landroid/text/SpannableStringBuilder;", "activity", "Landroid/app/Activity;", "tip", "", "isForbidForever", "", "remainingTime", "", "isForbidden", "getForbiddenInfo", "Lcom/tencent/mobileqq/qqexpand/bean/profile/ExpandForbiddenInfo;", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandForbiddenUtils
  extends QRouteApi
{
  @Nullable
  public abstract SpannableStringBuilder getForbidDialogMessage(@Nullable Activity paramActivity, @Nullable String paramString, boolean paramBoolean1, long paramLong, boolean paramBoolean2);
  
  @NotNull
  public abstract ExpandForbiddenInfo getForbiddenInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils
 * JD-Core Version:    0.7.0.1
 */