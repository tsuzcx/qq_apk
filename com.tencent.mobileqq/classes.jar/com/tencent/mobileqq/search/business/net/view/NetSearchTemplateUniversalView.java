package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.SquareImageView;

public class NetSearchTemplateUniversalView
  extends NetSearchTemplateBaseView
{
  public RelativeLayout a;
  public Button b;
  public ImageView c;
  public LinearLayout d;
  public LinearLayout n;
  public TextView o;
  public TextView p;
  public SquareImageView q;
  public LinearLayout y;
  public Button z;
  
  public NetSearchTemplateUniversalView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = b(this.m);
    a(localView);
    this.a = ((RelativeLayout)localView.findViewById(2131445013));
    this.b = ((Button)localView.findViewById(2131429997));
    this.c = ((ImageView)localView.findViewById(2131436556));
    this.d = ((LinearLayout)localView.findViewById(2131437429));
    this.n = ((LinearLayout)localView.findViewById(2131437430));
    this.o = ((TextView)localView.findViewById(2131448318));
    this.p = ((TextView)localView.findViewById(2131448317));
    this.q = ((SquareImageView)localView.findViewById(2131436303));
    this.y = ((LinearLayout)localView.findViewById(2131437428));
    this.z = ((Button)localView.findViewById(2131429817));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateUniversalView
 * JD-Core Version:    0.7.0.1
 */