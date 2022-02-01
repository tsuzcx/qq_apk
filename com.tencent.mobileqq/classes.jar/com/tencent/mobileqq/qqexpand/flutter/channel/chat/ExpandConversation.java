package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;

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
    if (paramRecentMatchChatListItem.getRecentUserType() == 1045)
    {
      localMatchedInfo.matchSrcDes = "暖说说";
    }
    else
    {
      paramRecentMatchChatListItem = BaseApplicationImpl.sApplication.getRuntime();
      if ((paramRecentMatchChatListItem instanceof QQAppInterface)) {
        paramRecentMatchChatListItem = (QQAppInterface)paramRecentMatchChatListItem;
      } else {
        paramRecentMatchChatListItem = null;
      }
      if (paramRecentMatchChatListItem != null) {
        localMatchedInfo.matchSrcDes = ExpandFriendData.getMatchSrcDes(paramRecentMatchChatListItem, localExpandConversation.peerUin);
      }
    }
    localExpandConversation.matchInfo = localMatchedInfo;
    return localExpandConversation;
  }
  
  private static String getLastMsg(RecentMatchChatListItem paramRecentMatchChatListItem)
  {
    Object localObject2 = paramRecentMatchChatListItem.mLastMsg.toString();
    int i = MsgStatusForFlutter.a(paramRecentMatchChatListItem);
    String str = "";
    if (i == 3)
    {
      localObject1 = ((String)localObject2).replaceFirst("F ", "");
    }
    else
    {
      localObject1 = localObject2;
      if (i == 2) {
        localObject1 = ((String)localObject2).replaceFirst("S ", "");
      }
    }
    Object localObject1 = ExpandEmotionHelper.a((String)localObject1);
    localObject2 = new StringBuilder();
    if (paramRecentMatchChatListItem.mMsgExtroInfo == null) {
      paramRecentMatchChatListItem = str;
    } else {
      paramRecentMatchChatListItem = paramRecentMatchChatListItem.mMsgExtroInfo;
    }
    ((StringBuilder)localObject2).append(paramRecentMatchChatListItem);
    ((StringBuilder)localObject2).append((String)localObject1);
    return ((StringBuilder)localObject2).toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExpandConversation{selfUin='");
    localStringBuilder.append(this.selfUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", peerUin='");
    localStringBuilder.append(this.peerUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isMySendMsg=");
    localStringBuilder.append(this.isMySendMsg);
    localStringBuilder.append(", uinType=");
    localStringBuilder.append(this.uinType);
    localStringBuilder.append(", msgType=");
    localStringBuilder.append(this.msgType);
    localStringBuilder.append(", msgSeq=");
    localStringBuilder.append(this.msgSeq);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", msgStatus=");
    localStringBuilder.append(this.msgStatus);
    localStringBuilder.append(", unreadNum=");
    localStringBuilder.append(this.unreadNum);
    localStringBuilder.append(", msgSummary='");
    localStringBuilder.append(this.msgSummary);
    localStringBuilder.append('\'');
    localStringBuilder.append(", matchInfo=");
    localStringBuilder.append(this.matchInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandConversation
 * JD-Core Version:    0.7.0.1
 */