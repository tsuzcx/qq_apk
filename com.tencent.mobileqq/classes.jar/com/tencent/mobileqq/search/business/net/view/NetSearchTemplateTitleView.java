package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class NetSearchTemplateTitleView
  extends NetSearchTemplateBaseView
{
  public URLImageView a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public TextView n;
  
  public NetSearchTemplateTitleView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    View localView = b(this.m);
    this.a = ((URLImageView)localView.findViewById(2131447511));
    this.b = ((TextView)localView.findViewById(2131433214));
    this.c = ((TextView)localView.findViewById(2131438889));
    this.d = ((ImageView)localView.findViewById(2131438862));
    this.n = ((TextView)localView.findViewById(2131445485));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateTitleView
 * JD-Core Version:    0.7.0.1
 */