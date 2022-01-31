package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.apkg.s;
import com.tencent.mobileqq.microapp.apkg.s.a;
import com.tencent.mobileqq.microapp.util.DisplayUtil;

public final class TabBarView$a
{
  public TextView a;
  public ImageView b;
  public View c;
  public View d;
  public View e;
  public View f;
  public View g;
  public TextView h;
  public Drawable i;
  public Drawable j;
  public s.a k;
  public s l;
  public boolean m = false;
  
  public static a a(View paramView, s.a parama, s params)
  {
    a locala = new a();
    locala.a = ((TextView)paramView.findViewById(R.id.aw));
    locala.b = ((ImageView)paramView.findViewById(R.id.z));
    locala.c = paramView.findViewById(R.id.bc);
    locala.d = paramView.findViewById(R.id.h);
    locala.e = paramView.findViewById(R.id.i);
    locala.g = paramView.findViewById(R.id.ar);
    locala.h = ((TextView)paramView.findViewById(R.id.g));
    locala.f = paramView;
    locala.l = params;
    locala.k = parama;
    return locala;
  }
  
  public void a()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ("top".equals(this.l.e))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.f.getContext(), 15.0F);
      localLayoutParams.topMargin = DisplayUtil.dip2px(this.f.getContext(), 15.0F);
      this.a.setLayoutParams(localLayoutParams);
      this.a.setTextSize(1, 15.0F);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.a.setText(this.k.b);
      if (!"top".equals(this.l.e)) {
        break label225;
      }
    }
    for (;;)
    {
      a(false);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.f.getContext(), 5.0F);
      localLayoutParams.topMargin = DisplayUtil.dip2px(this.f.getContext(), 0.0F);
      this.a.setLayoutParams(localLayoutParams);
      this.a.setTextSize(1, 12.0F);
      this.d.setVisibility(8);
      this.c.setVisibility(0);
      this.b.setVisibility(0);
      break;
      label225:
      this.i = new BitmapDrawable(this.f.getContext().getResources(), this.k.e);
      this.j = new BitmapDrawable(this.f.getContext().getResources(), this.k.f);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int n = 855638016;
    this.m = paramBoolean;
    this.f.setBackgroundColor(this.l.c);
    if (!paramBoolean)
    {
      this.a.setTextColor(this.l.a);
      if ("top".equals(this.l.e))
      {
        this.e.setVisibility(8);
        if (!"top".equals(this.l.e)) {
          break label193;
        }
        localView = this.d;
        if (!"black".equals(this.l.d)) {
          break label187;
        }
      }
    }
    for (;;)
    {
      localView.setBackgroundColor(n);
      this.e.setBackgroundColor(this.l.b);
      return;
      this.b.setImageDrawable(this.i);
      break;
      this.a.setTextColor(this.l.b);
      if ("top".equals(this.l.e))
      {
        this.e.setVisibility(0);
        break;
      }
      this.b.setImageDrawable(this.j);
      break;
      label187:
      n = 872415231;
    }
    label193:
    View localView = this.c;
    if ("black".equals(this.l.d)) {}
    for (;;)
    {
      localView.setBackgroundColor(n);
      return;
      n = 872415231;
    }
  }
  
  public void b()
  {
    a(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.TabBarView.a
 * JD-Core Version:    0.7.0.1
 */