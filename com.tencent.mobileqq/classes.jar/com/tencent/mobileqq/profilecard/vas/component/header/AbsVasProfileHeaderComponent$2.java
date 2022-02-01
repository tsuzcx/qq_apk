package com.tencent.mobileqq.profilecard.vas.component.header;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;

class AbsVasProfileHeaderComponent$2
  implements DialogInterface.OnClickListener
{
  AbsVasProfileHeaderComponent$2(AbsVasProfileHeaderComponent paramAbsVasProfileHeaderComponent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AbsVasProfileHeaderComponent.access$100(this.this$0) == 1) {
      VipUtils.a(AbsVasProfileHeaderComponent.access$200(this.this$0), 1, ProfileCardUtil.a(3));
    } else if (AbsVasProfileHeaderComponent.access$100(this.this$0) == 2) {
      VipUtils.b(AbsVasProfileHeaderComponent.access$300(this.this$0), 1, ProfileCardUtil.a(6));
    } else if (AbsVasProfileHeaderComponent.access$100(this.this$0) == 3) {
      VipUtils.a(AbsVasProfileHeaderComponent.access$400(this.this$0), true, 12, false, ProfileCardUtil.a(6));
    } else if (AbsVasProfileHeaderComponent.access$100(this.this$0) == 4) {
      VasH5PayUtil.a(AbsVasProfileHeaderComponent.access$500(this.this$0), ProfileCardUtil.a(6), "SVHHZLH", 0, false, false);
    }
    this.this$0.cancelOpenVipPromptDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.2
 * JD-Core Version:    0.7.0.1
 */