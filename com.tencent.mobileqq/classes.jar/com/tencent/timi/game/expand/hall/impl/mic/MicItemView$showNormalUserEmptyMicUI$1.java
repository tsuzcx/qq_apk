package com.tencent.timi.game.expand.hall.impl.mic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class MicItemView$showNormalUserEmptyMicUI$1
  implements View.OnClickListener
{
  MicItemView$showNormalUserEmptyMicUI$1(MicItemView paramMicItemView) {}
  
  public final void onClick(View paramView)
  {
    QQToast.makeText(this.a.getContext(), (CharSequence)"只有房间主持人才能够使用麦位哦", 0).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicItemView.showNormalUserEmptyMicUI.1
 * JD-Core Version:    0.7.0.1
 */