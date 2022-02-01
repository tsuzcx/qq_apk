package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;

public class WerewolvesMsgUtil
{
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1)
    {
      paramMessageRecord = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHotChatMng(true).a(paramMessageRecord.frienduin);
      if ((paramMessageRecord != null) && (paramMessageRecord.isGameRoom)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesMsgUtil
 * JD-Core Version:    0.7.0.1
 */