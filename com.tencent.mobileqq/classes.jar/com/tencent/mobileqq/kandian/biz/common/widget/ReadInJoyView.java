package com.tencent.mobileqq.kandian.biz.common.widget;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderFriendRecommend;
import com.tencent.widget.FixSizeImageView;

public class ReadInJoyView
{
  public View a;
  public View b;
  public ComponentHeaderFriendRecommend c;
  public View d;
  public KandianUrlImageView e;
  public FixSizeImageView[] f = new FixSizeImageView[4];
  public TextView g;
  public TextView h;
  public View i;
  public View j;
  public View k;
  public View l;
  public View m;
  public TextView[] n = new TextView[4];
  public View[] o = new View[2];
  public View p;
  public TextView q;
  public View r;
  public TextView s;
  public TextView t;
  public View u;
  public View v;
  public View w;
  public TextView x;
  private View y;
  
  public ReadInJoyView(View paramView)
  {
    this.y = paramView;
    g();
  }
  
  private void g()
  {
    this.j = this.y.findViewById(2131449096);
    this.k = this.y.findViewById(2131446615);
    this.l = this.y.findViewById(2131439121);
    this.v = this.y.findViewById(2131444214);
  }
  
  public View a()
  {
    return this.y;
  }
  
  public void b()
  {
    if (this.a != null) {
      return;
    }
    this.b = ((ViewStub)this.y.findViewById(2131444219)).inflate();
    this.a = this.b.findViewById(2131428807);
    this.d = this.y.findViewById(2131444226);
    this.e = ((KandianUrlImageView)this.y.findViewById(2131444240));
    this.f[0] = ((FixSizeImageView)this.y.findViewById(2131444215));
    this.f[1] = ((FixSizeImageView)this.y.findViewById(2131444216));
    this.f[2] = ((FixSizeImageView)this.y.findViewById(2131444217));
    this.f[3] = ((FixSizeImageView)this.y.findViewById(2131444218));
    this.g = ((TextView)this.y.findViewById(2131444231));
    this.h = ((TextView)this.y.findViewById(2131444222));
    this.i = this.y.findViewById(2131449116);
    this.c = ((ComponentHeaderFriendRecommend)this.y.findViewById(2131434965));
  }
  
  public void c()
  {
    if (this.m != null) {
      return;
    }
    this.m = ((ViewStub)this.y.findViewById(2131436703)).inflate();
    this.n[0] = ((TextView)this.y.findViewById(2131436704));
    this.n[1] = ((TextView)this.y.findViewById(2131436706));
    this.n[2] = ((TextView)this.y.findViewById(2131436708));
    this.n[3] = ((TextView)this.y.findViewById(2131436709));
    this.o[0] = this.y.findViewById(2131436705);
    this.o[1] = this.y.findViewById(2131436707);
  }
  
  public void d()
  {
    if (this.p != null) {
      return;
    }
    this.p = ((ViewStub)this.y.findViewById(2131433789)).inflate();
    this.q = ((TextView)this.y.findViewById(2131433790));
  }
  
  public void e()
  {
    if (this.r != null) {
      return;
    }
    this.r = ((ViewStub)this.y.findViewById(2131431121)).inflate();
    this.s = ((TextView)this.y.findViewById(2131431119));
    this.t = ((TextView)this.y.findViewById(2131431117));
    this.u = this.y.findViewById(2131431076);
  }
  
  public boolean f()
  {
    if (this.w != null) {
      return true;
    }
    ViewStub localViewStub = (ViewStub)this.y.findViewById(2131444237);
    if (localViewStub == null) {
      return false;
    }
    this.w = localViewStub.inflate();
    this.x = ((TextView)this.y.findViewById(2131444236));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView
 * JD-Core Version:    0.7.0.1
 */