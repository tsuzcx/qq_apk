package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import java.util.List;

public abstract class RIJBaseChannelGridViewAdapter
  extends ReadInJoyDynamicGridView.BaseDynamicGridAdapter<TabChannelCoverInfo>
{
  protected final RIJBaseChannelGridViewAdapter.AdapterCallback a;
  protected boolean a;
  protected final int b;
  
  public RIJBaseChannelGridViewAdapter(Context paramContext, int paramInt1, int paramInt2, RIJBaseChannelGridViewAdapter.AdapterCallback paramAdapterCallback)
  {
    super(paramContext, paramInt1);
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJBaseChannelGridViewAdapter$AdapterCallback = paramAdapterCallback;
  }
  
  private void d(List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJBaseChannelGridViewAdapter$AdapterCallback.a((TabChannelCoverInfo)paramList.get(i), i);
      i += 1;
    }
  }
  
  abstract List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList);
  
  protected void a(TabChannelCoverInfo paramTabChannelCoverInfo, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsRIJBaseChannelGridViewAdapter$AdapterCallback.a(paramTabChannelCoverInfo);
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo.redPoint.a)) {
      paramTextView.setText(paramTabChannelCoverInfo.redPoint.a);
    }
    if (paramTabChannelCoverInfo.redPoint.b != 0) {
      paramTextView.setTextColor(paramTabChannelCoverInfo.redPoint.b);
    }
    if (paramTabChannelCoverInfo.redPoint.c != 0) {
      ((GradientDrawable)paramTextView.getBackground()).setColor(paramTabChannelCoverInfo.redPoint.c);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void c(List<TabChannelCoverInfo> paramList)
  {
    paramList = a(paramList);
    b(paramList);
    d(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.RIJBaseChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */