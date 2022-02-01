package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

class ChannelCoverView$ChannelCoverViewObserver
  extends ReadInJoyObserver
{
  private ChannelCoverView$ChannelCoverViewObserver(ChannelCoverView paramChannelCoverView) {}
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (ChannelCoverView.a(this.a) == paramInt))
    {
      ChannelCoverView.a(this.a, (ArrayList)paramList);
      if ((ChannelCoverView.a(this.a) != null) && (ChannelCoverView.a(this.a) != null) && (ChannelCoverView.a(this.a).size() > 0))
      {
        ChannelCoverView.a(this.a).a(ChannelCoverView.a(this.a));
        ChannelCoverView.a(this.a).notifyDataSetChanged();
        if (ChannelCoverView.a(this.a).findHeaderViewPosition(ChannelCoverView.a(this.a)) < 0) {
          ChannelCoverView.a(this.a).addHeaderView(ChannelCoverView.a(this.a));
        }
      }
      else
      {
        ChannelCoverView.a(this.a).removeHeaderView(ChannelCoverView.a(this.a));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onSubChannelListUpdate infos size");
        paramList.append(ChannelCoverView.a(this.a).size());
        QLog.d("ChannelCoverView", 2, paramList.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onSubChannelListUpdate");
      paramList.append(paramBoolean);
      QLog.d("ChannelCoverView", 2, paramList.toString());
    }
  }
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (ChannelCoverView.a(this.a) == 0))
    {
      ChannelCoverView.a(this.a, (ArrayList)paramList);
      if ((ChannelCoverView.a(this.a) != null) && (ChannelCoverView.a(this.a).size() > 0))
      {
        ChannelCoverView.a(this.a).a(ChannelCoverView.a(this.a));
        ChannelCoverView.a(this.a).notifyDataSetChanged();
        if (ChannelCoverView.a(this.a).findHeaderViewPosition(ChannelCoverView.a(this.a)) < 0) {
          ChannelCoverView.a(this.a).addHeaderView(ChannelCoverView.a(this.a));
        }
      }
      else
      {
        ChannelCoverView.a(this.a).removeHeaderView(ChannelCoverView.a(this.a));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onMainChannelListUpdate infos size");
        paramList.append(ChannelCoverView.a(this.a).size());
        QLog.d("ChannelCoverView", 2, paramList.toString());
      }
    }
    paramList = new StringBuilder();
    paramList.append("onMainChannelListUpdate");
    paramList.append(paramBoolean);
    QLog.d("ChannelCoverView", 2, paramList.toString());
  }
  
  public void c(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (ChannelCoverView.a(this.a) == 56))
    {
      ChannelCoverView.a(this.a, (ArrayList)paramList);
      if ((ChannelCoverView.a(this.a) != null) && (ChannelCoverView.a(this.a) != null) && (ChannelCoverView.a(this.a).size() > 0))
      {
        ChannelCoverView.a(this.a).a(ChannelCoverView.a(this.a));
        ChannelCoverView.a(this.a).notifyDataSetChanged();
        if (ChannelCoverView.a(this.a).findHeaderViewPosition(ChannelCoverView.a(this.a)) < 0) {
          ChannelCoverView.a(this.a).addHeaderView(ChannelCoverView.a(this.a));
        }
      }
      else
      {
        ChannelCoverView.a(this.a).removeHeaderView(ChannelCoverView.a(this.a));
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onVideoChannelListUpdate infos size");
        paramList.append(ChannelCoverView.a(this.a).size());
        QLog.d("ChannelCoverView", 2, paramList.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onVideoChannelListUpdate");
      paramList.append(paramBoolean);
      QLog.d("ChannelCoverView", 2, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView.ChannelCoverViewObserver
 * JD-Core Version:    0.7.0.1
 */