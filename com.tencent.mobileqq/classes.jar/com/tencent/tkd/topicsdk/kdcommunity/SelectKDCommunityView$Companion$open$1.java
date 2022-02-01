package com.tencent.tkd.topicsdk.kdcommunity;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.widget.dialog.SlidingUpDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "communityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class SelectKDCommunityView$Companion$open$1
  extends Lambda
  implements Function1<CommunityInfo, Unit>
{
  SelectKDCommunityView$Companion$open$1(Function1 paramFunction1, SlidingUpDialog paramSlidingUpDialog)
  {
    super(1);
  }
  
  public final void invoke(@Nullable CommunityInfo paramCommunityInfo)
  {
    Function1 localFunction1 = this.$callback;
    if (localFunction1 != null) {
      paramCommunityInfo = (Unit)localFunction1.invoke(paramCommunityInfo);
    }
    this.$dialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView.Companion.open.1
 * JD-Core Version:    0.7.0.1
 */