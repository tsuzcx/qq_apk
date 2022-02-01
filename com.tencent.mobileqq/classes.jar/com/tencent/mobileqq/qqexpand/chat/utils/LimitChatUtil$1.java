package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

final class LimitChatUtil$1
  implements Comparator<MessageRecord>
{
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil.1
 * JD-Core Version:    0.7.0.1
 */