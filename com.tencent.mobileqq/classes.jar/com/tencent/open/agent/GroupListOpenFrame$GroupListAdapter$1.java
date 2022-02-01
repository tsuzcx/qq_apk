package com.tencent.open.agent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupListOpenFrame$GroupListAdapter$1
  implements View.OnClickListener
{
  GroupListOpenFrame$GroupListAdapter$1(GroupListOpenFrame.GroupListAdapter paramGroupListAdapter, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("group_index", this.a);
    localBundle.putString("group_name", this.b);
    this.c.a.k.a(1, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame.GroupListAdapter.1
 * JD-Core Version:    0.7.0.1
 */