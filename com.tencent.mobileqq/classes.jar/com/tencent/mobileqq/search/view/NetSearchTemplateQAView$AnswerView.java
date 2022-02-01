package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.SquareImageView;

class NetSearchTemplateQAView$AnswerView
{
  public SquareImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public LinearLayout e;
  public FrameLayout f;
  public SquareImageView g;
  public ImageView h;
  public int i;
  public Context j;
  public View k;
  
  public NetSearchTemplateQAView$AnswerView(NetSearchTemplateQAView paramNetSearchTemplateQAView, Context paramContext)
  {
    this.j = paramContext;
    a();
  }
  
  public void a()
  {
    this.k = LayoutInflater.from(this.j).inflate(2131625854, this.l.c, false);
    this.a = ((SquareImageView)this.k.findViewById(2131429020));
    this.b = ((TextView)this.k.findViewById(2131439121));
    this.c = ((TextView)this.k.findViewById(2131440581));
    this.d = ((TextView)this.k.findViewById(2131431757));
    this.e = ((LinearLayout)this.k.findViewById(2131440280));
    this.f = ((FrameLayout)this.k.findViewById(2131446037));
    this.g = ((SquareImageView)this.f.findViewById(2131435463));
    this.h = ((ImageView)this.f.findViewById(2131436849));
    this.i = this.e.getChildCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateQAView.AnswerView
 * JD-Core Version:    0.7.0.1
 */