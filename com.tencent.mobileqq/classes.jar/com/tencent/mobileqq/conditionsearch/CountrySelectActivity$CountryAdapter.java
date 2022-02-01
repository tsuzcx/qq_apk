package com.tencent.mobileqq.conditionsearch;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class CountrySelectActivity$CountryAdapter
  extends PinnedDividerListView.DividerAdapter
{
  private CountrySelectActivity$CountryAdapter(CountrySelectActivity paramCountrySelectActivity) {}
  
  public int a()
  {
    return 2131625567;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (TextView)paramView;
    Object localObject = getItem(paramInt);
    if ((localObject instanceof CountrySelectActivity.DividerItem))
    {
      paramView.setText(((CountrySelectActivity.DividerItem)localObject).a);
      return;
    }
    if ((localObject instanceof BaseAddress)) {
      paramView.setText(((BaseAddress)localObject).pinyinFirst);
    }
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 0;
  }
  
  public int getCount()
  {
    return this.a.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a.e.get(paramInt) instanceof CountrySelectActivity.DividerItem)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (getItemViewType(paramInt) == 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = this.a.getLayoutInflater().inflate(a(), null);
      }
      ((TextView)localView).setText(((CountrySelectActivity.DividerItem)getItem(paramInt)).a);
      paramView = localView;
    }
    else
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131625568, null);
        paramView = new CountrySelectActivity.ViewHolder(null);
        paramView.a = ((TextView)localView.findViewById(2131431449));
        paramView.b = ((ImageView)localView.findViewById(2131430679));
        localView.findViewById(2131431448).setVisibility(8);
        localView.setTag(paramView);
        localView.setOnClickListener(this.a);
      }
      CountrySelectActivity.ViewHolder localViewHolder = (CountrySelectActivity.ViewHolder)localView.getTag();
      BaseAddress localBaseAddress = (BaseAddress)getItem(paramInt);
      localViewHolder.a.setText(localBaseAddress.name);
      if ((!TextUtils.isEmpty(this.a.g)) && (this.a.g.equals(localBaseAddress.code))) {
        localViewHolder.b.setVisibility(0);
      } else {
        localViewHolder.b.setVisibility(8);
      }
      localViewHolder.c = localBaseAddress.code;
      paramView = localView;
      if (CountrySelectActivity.a) {
        if (localViewHolder.b.getVisibility() == 0)
        {
          paramView = new StringBuilder();
          paramView.append(localBaseAddress.name);
          paramView.append(HardCodeUtil.a(2131900771));
          localView.setContentDescription(paramView.toString());
          paramView = localView;
        }
        else
        {
          localView.setContentDescription(localBaseAddress.name);
          paramView = localView;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.CountrySelectActivity.CountryAdapter
 * JD-Core Version:    0.7.0.1
 */