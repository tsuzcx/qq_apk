package com.tencent.mobileqq.kandian.biz.common.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyFloatingWindowHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "jump2FloatingWindow", "", "context", "Landroid/content/Context;", "attrs", "Ljava/util/HashMap;", "", "openFloatLayer", "", "urlString", "openFloatLayerVideo", "rowKey", "extraData", "Landroid/os/Bundle;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyFloatingWindowHelper
  extends QRouteApi
{
  public abstract void jump2FloatingWindow(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap);
  
  public abstract boolean openFloatLayer(@Nullable Context paramContext, @Nullable String paramString);
  
  public abstract boolean openFloatLayerVideo(@Nullable Context paramContext, @Nullable String paramString, @Nullable Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyFloatingWindowHelper
 * JD-Core Version:    0.7.0.1
 */