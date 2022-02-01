package com.tencent.qqmini.sdk.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo;

class TabBar$1
  implements View.OnClickListener
{
  TabBar$1(TabBar paramTabBar, int paramInt, TabBarInfo.ButtonInfo paramButtonInfo) {}
  
  public void onClick(View paramView)
  {
    if (TabBar.access$000(this.this$0) != null) {
      TabBar.access$000(this.this$0).onTabItemClick(this.val$pos, this.val$info.pagePath, this.val$info.text);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.TabBar.1
 * JD-Core Version:    0.7.0.1
 */