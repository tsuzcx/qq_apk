package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Set;

public class ForwardEmojiPacketSendOption
  extends ForwardBaseOption
{
  int a;
  
  public ForwardEmojiPacketSendOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.A != null) && (this.A.isShowing())) {
      return;
    }
    this.t.putString("uin", paramBundle.getString("uin"));
    this.t.putInt("uintype", paramBundle.getInt("uintype"));
    this.t.putBoolean("isBack2Root", true);
    this.r = new Intent(this.s, SplashActivity.class);
    this.r = AIOUtils.a(this.r, new int[] { 2 });
    this.r.putExtras(this.t);
    this.s.getSharedPreferences("mobileQQ", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
    this.s.startActivity(this.r);
    ReportController.b(this.q, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", "FORWARD_EMOPGK_ID");
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
    this.a = this.r.getIntExtra("FORWARD_EMOPGK_ID", -1);
    return true;
  }
  
  public void m()
  {
    super.m();
    QQAppInterface localQQAppInterface = this.q;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.r.getIntExtra("FORWARD_EMOPGK_ID", -1));
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardEmojiPacketSendOption
 * JD-Core Version:    0.7.0.1
 */