package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.anim.FloatingWindowDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ColorNoteListAdapter$ViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  ColorNoteListAdapter a;
  public View b;
  public View c;
  public ImageView d;
  public TextView e;
  public TextView f;
  public Button g;
  ColorNoteListAdapter.DeleteListener h;
  Drawable i;
  
  public ColorNoteListAdapter$ViewHolder(ColorNoteListAdapter paramColorNoteListAdapter, View paramView)
  {
    super(paramView);
    this.a = paramColorNoteListAdapter;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131439416);
    int k = 0;
    AccessibilityUtil.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131439417);
    AccessibilityUtil.a(localView2, false);
    localView2.setOnClickListener(this);
    int j;
    if (ColorNoteListAdapter.a(paramColorNoteListAdapter)) {
      j = 8;
    } else {
      j = 0;
    }
    localView1.setVisibility(j);
    if (ColorNoteListAdapter.a(paramColorNoteListAdapter)) {
      j = k;
    } else {
      j = 8;
    }
    localView2.setVisibility(j);
    this.b = paramView.findViewById(2131439409);
    this.b.setContentDescription(localResources.getString(2131887846));
    this.c = paramView.findViewById(2131439406);
    this.d = ((ImageView)paramView.findViewById(2131439410));
    this.e = ((TextView)paramView.findViewById(2131439420));
    this.e.setCompoundDrawablePadding(Utils.a(3.0F, localResources));
    this.e.setFocusable(true);
    this.e.setFocusableInTouchMode(true);
    AccessibilityUtil.a(this.e, true);
    this.f = ((TextView)paramView.findViewById(2131439418));
    this.f.setFocusable(true);
    this.f.setFocusableInTouchMode(true);
    AccessibilityUtil.a(this.f, true);
    this.g = ((Button)paramView.findViewById(2131439411));
    this.h = new ColorNoteListAdapter.DeleteListener(paramColorNoteListAdapter, this);
    this.g.setOnClickListener(this.h);
    this.b.setOnClickListener(new ColorNoteListAdapter.OnItemClickListener(paramColorNoteListAdapter, this));
    this.i = new MusicDanceDrawable();
    ((FloatingWindowDrawable)this.i).a(paramView.getContext(), Utils.a(15.0F, localResources), Utils.a(9.5F, localResources));
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)ColorNoteListAdapter.c(this.a).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (((j == 2131439416) || (j == 2131439417)) && (ColorNoteListAdapter.b(this.a) != null))
    {
      ColorNoteListAdapter.b(this.a).c();
      ReportController.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */