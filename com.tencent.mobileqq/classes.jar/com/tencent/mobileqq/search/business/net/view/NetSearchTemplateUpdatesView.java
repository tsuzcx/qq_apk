package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import mqq.app.MobileQQ;

public class NetSearchTemplateUpdatesView
  extends NetSearchTemplateBaseView
{
  public ImageView a;
  public ImageView b;
  public TextView c;
  public LinearLayout d;
  public SquareImageView n;
  public ImageView o;
  public FrameLayout p;
  public int q;
  
  public NetSearchTemplateUpdatesView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    Object localObject = b(this.m);
    this.b = ((ImageView)((View)localObject).findViewById(2131431472));
    this.a = ((ImageView)((View)localObject).findViewById(2131435219));
    this.c = ((TextView)((View)localObject).findViewById(2131446828));
    this.d = ((LinearLayout)((View)localObject).findViewById(2131440280));
    this.p = ((FrameLayout)((View)localObject).findViewById(2131446037));
    this.n = ((SquareImageView)this.p.findViewById(2131435463));
    this.o = ((ImageView)this.p.findViewById(2131436849));
    this.q = this.d.getChildCount();
    localObject = b();
    TextView localTextView1 = c();
    TextView localTextView2 = d();
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null))
    {
      if (localObject != null) {
        ((TextView)localObject).setTextColor(((View)localObject).getContext().getResources().getColor(2131167917));
      }
      if (localTextView1 != null) {
        ((TextView)localTextView1).setTextColor(localTextView1.getContext().getResources().getColor(2131167916));
      }
      if (localTextView2 != null) {
        ((TextView)localTextView2).setTextColor(localTextView2.getContext().getResources().getColor(2131167916));
      }
    }
    else
    {
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#262626"));
      }
      if (localTextView1 != null) {
        ((TextView)localTextView1).setTextColor(Color.parseColor("#737373"));
      }
      if (localTextView2 != null) {
        ((TextView)localTextView2).setTextColor(Color.parseColor("#737373"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateUpdatesView
 * JD-Core Version:    0.7.0.1
 */