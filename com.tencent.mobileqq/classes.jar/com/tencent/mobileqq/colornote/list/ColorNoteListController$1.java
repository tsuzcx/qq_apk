package com.tencent.mobileqq.colornote.list;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ColorNoteListController$1
  implements View.OnClickListener
{
  ColorNoteListController$1(ColorNoteListController paramColorNoteListController) {}
  
  public void onClick(View paramView)
  {
    if ((ColorNoteListController.a(this.a) == null) || (ColorNoteListController.a(this.a).getVisibility() != 0) || (!ColorNoteListController.a(this.a).hasFocus()))
    {
      ColorNoteListController.a(this.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("start_from", 1);
      ColorNoteSettingFragment.a(ColorNoteListController.a(this.a), ColorNoteSettingFragment.class, localBundle);
      ReportController.b(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController.1
 * JD-Core Version:    0.7.0.1
 */