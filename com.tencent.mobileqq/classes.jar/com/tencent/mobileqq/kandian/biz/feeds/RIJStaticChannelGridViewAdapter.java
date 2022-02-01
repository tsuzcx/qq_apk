package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;

public class RIJStaticChannelGridViewAdapter
  extends RIJBaseChannelGridViewAdapter
  implements AdapterView.OnItemClickListener
{
  public RIJStaticChannelGridViewAdapter(Context paramContext, int paramInt1, int paramInt2, RIJBaseChannelGridViewAdapter.AdapterCallback paramAdapterCallback)
  {
    super(paramContext, paramInt1, paramInt2, paramAdapterCallback);
  }
  
  private int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int j = -1291845632;
    int i = j;
    if (paramTabChannelCoverInfo != null)
    {
      i = j;
      if (paramTabChannelCoverInfo.fontsColor != 0) {
        i = paramTabChannelCoverInfo.fontsColor;
      }
    }
    return i;
  }
  
  List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList)
  {
    Iterator localIterator;
    if ((paramList != null) && (paramList.size() != 0)) {
      localIterator = paramList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((TabChannelCoverInfo)localIterator.next()).isCurrent = false;
      continue;
      QLog.d("RIJStaticChannelGridViewAdapter", 2, "No channel Cache info.");
    }
    return paramList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560263, null);
      paramViewGroup = new RIJStaticChannelGridViewAdapter.ChannelItemViewHolder(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370075));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView = ((AutoFitTextView)paramView.findViewById(2131364464));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376320));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376325));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131369387));
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setCorner(this.b);
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setOnGetMaxWidthCallback(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (RIJStaticChannelGridViewAdapter.ChannelItemViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setText(localTabChannelCoverInfo.mChannelCoverName);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setTextColor(a(localTabChannelCoverInfo));
    if (this.jdField_a_of_type_Boolean)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablesWithIntrinsicBounds(2130842880, 0, 0, 0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablePadding(AIOUtils.b(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    else
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    ImageView localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
    if (RIJChannelHelper.a(localTabChannelCoverInfo) == 0) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localImageView.setVisibility(paramInt);
    if ((RIJChannelHelper.a(localTabChannelCoverInfo) == 1) && (localTabChannelCoverInfo.redPoint.c <= 0L))
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      a(localTabChannelCoverInfo, paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return paramView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJBaseChannelGridViewAdapter$AdapterCallback.a(paramAdapterView, this, paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.RIJStaticChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */