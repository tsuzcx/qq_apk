package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.feeds.CityData;
import java.util.ArrayList;
import java.util.List;

public class SelectCityAdapter
  extends BaseAdapter
{
  private ArrayList<CityData> a = new ArrayList();
  private Context b;
  
  public SelectCityAdapter(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void a(int paramInt, SelectCityAdapter.ViewHolder paramViewHolder)
  {
    String str;
    if (((CityData)this.a.get(paramInt)).a == 2) {
      str = ((CityData)this.a.get(paramInt)).c;
    } else if (((CityData)this.a.get(paramInt)).a == 1) {
      str = ((CityData)this.a.get(paramInt)).b;
    } else {
      str = "";
    }
    paramViewHolder.a.setText(str);
  }
  
  public void a(List<CityData> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && (((SelectCityAdapter.ViewHolder)paramView.getTag()).b == ((CityData)this.a.get(paramInt)).a))
    {
      paramViewGroup = (SelectCityAdapter.ViewHolder)paramView.getTag();
    }
    else
    {
      SelectCityAdapter.ViewHolder localViewHolder = new SelectCityAdapter.ViewHolder(this, null);
      localViewHolder.b = ((CityData)this.a.get(paramInt)).a;
      if (((CityData)this.a.get(paramInt)).a == 2)
      {
        paramView = LayoutInflater.from(this.b).inflate(2131626322, paramViewGroup, false);
        localViewHolder.a = ((TextView)paramView.findViewById(2131430734));
      }
      else
      {
        paramView = LayoutInflater.from(this.b).inflate(2131626325, paramViewGroup, false);
        localViewHolder.a = ((TextView)paramView.findViewById(2131435672));
      }
      paramView.setTag(localViewHolder);
      paramViewGroup = localViewHolder;
    }
    a(paramInt, paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.SelectCityAdapter
 * JD-Core Version:    0.7.0.1
 */