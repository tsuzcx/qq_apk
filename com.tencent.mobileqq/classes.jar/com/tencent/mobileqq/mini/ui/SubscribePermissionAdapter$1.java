package com.tencent.mobileqq.mini.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribePermissionAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  SubscribePermissionAdapter$1(SubscribePermissionAdapter paramSubscribePermissionAdapter, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (SubscribePermissionAdapter.access$000(this.this$0) != null) {
      SubscribePermissionAdapter.access$000(this.this$0).onCheckedChange(this.val$index, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter.1
 * JD-Core Version:    0.7.0.1
 */