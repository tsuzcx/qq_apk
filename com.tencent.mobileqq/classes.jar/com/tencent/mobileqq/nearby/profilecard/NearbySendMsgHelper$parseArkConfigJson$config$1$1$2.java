package com.tencent.mobileqq.nearby.profilecard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"addIfNotEmpty", "", "string", "", "invoke"}, k=3, mv={1, 1, 16})
final class NearbySendMsgHelper$parseArkConfigJson$config$1$1$2
  extends Lambda
  implements Function1<String, Unit>
{
  NearbySendMsgHelper$parseArkConfigJson$config$1$1$2(StringBuilder paramStringBuilder, NearbySendMsgHelper.parseArkConfigJson.config.1.1.1 param1)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.$addSeparator$1.invoke();
      this.$this_apply.append(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbySendMsgHelper.parseArkConfigJson.config.1.1.2
 * JD-Core Version:    0.7.0.1
 */