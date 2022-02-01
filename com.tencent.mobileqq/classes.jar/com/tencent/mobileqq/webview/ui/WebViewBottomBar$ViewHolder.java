package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WebViewBottomBar$ViewHolder
{
  ImageView a;
  TextView b;
  ImageView c;
  TextView d;
  TextView e;
  int f;
  
  public WebViewBottomBar$ViewHolder(WebViewBottomBar paramWebViewBottomBar, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131438117));
    this.b = ((TextView)paramView.findViewById(2131438129));
    this.c = ((ImageView)paramView.findViewById(2131438885));
    this.d = ((TextView)paramView.findViewById(2131445831));
    this.e = ((TextView)paramView.findViewById(2131444544));
  }
  
  public void a(int paramInt)
  {
    this.a.setBackgroundResource(paramInt);
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setSelected(paramBoolean);
    this.a.setSelected(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    ColorStateList localColorStateList = this.g.b.getResources().getColorStateList(paramInt);
    if (localColorStateList != null)
    {
      this.b.setTextColor(localColorStateList);
      return;
    }
    this.b.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewBottomBar.ViewHolder
 * JD-Core Version:    0.7.0.1
 */