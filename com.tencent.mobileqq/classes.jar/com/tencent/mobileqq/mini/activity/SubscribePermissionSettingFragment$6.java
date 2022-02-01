package com.tencent.mobileqq.mini.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter;
import java.util.List;

class SubscribePermissionSettingFragment$6
  implements Runnable
{
  SubscribePermissionSettingFragment$6(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment, List paramList) {}
  
  public void run()
  {
    SubscribePermissionSettingFragment localSubscribePermissionSettingFragment = this.this$0;
    SubscribePermissionSettingFragment.access$802(localSubscribePermissionSettingFragment, new SubscribePermissionAdapter(this.val$dataList, SubscribePermissionSettingFragment.access$900(localSubscribePermissionSettingFragment)));
    if (SubscribePermissionSettingFragment.access$1000(this.this$0) == null)
    {
      localSubscribePermissionSettingFragment = this.this$0;
      SubscribePermissionSettingFragment.access$1002(localSubscribePermissionSettingFragment, new LinearLayoutManager(localSubscribePermissionSettingFragment.getBaseActivity()));
      SubscribePermissionSettingFragment.access$1100(this.this$0).setLayoutManager(SubscribePermissionSettingFragment.access$1000(this.this$0));
    }
    SubscribePermissionSettingFragment.access$1100(this.this$0).setAdapter(SubscribePermissionSettingFragment.access$800(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */