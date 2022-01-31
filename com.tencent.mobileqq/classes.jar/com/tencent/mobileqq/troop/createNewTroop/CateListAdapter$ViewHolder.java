package com.tencent.mobileqq.troop.createNewTroop;

import ajfz;
import ajga;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class CateListAdapter$ViewHolder
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajfz(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public CateListAdapter a;
  SubCateListView.OnToggleSubListListener jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener = new ajga(this);
  TroopCateListProvider.TroopCateInfo jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider$TroopCateInfo;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  ArrayList b;
  
  public CateListAdapter$ViewHolder(CateListAdapter paramCateListAdapter, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter = paramCateListAdapter;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368342));
    this.b = new ArrayList();
    CateListAdapter.SingleItemViewHolder localSingleItemViewHolder = new CateListAdapter.SingleItemViewHolder(paramView.findViewById(2131368343), 0);
    this.b.add(localSingleItemViewHolder);
    localSingleItemViewHolder = new CateListAdapter.SingleItemViewHolder(paramView.findViewById(2131368344), 1);
    this.b.add(localSingleItemViewHolder);
    localSingleItemViewHolder = new CateListAdapter.SingleItemViewHolder(paramView.findViewById(2131368346), 2);
    this.b.add(localSingleItemViewHolder);
    paramView = new CateListAdapter.SingleItemViewHolder(paramView.findViewById(2131368347), 3);
    this.b.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new SubCateListView((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131368345), paramCateListAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    paramCateListAdapter = new SubCateListView((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131368348), paramCateListAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCateListAdapter);
  }
  
  public void a(TroopCateListProvider.TroopCateInfo paramTroopCateInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((SubCateListView)localIterator.next()).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider$TroopCateInfo = paramTroopCateInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopCateInfo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramTroopCateInfo.jdField_b_of_type_JavaLangString);
    int i = 0;
    while (i < paramTroopCateInfo.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((CateListAdapter.SingleItemViewHolder)this.b.get(i)).a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_AndroidContentContext, (TroopCateListProvider.TroopCateInfo)paramTroopCateInfo.jdField_a_of_type_JavaUtilArrayList.get(i), this);
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = (CateListAdapter.SingleItemViewHolder)paramView.getTag();
    if (paramView == null) {
      return;
    }
    TroopCateListProvider.TroopCateInfo localTroopCateInfo = (TroopCateListProvider.TroopCateInfo)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider$TroopCateInfo.jdField_a_of_type_JavaUtilArrayList.get(paramView.a);
    if (localTroopCateInfo.jdField_a_of_type_Boolean)
    {
      int i = paramView.a / 2;
      ((SubCateListView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramView, localTroopCateInfo);
      return;
    }
    if (localTroopCateInfo.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localTroopCateInfo.jdField_a_of_type_JavaLangString, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localTroopCateInfo.d, localTroopCateInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.CateListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */