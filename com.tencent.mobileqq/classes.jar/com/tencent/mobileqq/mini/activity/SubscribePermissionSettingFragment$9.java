package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import com.tencent.mobileqq.mini.model.SubscribeItemModel;
import com.tencent.mobileqq.mini.model.SubscribeItemModel.Builder;
import com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.List;

class SubscribePermissionSettingFragment$9
  implements Runnable
{
  SubscribePermissionSettingFragment$9(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment, SubscribeItemModel paramSubscribeItemModel, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    INTERFACE.StSubscribeMessage localStSubscribeMessage = this.val$clickItem.getStSubscribeMessage();
    if (localStSubscribeMessage != null)
    {
      PBInt32Field localPBInt32Field = localStSubscribeMessage.authState;
      int i;
      if (this.val$isChecked) {
        i = 1;
      } else {
        i = 2;
      }
      localPBInt32Field.set(i);
    }
    SubscribePermissionSettingFragment.access$000(this.this$0).set(this.val$position, new SubscribeItemModel.Builder(this.val$clickItem).setIsChecked(this.val$isChecked).setStSubscribeMessage(localStSubscribeMessage).build());
    SubscribePermissionSettingFragment.access$800(this.this$0).setData(SubscribePermissionSettingFragment.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */