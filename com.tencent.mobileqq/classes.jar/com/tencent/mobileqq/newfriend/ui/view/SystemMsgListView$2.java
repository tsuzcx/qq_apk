package com.tencent.mobileqq.newfriend.ui.view;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.connections.ListviewScrollStatus;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

class SystemMsgListView$2
  implements TabLayoutCompat.OnTabSelectedListener
{
  SystemMsgListView$2(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    if (paramTab != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setStickHead onTabSelected : position = ");
        localStringBuilder.append(paramTab.d());
        localStringBuilder.append(" tabid = ");
        localStringBuilder.append((Integer)paramTab.a());
        QLog.i("Q.newfriendSystemMsgListView", 2, localStringBuilder.toString());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramTab.a()).intValue(), paramTab.d());
      int i = SystemMsgListView.a(this.a).m();
      paramTab = (ListviewScrollStatus)SystemMsgListView.c(this.a).get(i);
      int j;
      if (paramTab != null)
      {
        i = paramTab.b;
        j = paramTab.c;
      }
      else
      {
        i = SystemMsgListView.d(this.a).b;
        j = SystemMsgListView.d(this.a).c;
      }
      SystemMsgListView.e(this.a).setSelectionFromTop(i, j);
      SystemMsgListView.a(this.a).a(0L);
    }
  }
  
  public void b(TabLayoutCompat.Tab paramTab) {}
  
  public void c(TabLayoutCompat.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.2
 * JD-Core Version:    0.7.0.1
 */