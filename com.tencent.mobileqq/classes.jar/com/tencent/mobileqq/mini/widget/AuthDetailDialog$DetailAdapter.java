package com.tencent.mobileqq.mini.widget;

import NS_COMM.COMM.Entry;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class AuthDetailDialog$DetailAdapter
  extends BaseAdapter
{
  ArrayList<COMM.Entry> detailList = new ArrayList();
  
  AuthDetailDialog$DetailAdapter(AuthDetailDialog paramAuthDetailDialog) {}
  
  public int getCount()
  {
    if (this.detailList != null) {
      return this.detailList.size();
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
    Object localObject = paramView;
    if (localEntry != null)
    {
      if (paramView == null) {
        break label84;
      }
      localObject = (AuthDetailDialog.DetailAdapter.DetailViewHolder)paramView.getTag();
    }
    for (;;)
    {
      ((AuthDetailDialog.DetailAdapter.DetailViewHolder)localObject).tvTitle.setText(localEntry.key.get());
      ((AuthDetailDialog.DetailAdapter.DetailViewHolder)localObject).tvDesc.setText(localEntry.value.get());
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      label84:
      paramView = LayoutInflater.from(AuthDetailDialog.access$000(this.this$0)).inflate(2131559381, null);
      localObject = new AuthDetailDialog.DetailAdapter.DetailViewHolder(this, paramView);
      paramView.setTag(localObject);
    }
  }
  
  public void setData(ArrayList<COMM.Entry> paramArrayList)
  {
    this.detailList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDetailDialog.DetailAdapter
 * JD-Core Version:    0.7.0.1
 */