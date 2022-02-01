package com.tencent.mobileqq.colornote.list;

import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ColorNoteListAdapter
  extends RecyclerView.Adapter<ColorNoteListAdapter.ViewHolder>
{
  private ColorNoteListAdapter.OnRecentNoteDeleteListener jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$OnRecentNoteDeleteListener;
  private OnListHideListener jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public ColorNoteListAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ColorNoteListAdapter.ViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558988, paramViewGroup, false));
  }
  
  public void a(ColorNoteListAdapter.OnRecentNoteDeleteListener paramOnRecentNoteDeleteListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$OnRecentNoteDeleteListener = paramOnRecentNoteDeleteListener;
  }
  
  public void a(ColorNoteListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    ColorNote localColorNote = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ColorNoteController.a(localColorNote).a(paramViewHolder, paramInt, this.jdField_a_of_type_Boolean);
    int j;
    int i;
    if (ColorNoteUtils.d(localColorNote))
    {
      UpComingMsgModel localUpComingMsgModel = UpComingMsgUtil.a(localColorNote);
      j = DisplayUtil.a(paramViewHolder.a.getContext(), 200.0F);
      i = 0;
      if (ColorNoteUtils.c(localColorNote)) {
        i = DisplayUtil.a(paramViewHolder.a.getContext(), 27.0F);
      }
      if (localUpComingMsgModel.uniseq.size() <= 1) {
        break label140;
      }
      paramViewHolder.a.setMaxWidth(j);
      TextUtils.compoundEllipsize(paramViewHolder.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.MIDDLE, "的", i);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      label140:
      TextUtils.compoundEllipsize(paramViewHolder.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.END, null, i);
    }
  }
  
  public void a(OnListHideListener paramOnListHideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener = paramOnListHideListener;
  }
  
  void a(List<ColorNote> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter
 * JD-Core Version:    0.7.0.1
 */