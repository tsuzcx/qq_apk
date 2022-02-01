package com.tencent.mobileqq.newfriend.ui.adapter;

import android.view.View;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;

class NewFriendMoreSysMsgAdapter$5$1
  implements Runnable
{
  NewFriendMoreSysMsgAdapter$5$1(NewFriendMoreSysMsgAdapter.5 param5, ArrayList paramArrayList) {}
  
  public void run()
  {
    NewFriendMoreSysMsgAdapter.a(this.b.this$0, this.a);
    this.b.this$0.notifyDataSetChanged();
    if (this.b.this$0.getCount() > 0)
    {
      NewFriendMoreSysMsgAdapter.h(this.b.this$0).setVisibility(0);
      NewFriendMoreSysMsgAdapter.i(this.b.this$0).setVisibility(8);
      if ((this.b.a) && (NewFriendMoreSysMsgAdapter.j(this.b.this$0) < this.b.this$0.getCount())) {
        NewFriendMoreSysMsgAdapter.h(this.b.this$0).setSelection(NewFriendMoreSysMsgAdapter.j(this.b.this$0));
      }
    }
    else
    {
      NewFriendMoreSysMsgAdapter.i(this.b.this$0).setVisibility(0);
      NewFriendMoreSysMsgAdapter.h(this.b.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */