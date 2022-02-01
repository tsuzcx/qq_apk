package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$52
  implements View.OnClickListener
{
  d$52(d paramd, CheckBox paramCheckBox) {}
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox = this.a;
    localCheckBox.setChecked(localCheckBox.isChecked() ^ true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.52
 * JD-Core Version:    0.7.0.1
 */