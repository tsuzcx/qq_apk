package com.tencent.mobileqq.troop.createNewTroop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class CateListAdapter
  extends BaseAdapter
{
  protected Context a;
  protected LayoutInflater a;
  public NewTroopCateView a;
  protected ArrayList a;
  
  public CateListAdapter(NewTroopCateView paramNewTroopCateView)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramNewTroopCateView.a;
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView = paramNewTroopCateView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
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
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969876, null);
      paramView = new CateListAdapter.ViewHolder(this, localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a((TroopCateListProvider.TroopCateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      return localView;
      paramViewGroup = (CateListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.CateListAdapter
 * JD-Core Version:    0.7.0.1
 */