package com.tencent.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class NegativeChildrenLayout
  extends LinearLayout
{
  LinearLayout a;
  View b;
  Context c;
  KandianNegativeWindow.iClickInterface d;
  ArrayList<View> e = new ArrayList();
  int f;
  View.OnClickListener g = new NegativeChildrenLayout.1(this);
  
  public NegativeChildrenLayout(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    a(paramContext);
  }
  
  public NegativeChildrenLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131626292, this);
    this.a = ((LinearLayout)paramContext.findViewById(2131437913));
    this.b = paramContext.findViewById(2131433199);
    paramContext = this.b.findViewById(2131445643);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    paramContext.setLayoutParams(localLayoutParams);
    this.b.setBackgroundResource(0);
  }
  
  private void a(View paramView, DislikeInfo paramDislikeInfo)
  {
    if (paramView == null) {
      return;
    }
    if ((paramDislikeInfo != null) && (!TextUtils.isEmpty(paramDislikeInfo.c)))
    {
      paramView.setVisibility(0);
      paramView.setTag(paramDislikeInfo);
      a(paramView, paramDislikeInfo, "", false);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a(View paramView, DislikeInfo paramDislikeInfo, String paramString, boolean paramBoolean)
  {
    String str = "";
    try
    {
      localImageView = (ImageView)paramView.findViewById(2131437082);
      localTextView1 = (TextView)paramView.findViewById(2131447769);
      localTextView2 = (TextView)paramView.findViewById(2131436073);
      int j = 8;
      if (paramBoolean)
      {
        i = 0;
        break label170;
      }
      i = j;
      if (paramDislikeInfo == null) {
        break label170;
      }
      i = j;
      if (TextUtils.isEmpty(paramDislikeInfo.c)) {
        break label170;
      }
      paramView = paramDislikeInfo.c;
      i = j;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ImageView localImageView;
        TextView localTextView1;
        TextView localTextView2;
        int i;
        continue;
        paramView = "";
      }
    }
    localTextView2.setText(paramView);
    localImageView.setVisibility(i);
    if (paramString != null) {
      localTextView1.setText(paramString);
    }
    paramView = str;
    if (paramDislikeInfo != null) {
      paramView = paramDislikeInfo.toString();
    }
    paramDislikeInfo = new StringBuilder();
    paramDislikeInfo.append("updateItemData:");
    paramDislikeInfo.append(paramView);
    paramDislikeInfo.append(" ,name:");
    paramDislikeInfo.append(paramString);
    QLog.e("NegativeChildrenLayout", 1, paramDislikeInfo.toString());
  }
  
  public void a(DislikeInfo paramDislikeInfo)
  {
    if (this.e.size() > 6) {
      return;
    }
    if (paramDislikeInfo != null)
    {
      if (TextUtils.isEmpty(paramDislikeInfo.c)) {
        return;
      }
      View localView = LayoutInflater.from(this.c).inflate(2131626293, this.a, false);
      this.a.addView(localView);
      localView.setOnClickListener(this.g);
      localView.setTag(paramDislikeInfo);
      this.e.add(localView);
    }
  }
  
  public void setData(ArrayList<DislikeInfo> paramArrayList, String paramString, KandianNegativeWindow.iClickInterface paramiClickInterface)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = 0;
    setVisibility(0);
    this.f = 0;
    a(this.b, null, paramString, true);
    while ((i < paramArrayList.size()) && (i < 6))
    {
      if (i > this.e.size() - 1) {
        a((DislikeInfo)paramArrayList.get(i));
      }
      if (i < this.e.size())
      {
        a((View)this.e.get(i), (DislikeInfo)paramArrayList.get(i));
        this.f = i;
      }
      i += 1;
    }
    setLastSeparateLineUnvis();
    i = this.f + 1;
    while (i < this.e.size())
    {
      a((View)this.e.get(i), null);
      i += 1;
    }
    this.d = paramiClickInterface;
  }
  
  public void setLastSeparateLineUnvis()
  {
    int i = 0;
    while (i < this.e.size())
    {
      View localView1 = (View)this.e.get(i);
      View localView2 = localView1.findViewById(2131445643);
      int j;
      if (i == this.f)
      {
        j = 4;
        localView1.setBackgroundResource(2130844017);
      }
      else
      {
        j = 0;
      }
      if (localView2 != null) {
        localView2.setVisibility(j);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.NegativeChildrenLayout
 * JD-Core Version:    0.7.0.1
 */