package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;

public class NetSearchTemplateIndividuateOneView
  extends NetSearchTemplateHorizontalBaseView
{
  public static final String a = "NetSearchTemplateIndividuateOneView";
  public RelativeLayout b;
  public ImageView c;
  public TextView d;
  public FrameLayout n;
  public TextView o;
  
  public NetSearchTemplateIndividuateOneView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, 2131625865);
    c(paramInt);
  }
  
  private void c(int paramInt)
  {
    this.b = ((RelativeLayout)this.e.findViewById(2131440673));
    this.c = ((ImageView)this.e.findViewById(2131440674));
    this.d = ((TextView)this.e.findViewById(2131440677));
    this.n = ((FrameLayout)this.e.findViewById(2131440675));
    this.o = ((TextView)this.e.findViewById(2131439121));
    d(paramInt);
  }
  
  private void d(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramInt;
      localLayoutParams.height = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateIndividuateOneView
 * JD-Core Version:    0.7.0.1
 */