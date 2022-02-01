package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ForwardQZoneRichImageOption
  extends ForwardSdkBaseOption
{
  private boolean aw;
  
  public ForwardQZoneRichImageOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (this.aw)
    {
      this.am.mSourceName = this.r.getStringExtra("struct_share_key_source_name");
      this.am.mSourceIcon = this.r.getStringExtra("struct_share_key_source_icon");
    }
    if ((paramQQCustomDialog != null) && (this.am != null))
    {
      this.al = new ForwardSdkBaseOption.PreStructViewHolder(this, this.s);
      paramQQCustomDialog.addView(this.al.a());
      paramQQCustomDialog.adjustMessageTopBottomMargin(0.0F, 10.0F);
      a(this.am.mSourceName, paramQQCustomDialog);
    }
    return false;
  }
  
  protected void b()
  {
    if (this.H)
    {
      ReportController.b(this.q, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.H = false;
    }
    super.b();
  }
  
  protected void d()
  {
    this.A.setMessage("");
  }
  
  public boolean e()
  {
    super.e();
    this.a = this.t.getLong("req_share_id");
    this.aw = this.r.getBooleanExtra("is_ec_live_share", false);
    if ((this.a > 0L) && (!this.aw)) {
      Share.a(this.q, this.I, this.q.getCurrentAccountUin(), this.a, 0L, this.au);
    }
    aw();
    Object localObject = new Bundle(this.t);
    ((Bundle)localObject).putInt("req_type", 1);
    localObject = StructMsgFactory.a((Bundle)localObject);
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.am = ((AbsShareMsg)localObject);
    }
    ax();
    return true;
  }
  
  protected boolean f()
  {
    aA();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQZoneRichImageOption
 * JD-Core Version:    0.7.0.1
 */