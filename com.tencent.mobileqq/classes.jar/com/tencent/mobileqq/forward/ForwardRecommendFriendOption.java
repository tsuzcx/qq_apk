package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ForwardRecommendFriendOption
  extends ForwardBaseOption
{
  AbsShareMsg a;
  AbsStructMsg ad;
  
  public ForwardRecommendFriendOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void W()
  {
    int i = this.r.getIntExtra("structmsg_service_id", -1);
    if (i == 63) {
      ReportController.b(this.q, "CliOper", "", "", "0X8005B35", "0X8005B35", 0, 0, "", "", "", "");
    } else if (i == 84) {
      if (this.r.getIntExtra("pa_type", -1) == 53) {
        ReportController.b(this.q, "CliOper", "", "", "0X8007017", "0X8007017", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.q, "CliOper", "", "", "0X800716A", "0X800716A", 0, 0, "", "", "", "");
      }
    }
    super.W();
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    Object localObject = this.ad;
    if (localObject != null)
    {
      paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.s, null));
    }
    else if (this.a != null)
    {
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.b(-15.0F, this.s.getResources()), 0, AIOUtils.b(-15.0F, this.s.getResources()), AIOUtils.b(5.0F, this.s.getResources()));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardRecommendFriendOption", 2, "updateImageView addStructView");
      }
      paramQQCustomDialog.addView(this.a.getPreDialogView(this.s, null), (LinearLayout.LayoutParams)localObject);
    }
    return true;
  }
  
  protected void b()
  {
    int i = this.r.getIntExtra("structmsg_service_id", -1);
    if (i == 63) {
      ReportController.b(this.q, "CliOper", "", "", "0X8005B34", "0X8005B34", 0, 0, "", "", "", "");
    } else if (i == 84) {
      if (this.r.getIntExtra("pa_type", -1) == 53) {
        ReportController.b(this.q, "CliOper", "", "", "0X8007018", "0X8007018", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.q, "CliOper", "", "", "0X8007169", "0X8007169", 0, 0, "", "", "", "");
      }
    }
    super.b();
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
  }
  
  public boolean e()
  {
    super.e();
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.t.getByteArray("stuctmsg_bytes"));
    this.ad = StructMsgFactory.a(this.t.getByteArray("struct_msg_show_in_dialog"));
    if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg))) {
      this.a = ((AbsShareMsg)localAbsStructMsg);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardRecommendFriendOption
 * JD-Core Version:    0.7.0.1
 */