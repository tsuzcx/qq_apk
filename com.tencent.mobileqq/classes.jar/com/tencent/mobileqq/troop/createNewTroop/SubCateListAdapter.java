package com.tencent.mobileqq.troop.createNewTroop;

import ajbu;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class SubCateListAdapter
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected TroopCateListProvider.TroopCateInfo a;
  protected ArrayList a;
  
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
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider$TroopCateInfo = paramTroopCateInfo;
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
    ajbu localajbu = new ajbu();
    if (paramView != null)
    {
      localajbu = (ajbu)paramView.getTag();
      paramViewGroup = paramView;
    }
    for (paramView = localajbu;; paramView = localajbu)
    {
      paramView.a.setText(localTroopCateInfo.b);
      paramView.a.setTag(localTroopCateInfo);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969878, null);
      localajbu.a = ((TextView)paramViewGroup.findViewById(2131363632));
      paramViewGroup.setTag(localajbu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.SubCateListAdapter
 * JD-Core Version:    0.7.0.1
 */