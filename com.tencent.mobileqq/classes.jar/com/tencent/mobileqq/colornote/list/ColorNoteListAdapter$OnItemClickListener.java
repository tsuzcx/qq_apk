package com.tencent.mobileqq.colornote.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ColorNoteListAdapter$OnItemClickListener
  implements View.OnClickListener
{
  ColorNoteListAdapter.ViewHolder jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$ViewHolder;
  ColorNoteListAdapter jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter;
  
  ColorNoteListAdapter$OnItemClickListener(ColorNoteListAdapter paramColorNoteListAdapter, ColorNoteListAdapter.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter = paramColorNoteListAdapter;
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$ViewHolder = paramViewHolder;
  }
  
  public void onClick(View paramView)
  {
    ColorNoteController.a(paramView.getContext(), (ColorNote)ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).get(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$ViewHolder.getAdapterPosition()));
    if (ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter) != null) {
      ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter.OnItemClickListener
 * JD-Core Version:    0.7.0.1
 */