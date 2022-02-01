package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;

class TroopBarPublishLocationSelectActivity$LocationAdapter
  extends XBaseAdapter
{
  protected LayoutInflater a;
  protected boolean a;
  
  public TroopBarPublishLocationSelectActivity$LocationAdapter(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity, Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562209, null);
      paramView = new TroopBarPublishLocationSelectActivity.LocationAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369910));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377179));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369898));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369893));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (TroopBarPublishLocationSelectActivity.LocationAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (TroopBarPOI)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.get(paramInt);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopBarPOI)localObject).c);
    ImageView localImageView = paramView.jdField_b_of_type_AndroidWidgetImageView;
    int i;
    if (((TroopBarPOI)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.c)) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    if (!TextUtils.isEmpty(((TroopBarPOI)localObject).d))
    {
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((TroopBarPOI)localObject).d);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramInt == 0) {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    } else {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Boolean) {
      localView.setBackgroundResource(17170445);
    } else {
      localView.setBackgroundResource(2130848606);
    }
    localView.setContentDescription(((TroopBarPOI)localObject).c);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.LocationAdapter
 * JD-Core Version:    0.7.0.1
 */