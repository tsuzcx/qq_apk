package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;

public class NetSearchTemplateSubItemView
  extends NetSearchTemplateBaseView
{
  public TextView a;
  public TextView b;
  public RelativeLayout c;
  public LinearLayout d;
  
  public NetSearchTemplateSubItemView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    this.d = ((LinearLayout)this.e.findViewById(2131445450));
    this.a = ((TextView)this.e.findViewById(2131437131));
    this.b = ((TextView)this.e.findViewById(2131444855));
    this.c = ((RelativeLayout)this.e.findViewById(2131435969));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateSubItemView
 * JD-Core Version:    0.7.0.1
 */