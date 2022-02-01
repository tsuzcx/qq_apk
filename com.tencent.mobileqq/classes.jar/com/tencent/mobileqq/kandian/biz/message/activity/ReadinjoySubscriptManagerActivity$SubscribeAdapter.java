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
  private List<ReadinjoySubscriptManagerActivity.SubscribeFeedData> b;
  
  private ReadinjoySubscriptManagerActivity$SubscribeAdapter(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(ReadinjoySubscriptManagerActivity.SubscribeHolder paramSubscribeHolder, int paramInt, View paramView)
  {
    ReadinjoySubscriptManagerActivity.SubscribeFeedData localSubscribeFeedData = (ReadinjoySubscriptManagerActivity.SubscribeFeedData)this.b.get(paramInt);
    ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramSubscribeHolder).setText(ReadinjoySubscriptManagerActivity.SubscribeFeedData.b(localSubscribeFeedData));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramSubscribeHolder).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramSubscribeHolder).setImageDrawable(ReadinjoySubscriptManagerActivity.c(this.a).a(1008, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(localSubscribeFeedData)));
    if (ReadinjoySubscriptManagerActivity.d(this.a)) {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
    } else {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.a.getResources().getDimensionPixelSize(2131299575);
    }
    localObject = ReadinjoySubscriptManagerActivity.SubscribeHolder.d(paramSubscribeHolder);
    int i;
    if (ReadinjoySubscriptManagerActivity.d(this.a)) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    ReadinjoySubscriptManagerActivity.SubscribeHolder.d(paramSubscribeHolder).setOnClickListener(new ReadinjoySubscriptManagerActivity.SubscribeAdapter.1(this, paramView));
    if (paramInt == getCount() - 1) {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.e(paramSubscribeHolder).setVisibility(8);
    } else {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.e(paramSubscribeHolder).setVisibility(0);
    }
    ReadinjoySubscriptManagerActivity.SubscribeHolder.f(paramSubscribeHolder).setOnClickListener(new ReadinjoySubscriptManagerActivity.SubscribeAdapter.2(this, localSubscribeFeedData));
    ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(localSubscribeFeedData));
    if (ReadinjoySubscriptManagerActivity.d(this.a)) {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.g(paramSubscribeHolder).setBackgroundResource(2131167849);
    } else {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.g(paramSubscribeHolder).setBackgroundResource(2130842690);
    }
    ReadinjoySubscriptManagerActivity.SubscribeHolder.g(paramSubscribeHolder).setPressed(false);
  }
  
  public void a(List<ReadinjoySubscriptManagerActivity.SubscribeFeedData> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.b.get(paramInt);
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
      paramView = new ReadinjoySubscriptManagerActivity.SubscribeHolder(this.a, null);
      View localView = this.a.getLayoutInflater().inflate(2131626337, paramViewGroup, false);
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, localView.findViewById(2131431280));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramView, localView.findViewById(2131431689));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (ImageView)localView.findViewById(2131446572));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (TextView)localView.findViewById(2131446583));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (Button)localView.findViewById(2131449084));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramView, localView.findViewById(2131432003));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.a.getResources().getDimensionPixelSize(2131299576)));
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
      if (ReadinjoySubscriptManagerActivity.d(this.a)) {
        return;
      }
      paramView = new ActivityURIRequest(this.a, "/pubaccount/detail");
      paramView.extra().putString("uin", ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(paramAdapterView));
      paramView.extra().putString("report_src_param_type", "");
      paramView.extra().putString("report_src_param_name", "");
      QRoute.startUri(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadinjoySubscriptManagerActivity.SubscribeAdapter
 * JD-Core Version:    0.7.0.1
 */