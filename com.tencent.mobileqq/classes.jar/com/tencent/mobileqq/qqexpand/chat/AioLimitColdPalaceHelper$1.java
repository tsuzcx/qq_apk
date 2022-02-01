package com.tencent.mobileqq.qqexpand.chat;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper.Companion;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/chat/AioLimitColdPalaceHelper$1", "Lcom/tencent/mobileqq/app/MessageObserver;", "onMessageRecordAdded", "", "list", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "onUpdateSendMsgError", "uin", "", "uinType", "", "replyCode", "sendMessageHandler", "Lcom/tencent/mobileqq/utils/SendMessageHandler;", "timeOut", "", "dbid", "errMsg", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class AioLimitColdPalaceHelper$1
  extends MessageObserver
{
  public void onMessageRecordAdded(@Nullable List<MessageRecord> paramList)
  {
    if (AioLimitColdPalaceHelper.b(this.a)) {
      return;
    }
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onMessageRecordAdded msg size is ");
      if (paramList != null) {
        localObject1 = Integer.valueOf(paramList.size());
      } else {
        localObject1 = null;
      }
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("AioLimitColdPalaceHelper", 2, ((StringBuilder)localObject2).toString());
    }
    if ((this.a.i()) && (this.a.j()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AioLimitColdPalaceHelper", 2, "onMessageRecordAdded: has insert ");
      }
      return;
    }
    if (this.a.a().ah != null)
    {
      localObject1 = this.a.a().ah;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if ((!TextUtils.isEmpty((CharSequence)((SessionInfo)localObject1).b)) && (paramList != null))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (MessageRecord)paramList.next();
          if (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isSystemMessage(((MessageRecord)localObject1).msgtype))
          {
            localObject2 = this.a.a().ah;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual(((SessionInfo)localObject2).b, ((MessageRecord)localObject1).senderuin))
            {
              localObject1 = this.a;
              ((AioLimitColdPalaceHelper)localObject1).b(((AioLimitColdPalaceHelper)localObject1).h() + 1);
              if ((this.a.i()) && (!this.a.j()) && (this.a.h() >= this.a.k())) {
                this.a.o();
              }
            }
          }
        }
      }
    }
  }
  
  protected void onUpdateSendMsgError(@Nullable String paramString1, int paramInt1, int paramInt2, @Nullable SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, @Nullable String paramString2)
  {
    paramSendMessageHandler = new StringBuilder();
    paramSendMessageHandler.append("onUpdateSendMsgError uinType=");
    paramSendMessageHandler.append(paramInt1);
    paramSendMessageHandler.append(" uin=");
    paramSendMessageHandler.append(MobileQQ.getShortUinStr(paramString1));
    QLog.d("AioLimitColdPalaceHelper", 1, paramSendMessageHandler.toString());
    if (paramInt2 == 69)
    {
      paramSendMessageHandler = ColdPalaceHelper.f;
      paramString2 = this.a.a().d;
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "mChatPie.app");
      paramSendMessageHandler = paramSendMessageHandler.a((BaseQQAppInterface)paramString2);
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      paramSendMessageHandler.a(paramString1, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.AioLimitColdPalaceHelper.1
 * JD-Core Version:    0.7.0.1
 */