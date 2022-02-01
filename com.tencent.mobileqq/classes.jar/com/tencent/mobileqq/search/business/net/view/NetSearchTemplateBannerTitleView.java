package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

public class NetSearchTemplateBannerTitleView
  extends NetSearchTemplateBaseView
{
  public TextView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public RelativeLayout n;
  public ImageView o;
  public ImageView p;
  
  public NetSearchTemplateBannerTitleView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    Object localObject = b(this.m);
    this.a = ((TextView)((View)localObject).findViewById(2131447463));
    this.n = ((RelativeLayout)((View)localObject).findViewById(2131437105));
    this.o = ((ImageView)((View)localObject).findViewById(2131435388));
    this.p = ((ImageView)((View)localObject).findViewById(2131431472));
    this.b = ((TextView)((View)localObject).findViewById(2131446828));
    this.c = ((TextView)((View)localObject).findViewById(2131446631));
    this.d = ((TextView)((View)localObject).findViewById(2131431757));
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null))
    {
      localObject = this.c;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColor(2131167916));
      }
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColor(2131167916));
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#737373"));
      }
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#737373"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBannerTitleView
 * JD-Core Version:    0.7.0.1
 */