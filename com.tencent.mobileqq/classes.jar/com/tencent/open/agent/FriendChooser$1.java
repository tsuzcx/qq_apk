package com.tencent.open.agent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class FriendChooser$1
  implements AdapterView.OnItemClickListener
{
  FriendChooser$1(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Friend localFriend = (Friend)this.a.x.getItem(paramInt);
    if ((localFriend != null) && (this.a.C.b(localFriend.a)))
    {
      this.a.C.d(localFriend.a);
      this.a.B.remove(localFriend);
      this.a.f();
      ((OpenFrame)this.a.h.getCurrentView()).g();
      this.a.b(false);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.1
 * JD-Core Version:    0.7.0.1
 */