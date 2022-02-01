package com.tencent.mobileqq.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQTheme;

public class PostTable
  extends RelativeLayout
{
  public RelativeLayout a;
  private Context b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private ImageView l;
  private ImageView m;
  private TextView n;
  private TextView o;
  private View p;
  private boolean q = false;
  
  public PostTable(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PostTable(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext;
    this.k = 0;
    this.a = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131624509, this));
    this.l = ((ImageView)this.a.findViewById(2131440542));
    this.m = ((ImageView)this.a.findViewById(2131440543));
    this.n = ((TextView)this.a.findViewById(2131440544));
    this.o = ((TextView)this.a.findViewById(2131440541));
    this.p = this.a.findViewById(2131440540);
    if (QQTheme.isNowThemeIsNight()) {
      this.p.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839417));
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.e = paramContext.getDefaultDisplay().getWidth();
    this.f = paramContext.getDefaultDisplay().getHeight();
    d();
  }
  
  private void d()
  {
    this.c = this.b.getResources().getDimensionPixelSize(2131298244);
    this.d = this.b.getResources().getDimensionPixelSize(2131298245);
    this.c = ((int)(this.c * 1.083333F));
    this.d = ((int)(this.d * 1.0F));
    this.i = (this.f - getResources().getDimensionPixelSize(2131298243));
    this.h = (this.i - this.c);
    this.g = this.e;
    this.j = (this.g + this.d);
  }
  
  private void e()
  {
    this.o.setVisibility(0);
    this.n.setVisibility(8);
    this.m.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  private void f()
  {
    this.o.setVisibility(4);
    this.n.setVisibility(0);
    this.m.setVisibility(0);
    this.l.setVisibility(0);
    this.m.setScaleX(0.0F);
    this.m.setScaleY(0.0F);
  }
  
  public void a()
  {
    int i1 = this.k;
    if (i1 == 0) {
      return;
    }
    if (i1 == 2) {
      f();
    }
    this.q = true;
    this.k = 0;
    PostTableAnimHelper.a(this.m, 300, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
    PostTableAnimHelper.a(this.l, 300, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F);
    PostTableAnimHelper.a(this.p, 300, 1.0F, 1.0F, 1.083333F, 1.0F);
  }
  
  public void a(double paramDouble)
  {
    if (this.q)
    {
      d();
      this.q = false;
    }
    int i1 = this.e;
    int i2 = this.d;
    double d1 = i2;
    Double.isNaN(d1);
    this.g = (i1 - (int)(d1 * paramDouble));
    d1 = i2;
    Double.isNaN(d1);
    this.j = (i1 - (int)(paramDouble * d1) + i2);
    layout(this.g, this.h, this.j, this.i);
    invalidate();
  }
  
  public void b()
  {
    int i1 = this.k;
    if (i1 == 1) {
      return;
    }
    if (i1 == 2) {
      f();
    }
    this.q = true;
    this.k = 1;
    PostTableAnimHelper.a(this.l, 300, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
    PostTableAnimHelper.a(this.m, 300, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F);
    PostTableAnimHelper.a(this.p, 300, 1.0F, 1.0F, 1.0F, 1.083333F);
  }
  
  public void c()
  {
    if (this.k == 2) {
      return;
    }
    this.q = true;
    e();
    this.k = 2;
    this.p.setScaleX(1.0F);
    this.p.setScaleY(1.083333F);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, this.g, this.h, this.j, this.i);
    if (paramInt2 == 0) {
      layout(this.g, this.h, this.j, this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.swipe.PostTable
 * JD-Core Version:    0.7.0.1
 */