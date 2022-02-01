package com.tencent.mobileqq.richstatus;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ActionListActivity$GridAdapter
  extends BaseAdapter
{
  private ArrayList<Integer> b;
  
  public ActionListActivity$GridAdapter(ArrayList<Integer> paramArrayList)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
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
      localView = this.a.getLayoutInflater().inflate(2131629327, paramViewGroup, false);
      paramView = new ActionListActivity.ActionViewHolder(null);
      paramView.a = ((ImageView)localView.findViewById(2131446519));
      paramView.b = ((TextView)localView.findViewById(2131446520));
      localView.setTag(paramView);
    }
    paramView = (ActionListActivity.ActionViewHolder)localView.getTag();
    ActionInfo localActionInfo = ActionListActivity.a(this.a).a(((Integer)this.b.get(paramInt)).intValue());
    if ((localActionInfo != null) && (paramView.c != localActionInfo.b))
    {
      paramView.c = localActionInfo.b;
      paramView.a.setImageDrawable(new StatableBitmapDrawable(this.a.getResources(), ActionListActivity.a(this.a).a(localActionInfo.b, 201), false, false));
      paramView.b.setText(localActionInfo.e);
      if (localActionInfo.g == 1)
      {
        paramView.b.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.b.setCompoundDrawablesWithIntrinsicBounds(null, null, this.a.getResources().getDrawable(2130839446), null);
        paramView.b.setCompoundDrawablePadding(10);
      }
    }
    localView.setOnClickListener(this.a);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity.GridAdapter
 * JD-Core Version:    0.7.0.1
 */