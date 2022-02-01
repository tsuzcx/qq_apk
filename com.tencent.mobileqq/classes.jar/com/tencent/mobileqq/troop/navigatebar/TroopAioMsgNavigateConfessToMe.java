package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopAioMsgNavigateConfessToMe
  extends BaseTroopAioMsgMultiNavigateBarDelegate
{
  public TroopAioMsgNavigateConfessToMe(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 11;
  }
  
  @Nullable
  public BaseAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = AioAgent.Message.a(paramInt1, paramLong1, paramInt2);
    String str = this.e.getString(2131896668);
    MessageRecord localMessageRecord = this.d.getMessageFacade().d(this.f.b, this.f.a, paramLong1);
    if (localMessageRecord != null) {
      paramList = localMessageRecord.senderuin;
    } else {
      paramList = "";
    }
    paramLong3 = TroopAioMsgNavigateBar.b;
    boolean bool2 = false;
    boolean bool1;
    if ((paramLong2 != paramLong3) && (paramLong1 < paramLong2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(".troop.special_msg.confess_to_me");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("需要定位的第一条消息是否已经拉到本地：");
      if (localMessageRecord != null) {
        bool2 = true;
      }
      localStringBuilder.append(bool2);
      localStringBuilder.append(", isShow = ");
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (bool1) {
      return new BaseAioMsgNavigateBarDelegate.Entity(true, str, paramObject, paramList);
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(HardCodeUtil.a(2131912439));
    paramTextView2.setText(HardCodeUtil.a(2131912450));
    paramTextView1.setTextSize(1, 13.0F);
    paramTextView2.setTextSize(1, 13.0F);
  }
  
  public void a(int paramInt1, AioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, paramMessage, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    if (paramLong != TroopAioMsgNavigateBar.b) {
      paramString = this.d.getMessageFacade().d(this.f.b, this.f.a, paramLong);
    } else {
      paramString = null;
    }
    if (paramString != null) {
      paramTextView1.setText(HardCodeUtil.a(2131912444));
    }
    if (((paramString instanceof MessageForQQWalletMsg)) && (MessageForQQWalletMsg.isRedPacketMsg(paramString)))
    {
      paramString = (MessageForQQWalletMsg)paramString;
      if ((paramString.messageType != 7) && (paramString.messageType != 8))
      {
        paramTextView2.setText(this.e.getString(2131916248));
        paramMessage.g = true;
        return;
      }
      paramTextView2.setText(this.e.getString(2131916264));
      paramMessage.h = true;
      return;
    }
    if (paramInt2 > 0)
    {
      paramMessage.g = false;
      paramTextView2.setText(HardCodeUtil.a(2131912442));
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateConfessToMe
 * JD-Core Version:    0.7.0.1
 */