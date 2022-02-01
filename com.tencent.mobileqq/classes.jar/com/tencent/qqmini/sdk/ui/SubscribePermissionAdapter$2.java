package com.tencent.qqmini.sdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribePermissionAdapter$2
  implements View.OnClickListener
{
  SubscribePermissionAdapter$2(SubscribePermissionAdapter paramSubscribePermissionAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (SubscribePermissionAdapter.access$000(this.this$0) != null) {
      SubscribePermissionAdapter.access$000(this.this$0).onClickDetail(this.val$index);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionAdapter.2
 * JD-Core Version:    0.7.0.1
 */