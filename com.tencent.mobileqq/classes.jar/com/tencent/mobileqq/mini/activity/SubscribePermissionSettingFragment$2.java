package com.tencent.mobileqq.mini.activity;

import com.tencent.mobileqq.mini.model.SubscribeItemModel;
import com.tencent.mobileqq.mini.model.SubscribeItemModel.SubscribeViewType;
import com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter.InteractiveListener;
import com.tencent.mobileqq.mini.widget.AuthDetailDialog;
import java.util.List;

class SubscribePermissionSettingFragment$2
  implements SubscribePermissionAdapter.InteractiveListener
{
  SubscribePermissionSettingFragment$2(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment) {}
  
  public void onCheckedChange(int paramInt, boolean paramBoolean)
  {
    SubscribeItemModel localSubscribeItemModel = (SubscribeItemModel)SubscribePermissionSettingFragment.access$000(this.this$0).get(paramInt);
    SubscribePermissionSettingFragment.access$100(this.this$0, paramInt, paramBoolean, localSubscribeItemModel);
    if (localSubscribeItemModel.getViewType() == SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE) {
      SubscribePermissionSettingFragment.access$200(this.this$0, paramInt, paramBoolean, localSubscribeItemModel);
    }
    if (localSubscribeItemModel.getViewType() == SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE) {
      SubscribePermissionSettingFragment.access$300(this.this$0, paramInt, paramBoolean, localSubscribeItemModel, "setting.onceMsgSubscribed");
    }
    if (localSubscribeItemModel.getViewType() == SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE) {
      SubscribePermissionSettingFragment.access$300(this.this$0, paramInt, paramBoolean, localSubscribeItemModel, "setting.sysMsgSubscribed");
    }
  }
  
  public void onClickDetail(int paramInt)
  {
    SubscribeItemModel localSubscribeItemModel = (SubscribeItemModel)SubscribePermissionSettingFragment.access$000(this.this$0).get(paramInt);
    new AuthDetailDialog(this.this$0.getActivity(), localSubscribeItemModel.getStSubscribeMessage(), -1, -1, 2).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */