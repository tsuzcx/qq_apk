package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class TroopAioMsgNavigateReply
  extends BaseAioMsgNavigateBarDelegate
{
  public TroopAioMsgNavigateReply(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 22;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    Object localObject = this.d.getMessageFacade().c(this.f.b, this.f.a, paramLong1);
    if ((localObject != null) && (a((MessageRecord)localObject, paramLong2, paramLong3)))
    {
      paramList = this.e.getString(2131895469);
      paramObject = AioAgent.Message.a(paramInt1, ((MessageRecord)localObject).shmsgseq, paramInt2);
      localObject = ((MessageRecord)localObject).senderuin;
      MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.f.b, null);
      return new BaseAioMsgNavigateBarDelegate.Entity(true, paramList, paramObject, (String)localObject);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.f.a == 3000) {
      paramObject = "Grp_Dis_replyMsg";
    } else {
      paramObject = "Grp_AIO";
    }
    ReportController.b(this.d, "dc00899", paramObject, "", "notice_center_new", "exp_reply", 0, 0, this.f.b, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.f.b, null);
    if (this.f.a == 3000) {
      paramObject = "Grp_Dis_replyMsg";
    } else {
      paramObject = "Grp_AIO";
    }
    ReportController.b(this.d, "dc00899", paramObject, "", "notice_center_new", "clk_reply", 0, 0, this.f.b, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateReply
 * JD-Core Version:    0.7.0.1
 */