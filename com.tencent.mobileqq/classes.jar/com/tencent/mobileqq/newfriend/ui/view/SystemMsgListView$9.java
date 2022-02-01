package com.tencent.mobileqq.newfriend.ui.view;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contact.connections.ListviewScrollStatus;
import com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.MayKnowRecommendBuilder;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;

class SystemMsgListView$9
  implements AbsListView.OnScrollListener
{
  SystemMsgListView$9(SystemMsgListView paramSystemMsgListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemMsgListView.a(this.a, paramInt1);
    paramAbsListView = this.a;
    paramInt2 += paramInt1;
    SystemMsgListView.a(paramAbsListView, paramInt2 - 1);
    if (SystemMsgListView.a(this.a).b() == 23)
    {
      if (paramInt1 >= 1)
      {
        paramAbsListView = (NewFriendBaseBuilder)SystemMsgListView.a(this.a).getItem(paramInt1 - 1);
        if ((paramAbsListView instanceof MayKnowRecommendBuilder)) {
          ((MayKnowRecommendBuilder)paramAbsListView).c();
        }
      }
      if (paramInt2 < paramInt3)
      {
        paramAbsListView = (NewFriendBaseBuilder)SystemMsgListView.a(this.a).getItem(paramInt2);
        if ((paramAbsListView instanceof MayKnowRecommendBuilder)) {
          ((MayKnowRecommendBuilder)paramAbsListView).c();
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (SystemMsgListView.a(this.a) != null)
    {
      if ((paramInt != 0) && (paramInt != 1))
      {
        SystemMsgListView.a(this.a).e();
      }
      else
      {
        SystemMsgListView.a(this.a).f();
        SystemMsgListView.a(this.a).d();
      }
      if (paramInt == 0)
      {
        SystemMsgListView.a(this.a).j();
        int i = SystemMsgListView.a(this.a).b();
        if (SystemMsgListView.a(this.a) >= SystemMsgListView.a(this.a).getCount() - 2)
        {
          paramAbsListView = SystemMsgListView.a(this.a).a();
          if ((paramAbsListView != null) && (paramAbsListView.a()) && (paramAbsListView.a >= 0) && (SystemMsgListView.a(this.a).a(i))) {
            ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getConnectionsPersonRemoteNextPage(paramAbsListView.a, this.a.a);
          }
        }
        int j = SystemMsgListView.a(this.a).getFirstVisiblePosition();
        paramAbsListView = SystemMsgListView.a(this.a);
        paramInt = 0;
        paramAbsListView = paramAbsListView.getChildAt(0);
        if (paramAbsListView != null) {
          paramInt = paramAbsListView.getTop();
        }
        SystemMsgListView.a(this.a).remove(i);
        if (SystemMsgListView.a(this.a).isShown())
        {
          paramAbsListView = new ListviewScrollStatus(i, j, paramInt);
          SystemMsgListView.a(this.a).put(i, paramAbsListView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.9
 * JD-Core Version:    0.7.0.1
 */