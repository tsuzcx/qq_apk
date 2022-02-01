package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;

public class MsgStatusForFlutter
{
  public static int a(RecentMatchChatListItem paramRecentMatchChatListItem)
  {
    MsgSummary localMsgSummary = paramRecentMatchChatListItem.a();
    if (localMsgSummary.nState == 2) {
      return 3;
    }
    if (localMsgSummary.nState == 1) {
      return 2;
    }
    switch (paramRecentMatchChatListItem.mStatus)
    {
    default: 
      return 0;
    case 11: 
      return 13;
    case 10: 
      return 12;
    case 9: 
      return 11;
    case 8: 
      return 10;
    case 7: 
      return 9;
    case 6: 
      return 8;
    case 5: 
      return 7;
    case 4: 
      return 1;
    case 3: 
      return 6;
    case 2: 
      return 5;
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.MsgStatusForFlutter
 * JD-Core Version:    0.7.0.1
 */