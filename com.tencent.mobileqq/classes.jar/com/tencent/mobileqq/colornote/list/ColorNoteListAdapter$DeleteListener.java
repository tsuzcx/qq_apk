package com.tencent.mobileqq.colornote.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.ColorNoteHelper;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.music.QQPlayerService;
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
    if ((i < 0) || (i >= ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).size()))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    ColorNote localColorNote = (ColorNote)ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).get(i);
    ColorNoteHelper.b(localColorNote.mServiceType, localColorNote.mSubType);
    ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).remove(i);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.notifyDataSetChanged();
    switch (localColorNote.getServiceType())
    {
    default: 
      label108:
      if (ColorNoteUtils.b(localColorNote))
      {
        if ((ColorNoteRecentConfigProcessor.a().a()) && (ColorNoteRecentView.b())) {
          ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).a(paramView);
        }
        String str = ReportUtil.a(localColorNote);
        ReportController.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", ColorNoteConstants.b(ColorNoteUtils.a(localColorNote.getServiceType())), 0, "", "", "", str);
      }
      break;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter.getItemCount() == 0) && (ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter) != null))
    {
      ColorNoteListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter).b();
      break;
      QQPlayerService.c(paramView.getContext());
      break label108;
      ReportController.b(null, "dc00898", "", "", "0X800A747", "0X800A747", ColorNoteConstants.a(localColorNote.getServiceType()), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter.DeleteListener
 * JD-Core Version:    0.7.0.1
 */