package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ThemeDiyBgAdapter
  extends BaseAdapter
{
  static String TAG = "ThemeDiyBgAdapter";
  boolean isDIYThemeBefore;
  protected Context mContext;
  ArrayList mData = new ArrayList();
  LayoutInflater mInflater;
  int mResType;
  ThemeDIYData themeDIYData;
  ResSuitData tryOnStyleRSD;
  ResSuitData usedStyleRSD;
  
  public ThemeDiyBgAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mData == null) || (paramInt < 0) || (paramInt >= this.mData.size())) {
      return null;
    }
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.mInflater.inflate(2130971055, paramViewGroup, false);
    }
    for (;;)
    {
      ItemView localItemView = (ItemView)paramView;
      paramViewGroup = getItem(paramInt);
      if (localItemView == null)
      {
        QLog.e(TAG, 1, "getVie error itemView null");
        return paramView;
      }
      if (paramViewGroup == null)
      {
        QLog.e(TAG, 1, "getVie error obj null");
        return paramView;
      }
      if ((paramViewGroup instanceof ResSuitData.BgSuit))
      {
        ResSuitData localResSuitData1 = (ResSuitData)paramViewGroup;
        ResSuitData localResSuitData2 = this.themeDIYData.tryOnBgRSD;
        if (this.isDIYThemeBefore) {}
        for (paramViewGroup = this.themeDIYData.usedBgRSD;; paramViewGroup = null)
        {
          localItemView.init(localResSuitData1, localResSuitData2, paramViewGroup, false);
          return paramView;
        }
      }
      localItemView.init((ResSuitData)paramViewGroup, this.tryOnStyleRSD, this.usedStyleRSD, false);
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyBgAdapter
 * JD-Core Version:    0.7.0.1
 */