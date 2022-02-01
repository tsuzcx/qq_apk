package com.tencent.mobileqq.vas;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ColorNickColorPanelAdapter$GradientViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView b;
  ImageView c;
  ColorNickColorPanelAdapter d;
  ColorNickColorPanelAdapter.OnColorSelectListener e;
  
  public ColorNickColorPanelAdapter$GradientViewHolder(View paramView, ColorNickColorPanelAdapter paramColorNickColorPanelAdapter, ColorNickColorPanelAdapter.OnColorSelectListener paramOnColorSelectListener)
  {
    super(paramView);
    this.d = paramColorNickColorPanelAdapter;
    this.b = ((ImageView)paramView.findViewById(2131430947));
    this.c = ((ImageView)paramView.findViewById(2131430948));
    paramView.setOnClickListener(this);
    this.e = paramOnColorSelectListener;
  }
  
  public void onClick(View paramView)
  {
    this.d.a(this.a);
    ColorNickColorPanelAdapter.OnColorSelectListener localOnColorSelectListener = this.e;
    if (localOnColorSelectListener != null) {
      localOnColorSelectListener.a(this.d.b(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.GradientViewHolder
 * JD-Core Version:    0.7.0.1
 */