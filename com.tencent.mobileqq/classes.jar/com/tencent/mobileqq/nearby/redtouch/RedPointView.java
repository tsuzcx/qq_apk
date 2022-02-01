package com.tencent.mobileqq.nearby.redtouch;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.ArrayList;
import java.util.List;

public class RedPointView
  extends FrameLayout
{
  protected static int g = 1;
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected Context e;
  protected View f;
  protected boolean h = false;
  protected Handler i;
  protected int j = 21;
  protected int k = 0;
  protected int l = 0;
  protected int m = 0;
  protected int n = 0;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected boolean u = false;
  protected boolean v = true;
  protected List<BusinessInfoCheckUpdate.RedTypeInfo> w;
  
  public RedPointView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedPointView(Context paramContext, View paramView)
  {
    super(paramContext);
    this.e = paramContext;
    this.f = paramView;
    a();
  }
  
  private void a()
  {
    this.o = this.j;
    this.p = this.k;
    this.q = this.l;
    this.r = this.m;
    this.s = this.n;
    this.t = 99;
    this.w = new ArrayList();
    this.i = new Handler(Looper.getMainLooper());
    this.a = 10;
    this.b = 20;
    this.c = 30;
    this.d = 40;
  }
  
  private FrameLayout.LayoutParams getRedTouchContainerLayoutParams()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.o;
    localLayoutParams.leftMargin = this.p;
    localLayoutParams.rightMargin = this.q;
    localLayoutParams.topMargin = this.r;
    localLayoutParams.bottomMargin = this.s;
    return localLayoutParams;
  }
  
  private FrameLayout.LayoutParams getRedTouchTargetLayoutParams()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  public int getGravity()
  {
    return this.o;
  }
  
  public int getLeftMargin()
  {
    return this.p;
  }
  
  protected LinearLayout.LayoutParams getRedTouchLayoutParams()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public int getRightMargin()
  {
    return this.q;
  }
  
  public View getTarget()
  {
    return this.f;
  }
  
  public int getTopMargin()
  {
    return this.r;
  }
  
  public void setMaxNum(int paramInt)
  {
    this.t = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedPointView
 * JD-Core Version:    0.7.0.1
 */