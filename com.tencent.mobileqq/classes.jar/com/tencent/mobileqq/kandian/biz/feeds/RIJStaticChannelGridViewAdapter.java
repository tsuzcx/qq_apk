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
  
  List<TabChannelCoverInfo> d(List<TabChannelCoverInfo> paramList)
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
      paramView = LayoutInflater.from(this.a).inflate(2131626310, null);
      paramViewGroup = new RIJStaticChannelGridViewAdapter.ChannelItemViewHolder(this.a);
      paramViewGroup.a = ((LinearLayout)paramView.findViewById(2131437237));
      paramViewGroup.b = ((AutoFitTextView)paramView.findViewById(2131430505));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131444531));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131444538));
      paramViewGroup.e = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131436420));
      if (paramViewGroup.e != null) {
        paramViewGroup.e.setCorner(this.d);
      }
      paramViewGroup.b.setOnGetMaxWidthCallback(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (RIJStaticChannelGridViewAdapter.ChannelItemViewHolder)paramView.getTag();
    }
    paramViewGroup.b.setText(localTabChannelCoverInfo.mChannelCoverName);
    paramViewGroup.b.setTextColor(a(localTabChannelCoverInfo));
    if (this.f)
    {
      paramViewGroup.b.setCompoundDrawablesWithIntrinsicBounds(2130843836, 0, 0, 0);
      paramViewGroup.b.setCompoundDrawablePadding(AIOUtils.b(4.0F, this.a.getResources()));
    }
    else
    {
      paramViewGroup.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    ImageView localImageView = paramViewGroup.c;
    if (RIJChannelHelper.a(localTabChannelCoverInfo) == 0) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localImageView.setVisibility(paramInt);
    if ((RIJChannelHelper.a(localTabChannelCoverInfo) == 1) && (localTabChannelCoverInfo.redPoint.d <= 0L))
    {
      paramViewGroup.d.setVisibility(0);
      a(localTabChannelCoverInfo, paramViewGroup.d);
      return paramView;
    }
    paramViewGroup.d.setVisibility(8);
    return paramView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.e.a(paramAdapterView, this, paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.RIJStaticChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */