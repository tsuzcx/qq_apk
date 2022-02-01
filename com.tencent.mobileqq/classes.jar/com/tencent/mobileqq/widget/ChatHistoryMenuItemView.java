package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatHistoryMenuItemView
  extends LinearLayout
  implements View.OnClickListener
{
  private int a;
  private int b;
  private int c;
  private int d;
  private TextView e;
  private LinearLayout f;
  private ArrayList<ChatHistoryMenuItemView.CategoryItemColumnView> g;
  private ArrayList<ChatHistoryMenuItemView.SeparatorColumnView> h;
  private ArrayList<TextView> i;
  private ArrayList<ChatHistoryMenuItemView.OnCategoryClickListener> j;
  
  public ChatHistoryMenuItemView(Context paramContext, int paramInt, String paramString, int[] paramArrayOfInt)
  {
    super(paramContext);
    this.a = paramInt;
    this.b = paramArrayOfInt.length;
    a(paramContext, paramString, a(paramArrayOfInt));
  }
  
  private ArrayList<String> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = paramArrayOfInt.length;
    int k = 0;
    while (k < m)
    {
      int n = paramArrayOfInt[k];
      localArrayList.add(getResources().getString(n));
      k += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    if (QQTheme.isNowSimpleUI())
    {
      this.c = getResources().getColor(2131168059);
      this.d = 0;
      return;
    }
    this.c = getResources().getColor(2131165905);
    this.d = getResources().getColor(2131165997);
  }
  
  private void a(Context paramContext, String paramString)
  {
    this.e = new TextView(paramContext);
    this.e.setText(paramString);
    this.e.setGravity(17);
    this.e.setTextSize(2, 14.0F);
    this.e.setTextColor(this.c);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(0, ViewUtils.dip2px(28.0F), 0, ViewUtils.dip2px(32.0F));
    this.e.setLayoutParams(paramContext);
    addView(this.e);
  }
  
  private void a(Context paramContext, String paramString, ArrayList<String> paramArrayList)
  {
    setOrientation(1);
    a();
    a(paramContext, paramString);
    this.f = new LinearLayout(paramContext);
    paramString = this.f;
    int m = 0;
    paramString.setOrientation(0);
    this.f.setGravity(1);
    addView(this.f);
    this.g = ChatHistoryMenuItemView.CategoryItemColumnView.a(paramContext, this.a);
    this.i = new ArrayList(this.b);
    int k = 0;
    while (k < this.b)
    {
      paramString = new ChatHistoryMenuItemView.CategoryItem(paramContext, (String)paramArrayList.get(k), this);
      this.i.add(paramString);
      ((ChatHistoryMenuItemView.CategoryItemColumnView)this.g.get(k % this.a)).addView(paramString);
      k += 1;
    }
    this.h = ChatHistoryMenuItemView.SeparatorColumnView.a(paramContext, this.a, this.g, this.d);
    k = m;
    for (;;)
    {
      m = this.a;
      if (k >= m - 1) {
        break;
      }
      this.f.addView((View)this.g.get(k));
      this.f.addView((View)this.h.get(k));
      k += 1;
    }
    this.f.addView((View)this.g.get(m - 1));
  }
  
  public void a(ChatHistoryMenuItemView.OnCategoryClickListener paramOnCategoryClickListener)
  {
    if (this.j == null) {
      this.j = new ArrayList();
    }
    this.j.add(paramOnCategoryClickListener);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ChatHistoryMenuItemView.OnCategoryClickListener)((Iterator)localObject).next()).a(this.i.indexOf(paramView));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ChatHistoryMenuItemView
 * JD-Core Version:    0.7.0.1
 */