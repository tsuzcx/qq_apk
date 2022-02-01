package com.tencent.mobileqq.vas;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;

public class ColorNickColorPanelAdapter$PureColorViewHolder
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  HorizontalListView a;
  ColorNickColorPanelAdapter.PureColorAdapter b;
  ColorNickColorPanelAdapter.OnColorSelectListener c;
  ColorNickColorPanelAdapter d;
  
  public ColorNickColorPanelAdapter$PureColorViewHolder(View paramView, ColorNickColorPanelAdapter.OnColorSelectListener paramOnColorSelectListener, ColorNickColorPanelAdapter.PureColorAdapter paramPureColorAdapter, ColorNickColorPanelAdapter paramColorNickColorPanelAdapter)
  {
    super(paramView);
    this.a = ((HorizontalListView)paramView.findViewById(2131430961));
    this.b = paramPureColorAdapter;
    this.a.setAdapter(this.b);
    this.a.setOnItemClickListener(this);
    this.c = paramOnColorSelectListener;
    this.d = paramColorNickColorPanelAdapter;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.a(paramInt);
    this.d.a(-1);
    if (this.c != null)
    {
      ColorNickColorPanelAdapter.ColorItem localColorItem = new ColorNickColorPanelAdapter.ColorItem(2, null, ((Integer)this.b.getItem(paramInt)).intValue(), null);
      this.c.a(localColorItem);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.PureColorViewHolder
 * JD-Core Version:    0.7.0.1
 */