package com.tencent.mobileqq.troop.createNewTroop;

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
    Object localObject1 = new SubCateListAdapter.ViewHolder();
    Object localObject2;
    if (paramView != null)
    {
      localObject2 = (SubCateListAdapter.ViewHolder)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    for (;;)
    {
      paramView.a.setText(localTroopCateInfo.b);
      paramView.a.setTag(localTroopCateInfo);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560747, null);
      ((SubCateListAdapter.ViewHolder)localObject1).a = ((TextView)((View)localObject2).findViewById(2131379091));
      ((View)localObject2).setTag(localObject1);
      paramView = (View)localObject1;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.SubCateListAdapter
 * JD-Core Version:    0.7.0.1
 */