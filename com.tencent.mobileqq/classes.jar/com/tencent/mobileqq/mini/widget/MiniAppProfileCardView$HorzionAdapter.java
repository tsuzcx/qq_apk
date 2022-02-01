package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class MiniAppProfileCardView$HorzionAdapter
  extends BaseAdapter
{
  private ArrayList<MiniAppInfo> miniAppInfoItems;
  
  MiniAppProfileCardView$HorzionAdapter(MiniAppProfileCardView paramMiniAppProfileCardView) {}
  
  public int getCount()
  {
    if (this.miniAppInfoItems != null) {
      return this.miniAppInfoItems.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.miniAppInfoItems != null) {
      return (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((this.miniAppInfoItems == null) || (this.miniAppInfoItems.size() < 1))
    {
      localObject = paramView;
      localView = paramView;
      paramView = (View)localObject;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    Object localObject = (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
    if (paramView == null) {
      paramView = new MiniAppProfileCardItemView(MiniAppProfileCardView.access$000(this.this$0), null);
    }
    for (;;)
    {
      ((MiniAppProfileCardItemView)paramView).setData((MiniAppInfo)localObject, paramInt);
      if (MiniAppProfileCardView.access$100(this.this$0))
      {
        if (MiniAppProfileCardView.access$200(this.this$0) == null) {
          break label127;
        }
        ((MiniAppProfileCardItemView)paramView).setTextColor(MiniAppProfileCardView.access$200(this.this$0));
      }
      for (;;)
      {
        localView = paramView;
        break;
        label127:
        ((MiniAppProfileCardItemView)paramView).setTextColor(MiniAppProfileCardView.access$300(this.this$0));
      }
    }
  }
  
  public void setData(ArrayList<MiniAppInfo> paramArrayList)
  {
    this.miniAppInfoItems = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardView.HorzionAdapter
 * JD-Core Version:    0.7.0.1
 */