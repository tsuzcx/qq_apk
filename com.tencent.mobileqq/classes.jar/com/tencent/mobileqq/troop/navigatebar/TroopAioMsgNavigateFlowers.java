package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class TroopAioMsgNavigateFlowers
  extends BaseAioMsgNavigateBarDelegate
{
  public TroopAioMsgNavigateFlowers(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 26;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.d.getMessageFacade().b(this.f.b, this.f.a, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3)))
    {
      paramObject = this.e.getString(2131895461);
      AioAgent.Message localMessage = AioAgent.Message.a(paramInt1, paramLong1, paramInt2);
      String str = paramList.senderuin;
      if (AnonymousChatHelper.c(paramList)) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
      ReportController.b(this.d, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", paramInt1, 0, this.f.b, "", "", "");
      return new BaseAioMsgNavigateBarDelegate.Entity(true, paramObject, localMessage, str);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    ReportController.b(this.d, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_gift", 0, 0, this.f.b, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (AnonymousChatHelper.a().a(this.f.b)) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    ReportController.b(this.d, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_topmsgcue", paramInt, 0, this.f.b, "", "", "");
    ReportController.b(this.d, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_gift", 0, 0, this.f.b, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateFlowers
 * JD-Core Version:    0.7.0.1
 */