package com.tencent.mobileqq.webview.ui;

import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;

class WebViewBottomBar$RedTouch
{
  int a;
  String b;
  boolean c;
  
  public void a(int paramInt)
  {
    a(paramInt, this.c);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.d.a(paramInt);
    if (localObject == null) {
      return;
    }
    this.c = paramBoolean;
    int j = this.a;
    int i = 4;
    if (j == 1)
    {
      if ((!this.c) && (this.d.g.containsKey(Integer.valueOf(paramInt)))) {
        this.d.g.remove(Integer.valueOf(paramInt));
      }
      if (this.c)
      {
        ((WebViewBottomBar.ViewHolder)localObject).d.setVisibility(8);
        ((WebViewBottomBar.ViewHolder)localObject).e.setVisibility(8);
      }
      localObject = ((WebViewBottomBar.ViewHolder)localObject).c;
      paramInt = i;
      if (this.c) {
        paramInt = 0;
      }
      ((ImageView)localObject).setVisibility(paramInt);
      return;
    }
    if (j == 3)
    {
      if (paramInt <= 0)
      {
        if (this.d.g.containsKey(Integer.valueOf(paramInt))) {
          this.d.g.remove(Integer.valueOf(paramInt));
        }
        ((WebViewBottomBar.ViewHolder)localObject).d.setVisibility(4);
      }
      paramInt = Integer.parseInt(this.b);
      if (paramInt <= 0)
      {
        if (this.d.g.containsKey(Integer.valueOf(((WebViewBottomBar.ViewHolder)localObject).f))) {
          this.d.g.remove(Integer.valueOf(((WebViewBottomBar.ViewHolder)localObject).f));
        }
        ((WebViewBottomBar.ViewHolder)localObject).d.setVisibility(4);
        return;
      }
      ((WebViewBottomBar.ViewHolder)localObject).c.setVisibility(8);
      ((WebViewBottomBar.ViewHolder)localObject).e.setVisibility(8);
      ((WebViewBottomBar.ViewHolder)localObject).d.setVisibility(0);
      ((WebViewBottomBar.ViewHolder)localObject).d.setText(String.valueOf(paramInt));
      return;
    }
    if (j == 2)
    {
      if (!this.c)
      {
        ((WebViewBottomBar.ViewHolder)localObject).e.setVisibility(8);
        return;
      }
      ((WebViewBottomBar.ViewHolder)localObject).c.setVisibility(8);
      ((WebViewBottomBar.ViewHolder)localObject).d.setVisibility(8);
      ((WebViewBottomBar.ViewHolder)localObject).e.setText(this.b);
      ((WebViewBottomBar.ViewHolder)localObject).e.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar.RedTouch
 * JD-Core Version:    0.7.0.1
 */