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
    SubscribePermissionSettingFragment.access$802(this.this$0, new SubscribePermissionAdapter(this.val$dataList, SubscribePermissionSettingFragment.access$900(this.this$0)));
    if (SubscribePermissionSettingFragment.access$1000(this.this$0) == null)
    {
      SubscribePermissionSettingFragment.access$1002(this.this$0, new LinearLayoutManager(this.this$0.getActivity()));
      SubscribePermissionSettingFragment.access$1100(this.this$0).setLayoutManager(SubscribePermissionSettingFragment.access$1000(this.this$0));
    }
    SubscribePermissionSettingFragment.access$1100(this.this$0).setAdapter(SubscribePermissionSettingFragment.access$800(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */