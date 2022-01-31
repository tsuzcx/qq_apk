package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
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
    if ((this.miniAppInfoItems == null) || (this.miniAppInfoItems.size() < 1))
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    paramViewGroup = (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
    if (paramView == null) {
      paramView = new MiniAppProfileCardItemView(MiniAppProfileCardView.access$000(this.this$0), null);
    }
    for (;;)
    {
      ((MiniAppProfileCardItemView)paramView).setData(paramViewGroup, paramInt);
      paramViewGroup = paramView;
      if (!MiniAppProfileCardView.access$100(this.this$0)) {
        break;
      }
      if (MiniAppProfileCardView.access$200(this.this$0) != null)
      {
        ((MiniAppProfileCardItemView)paramView).setTextColor(MiniAppProfileCardView.access$200(this.this$0));
        return paramView;
      }
      ((MiniAppProfileCardItemView)paramView).setTextColor(MiniAppProfileCardView.access$300(this.this$0));
      return paramView;
    }
  }
  
  public void setData(ArrayList<MiniAppInfo> paramArrayList)
  {
    this.miniAppInfoItems = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardView.HorzionAdapter
 * JD-Core Version:    0.7.0.1
 */