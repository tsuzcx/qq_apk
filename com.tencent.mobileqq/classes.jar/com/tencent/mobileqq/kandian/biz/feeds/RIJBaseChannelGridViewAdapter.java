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
  protected final int d;
  protected final RIJBaseChannelGridViewAdapter.AdapterCallback e;
  protected boolean f;
  
  public RIJBaseChannelGridViewAdapter(Context paramContext, int paramInt1, int paramInt2, RIJBaseChannelGridViewAdapter.AdapterCallback paramAdapterCallback)
  {
    super(paramContext, paramInt1);
    this.d = paramInt2;
    this.e = paramAdapterCallback;
  }
  
  private void e(List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      this.e.a((TabChannelCoverInfo)paramList.get(i), i);
      i += 1;
    }
  }
  
  protected void a(TabChannelCoverInfo paramTabChannelCoverInfo, TextView paramTextView)
  {
    this.e.a(paramTabChannelCoverInfo);
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo.redPoint.f)) {
      paramTextView.setText(paramTabChannelCoverInfo.redPoint.f);
    }
    if (paramTabChannelCoverInfo.redPoint.g != 0) {
      paramTextView.setTextColor(paramTabChannelCoverInfo.redPoint.g);
    }
    if (paramTabChannelCoverInfo.redPoint.h != 0) {
      ((GradientDrawable)paramTextView.getBackground()).setColor(paramTabChannelCoverInfo.redPoint.h);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void c(List<TabChannelCoverInfo> paramList)
  {
    paramList = d(paramList);
    b(paramList);
    e(paramList);
  }
  
  abstract List<TabChannelCoverInfo> d(List<TabChannelCoverInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.RIJBaseChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */