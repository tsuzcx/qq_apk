package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class TroopAioMsgNavigateAtMe
  extends BaseAioMsgNavigateBarDelegate
{
  public TroopAioMsgNavigateAtMe(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 23;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.d.getMessageFacade().b(this.f.b, this.f.a, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      return new BaseAioMsgNavigateBarDelegate.Entity(true, this.e.getString(2131895022), AioAgent.Message.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    ReportController.b(this.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atme", 0, 0, this.f.b, "", "", "");
    ReportController.b(this.d, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at", 0, 0, this.f.b, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    ReportController.b(this.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atme", 0, 0, this.f.b, "", "", "");
    ReportController.b(this.d, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at", 0, 0, this.f.b, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateAtMe
 * JD-Core Version:    0.7.0.1
 */