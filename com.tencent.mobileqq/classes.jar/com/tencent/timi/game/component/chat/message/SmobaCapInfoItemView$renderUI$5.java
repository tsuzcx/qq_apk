package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class SmobaCapInfoItemView$renderUI$5
  implements View.OnClickListener
{
  SmobaCapInfoItemView$renderUI$5(SmobaCapInfoItemView paramSmobaCapInfoItemView, IMsg paramIMsg, List paramList) {}
  
  public final void onClick(View paramView)
  {
    this.b.a(1);
    Object localObject1 = (LinearLayout)this.a.a(2131438849);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "moreInfoLl");
    localObject1 = (View)localObject1;
    int i = 0;
    ViewExKt.a((View)localObject1, false);
    localObject1 = (ImageView)this.a.a(2131438845);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "moreArrowIv");
    ViewExKt.a((View)localObject1, false);
    localObject1 = this.c;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "qqUsers");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = (CommonOuterClass.QQUserId)localObject2;
      ViewExKt.a((View)SmobaCapInfoItemView.a(this.a).get(i), true);
      i += 1;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaCapInfoItemView.renderUI.5
 * JD-Core Version:    0.7.0.1
 */