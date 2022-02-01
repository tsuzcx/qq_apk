package com.tencent.mobileqq.colornote.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ColorNoteListAdapter$OnItemClickListener
  implements View.OnClickListener
{
  ColorNoteListAdapter a;
  ColorNoteListAdapter.ViewHolder b;
  
  ColorNoteListAdapter$OnItemClickListener(ColorNoteListAdapter paramColorNoteListAdapter, ColorNoteListAdapter.ViewHolder paramViewHolder)
  {
    this.a = paramColorNoteListAdapter;
    this.b = paramViewHolder;
  }
  
  public void onClick(View paramView)
  {
    ColorNote localColorNote = (ColorNote)ColorNoteListAdapter.c(this.a).get(this.b.getAdapterPosition());
    ColorNoteControllerImpl.launch(paramView.getContext(), localColorNote);
    if (ColorNoteListAdapter.b(this.a) != null) {
      ColorNoteListAdapter.b(this.a).c();
    }
    ColorNoteListAdapter.b(this.a, paramView, localColorNote);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter.OnItemClickListener
 * JD-Core Version:    0.7.0.1
 */