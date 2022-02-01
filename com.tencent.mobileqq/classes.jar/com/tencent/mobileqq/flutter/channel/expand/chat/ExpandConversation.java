package com.tencent.mobileqq.flutter.channel.expand.chat;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.ExpandFriendData;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.qphone.base.util.QLog;

public class ExpandConversation
{
  public boolean isMySendMsg;
  public MatchedInfo matchInfo;
  public long msgSeq;
  public int msgStatus;
  public String msgSummary;
  public int msgType;
  public String nickName;
  public String peerUin;
  public String selfUin;
  public long time;
  public int uinType;
  public int unreadNum;
  
  public static ExpandConversation convert2Con(RecentMatchChatListItem paramRecentMatchChatListItem)
  {
    ExpandConversation localExpandConversation = new ExpandConversation();
    localExpandConversation.peerUin = paramRecentMatchChatListItem.getRecentUserUin();
    localExpandConversation.uinType = paramRecentMatchChatListItem.getRecentUserType();
    localExpandConversation.nickName = paramRecentMatchChatListItem.mTitleName;
    localExpandConversation.unreadNum = paramRecentMatchChatListItem.mUnreadNum;
    localExpandConversation.msgType = paramRecentMatchChatListItem.messageRecord.msgtype;
    localExpandConversation.time = paramRecentMatchChatListItem.getLastMsgTime();
    localExpandConversation.msgStatus = MsgStatusForFlutter.a(paramRecentMatchChatListItem);
    localExpandConversation.isMySendMsg = paramRecentMatchChatListItem.messageRecord.isSelf();
    localExpandConversation.msgSeq = paramRecentMatchChatListItem.messageRecord.msgseq;
    localExpandConversation.msgSummary = getLastMsg(paramRecentMatchChatListItem);
    MatchedInfo localMatchedInfo = new MatchedInfo();
    if (paramRecentMatchChatListItem.getRecentUserType() == 1045) {
      localMatchedInfo.matchSrcDes = "暖说说";
    }
    for (;;)
    {
      localExpandConversation.matchInfo = localMatchedInfo;
      return localExpandConversation;
      paramRecentMatchChatListItem = ExtendFriendManager.a();
      if (paramRecentMatchChatListItem != null) {
        try
        {
          localMatchedInfo.matchSrcDes = ((String)ExpandFriendData.getAttribute(paramRecentMatchChatListItem, localExpandConversation.peerUin, -1));
        }
        catch (Exception paramRecentMatchChatListItem)
        {
          localMatchedInfo.matchSrcDes = "";
          QLog.w("ExpandConversation", 1, "convert2Con get matchSrcDes error" + paramRecentMatchChatListItem);
        }
      }
    }
  }
  
  private static String getLastMsg(RecentMatchChatListItem paramRecentMatchChatListItem)
  {
    Object localObject2 = paramRecentMatchChatListItem.mLastMsg.toString();
    int i = MsgStatusForFlutter.a(paramRecentMatchChatListItem);
    Object localObject1;
    if (i == 3)
    {
      localObject1 = ((String)localObject2).replaceFirst("F ", "");
      localObject1 = ExpandEmotionHelper.a((String)localObject1);
      localObject2 = new StringBuilder();
      if (paramRecentMatchChatListItem.mMsgExtroInfo != null) {
        break label84;
      }
    }
    label84:
    for (paramRecentMatchChatListItem = "";; paramRecentMatchChatListItem = paramRecentMatchChatListItem.mMsgExtroInfo)
    {
      return paramRecentMatchChatListItem + (String)localObject1;
      localObject1 = localObject2;
      if (i != 2) {
        break;
      }
      localObject1 = ((String)localObject2).replaceFirst("S ", "");
      break;
    }
  }
  
  public String toString()
  {
    return "ExpandConversation{selfUin='" + this.selfUin + '\'' + ", peerUin='" + this.peerUin + '\'' + ", nickName='" + this.nickName + '\'' + ", isMySendMsg=" + this.isMySendMsg + ", uinType=" + this.uinType + ", msgType=" + this.msgType + ", msgSeq=" + this.msgSeq + ", time=" + this.time + ", msgStatus=" + this.msgStatus + ", unreadNum=" + this.unreadNum + ", msgSummary='" + this.msgSummary + '\'' + ", matchInfo=" + this.matchInfo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandConversation
 * JD-Core Version:    0.7.0.1
 */