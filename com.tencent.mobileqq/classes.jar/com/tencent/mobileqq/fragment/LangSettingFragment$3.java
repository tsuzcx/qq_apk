package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.List;

class LangSettingFragment$3
  implements View.OnClickListener
{
  LangSettingFragment$3(LangSettingFragment paramLangSettingFragment, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i = this.a;
    if ((i >= 0) && (i < LangSettingFragment.a().size()))
    {
      LangSettingFragment.c(this.b, this.a);
      LangSettingFragment.d(this.b, ((Integer)LangSettingFragment.a().get(this.a)).intValue());
    }
    if ((LangSettingFragment.b(this.b) != null) && (LangSettingFragment.b(this.b).isShowing())) {
      LangSettingFragment.b(this.b).dismiss();
    }
    if ((LangSettingFragment.c(this.b) != null) && (LangSettingFragment.c(this.b).isShowing())) {
      LangSettingFragment.c(this.b).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */