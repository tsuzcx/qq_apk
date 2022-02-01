package com.tencent.xaction.express;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/express/Order;", "Lcom/tencent/xaction/express/IFunc;", "()V", "compute", "", "fieldType", "Ljava/lang/Class;", "param", "", "index", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class Order
  implements IFunc
{
  @Nullable
  public Object a(@NotNull Class<?> paramClass, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "fieldType");
    Intrinsics.checkParameterIsNotNull(paramString, "param");
    paramString = StringsKt.split$default((CharSequence)paramString, new String[] { "," }, false, 0, 6, null);
    if ((paramInt >= 0) && (paramInt < paramString.size())) {
      return ExpressKt.a((String)paramString.get(paramInt), paramClass);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.express.Order
 * JD-Core Version:    0.7.0.1
 */