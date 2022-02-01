package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class NetSearchTemplateBigImageView
  extends NetSearchTemplateBaseView
{
  public RelativeLayout a;
  public URLImageView b;
  public TextView c;
  public TextView d;
  public TextView n;
  public TextView o;
  
  public NetSearchTemplateBigImageView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = b(this.m);
    this.a = ((RelativeLayout)localView.findViewById(2131436854));
    this.b = ((URLImageView)localView.findViewById(2131429434));
    this.c = ((TextView)localView.findViewById(2131435219));
    this.d = ((TextView)localView.findViewById(2131433201));
    this.n = ((TextView)localView.findViewById(2131445477));
    this.o = ((TextView)localView.findViewById(2131427606));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBigImageView
 * JD-Core Version:    0.7.0.1
 */