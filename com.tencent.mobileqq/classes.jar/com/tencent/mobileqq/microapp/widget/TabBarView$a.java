package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.microapp.apkg.k.a;
import com.tencent.mobileqq.microapp.util.DisplayUtil;

public final class TabBarView$a
{
  public TextView a;
  public ImageView b;
  public View c;
  public View d;
  public View e;
  public View f;
  public Drawable g;
  public Drawable h;
  public k.a i;
  public k j;
  
  public static a a(View paramView, k.a parama, k paramk)
  {
    a locala = new a();
    locala.a = ((TextView)paramView.findViewById(R.id.m));
    locala.b = ((ImageView)paramView.findViewById(R.id.i));
    locala.c = paramView.findViewById(R.id.p);
    locala.d = paramView.findViewById(R.id.b);
    locala.e = paramView.findViewById(R.id.c);
    paramView.findViewById(R.id.l);
    paramView.findViewById(R.id.a);
    locala.f = paramView;
    locala.j = paramk;
    locala.i = parama;
    return locala;
  }
  
  public void a()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ("top".equals(this.j.e))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.f.getContext(), 15.0F);
      localLayoutParams.topMargin = DisplayUtil.dip2px(this.f.getContext(), 15.0F);
      this.a.setLayoutParams(localLayoutParams);
      this.a.setTextSize(1, 15.0F);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(0);
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.f.getContext(), 5.0F);
      localLayoutParams.topMargin = DisplayUtil.dip2px(this.f.getContext(), 0.0F);
      this.a.setLayoutParams(localLayoutParams);
      this.a.setTextSize(1, 12.0F);
      this.d.setVisibility(8);
      this.c.setVisibility(0);
      this.b.setVisibility(0);
    }
    this.a.setText(this.i.b);
    if (!"top".equals(this.j.e))
    {
      this.g = new BitmapDrawable(this.f.getContext().getResources(), this.i.c);
      this.h = new BitmapDrawable(this.f.getContext().getResources(), this.i.d);
    }
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f.setBackgroundColor(this.j.c);
    if (!paramBoolean)
    {
      this.a.setTextColor(this.j.a);
      if ("top".equals(this.j.e)) {
        this.e.setVisibility(8);
      } else {
        this.b.setImageDrawable(this.g);
      }
    }
    else
    {
      this.a.setTextColor(this.j.b);
      if ("top".equals(this.j.e)) {
        this.e.setVisibility(0);
      } else {
        this.b.setImageDrawable(this.h);
      }
    }
    paramBoolean = "top".equals(this.j.e);
    int k = 855638016;
    if (paramBoolean)
    {
      localView = this.d;
      if (!"black".equals(this.j.d)) {
        k = 872415231;
      }
      localView.setBackgroundColor(k);
      this.e.setBackgroundColor(this.j.b);
      return;
    }
    View localView = this.c;
    if (!"black".equals(this.j.d)) {
      k = 872415231;
    }
    localView.setBackgroundColor(k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.TabBarView.a
 * JD-Core Version:    0.7.0.1
 */