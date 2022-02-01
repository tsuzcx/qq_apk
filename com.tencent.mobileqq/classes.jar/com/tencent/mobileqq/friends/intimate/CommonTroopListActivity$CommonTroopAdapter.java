package com.tencent.mobileqq.friends.intimate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class CommonTroopListActivity$CommonTroopAdapter
  extends BaseAdapter
{
  private List<IntimateInfo.CommonTroopInfo> jdField_a_of_type_JavaUtilList;
  
  private CommonTroopListActivity$CommonTroopAdapter(CommonTroopListActivity paramCommonTroopListActivity) {}
  
  public IntimateInfo.CommonTroopInfo a(int paramInt)
  {
    return (IntimateInfo.CommonTroopInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<IntimateInfo.CommonTroopInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity)).inflate(2131559266, null);
    }
    paramView = a(paramInt);
    ImageView localImageView = (ImageView)localView.findViewById(2131365033);
    TextView localTextView = (TextView)localView.findViewById(2131365036);
    localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity), 4, paramView.troopCode));
    localTextView.setText(paramView.troopName);
    localView.setTag(paramView);
    localView.setOnClickListener(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.CommonTroopListActivity.CommonTroopAdapter
 * JD-Core Version:    0.7.0.1
 */