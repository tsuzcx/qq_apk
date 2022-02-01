package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public abstract class BaseTroopAioMsgMultiNavigateBarDelegate
  extends BaseAioMsgNavigateBarDelegate
{
  public BaseTroopAioMsgMultiNavigateBarDelegate(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
  }
  
  public void a(int paramInt1, AioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    if (paramMessage.g)
    {
      ReportController.b(this.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_hongbao", 0, 0, this.f.b, "", "", "");
      ReportController.b(this.d, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_hongbao", 0, 0, this.f.b, "", "", "");
      return;
    }
    ReportController.b(this.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.f.b, "", "", "");
    ReportController.b(this.d, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_special_focus", 0, 0, this.f.b, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseTroopAioMsgMultiNavigateBarDelegate
 * JD-Core Version:    0.7.0.1
 */