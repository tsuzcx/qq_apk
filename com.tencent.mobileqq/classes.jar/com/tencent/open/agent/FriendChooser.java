package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.open.adapter.IOpenAppClient;
import com.tencent.open.adapter.OpenAppClientImpl;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class FriendChooser
  extends QBaseActivity
  implements View.OnClickListener, Animation.AnimationListener, ImageLoader.ImageLoadListener
{
  @ConfigInject(configPath="Business/opensdk-api/src/main/resources/Inject_open_app_client.yml", version=1)
  private static ArrayList<Class<? extends IOpenAppClient>> N = new ArrayList();
  protected List<Friend> A = new ArrayList();
  protected ArrayList<Friend> B = new ArrayList();
  protected FriendDataManager C;
  protected float D;
  public boolean E;
  protected InputMethodManager F = null;
  protected TranslateAnimation G;
  protected TranslateAnimation H;
  protected AlphaAnimation I;
  protected ImageView J;
  protected int K = 99999;
  protected int L = 99999;
  final Handler M = new FriendChooser.4(this);
  protected View a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  protected LinearLayout f;
  protected ViewStub g;
  protected InnerFrameManager h;
  protected HorizontalScrollView i;
  protected GridView j;
  protected Button k;
  protected Button l;
  protected TextView m;
  protected RelativeLayout n;
  protected View o;
  protected EditText p;
  protected ImageButton q;
  protected Button r;
  protected View s;
  protected String t;
  protected String u;
  protected String v;
  protected XListView w;
  protected FriendChooser.GridViewAdapter x;
  protected FriendChooser.SearchResultAdapter y;
  protected ArrayList<String> z;
  
  static
  {
    N.add(OpenAppClientImpl.class);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected void a(Friend paramFriend)
  {
    boolean bool;
    if (this.C.b(paramFriend.a))
    {
      bool = false;
      this.B.remove(paramFriend);
      this.C.d(paramFriend.a);
    }
    else
    {
      if (this.C.d() >= this.K)
      {
        j();
        return;
      }
      bool = true;
      this.B.add(paramFriend);
      this.C.c(paramFriend.a);
    }
    b(bool);
    f();
  }
  
  protected void a(String paramString)
  {
    this.A.clear();
    if ((!paramString.equals("")) && (paramString.trim().length() != 0))
    {
      this.q.setVisibility(0);
      this.w.setVisibility(0);
      this.A.clear();
      Object localObject = ((OpenFrame)this.h.getCurrentView()).getDataForSearch();
      if (localObject != null)
      {
        paramString = paramString.toLowerCase();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friend localFriend = (Friend)((Iterator)localObject).next();
          if ((!paramString.equals(localFriend.i)) && (!paramString.equals(localFriend.j)) && (!paramString.equals(localFriend.c)) && (!paramString.equals(localFriend.b)))
          {
            if (((localFriend.c != null) && (localFriend.c.indexOf(paramString) >= 0)) || ((localFriend.b != null) && (localFriend.b.indexOf(paramString) >= 0)) || (localFriend.i.indexOf(paramString) >= 0) || (localFriend.j.indexOf(paramString) >= 0)) {
              localArrayList2.add(localFriend);
            }
          }
          else {
            localArrayList1.add(localFriend);
          }
        }
        Collections.sort(localArrayList2, new FriendChooser.MyComparator(this));
        this.A.addAll(localArrayList1);
        this.A.addAll(localArrayList2);
      }
      if (this.A.isEmpty()) {
        this.s.setVisibility(0);
      } else {
        this.s.setVisibility(8);
      }
    }
    else
    {
      this.q.setVisibility(8);
      this.w.setVisibility(8);
      this.s.setVisibility(8);
    }
    this.y.notifyDataSetChanged();
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.y.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i1 = this.B.size();
    String str;
    if (i1 <= 1) {
      str = this.u;
    } else {
      str = MessageFormat.format(this.v, new Object[] { Integer.valueOf(i1) });
    }
    if (paramBoolean)
    {
      this.k.setVisibility(4);
      this.l.setVisibility(0);
      this.l.setText(str);
      return;
    }
    this.k.setVisibility(0);
    this.k.setText(str);
    this.l.setVisibility(4);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      this.c.setVisibility(0);
      this.c.setText(paramString1);
      this.d.setVisibility(4);
      a(this.c);
    }
    else
    {
      this.c.setVisibility(4);
      this.d.setVisibility(4);
    }
    if (paramBoolean2) {
      this.e.setVisibility(0);
    } else {
      this.e.setVisibility(4);
    }
    this.b.setText(paramString2);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean1)
    {
      this.c.setVisibility(0);
      this.c.setText(paramString1);
      this.d.setVisibility(4);
      a(this.c);
    }
    else
    {
      this.c.setVisibility(4);
      this.d.setVisibility(4);
    }
    if (paramBoolean2)
    {
      this.e.setVisibility(0);
      this.e.setText(paramString3);
    }
    else
    {
      this.e.setVisibility(4);
    }
    this.b.setText(paramString2);
  }
  
  protected void b()
  {
    this.t = super.getString(2131916218);
    this.u = super.getString(2131887910);
    this.v = super.getString(2131887910);
    this.c.setVisibility(4);
    this.d.setVisibility(4);
    this.e.setVisibility(0);
    this.e.setText(2131886464);
    this.b.setText(this.t);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  protected void b(boolean paramBoolean)
  {
    Object localObject = this.m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.B.size());
    localStringBuilder.append("/");
    localStringBuilder.append(this.K);
    ((TextView)localObject).setText(localStringBuilder.toString());
    this.j.setNumColumns(this.B.size());
    localObject = this.j.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)((this.B.size() * 36 + this.B.size() * 10) * this.D));
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.C.d() == this.K) {
      this.J.setVisibility(4);
    } else {
      this.J.setVisibility(0);
    }
    if (paramBoolean) {
      this.M.sendEmptyMessageDelayed(100, 200L);
    }
    this.x.notifyDataSetChanged();
  }
  
  @SuppressLint({"NewApi"})
  protected void c()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      this.i.setOverScrollMode(2);
    }
    this.x = new FriendChooser.GridViewAdapter(this);
    this.j.setAdapter(this.x);
    this.j.setSmoothScrollbarEnabled(false);
    this.k.setVisibility(0);
    this.k.setText(this.u);
    this.k.setEnabled(false);
    this.l.setVisibility(4);
    this.l.setText(this.v);
    this.j.setOnItemClickListener(new FriendChooser.1(this));
    this.l.setOnClickListener(this);
  }
  
  protected void d()
  {
    if (this.F == null) {
      this.F = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.G = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.a.getHeight());
    this.G.setDuration(300L);
    this.G.setFillAfter(true);
    this.I = new AlphaAnimation(0.0F, 1.0F);
    this.I.setDuration(300L);
    this.G.setAnimationListener(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, this.f.getHeight() + this.a.getHeight());
    this.f.setLayoutParams(localLayoutParams);
    this.f.startAnimation(this.G);
    this.F.toggleSoftInput(0, 0);
    this.E = true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void e()
  {
    this.n = ((RelativeLayout)this.g.inflate());
    this.p = ((EditText)this.n.findViewById(2131432634));
    this.q = ((ImageButton)this.n.findViewById(2131435215));
    this.r = ((Button)this.n.findViewById(2131429816));
    this.o = this.n.findViewById(2131444724);
    this.w = ((XListView)this.n.findViewById(2131445451));
    this.s = this.n.findViewById(2131439366);
    this.p.addTextChangedListener(new FriendChooser.SearchTextWatcher(this));
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.w.setBackgroundResource(2130838958);
    this.w.setDividerHeight(0);
    this.y = new FriendChooser.SearchResultAdapter(this, this.A);
    this.w.setAdapter(this.y);
    this.o.setOnClickListener(this);
    this.w.setOnTouchListener(new FriendChooser.2(this));
    this.w.setOnItemClickListener(new FriendChooser.3(this));
  }
  
  protected void f()
  {
    TextView localTextView = this.m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.B.size());
    localStringBuilder.append("/");
    localStringBuilder.append(this.K);
    localTextView.setText(localStringBuilder.toString());
    if (this.B.size() > 0)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected void g()
  {
    this.p.setText("");
    this.H = new TranslateAnimation(0.0F, 0.0F, -this.a.getHeight(), 0.0F);
    this.H.setDuration(300L);
    this.H.setAnimationListener(this);
    this.n.setVisibility(8);
    this.f.startAnimation(this.H);
    this.F.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.E = false;
  }
  
  protected abstract void h();
  
  public abstract String i();
  
  public abstract void j();
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.H)
    {
      paramAnimation = new FrameLayout.LayoutParams(-1, -1);
      this.f.setLayoutParams(paramAnimation);
      return;
    }
    if (paramAnimation == this.G)
    {
      if (this.n == null) {
        e();
      }
      this.o.startAnimation(this.I);
      this.n.setVisibility(0);
      this.p.requestFocus();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected boolean onBackEvent()
  {
    RelativeLayout localRelativeLayout = this.n;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      g();
      return true;
    }
    if (this.h.getCurrentPage() != 1) {
      return super.onBackEvent();
    }
    this.h.a(0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.c)
    {
      onBackEvent();
    }
    else if (paramView == this.e)
    {
      super.finish();
    }
    else if (paramView == this.l)
    {
      h();
    }
    else if (paramView == this.q)
    {
      this.p.setText("");
      this.F.showSoftInput(this.p, 0);
    }
    else if (paramView == this.r)
    {
      g();
    }
    else if (paramView == this.o)
    {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131952010);
    super.setContentView(a());
    AppRuntime localAppRuntime = getAppRuntime();
    try
    {
      ((IOpenAppClient)((Class)N.get(0)).newInstance()).a((AppInterface)localAppRuntime);
    }
    catch (Exception paramBundle)
    {
      QLog.e("qqBaseActivity", 1, paramBundle, new Object[0]);
    }
    this.C = FriendDataManager.a();
    this.a = super.findViewById(2131447484);
    this.b = ((TextView)super.findViewById(2131436227));
    this.c = ((TextView)super.findViewById(2131436180));
    this.d = ((TextView)super.findViewById(2131436182));
    this.e = ((TextView)super.findViewById(2131436211));
    this.f = ((LinearLayout)super.findViewById(2131439598));
    this.g = ((ViewStub)super.findViewById(2131445445));
    this.h = ((InnerFrameManager)super.findViewById(2131439608));
    this.i = ((HorizontalScrollView)super.findViewById(2131445370));
    this.j = ((GridView)super.findViewById(2131445556));
    this.k = ((Button)super.findViewById(2131432054));
    this.l = ((Button)super.findViewById(2131432055));
    this.m = ((TextView)super.findViewById(2131445519));
    this.J = ((ImageView)super.findViewById(2131439238));
    b();
    this.h.a(this);
    paramBundle = null;
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      paramBundle = (BaseQQAppInterface)localAppRuntime;
    }
    this.h.setAppIntf(paramBundle);
    this.h.a(0);
    c();
    this.D = getResources().getDisplayMetrics().density;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.h.d();
    if (this.y != null) {
      this.y = null;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.h.b();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.h.a();
  }
  
  protected void onStart()
  {
    super.onStart();
    getWindow().setSoftInputMode(16);
  }
  
  protected void onStop()
  {
    super.onStop();
    super.getWindow().setSoftInputMode(48);
    this.h.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser
 * JD-Core Version:    0.7.0.1
 */