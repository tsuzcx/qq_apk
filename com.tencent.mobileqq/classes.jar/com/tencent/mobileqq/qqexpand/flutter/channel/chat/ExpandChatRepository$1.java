package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ExpandChatRepository$1
  extends ExpandObserver
{
  ExpandChatRepository$1(ExpandChatRepository paramExpandChatRepository) {}
  
  protected void a(boolean paramBoolean, Card paramCard, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandChatRepository.1.2(this, paramBoolean, paramCard, paramInt));
  }
  
  protected void a(boolean paramBoolean, @NonNull List<Long> paramList1, int paramInt, List<Long> paramList2)
  {
    if (!paramBoolean)
    {
      paramList1 = new StringBuilder();
      paramList1.append("onGetExtendFriendOnlineState failed seqNum:");
      paramList1.append(paramInt);
      QLog.w("expand.chat.ExpandChatRepository", 1, paramList1.toString());
      ExpandChatRepository.a(this.a, true);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ExpandChatRepository.1.1(this, paramInt, paramList1, paramList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.1
 * JD-Core Version:    0.7.0.1
 */