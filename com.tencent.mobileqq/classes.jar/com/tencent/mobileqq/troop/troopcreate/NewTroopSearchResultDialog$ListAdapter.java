package com.tencent.mobileqq.troop.troopcreate;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class NewTroopSearchResultDialog$ListAdapter
  extends BaseAdapter
{
  List<ITroopSearchService.SearchResult> jdField_a_of_type_JavaUtilList;
  
  NewTroopSearchResultDialog$ListAdapter(List<ITroopSearchService.SearchResult> paramList)
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
  
  @SuppressLint({"SetTextI18n"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateNewTroopSearchResultDialog.getContext()).inflate(2131560638, null);
      paramView = new NewTroopSearchResultDialog.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateNewTroopSearchResultDialog);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131371697));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368087));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369727));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateNewTroopSearchResultDialog);
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (NewTroopSearchResultDialog.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = (ITroopSearchService.SearchResult)getItem(paramInt);
    paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(((ITroopSearchService.SearchResult)localObject1).a.getTroopDisplayName());
    StringBuilder localStringBuilder;
    if (((ITroopSearchService.SearchResult)localObject1).a.lastMsgTime != 0L)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = paramView.jdField_a_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707578));
      localStringBuilder.append(TimeManager.a().a(((ITroopSearchService.SearchResult)localObject1).a.troopuin, ((ITroopSearchService.SearchResult)localObject1).a.lastMsgTime));
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    else if (((ITroopSearchService.SearchResult)localObject1).a.troopCreateTime != 0L)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = paramView.jdField_a_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707583));
      localStringBuilder.append(TimeManager.a().a(((ITroopSearchService.SearchResult)localObject1).a.troopuin, ((ITroopSearchService.SearchResult)localObject1).a.troopCreateTime));
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    else
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    int i;
    if (((ITroopSearchService.SearchResult)localObject1).a.hasSetTroopHead()) {
      i = 4;
    } else {
      i = 113;
    }
    Object localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateNewTroopSearchResultDialog.a, i, ((ITroopSearchService.SearchResult)localObject1).a.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    paramView.jdField_a_of_type_JavaLangString = ((ITroopSearchService.SearchResult)localObject1).a.troopuin;
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.NewTroopSearchResultDialog.ListAdapter
 * JD-Core Version:    0.7.0.1
 */