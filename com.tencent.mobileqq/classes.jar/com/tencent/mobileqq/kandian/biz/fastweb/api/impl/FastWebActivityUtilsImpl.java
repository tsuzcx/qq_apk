package com.tencent.mobileqq.kandian.biz.fastweb.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.fastweb.api.IFastWebActivityUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/api/impl/FastWebActivityUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/fastweb/api/IFastWebActivityUtils;", "()V", "openNewPage", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastWebActivityUtilsImpl
  implements IFastWebActivityUtils
{
  public void openNewPage(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    this.$$delegate_0.openNewPage(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.api.impl.FastWebActivityUtilsImpl
 * JD-Core Version:    0.7.0.1
 */