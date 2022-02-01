package com.tencent.mobileqq.mini.widget;

import NS_COMM.COMM.Entry;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;

class AuthDetailDialog$DetailAdapter
  extends BaseAdapter
{
  ArrayList<COMM.Entry> detailList = new ArrayList();
  
  AuthDetailDialog$DetailAdapter(AuthDetailDialog paramAuthDetailDialog) {}
  
  public int getCount()
  {
    ArrayList localArrayList = this.detailList;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.detailList.size())) {
      return this.detailList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    COMM.Entry localEntry = (COMM.Entry)getItem(paramInt);
    paramViewGroup = paramView;
    if (localEntry != null)
    {
      if (paramView != null)
      {
        paramViewGroup = (AuthDetailDialog.DetailAdapter.DetailViewHolder)paramView.getTag();
      }
      else
      {
        paramView = LayoutInflater.from(AuthDetailDialog.access$000(this.this$0)).inflate(2131625337, null);
        paramViewGroup = new AuthDetailDialog.DetailAdapter.DetailViewHolder(this, paramView);
        paramView.setTag(paramViewGroup);
      }
      paramViewGroup.tvTitle.setText(localEntry.key.get());
      paramViewGroup.tvDesc.setText(localEntry.value.get());
      paramViewGroup = paramView;
    }
    return paramViewGroup;
  }
  
  public void setData(ArrayList<COMM.Entry> paramArrayList)
  {
    this.detailList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDetailDialog.DetailAdapter
 * JD-Core Version:    0.7.0.1
 */