package com.tencent.mobileqq.profilecard.vas.component.header;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qphone.base.util.QLog;

class AbsVasProfileHeaderComponent$7
  implements DialogInterface.OnClickListener
{
  AbsVasProfileHeaderComponent$7(AbsVasProfileHeaderComponent paramAbsVasProfileHeaderComponent, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, "set friend profile card click and aid=" + this.val$aid + " pay type=" + this.val$payType);
    switch (this.val$payType)
    {
    case 3: 
    default: 
      Toast.makeText(AbsVasProfileHeaderComponent.access$7200(this.this$0), 2131695140, 0).show();
    }
    for (;;)
    {
      ReportController.b(AbsVasProfileHeaderComponent.access$7300(this.this$0), "dc00898", "", "", "", "0X800A4C2", 0, 0, "", "", "", "");
      this.this$0.cancelOpenVipPromptDialog();
      return;
      VipUtils.a(AbsVasProfileHeaderComponent.access$6600(this.this$0), 1, this.val$aid);
      continue;
      VipUtils.b(AbsVasProfileHeaderComponent.access$6700(this.this$0), 1, this.val$aid);
      continue;
      VipUtils.a(AbsVasProfileHeaderComponent.access$6800(this.this$0), false, 12, false, this.val$aid);
      continue;
      VipUtils.a(AbsVasProfileHeaderComponent.access$6900(this.this$0), true, 12, false, this.val$aid);
      continue;
      VasH5PayUtil.a(AbsVasProfileHeaderComponent.access$7000(this.this$0), this.val$aid, "SVHHZLH", 0, false, false);
      continue;
      VasH5PayUtil.a(AbsVasProfileHeaderComponent.access$7100(this.this$0), this.val$aid, "SVHHZLH", 12, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.7
 * JD-Core Version:    0.7.0.1
 */