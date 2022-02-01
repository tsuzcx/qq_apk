package com.tencent.mobileqq.search.business.net.model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;

public class NetSearchTemplateAvatarsView
  extends NetSearchTemplateBaseView
{
  public TextView a;
  public LinearLayout b;
  public int c;
  public LinearLayout d;
  public int n;
  public URLImageView o;
  public LinearLayout p;
  public LinearLayout q;
  
  public NetSearchTemplateAvatarsView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    View localView = b(this.m);
    this.a = ((TextView)localView.findViewById(2131447463));
    this.b = ((LinearLayout)localView.findViewById(2131435457));
    this.c = this.b.getChildCount();
    this.d = ((LinearLayout)localView.findViewById(2131437106));
    this.n = this.d.getChildCount();
    this.o = ((URLImageView)this.d.findViewById(2131435460));
    this.p = ((LinearLayout)this.d.findViewById(2131440278));
    this.q = ((LinearLayout)this.d.findViewById(2131440279));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsView
 * JD-Core Version:    0.7.0.1
 */