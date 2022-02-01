package com.tencent.mobileqq.extendfriend.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.subscribe.widget.ShadowCardView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.recent.gamemsgbox.RoundCornerImageView;
import com.tencent.mobileqq.qqexpand.bean.entrance.EntranceInfo;
import com.tencent.mobileqq.utils.ViewUtils;

class ExtendFriendContactEntranceContainer$ExtendEntranceListAdapter$Holder
{
  private Context b;
  private View c;
  private RoundCornerImageView d;
  private View e;
  private View f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private ShadowCardView j;
  private ClickableFrameLayout k;
  
  public ExtendFriendContactEntranceContainer$ExtendEntranceListAdapter$Holder(ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter paramExtendEntranceListAdapter, View paramView, Context paramContext)
  {
    this.b = paramContext;
    this.c = paramView;
    this.d = ((RoundCornerImageView)paramView.findViewById(2131429234));
    this.e = paramView.findViewById(2131429239);
    this.f = paramView.findViewById(2131430778);
    this.g = ((ImageView)paramView.findViewById(2131435219));
    this.h = ((TextView)paramView.findViewById(2131447463));
    this.i = ((TextView)paramView.findViewById(2131446515));
    this.j = ((ShadowCardView)paramView.findViewById(2131430316));
    this.k = ((ClickableFrameLayout)paramView.findViewById(2131430330));
  }
  
  public void a(@NonNull EntranceInfo paramEntranceInfo, boolean paramBoolean)
  {
    this.f.setOnClickListener(new ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder.1(this, paramEntranceInfo));
    Object localObject;
    if (!paramBoolean)
    {
      this.j.setShadowCardColor(-1);
      this.j.setShadowBlur(ViewUtils.dpToPx(10.0F));
      this.k.setBackground(this.a.a.getResources().getDrawable(2130846564));
      if (!TextUtils.isEmpty(paramEntranceInfo.e))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.a.getResources().getDrawable(2130846565);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.a.getResources().getDrawable(2130846565);
        localObject = URLDrawable.getDrawable(paramEntranceInfo.e, (URLDrawable.URLDrawableOptions)localObject);
        this.d.setImageDrawable((Drawable)localObject);
        this.d.setVisibility(0);
        this.k.setOnDispatchListener(new ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder.2(this));
      }
      this.g.setAlpha(1.0F);
      this.i.setTextColor(Color.parseColor("#B2B2B2"));
    }
    else
    {
      this.j.setShadowCardColor(Color.parseColor("#1A1A1A"));
      this.j.setShadowBlur(0);
      this.k.setBackground(this.a.a.getResources().getDrawable(2130846563));
      this.k.setOnDispatchListener(new ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder.3(this));
      this.d.setVisibility(8);
      this.g.setAlpha(0.8F);
      this.i.setTextColor(Color.parseColor("#666666"));
    }
    if (!TextUtils.isEmpty(paramEntranceInfo.d))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.a.getResources().getDrawable(2130846565);
      localObject = URLDrawable.getDrawable(paramEntranceInfo.d, (URLDrawable.URLDrawableOptions)localObject);
      this.g.setImageDrawable((Drawable)localObject);
    }
    this.h.setText(paramEntranceInfo.b);
    this.i.setText(paramEntranceInfo.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder
 * JD-Core Version:    0.7.0.1
 */