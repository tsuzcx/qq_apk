package com.tencent.mobileqq.flutter.channel.expand.chat;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ExpandChatRepository$3
  extends ExtendFriendObserver
{
  ExpandChatRepository$3(ExpandChatRepository paramExpandChatRepository) {}
  
  public void onGetExtendFriendInfo(boolean paramBoolean, Card paramCard, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandChatRepository.3.2(this, paramBoolean, paramCard, paramInt));
  }
  
  public void onGetExtendFriendOnlineState(boolean paramBoolean, @NonNull List<Long> paramList1, int paramInt, List<Long> paramList2)
  {
    if (!paramBoolean)
    {
      QLog.w("expand.chat.ExpandChatRepository", 1, "onGetExtendFriendOnlineState failed seqNum:" + paramInt);
      ExpandChatRepository.a(this.a, true);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ExpandChatRepository.3.1(this, paramInt, paramList1, paramList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.3
 * JD-Core Version:    0.7.0.1
 */