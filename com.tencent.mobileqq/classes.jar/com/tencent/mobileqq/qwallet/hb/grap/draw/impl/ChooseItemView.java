package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChooseItemView
  extends FrameLayout
{
  private static int c = 13;
  ChooseItemView.MyRecycleViewAdapter a;
  public ChooseItemView.OnVisibilityChangeListener b;
  private List<String> d = new LinkedList();
  private View.OnClickListener e;
  private View.OnClickListener f;
  private LinearLayout g = new LinearLayout(getContext());
  private int h = 4;
  private int i = 0;
  private int j = 0;
  private boolean k = false;
  private String l;
  private View.OnClickListener m = new ChooseItemView.3(this);
  private Paint n;
  
  public ChooseItemView(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.g.setOrientation(1);
    addView(this.g);
    paramContext = (FrameLayout.LayoutParams)this.g.getLayoutParams();
    paramContext.width = -1;
    paramContext.height = -2;
    setOnClickListener(paramOnClickListener);
    this.g.setOnTouchListener(new ChooseItemView.1(this));
  }
  
  private void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChooseItemView.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    this.e = new ChooseItemView.4(this, paramOnClickListener1);
    this.f = paramOnClickListener2;
    this.b = paramOnVisibilityChangeListener;
  }
  
  private boolean a(int paramInt)
  {
    if (this.j == 1) {
      return true;
    }
    return paramInt <= this.h;
  }
  
  private void e()
  {
    QLog.i("ChooseItemView", 2, "updatePageInner....");
    this.g.removeAllViews();
    this.g.setPadding(DisplayUtil.a(getContext(), 8.0F), 0, this.g.getPaddingRight(), DisplayUtil.a(getContext(), 10.0F));
    f();
    Object localObject = new RecyclerView(getContext());
    this.a = new ChooseItemView.MyRecycleViewAdapter(getAdapterInfo(), this.e);
    this.a.a(this.l);
    ((RecyclerView)localObject).setAdapter(this.a);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    this.g.addView((View)localObject);
    localObject = (LinearLayout.LayoutParams)((RecyclerView)localObject).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = -1;
    ((LinearLayout.LayoutParams)localObject).height = -1;
  }
  
  private void f()
  {
    if (this.j == 0)
    {
      TextView localTextView = new TextView(getContext());
      this.g.addView(localTextView);
      Object localObject = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = -2;
      ((LinearLayout.LayoutParams)localObject).width = -2;
      ((LinearLayout.LayoutParams)localObject).gravity = 5;
      localObject = getContext().getResources().getDrawable(R.drawable.p);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localTextView.setCompoundDrawablePadding(DisplayUtil.a(getContext(), 7.0F));
      localTextView.setPadding(DisplayUtil.a(getContext(), 5.0F), 0, DisplayUtil.a(getContext(), 20.0F), DisplayUtil.a(getContext(), 10.0F));
      localTextView.setText(HardCodeUtil.a(R.string.au));
      localTextView.setTextColor(-1694379);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setOnClickListener(this.m);
      QWalletTools.a(localTextView, 0.6F);
    }
  }
  
  private List<List<ChooseItemView.ItemInfo>> getAdapterInfo()
  {
    LinkedList localLinkedList2 = new LinkedList();
    int i3 = this.g.getWidth();
    LinkedList localLinkedList1 = new LinkedList();
    int i2 = 0;
    int i1 = 0;
    for (;;)
    {
      int i4 = this.d.size();
      boolean bool = true;
      if ((i2 >= i4) || (!a(localLinkedList2.size() + 1))) {
        break;
      }
      String str = (String)this.d.get(i2);
      if (i2 >= this.i) {
        bool = false;
      }
      ChooseItemView.ItemInfo localItemInfo = new ChooseItemView.ItemInfo(str, bool, false);
      float f1 = getTxtMeasurePaint().measureText(str) + DisplayUtil.a(getContext(), 26.0F);
      float f2 = i1;
      if (f2 + f1 + DisplayUtil.a(getContext(), 12.0F) * 2 <= i3)
      {
        localLinkedList1.add(localItemInfo);
        i1 = (int)(f2 + (f1 + DisplayUtil.a(getContext(), 12.0F)));
      }
      else
      {
        localLinkedList2.add(localLinkedList1);
        localLinkedList1 = new LinkedList();
        localLinkedList1.add(localItemInfo);
        i1 = (int)f1 + DisplayUtil.a(getContext(), 12.0F);
      }
      i2 += 1;
    }
    if (a(localLinkedList2.size() + 1)) {
      localLinkedList2.add(localLinkedList1);
    }
    return localLinkedList2;
  }
  
  private Paint getTxtMeasurePaint()
  {
    if (this.n == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextSize(1, c);
      this.n = localTextView.getPaint();
    }
    return this.n;
  }
  
  public void a(String paramString)
  {
    if (getVisibility() == 0)
    {
      b();
      return;
    }
    a(paramString, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    this.l = paramString;
    setVisibility(0);
    if (this.k) {
      return;
    }
    this.k = true;
    this.g.post(new ChooseItemView.2(this));
    QLog.i("ChooseItemView", 2, "show....");
  }
  
  public void a(List<String> paramList, boolean paramBoolean, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, ChooseItemView.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        this.d.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          if (!TextUtils.isEmpty(str)) {
            this.d.add(str);
          }
        }
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        if (paramBoolean)
        {
          paramList = this.d;
          if ((paramList != null) && (paramList.size() > 1)) {
            Collections.shuffle(this.d);
          }
        }
        a(paramOnClickListener1, paramOnClickListener2, paramOnVisibilityChangeListener);
      }
    }
  }
  
  public boolean a()
  {
    List localList = this.d;
    return (localList != null) && (localList.size() > 0);
  }
  
  public void b()
  {
    setVisibility(8);
  }
  
  public void c()
  {
    a("", true);
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.h = paramInt;
    if (this.h <= 0) {
      this.h = 4;
    }
  }
  
  public void setRecommendCnt(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setStyle(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setTextSizeInDp(int paramInt)
  {
    if (paramInt > 0) {
      c = paramInt;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    ChooseItemView.OnVisibilityChangeListener localOnVisibilityChangeListener = this.b;
    if (localOnVisibilityChangeListener != null) {
      localOnVisibilityChangeListener.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView
 * JD-Core Version:    0.7.0.1
 */