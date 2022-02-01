package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

class WebViewBottomBar$BarAdapter
  extends BaseAdapter
{
  Context a;
  
  public WebViewBottomBar.BottomItem a(int paramInt)
  {
    return (WebViewBottomBar.BottomItem)this.b.f.get(paramInt);
  }
  
  public int getCount()
  {
    return this.b.f.size();
  }
  
  public long getItemId(int paramInt)
  {
    return a(paramInt).a;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = false;
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2131629665, paramViewGroup, false);
      paramView = new WebViewBottomBar.ViewHolder(this.b, localView);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (WebViewBottomBar.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    paramView.f = a(paramInt).a;
    if (!this.b.e.contains(paramView)) {
      this.b.e.add(paramView);
    }
    paramView.a(a(paramInt).c);
    if (this.b.f.size() > paramInt)
    {
      paramView.a(a(paramInt).b);
      if (this.b.h != 0) {
        paramView.b(this.b.h);
      }
    }
    if (this.b.d == getItemId(paramInt)) {
      bool = true;
    }
    paramView.a(bool);
    Object localObject = (WebViewBottomBar.RedTouch)this.b.g.get(Integer.valueOf(paramView.f));
    if (localObject != null) {
      ((WebViewBottomBar.RedTouch)localObject).a(paramView.f);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar.BarAdapter
 * JD-Core Version:    0.7.0.1
 */