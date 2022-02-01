package com.tencent.mobileqq.nearby.gameroom.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.gameroom.IWerewolvesMsgUtilDelegate;

public class WerewolvesMsgUtilDelegateImpl
  implements IWerewolvesMsgUtilDelegate
{
  public boolean isWerewolvesMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1)
    {
      paramMessageRecord = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHotChatMng(true).c(paramMessageRecord.frienduin);
      if ((paramMessageRecord != null) && (paramMessageRecord.isGameRoom)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.impl.WerewolvesMsgUtilDelegateImpl
 * JD-Core Version:    0.7.0.1
 */