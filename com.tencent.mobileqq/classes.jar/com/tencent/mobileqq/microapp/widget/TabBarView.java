package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.apkg.s;
import com.tencent.mobileqq.microapp.apkg.s.a;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TabBarView
  extends LinearLayout
{
  public LinkedList a = new LinkedList();
  private s b;
  private TabBarView.b c;
  
  public TabBarView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void a(List paramList)
  {
    removeAllViews();
    this.a.clear();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        View localView = a((s.a)paramList.get(i), i);
        if (localView != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
          localLayoutParams.weight = 1.0F;
          addView(localView, localLayoutParams);
        }
        i += 1;
      }
    }
  }
  
  private void b()
  {
    setOrientation(0);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.bc);
    localRelativeLayout.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5F)));
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setId(R.id.z);
    Object localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 30.0F), DisplayUtil.dip2px(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.bc);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(R.id.g);
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setPadding(DisplayUtil.dip2px(getContext(), 1.0F), 0, DisplayUtil.dip2px(getContext(), 1.0F), 0);
    ((TextView)localObject1).setBackgroundResource(R.drawable.x);
    ((TextView)localObject1).setVisibility(4);
    ((TextView)localObject1).setGravity(17);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.dip2px(getContext(), -10.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, R.id.z);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, R.id.z);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.ar);
    ((View)localObject1).setBackgroundResource(R.drawable.w);
    ((View)localObject1).setVisibility(4);
    localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 10.0F), DisplayUtil.dip2px(getContext(), 10.0F));
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.dip2px(getContext(), -4.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, R.id.z);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, R.id.z);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(R.id.aw);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.z);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = DisplayUtil.dip2px(getContext(), 5.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.aw);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.h);
    localObject2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.aw);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new LinearLayout(getContext());
    ((LinearLayout)localObject1).setOrientation(0);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, R.id.h);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    ((View)localObject2).setId(R.id.i);
    ((View)localObject2).setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 3.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    return localRelativeLayout;
  }
  
  public View a(s.a parama, int paramInt)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.b))) {
      return null;
    }
    View localView = a();
    TabBarView.a locala = TabBarView.a.a(localView, parama, this.b);
    locala.a();
    this.a.add(locala);
    localView.setOnClickListener(new k(this, paramInt, parama));
    return localView;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.a.size()))
    {
      TabBarView.a locala = (TabBarView.a)this.a.get(paramInt);
      locala.g.setVisibility(0);
      locala.h.setVisibility(4);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt != -1) && (paramInt < this.a.size()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() < 5))
    {
      TabBarView.a locala = (TabBarView.a)this.a.get(paramInt);
      locala.h.setVisibility(0);
      locala.h.setText(paramString);
      locala.g.setVisibility(4);
    }
  }
  
  public void a(int paramInt, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramInt != -1) && (paramInt < this.a.size()))
    {
      TabBarView.a locala = (TabBarView.a)this.a.get(paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        locala.a.setText(paramString);
      }
      if (paramBitmap1 != null) {
        locala.i = new BitmapDrawable(getContext().getResources(), paramBitmap1);
      }
      if (paramBitmap2 != null) {
        locala.j = new BitmapDrawable(getContext().getResources(), paramBitmap2);
      }
      locala.b();
    }
  }
  
  public void a(s params)
  {
    this.b = params;
    if (this.b != null)
    {
      this.b = params.a();
      a(this.b.f);
      if (this.a.size() > 0) {
        ((TabBarView.a)this.a.getFirst()).a(true);
      }
    }
  }
  
  public void a(TabBarView.a parama)
  {
    if (parama != null)
    {
      parama.a(true);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        TabBarView.a locala = (TabBarView.a)localIterator.next();
        if (locala != parama) {
          locala.a(false);
        }
      }
    }
  }
  
  public void a(TabBarView.b paramb)
  {
    this.c = paramb;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        TabBarView.a locala = (TabBarView.a)localIterator.next();
        if (locala.k.a.equals(paramString)) {
          a(locala);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.a = DisplayUtil.parseColor(paramString1);
    this.b.b = DisplayUtil.parseColor(paramString2);
    this.b.c = DisplayUtil.parseColor(paramString3);
    paramString2 = this.b;
    if ("white".equals(paramString4)) {}
    for (paramString1 = "white";; paramString1 = "black")
    {
      paramString2.d = paramString1;
      paramString1 = this.a.iterator();
      while (paramString1.hasNext()) {
        ((TabBarView.a)paramString1.next()).b();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (getVisibility() != 0)
    {
      setVisibility(0);
      if ((paramBoolean) && (this.b != null)) {
        if (!"top".equals(this.b.e)) {
          break label77;
        }
      }
    }
    label77:
    for (int i = -getHeight();; i = getHeight())
    {
      setTranslationY(i);
      animate().translationY(0.0F).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < this.a.size()))
    {
      TabBarView.a locala = (TabBarView.a)this.a.get(paramInt);
      locala.g.setVisibility(4);
      locala.h.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (getVisibility() != 8)
    {
      if ((!paramBoolean) || (this.b == null)) {
        break label88;
      }
      if (!"top".equals(this.b.e)) {
        break label80;
      }
    }
    label80:
    for (int i = -getHeight();; i = getHeight())
    {
      animate().translationY(i).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new j(this));
      return;
    }
    label88:
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.TabBarView
 * JD-Core Version:    0.7.0.1
 */