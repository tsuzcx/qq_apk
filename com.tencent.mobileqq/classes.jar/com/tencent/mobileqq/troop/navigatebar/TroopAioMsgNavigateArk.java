package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class TroopAioMsgNavigateArk
  extends BaseAioMsgNavigateBarDelegate
{
  public TroopAioMsgNavigateArk(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 20;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.d.getMessageFacade().b(this.f.b, this.f.a, paramLong1);
    if (((paramList instanceof MessageForArkApp)) && (a(paramList, paramLong2, paramLong3))) {
      return new BaseAioMsgNavigateBarDelegate.Entity(true, ArkTipsManager.a((MessageForArkApp)paramList), AioAgent.Message.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (!(paramObject instanceof AioAgent.Message)) {
      return;
    }
    paramObject = (AioAgent.Message)paramObject;
    paramObject = this.d.getMessageFacade().b(this.f.b, this.f.a, paramObject.d);
    if ((paramObject instanceof MessageForArkApp))
    {
      paramObject = ((MessageForArkApp)paramObject).ark_app_message;
      if (paramObject != null) {
        ArkAppDataReport.a(this.d, paramObject.appName, "AIOMsgRemindShow", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800AA11", "0X800AA11", 0, 0, "", "", "", "");
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateArk
 * JD-Core Version:    0.7.0.1
 */