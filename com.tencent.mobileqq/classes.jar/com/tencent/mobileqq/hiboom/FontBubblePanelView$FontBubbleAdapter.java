package com.tencent.mobileqq.hiboom;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FontBubblePanelView$FontBubbleAdapter
  extends RecyclerView.Adapter<FontBubblePanelView<T>.FontBubbleHolder>
{
  public FontBubblePanelView$FontBubbleAdapter(FontBubblePanelView paramFontBubblePanelView) {}
  
  public FontBubblePanelView<T>.FontBubbleHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131629646, paramViewGroup, false);
    return new FontBubblePanelView.FontBubbleHolder(this.a, paramViewGroup);
  }
  
  public void a(FontBubblePanelView<T>.FontBubbleHolder paramFontBubblePanelView, int paramInt)
  {
    if (paramInt < FontBubblePanelView.d(this.a).size())
    {
      FontBubblePanelView localFontBubblePanelView = this.a;
      localFontBubblePanelView.a(paramFontBubblePanelView, (FontBubble)FontBubblePanelView.d(localFontBubblePanelView).get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramFontBubblePanelView, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return FontBubblePanelView.d(this.a).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((FontBubble)FontBubblePanelView.d(this.a).get(paramInt)).viewType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView.FontBubbleAdapter
 * JD-Core Version:    0.7.0.1
 */