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
  private List<ColorNote> a;
  private boolean b;
  private OnListHideListener c;
  private ColorNoteListAdapter.OnRecentNoteDeleteListener d;
  private List<IColorNoteListListener> e;
  
  public ColorNoteListAdapter(List<IColorNoteListListener> paramList)
  {
    this.e = paramList;
  }
  
  private void a(View paramView, ColorNote paramColorNote)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteListListener)localIterator.next()).a(paramView, paramColorNote);
    }
  }
  
  private void b(View paramView, ColorNote paramColorNote)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteListListener)localIterator.next()).b(paramView, paramColorNote);
    }
  }
  
  public ColorNoteListAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ColorNoteListAdapter.ViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624505, paramViewGroup, false));
  }
  
  public void a(ColorNoteListAdapter.OnRecentNoteDeleteListener paramOnRecentNoteDeleteListener)
  {
    this.d = paramOnRecentNoteDeleteListener;
  }
  
  public void a(ColorNoteListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    ColorNote localColorNote = (ColorNote)this.a.get(paramInt);
    ColorNoteControllerImpl.getItemBuilder(localColorNote).a(paramViewHolder, paramInt, this.b);
    if (ColorNoteUtils.i(localColorNote))
    {
      UpComingMsgModel localUpComingMsgModel = ColorNoteSmallScreenUtil.b(localColorNote);
      int j = DisplayUtil.a(paramViewHolder.e.getContext(), 200.0F);
      int i;
      if (ColorNoteUtils.h(localColorNote)) {
        i = DisplayUtil.a(paramViewHolder.e.getContext(), 27.0F);
      } else {
        i = 0;
      }
      if (localUpComingMsgModel.uniseq.size() > 1)
      {
        paramViewHolder.e.setMaxWidth(j);
        ColorNoteSmallScreenUtil.a(paramViewHolder.e, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.MIDDLE, "的", i);
      }
      else
      {
        ColorNoteSmallScreenUtil.a(paramViewHolder.e, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.END, null, i);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(OnListHideListener paramOnListHideListener)
  {
    this.c = paramOnListHideListener;
  }
  
  void a(List<ColorNote> paramList)
  {
    this.a = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter
 * JD-Core Version:    0.7.0.1
 */