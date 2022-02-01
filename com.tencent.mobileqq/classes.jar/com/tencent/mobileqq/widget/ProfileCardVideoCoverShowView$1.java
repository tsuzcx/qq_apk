package com.tencent.mobileqq.widget;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131561467, null, false);
      paramView.setTag((ImageView)paramView.findViewById(2131368729));
      localObject = new StateListDrawable();
      ((StateListDrawable)localObject).addState(ProfileCardVideoCoverShowView.a(), new ColorDrawable(855638016));
      ((StateListDrawable)localObject).addState(ProfileCardVideoCoverShowView.b(), new ColorDrawable(0));
      paramView.findViewById(2131379736).setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      localObject = (ImageView)paramView.getTag();
      ProfileCardVideoCoverShowView.DataItem localDataItem = a(paramInt);
      if (TextUtils.isEmpty(localDataItem.a))
      {
        ((ImageView)localObject).setImageDrawable(null);
        if (paramInt != 0) {
          break label240;
        }
        paramView.setPadding(AIOUtils.a(12.0F, this.a.getResources()), 0, 0, 0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localURLDrawableOptions.mRequestHeight = AIOUtils.a(178.0F, this.a.getResources());
        localURLDrawableOptions.mRequestWidth = AIOUtils.a(100.0F, this.a.getResources());
        ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(localDataItem.a, localURLDrawableOptions));
        break;
        label240:
        paramView.setPadding(0, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardVideoCoverShowView.1
 * JD-Core Version:    0.7.0.1
 */