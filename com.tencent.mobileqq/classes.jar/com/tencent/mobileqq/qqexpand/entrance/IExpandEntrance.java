package com.tencent.mobileqq.qqexpand.entrance;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/entrance/IExpandEntrance;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enterExpand", "", "activityContext", "Landroid/content/Context;", "app", "Lcom/tencent/common/app/AppInterface;", "sourceType", "", "enterExpandByJumpAction", "activity", "jumpUrl", "", "enterExpandLimitMatch", "Landroid/app/Activity;", "enterExpandPlugin", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Companion", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandEntrance
  extends QRouteApi
{
  public static final IExpandEntrance.Companion Companion = IExpandEntrance.Companion.a;
  @NotNull
  public static final String EXPAND_PLUGIN_ID = "expand";
  
  public abstract void enterExpand(@Nullable Context paramContext, @Nullable AppInterface paramAppInterface, int paramInt);
  
  public abstract void enterExpandByJumpAction(@Nullable Context paramContext, @Nullable AppInterface paramAppInterface, int paramInt, @Nullable String paramString);
  
  public abstract void enterExpandLimitMatch(@Nullable Activity paramActivity, @Nullable AppInterface paramAppInterface, int paramInt);
  
  public abstract void enterExpandPlugin(@NotNull Context paramContext, @NotNull HashMap<String, Object> paramHashMap, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance
 * JD-Core Version:    0.7.0.1
 */