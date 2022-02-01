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
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("set friend profile card click and aid=");
    paramDialogInterface.append(this.val$aid);
    paramDialogInterface.append(" pay type=");
    paramDialogInterface.append(this.val$payType);
    QLog.e("QVipProfileCard.AbsVasProfileHeaderComponent", 1, paramDialogInterface.toString());
    paramInt = this.val$payType;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6)
            {
              if (paramInt != 7) {
                Toast.makeText(AbsVasProfileHeaderComponent.access$4600(this.this$0), 2131695130, 0).show();
              } else {
                VasH5PayUtil.a(AbsVasProfileHeaderComponent.access$4500(this.this$0), this.val$aid, "SVHHZLH", 12, false, false);
              }
            }
            else {
              VasH5PayUtil.a(AbsVasProfileHeaderComponent.access$4400(this.this$0), this.val$aid, "SVHHZLH", 0, false, false);
            }
          }
          else {
            VipUtils.a(AbsVasProfileHeaderComponent.access$4300(this.this$0), true, 12, false, this.val$aid);
          }
        }
        else {
          VipUtils.a(AbsVasProfileHeaderComponent.access$4200(this.this$0), false, 12, false, this.val$aid);
        }
      }
      else {
        VipUtils.b(AbsVasProfileHeaderComponent.access$4100(this.this$0), 1, this.val$aid);
      }
    }
    else {
      VipUtils.a(AbsVasProfileHeaderComponent.access$4000(this.this$0), 1, this.val$aid);
    }
    ReportController.b(AbsVasProfileHeaderComponent.access$4700(this.this$0), "dc00898", "", "", "", "0X800A4C2", 0, 0, "", "", "", "");
    this.this$0.cancelOpenVipPromptDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.7
 * JD-Core Version:    0.7.0.1
 */