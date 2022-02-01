package com.tencent.mobileqq.kandian.biz.publisher;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.contacts.base.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class TroopBarPublishLocationSelectActivity$2
  implements OverScrollViewListener
{
  TroopBarPublishLocationSelectActivity$2(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.h == 0L) {
      l = System.currentTimeMillis();
    } else {
      l = this.a.h;
    }
    paramView.c(l);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.h == 0L) {
      l = System.currentTimeMillis();
    } else {
      l = this.a.h;
    }
    paramView.b(l);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.h == 0L) {
      l = System.currentTimeMillis();
    } else {
      l = this.a.h;
    }
    paramListView.a(l);
    if (NetworkUtil.isNetworkAvailable(this.a.getActivity()))
    {
      this.a.b();
      this.a.m.postDelayed(new TroopBarPublishLocationSelectActivity.2.1(this), 300L);
    }
    else
    {
      this.a.m.postDelayed(new TroopBarPublishLocationSelectActivity.2.2(this), 300L);
    }
    ((Contacts.OverScrollViewTag)paramView.getTag()).a = true;
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.TroopBarPublishLocationSelectActivity.2
 * JD-Core Version:    0.7.0.1
 */