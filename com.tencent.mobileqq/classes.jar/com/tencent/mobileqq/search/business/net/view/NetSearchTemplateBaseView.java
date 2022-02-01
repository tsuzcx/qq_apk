package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import mqq.app.MobileQQ;

public class NetSearchTemplateBaseView
  extends SearchResultView
{
  public RelativeLayout r;
  public SquareImageView s;
  public ImageView t;
  public TextView u;
  public TextView v;
  public SquareImageView w;
  public TextView x;
  
  public NetSearchTemplateBaseView(ViewGroup paramViewGroup, int paramInt)
  {
    this.m = paramInt;
    paramViewGroup.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, null, false), new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setBackgroundResource(2130852377);
    localLinearLayout.setClickable(true);
    localLinearLayout.setFocusable(true);
    this.e = localLinearLayout;
    a();
  }
  
  protected void a()
  {
    super.a();
  }
  
  protected void a(View paramView)
  {
    this.r = ((RelativeLayout)paramView.findViewById(2131444977));
    if (this.r == null) {
      this.r = ((RelativeLayout)paramView.findViewById(2131435444));
    }
    this.s = ((SquareImageView)paramView.findViewById(2131436435));
    this.t = ((ImageView)paramView.findViewById(2131436334));
    this.u = ((TextView)paramView.findViewById(2131448793));
    this.v = ((TextView)paramView.findViewById(2131448713));
    this.w = ((SquareImageView)paramView.findViewById(2131444806));
    this.x = ((TextView)paramView.findViewById(2131444807));
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null))
    {
      paramView = this.v;
      paramView.setTextColor(paramView.getContext().getResources().getColor(2131167917));
      paramView = this.x;
      paramView.setTextColor(paramView.getContext().getResources().getColor(2131167917));
      return;
    }
    paramView = this.v;
    paramView.setTextColor(paramView.getContext().getResources().getColor(2131168464));
    paramView = this.x;
    paramView.setTextColor(paramView.getContext().getResources().getColor(2131168464));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView
 * JD-Core Version:    0.7.0.1
 */