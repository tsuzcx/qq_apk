package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileCardFavorItemView
  extends LinearLayout
{
  public TextView a;
  public ImageView b;
  public LinearLayout c;
  public ImageView d;
  public View e;
  private Context f;
  private View g;
  private LinearLayout h;
  
  public ProfileCardFavorItemView(Context paramContext)
  {
    super(paramContext);
    this.f = paramContext;
    a();
  }
  
  public ProfileCardFavorItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext;
    a();
  }
  
  private void a()
  {
    this.g = LayoutInflater.from(this.f).inflate(2131625521, this, true);
    this.a = ((TextView)this.g.findViewById(2131436136));
    this.a.setTextColor(getResources().getColorStateList(2131167993));
    this.b = ((ImageView)this.g.findViewById(2131428774));
    this.h = ((LinearLayout)this.g.findViewById(2131440706));
    this.c = ((LinearLayout)this.g.findViewById(2131440709));
    this.d = ((ImageView)this.g.findViewById(2131440707));
    this.e = this.g.findViewById(2131440708);
  }
  
  public void addView(View paramView)
  {
    this.h.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    this.h.addView(paramView, paramInt);
  }
  
  public View getArrow()
  {
    return this.b;
  }
  
  public void removeViewAt(int paramInt)
  {
    this.h.removeViewAt(paramInt);
  }
  
  public void setArrowVisiale(boolean paramBoolean)
  {
    ImageView localImageView = this.b;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void setTitle(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorItemView
 * JD-Core Version:    0.7.0.1
 */