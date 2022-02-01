package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageForLongMsg
  extends RecommendCommonMessage
  implements HasSourceMessage
{
  public Object fragmentListSyncLock = new Object();
  public List<MessageRecord> longMsgFragmentList;
  public boolean mHasPullHistorySourceMsg = false;
  public boolean mIsCutAtInfoLocal = false;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  public CharSequence sb;
  public CharSequence sb2;
  
  public MessageForLongMsg()
  {
    this.longMsgFragmentList = new ArrayList();
  }
  
  public MessageForLongMsg(ArrayList<MessageRecord> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.longMsgFragmentList = new ArrayList(paramArrayList);
      paramArrayList = (MessageRecord)this.longMsgFragmentList.get(0);
      MessageRecord.copyMessageRecordBaseField(this, paramArrayList);
      if ((paramArrayList instanceof MessageForReplyText)) {
        this.atInfoList = ((MessageForReplyText)paramArrayList).atInfoList;
      }
      this.msgtype = -1037;
      paramArrayList = this.longMsgFragmentList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        if ((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForReplyText))) {
          this.msgtype = -1036;
        }
        if ((localMessageRecord.extraflag == 32768) && (localMessageRecord.isSendFromLocal())) {
          this.extraflag = 32768;
        }
      }
    }
  }
  
  public boolean canSelectable()
  {
    Object localObject1 = this.longMsgFragmentList;
    if (localObject1 != null)
    {
      Object localObject2;
      do
      {
        localObject1 = ((List)localObject1).iterator();
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if ((localObject2 instanceof MessageForText)) {
                return true;
              }
              if ((localObject2 instanceof MessageForReplyText)) {
                return true;
              }
            } while (!(localObject2 instanceof MessageForMixedMsg));
            localObject2 = (MessageForMixedMsg)localObject2;
          } while (((MessageForMixedMsg)localObject2).msgElemList == null);
          localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
        }
      } while (!((MessageRecord)((Iterator)localObject2).next() instanceof MessageForText));
      return true;
    }
    return false;
  }
  
  protected void doParse()
  {
    super.doParse();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i;
    int k;
    int j;
    label1142:
    synchronized (this.fragmentListSyncLock)
    {
      Object localObject1 = this.longMsgFragmentList;
      i = 0;
      int i3 = 0;
      int m = i;
      if (localObject1 != null)
      {
        m = i;
        if (!this.longMsgFragmentList.isEmpty())
        {
          Object localObject4 = this.longMsgFragmentList.iterator();
          k = 0;
          j = 0;
          boolean bool1 = false;
          while (((Iterator)localObject4).hasNext())
          {
            Object localObject5 = (MessageRecord)((Iterator)localObject4).next();
            localObject1 = ((MessageRecord)localObject5).getExtInfoFromExtStr("sens_msg_ctrl_info");
            boolean bool3 = TextUtils.isEmpty((CharSequence)localObject1);
            int i1 = k;
            int i2 = j;
            boolean bool2 = bool1;
            int n;
            if (!bool3)
            {
              m = k;
              n = j;
              bool3 = bool1;
              try
              {
                localObject6 = new bankcode_info.BankcodeCtrlInfo();
                m = k;
                n = j;
                bool3 = bool1;
                ((bankcode_info.BankcodeCtrlInfo)localObject6).mergeFrom(HexUtil.hexStr2Bytes((String)localObject1));
                m = k;
                n = j;
                bool3 = bool1;
                i = k;
                if (!((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.has()) {
                  break label1142;
                }
                m = k;
                n = j;
                bool3 = bool1;
                i = ((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.get();
              }
              catch (Exception localException1)
              {
                Object localObject6;
                bankcode_info.BankcodeElem localBankcodeElem;
                localException1.printStackTrace();
                bool2 = bool3;
                i2 = n;
                i1 = m;
              }
              m = i;
              n = j;
              bool3 = bool1;
              i1 = i;
              i2 = j;
              bool2 = bool1;
              if (((bankcode_info.BankcodeCtrlInfo)localObject6).bankcode_elems.has())
              {
                m = i;
                n = j;
                bool3 = bool1;
                localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject6).bankcode_elems.get();
                i1 = i;
                i2 = j;
                bool2 = bool1;
                if (localObject1 != null)
                {
                  m = i;
                  n = j;
                  bool3 = bool1;
                  localObject6 = ((List)localObject1).iterator();
                  m = i;
                  n = j;
                  bool3 = bool1;
                  if (((Iterator)localObject6).hasNext())
                  {
                    m = i;
                    n = j;
                    bool3 = bool1;
                    localBankcodeElem = (bankcode_info.BankcodeElem)((Iterator)localObject6).next();
                    m = i;
                    n = j;
                    bool3 = bool1;
                    if (!localBankcodeElem.bankcode_attr.has()) {
                      break label1152;
                    }
                    m = i;
                    n = j;
                    bool3 = bool1;
                    k = localBankcodeElem.bankcode_attr.get();
                    break label1154;
                  }
                  i1 = i;
                  i2 = j;
                  bool2 = bool1;
                  if (j == 20)
                  {
                    m = i;
                    n = j;
                    bool3 = bool1;
                    localObject6 = ((List)localObject1).iterator();
                    for (;;)
                    {
                      m = i;
                      n = j;
                      bool3 = bool1;
                      i1 = i;
                      i2 = j;
                      bool2 = bool1;
                      if (!((Iterator)localObject6).hasNext()) {
                        break;
                      }
                      m = i;
                      n = j;
                      bool3 = bool1;
                      localBankcodeElem = (bankcode_info.BankcodeElem)((Iterator)localObject6).next();
                      m = i;
                      n = j;
                      bool3 = bool1;
                      if (!localBankcodeElem.bankcode_attr.has()) {
                        break label1164;
                      }
                      m = i;
                      n = j;
                      bool3 = bool1;
                      k = localBankcodeElem.bankcode_attr.get();
                      break label1166;
                      localObject1 = null;
                      m = i;
                      n = j;
                      bool3 = bool1;
                      if (localBankcodeElem.clean_bankcode.has())
                      {
                        m = i;
                        n = j;
                        bool3 = bool1;
                        localObject1 = localBankcodeElem.clean_bankcode.get();
                      }
                      m = i;
                      n = j;
                      bool3 = bool1;
                      if (!TextUtils.isEmpty((CharSequence)localObject1))
                      {
                        m = i;
                        n = j;
                        bool3 = bool1;
                        bool2 = MQPSensitiveMsgUtil.a().a((String)localObject1);
                        if (!bool2) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
            k = i1;
            j = i2;
            bool1 = bool2;
            if (this.mSourceMsgInfo == null)
            {
              String str = ((MessageRecord)localObject5).getExtInfoFromExtStr("sens_msg_source_msg_info");
              bool3 = TextUtils.isEmpty(str);
              k = i1;
              j = i2;
              bool1 = bool2;
              if (!bool3)
              {
                try
                {
                  this.mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.hexStr2Bytes(str)));
                  k = i1;
                  j = i2;
                  bool1 = bool2;
                }
                catch (Exception localException2)
                {
                  k = i1;
                  j = i2;
                  bool1 = bool2;
                }
                if (QLog.isColorLevel())
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("getSourceMsgInfo exception:");
                  ((StringBuilder)localObject5).append(localException2.getMessage());
                  QLog.d("Q.msg.", 2, ((StringBuilder)localObject5).toString());
                  k = i1;
                  j = i2;
                  bool1 = bool2;
                }
              }
            }
          }
          Iterator localIterator = this.longMsgFragmentList.iterator();
          i = i3;
          for (;;)
          {
            m = i;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject4 = (MessageRecord)localIterator.next();
            if ((localObject4 instanceof ChatMessage))
            {
              if (k == 1)
              {
                ((MessageRecord)localObject4).saveExtInfoToExtStr("sens_msg_attr", Integer.toString(j));
                ((MessageRecord)localObject4).saveExtInfoToExtStr("sens_msg_has_not_confirmed_msg", Boolean.toString(bool1));
              }
              ((ChatMessage)localObject4).doParse();
              if ((localObject4 instanceof MessageForText))
              {
                if (!TextUtils.isEmpty(((MessageRecord)localObject4).msg)) {
                  localStringBuilder1.append(((MessageRecord)localObject4).msg);
                }
                if (!TextUtils.isEmpty(((MessageRecord)localObject4).msg2))
                {
                  localStringBuilder2.append(((MessageRecord)localObject4).msg2);
                  i = 1;
                }
                else if (!TextUtils.isEmpty(((MessageRecord)localObject4).msg))
                {
                  localStringBuilder2.append(((MessageRecord)localObject4).msg);
                }
              }
              else if ((localObject4 instanceof MessageForReplyText))
              {
                localStringBuilder1.append(((MessageForReplyText)localObject4).msg);
                localStringBuilder2.append(((MessageForReplyText)localObject4).msg);
              }
              else if ((localObject4 instanceof MessageForMixedMsg))
              {
                localStringBuilder1.append(((MessageForMixedMsg)localObject4).msg);
                localStringBuilder2.append(((MessageForMixedMsg)localObject4).msg2);
              }
              else if ((localObject4 instanceof MessageForPic))
              {
                localStringBuilder1.append(((MessageForPic)localObject4).getSummaryMsg());
                localStringBuilder2.append(((MessageForPic)localObject4).getSummaryMsg());
              }
            }
          }
        }
      }
      this.msg = localStringBuilder1.toString();
      this.sb = new QQText(this.msg, 13, ChatTextSizeSettingActivity.a(), this.istroop);
      if (m != 0) {
        this.sb2 = new QQText(localStringBuilder2.toString(), 13, ChatTextSizeSettingActivity.a(), this.istroop);
      }
      return;
    }
  }
  
  public boolean getHasPulledSourceMsg()
  {
    return this.mHasPullHistorySourceMsg;
  }
  
  public MessageForReplyText.SourceMsgInfo getSourceMsgInfo()
  {
    return this.mSourceMsgInfo;
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.m(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public MessageRecord rebuildLongMsg()
  {
    return rebuildLongMsg(false);
  }
  
  public MessageRecord rebuildLongMsg(boolean paramBoolean)
  {
    int i = this.msgtype;
    Object localObject3 = null;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    if (i == -1037)
    {
      localObject6 = new StringBuilder("");
      synchronized (this.fragmentListSyncLock)
      {
        localObject7 = this.longMsgFragmentList.iterator();
        i = 0;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (MessageRecord)((Iterator)localObject7).next();
          if ((localObject8 instanceof MessageForText))
          {
            ((StringBuilder)localObject6).append(((MessageForText)localObject8).msg);
          }
          else if ((localObject8 instanceof MessageForReplyText))
          {
            ((StringBuilder)localObject6).append(((MessageForReplyText)localObject8).msg);
            i = 1;
          }
        }
        ??? = localObject3;
        if (paramBoolean)
        {
          ??? = localObject3;
          if (i != 0) {
            try
            {
              ??? = (MessageForReplyText)((MessageForReplyText)this.longMsgFragmentList.get(0)).deepCopyByReflect();
              ((MessageForReplyText)???).msg = ((StringBuilder)localObject6).toString();
            }
            catch (Exception localException)
            {
              QLog.e("MultiMsg_TAG", 1, localException, new Object[0]);
              ??? = localObject3;
            }
          }
        }
        localObject3 = ???;
        if (??? == null)
        {
          localObject3 = MessageRecordFactory.a(-1000);
          copyMessageRecordBaseField((MessageRecord)localObject3, this);
          ((MessageRecord)localObject3).msgtype = -1000;
          ((MessageRecord)localObject3).msg = ((StringBuilder)localObject6).toString();
        }
        return localObject3;
      }
    }
    if (this.msgtype == -1036)
    {
      localObject6 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localObject7 = new StringBuffer();
      synchronized (this.fragmentListSyncLock)
      {
        localObject8 = this.longMsgFragmentList.iterator();
        while (((Iterator)localObject8).hasNext())
        {
          Object localObject9 = (MessageRecord)((Iterator)localObject8).next();
          if ((localObject9 instanceof MessageForText))
          {
            ((List)localObject6).add(localObject9);
          }
          else
          {
            Object localObject10;
            if ((localObject9 instanceof MessageForMixedMsg))
            {
              localObject9 = ((MessageForMixedMsg)localObject9).msgElemList.iterator();
              while (((Iterator)localObject9).hasNext())
              {
                localObject10 = (MessageRecord)((Iterator)localObject9).next();
                if ((localObject10 instanceof MessageForText))
                {
                  ((List)localObject6).add(localObject10);
                }
                else if ((localObject10 instanceof MessageForPic))
                {
                  if (!((List)localObject6).isEmpty())
                  {
                    Object localObject11 = ((List)localObject6).iterator();
                    while (((Iterator)localObject11).hasNext()) {
                      ((StringBuffer)localObject7).append(((MessageRecord)((Iterator)localObject11).next()).msg);
                    }
                    localObject11 = (MessageForText)MessageRecordFactory.a(-1000);
                    ((MessageForText)localObject11).msgtype = -1000;
                    ((MessageForText)localObject11).msg = ((StringBuffer)localObject7).toString();
                    ((StringBuffer)localObject7).delete(0, ((StringBuffer)localObject7).length());
                    localArrayList.add(localObject11);
                    ((List)localObject6).clear();
                  }
                  localArrayList.add((MessageForPic)((MessageRecord)localObject10).deepCopyByReflect());
                }
                else if ((localObject10 instanceof MessageForReplyText))
                {
                  ((List)localObject6).add(localObject10);
                }
              }
            }
            else if ((localObject9 instanceof MessageForPic))
            {
              if (!((List)localObject6).isEmpty())
              {
                localObject10 = ((List)localObject6).iterator();
                while (((Iterator)localObject10).hasNext()) {
                  ((StringBuffer)localObject7).append(((MessageRecord)((Iterator)localObject10).next()).msg);
                }
                localObject10 = (MessageForText)MessageRecordFactory.a(-1000);
                ((MessageForText)localObject10).msgtype = -1000;
                ((MessageForText)localObject10).msg = ((StringBuffer)localObject7).toString();
                ((StringBuffer)localObject7).delete(0, ((StringBuffer)localObject7).length());
                localArrayList.add(localObject10);
                ((List)localObject6).clear();
              }
              localArrayList.add((MessageForPic)((MessageRecord)localObject9).deepCopyByReflect());
            }
            else if ((localObject9 instanceof MessageForReplyText))
            {
              ((List)localObject6).add(localObject9);
            }
          }
        }
        if (!((List)localObject6).isEmpty())
        {
          localObject8 = ((List)localObject6).iterator();
          while (((Iterator)localObject8).hasNext())
          {
            ??? = (MessageRecord)((Iterator)localObject8).next();
            if (((MessageRecord)???).msg == null) {
              ??? = "";
            } else {
              ??? = ((MessageRecord)???).msg;
            }
            ((StringBuffer)localObject7).append((String)???);
          }
          ??? = (MessageForText)MessageRecordFactory.a(-1000);
          ((MessageForText)???).msgtype = -1000;
          ((MessageForText)???).msg = ((StringBuffer)localObject7).toString();
          ((StringBuffer)localObject7).delete(0, ((StringBuffer)localObject7).length());
          localArrayList.add(???);
          ((List)localObject6).clear();
        }
        ??? = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
        copyMessageRecordBaseField((MessageRecord)???, this);
        ((MessageForMixedMsg)???).msgtype = -1035;
        ((MessageForMixedMsg)???).msgElemList = localArrayList;
        ((MessageForMixedMsg)???).prewrite();
        return ???;
      }
    }
    return null;
  }
  
  public void setPulledSourceMsg()
  {
    this.mHasPullHistorySourceMsg = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongMsg
 * JD-Core Version:    0.7.0.1
 */