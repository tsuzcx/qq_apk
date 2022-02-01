package com.tencent.mobileqq.colornote.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ColorNoteListAdapter$DeleteListener
  implements View.OnClickListener
{
  ColorNoteListAdapter.ViewHolder jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$ViewHolder;
  ColorNoteListAdapter jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter;
  
  ColorNoteListAdapter$DeleteListener(ColorNoteListAdapter paramColorNoteListAdapter, ColorNoteListAdapter.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter = paramColorNoteListAdapter;
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$ViewHolder = paramViewHolder;
  }
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$ViewHolder.getAdapterPosition();
    if ((i >= 0) && (i < ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).size()))
    {
      ColorNote localColorNote = (ColorNote)ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).get(i);
      ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).remove(i);
      this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.notifyDataSetChanged();
      if (localColorNote.getServiceType() == 16973824) {
        ((IQQPlayer)QRoute.api(IQQPlayer.class)).stopPlayMusic(paramView.getContext());
      }
      if (ColorNoteUtils.b(localColorNote))
      {
        if ((ColorNoteRecentConfigProcessor.a().a()) && (ColorNoteRecentView.a())) {
          ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).a(paramView);
        }
      }
      else {
        ReportController.b(null, "dc00898", "", "", "0X800A747", "0X800A747", ColorNoteConstants.a(localColorNote.getServiceType()), 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.getItemCount() == 0) && (ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter) != null)) {
        ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).b();
      }
      ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter, paramView, localColorNote);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter.DeleteListener
 * JD-Core Version:    0.7.0.1
 */