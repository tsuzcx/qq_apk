package com.tencent.mobileqq.colornote.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ColorNoteListController$4$2
  implements View.OnClickListener
{
  ColorNoteListController$4$2(ColorNoteListController.4 param4) {}
  
  public void onClick(View paramView)
  {
    ColorNoteListController.a(this.a.a).setVisibility(8);
    ColorNoteListController.a(this.a.a, null);
    if (ColorNoteListController.f(this.a.a).getItemCount() == 0) {
      ColorNoteListController.b(this.a.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController.4.2
 * JD-Core Version:    0.7.0.1
 */