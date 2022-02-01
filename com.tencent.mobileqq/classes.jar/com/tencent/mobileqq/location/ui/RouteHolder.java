package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.BaseApplication;

public class RouteHolder
{
  TextView a;
  TextView b;
  TextView c;
  TextView d;
  View e;
  View f;
  View g;
  View h;
  View i;
  View j;
  View k;
  View l;
  View m;
  TextView n;
  TextView o;
  TextView p;
  int q = 0;
  private LocationShareController r;
  
  RouteHolder(LocationShareController paramLocationShareController, View paramView)
  {
    this.r = paramLocationShareController;
    b(paramView);
    c();
  }
  
  private void b(View paramView)
  {
    this.e = paramView.findViewById(2131445183);
    this.a = ((TextView)paramView.findViewById(2131445197));
    this.b = ((TextView)paramView.findViewById(2131445196));
    this.f = paramView.findViewById(2131445182);
    this.c = ((TextView)paramView.findViewById(2131445195));
    this.d = ((TextView)paramView.findViewById(2131445184));
    this.g = paramView.findViewById(2131445187);
    this.h = paramView.findViewById(2131445186);
    this.i = paramView.findViewById(2131445180);
    this.j = paramView.findViewById(2131445194);
    this.k = paramView.findViewById(2131445190);
    this.l = paramView.findViewById(2131445188);
    this.m = paramView.findViewById(2131445192);
    this.n = ((TextView)paramView.findViewById(2131445191));
    this.o = ((TextView)paramView.findViewById(2131445189));
    this.p = ((TextView)paramView.findViewById(2131445193));
    if (QQUIDelegate.c())
    {
      this.k.setBackgroundResource(2130846995);
      this.n.setTextColor(paramView.getContext().getResources().getColor(2131166405));
      this.l.setBackgroundResource(2130846995);
      this.o.setTextColor(paramView.getContext().getResources().getColor(2131166405));
      this.m.setBackgroundResource(2130846995);
      this.p.setTextColor(paramView.getContext().getResources().getColor(2131166405));
      paramView.findViewById(2131432000).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131432001).setBackgroundColor(Color.parseColor("#282828"));
      this.c.setTextColor(-1);
      this.d.setTextColor(-1);
      this.g.setBackgroundResource(2130846996);
      this.a.setTextColor(-1);
      this.b.setTextColor(-1);
    }
  }
  
  private void c()
  {
    this.f.setOnClickListener(new RouteHolder.1(this));
    this.g.setOnClickListener(new RouteHolder.2(this));
    this.k.setOnClickListener(new RouteHolder.3(this));
    this.l.setOnClickListener(new RouteHolder.4(this));
    this.m.setOnClickListener(new RouteHolder.5(this));
  }
  
  private String d()
  {
    int i1 = this.q;
    if (i1 != 2)
    {
      if (i1 != 3) {
        return "drive";
      }
      return "walk";
    }
    return "bus";
  }
  
  void a()
  {
    this.e.setVisibility(0);
  }
  
  void a(int paramInt)
  {
    this.h.setVisibility(0);
    this.j.setVisibility(8);
    this.i.setVisibility(8);
    LocationRoom.Venue localVenue = this.r.a.getVenue();
    this.a.setText(localVenue.c);
    this.b.setText(localVenue.d);
    b(paramInt);
  }
  
  void a(View paramView)
  {
    this.k.setSelected(false);
    this.l.setSelected(false);
    this.m.setSelected(false);
    paramView.setSelected(true);
  }
  
  void a(MapWidget.RouteDetail paramRouteDetail)
  {
    this.h.setVisibility(8);
    this.j.setVisibility(8);
    this.i.setVisibility(0);
    LocationRoom.Venue localVenue = this.r.a.getVenue();
    this.a.setText(localVenue.c);
    this.b.setText(localVenue.d);
    int i1;
    if (paramRouteDetail != null) {
      i1 = paramRouteDetail.a.intValue();
    } else {
      i1 = 1;
    }
    b(i1);
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(MapWidget.RouteDetail paramRouteDetail, LocationRoom.Venue paramVenue)
  {
    this.h.setVisibility(8);
    this.j.setVisibility(0);
    this.i.setVisibility(8);
    this.a.setText(paramVenue.c);
    this.b.setText(paramVenue.d);
    this.c.setText(MapUtils.a(paramRouteDetail.b));
    if (paramRouteDetail.c < 1000.0F)
    {
      paramVenue = String.format(BaseApplication.getContext().getResources().getString(2131891399), new Object[] { Integer.valueOf(Math.round(paramRouteDetail.c)) });
    }
    else
    {
      paramVenue = BaseApplication.getContext().getResources().getString(2131891398);
      double d1 = paramRouteDetail.c;
      Double.isNaN(d1);
      paramVenue = String.format(paramVenue, new Object[] { Double.valueOf(d1 / 1000.0D) });
    }
    this.d.setText(paramVenue);
    b(paramRouteDetail.a.intValue());
  }
  
  void b()
  {
    this.e.setVisibility(8);
  }
  
  void b(int paramInt)
  {
    this.q = paramInt;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        this.q = 1;
        a(this.k);
        return;
      }
      a(this.m);
      return;
    }
    a(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.RouteHolder
 * JD-Core Version:    0.7.0.1
 */