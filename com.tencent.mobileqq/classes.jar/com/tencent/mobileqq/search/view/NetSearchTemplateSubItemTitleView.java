package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;

public class NetSearchTemplateSubItemTitleView
  extends NetSearchTemplateBaseView
{
  public TextView a;
  public LinearLayout b;
  
  public NetSearchTemplateSubItemTitleView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    this.a = ((TextView)this.e.findViewById(2131448814));
    this.b = ((LinearLayout)this.e.findViewById(2131428785));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateSubItemTitleView
 * JD-Core Version:    0.7.0.1
 */