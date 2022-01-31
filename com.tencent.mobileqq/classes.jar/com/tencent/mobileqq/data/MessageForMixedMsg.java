package com.tencent.mobileqq.data;

import adyf;
import akpx;
import akwa;
import android.text.TextUtils;
import asoj;
import axas;
import axup;
import axuq;
import axzj;
import aykk;
import bafv;
import bamk;
import bbbr;
import bcxb;
import bgqm;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MarketFaceMsg.MarketFaceRec;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.RichText;

public class MessageForMixedMsg
  extends ChatMessage
{
  private static final String TAG = "MessageForMixedMsg";
  public int forwardID;
  public MessageForText.AtTroopMemberInfo mAtInfo;
  public int mForwardFromIsTroop;
  public String mForwardFromUin;
  public long mForwardFromUniSeq;
  protected boolean mHasReplyText;
  public boolean mIsResend;
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
    int m = 0;
    StringBuilder localStringBuilder = new StringBuilder(32);
    Object localObject2;
    int n;
    int i;
    int j;
    Object localObject3;
    if ((??? instanceof MessageForMixedMsg))
    {
      localObject2 = ((MessageForMixedMsg)???).msgElemList;
      n = ((List)localObject2).size();
      i = 0;
      j = 0;
      if (m < n)
      {
        ??? = (MessageRecord)((List)localObject2).get(m);
        if ((!(??? instanceof MessageForReplyText)) || (j != 0)) {
          break label150;
        }
        localObject3 = (MessageForReplyText)???;
        if (((MessageForReplyText)localObject3).sb == null) {
          break label129;
        }
        ??? = ((MessageForReplyText)localObject3).sb.toString();
        label99:
        localStringBuilder.append(???);
        if (TextUtils.isEmpty(???)) {
          break label641;
        }
        j = 1;
        label115:
        if ((i == 0) || (j == 0)) {
          break label270;
        }
      }
    }
    label129:
    label150:
    int k;
    for (;;)
    {
      return localStringBuilder.toString();
      if (???.msg == null)
      {
        ??? = "";
        break label99;
      }
      ??? = ???.msg;
      break label99;
      if (((??? instanceof MessageForText)) && (j == 0))
      {
        localObject3 = (MessageForText)???;
        if (((MessageForText)localObject3).sb != null) {
          ??? = ((MessageForText)localObject3).sb.toString();
        }
        for (;;)
        {
          localStringBuilder.append(???);
          k = j;
          if (!TextUtils.isEmpty(???))
          {
            k = j;
            if (!???.equals("\n")) {
              k = 1;
            }
          }
          j = k;
          break;
          if (???.msg == null) {
            ??? = "";
          } else {
            ??? = ???.msg;
          }
        }
      }
      if ((!(??? instanceof MessageForPic)) || (i != 0)) {
        break label638;
      }
      localStringBuilder.append(((MessageForPic)???).getSummaryMsg());
      i = 1;
      break label115;
      label270:
      m += 1;
      break;
      if ((??? instanceof MessageForLongMsg))
      {
        localObject2 = (MessageForLongMsg)???;
        label319:
        label377:
        synchronized (((MessageForLongMsg)localObject2).fragmentListSyncLock)
        {
          int i2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.size();
          n = 0;
          i = 0;
          j = 0;
          if (n < i2)
          {
            localObject3 = (MessageRecord)((MessageForLongMsg)localObject2).longMsgFragmentList.get(n);
            if ((!(localObject3 instanceof MessageForReplyText)) || (j != 0)) {
              break label389;
            }
            localStringBuilder.append(((MessageForReplyText)localObject3).msg);
            k = 1;
            m = i;
            break label644;
          }
        }
      }
    }
    label389:
    int i3;
    int i1;
    if (((localObject3 instanceof MessageForText)) && (j == 0))
    {
      localObject1.append(((MessageForText)localObject3).msg);
      k = 1;
      m = i;
    }
    else if ((localObject3 instanceof MessageForMixedMsg))
    {
      localObject3 = (MessageForMixedMsg)localObject3;
      i3 = ((MessageForMixedMsg)localObject3).msgElemList.size();
      i1 = 0;
    }
    for (;;)
    {
      m = i;
      k = j;
      if (i1 < i3)
      {
        MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(i1);
        if (((localMessageRecord instanceof MessageForReplyText)) && (j == 0))
        {
          if (!TextUtils.isEmpty(localMessageRecord.msg))
          {
            localObject1.append(((MessageForReplyText)localMessageRecord).msg);
            j = 1;
            break label656;
          }
        }
        else
        {
          if (((localMessageRecord instanceof MessageForText)) && (j == 0))
          {
            localObject1.append(((MessageForText)localMessageRecord).msg);
            j = 1;
            break label656;
          }
          if (((localMessageRecord instanceof MessageForPic)) && (i == 0))
          {
            localObject1.append(((MessageForPic)localMessageRecord).getSummaryMsg());
            i = 1;
            break label656;
            m = i;
            k = j;
            if (!(localObject3 instanceof MessageForPic)) {
              break label644;
            }
            localObject1.append(((MessageForPic)localObject3).getSummaryMsg());
            m = 1;
            k = j;
          }
        }
      }
      label638:
      while ((m == 0) || (k == 0))
      {
        n += 1;
        i = m;
        j = k;
        break label319;
        break label656;
        break;
        break;
      }
      label641:
      label644:
      break label377;
      label656:
      i1 += 1;
    }
  }
  
  public static CharSequence getTextFromMixedMsg(ChatMessage arg0)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(32);
    Object localObject2;
    int j;
    Object localObject3;
    label86:
    int m;
    if ((??? instanceof MessageForMixedMsg))
    {
      localObject2 = ((MessageForMixedMsg)???).msgElemList;
      j = ((List)localObject2).size();
      if (i < j)
      {
        ??? = (MessageRecord)((List)localObject2).get(i);
        if ((??? instanceof MessageForReplyText))
        {
          localObject3 = (MessageForReplyText)???;
          if (((MessageForReplyText)localObject3).sb != null)
          {
            ??? = ((MessageForReplyText)localObject3).sb.toString();
            localStringBuilder.append(???);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (???.msg == null)
          {
            ??? = "";
            break label86;
          }
          ??? = ???.msg;
          break label86;
          if ((??? instanceof MessageForText))
          {
            localObject3 = (MessageForText)???;
            if (((MessageForText)localObject3).sb != null) {
              ??? = ((MessageForText)localObject3).sb.toString();
            }
            for (;;)
            {
              localStringBuilder.append(???);
              break;
              if (???.msg == null) {
                ??? = "";
              } else {
                ??? = ???.msg;
              }
            }
          }
          if ((??? instanceof MessageForPic)) {
            localStringBuilder.append(((MessageForPic)???).getSummaryMsg());
          }
        }
      }
    }
    else
    {
      if (!(??? instanceof MessageForLongMsg)) {
        break label489;
      }
      localObject2 = (MessageForLongMsg)???;
      synchronized (((MessageForLongMsg)localObject2).fragmentListSyncLock)
      {
        int k = ((MessageForLongMsg)localObject2).longMsgFragmentList.size();
        i = 0;
        if (i >= k) {
          break label481;
        }
        localObject3 = (MessageRecord)((MessageForLongMsg)localObject2).longMsgFragmentList.get(i);
        if ((localObject3 instanceof MessageForReplyText)) {
          localStringBuilder.append(((MessageForReplyText)localObject3).msg);
        } else if ((localObject3 instanceof MessageForText)) {
          localStringBuilder.append(((MessageForText)localObject3).msg);
        }
      }
      if ((localObject3 instanceof MessageForMixedMsg))
      {
        localObject3 = (MessageForMixedMsg)localObject3;
        m = ((MessageForMixedMsg)localObject3).msgElemList.size();
        j = 0;
      }
    }
    for (;;)
    {
      if (j < m)
      {
        MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(j);
        if ((localMessageRecord instanceof MessageForReplyText))
        {
          if (TextUtils.isEmpty(localMessageRecord.msg)) {
            break label697;
          }
          localObject1.append(((MessageForReplyText)localMessageRecord).msg);
          break label697;
        }
        if ((localMessageRecord instanceof MessageForText))
        {
          localObject1.append(((MessageForText)localMessageRecord).msg);
          break label697;
        }
        if (!(localMessageRecord instanceof MessageForPic)) {
          break label697;
        }
        localObject1.append(((MessageForPic)localMessageRecord).getSummaryMsg());
        break label697;
        if ((localObject3 instanceof MessageForPic))
        {
          localObject1.append(((MessageForPic)localObject3).getSummaryMsg());
          break label690;
          label481:
          label489:
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return localObject1.toString();
                  } while (!(??? instanceof MessageForStructing));
                  if (!bgqm.a(???)) {
                    return "";
                  }
                  ??? = (MessageForStructing)???;
                } while (!(???.structingMsg instanceof AbsShareMsg));
                ??? = (AbsShareMsg)???.structingMsg;
              } while ((???.mStructMsgItemLists == null) || (???.mStructMsgItemLists.size() <= 0));
              ??? = (axup)???.mStructMsgItemLists.get(0);
            } while ((??? == null) || (!(??? instanceof axuq)));
            ??? = ((axuq)???).a.iterator();
            i = 0;
            do
            {
              if (!???.hasNext()) {
                break;
              }
              localObject2 = (axup)???.next();
              if (!(localObject2 instanceof StructMsgItemTitle)) {
                break label679;
              }
              j = i + 1;
              i = j;
            } while (j == 1);
          } while (j > 3);
          label586:
          localObject2 = trim(((StructMsgItemTitle)localObject2).Y.replaceFirst(":  ", ":"));
          if (localObject1.length() != 0) {
            localObject1.append("\r\n");
          }
          localObject1.append((String)localObject2);
          i = j;
          for (;;)
          {
            break label586;
            break;
            label679:
            if (!(localObject2 instanceof axzj)) {}
          }
        }
      }
      label690:
      i += 1;
      break;
      label697:
      j += 1;
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
      if (i < j)
      {
        paramChatMessage = (MessageRecord)localList.get(i);
        Object localObject;
        if ((paramChatMessage instanceof MessageForReplyText))
        {
          localObject = (MessageForReplyText)paramChatMessage;
          if (((MessageForReplyText)localObject).sb != null)
          {
            paramChatMessage = ((MessageForReplyText)localObject).sb.toString();
            label85:
            localStringBuilder.append("[回复消息]");
            if (!TextUtils.isEmpty(paramChatMessage)) {
              localStringBuilder.append(paramChatMessage + " ");
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramChatMessage.msg == null)
          {
            paramChatMessage = "";
            break label85;
          }
          paramChatMessage = paramChatMessage.msg;
          break label85;
          if ((paramChatMessage instanceof MessageForText))
          {
            localObject = (MessageForText)paramChatMessage;
            if (((MessageForText)localObject).sb != null) {
              paramChatMessage = ((MessageForText)localObject).sb.toString();
            }
            for (;;)
            {
              if (TextUtils.isEmpty(paramChatMessage)) {
                break label236;
              }
              localStringBuilder.append(paramChatMessage + " ");
              break;
              if (paramChatMessage.msg == null) {
                paramChatMessage = "";
              } else {
                paramChatMessage = paramChatMessage.msg;
              }
            }
          }
          else
          {
            label236:
            if ((paramChatMessage instanceof MessageForPic)) {
              localStringBuilder.append(((MessageForPic)paramChatMessage).getSummaryMsg()).append(" ");
            }
          }
        }
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static CharSequence getTextFromMixedMsgForMail(ChatMessage arg0, List<String> paramList1, List<String> paramList2)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject1;
    int j;
    Object localObject2;
    label91:
    int m;
    if ((??? instanceof MessageForMixedMsg))
    {
      localObject1 = (MessageForMixedMsg)???;
      j = ((MessageForMixedMsg)localObject1).msgElemList.size();
      if (i < j)
      {
        ??? = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(i);
        if ((??? instanceof MessageForReplyText))
        {
          localObject2 = (MessageForReplyText)???;
          if (((MessageForReplyText)localObject2).sb != null)
          {
            ??? = ((MessageForReplyText)localObject2).sb.toString();
            localStringBuilder.append(???);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          ??? = ???.msg;
          break label91;
          if ((??? instanceof MessageForText))
          {
            localObject2 = (MessageForText)???;
            if (((MessageForText)localObject2).sb != null) {}
            for (??? = ((MessageForText)localObject2).sb.toString();; ??? = ???.msg)
            {
              localStringBuilder.append(???);
              break;
            }
          }
          if ((??? instanceof MessageForPic))
          {
            ??? = asoj.a((MessageForPic)???, paramList1, paramList2);
            if (??? != null) {
              localStringBuilder.append(???);
            }
          }
        }
      }
    }
    else if ((??? instanceof MessageForLongMsg))
    {
      localObject1 = (MessageForLongMsg)???;
      synchronized (((MessageForLongMsg)localObject1).fragmentListSyncLock)
      {
        int k = ((MessageForLongMsg)localObject1).longMsgFragmentList.size();
        i = 0;
        if (i >= k) {
          break label493;
        }
        localObject2 = (MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(i);
        if ((localObject2 instanceof MessageForReplyText)) {
          localStringBuilder.append(((MessageForReplyText)localObject2).msg);
        } else if ((localObject2 instanceof MessageForText)) {
          localStringBuilder.append(((MessageForText)localObject2).msg);
        }
      }
      if ((localObject2 instanceof MessageForMixedMsg))
      {
        localObject2 = (MessageForMixedMsg)localObject2;
        m = ((MessageForMixedMsg)localObject2).msgElemList.size();
        j = 0;
      }
    }
    for (;;)
    {
      if (j < m)
      {
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
        localObject3 = asoj.a((MessageForPic)localObject3, paramList1, paramList2);
        if (localObject3 == null) {
          break label508;
        }
        localStringBuilder.append((String)localObject3);
        break label508;
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = asoj.a((MessageForPic)localObject2, paramList1, paramList2);
          if (localObject2 != null)
          {
            localStringBuilder.append((String)localObject2);
            break label501;
            label493:
            return localStringBuilder.toString();
          }
        }
      }
      label501:
      i += 1;
      break;
      label508:
      j += 1;
    }
  }
  
  public static String trim(String paramString)
  {
    if (paramString != null)
    {
      String str = paramString;
      StringBuffer localStringBuffer;
      try
      {
        if ("".equals(paramString)) {
          break label171;
        }
        str = paramString;
        paramString = paramString.replace("\r\n", " ").replace("\n", " ");
        str = paramString;
        localStringBuffer = new StringBuffer(paramString);
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
        return "";
      }
      catch (Exception paramString)
      {
        QLog.e("MessageForMixedMsg", 1, "TextUtils|trim|execption:" + str);
        paramString = str;
        if (str != null) {
          return paramString;
        }
      }
      str = paramString;
      for (int i = localStringBuffer.length(); i > 0; i = localStringBuffer.length())
      {
        str = paramString;
        if (!Character.isWhitespace(localStringBuffer.charAt(i - 1))) {
          break;
        }
        str = paramString;
        localStringBuffer.deleteCharAt(i - 1);
        str = paramString;
      }
      str = paramString;
      paramString = localStringBuffer.toString();
      return paramString;
    }
    label171:
    paramString = "";
    return paramString;
  }
  
  public boolean canSelectable()
  {
    if (this.msgElemList != null)
    {
      Iterator localIterator = this.msgElemList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((MessageRecord)localIterator.next() instanceof MessageForText));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageForMixedMsg", 2, "canSelect: " + bool);
      }
      return bool;
    }
  }
  
  public void doParse()
  {
    Object localObject5 = new HashMap();
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.msgElemList;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject3 instanceof MessageForPic))
        {
          localObject3 = (MessageForPic)localObject3;
          if ((((MessageForPic)localObject3).uuid != null) && (((MessageForPic)localObject3).uuid.length() > 0) && (((MessageForPic)localObject3).richText != null)) {
            ((HashMap)localObject5).put(((MessageForPic)localObject3).uuid, ((MessageForPic)localObject3).richText);
          }
          if ((((MessageForPic)localObject3).path != null) && (((MessageForPic)localObject3).path.length() > 0) && (((MessageForPic)localObject3).richText != null)) {
            localHashMap.put(((MessageForPic)localObject3).path, ((MessageForPic)localObject3).richText);
          }
        }
      }
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    StringBuilder localStringBuilder1 = new StringBuilder(32);
    StringBuilder localStringBuilder2 = new StringBuilder(32);
    for (;;)
    {
      int n;
      ArrayList localArrayList;
      int i;
      Object localObject6;
      Object localObject2;
      try
      {
        localMsg.mergeFrom(this.msgData);
        n = localMsg.elems.get().size();
        localArrayList = new ArrayList(n);
        if (n <= 0)
        {
          QLog.e("MessageForMixedMsg", 1, "MessageForMixedMsg.doParse no element");
          QLog.e("MessageForMixedMsg", 1, getBaseInfoString());
          this.msgElemList = localArrayList;
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.e("MessageForMixedMsg", 1, "parse failed", localInvalidProtocolBufferMicroException);
        QLog.e("MessageForMixedMsg", 1, "content：" + Arrays.toString(this.msgData));
        QLog.e("MessageForMixedMsg", 1, "msgContent：" + this);
        continue;
        i = 0;
        localObject6 = getExtInfoFromExtStr("disc_at_info_list");
        localObject3 = getExtInfoFromExtStr("troop_at_info_list");
        localObject2 = null;
      }
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse disc_at_info_list extStr " + (String)localObject6);
          }
          localObject2 = new JSONObject((String)localObject6);
          i = 1;
        }
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label1607;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse troop_at_info_list extStr " + (String)localObject3);
          }
          localObject3 = new JSONObject((String)localObject3);
          i = 2;
          localObject2 = localObject3;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            int j;
            int k;
            int m;
            Object localObject4;
            boolean bool2;
            continue;
            boolean bool1 = false;
          }
        }
        j = i;
        i = 0;
        k = 0;
        for (;;)
        {
          if (k >= n) {
            break label1296;
          }
          localObject6 = (MixedMsg.Elem)localMsg.elems.get().get(k);
          if (!((MixedMsg.Elem)localObject6).sourceMsgInfo.has()) {
            break label821;
          }
          try
          {
            localObject3 = new MessageForReplyText();
            ((MessageForReplyText)localObject3).mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)akwa.a(HexUtil.hexStr2Bytes(((MixedMsg.Elem)localObject6).sourceMsgInfo.get())));
            if (((MixedMsg.Elem)localObject6).textMsg.has())
            {
              ((MessageForReplyText)localObject3).msg = ((MixedMsg.Elem)localObject6).textMsg.get();
              ((MessageForReplyText)localObject3).sb = new aykk(((MessageForReplyText)localObject3).msg, 13, ChatTextSizeSettingActivity.a(), this);
              copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, this);
            }
            if (((MessageForReplyText)localObject3).mSourceMsgInfo != null)
            {
              localObject6 = MessageForReplyText.getAppInterface();
              ((MessageForReplyText)localObject3).setSourceMessageRecord(((MessageForReplyText)localObject3).mSourceMsgInfo.unPackSourceMsg((QQAppInterface)localObject6));
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.", 2, "doParse sourceMessage ok");
              }
            }
            if (localObject2 != null)
            {
              localObject6 = ((JSONObject)localObject2).optJSONArray("" + k);
              if ((localObject6 != null) && (!TextUtils.isEmpty(((JSONArray)localObject6).toString())))
              {
                localObject6 = MessageForText.getTroopMemberInfoFromExtrJson(((JSONArray)localObject6).toString());
                if ((localObject6 != null) && (((ArrayList)localObject6).size() > 0)) {
                  ((MessageForReplyText)localObject3).atInfoList = ((ArrayList)localObject6);
                }
              }
            }
            localArrayList.add(localObject3);
            if (((MessageForReplyText)localObject3).msg != null)
            {
              localStringBuilder1.append(((MessageForReplyText)localObject3).msg);
              localStringBuilder2.append(((MessageForReplyText)localObject3).msg);
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MessageForMixedMsg", 2, localException3.getMessage());
              }
            }
          }
          this.mHasReplyText = true;
          m = i;
          k += 1;
          i = m;
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localObject2 = null;
          i = 0;
          QLog.e("MessageForMixedMsg", 1, "get mixJSONO error:", localJSONException1);
          j = i;
          continue;
          label821:
          if (((MixedMsg.Elem)localObject6).textMsg.has())
          {
            localObject4 = new MessageForText();
            ((MessageForText)localObject4).frienduin = this.frienduin;
            ((MessageForText)localObject4).msg = ((MixedMsg.Elem)localObject6).textMsg.get();
            ((MessageForText)localObject4).msgData = ((MessageForText)localObject4).msg.getBytes();
            if (localObject2 != null)
            {
              if (j != 1) {
                break label1003;
              }
              localObject6 = ((JSONObject)localObject2).optJSONArray("" + k);
              if ((localObject6 != null) && (!TextUtils.isEmpty(((JSONArray)localObject6).toString()))) {
                bafv.a(3000, ((JSONArray)localObject6).toString(), (ChatMessage)localObject4);
              }
            }
            ((MessageForText)localObject4).doParse(true);
            bamk.a((MessageRecord)localObject4);
            localArrayList.add(localObject4);
            localStringBuilder1.append(((MessageForText)localObject4).msg);
            if (!TextUtils.isEmpty(((MessageForText)localObject4).msg2))
            {
              i = 1;
              localStringBuilder2.append(((MessageForText)localObject4).msg2);
            }
            for (;;)
            {
              m = i;
              break;
              label1003:
              if (j != 2) {
                break label941;
              }
              localObject6 = ((JSONObject)localObject2).optJSONArray("" + k);
              if ((localObject6 == null) || (TextUtils.isEmpty(((JSONArray)localObject6).toString()))) {
                break label941;
              }
              bafv.a(1, ((JSONArray)localObject6).toString(), (ChatMessage)localObject4);
              break label941;
              localStringBuilder2.append(((MessageForText)localObject4).msg);
            }
          }
          label941:
          if (((MixedMsg.Elem)localObject6).picMsg.has())
          {
            localObject4 = new MessageForPic();
            ((MessageForPic)localObject4).msgData = ((RichMsg.PicRec)((MixedMsg.Elem)localObject6).picMsg.get()).toByteArray();
            ((MessageForPic)localObject4).doParse();
            if ((((MessageForPic)localObject4).uuid != null) && (((MessageForPic)localObject4).uuid.length() > 0) && (((HashMap)localObject5).get(((MessageForPic)localObject4).uuid) != null)) {}
            for (((MessageForPic)localObject4).richText = ((im_msg_body.RichText)((HashMap)localObject5).get(((MessageForPic)localObject4).uuid));; ((MessageForPic)localObject4).richText = ((im_msg_body.RichText)localHashMap.get(((MessageForPic)localObject4).path))) {
              do
              {
                ((MessageForPic)localObject4).subMsgId = k;
                copyBaseInfoFromMixedToPic((MessageForPic)localObject4, this);
                localArrayList.add(localObject4);
                localObject4 = ((MessageForPic)localObject4).getSummaryMsg();
                localStringBuilder1.append((String)localObject4);
                localStringBuilder2.append((String)localObject4);
                m = i;
                break;
              } while ((((MessageForPic)localObject4).path == null) || (((MessageForPic)localObject4).path.length() <= 0) || (localHashMap.get(((MessageForPic)localObject4).path) == null));
            }
          }
          m = i;
          if (((MixedMsg.Elem)localObject6).markfaceMsg.has()) {
            m = i;
          }
        }
        label1296:
        this.msgElemList = localArrayList;
        if (QLog.isColorLevel()) {
          QLog.d("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse list size is " + this.msgElemList.size());
        }
        this.msg = localStringBuilder1.toString();
        if (i != 0) {
          this.msg2 = localStringBuilder2.toString();
        }
        bool2 = true;
        localObject2 = getExtInfoFromExtStr("sens_msg_need_parse");
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        try
        {
          bool1 = Boolean.parseBoolean((String)localObject2);
          bool2 = bool1;
          if (bool1) {
            if (!(BaseActivity.sTopActivity instanceof MultiForwardActivity))
            {
              bool2 = bool1;
              if (!(BaseActivity.sTopActivity instanceof ChatHistoryActivity)) {}
            }
            else
            {
              bool2 = false;
            }
          }
          if (!bool2) {
            continue;
          }
          localObject2 = getExtInfoFromExtStr("sens_msg_ctrl_info");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject4 = getExtInfoFromExtStr("sens_msg_confirmed");
            if ((TextUtils.isEmpty((CharSequence)localObject4)) || (!((String)localObject4).equalsIgnoreCase("1"))) {
              break label1601;
            }
            bool1 = true;
            if (!bool1)
            {
              localObject4 = this.msgElemList.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (MessageRecord)((Iterator)localObject4).next();
                if ((localObject5 instanceof MessageForText)) {
                  ((MessageRecord)localObject5).saveExtInfoToExtStr("sens_msg_original_text", ((MessageRecord)localObject5).msg);
                }
              }
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
            bool1 = bool2;
          }
          bcxb.a(this, this.msgElemList, bool1, HexUtil.hexStr2Bytes(localException1));
          try
          {
            this.mRobotFlag = Integer.parseInt(getExtInfoFromExtStr("is_to_robot"));
            return;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            return;
          }
        }
      }
    }
  }
  
  public String getContentForSearch()
  {
    for (;;)
    {
      MessageRecord localMessageRecord;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(64);
        Iterator localIterator = this.msgElemList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
        if ((localMessageRecord instanceof MessageForPic))
        {
          localStringBuilder.append("[图片]");
          continue;
        }
        if (!(localMessageRecord instanceof MessageForReplyText)) {
          break label105;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageForMixedMsg", 2, "MessageForMixedMsg.getContentForSearch failure: ", localThrowable);
        }
        return null;
      }
      if (!TextUtils.isEmpty(localMessageRecord.msg))
      {
        localThrowable.append(localMessageRecord.msg);
        continue;
        label105:
        if ((localMessageRecord instanceof MessageForText)) {
          localThrowable.append(localMessageRecord.msg);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.getContentForSearch msg is " + bbbr.a(localThrowable.toString()));
    }
    String str = localThrowable.toString();
    return str;
  }
  
  public List<MessageRecord> getPicMsgList()
  {
    if ((this.msgElemList == null) || (this.msgElemList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.msgElemList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  public MessageForReplyText getReplyMessage(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = this.msgElemList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForReplyText))
      {
        if (((MessageForReplyText)localMessageRecord).getSourceMessage() == null) {
          adyf.a(paramQQAppInterface, this.frienduin, this.istroop, localMessageRecord, ((MessageForReplyText)localMessageRecord).mSourceMsgInfo);
        }
        return (MessageForReplyText)localMessageRecord;
      }
    }
    return null;
  }
  
  public MessageRecord getSubMessage(long paramLong)
  {
    if ((this.msgElemList == null) || (paramLong < 0L) || (paramLong >= this.msgElemList.size())) {
      return null;
    }
    return (MessageRecord)this.msgElemList.get((int)paramLong);
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
    return akpx.v(this.istroop);
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
      if (((localMessageRecord instanceof MessageForPic)) && (localMessageRecord.uniseq != this.uniseq))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageForMixedMsg", 2, " Error : Info not Equals : child : " + localMessageRecord.uniseq + " parent:" + this.uniseq);
        }
        copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, this);
      }
      if (((localMessageRecord instanceof MessageForReplyText)) && (localMessageRecord.uniseq != this.uniseq))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageForMixedMsg", 2, " Error : Info not Equals : child : " + localMessageRecord.uniseq + " parent:" + this.uniseq);
        }
        copyBaseInfoFromMixedToNormal(localMessageRecord, this);
      }
    }
  }
  
  public void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  public void prewrite()
  {
    if ((this.msgElemList == null) || (this.msgElemList.size() < 1))
    {
      QLog.e("MessageForMixedMsg", 1, "prewrite err null elemList");
      return;
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    Iterator localIterator = this.msgElemList.iterator();
    Object localObject2;
    MixedMsg.Elem localElem;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      localElem = new MixedMsg.Elem();
      if ((localObject2 instanceof MessageForText))
      {
        localObject1 = getExtInfoFromExtStr("sens_msg_original_text");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label390;
        }
        localObject1 = ((MessageForText)localObject2).msg;
      }
    }
    label390:
    for (;;)
    {
      localElem.textMsg.set((String)localObject1);
      for (;;)
      {
        localMsg.elems.get().add(localElem);
        break;
        if ((localObject2 instanceof MessageForPic))
        {
          localElem.picMsg.set(((MessageForPic)localObject2).getSerialPB());
        }
        else
        {
          if ((localObject2 instanceof MessageForReplyText))
          {
            localObject1 = (MessageForReplyText)localObject2;
            if (!TextUtils.isEmpty(((MessageForReplyText)localObject1).msg)) {
              localElem.textMsg.set(((MessageForReplyText)localObject1).msg);
            }
            try
            {
              if (((MessageForReplyText)localObject1).mSourceMsgInfo != null) {
                ((MessageForReplyText)localObject1).mSourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), ((MessageForReplyText)localObject1).getSourceMessage());
              }
              localObject1 = akwa.a(((MessageForReplyText)localObject1).mSourceMsgInfo);
              localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject1));
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("MessageForMixedMsg", 2, "MessagePkgUtils.getBytesFromObject get Exception:" + localException.getMessage());
                }
              }
            }
            this.mHasReplyText = true;
            continue;
          }
          if ((localObject2 instanceof MessageForMarketFace)) {
            QLog.e("MessageForMixedMsg", 1, "prewrite err unSupported" + localObject2);
          } else {
            QLog.e("MessageForMixedMsg", 1, "prewrite err unSupported" + localObject2);
          }
        }
      }
      this.msgData = localMsg.toByteArray();
      saveExtInfoToExtStr("is_to_robot", this.mRobotFlag + "");
      return;
    }
  }
  
  public MessageRecord rebuildMixedMsg()
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      MessageRecord localMessageRecord;
      synchronized (this.msgElemListSyncLock)
      {
        Iterator localIterator1 = this.msgElemList.iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)localIterator1.next();
        if ((localMessageRecord instanceof MessageForText)) {
          localArrayList2.add(localMessageRecord);
        }
      }
      if ((localMessageRecord instanceof MessageForPic))
      {
        if (!localArrayList2.isEmpty())
        {
          Iterator localIterator2 = localArrayList2.iterator();
          if (localIterator2.hasNext())
          {
            localObject2 = (MessageRecord)localIterator2.next();
            if (((MessageRecord)localObject2).msg == null) {}
            for (localObject2 = "";; localObject2 = ((MessageRecord)localObject2).msg)
            {
              localStringBuffer.append((String)localObject2);
              break;
            }
          }
          localObject2 = (MessageForText)axas.a(-1000);
          ((MessageForText)localObject2).msgtype = -1000;
          ((MessageForText)localObject2).msg = localStringBuffer.toString();
          localStringBuffer.delete(0, localStringBuffer.length());
          localArrayList1.add(localObject2);
          localArrayList2.clear();
        }
        localArrayList1.add((MessageForPic)localMessageRecord.deepCopyByReflect());
      }
      else if ((localMessageRecord instanceof MessageForReplyText))
      {
        localObject2 = (MessageForReplyText)localMessageRecord.deepCopyByReflect();
        if (((MessageForReplyText)localMessageRecord).getSourceMessage() != null) {
          ((MessageForReplyText)localObject2).deepCopySourceMsg((MessageForReplyText)localMessageRecord);
        }
        localArrayList1.add(localObject2);
      }
    }
    if (!localArrayList2.isEmpty())
    {
      ??? = localArrayList2.iterator();
      if (((Iterator)???).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)???).next();
        if (((MessageRecord)localObject2).msg == null) {}
        for (localObject2 = "";; localObject2 = ((MessageRecord)localObject2).msg)
        {
          localStringBuffer.append((String)localObject2);
          break;
        }
      }
      localObject2 = (MessageForText)axas.a(-1000);
      ((MessageForText)localObject2).msgtype = -1000;
      ((MessageForText)localObject2).msg = localStringBuffer.toString();
      localStringBuffer.delete(0, localStringBuffer.length());
      localArrayList1.add(localObject2);
      localArrayList2.clear();
    }
    Object localObject2 = (MessageForMixedMsg)axas.a(-1035);
    copyMessageRecordBaseField((MessageRecord)localObject2, this);
    ((MessageForMixedMsg)localObject2).msgtype = -1035;
    ((MessageForMixedMsg)localObject2).msgElemList = localArrayList1;
    ((MessageForMixedMsg)localObject2).prewrite();
    return localObject2;
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
    Object localObject3;
    MixedMsg.Elem localElem;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = localIterator.next();
        localElem = new MixedMsg.Elem();
        if ((localObject3 instanceof MessageForReplyText))
        {
          String str = getExtInfoFromExtStr("sens_msg_original_text");
          localObject3 = (MessageForReplyText)localObject3;
          Object localObject1 = str;
          if (TextUtils.isEmpty(str)) {
            localObject1 = ((MessageForReplyText)localObject3).msg;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localElem.textMsg.set((String)localObject1);
          }
          try
          {
            if (((MessageForReplyText)localObject3).mSourceMsgInfo != null) {
              ((MessageForReplyText)localObject3).mSourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), ((MessageForReplyText)localObject3).getSourceMessage());
            }
            localObject1 = akwa.a(((MessageForReplyText)localObject3).mSourceMsgInfo);
            localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject1));
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("MessageForMixedMsg", 2, "MessagePkgUtils.getBytesFromObject get Exception:" + localException.getMessage());
              }
            }
          }
          localMsg.elems.get().add(localElem);
          continue;
        }
        if ((localObject3 instanceof MessageForText))
        {
          localObject2 = getExtInfoFromExtStr("sens_msg_original_text");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label417;
          }
          localObject2 = ((MessageForText)localObject3).msg;
        }
      }
    }
    label408:
    label417:
    for (;;)
    {
      localElem.textMsg.set((String)localObject2);
      break;
      if ((localObject3 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject3;
        if ((((MessageForPic)localObject2).uniseq == paramMessageForPic.uniseq) && (((MessageForPic)localObject2).subMsgId == paramMessageForPic.subMsgId))
        {
          localElem.picMsg.set(paramMessageForPic.getSerialPB());
          break;
        }
        localElem.picMsg.set(((MessageForPic)localObject2).getSerialPB());
        break;
      }
      if (!(localObject3 instanceof MessageForMarketFace)) {
        break;
      }
      break;
      this.msgData = localMsg.toByteArray();
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder().append("upateMessageForPic");
        if (this.msgData != null) {
          break label408;
        }
      }
      for (int i = 0;; i = this.msgData.length)
      {
        QLog.i("MessageForMixedMsg", 2, i);
        return this.msgData;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMixedMsg
 * JD-Core Version:    0.7.0.1
 */