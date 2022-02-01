package com.tencent.mobileqq.colornote.list;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;

class ColorNoteListController$4
  implements ColorNoteListAdapter.OnRecentNoteDeleteListener
{
  ColorNoteListController$4(ColorNoteListController paramColorNoteListController) {}
  
  public void a(View paramView)
  {
    paramView = this.a;
    ColorNoteListController.a(paramView, ColorNoteListController.e(paramView).inflate());
    ColorNoteListController.a(this.a).setOnClickListener(new ColorNoteListController.4.1(this));
    ((TextView)ColorNoteListController.a(this.a).findViewById(2131431898)).setOnClickListener(new ColorNoteListController.4.2(this));
    ReportController.b(null, "dc00898", "", "", "0X800A8AD", "0X800A8AD", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController.4
 * JD-Core Version:    0.7.0.1
 */