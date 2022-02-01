package com.tencent.mobileqq.colornote.list;

import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ColorNoteListAdapter
  extends RecyclerView.Adapter<ColorNoteListAdapter.ViewHolder>
{
  private ColorNoteListAdapter.OnRecentNoteDeleteListener jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$OnRecentNoteDeleteListener;
  private OnListHideListener jdField_a_of_type_ComTencentMobileqqColornoteListOnListHideListener;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<IColorNoteListListener> b;
  
  public ColorNoteListAdapter(List<IColorNoteListListener> paramList)
  {
    this.b = paramList;
  }
  
  private void a(View paramView, ColorNote paramColorNote)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteListListener)localIterator.next()).a(paramView, paramColorNote);
    }
  }
  
  private void b(View paramView, ColorNote paramColorNote)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteListListener)localIterator.next()).b(paramView, paramColorNote);
    }
  }
  
  public ColorNoteListAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ColorNoteListAdapter.ViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558883, paramViewGroup, false));
  }
  
  public void a(ColorNoteListAdapter.OnRecentNoteDeleteListener paramOnRecentNoteDeleteListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListAdapter$OnRecentNoteDeleteListener = paramOnRecentNoteDeleteListener;
  }
  
  public void a(ColorNoteListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    ColorNote localColorNote = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ColorNoteControllerImpl.getItemBuilder(localColorNote).a(paramViewHolder, paramInt, this.jdField_a_of_type_Boolean);
    if (ColorNoteUtils.d(localColorNote))
    {
      UpComingMsgModel localUpComingMsgModel = ColorNoteSmallScreenUtil.a(localColorNote);
      int j = DisplayUtil.a(paramViewHolder.a.getContext(), 200.0F);
      int i;
      if (ColorNoteUtils.c(localColorNote)) {
        i = DisplayUtil.a(paramViewHolder.a.getContext(), 27.0F);
      } else {
        i = 0;
      }
      if (localUpComingMsgModel.uniseq.size() > 1)
      {
        paramViewHolder.a.setMaxWidth(j);
        ColorNoteSmallScreenUtil.a(paramViewHolder.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.MIDDLE, "的", i);
      }
      else
      {
        ColorNoteSmallScreenUtil.a(paramViewHolder.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.END, null, i);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter
 * JD-Core Version:    0.7.0.1
 */