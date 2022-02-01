package com.tencent.mobileqq.webview.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class WebViewBottomBar
{
  WebViewBottomBar.BarAdapter a;
  Context b;
  WebViewBottomBar.OnBottomBarItemListener c;
  int d;
  List<WebViewBottomBar.ViewHolder> e;
  List<WebViewBottomBar.BottomItem> f;
  HashMap<Integer, WebViewBottomBar.RedTouch> g;
  int h;
  
  WebViewBottomBar.ViewHolder a(int paramInt)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        WebViewBottomBar.ViewHolder localViewHolder = (WebViewBottomBar.ViewHolder)((Iterator)localObject).next();
        if (paramInt == localViewHolder.f) {
          return localViewHolder;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar
 * JD-Core Version:    0.7.0.1
 */