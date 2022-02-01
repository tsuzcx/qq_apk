package com.tencent.mobileqq.together.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.together.TogetherEntryData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TogetherPopupDialog$2
  implements View.OnClickListener
{
  TogetherPopupDialog$2(TogetherPopupDialog paramTogetherPopupDialog) {}
  
  public void onClick(View paramView)
  {
    switch (((TogetherEntryData)paramView.getTag()).b)
    {
    }
    for (;;)
    {
      this.a.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.e();
      continue;
      this.a.f();
      continue;
      this.a.g();
      continue;
      this.a.h();
      continue;
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.2
 * JD-Core Version:    0.7.0.1
 */