package com.tencent.timi.game.expand.hall.impl.mic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.CustomToastView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class MicItemView$showWhiteListUserEmptyMicUI$1
  implements View.OnClickListener
{
  MicItemView$showWhiteListUserEmptyMicUI$1(MicItemView paramMicItemView) {}
  
  public final void onClick(View paramView)
  {
    if (MicItemView.a(this.a)) {
      CustomToastView.a("你已经在麦上");
    } else {
      MicOperationUtil.a.a(MicItemView.b(this.a), MicItemView.c(this.a), (OnMicOptCallback)new MicItemView.showWhiteListUserEmptyMicUI.1.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicItemView.showWhiteListUserEmptyMicUI.1
 * JD-Core Version:    0.7.0.1
 */