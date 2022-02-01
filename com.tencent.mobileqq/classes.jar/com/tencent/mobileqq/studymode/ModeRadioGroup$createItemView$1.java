package com.tencent.mobileqq.studymode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ModeRadioGroup$createItemView$1
  implements View.OnClickListener
{
  ModeRadioGroup$createItemView$1(ModeRadioGroup paramModeRadioGroup, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.a.getContext()))
    {
      if (ModeRadioGroup.a(this.a) != this.b) {
        QQToast.makeText(this.a.getContext(), 1, 2131892157, 1).show();
      }
    }
    else if ((this.b == 2) && (ModeRadioGroup.a(this.a) != 2))
    {
      ModeRadioGroup.a(this.a, this.b);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("click item, type= ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", old type= ");
      localStringBuilder.append(ModeRadioGroup.a(this.a));
      localStringBuilder.append(", enableCheck = ");
      localStringBuilder.append(ModeRadioGroup.b(this.a));
      QLog.d("GeneralModeRadioGroup", 2, localStringBuilder.toString());
      if ((ModeRadioGroup.b(this.a)) && (this.b != ModeRadioGroup.a(this.a))) {
        ModeRadioGroup.a(this.a, this.b, true, false, 4, null);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeRadioGroup.createItemView.1
 * JD-Core Version:    0.7.0.1
 */