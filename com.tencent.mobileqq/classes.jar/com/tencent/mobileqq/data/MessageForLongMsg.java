package com.tencent.mobileqq.data;

import adak;
import android.text.TextUtils;
import apdm;
import arwl;
import bcry;
import begp;
import bjim;
import com.qq.taf.jce.HexUtil;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageForLongMsg
  extends RecommendCommonMessage
  implements arwl
{
  public Object fragmentListSyncLock = new Object();
  public List<MessageRecord> longMsgFragmentList;
  public boolean mHasPullHistorySourceMsg;
  public boolean mIsCutAtInfoLocal;
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
    if (this.longMsgFragmentList != null)
    {
      Object localObject;
      do
      {
        Iterator localIterator = this.longMsgFragmentList.iterator();
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localObject = (MessageRecord)localIterator.next();
              if ((localObject instanceof MessageForText)) {
                return true;
              }
              if ((localObject instanceof MessageForReplyText)) {
                return true;
              }
            } while (!(localObject instanceof MessageForMixedMsg));
            localObject = (MessageForMixedMsg)localObject;
          } while (((MessageForMixedMsg)localObject).msgElemList == null);
          localObject = ((MessageForMixedMsg)localObject).msgElemList.iterator();
        }
      } while (!((MessageRecord)((Iterator)localObject).next() instanceof MessageForText));
      return true;
    }
    return false;
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
        break label1033;
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
            break label1007;
          }
          for (;;)
          {
            try
            {
              localObject6 = new bankcode_info.BankcodeCtrlInfo();
              ((bankcode_info.BankcodeCtrlInfo)localObject6).mergeFrom(HexUtil.hexStr2Bytes((String)localObject1));
              if (!((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.has()) {
                break label1002;
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
                  break label997;
                }
                m = k;
                bool3 = bool1;
                j = localBankcodeElem.bankcode_attr.get();
                break label1017;
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
                break label986;
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
              break label983;
            }
            m = k;
            bool3 = bool1;
            bool2 = bjim.a().a((String)localObject1);
            if (bool2) {
              break label983;
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
            this.mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)apdm.a(HexUtil.hexStr2Bytes(str)));
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
        break label1030;
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
          break label1027;
        }
        if (TextUtils.isEmpty(((MessageRecord)localObject5).msg)) {
          break label1030;
        }
        localStringBuilder2.append(((MessageRecord)localObject5).msg);
        break label1027;
      }
      if ((localObject5 instanceof MessageForReplyText))
      {
        localStringBuilder1.append(((MessageForReplyText)localObject5).msg);
        localStringBuilder2.append(((MessageForReplyText)localObject5).msg);
        break label1027;
      }
      if ((localObject5 instanceof MessageForMixedMsg))
      {
        localStringBuilder1.append(((MessageForMixedMsg)localObject5).msg);
        localStringBuilder2.append(((MessageForMixedMsg)localObject5).msg2);
        break label1027;
      }
      if (!(localObject5 instanceof MessageForPic)) {
        break label1030;
      }
      localStringBuilder1.append(((MessageForPic)localObject5).getSummaryMsg());
      localStringBuilder2.append(((MessageForPic)localObject5).getSummaryMsg());
      break label1030;
    }
    for (;;)
    {
      this.msg = localStringBuilder1.toString();
      this.sb = new begp(this.msg, 13, ChatTextSizeSettingActivity.a(), this.istroop);
      if (m != 0) {
        this.sb2 = new begp(localStringBuilder2.toString(), 13, ChatTextSizeSettingActivity.a(), this.istroop);
      }
      return;
      label983:
      label986:
      label997:
      label1002:
      label1007:
      label1017:
      do
      {
        Object localObject3;
        j = k;
        break label1022;
        j = 0;
        continue;
        i = j;
        break;
        n = k;
        bool2 = bool1;
        break label522;
      } while (j <= k);
      label1022:
      k = j;
      break label235;
      label1027:
      label1030:
      for (;;)
      {
        break;
      }
      label1033:
      m = 0;
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
    return adak.x(this.istroop);
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
    Object localObject6;
    if (this.msgtype == -1037) {
      localObject6 = new StringBuilder("");
    }
    label868:
    for (;;)
    {
      Object localObject3;
      Object localObject7;
      synchronized (this.fragmentListSyncLock)
      {
        localObject3 = this.longMsgFragmentList.iterator();
        int i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          localObject7 = (MessageRecord)((Iterator)localObject3).next();
          if ((localObject7 instanceof MessageForText))
          {
            ((StringBuilder)localObject6).append(((MessageForText)localObject7).msg);
            break label868;
          }
          if (!(localObject7 instanceof MessageForReplyText)) {
            break label868;
          }
          ((StringBuilder)localObject6).append(((MessageForReplyText)localObject7).msg);
          i = 1;
          break label868;
        }
        if ((!paramBoolean) || (i == 0)) {}
      }
      ??? = null;
      continue;
      if (this.msgtype == -1036)
      {
        localObject6 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        localObject7 = new StringBuffer();
        Iterator localIterator;
        for (;;)
        {
          Object localObject8;
          synchronized (this.fragmentListSyncLock)
          {
            localIterator = this.longMsgFragmentList.iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            localObject8 = (MessageRecord)localIterator.next();
            if ((localObject8 instanceof MessageForText)) {
              ((List)localObject6).add(localObject8);
            }
          }
          Object localObject9;
          if ((localObject8 instanceof MessageForMixedMsg))
          {
            localObject8 = ((MessageForMixedMsg)localObject8).msgElemList.iterator();
            while (((Iterator)localObject8).hasNext())
            {
              localObject9 = (MessageRecord)((Iterator)localObject8).next();
              if ((localObject9 instanceof MessageForText))
              {
                ((List)localObject6).add(localObject9);
              }
              else if ((localObject9 instanceof MessageForPic))
              {
                if (!((List)localObject6).isEmpty())
                {
                  Object localObject10 = ((List)localObject6).iterator();
                  while (((Iterator)localObject10).hasNext()) {
                    ((StringBuffer)localObject7).append(((MessageRecord)((Iterator)localObject10).next()).msg);
                  }
                  localObject10 = (MessageForText)bcry.a(-1000);
                  ((MessageForText)localObject10).msgtype = -1000;
                  ((MessageForText)localObject10).msg = ((StringBuffer)localObject7).toString();
                  ((StringBuffer)localObject7).delete(0, ((StringBuffer)localObject7).length());
                  localObject5.add(localObject10);
                  ((List)localObject6).clear();
                }
                localObject5.add((MessageForPic)((MessageRecord)localObject9).deepCopyByReflect());
              }
              else if ((localObject9 instanceof MessageForReplyText))
              {
                ((List)localObject6).add(localObject9);
              }
            }
          }
          else if ((localObject8 instanceof MessageForPic))
          {
            if (!((List)localObject6).isEmpty())
            {
              localObject9 = ((List)localObject6).iterator();
              while (((Iterator)localObject9).hasNext()) {
                ((StringBuffer)localObject7).append(((MessageRecord)((Iterator)localObject9).next()).msg);
              }
              localObject9 = (MessageForText)bcry.a(-1000);
              ((MessageForText)localObject9).msgtype = -1000;
              ((MessageForText)localObject9).msg = ((StringBuffer)localObject7).toString();
              ((StringBuffer)localObject7).delete(0, ((StringBuffer)localObject7).length());
              localObject5.add(localObject9);
              ((List)localObject6).clear();
            }
            localObject5.add((MessageForPic)((MessageRecord)localObject8).deepCopyByReflect());
          }
          else if ((localObject8 instanceof MessageForReplyText))
          {
            ((List)localObject6).add(localObject8);
          }
        }
        if (!((List)localObject6).isEmpty())
        {
          localIterator = ((List)localObject6).iterator();
          if (localIterator.hasNext())
          {
            ??? = (MessageRecord)localIterator.next();
            if (((MessageRecord)???).msg == null) {}
            for (??? = "";; ??? = ((MessageRecord)???).msg)
            {
              ((StringBuffer)localObject7).append((String)???);
              break;
            }
          }
          ??? = (MessageForText)bcry.a(-1000);
          ((MessageForText)???).msgtype = -1000;
          ((MessageForText)???).msg = ((StringBuffer)localObject7).toString();
          ((StringBuffer)localObject7).delete(0, ((StringBuffer)localObject7).length());
          localObject5.add(???);
          ((List)localObject6).clear();
        }
        ??? = (MessageForMixedMsg)bcry.a(-1035);
        copyMessageRecordBaseField((MessageRecord)???, this);
        ((MessageForMixedMsg)???).msgtype = -1035;
        ((MessageForMixedMsg)???).msgElemList = localObject5;
        ((MessageForMixedMsg)???).prewrite();
        return ???;
      }
      return null;
    }
  }
  
  public void setPulledSourceMsg()
  {
    this.mHasPullHistorySourceMsg = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongMsg
 * JD-Core Version:    0.7.0.1
 */