package com.tencent.tkd.weibo.atContact;

import com.tencent.tkd.topicsdk.bean.AtPersonItem;
import com.tencent.tkd.weibo.utils.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "invoke"}, k=3, mv={1, 1, 16})
final class AtContactView$initView$2
  extends Lambda
  implements Function1<AtPersonItem, Unit>
{
  AtContactView$initView$2(AtContactView paramAtContactView)
  {
    super(1);
  }
  
  public final void invoke(@NotNull AtPersonItem paramAtPersonItem)
  {
    Intrinsics.checkParameterIsNotNull(paramAtPersonItem, "it");
    this.this$0.a(Utils.a.a(paramAtPersonItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.AtContactView.initView.2
 * JD-Core Version:    0.7.0.1
 */