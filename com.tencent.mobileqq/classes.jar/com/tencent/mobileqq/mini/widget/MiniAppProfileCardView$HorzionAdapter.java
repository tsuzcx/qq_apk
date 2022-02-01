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
    ArrayList localArrayList = this.miniAppInfoItems;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.miniAppInfoItems;
    if (localArrayList != null) {
      return localArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.miniAppInfoItems;
    Object localObject = paramView;
    if (paramViewGroup != null)
    {
      if (paramViewGroup.size() < 1) {
        return paramView;
      }
      localObject = (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = new MiniAppProfileCardItemView(MiniAppProfileCardView.access$000(this.this$0), null);
      }
      paramView = (MiniAppProfileCardItemView)paramViewGroup;
      paramView.setData((MiniAppInfo)localObject, paramInt);
      localObject = paramViewGroup;
      if (MiniAppProfileCardView.access$100(this.this$0))
      {
        if (MiniAppProfileCardView.access$200(this.this$0) != null)
        {
          paramView.setTextColor(MiniAppProfileCardView.access$200(this.this$0));
          return paramViewGroup;
        }
        paramView.setTextColor(MiniAppProfileCardView.access$300(this.this$0));
        localObject = paramViewGroup;
      }
    }
    return localObject;
  }
  
  public void setData(ArrayList<MiniAppInfo> paramArrayList)
  {
    this.miniAppInfoItems = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardView.HorzionAdapter
 * JD-Core Version:    0.7.0.1
 */