package com.tencent.mobileqq.kandian.glue.router.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/router/api/IRIJJumpAction;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "handleServerReadInJoy", "", "context", "Landroid/content/Context;", "actionName", "", "attrs", "Ljava/util/HashMap;", "jumActionFrom", "jumpActionSource", "launchReadInJoyPlugin", "", "intent", "Landroid/content/Intent;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJJumpAction
  extends QRouteApi
{
  public abstract boolean handleServerReadInJoy(@NotNull Context paramContext, @Nullable String paramString1, @NotNull HashMap<String, String> paramHashMap, @Nullable String paramString2, @Nullable String paramString3);
  
  public abstract void launchReadInJoyPlugin(@NotNull HashMap<String, String> paramHashMap, @NotNull Intent paramIntent, @NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpAction
 * JD-Core Version:    0.7.0.1
 */