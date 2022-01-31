package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageForLongMsg
  extends RecommendCommonMessage
{
  public Object fragmentListSyncLock = new Object();
  public List longMsgFragmentList;
  public boolean mIsCutAtInfoLocal;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  public CharSequence sb;
  public CharSequence sb2;
  
  public MessageForLongMsg()
  {
    this.longMsgFragmentList = new ArrayList();
  }
  
  public MessageForLongMsg(ArrayList paramArrayList)
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
  
  protected void doParse()
  {
    super.doParse();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int k;
    boolean bool1;
    Object localObject5;
    int j;
    boolean bool2;
    int n;
    boolean bool3;
    synchronized (this.fragmentListSyncLock)
    {
      if ((this.longMsgFragmentList == null) || (this.longMsgFragmentList.isEmpty())) {
        break label1031;
      }
      k = 0;
      bool1 = false;
      localObject5 = this.longMsgFragmentList.iterator();
      j = 0;
      for (;;)
      {
        if (((Iterator)localObject5).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
          Object localObject1 = localMessageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
          bool2 = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool2) {
            break label1005;
          }
          for (;;)
          {
            try
            {
              localObject6 = new bankcode_info.BankcodeCtrlInfo();
              ((bankcode_info.BankcodeCtrlInfo)localObject6).mergeFrom(HexUtil.hexStr2Bytes((String)localObject1));
              if (!((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.has()) {
                break label1000;
              }
              i = ((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.get();
              if (i != 1)
              {
                j = i;
                break;
              }
              n = k;
              bool2 = bool1;
              j = i;
              m = k;
              bool3 = bool1;
            }
            catch (Exception localException1)
            {
              Object localObject6;
              label235:
              i = j;
            }
            try
            {
              if (!((bankcode_info.BankcodeCtrlInfo)localObject6).bankcode_elems.has()) {
                break label522;
              }
              m = k;
              bool3 = bool1;
              localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject6).bankcode_elems.get();
              n = k;
              bool2 = bool1;
              j = i;
              if (localObject1 == null) {
                break label522;
              }
              m = k;
              bool3 = bool1;
              localObject6 = ((List)localObject1).iterator();
              m = k;
              bool3 = bool1;
              if (((Iterator)localObject6).hasNext())
              {
                m = k;
                bool3 = bool1;
                bankcode_info.BankcodeElem localBankcodeElem = (bankcode_info.BankcodeElem)((Iterator)localObject6).next();
                m = k;
                bool3 = bool1;
                if (!localBankcodeElem.bankcode_attr.has()) {
                  break label995;
                }
                m = k;
                bool3 = bool1;
                j = localBankcodeElem.bankcode_attr.get();
                break label1015;
              }
              n = k;
              bool2 = bool1;
              j = i;
              if (k != 20) {
                break label522;
              }
              m = k;
              bool3 = bool1;
              localObject6 = ((List)localObject1).iterator();
              n = k;
              bool2 = bool1;
              j = i;
              m = k;
              bool3 = bool1;
              if (!((Iterator)localObject6).hasNext()) {
                break label522;
              }
              m = k;
              bool3 = bool1;
              localObject1 = (bankcode_info.BankcodeElem)((Iterator)localObject6).next();
              j = 0;
              m = k;
              bool3 = bool1;
              if (((bankcode_info.BankcodeElem)localObject1).bankcode_attr.has())
              {
                m = k;
                bool3 = bool1;
                j = ((bankcode_info.BankcodeElem)localObject1).bankcode_attr.get();
              }
              if (j != 20) {
                continue;
              }
              m = k;
              bool3 = bool1;
              if (!((bankcode_info.BankcodeElem)localObject1).clean_bankcode.has()) {
                break label984;
              }
              m = k;
              bool3 = bool1;
              localObject1 = ((bankcode_info.BankcodeElem)localObject1).clean_bankcode.get();
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                String str;
                Iterator localIterator;
                k = m;
                bool1 = bool3;
              }
              continue;
              localObject3 = null;
              continue;
            }
            m = k;
            bool3 = bool1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label981;
            }
            m = k;
            bool3 = bool1;
            bool2 = MQPSensitiveMsgUtil.a().a((String)localObject1);
            if (bool2) {
              break label981;
            }
            bool1 = true;
          }
          localException1.printStackTrace();
          j = i;
          bool2 = bool1;
          n = k;
          label522:
          if (this.mSourceMsgInfo == null)
          {
            str = localMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info");
            bool1 = TextUtils.isEmpty(str);
            if (bool1) {}
          }
          try
          {
            this.mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.hexStr2Bytes(str)));
            k = n;
            bool1 = bool2;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.", 2, "getSourceMsgInfo exception:" + localException2.getMessage());
              }
            }
          }
        }
      }
    }
    localIterator = this.longMsgFragmentList.iterator();
    int i = 0;
    int m = i;
    if (localIterator.hasNext())
    {
      localObject5 = (MessageRecord)localIterator.next();
      if (!(localObject5 instanceof ChatMessage)) {
        break label1028;
      }
      if (j == 1)
      {
        ((MessageRecord)localObject5).saveExtInfoToExtStr("sens_msg_attr", Integer.toString(k));
        ((MessageRecord)localObject5).saveExtInfoToExtStr("sens_msg_has_not_confirmed_msg", Boolean.toString(bool1));
      }
      ((ChatMessage)localObject5).doParse();
      if ((localObject5 instanceof MessageForText))
      {
        if (!TextUtils.isEmpty(((MessageRecord)localObject5).msg)) {
          localStringBuilder1.append(((MessageRecord)localObject5).msg);
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject5).msg2))
        {
          localStringBuilder2.append(((MessageRecord)localObject5).msg2);
          i = 1;
          break label1025;
        }
        if (TextUtils.isEmpty(((MessageRecord)localObject5).msg)) {
          break label1028;
        }
        localStringBuilder2.append(((MessageRecord)localObject5).msg);
        break label1025;
      }
      if ((localObject5 instanceof MessageForReplyText))
      {
        localStringBuilder1.append(((MessageForReplyText)localObject5).msg);
        localStringBuilder2.append(((MessageForReplyText)localObject5).msg);
        break label1025;
      }
      if ((localObject5 instanceof MessageForMixedMsg))
      {
        localStringBuilder1.append(((MessageForMixedMsg)localObject5).msg);
        localStringBuilder2.append(((MessageForMixedMsg)localObject5).msg2);
        break label1025;
      }
      if (!(localObject5 instanceof MessageForPic)) {
        break label1028;
      }
      localStringBuilder1.append(BaseApplicationImpl.getContext().getString(2131433021));
      localStringBuilder2.append(BaseApplicationImpl.getContext().getString(2131433021));
      break label1028;
    }
    for (;;)
    {
      this.msg = localStringBuilder1.toString();
      this.sb = new QQText(this.msg, 13, 32, this.istroop);
      if (m != 0) {
        this.sb2 = new QQText(localStringBuilder2.toString(), 13, 32, this.istroop);
      }
      return;
      label981:
      label984:
      label995:
      label1000:
      label1005:
      label1015:
      do
      {
        Object localObject3;
        j = k;
        break label1020;
        j = 0;
        continue;
        i = j;
        break;
        n = k;
        bool2 = bool1;
        break label522;
      } while (j <= k);
      label1020:
      k = j;
      break label235;
      label1025:
      label1028:
      for (;;)
      {
        break;
      }
      label1031:
      m = 0;
    }
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.v(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public MessageRecord rebuildLongMsg()
  {
    Object localObject4;
    if (this.msgtype == -1037)
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      for (;;)
      {
        synchronized (this.fragmentListSyncLock)
        {
          localObject4 = this.longMsgFragmentList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          ??? = (MessageRecord)((Iterator)localObject4).next();
          if ((??? instanceof MessageForText)) {
            localStringBuilder.append(((MessageForText)???).msg);
          }
        }
        if ((??? instanceof MessageForReplyText)) {
          localObject1.append(((MessageForReplyText)???).msg);
        }
      }
      ??? = (MessageForText)MessageRecordFactory.a(-1000);
      copyMessageRecordBaseField((MessageRecord)???, this);
      ((MessageForText)???).msgtype = -1000;
      ((MessageForText)???).msg = localObject1.toString();
      return ???;
    }
    if (this.msgtype == -1036)
    {
      ??? = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localObject4 = new StringBuffer();
      for (;;)
      {
        Object localObject6;
        synchronized (this.fragmentListSyncLock)
        {
          Iterator localIterator = this.longMsgFragmentList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject6 = (MessageRecord)localIterator.next();
          if ((localObject6 instanceof MessageForText)) {
            ((List)???).add(localObject6);
          }
        }
        Object localObject7;
        if ((localObject6 instanceof MessageForMixedMsg))
        {
          localObject6 = ((MessageForMixedMsg)localObject6).msgElemList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (MessageRecord)((Iterator)localObject6).next();
            if ((localObject7 instanceof MessageForText))
            {
              ((List)???).add(localObject7);
            }
            else if ((localObject7 instanceof MessageForPic))
            {
              if (!((List)???).isEmpty())
              {
                Object localObject8 = ((List)???).iterator();
                while (((Iterator)localObject8).hasNext()) {
                  ((StringBuffer)localObject4).append(((MessageRecord)((Iterator)localObject8).next()).msg);
                }
                localObject8 = (MessageForText)MessageRecordFactory.a(-1000);
                ((MessageForText)localObject8).msgtype = -1000;
                ((MessageForText)localObject8).msg = ((StringBuffer)localObject4).toString();
                ((StringBuffer)localObject4).delete(0, ((StringBuffer)localObject4).length());
                localObject2.add(localObject8);
                ((List)???).clear();
              }
              localObject2.add((MessageForPic)((MessageRecord)localObject7).deepCopyByReflect());
            }
            else if ((localObject7 instanceof MessageForReplyText))
            {
              ((List)???).add(localObject7);
            }
          }
        }
        else if ((localObject6 instanceof MessageForPic))
        {
          if (!((List)???).isEmpty())
          {
            localObject7 = ((List)???).iterator();
            while (((Iterator)localObject7).hasNext()) {
              ((StringBuffer)localObject4).append(((MessageRecord)((Iterator)localObject7).next()).msg);
            }
            localObject7 = (MessageForText)MessageRecordFactory.a(-1000);
            ((MessageForText)localObject7).msgtype = -1000;
            ((MessageForText)localObject7).msg = ((StringBuffer)localObject4).toString();
            ((StringBuffer)localObject4).delete(0, ((StringBuffer)localObject4).length());
            localObject2.add(localObject7);
            ((List)???).clear();
          }
          localObject2.add((MessageForPic)((MessageRecord)localObject6).deepCopyByReflect());
        }
        else if ((localObject6 instanceof MessageForReplyText))
        {
          ((List)???).add(localObject6);
        }
      }
      if (!((List)???).isEmpty())
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((StringBuffer)localObject4).append(((MessageRecord)((Iterator)???).next()).msg);
        }
        ??? = (MessageForText)MessageRecordFactory.a(-1000);
        ((MessageForText)???).msgtype = -1000;
        ((MessageForText)???).msg = ((StringBuffer)localObject4).toString();
        ((StringBuffer)localObject4).delete(0, ((StringBuffer)localObject4).length());
        localObject2.add(???);
        ((List)???).clear();
      }
      ??? = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
      copyMessageRecordBaseField((MessageRecord)???, this);
      ((MessageForMixedMsg)???).msgtype = -1035;
      ((MessageForMixedMsg)???).msgElemList = localObject2;
      ((MessageForMixedMsg)???).prewrite();
      return ???;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongMsg
 * JD-Core Version:    0.7.0.1
 */