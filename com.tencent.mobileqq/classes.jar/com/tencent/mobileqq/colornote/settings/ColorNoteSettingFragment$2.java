package com.tencent.mobileqq.colornote.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ColorNoteSettingFragment$2
  implements View.OnClickListener
{
  ColorNoteSettingFragment$2(ColorNoteSettingFragment paramColorNoteSettingFragment, IOnHeaderClickHandler paramIOnHeaderClickHandler, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */