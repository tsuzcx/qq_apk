package com.tencent.mobileqq.extendfriend.widget;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.qqexpand.bean.entrance.EntranceInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ExtendFriendContactEntranceContainer$ExtendEntranceListAdapter
  extends BaseAdapter
{
  private ExtendFriendContactEntranceContainer$ExtendEntranceListAdapter(ExtendFriendContactEntranceContainer paramExtendFriendContactEntranceContainer) {}
  
  private View a(int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(ExtendFriendContactEntranceContainer.b(this.a));
    if (paramInt == 1) {
      return localLayoutInflater.inflate(2131627417, null);
    }
    if (paramInt == 2) {
      return localLayoutInflater.inflate(2131627418, null);
    }
    if (paramInt == 3) {
      return localLayoutInflater.inflate(2131627419, null);
    }
    return localLayoutInflater.inflate(2131627420, null);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 1) {
      return;
    }
    Object localObject = this.a.getResources().getDisplayMetrics();
    int i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    paramView = paramView.findViewById(2131430316);
    int j = ViewUtils.dpToPx(7.0F);
    int k = ViewUtils.dpToPx(16.0F);
    int m = ViewUtils.dpToPx(0.0F);
    int n = ViewUtils.dpToPx(7.0F);
    int i1 = m + n;
    int i2 = paramInt1 - 1;
    int i3 = (i - k * 2 - i2 * j) / paramInt1;
    if (paramInt1 == 3) {}
    for (i = ViewUtils.dpToPx(109.5F);; i = ViewUtils.dpToPx(94.0F))
    {
      i += i1;
      break label136;
      if (paramInt1 < 4) {
        break;
      }
    }
    i = 0;
    label136:
    localObject = new FrameLayout.LayoutParams(Math.max(i3 + i1, i), -2);
    if (paramInt1 == 1)
    {
      ((FrameLayout.LayoutParams)localObject).leftMargin = (k - m);
      ((FrameLayout.LayoutParams)localObject).rightMargin = (k - n);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if (paramInt2 == 0)
    {
      ((FrameLayout.LayoutParams)localObject).leftMargin = (k - m);
      ((FrameLayout.LayoutParams)localObject).rightMargin = (j - i1);
    }
    else if (paramInt2 < i2)
    {
      ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
      ((FrameLayout.LayoutParams)localObject).rightMargin = (j - i1);
    }
    else if (paramInt2 == i2)
    {
      ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
      ((FrameLayout.LayoutParams)localObject).rightMargin = (k - n);
    }
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public int getCount()
  {
    if (ExtendFriendContactEntranceContainer.e(this.a) == null) {
      return 0;
    }
    return ExtendFriendContactEntranceContainer.e(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (ExtendFriendContactEntranceContainer.e(this.a) == null) {
      return null;
    }
    return ExtendFriendContactEntranceContainer.e(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getCount();
    Object localObject1;
    if (i == 0)
    {
      Object localObject2 = null;
      localObject1 = paramView;
      paramView = localObject2;
    }
    else
    {
      if (paramView == null)
      {
        paramView = a(i);
        localObject1 = new ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder(this, paramView, ExtendFriendContactEntranceContainer.b(this.a));
        paramView.setTag(localObject1);
      }
      else
      {
        localObject1 = (ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder)paramView.getTag();
      }
      ((ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter.Holder)localObject1).a((EntranceInfo)getItem(paramInt), ExtendFriendContactEntranceContainer.f(this.a));
      a(paramView, i, paramInt);
      localObject1 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter
 * JD-Core Version:    0.7.0.1
 */