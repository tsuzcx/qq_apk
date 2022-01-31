package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
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
  public MessageForText.AtTroopMemberInfo mAtInfo;
  public int mForwardFromIsTroop;
  public String mForwardFromUin;
  public long mForwardFromUniSeq;
  protected boolean mHasReplyText;
  public boolean mIsResend;
  public int mRichTextLength;
  public List msgElemList;
  
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
          ??? = ???.msg;
          break label86;
          if ((??? instanceof MessageForText))
          {
            localObject3 = (MessageForText)???;
            if (((MessageForText)localObject3).sb != null) {}
            for (??? = ((MessageForText)localObject3).sb.toString();; ??? = ???.msg)
            {
              localStringBuilder.append(???);
              break;
            }
          }
          if ((??? instanceof MessageForPic)) {
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131433004));
          }
        }
      }
    }
    else if ((??? instanceof MessageForLongMsg))
    {
      localObject2 = (MessageForLongMsg)???;
      synchronized (((MessageForLongMsg)localObject2).fragmentListSyncLock)
      {
        int k = ((MessageForLongMsg)localObject2).longMsgFragmentList.size();
        i = 0;
        if (i >= k) {
          break label456;
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
            break label471;
          }
          localObject1.append(((MessageForReplyText)localMessageRecord).msg);
          break label471;
        }
        if ((localMessageRecord instanceof MessageForText))
        {
          localObject1.append(((MessageForText)localMessageRecord).msg);
          break label471;
        }
        if (!(localMessageRecord instanceof MessageForPic)) {
          break label471;
        }
        localObject1.append(BaseApplicationImpl.getContext().getString(2131433004));
        break label471;
        if ((localObject3 instanceof MessageForPic))
        {
          localObject1.append(BaseApplicationImpl.getContext().getString(2131433004));
          break label464;
          label456:
          return localObject1.toString();
        }
      }
      label464:
      i += 1;
      break;
      label471:
      j += 1;
    }
  }
  
  public static CharSequence getTextFromMixedMsgForMail(ChatMessage arg0, List paramList1, List paramList2)
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
            ??? = AIOShareActionSheet.a((MessageForPic)???, paramList1, paramList2);
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
        localObject3 = AIOShareActionSheet.a((MessageForPic)localObject3, paramList1, paramList2);
        if (localObject3 == null) {
          break label508;
        }
        localStringBuilder.append((String)localObject3);
        break label508;
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = AIOShareActionSheet.a((MessageForPic)localObject2, paramList1, paramList2);
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
          if (QLog.isColorLevel()) {
            QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse no element");
          }
          this.msgElemList = localArrayList;
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        i = 0;
        localObject6 = getExtInfoFromExtStr("disc_at_info_list");
        localObject3 = getExtInfoFromExtStr("troop_at_info_list");
        if (QLog.isColorLevel()) {
          QLog.d("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse disc_at_info_list extStr " + (String)localObject6 + " extStr2 " + (String)localObject3);
        }
        localObject2 = null;
      }
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          localObject2 = new JSONObject((String)localObject6);
          i = 1;
        }
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label1389;
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
            break label1078;
          }
          localObject3 = (MixedMsg.Elem)localMsg.elems.get().get(k);
          if (!((MixedMsg.Elem)localObject3).sourceMsgInfo.has()) {
            break label598;
          }
          try
          {
            localObject6 = new MessageForReplyText();
            ((MessageForReplyText)localObject6).mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.hexStr2Bytes(((MixedMsg.Elem)localObject3).sourceMsgInfo.get())));
            if (((MixedMsg.Elem)localObject3).textMsg.has())
            {
              ((MessageForReplyText)localObject6).msg = ((MixedMsg.Elem)localObject3).textMsg.get();
              ((MessageForReplyText)localObject6).sb = new QQText(((MessageForReplyText)localObject6).msg, 13, 32, this);
            }
            localArrayList.add(localObject6);
            if (((MessageForReplyText)localObject6).msg != null)
            {
              localStringBuilder1.append(((MessageForReplyText)localObject6).msg);
              localStringBuilder2.append(((MessageForReplyText)localObject6).msg);
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
          label598:
          if (localException3.textMsg.has())
          {
            localObject6 = new MessageForText();
            ((MessageForText)localObject6).frienduin = this.frienduin;
            ((MessageForText)localObject6).msg = localException3.textMsg.get();
            ((MessageForText)localObject6).msgData = ((MessageForText)localObject6).msg.getBytes();
            if (localObject2 != null)
            {
              if (j != 1) {
                break label780;
              }
              localObject4 = ((JSONObject)localObject2).optJSONArray("" + k);
              if ((localObject4 != null) && (!TextUtils.isEmpty(((JSONArray)localObject4).toString()))) {
                AtTroopMemberSpan.a(3000, ((JSONArray)localObject4).toString(), (ChatMessage)localObject6);
              }
            }
            ((MessageForText)localObject6).doParse(true);
            TroopRobotManager.a((MessageRecord)localObject6);
            localArrayList.add(localObject6);
            localStringBuilder1.append(((MessageForText)localObject6).msg);
            if (!TextUtils.isEmpty(((MessageForText)localObject6).msg2))
            {
              i = 1;
              localStringBuilder2.append(((MessageForText)localObject6).msg2);
            }
            for (;;)
            {
              m = i;
              break;
              if (j != 2) {
                break label718;
              }
              localObject4 = ((JSONObject)localObject2).optJSONArray("" + k);
              if ((localObject4 == null) || (TextUtils.isEmpty(((JSONArray)localObject4).toString()))) {
                break label718;
              }
              AtTroopMemberSpan.a(1, ((JSONArray)localObject4).toString(), (ChatMessage)localObject6);
              break label718;
              localStringBuilder2.append(((MessageForText)localObject6).msg);
            }
          }
          label718:
          if (((MixedMsg.Elem)localObject4).picMsg.has())
          {
            localObject6 = new MessageForPic();
            ((MessageForPic)localObject6).msgData = ((RichMsg.PicRec)((MixedMsg.Elem)localObject4).picMsg.get()).toByteArray();
            ((MessageForPic)localObject6).doParse();
            if ((((MessageForPic)localObject6).uuid != null) && (((MessageForPic)localObject6).uuid.length() > 0) && (((HashMap)localObject5).get(((MessageForPic)localObject6).uuid) != null)) {}
            for (((MessageForPic)localObject6).richText = ((im_msg_body.RichText)((HashMap)localObject5).get(((MessageForPic)localObject6).uuid));; ((MessageForPic)localObject6).richText = ((im_msg_body.RichText)localHashMap.get(((MessageForPic)localObject6).path))) {
              do
              {
                ((MessageForPic)localObject6).subMsgId = k;
                copyBaseInfoFromMixedToPic((MessageForPic)localObject6, this);
                localArrayList.add(localObject6);
                localStringBuilder1.append(BaseApplicationImpl.getContext().getString(2131433004));
                localStringBuilder2.append(BaseApplicationImpl.getContext().getString(2131433004));
                m = i;
                break;
              } while ((((MessageForPic)localObject6).path == null) || (((MessageForPic)localObject6).path.length() <= 0) || (localHashMap.get(((MessageForPic)localObject6).path) == null));
            }
          }
          label780:
          m = i;
          if (((MixedMsg.Elem)localObject4).markfaceMsg.has()) {
            m = i;
          }
        }
        label1078:
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
              if (!(BaseActivity.sTopActivity instanceof ChatHistoryForC2C)) {}
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
              break label1383;
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
          MQPSensitiveMsgUtil.a(this, this.msgElemList, bool1, HexUtil.hexStr2Bytes(localException1));
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
      QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.getContentForSearch msg is " + Utils.a(localThrowable.toString()));
    }
    String str = localThrowable.toString();
    return str;
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
    return MsgProxyUtils.v(this.istroop);
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
    }
  }
  
  protected void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  public void prewrite()
  {
    if (this.msgElemList == null) {
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
          break label290;
        }
        localObject1 = ((MessageForText)localObject2).msg;
      }
    }
    label290:
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
        else if ((localObject2 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForReplyText)localObject2;
          if (!TextUtils.isEmpty(((MessageForReplyText)localObject1).msg)) {
            localElem.textMsg.set(((MessageForReplyText)localObject1).msg);
          }
          try
          {
            localObject1 = MessagePkgUtils.a(((MessageForReplyText)localObject1).mSourceMsgInfo);
            localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject1));
            this.mHasReplyText = true;
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
        }
        else if (!(localObject2 instanceof MessageForMarketFace)) {}
      }
      this.msgData = localMsg.toByteArray();
      saveExtInfoToExtStr("is_to_robot", this.mRobotFlag + "");
      return;
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
    Object localObject3;
    MixedMsg.Elem localElem;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label324;
      }
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
          localObject1 = MessagePkgUtils.a(((MessageForReplyText)localObject3).mSourceMsgInfo);
          localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject1));
          localMsg.elems.get().add(localElem);
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
      }
    }
    Object localObject2;
    if ((localObject3 instanceof MessageForText))
    {
      localObject2 = getExtInfoFromExtStr("sens_msg_original_text");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label338;
      }
      localObject2 = ((MessageForText)localObject3).msg;
    }
    label324:
    label338:
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
      return this.msgData;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMixedMsg
 * JD-Core Version:    0.7.0.1
 */