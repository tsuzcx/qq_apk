package com.tencent.mobileqq.kandian.biz.message.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class ReadinjoySubscriptManagerActivity$SubscribeAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private List<ReadinjoySubscriptManagerActivity.SubscribeFeedData> jdField_a_of_type_JavaUtilList;
  
  private ReadinjoySubscriptManagerActivity$SubscribeAdapter(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(ReadinjoySubscriptManagerActivity.SubscribeHolder paramSubscribeHolder, int paramInt, View paramView)
  {
    ReadinjoySubscriptManagerActivity.SubscribeFeedData localSubscribeFeedData = (ReadinjoySubscriptManagerActivity.SubscribeFeedData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).setText(ReadinjoySubscriptManagerActivity.SubscribeFeedData.b(localSubscribeFeedData));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).setImageDrawable(ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity).a(1008, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(localSubscribeFeedData)));
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity)) {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
    } else {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298858);
    }
    localObject = ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder);
    int i;
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity)) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).setOnClickListener(new ReadinjoySubscriptManagerActivity.SubscribeAdapter.1(this, paramView));
    if (paramInt == getCount() - 1) {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramSubscribeHolder).setVisibility(8);
    } else {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramSubscribeHolder).setVisibility(0);
    }
    ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).setOnClickListener(new ReadinjoySubscriptManagerActivity.SubscribeAdapter.2(this, localSubscribeFeedData));
    ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(localSubscribeFeedData));
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity)) {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramSubscribeHolder).setBackgroundResource(2131166928);
    } else {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramSubscribeHolder).setBackgroundResource(2130841773);
    }
    ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramSubscribeHolder).setPressed(false);
  }
  
  public void a(List<ReadinjoySubscriptManagerActivity.SubscribeFeedData> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ReadinjoySubscriptManagerActivity.SubscribeHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity, null);
      View localView = this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity.getLayoutInflater().inflate(2131560291, paramViewGroup, false);
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, localView.findViewById(2131365132));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramView, localView.findViewById(2131365474));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (ImageView)localView.findViewById(2131378072));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (TextView)localView.findViewById(2131378078));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (Button)localView.findViewById(2131380169));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramView, localView.findViewById(2131365759));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298859)));
      paramViewGroup = paramView;
      paramView = localView;
    }
    else
    {
      paramViewGroup = (ReadinjoySubscriptManagerActivity.SubscribeHolder)paramView.getTag();
    }
    a(paramViewGroup, paramInt, paramView);
    return paramView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ReadinjoySubscriptManagerActivity.SubscribeFeedData)getItem((int)paramLong);
    if (paramAdapterView != null)
    {
      if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity)) {
        return;
      }
      paramView = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageActivityReadinjoySubscriptManagerActivity, "/pubaccount/detail");
      paramView.extra().putString("uin", ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(paramAdapterView));
      paramView.extra().putString("report_src_param_type", "");
      paramView.extra().putString("report_src_param_name", "");
      QRoute.startUri(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadinjoySubscriptManagerActivity.SubscribeAdapter
 * JD-Core Version:    0.7.0.1
 */