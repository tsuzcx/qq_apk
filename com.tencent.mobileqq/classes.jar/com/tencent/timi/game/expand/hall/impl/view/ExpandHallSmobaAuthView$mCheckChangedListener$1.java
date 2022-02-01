package com.tencent.timi.game.expand.hall.impl.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k=3, mv={1, 1, 16})
final class ExpandHallSmobaAuthView$mCheckChangedListener$1
  implements CompoundButton.OnCheckedChangeListener
{
  ExpandHallSmobaAuthView$mCheckChangedListener$1(ExpandHallSmobaAuthView paramExpandHallSmobaAuthView) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user clicked,isChecked=");
    localStringBuilder.append(paramBoolean);
    Logger.a("ExpandHallSmobaAuthView_", localStringBuilder.toString());
    if (paramBoolean) {
      ExpandHallSmobaAuthView.e(this.a);
    } else {
      ExpandHallSmobaAuthView.f(this.a);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView.mCheckChangedListener.1
 * JD-Core Version:    0.7.0.1
 */