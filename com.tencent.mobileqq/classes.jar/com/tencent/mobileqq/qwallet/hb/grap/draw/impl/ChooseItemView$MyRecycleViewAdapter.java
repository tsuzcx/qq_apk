package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.Iterator;
import java.util.List;

class ChooseItemView$MyRecycleViewAdapter
  extends RecyclerView.Adapter<ChooseItemView.MyHolder>
{
  private static final int e = R.id.bC;
  private static final int f = R.id.bD;
  private static final int g = R.id.bE;
  private List<List<ChooseItemView.ItemInfo>> a;
  private View.OnClickListener b;
  private ChooseItemView.ItemInfo c;
  private String d;
  
  ChooseItemView$MyRecycleViewAdapter(@NonNull List<List<ChooseItemView.ItemInfo>> paramList, View.OnClickListener paramOnClickListener)
  {
    this.a = paramList;
    this.b = paramOnClickListener;
  }
  
  private View a(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, ChooseItemView.d());
    localTextView.setGravity(16);
    int i = DisplayUtil.a(paramContext, 13.0F);
    localTextView.setPadding(i, 0, i, 0);
    localTextView.setOnClickListener(this.b);
    QWalletTools.a(localTextView, 0.6F);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-2, DisplayUtil.a(paramContext, 30.0F)));
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new LinearLayout.LayoutParams(-2, DisplayUtil.a(paramContext, 30.0F));
    ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(paramContext, 12.0F);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRelativeLayout.addView(localTextView);
    localTextView.setId(R.id.bN);
    localObject = new View(paramContext);
    ((View)localObject).setBackgroundResource(R.drawable.al);
    ((View)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.width = DisplayUtil.a(paramContext, 9.2F);
    localLayoutParams.height = DisplayUtil.a(paramContext, 8.9F);
    localLayoutParams.addRule(7, R.id.bN);
    localLayoutParams.addRule(6, R.id.bN);
    localRelativeLayout.setTag(e, localTextView);
    localRelativeLayout.setTag(f, localObject);
    return localRelativeLayout;
  }
  
  private void a(View paramView, ChooseItemView.ItemInfo paramItemInfo)
  {
    TextView localTextView = (TextView)paramView.getTag(e);
    paramView = (View)paramView.getTag(f);
    localTextView.setText(paramItemInfo.a);
    int i;
    if (paramItemInfo.b) {
      i = 0;
    } else {
      i = 4;
    }
    paramView.setVisibility(i);
    if ((!paramItemInfo.c) && ((TextUtils.isEmpty(this.d)) || (!this.d.equals(paramItemInfo.a))))
    {
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(R.drawable.U);
    }
    else
    {
      localTextView.setTextColor(-1);
      localTextView.setBackgroundResource(R.drawable.V);
      this.d = "";
    }
    localTextView.setTag(g, paramItemInfo);
  }
  
  public ChooseItemView.MyHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    paramInt = DisplayUtil.a(paramViewGroup.getContext(), 6.0F);
    localLinearLayout.setPadding(0, paramInt, 0, paramInt);
    return new ChooseItemView.MyHolder(localLinearLayout);
  }
  
  public void a(View paramView)
  {
    ChooseItemView.ItemInfo localItemInfo = this.c;
    if (localItemInfo != null) {
      localItemInfo.c = false;
    }
    paramView = (ChooseItemView.ItemInfo)paramView.getTag(g);
    paramView.c = true;
    this.c = paramView;
    notifyDataSetChanged();
  }
  
  public void a(ChooseItemView.MyHolder paramMyHolder, int paramInt)
  {
    List localList = (List)this.a.get(paramInt);
    paramMyHolder = paramMyHolder.a;
    while (paramMyHolder.getChildCount() < localList.size()) {
      paramMyHolder.addView(a(paramMyHolder.getContext()));
    }
    paramInt = 0;
    int i;
    for (;;)
    {
      i = paramInt;
      if (paramInt >= localList.size()) {
        break;
      }
      ChooseItemView.ItemInfo localItemInfo = (ChooseItemView.ItemInfo)localList.get(paramInt);
      View localView = paramMyHolder.getChildAt(paramInt);
      a(localView, localItemInfo);
      localView.setVisibility(0);
      paramInt += 1;
    }
    while (i < paramMyHolder.getChildCount())
    {
      paramMyHolder.getChildAt(i).setVisibility(8);
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.d = paramString;
    }
  }
  
  public void a(@NonNull List<List<ChooseItemView.ItemInfo>> paramList)
  {
    this.a = paramList;
    if (this.c != null)
    {
      paramList = this.a.iterator();
      while (paramList.hasNext())
      {
        Iterator localIterator = ((List)paramList.next()).iterator();
        while (localIterator.hasNext())
        {
          ChooseItemView.ItemInfo localItemInfo = (ChooseItemView.ItemInfo)localIterator.next();
          if (TextUtils.equals(localItemInfo.a, this.c.a))
          {
            localItemInfo.c = true;
            this.c = localItemInfo;
          }
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView.MyRecycleViewAdapter
 * JD-Core Version:    0.7.0.1
 */