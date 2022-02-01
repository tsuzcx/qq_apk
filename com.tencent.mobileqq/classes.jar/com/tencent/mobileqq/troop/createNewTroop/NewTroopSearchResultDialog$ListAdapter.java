package com.tencent.mobileqq.troop.createNewTroop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.SearchResult;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class NewTroopSearchResultDialog$ListAdapter
  extends BaseAdapter
{
  List<TroopSearchLogic.SearchResult> jdField_a_of_type_JavaUtilList;
  
  NewTroopSearchResultDialog$ListAdapter(List<TroopSearchLogic.SearchResult> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NewTroopSearchResultDialog.ViewHolder localViewHolder;
    TroopSearchLogic.SearchResult localSearchResult;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopSearchResultDialog.getContext()).inflate(2131560750, null);
      localViewHolder = new NewTroopSearchResultDialog.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopSearchResultDialog);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131372115));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368336));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370043));
      localViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370380);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopSearchResultDialog);
      paramView.setTag(localViewHolder);
      localSearchResult = (TroopSearchLogic.SearchResult)getItem(paramInt);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localSearchResult.a.getTroopDisplayName());
      if (localSearchResult.a.lastMsgTime == 0L) {
        break label298;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707553) + TimeManager.a().a(localSearchResult.a.troopuin, localSearchResult.a.lastMsgTime));
      label200:
      if (!localSearchResult.a.hasSetTroopHead()) {
        break label387;
      }
    }
    label387:
    for (int i = 4;; i = 113)
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopSearchResultDialog.a, i, localSearchResult.a.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      localViewHolder.jdField_a_of_type_JavaLangString = localSearchResult.a.troopuin;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localViewHolder = (NewTroopSearchResultDialog.ViewHolder)paramView.getTag();
      break;
      label298:
      if (localSearchResult.a.troopCreateTime != 0L)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707558) + TimeManager.a().a(localSearchResult.a.troopuin, localSearchResult.a.troopCreateTime));
        break label200;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label200;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopSearchResultDialog.ListAdapter
 * JD-Core Version:    0.7.0.1
 */