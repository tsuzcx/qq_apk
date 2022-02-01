package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.image.URLImageView;

class NetSearchTemplateNewEntranceView$NetSearchSubView
{
  public View a;
  public URLImageView b;
  public TextView c;
  public View.OnClickListener d = new NetSearchTemplateNewEntranceView.NetSearchSubView.1(this);
  
  public NetSearchTemplateNewEntranceView$NetSearchSubView(NetSearchTemplateNewEntranceView paramNetSearchTemplateNewEntranceView, Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext).inflate(2131627779, paramNetSearchTemplateNewEntranceView.y, false);
    this.b = ((URLImageView)this.a.findViewById(2131435357));
    this.c = ((TextView)this.a.findViewById(2131431733));
    this.a.setOnClickListener(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView.NetSearchSubView
 * JD-Core Version:    0.7.0.1
 */