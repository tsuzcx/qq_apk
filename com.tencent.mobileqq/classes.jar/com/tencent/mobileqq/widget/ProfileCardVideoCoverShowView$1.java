package com.tencent.mobileqq.widget;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ProfileCardVideoCoverShowView$1
  extends BaseAdapter
{
  ProfileCardVideoCoverShowView$1(ProfileCardVideoCoverShowView paramProfileCardVideoCoverShowView) {}
  
  public ProfileCardVideoCoverShowView.DataItem a(int paramInt)
  {
    return (ProfileCardVideoCoverShowView.DataItem)ProfileCardVideoCoverShowView.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return ProfileCardVideoCoverShowView.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131561311, null, false);
      localView.setTag((ImageView)localView.findViewById(2131368461));
      paramView = new StateListDrawable();
      paramView.addState(ProfileCardVideoCoverShowView.a(), new ColorDrawable(855638016));
      paramView.addState(ProfileCardVideoCoverShowView.b(), new ColorDrawable(0));
      localView.findViewById(2131379074).setBackgroundDrawable(paramView);
    }
    paramView = (ImageView)localView.getTag();
    ProfileCardVideoCoverShowView.DataItem localDataItem = a(paramInt);
    if (TextUtils.isEmpty(localDataItem.a))
    {
      paramView.setImageDrawable(null);
    }
    else
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mRequestHeight = AIOUtils.b(178.0F, this.a.getResources());
      localURLDrawableOptions.mRequestWidth = AIOUtils.b(100.0F, this.a.getResources());
      paramView.setImageDrawable(URLDrawable.getDrawable(localDataItem.a, localURLDrawableOptions));
    }
    if (paramInt == 0) {
      localView.setPadding(AIOUtils.b(12.0F, this.a.getResources()), 0, 0, 0);
    } else {
      localView.setPadding(0, 0, 0, 0);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardVideoCoverShowView.1
 * JD-Core Version:    0.7.0.1
 */