package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class SubCateListAdapter
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected TroopCateListProvider.TroopCateInfo a;
  protected ArrayList<TroopCateListProvider.TroopCateInfo> a;
  
  public SubCateListAdapter(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(TroopCateListProvider.TroopCateInfo paramTroopCateInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider$TroopCateInfo = paramTroopCateInfo;
    this.jdField_a_of_type_JavaUtilArrayList = paramTroopCateInfo.jdField_a_of_type_JavaUtilArrayList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopCateListProvider.TroopCateInfo localTroopCateInfo = (TroopCateListProvider.TroopCateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    SubCateListAdapter.ViewHolder localViewHolder = new SubCateListAdapter.ViewHolder();
    if (paramView != null)
    {
      localViewHolder = (SubCateListAdapter.ViewHolder)paramView.getTag();
    }
    else
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560635, null);
      localViewHolder.a = ((TextView)paramView.findViewById(2131378460));
      paramView.setTag(localViewHolder);
    }
    localViewHolder.a.setText(localTroopCateInfo.b);
    localViewHolder.a.setTag(localTroopCateInfo);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      localViewHolder.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SubCateListAdapter
 * JD-Core Version:    0.7.0.1
 */