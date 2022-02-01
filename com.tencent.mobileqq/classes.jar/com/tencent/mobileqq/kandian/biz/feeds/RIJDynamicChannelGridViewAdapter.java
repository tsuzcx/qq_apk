package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.OnDragListener;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.OnDropListener;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import java.util.List;

public class RIJDynamicChannelGridViewAdapter
  extends RIJBaseChannelGridViewAdapter
  implements View.OnClickListener, ReadInJoyDynamicGridView.OnDragListener, ReadInJoyDynamicGridView.OnDropListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private final RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback a;
  private final int c;
  private int d = 0;
  
  public RIJDynamicChannelGridViewAdapter(Context paramContext, int paramInt1, int paramInt2, RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback paramDynamicAdapterCallback, int paramInt3)
  {
    super(paramContext, paramInt1, paramInt2, paramDynamicAdapterCallback);
    this.c = paramInt3;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback = paramDynamicAdapterCallback;
  }
  
  private int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int j = -1291845632;
    int i = j;
    if (paramTabChannelCoverInfo != null)
    {
      if (paramTabChannelCoverInfo.fontsColor != 0) {
        return paramTabChannelCoverInfo.fontsColor;
      }
      i = j;
      if (paramTabChannelCoverInfo.isCurrent) {
        i = -15550475;
      }
    }
    return i;
  }
  
  List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i = this.c;
      if ((i >= 0) && (i < paramList.size())) {
        ((TabChannelCoverInfo)paramList.get(this.c)).isCurrent = true;
      }
      int k = 0;
      i = 0;
      TabChannelCoverInfo localTabChannelCoverInfo;
      while (i < paramList.size())
      {
        localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(i);
        if (localTabChannelCoverInfo != null)
        {
          boolean bool;
          if (i == this.c) {
            bool = true;
          } else {
            bool = false;
          }
          localTabChannelCoverInfo.isCurrent = bool;
        }
        i += 1;
      }
      int j = 0;
      i = k;
      while (i < paramList.size())
      {
        localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(i);
        k = j;
        if (localTabChannelCoverInfo != null)
        {
          if (localTabChannelCoverInfo.reason != 4) {
            break;
          }
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.d = j;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a(this.d);
      return paramList;
    }
    QLog.d("RIJDynamicChannelGridViewAdapter", 2, "No channel Cache info.");
    return paramList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a(this, paramInt1, paramInt2);
  }
  
  public void av_()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560235, null);
      paramView = new RIJDynamicChannelGridViewAdapter.ChannelItemViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131370075));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView = ((AutoFitTextView)paramViewGroup.findViewById(2131364464));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131376320));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131376325));
      paramView.b = ((ImageView)paramViewGroup.findViewById(2131365501));
      paramView.b.setOnClickListener(this);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setOnGetMaxWidthCallback(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)paramViewGroup.findViewById(2131369387));
      if (paramView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView != null) {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setCorner(this.b);
      }
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject = (RIJDynamicChannelGridViewAdapter.ChannelItemViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    paramViewGroup.setAlpha(1.0F);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setText(localTabChannelCoverInfo.mChannelCoverName);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setTextColor(a(localTabChannelCoverInfo));
    Object localObject = paramView.b;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    paramView.b.setTag(localTabChannelCoverInfo);
    paramView.b.setTag(2131376102, Integer.valueOf(paramInt));
    if ((paramInt < this.d) && (this.jdField_a_of_type_Boolean))
    {
      paramViewGroup.setAlpha(0.5F);
      paramView.b.setVisibility(8);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return paramViewGroup;
    }
    localObject = paramView.jdField_a_of_type_AndroidWidgetImageView;
    if (RIJChannelHelper.a(localTabChannelCoverInfo) == 0) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    ((ImageView)localObject).setVisibility(paramInt);
    if ((RIJChannelHelper.a(localTabChannelCoverInfo) == 1) && (localTabChannelCoverInfo.redPoint.c <= 0L))
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      a(localTabChannelCoverInfo, paramView.jdField_a_of_type_AndroidWidgetTextView);
      return paramViewGroup;
    }
    paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return paramViewGroup;
  }
  
  public void k_(int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131365501) {
      return;
    }
    int i = ((Integer)paramView.getTag(2131376102)).intValue();
    paramView = (TabChannelCoverInfo)paramView.getTag();
    QLog.d("RIJDynamicChannelGridViewAdapter", 1, new Object[] { "onClick, delete button position = ", Integer.valueOf(i) });
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a(i, paramView, this);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a(paramAdapterView, this, paramInt, paramView);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.b(paramAdapterView, this, paramInt, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.RIJDynamicChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */