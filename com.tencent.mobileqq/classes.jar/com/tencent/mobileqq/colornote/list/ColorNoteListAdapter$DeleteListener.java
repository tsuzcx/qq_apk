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
  ColorNoteListAdapter a;
  ColorNoteListAdapter.ViewHolder b;
  
  ColorNoteListAdapter$DeleteListener(ColorNoteListAdapter paramColorNoteListAdapter, ColorNoteListAdapter.ViewHolder paramViewHolder)
  {
    this.a = paramColorNoteListAdapter;
    this.b = paramViewHolder;
  }
  
  public void onClick(View paramView)
  {
    int i = this.b.getAdapterPosition();
    if ((i >= 0) && (i < ColorNoteListAdapter.c(this.a).size()))
    {
      ColorNote localColorNote = (ColorNote)ColorNoteListAdapter.c(this.a).get(i);
      ColorNoteListAdapter.c(this.a).remove(i);
      this.a.notifyDataSetChanged();
      if (localColorNote.getServiceType() == 16973824) {
        ((IQQPlayer)QRoute.api(IQQPlayer.class)).stopPlayMusic(paramView.getContext());
      }
      if (ColorNoteUtils.d(localColorNote))
      {
        if ((ColorNoteRecentConfigProcessor.a().a()) && (ColorNoteRecentView.a())) {
          ColorNoteListAdapter.d(this.a).a(paramView);
        }
      }
      else {
        ReportController.b(null, "dc00898", "", "", "0X800A747", "0X800A747", ColorNoteConstants.a(localColorNote.getServiceType()), 0, "", "", "", "");
      }
      if ((this.a.getItemCount() == 0) && (ColorNoteListAdapter.b(this.a) != null)) {
        ColorNoteListAdapter.b(this.a).c();
      }
      ColorNoteListAdapter.a(this.a, paramView, localColorNote);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter.DeleteListener
 * JD-Core Version:    0.7.0.1
 */