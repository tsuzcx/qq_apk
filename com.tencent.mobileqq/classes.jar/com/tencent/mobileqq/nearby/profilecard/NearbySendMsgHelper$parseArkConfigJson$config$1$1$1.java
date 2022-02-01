package com.tencent.mobileqq.nearby.profilecard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"addSeparator", "", "invoke"}, k=3, mv={1, 1, 16})
final class NearbySendMsgHelper$parseArkConfigJson$config$1$1$1
  extends Lambda
  implements Function0<Unit>
{
  NearbySendMsgHelper$parseArkConfigJson$config$1$1$1(StringBuilder paramStringBuilder, Ref.BooleanRef paramBooleanRef)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (this.$hasContent.element)
    {
      this.$this_apply.append("  |  ");
      return;
    }
    this.$hasContent.element = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbySendMsgHelper.parseArkConfigJson.config.1.1.1
 * JD-Core Version:    0.7.0.1
 */