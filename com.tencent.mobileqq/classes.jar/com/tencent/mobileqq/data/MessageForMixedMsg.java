package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;

public class MessageForMixedMsg
  extends ChatMessage
{
  private static final String TAG = "MessageForMixedMsg";
  public int forwardID;
  public AtTroopMemberInfo mAtInfo;
  public int mForwardFromIsTroop;
  public String mForwardFromUin;
  public long mForwardFromUniSeq;
  protected boolean mHasReplyText = false;
  public boolean mIsResend = false;
  public int mRichTextLength;
  public List<MessageRecord> msgElemList;
  public Object msgElemListSyncLock = new Object();
  
  public static void copyBaseInfoFromMixedToNormal(MessageRecord paramMessageRecord, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageRecord.senderuin = paramMessageForMixedMsg.senderuin;
    paramMessageRecord.selfuin = paramMessageForMixedMsg.selfuin;
    paramMessageRecord.frienduin = paramMessageForMixedMsg.frienduin;
    paramMessageRecord.time = paramMessageForMixedMsg.time;
    paramMessageRecord.issend = paramMessageForMixedMsg.issend;
    paramMessageRecord.istroop = paramMessageForMixedMsg.istroop;
    paramMessageRecord.shmsgseq = paramMessageForMixedMsg.shmsgseq;
    paramMessageRecord.uniseq = paramMessageForMixedMsg.uniseq;
    paramMessageRecord.msgseq = paramMessageForMixedMsg.msgseq;
  }
  
  public static void copyBaseInfoFromMixedToPic(MessageForPic paramMessageForPic, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForPic.senderuin = paramMessageForMixedMsg.senderuin;
    paramMessageForPic.selfuin = paramMessageForMixedMsg.selfuin;
    paramMessageForPic.frienduin = paramMessageForMixedMsg.frienduin;
    paramMessageForPic.time = paramMessageForMixedMsg.time;
    paramMessageForPic.issend = paramMessageForMixedMsg.issend;
    paramMessageForPic.istroop = paramMessageForMixedMsg.istroop;
    paramMessageForPic.shmsgseq = paramMessageForMixedMsg.shmsgseq;
    paramMessageForPic.msgtype = -2000;
    paramMessageForPic.uniseq = paramMessageForMixedMsg.uniseq;
    paramMessageForPic.msgseq = paramMessageForMixedMsg.msgseq;
  }
  
  public static String getReplySummary(MessageRecord arg0)
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    boolean bool = ??? instanceof MessageForMixedMsg;
    int j = 0;
    Object localObject2;
    int i1;
    int k;
    int i;
    Object localObject3;
    int m;
    int n;
    if (bool)
    {
      localObject2 = ((MessageForMixedMsg)???).msgElemList;
      i1 = ((List)localObject2).size();
      k = 0;
      for (i = 0; j < i1; i = n)
      {
        ??? = (MessageRecord)((List)localObject2).get(j);
        if (((??? instanceof MessageForReplyText)) && (k == 0))
        {
          localObject3 = (MessageForReplyText)???;
          if (((MessageForReplyText)localObject3).sb != null) {
            ??? = ((MessageForReplyText)localObject3).sb.toString();
          } else if (???.msg == null) {
            ??? = "";
          } else {
            ??? = ???.msg;
          }
          localStringBuilder.append(???);
          m = k;
          n = i;
          if (TextUtils.isEmpty(???)) {}
        }
        else
        {
          for (;;)
          {
            m = 1;
            n = i;
            break label287;
            if ((!(??? instanceof MessageForText)) || (k != 0)) {
              break;
            }
            localObject3 = (MessageForText)???;
            if (((MessageForText)localObject3).sb != null) {
              ??? = ((MessageForText)localObject3).sb.toString();
            } else if (???.msg == null) {
              ??? = "";
            } else {
              ??? = ???.msg;
            }
            localStringBuilder.append(???);
            m = k;
            n = i;
            if (TextUtils.isEmpty(???)) {
              break label287;
            }
            m = k;
            n = i;
            if (???.equals("\n")) {
              break label287;
            }
          }
          m = k;
          n = i;
          if ((??? instanceof MessageForPic))
          {
            m = k;
            n = i;
            if (i == 0)
            {
              localStringBuilder.append(((MessageForPic)???).getSummaryMsg());
              n = 1;
              m = k;
            }
          }
        }
        label287:
        if ((n != 0) && (m != 0)) {
          break;
        }
        j += 1;
        k = m;
      }
    }
    if ((??? instanceof MessageForLongMsg)) {
      localObject2 = (MessageForLongMsg)???;
    }
    for (;;)
    {
      synchronized (((MessageForLongMsg)localObject2).fragmentListSyncLock)
      {
        int i2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.size();
        m = 0;
        j = 0;
        i = 0;
        if (m < i2)
        {
          localObject3 = (MessageRecord)((MessageForLongMsg)localObject2).longMsgFragmentList.get(m);
          if (((localObject3 instanceof MessageForReplyText)) && (j == 0))
          {
            localStringBuilder.append(((MessageForReplyText)localObject3).msg);
            break label657;
          }
          if (((localObject3 instanceof MessageForText)) && (j == 0))
          {
            localStringBuilder.append(((MessageForText)localObject3).msg);
            break label657;
          }
          if ((localObject3 instanceof MessageForMixedMsg))
          {
            localObject3 = (MessageForMixedMsg)localObject3;
            int i3 = ((MessageForMixedMsg)localObject3).msgElemList.size();
            k = 0;
            if (k >= i3) {
              break label681;
            }
            MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(k);
            if (((localMessageRecord instanceof MessageForReplyText)) && (j == 0))
            {
              n = i;
              i1 = j;
              if (TextUtils.isEmpty(localMessageRecord.msg)) {
                break label668;
              }
              localStringBuilder.append(((MessageForReplyText)localMessageRecord).msg);
              break label662;
            }
            if (((localMessageRecord instanceof MessageForText)) && (j == 0))
            {
              localStringBuilder.append(((MessageForText)localMessageRecord).msg);
              break label662;
            }
            n = i;
            i1 = j;
            if (!(localMessageRecord instanceof MessageForPic)) {
              break label668;
            }
            n = i;
            i1 = j;
            if (i != 0) {
              break label668;
            }
            localStringBuilder.append(((MessageForPic)localMessageRecord).getSummaryMsg());
            n = 1;
            i1 = j;
            break label668;
          }
          k = j;
          if (!(localObject3 instanceof MessageForPic)) {
            break label683;
          }
          localStringBuilder.append(((MessageForPic)localObject3).getSummaryMsg());
          i = 1;
          k = j;
          break label683;
        }
      }
      return localObject1.toString();
      label657:
      k = 1;
      break label683;
      label662:
      i1 = 1;
      n = i;
      label668:
      k += 1;
      i = n;
      j = i1;
      continue;
      label681:
      k = j;
      label683:
      if ((i == 0) || (k == 0))
      {
        m += 1;
        j = k;
      }
    }
  }
  
  public static CharSequence getTextFromMixedMsg(ChatMessage arg0)
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    boolean bool = ??? instanceof MessageForMixedMsg;
    int j = 0;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (bool)
    {
      localObject2 = ((MessageForMixedMsg)???).msgElemList;
      j = ((List)localObject2).size();
      while (i < j)
      {
        ??? = (MessageRecord)((List)localObject2).get(i);
        if ((??? instanceof MessageForReplyText))
        {
          localObject3 = (MessageForReplyText)???;
          if (((MessageForReplyText)localObject3).sb != null) {
            ??? = ((MessageForReplyText)localObject3).sb.toString();
          } else if (???.msg == null) {
            ??? = "";
          } else {
            ??? = ???.msg;
          }
          localStringBuilder.append(???);
        }
        else if ((??? instanceof MessageForText))
        {
          localObject3 = (MessageForText)???;
          if (((MessageForText)localObject3).sb != null) {
            ??? = ((MessageForText)localObject3).sb.toString();
          } else if (???.msg == null) {
            ??? = "";
          } else {
            ??? = ???.msg;
          }
          localStringBuilder.append(???);
        }
        else if ((??? instanceof MessageForPic))
        {
          localStringBuilder.append(((MessageForPic)???).getSummaryMsg());
        }
        i += 1;
      }
    }
    if ((??? instanceof MessageForLongMsg)) {
      localObject2 = (MessageForLongMsg)???;
    }
    for (;;)
    {
      synchronized (((MessageForLongMsg)localObject2).fragmentListSyncLock)
      {
        int k = ((MessageForLongMsg)localObject2).longMsgFragmentList.size();
        i = 0;
        if (i < k)
        {
          localObject3 = (MessageRecord)((MessageForLongMsg)localObject2).longMsgFragmentList.get(i);
          if ((localObject3 instanceof MessageForReplyText))
          {
            localStringBuilder.append(((MessageForReplyText)localObject3).msg);
            break label707;
          }
          if ((localObject3 instanceof MessageForText))
          {
            localStringBuilder.append(((MessageForText)localObject3).msg);
            break label707;
          }
          if ((localObject3 instanceof MessageForMixedMsg))
          {
            localObject3 = (MessageForMixedMsg)localObject3;
            int m = ((MessageForMixedMsg)localObject3).msgElemList.size();
            j = 0;
            if (j >= m) {
              break label707;
            }
            MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(j);
            if ((localMessageRecord instanceof MessageForReplyText))
            {
              if (TextUtils.isEmpty(localMessageRecord.msg)) {
                break label700;
              }
              localStringBuilder.append(((MessageForReplyText)localMessageRecord).msg);
              break label700;
            }
            if ((localMessageRecord instanceof MessageForText))
            {
              localStringBuilder.append(((MessageForText)localMessageRecord).msg);
              break label700;
            }
            if (!(localMessageRecord instanceof MessageForPic)) {
              break label700;
            }
            localStringBuilder.append(((MessageForPic)localMessageRecord).getSummaryMsg());
            break label700;
          }
          if (!(localObject3 instanceof MessageForPic)) {
            break label707;
          }
          localStringBuilder.append(((MessageForPic)localObject3).getSummaryMsg());
          break label707;
        }
      }
      if ((??? instanceof MessageForStructing))
      {
        if (!QfavUtil.a(???)) {
          return "";
        }
        ??? = (MessageForStructing)???;
        if ((???.structingMsg instanceof AbsShareMsg))
        {
          ??? = (AbsShareMsg)???.structingMsg;
          if ((???.mStructMsgItemLists != null) && (???.mStructMsgItemLists.size() > 0))
          {
            ??? = (AbsStructMsgElement)???.mStructMsgItemLists.get(0);
            if ((??? != null) && ((??? instanceof AbsStructMsgItem)))
            {
              ??? = ((AbsStructMsgItem)???).ax.iterator();
              i = j;
              while (???.hasNext())
              {
                localObject2 = (AbsStructMsgElement)???.next();
                if ((localObject2 instanceof StructMsgItemTitle))
                {
                  i += 1;
                  if (i != 1)
                  {
                    if (i > 3) {
                      break;
                    }
                    localObject2 = trim(((StructMsgItemTitle)localObject2).aA.replaceFirst(":  ", ":"));
                    if (localObject1.length() != 0) {
                      localObject1.append("\r\n");
                    }
                    localObject1.append((String)localObject2);
                  }
                }
                else
                {
                  bool = localObject2 instanceof StructMsgItemSummary;
                }
              }
            }
          }
        }
      }
      return localObject1.toString();
      label700:
      j += 1;
      continue;
      label707:
      i += 1;
    }
  }
  
  public static String getTextFromMixedMsgForForwardPreview(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      List localList = ((MessageForMixedMsg)paramChatMessage).msgElemList;
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject1 = (MessageRecord)localList.get(i);
        boolean bool = localObject1 instanceof MessageForReplyText;
        paramChatMessage = "";
        Object localObject2;
        if (bool)
        {
          localObject2 = (MessageForReplyText)localObject1;
          if (((MessageForReplyText)localObject2).sb != null) {
            paramChatMessage = ((MessageForReplyText)localObject2).sb.toString();
          } else if (((MessageRecord)localObject1).msg != null) {
            paramChatMessage = ((MessageRecord)localObject1).msg;
          }
          localStringBuilder.append("[回复消息]");
          if (!TextUtils.isEmpty(paramChatMessage))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramChatMessage);
            ((StringBuilder)localObject1).append(" ");
            localStringBuilder.append(((StringBuilder)localObject1).toString());
          }
        }
        else if ((localObject1 instanceof MessageForText))
        {
          localObject2 = (MessageForText)localObject1;
          if (((MessageForText)localObject2).sb != null) {
            paramChatMessage = ((MessageForText)localObject2).sb.toString();
          } else if (((MessageRecord)localObject1).msg != null) {
            paramChatMessage = ((MessageRecord)localObject1).msg;
          }
          if (!TextUtils.isEmpty(paramChatMessage))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramChatMessage);
            ((StringBuilder)localObject1).append(" ");
            localStringBuilder.append(((StringBuilder)localObject1).toString());
          }
        }
        else if ((localObject1 instanceof MessageForPic))
        {
          localStringBuilder.append(((MessageForPic)localObject1).getSummaryMsg());
          localStringBuilder.append(" ");
        }
        i += 1;
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static CharSequence getTextFromMixedMsgForMail(ChatMessage arg0, List<String> paramList1, List<String> paramList2)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    boolean bool = ??? instanceof MessageForMixedMsg;
    int i = 0;
    Object localObject1;
    int j;
    Object localObject2;
    if (bool)
    {
      localObject1 = (MessageForMixedMsg)???;
      j = ((MessageForMixedMsg)localObject1).msgElemList.size();
      while (i < j)
      {
        ??? = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(i);
        if ((??? instanceof MessageForReplyText))
        {
          localObject2 = (MessageForReplyText)???;
          if (((MessageForReplyText)localObject2).sb != null) {
            ??? = ((MessageForReplyText)localObject2).sb.toString();
          } else {
            ??? = ???.msg;
          }
          localStringBuilder.append(???);
        }
        else if ((??? instanceof MessageForText))
        {
          localObject2 = (MessageForText)???;
          if (((MessageForText)localObject2).sb != null) {
            ??? = ((MessageForText)localObject2).sb.toString();
          } else {
            ??? = ???.msg;
          }
          localStringBuilder.append(???);
        }
        else if ((??? instanceof MessageForPic))
        {
          ??? = AIOShareActionSheet.a((MessageForPic)???, paramList1, paramList2);
          if (??? != null) {
            localStringBuilder.append(???);
          }
        }
        i += 1;
      }
    }
    if ((??? instanceof MessageForLongMsg)) {
      localObject1 = (MessageForLongMsg)???;
    }
    for (;;)
    {
      synchronized (((MessageForLongMsg)localObject1).fragmentListSyncLock)
      {
        int k = ((MessageForLongMsg)localObject1).longMsgFragmentList.size();
        i = 0;
        if (i < k)
        {
          localObject2 = (MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(i);
          if ((localObject2 instanceof MessageForReplyText))
          {
            localStringBuilder.append(((MessageForReplyText)localObject2).msg);
            break label517;
          }
          if ((localObject2 instanceof MessageForText))
          {
            localStringBuilder.append(((MessageForText)localObject2).msg);
            break label517;
          }
          if ((localObject2 instanceof MessageForMixedMsg))
          {
            localObject2 = (MessageForMixedMsg)localObject2;
            int m = ((MessageForMixedMsg)localObject2).msgElemList.size();
            j = 0;
            if (j >= m) {
              break label517;
            }
            Object localObject3 = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(j);
            if ((localObject3 instanceof MessageForReplyText))
            {
              if (TextUtils.isEmpty(((MessageRecord)localObject3).msg)) {
                break label508;
              }
              localStringBuilder.append(((MessageForReplyText)localObject3).msg);
              break label508;
            }
            if ((localObject3 instanceof MessageForText))
            {
              localStringBuilder.append(((MessageForText)localObject3).msg);
              break label508;
            }
            if (!(localObject3 instanceof MessageForPic)) {
              break label508;
            }
            localObject3 = AIOShareActionSheet.a((MessageForPic)localObject3, paramList1, paramList2);
            if (localObject3 == null) {
              break label508;
            }
            localStringBuilder.append((String)localObject3);
            break label508;
          }
          if (!(localObject2 instanceof MessageForPic)) {
            break label517;
          }
          localObject2 = AIOShareActionSheet.a((MessageForPic)localObject2, paramList1, paramList2);
          if (localObject2 == null) {
            break label517;
          }
          localStringBuilder.append((String)localObject2);
          break label517;
        }
      }
      return localStringBuilder.toString();
      label508:
      j += 1;
      continue;
      label517:
      i += 1;
    }
  }
  
  public static String trim(String paramString)
  {
    String str;
    if (paramString != null) {
      str = paramString;
    }
    try
    {
      if ("".equals(paramString)) {
        return "";
      }
      str = paramString;
      paramString = paramString.replace("\r\n", " ").replace("\n", " ");
      str = paramString;
      StringBuffer localStringBuffer = new StringBuffer(paramString);
      for (;;)
      {
        str = paramString;
        if (localStringBuffer.length() <= 0) {
          break;
        }
        str = paramString;
        if (!Character.isWhitespace(localStringBuffer.charAt(0))) {
          break;
        }
        str = paramString;
        localStringBuffer.deleteCharAt(0);
      }
      str = paramString;
      for (int i = localStringBuffer.length(); i > 0; i = localStringBuffer.length())
      {
        i -= 1;
        str = paramString;
        if (!Character.isWhitespace(localStringBuffer.charAt(i))) {
          break;
        }
        str = paramString;
        localStringBuffer.deleteCharAt(i);
        str = paramString;
      }
      str = paramString;
      paramString = localStringBuffer.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      label135:
      break label135;
    }
    break label141;
    return "";
    label141:
    paramString = new StringBuilder();
    paramString.append("TextUtils|trim|execption:");
    paramString.append(str);
    QLog.e("MessageForMixedMsg", 1, paramString.toString());
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public boolean canSelectable()
  {
    Object localObject = this.msgElemList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((MessageRecord)((Iterator)localObject).next() instanceof MessageForText))
        {
          bool = true;
          break label47;
        }
      }
    }
    boolean bool = false;
    label47:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("canSelect: ");
      ((StringBuilder)localObject).append(bool);
      QLog.e("MessageForMixedMsg", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  /* Error */
  public void doParse()
  {
    // Byte code:
    //   0: new 305	java/util/HashMap
    //   3: dup
    //   4: invokespecial 306	java/util/HashMap:<init>	()V
    //   7: astore 11
    //   9: new 305	java/util/HashMap
    //   12: dup
    //   13: invokespecial 306	java/util/HashMap:<init>	()V
    //   16: astore 12
    //   18: aload_0
    //   19: getfield 104	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   22: astore 8
    //   24: aload 8
    //   26: ifnull +138 -> 164
    //   29: aload 8
    //   31: invokeinterface 290 1 0
    //   36: astore 8
    //   38: aload 8
    //   40: invokeinterface 205 1 0
    //   45: ifeq +119 -> 164
    //   48: aload 8
    //   50: invokeinterface 209 1 0
    //   55: checkcast 46	com/tencent/mobileqq/data/MessageRecord
    //   58: astore 9
    //   60: aload 9
    //   62: instanceof 83
    //   65: ifeq -27 -> 38
    //   68: aload 9
    //   70: checkcast 83	com/tencent/mobileqq/data/MessageForPic
    //   73: astore 9
    //   75: aload 9
    //   77: getfield 309	com/tencent/mobileqq/data/MessageForPic:uuid	Ljava/lang/String;
    //   80: ifnull +38 -> 118
    //   83: aload 9
    //   85: getfield 309	com/tencent/mobileqq/data/MessageForPic:uuid	Ljava/lang/String;
    //   88: invokevirtual 310	java/lang/String:length	()I
    //   91: ifle +27 -> 118
    //   94: aload 9
    //   96: getfield 314	com/tencent/mobileqq/data/MessageForPic:richText	Ltencent/im/msg/im_msg_body$RichText;
    //   99: ifnull +19 -> 118
    //   102: aload 11
    //   104: aload 9
    //   106: getfield 309	com/tencent/mobileqq/data/MessageForPic:uuid	Ljava/lang/String;
    //   109: aload 9
    //   111: getfield 314	com/tencent/mobileqq/data/MessageForPic:richText	Ltencent/im/msg/im_msg_body$RichText;
    //   114: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: aload 9
    //   120: getfield 321	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   123: ifnull -85 -> 38
    //   126: aload 9
    //   128: getfield 321	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   131: invokevirtual 310	java/lang/String:length	()I
    //   134: ifle -96 -> 38
    //   137: aload 9
    //   139: getfield 314	com/tencent/mobileqq/data/MessageForPic:richText	Ltencent/im/msg/im_msg_body$RichText;
    //   142: ifnull -104 -> 38
    //   145: aload 12
    //   147: aload 9
    //   149: getfield 321	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   152: aload 9
    //   154: getfield 314	com/tencent/mobileqq/data/MessageForPic:richText	Ltencent/im/msg/im_msg_body$RichText;
    //   157: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: goto -123 -> 38
    //   164: new 323	localpb/richMsg/MixedMsg$Msg
    //   167: dup
    //   168: invokespecial 324	localpb/richMsg/MixedMsg$Msg:<init>	()V
    //   171: astore 10
    //   173: new 99	java/lang/StringBuilder
    //   176: dup
    //   177: bipush 32
    //   179: invokespecial 102	java/lang/StringBuilder:<init>	(I)V
    //   182: astore 13
    //   184: new 99	java/lang/StringBuilder
    //   187: dup
    //   188: bipush 32
    //   190: invokespecial 102	java/lang/StringBuilder:<init>	(I)V
    //   193: astore 14
    //   195: aload 10
    //   197: aload_0
    //   198: getfield 328	com/tencent/mobileqq/data/MessageForMixedMsg:msgData	[B
    //   201: invokevirtual 332	localpb/richMsg/MixedMsg$Msg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   204: pop
    //   205: goto +94 -> 299
    //   208: astore 8
    //   210: ldc 8
    //   212: iconst_1
    //   213: ldc_w 334
    //   216: aload 8
    //   218: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: new 99	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   228: astore 8
    //   230: aload 8
    //   232: ldc_w 339
    //   235: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 8
    //   241: aload_0
    //   242: getfield 328	com/tencent/mobileqq/data/MessageForMixedMsg:msgData	[B
    //   245: invokestatic 344	java/util/Arrays:toString	([B)Ljava/lang/String;
    //   248: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: ldc 8
    //   254: iconst_1
    //   255: aload 8
    //   257: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: new 99	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   270: astore 8
    //   272: aload 8
    //   274: ldc_w 346
    //   277: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 8
    //   283: aload_0
    //   284: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: ldc 8
    //   290: iconst_1
    //   291: aload 8
    //   293: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload 10
    //   301: getfield 353	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   304: invokevirtual 358	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   307: invokeinterface 110 1 0
    //   312: istore_3
    //   313: new 195	java/util/ArrayList
    //   316: dup
    //   317: iload_3
    //   318: invokespecial 359	java/util/ArrayList:<init>	(I)V
    //   321: astore 15
    //   323: iload_3
    //   324: ifgt +29 -> 353
    //   327: ldc 8
    //   329: iconst_1
    //   330: ldc_w 361
    //   333: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: ldc 8
    //   338: iconst_1
    //   339: aload_0
    //   340: invokevirtual 364	com/tencent/mobileqq/data/MessageForMixedMsg:getBaseInfoString	()Ljava/lang/String;
    //   343: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_0
    //   347: aload 15
    //   349: putfield 104	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   352: return
    //   353: aload_0
    //   354: ldc_w 366
    //   357: invokevirtual 369	com/tencent/mobileqq/data/MessageForMixedMsg:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   360: astore 8
    //   362: aload_0
    //   363: ldc_w 371
    //   366: invokevirtual 369	com/tencent/mobileqq/data/MessageForMixedMsg:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   369: astore 9
    //   371: aload 8
    //   373: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   376: ifne +62 -> 438
    //   379: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +40 -> 422
    //   385: new 99	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   392: astore 16
    //   394: aload 16
    //   396: ldc_w 373
    //   399: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 16
    //   405: aload 8
    //   407: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: ldc 8
    //   413: iconst_2
    //   414: aload 16
    //   416: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: new 378	org/json/JSONObject
    //   425: dup
    //   426: aload 8
    //   428: invokespecial 379	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   431: astore 8
    //   433: iconst_1
    //   434: istore_1
    //   435: goto +8 -> 443
    //   438: aconst_null
    //   439: astore 8
    //   441: iconst_0
    //   442: istore_1
    //   443: aload 9
    //   445: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   448: ifne +66 -> 514
    //   451: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq +40 -> 494
    //   457: new 99	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   464: astore 16
    //   466: aload 16
    //   468: ldc_w 381
    //   471: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 16
    //   477: aload 9
    //   479: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: ldc 8
    //   485: iconst_2
    //   486: aload 16
    //   488: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: new 378	org/json/JSONObject
    //   497: dup
    //   498: aload 9
    //   500: invokespecial 379	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   503: astore 9
    //   505: iconst_2
    //   506: istore_1
    //   507: aload 9
    //   509: astore 8
    //   511: goto +3 -> 514
    //   514: aload 8
    //   516: astore 9
    //   518: iload_1
    //   519: istore_2
    //   520: goto +32 -> 552
    //   523: astore 9
    //   525: goto +10 -> 535
    //   528: astore 9
    //   530: iconst_0
    //   531: istore_1
    //   532: aconst_null
    //   533: astore 8
    //   535: ldc 8
    //   537: iconst_1
    //   538: ldc_w 383
    //   541: aload 9
    //   543: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   546: iload_1
    //   547: istore_2
    //   548: aload 8
    //   550: astore 9
    //   552: iconst_0
    //   553: istore 4
    //   555: iconst_0
    //   556: istore_1
    //   557: iconst_1
    //   558: istore 7
    //   560: iload 4
    //   562: iload_3
    //   563: if_icmpge +865 -> 1428
    //   566: aload 10
    //   568: getfield 353	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   571: invokevirtual 358	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   574: iload 4
    //   576: invokeinterface 114 2 0
    //   581: checkcast 385	localpb/richMsg/MixedMsg$Elem
    //   584: astore 16
    //   586: aload 16
    //   588: getfield 389	localpb/richMsg/MixedMsg$Elem:sourceMsgInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   591: invokevirtual 394	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   594: ifeq +306 -> 900
    //   597: new 116	com/tencent/mobileqq/data/MessageForReplyText
    //   600: dup
    //   601: invokespecial 395	com/tencent/mobileqq/data/MessageForReplyText:<init>	()V
    //   604: astore 8
    //   606: aload 8
    //   608: aload 16
    //   610: getfield 389	localpb/richMsg/MixedMsg$Elem:sourceMsgInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   613: invokevirtual 397	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   616: invokestatic 403	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   619: invokestatic 408	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   622: checkcast 410	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo
    //   625: putfield 414	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   628: aload 16
    //   630: getfield 417	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   633: invokevirtual 394	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   636: ifeq +1097 -> 1733
    //   639: aload 8
    //   641: aload 16
    //   643: getfield 417	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   646: invokevirtual 397	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   649: putfield 164	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   652: aload 8
    //   654: getfield 164	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   657: astore 16
    //   659: aload 8
    //   661: new 419	com/tencent/mobileqq/text/QQText
    //   664: dup
    //   665: aload 16
    //   667: bipush 13
    //   669: invokestatic 423	com/tencent/mobileqq/activity/ChatTextSizeSettingActivity:a	()I
    //   672: aload_0
    //   673: invokespecial 426	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;IILjava/lang/Object;)V
    //   676: putfield 120	com/tencent/mobileqq/data/MessageForReplyText:sb	Ljava/lang/CharSequence;
    //   679: aload 8
    //   681: aload_0
    //   682: invokestatic 428	com/tencent/mobileqq/data/MessageForMixedMsg:copyBaseInfoFromMixedToNormal	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/data/MessageForMixedMsg;)V
    //   685: goto +3 -> 688
    //   688: aload 8
    //   690: getfield 414	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   693: ifnull +39 -> 732
    //   696: invokestatic 432	com/tencent/mobileqq/data/MessageForReplyText:getAppInterface	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   699: astore 16
    //   701: aload 8
    //   703: aload 8
    //   705: getfield 414	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   708: aload 16
    //   710: invokevirtual 436	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:unPackSourceMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   713: invokevirtual 440	com/tencent/mobileqq/data/MessageForReplyText:setSourceMessageRecord	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   716: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq +13 -> 732
    //   722: ldc_w 442
    //   725: iconst_2
    //   726: ldc_w 444
    //   729: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: aload 9
    //   734: ifnull +86 -> 820
    //   737: new 99	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   744: astore 16
    //   746: aload 16
    //   748: ldc 131
    //   750: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload 16
    //   756: iload 4
    //   758: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload 9
    //   764: aload 16
    //   766: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokevirtual 450	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   772: astore 16
    //   774: aload 16
    //   776: ifnull +44 -> 820
    //   779: aload 16
    //   781: invokevirtual 453	org/json/JSONArray:toString	()Ljava/lang/String;
    //   784: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   787: ifne +33 -> 820
    //   790: aload 16
    //   792: invokevirtual 453	org/json/JSONArray:toString	()Ljava/lang/String;
    //   795: invokestatic 457	com/tencent/mobileqq/data/MessageForText:getTroopMemberInfoFromExtrJson	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   798: astore 16
    //   800: aload 16
    //   802: ifnull +18 -> 820
    //   805: aload 16
    //   807: invokevirtual 458	java/util/ArrayList:size	()I
    //   810: ifle +10 -> 820
    //   813: aload 8
    //   815: aload 16
    //   817: putfield 461	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   820: aload 15
    //   822: aload 8
    //   824: invokeinterface 464 2 0
    //   829: pop
    //   830: aload 8
    //   832: getfield 164	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   835: ifnull +57 -> 892
    //   838: aload 13
    //   840: aload 8
    //   842: getfield 164	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   845: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload 14
    //   851: aload 8
    //   853: getfield 164	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   856: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: goto +32 -> 892
    //   863: astore 8
    //   865: goto +10 -> 875
    //   868: astore 8
    //   870: goto +5 -> 875
    //   873: astore 8
    //   875: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq +14 -> 892
    //   881: ldc 8
    //   883: iconst_2
    //   884: aload 8
    //   886: invokevirtual 467	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   889: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   892: aload_0
    //   893: iconst_1
    //   894: putfield 31	com/tencent/mobileqq/data/MessageForMixedMsg:mHasReplyText	Z
    //   897: goto +522 -> 1419
    //   900: aload 16
    //   902: getfield 417	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   905: invokevirtual 394	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   908: ifeq +288 -> 1196
    //   911: new 143	com/tencent/mobileqq/data/MessageForText
    //   914: dup
    //   915: invokespecial 468	com/tencent/mobileqq/data/MessageForText:<init>	()V
    //   918: astore 8
    //   920: aload 8
    //   922: aload_0
    //   923: getfield 54	com/tencent/mobileqq/data/MessageForMixedMsg:frienduin	Ljava/lang/String;
    //   926: putfield 469	com/tencent/mobileqq/data/MessageForText:frienduin	Ljava/lang/String;
    //   929: aload 8
    //   931: aload 16
    //   933: getfield 417	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   936: invokevirtual 397	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   939: putfield 165	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   942: aload 8
    //   944: aload 8
    //   946: getfield 165	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   949: invokevirtual 473	java/lang/String:getBytes	()[B
    //   952: putfield 474	com/tencent/mobileqq/data/MessageForText:msgData	[B
    //   955: aload 9
    //   957: ifnull +149 -> 1106
    //   960: iload_2
    //   961: iconst_1
    //   962: if_icmpne +72 -> 1034
    //   965: new 99	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   972: astore 16
    //   974: aload 16
    //   976: ldc 131
    //   978: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload 16
    //   984: iload 4
    //   986: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload 9
    //   992: aload 16
    //   994: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokevirtual 450	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1000: astore 16
    //   1002: aload 16
    //   1004: ifnull +102 -> 1106
    //   1007: aload 16
    //   1009: invokevirtual 453	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1012: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1015: ifne +91 -> 1106
    //   1018: sipush 3000
    //   1021: aload 16
    //   1023: invokevirtual 453	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1026: aload 8
    //   1028: invokestatic 479	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(ILjava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1031: goto +75 -> 1106
    //   1034: iload_2
    //   1035: iconst_2
    //   1036: if_icmpne +70 -> 1106
    //   1039: new 99	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1046: astore 16
    //   1048: aload 16
    //   1050: ldc 131
    //   1052: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload 16
    //   1058: iload 4
    //   1060: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload 9
    //   1066: aload 16
    //   1068: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokevirtual 450	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1074: astore 16
    //   1076: aload 16
    //   1078: ifnull +28 -> 1106
    //   1081: aload 16
    //   1083: invokevirtual 453	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1086: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1089: ifne +17 -> 1106
    //   1092: iconst_1
    //   1093: aload 16
    //   1095: invokevirtual 453	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1098: aload 8
    //   1100: invokestatic 479	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(ILjava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1103: goto +3 -> 1106
    //   1106: aload 8
    //   1108: iconst_1
    //   1109: invokevirtual 482	com/tencent/mobileqq/data/MessageForText:doParse	(Z)V
    //   1112: invokestatic 432	com/tencent/mobileqq/data/MessageForReplyText:getAppInterface	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: ldc_w 484
    //   1118: ldc_w 486
    //   1121: invokevirtual 492	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1124: checkcast 484	com/tencent/mobileqq/troop/robot/api/ITroopRobotService
    //   1127: aload 8
    //   1129: invokeinterface 495 2 0
    //   1134: aload 15
    //   1136: aload 8
    //   1138: invokeinterface 464 2 0
    //   1143: pop
    //   1144: aload 13
    //   1146: aload 8
    //   1148: getfield 165	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   1151: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload 8
    //   1157: getfield 498	com/tencent/mobileqq/data/MessageForText:msg2	Ljava/lang/String;
    //   1160: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1163: ifne +19 -> 1182
    //   1166: aload 14
    //   1168: aload 8
    //   1170: getfield 498	com/tencent/mobileqq/data/MessageForText:msg2	Ljava/lang/String;
    //   1173: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: iconst_1
    //   1178: istore_1
    //   1179: goto +240 -> 1419
    //   1182: aload 14
    //   1184: aload 8
    //   1186: getfield 165	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   1189: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: goto +226 -> 1419
    //   1196: aload 16
    //   1198: getfield 502	localpb/richMsg/MixedMsg$Elem:picMsg	Llocalpb/richMsg/RichMsg$PicRec;
    //   1201: invokevirtual 505	localpb/richMsg/RichMsg$PicRec:has	()Z
    //   1204: ifeq +206 -> 1410
    //   1207: new 83	com/tencent/mobileqq/data/MessageForPic
    //   1210: dup
    //   1211: invokespecial 506	com/tencent/mobileqq/data/MessageForPic:<init>	()V
    //   1214: astore 8
    //   1216: aload 8
    //   1218: aload 16
    //   1220: getfield 502	localpb/richMsg/MixedMsg$Elem:picMsg	Llocalpb/richMsg/RichMsg$PicRec;
    //   1223: invokevirtual 509	localpb/richMsg/RichMsg$PicRec:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1226: checkcast 504	localpb/richMsg/RichMsg$PicRec
    //   1229: invokevirtual 512	localpb/richMsg/RichMsg$PicRec:toByteArray	()[B
    //   1232: putfield 513	com/tencent/mobileqq/data/MessageForPic:msgData	[B
    //   1235: aload_0
    //   1236: getfield 66	com/tencent/mobileqq/data/MessageForMixedMsg:istroop	I
    //   1239: sipush 10014
    //   1242: if_icmpne +11 -> 1253
    //   1245: aload 8
    //   1247: sipush 10014
    //   1250: putfield 89	com/tencent/mobileqq/data/MessageForPic:istroop	I
    //   1253: aload 8
    //   1255: invokevirtual 515	com/tencent/mobileqq/data/MessageForPic:doParse	()V
    //   1258: aload 8
    //   1260: getfield 309	com/tencent/mobileqq/data/MessageForPic:uuid	Ljava/lang/String;
    //   1263: ifnull +48 -> 1311
    //   1266: aload 8
    //   1268: getfield 309	com/tencent/mobileqq/data/MessageForPic:uuid	Ljava/lang/String;
    //   1271: invokevirtual 310	java/lang/String:length	()I
    //   1274: ifle +37 -> 1311
    //   1277: aload 11
    //   1279: aload 8
    //   1281: getfield 309	com/tencent/mobileqq/data/MessageForPic:uuid	Ljava/lang/String;
    //   1284: invokevirtual 518	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1287: ifnull +24 -> 1311
    //   1290: aload 8
    //   1292: aload 11
    //   1294: aload 8
    //   1296: getfield 309	com/tencent/mobileqq/data/MessageForPic:uuid	Ljava/lang/String;
    //   1299: invokevirtual 518	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1302: checkcast 520	tencent/im/msg/im_msg_body$RichText
    //   1305: putfield 314	com/tencent/mobileqq/data/MessageForPic:richText	Ltencent/im/msg/im_msg_body$RichText;
    //   1308: goto +53 -> 1361
    //   1311: aload 8
    //   1313: getfield 321	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   1316: ifnull +45 -> 1361
    //   1319: aload 8
    //   1321: getfield 321	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   1324: invokevirtual 310	java/lang/String:length	()I
    //   1327: ifle +34 -> 1361
    //   1330: aload 12
    //   1332: aload 8
    //   1334: getfield 321	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   1337: invokevirtual 518	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1340: ifnull +21 -> 1361
    //   1343: aload 8
    //   1345: aload 12
    //   1347: aload 8
    //   1349: getfield 321	com/tencent/mobileqq/data/MessageForPic:path	Ljava/lang/String;
    //   1352: invokevirtual 518	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1355: checkcast 520	tencent/im/msg/im_msg_body$RichText
    //   1358: putfield 314	com/tencent/mobileqq/data/MessageForPic:richText	Ltencent/im/msg/im_msg_body$RichText;
    //   1361: aload 8
    //   1363: iload 4
    //   1365: putfield 523	com/tencent/mobileqq/data/MessageForPic:subMsgId	I
    //   1368: aload 8
    //   1370: aload_0
    //   1371: invokestatic 525	com/tencent/mobileqq/data/MessageForMixedMsg:copyBaseInfoFromMixedToPic	(Lcom/tencent/mobileqq/data/MessageForPic;Lcom/tencent/mobileqq/data/MessageForMixedMsg;)V
    //   1374: aload 15
    //   1376: aload 8
    //   1378: invokeinterface 464 2 0
    //   1383: pop
    //   1384: aload 8
    //   1386: invokevirtual 155	com/tencent/mobileqq/data/MessageForPic:getSummaryMsg	()Ljava/lang/String;
    //   1389: astore 8
    //   1391: aload 13
    //   1393: aload 8
    //   1395: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: aload 14
    //   1401: aload 8
    //   1403: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: pop
    //   1407: goto +12 -> 1419
    //   1410: aload 16
    //   1412: getfield 529	localpb/richMsg/MixedMsg$Elem:markfaceMsg	Llocalpb/richMsg/MarketFaceMsg$MarketFaceRec;
    //   1415: invokevirtual 532	localpb/richMsg/MarketFaceMsg$MarketFaceRec:has	()Z
    //   1418: pop
    //   1419: iload 4
    //   1421: iconst_1
    //   1422: iadd
    //   1423: istore 4
    //   1425: goto -868 -> 557
    //   1428: aload_0
    //   1429: aload 15
    //   1431: putfield 104	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   1434: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1437: ifeq +47 -> 1484
    //   1440: new 99	java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   1447: astore 8
    //   1449: aload 8
    //   1451: ldc_w 534
    //   1454: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: pop
    //   1458: aload 8
    //   1460: aload_0
    //   1461: getfield 104	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   1464: invokeinterface 110 1 0
    //   1469: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1472: pop
    //   1473: ldc 8
    //   1475: iconst_2
    //   1476: aload 8
    //   1478: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1481: invokestatic 376	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1484: aload_0
    //   1485: aload 13
    //   1487: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1490: putfield 535	com/tencent/mobileqq/data/MessageForMixedMsg:msg	Ljava/lang/String;
    //   1493: iload_1
    //   1494: ifeq +12 -> 1506
    //   1497: aload_0
    //   1498: aload 14
    //   1500: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1503: putfield 536	com/tencent/mobileqq/data/MessageForMixedMsg:msg2	Ljava/lang/String;
    //   1506: aload_0
    //   1507: ldc_w 538
    //   1510: invokevirtual 369	com/tencent/mobileqq/data/MessageForMixedMsg:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1513: astore 8
    //   1515: aload 8
    //   1517: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1520: ifne +20 -> 1540
    //   1523: aload 8
    //   1525: invokestatic 544	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   1528: istore 5
    //   1530: goto +13 -> 1543
    //   1533: astore 8
    //   1535: aload 8
    //   1537: invokevirtual 547	java/lang/Exception:printStackTrace	()V
    //   1540: iconst_1
    //   1541: istore 5
    //   1543: iload 5
    //   1545: istore 6
    //   1547: iload 5
    //   1549: ifeq +28 -> 1577
    //   1552: getstatic 553	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1555: instanceof 555
    //   1558: ifne +16 -> 1574
    //   1561: iload 5
    //   1563: istore 6
    //   1565: getstatic 553	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1568: instanceof 557
    //   1571: ifeq +6 -> 1577
    //   1574: iconst_0
    //   1575: istore 6
    //   1577: iload 6
    //   1579: ifne +4 -> 1583
    //   1582: return
    //   1583: aload_0
    //   1584: ldc_w 559
    //   1587: invokevirtual 369	com/tencent/mobileqq/data/MessageForMixedMsg:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1590: astore 8
    //   1592: aload 8
    //   1594: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1597: ifne +118 -> 1715
    //   1600: aload_0
    //   1601: ldc_w 561
    //   1604: invokevirtual 369	com/tencent/mobileqq/data/MessageForMixedMsg:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1607: astore 9
    //   1609: aload 9
    //   1611: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1614: ifne +21 -> 1635
    //   1617: aload 9
    //   1619: ldc_w 563
    //   1622: invokevirtual 566	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1625: ifeq +10 -> 1635
    //   1628: iload 7
    //   1630: istore 5
    //   1632: goto +6 -> 1638
    //   1635: iconst_0
    //   1636: istore 5
    //   1638: iload 5
    //   1640: ifne +60 -> 1700
    //   1643: aload_0
    //   1644: getfield 104	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   1647: invokeinterface 290 1 0
    //   1652: astore 9
    //   1654: aload 9
    //   1656: invokeinterface 205 1 0
    //   1661: ifeq +39 -> 1700
    //   1664: aload 9
    //   1666: invokeinterface 209 1 0
    //   1671: checkcast 46	com/tencent/mobileqq/data/MessageRecord
    //   1674: astore 10
    //   1676: aload 10
    //   1678: instanceof 143
    //   1681: ifeq -27 -> 1654
    //   1684: aload 10
    //   1686: ldc_w 568
    //   1689: aload 10
    //   1691: getfield 129	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1694: invokevirtual 572	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1697: goto -43 -> 1654
    //   1700: aload_0
    //   1701: aload_0
    //   1702: getfield 104	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   1705: iload 5
    //   1707: aload 8
    //   1709: invokestatic 403	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   1712: invokestatic 577	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/util/List;Z[B)V
    //   1715: aload_0
    //   1716: aload_0
    //   1717: ldc_w 579
    //   1720: invokevirtual 369	com/tencent/mobileqq/data/MessageForMixedMsg:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1723: invokestatic 585	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1726: putfield 588	com/tencent/mobileqq/data/MessageForMixedMsg:mRobotFlag	I
    //   1729: return
    //   1730: astore 8
    //   1732: return
    //   1733: goto -1045 -> 688
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1736	0	this	MessageForMixedMsg
    //   434	1060	1	i	int
    //   519	518	2	j	int
    //   312	252	3	k	int
    //   553	871	4	m	int
    //   1528	178	5	bool1	boolean
    //   1545	33	6	bool2	boolean
    //   558	1071	7	bool3	boolean
    //   22	27	8	localObject1	Object
    //   208	9	8	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   228	624	8	localObject2	Object
    //   863	1	8	localException1	Exception
    //   868	1	8	localException2	Exception
    //   873	12	8	localException3	Exception
    //   918	606	8	localObject3	Object
    //   1533	3	8	localException4	Exception
    //   1590	118	8	str	String
    //   1730	1	8	localException5	Exception
    //   58	459	9	localObject4	Object
    //   523	1	9	localJSONException1	org.json.JSONException
    //   528	14	9	localJSONException2	org.json.JSONException
    //   550	1115	9	localObject5	Object
    //   171	1519	10	localObject6	Object
    //   7	1286	11	localHashMap1	java.util.HashMap
    //   16	1330	12	localHashMap2	java.util.HashMap
    //   182	1304	13	localStringBuilder1	StringBuilder
    //   193	1306	14	localStringBuilder2	StringBuilder
    //   321	1109	15	localArrayList	ArrayList
    //   392	1019	16	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   195	205	208	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   443	494	523	org/json/JSONException
    //   494	505	523	org/json/JSONException
    //   371	422	528	org/json/JSONException
    //   422	433	528	org/json/JSONException
    //   659	685	863	java/lang/Exception
    //   688	732	863	java/lang/Exception
    //   737	774	863	java/lang/Exception
    //   779	800	863	java/lang/Exception
    //   805	820	863	java/lang/Exception
    //   820	860	863	java/lang/Exception
    //   606	659	868	java/lang/Exception
    //   597	606	873	java/lang/Exception
    //   1523	1530	1533	java/lang/Exception
    //   1715	1729	1730	java/lang/Exception
  }
  
  public String getContentForSearch()
  {
    try
    {
      Object localObject1 = new StringBuilder(64);
      Object localObject2 = this.msgElemList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if ((localMessageRecord instanceof MessageForPic)) {
          ((StringBuilder)localObject1).append("[图片]");
        } else if ((localMessageRecord instanceof MessageForReplyText))
        {
          if (!TextUtils.isEmpty(localMessageRecord.msg)) {
            ((StringBuilder)localObject1).append(localMessageRecord.msg);
          }
        }
        else if ((localMessageRecord instanceof MessageForText)) {
          ((StringBuilder)localObject1).append(localMessageRecord.msg);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("MessageForMixedMsg.getContentForSearch msg is ");
        ((StringBuilder)localObject2).append(MessageRecordUtil.a(((StringBuilder)localObject1).toString()));
        QLog.i("MessageForMixedMsg", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageForMixedMsg", 2, "MessageForMixedMsg.getContentForSearch failure: ", localThrowable);
      }
    }
    return null;
  }
  
  public List<MessageRecord> getPicMsgList()
  {
    Object localObject = this.msgElemList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((localMessageRecord instanceof MessageForPic)) {
          ((List)localObject).add(localMessageRecord);
        }
      }
      return localObject;
    }
    return null;
  }
  
  public MessageForReplyText getReplyMessage(QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.msgElemList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if ((localMessageRecord instanceof MessageForReplyText))
      {
        localObject = (MessageForReplyText)localMessageRecord;
        if (((MessageForReplyText)localObject).getSourceMessage() == null) {
          ReplyTextItemBuilder.a(paramQQAppInterface, this.frienduin, this.istroop, localMessageRecord, ((MessageForReplyText)localObject).mSourceMsgInfo);
        }
        return localObject;
      }
    }
    return null;
  }
  
  public MessageRecord getSubMessage(long paramLong)
  {
    List localList = this.msgElemList;
    if ((localList != null) && (paramLong >= 0L) && (paramLong < localList.size())) {
      return (MessageRecord)this.msgElemList.get((int)paramLong);
    }
    return null;
  }
  
  public String getSummaryMsg()
  {
    return getTextFromMixedMsg(this).toString();
  }
  
  public boolean hasReplyText()
  {
    return this.mHasReplyText;
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.n(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void parse()
  {
    super.parse();
    Iterator localIterator = this.msgElemList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      StringBuilder localStringBuilder;
      if (((localMessageRecord instanceof MessageForPic)) && (localMessageRecord.uniseq != this.uniseq))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" Error : Info not Equals : child : ");
          localStringBuilder.append(localMessageRecord.uniseq);
          localStringBuilder.append(" parent:");
          localStringBuilder.append(this.uniseq);
          QLog.d("MessageForMixedMsg", 2, localStringBuilder.toString());
        }
        copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, this);
      }
      if (((localMessageRecord instanceof MessageForReplyText)) && (localMessageRecord.uniseq != this.uniseq))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" Error : Info not Equals : child : ");
          localStringBuilder.append(localMessageRecord.uniseq);
          localStringBuilder.append(" parent:");
          localStringBuilder.append(this.uniseq);
          QLog.d("MessageForMixedMsg", 2, localStringBuilder.toString());
        }
        copyBaseInfoFromMixedToNormal(localMessageRecord, this);
      }
    }
  }
  
  protected void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  public void prewrite()
  {
    Object localObject1 = this.msgElemList;
    if ((localObject1 != null) && (((List)localObject1).size() >= 1))
    {
      MixedMsg.Msg localMsg = new MixedMsg.Msg();
      Iterator localIterator = this.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        MixedMsg.Elem localElem = new MixedMsg.Elem();
        Object localObject2;
        if ((localObject3 instanceof MessageForText))
        {
          localObject2 = getExtInfoFromExtStr("sens_msg_original_text");
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = ((MessageForText)localObject3).msg;
          }
          localElem.textMsg.set((String)localObject1);
        }
        else if ((localObject3 instanceof MessageForPic))
        {
          localElem.picMsg.set(((MessageForPic)localObject3).getSerialPB());
        }
        else if ((localObject3 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForReplyText)localObject3;
          if (!TextUtils.isEmpty(((MessageForReplyText)localObject1).msg)) {
            localElem.textMsg.set(((MessageForReplyText)localObject1).msg);
          }
          try
          {
            if (((MessageForReplyText)localObject1).mSourceMsgInfo != null) {
              ((MessageForReplyText)localObject1).mSourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), ((MessageForReplyText)localObject1).getSourceMessage());
            }
            localObject1 = MessagePkgUtils.a(((MessageForReplyText)localObject1).mSourceMsgInfo);
            localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject1));
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("MessagePkgUtils.getBytesFromObject get Exception:");
              ((StringBuilder)localObject2).append(localException.getMessage());
              QLog.i("MessageForMixedMsg", 2, ((StringBuilder)localObject2).toString());
            }
          }
          this.mHasReplyText = true;
        }
        else if ((localObject3 instanceof MessageForMarketFace))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("prewrite err unSupported");
          localStringBuilder.append(localObject3);
          QLog.e("MessageForMixedMsg", 1, localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("prewrite err unSupported");
          localStringBuilder.append(localObject3);
          QLog.e("MessageForMixedMsg", 1, localStringBuilder.toString());
        }
        localMsg.elems.get().add(localElem);
      }
      this.msgData = localMsg.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mRobotFlag);
      localStringBuilder.append("");
      saveExtInfoToExtStr("is_to_robot", localStringBuilder.toString());
      return;
    }
    QLog.e("MessageForMixedMsg", 1, "prewrite err null elemList");
  }
  
  public MessageRecord rebuildMixedMsg()
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    synchronized (this.msgElemListSyncLock)
    {
      Iterator localIterator1 = this.msgElemList.iterator();
      while (localIterator1.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
        if ((localMessageRecord instanceof MessageForText))
        {
          localArrayList2.add(localMessageRecord);
        }
        else if ((localMessageRecord instanceof MessageForPic))
        {
          if (!localArrayList2.isEmpty())
          {
            Iterator localIterator2 = localArrayList2.iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (MessageRecord)localIterator2.next();
              if (((MessageRecord)localObject1).msg == null) {
                localObject1 = "";
              } else {
                localObject1 = ((MessageRecord)localObject1).msg;
              }
              localStringBuffer.append((String)localObject1);
            }
            localObject1 = (MessageForText)MessageRecordFactory.a(-1000);
            ((MessageForText)localObject1).msgtype = -1000;
            ((MessageForText)localObject1).msg = localStringBuffer.toString();
            localStringBuffer.delete(0, localStringBuffer.length());
            localArrayList1.add(localObject1);
            localArrayList2.clear();
          }
          localArrayList1.add((MessageForPic)localMessageRecord.deepCopyByReflect());
        }
        else if ((localMessageRecord instanceof MessageForReplyText))
        {
          localObject1 = (MessageForReplyText)localMessageRecord.deepCopyByReflect();
          if (((MessageForReplyText)localMessageRecord).getSourceMessage() != null) {
            ((MessageForReplyText)localObject1).deepCopySourceMsg((MessageForReplyText)localMessageRecord);
          }
          localArrayList1.add(localObject1);
        }
      }
      if (!localArrayList2.isEmpty())
      {
        ??? = localArrayList2.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject1 = (MessageRecord)((Iterator)???).next();
          if (((MessageRecord)localObject1).msg == null) {
            localObject1 = "";
          } else {
            localObject1 = ((MessageRecord)localObject1).msg;
          }
          localStringBuffer.append((String)localObject1);
        }
        localObject1 = (MessageForText)MessageRecordFactory.a(-1000);
        ((MessageForText)localObject1).msgtype = -1000;
        ((MessageForText)localObject1).msg = localStringBuffer.toString();
        localStringBuffer.delete(0, localStringBuffer.length());
        localArrayList1.add(localObject1);
        localArrayList2.clear();
      }
      Object localObject1 = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
      copyMessageRecordBaseField((MessageRecord)localObject1, this);
      ((MessageForMixedMsg)localObject1).msgtype = -1035;
      ((MessageForMixedMsg)localObject1).msgElemList = localArrayList1;
      ((MessageForMixedMsg)localObject1).prewrite();
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public byte[] upateMessageForPic(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      return this.msgData;
    }
    if (this.msgElemList == null) {
      return this.msgData;
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    Iterator localIterator = this.msgElemList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject4 = localIterator.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      Object localObject3;
      if ((localObject4 instanceof MessageForReplyText))
      {
        localObject3 = getExtInfoFromExtStr("sens_msg_original_text");
        localObject4 = (MessageForReplyText)localObject4;
        Object localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = ((MessageForReplyText)localObject4).msg;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localElem.textMsg.set((String)localObject1);
        }
        try
        {
          if (((MessageForReplyText)localObject4).mSourceMsgInfo != null) {
            ((MessageForReplyText)localObject4).mSourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), ((MessageForReplyText)localObject4).getSourceMessage());
          }
          localObject1 = MessagePkgUtils.a(((MessageForReplyText)localObject4).mSourceMsgInfo);
          localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject1));
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label360;
          }
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("MessagePkgUtils.getBytesFromObject get Exception:");
        ((StringBuilder)localObject3).append(localException.getMessage());
        QLog.i("MessageForMixedMsg", 2, ((StringBuilder)localObject3).toString());
      }
      else
      {
        Object localObject2;
        if ((localObject4 instanceof MessageForText))
        {
          localObject3 = getExtInfoFromExtStr("sens_msg_original_text");
          localObject2 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject2 = ((MessageForText)localObject4).msg;
          }
          localElem.textMsg.set((String)localObject2);
        }
        else if ((localObject4 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject4;
          if ((((MessageForPic)localObject2).uniseq == paramMessageForPic.uniseq) && (((MessageForPic)localObject2).subMsgId == paramMessageForPic.subMsgId)) {
            localElem.picMsg.set(paramMessageForPic.getSerialPB());
          } else {
            localElem.picMsg.set(((MessageForPic)localObject2).getSerialPB());
          }
        }
        else
        {
          boolean bool = localObject4 instanceof MessageForMarketFace;
        }
      }
      label360:
      localMsg.elems.get().add(localElem);
    }
    this.msgData = localMsg.toByteArray();
    if (QLog.isColorLevel())
    {
      paramMessageForPic = new StringBuilder();
      paramMessageForPic.append("upateMessageForPic");
      int i;
      if (this.msgData == null) {
        i = 0;
      } else {
        i = this.msgData.length;
      }
      paramMessageForPic.append(i);
      QLog.i("MessageForMixedMsg", 2, paramMessageForPic.toString());
    }
    return this.msgData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMixedMsg
 * JD-Core Version:    0.7.0.1
 */