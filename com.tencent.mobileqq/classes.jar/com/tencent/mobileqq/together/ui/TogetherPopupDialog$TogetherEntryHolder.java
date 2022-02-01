package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.together.TogetherEntryData;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class TogetherPopupDialog$TogetherEntryHolder
{
  TogetherPopupDialog.TogetherEntryItem a = null;
  TogetherPopupDialog.TogetherEntryItem b = null;
  
  void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.a == null) {
      this.a = new TogetherPopupDialog.TogetherEntryItem();
    }
    this.a.a = ((RelativeLayout)paramView.findViewById(2131437120));
    this.a.b = ((RoundRectView)paramView.findViewById(2131437084));
    this.a.c = ((TextView)paramView.findViewById(2131437119));
    this.a.d = ((TextView)paramView.findViewById(2131437130));
    this.a.e = ((RoundRectUrlImageView)paramView.findViewById(2131437116));
    this.a.f = ((RelativeLayout)paramView.findViewById(2131437099));
    this.a.g = new HeadsPanelAnimationView();
    if (this.a.g.a() != null)
    {
      this.a.f.removeAllViews();
      this.a.f.addView(this.a.g.a());
    }
  }
  
  void a(TogetherEntryData paramTogetherEntryData, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    if ((paramTogetherEntryData != null) && (paramOnClickListener != null))
    {
      if (paramContext == null) {
        return;
      }
      this.a.b.setAllRadius(ViewUtils.dpToPx(12.0F));
      this.a.b.setBgColor(paramTogetherEntryData.k);
      this.a.b.setTag(paramTogetherEntryData);
      this.a.b.setOnClickListener(paramOnClickListener);
      if (AppSetting.e) {
        this.a.b.setContentDescription(paramTogetherEntryData.i);
      }
      this.a.c.setText(paramTogetherEntryData.i);
      if (paramTogetherEntryData.n)
      {
        this.a.f.setVisibility(0);
        this.a.g.a(paramTogetherEntryData.p);
      }
      else
      {
        this.a.f.setVisibility(8);
      }
      this.a.d.setText(paramTogetherEntryData.b());
      this.a.e.setAllRadius(ViewUtils.dpToPx(12.0F));
      if (!TextUtils.isEmpty(paramTogetherEntryData.l))
      {
        paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
        paramOnClickListener.mLoadingDrawable = TogetherEntryData.a(paramContext, paramTogetherEntryData);
        paramOnClickListener.mFailedDrawable = TogetherEntryData.a(paramContext, paramTogetherEntryData);
        paramTogetherEntryData = URLDrawable.getDrawable(paramTogetherEntryData.l, paramOnClickListener);
        this.a.e.setImageDrawable(paramTogetherEntryData);
        return;
      }
      this.a.e.setImageResource(paramTogetherEntryData.m);
    }
  }
  
  void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.b == null) {
      this.b = new TogetherPopupDialog.TogetherEntryItem();
    }
    this.b.a = ((RelativeLayout)paramView.findViewById(2131444839));
    this.b.b = ((RoundRectView)paramView.findViewById(2131444801));
    this.b.c = ((TextView)paramView.findViewById(2131444838));
    this.b.d = ((TextView)paramView.findViewById(2131444853));
    this.b.e = ((RoundRectUrlImageView)paramView.findViewById(2131444835));
    this.b.f = ((RelativeLayout)paramView.findViewById(2131444822));
    this.b.g = new HeadsPanelAnimationView();
    if (this.b.g.a() != null)
    {
      this.b.f.removeAllViews();
      this.b.f.addView(this.b.g.a());
    }
  }
  
  void b(TogetherEntryData paramTogetherEntryData, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    if ((paramTogetherEntryData != null) && (paramOnClickListener != null))
    {
      if (paramContext == null) {
        return;
      }
      this.b.b.setAllRadius(ViewUtils.dpToPx(12.0F));
      this.b.b.setBgColor(paramTogetherEntryData.k);
      this.b.b.setTag(paramTogetherEntryData);
      this.b.b.setOnClickListener(paramOnClickListener);
      if (AppSetting.e) {
        this.b.b.setContentDescription(paramTogetherEntryData.i);
      }
      this.b.c.setText(paramTogetherEntryData.i);
      if (paramTogetherEntryData.n)
      {
        this.b.f.setVisibility(0);
        this.b.g.a(paramTogetherEntryData.p);
      }
      else
      {
        this.b.f.setVisibility(8);
      }
      this.b.d.setText(paramTogetherEntryData.b());
      this.b.e.setAllRadius(ViewUtils.dpToPx(12.0F));
      if (!TextUtils.isEmpty(paramTogetherEntryData.l))
      {
        paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
        paramOnClickListener.mLoadingDrawable = TogetherEntryData.a(paramContext, paramTogetherEntryData);
        paramOnClickListener.mFailedDrawable = TogetherEntryData.a(paramContext, paramTogetherEntryData);
        paramTogetherEntryData = URLDrawable.getDrawable(paramTogetherEntryData.l, paramOnClickListener);
        this.b.e.setImageDrawable(paramTogetherEntryData);
        return;
      }
      this.b.e.setImageResource(paramTogetherEntryData.m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.TogetherEntryHolder
 * JD-Core Version:    0.7.0.1
 */