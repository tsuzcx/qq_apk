package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.common.ReadInjoyFloatingWindowHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyFloatingWindowHelper;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/ReadInJoyFloatingWindowHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyFloatingWindowHelper;", "()V", "jump2FloatingWindow", "", "context", "Landroid/content/Context;", "attrs", "Ljava/util/HashMap;", "", "openFloatLayer", "", "urlString", "openFloatLayerVideo", "rowKey", "extraData", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyFloatingWindowHelperImpl
  implements IReadInJoyFloatingWindowHelper
{
  public void jump2FloatingWindow(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    ReadInjoyFloatingWindowHelper.a(paramContext, paramHashMap);
  }
  
  public boolean openFloatLayer(@Nullable Context paramContext, @Nullable String paramString)
  {
    return ReadInjoyFloatingWindowHelper.a(paramContext, paramString);
  }
  
  public boolean openFloatLayerVideo(@Nullable Context paramContext, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    return ReadInjoyFloatingWindowHelper.a(paramContext, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.ReadInJoyFloatingWindowHelperImpl
 * JD-Core Version:    0.7.0.1
 */