package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class MessageForReplyText
  extends ChatMessage
  implements HasSourceMessage
{
  public static final String KEY_BARRAGE_SOURCE_MSG_TYPE = "barrage_source_msg_type";
  public static final String KEY_BARRAGE_TIME_LOCATION = "barrage_time_location";
  public String action;
  public int barrageSourceMsgType;
  public long barrageTimeLocation;
  public boolean isBarrageMsg;
  public boolean mHasPullHistorySourceMsg = false;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  public int msgVia;
  public CharSequence sb;
  @notColumn
  private MessageRecord sourceMessage;
  
  public static QQAppInterface getAppInterface()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return (QQAppInterface)localAppRuntime;
      }
    }
    return null;
  }
  
  public static boolean needHideLocate(MessageForReplyText paramMessageForReplyText)
  {
    boolean bool = true;
    if (paramMessageForReplyText == null) {
      return true;
    }
    if (UinTypeUtil.b(paramMessageForReplyText.istroop))
    {
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = paramMessageForReplyText.mSourceMsgInfo;
      if (localSourceMsgInfo != null)
      {
        if (localSourceMsgInfo.origUid == 0L) {
          return bool;
        }
        if (paramMessageForReplyText.mSourceMsgInfo.origUid == -1L) {
          return true;
        }
      }
    }
    bool = false;
    return bool;
  }
  
  public static void reportReplyMsg(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80095E8", "0X80095E8", 0, 0, "", "", "", "");
      return;
    }
    reportReplyMsg(paramQQAppInterface, "Msg_menu", "clk_replyMsg", paramSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage);
  }
  
  public static void reportReplyMsg(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      int j = paramChatMessage.msgtype;
      int i = 0;
      if (j != -2022) {
        if (j != -2017) {
          if (j != -2011) {
            if (j != -2007) {
              if (j != -2002) {
                if (j == -2000) {}
              }
            }
          }
        }
      }
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        localObject1 = "";
        break;
        i = 3;
        continue;
        i = 4;
        continue;
        i = 2;
        continue;
        j = 10;
        i = j;
        if ((paramChatMessage instanceof MessageForStructing))
        {
          localObject1 = (MessageForStructing)paramChatMessage;
          if (((MessageForStructing)localObject1).structingMsg != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((MessageForStructing)localObject1).structingMsg.mMsgServiceID);
            ((StringBuilder)localObject2).append("");
            localObject1 = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject1 = "";
          }
          i = j;
          break;
          i = 5;
          continue;
          i = 7;
        }
      }
      if (paramChatMessage.istroop == 3000) {
        localObject2 = "Grp_Dis_replyMsg";
      } else {
        localObject2 = "Grp_replyMsg";
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      if (AnonymousChatHelper.a(paramChatMessage)) {
        paramChatMessage = "1";
      } else {
        paramChatMessage = "0";
      }
      ReportController.b(paramQQAppInterface, "P_CliOper", (String)localObject2, "", paramString1, paramString2, 0, 0, paramString3, (String)localObject3, paramChatMessage, (String)localObject1);
      return;
    }
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_replyMsg", "", paramString1, paramString2, 0, 0, paramString3, "", "", "");
  }
  
  public void deepCopySourceMsg(MessageForReplyText paramMessageForReplyText)
  {
    if (paramMessageForReplyText == null)
    {
      QLog.d("Q.msg.", 1, "originMsg is null");
      return;
    }
    this.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText.mSourceMsgInfo);
    MessageRecord localMessageRecord = paramMessageForReplyText.sourceMessage;
    paramMessageForReplyText = null;
    if (localMessageRecord != null) {
      if (localMessageRecord.msgtype == -1037) {
        paramMessageForReplyText = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
      } else if (localMessageRecord.msgtype == -1036) {
        paramMessageForReplyText = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord).rebuildLongMsg();
      } else if (localMessageRecord.msgtype == -1035) {
        paramMessageForReplyText = ((MessageForMixedMsg)localMessageRecord).rebuildMixedMsg();
      } else if (localMessageRecord.msgtype == -2011) {
        paramMessageForReplyText = new MessageForStructing(localMessageRecord);
      } else {
        paramMessageForReplyText = (MessageRecord)localMessageRecord.deepCopyByReflect();
      }
    }
    if ((paramMessageForReplyText == null) && (QLog.isColorLevel())) {
      QLog.d("Q.msg.", 2, "MessageForReplyText deepCopySourceMsg is null");
    }
    this.sourceMessage = paramMessageForReplyText;
  }
  
  protected void doParse()
  {
    if (this.msg == null) {
      localObject1 = "";
    } else {
      localObject1 = this.msg;
    }
    String str1 = getExtInfoFromExtStr("sens_msg_need_parse");
    boolean bool1;
    if (!TextUtils.isEmpty(str1)) {
      try
      {
        bool1 = Boolean.parseBoolean(str1);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    } else {
      bool1 = true;
    }
    boolean bool3 = false;
    boolean bool2 = bool1;
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
    Object localObject4;
    try
    {
      Object localObject2 = getExtInfoFromExtStr("sens_msg_source_msg_info");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (this.mSourceMsgInfo == null))
      {
        this.mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.hexStr2Bytes((String)localObject2)));
        if (this.mSourceMsgInfo != null)
        {
          localObject2 = getAppInterface();
          setSourceMessageRecord(this.mSourceMsgInfo.unPackSourceMsg((QQAppInterface)localObject2));
        }
      }
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("doParse MessageForReplyText exception:");
        ((StringBuilder)localObject4).append(localException2.getMessage());
        QLog.d("Q.msg.", 2, ((StringBuilder)localObject4).toString());
      }
    }
    try
    {
      Object localObject3 = getExtInfoFromExtStr(MessageConstants.i);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = MessageForText.getTroopMemberInfoFromExtrJson((String)localObject3);
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
          this.atInfoList = ((ArrayList)localObject3);
        }
      }
    }
    catch (Exception localException3)
    {
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("doParse MessageForReplyText exception:");
        ((StringBuilder)localObject4).append(localException3.getMessage());
        QLog.d("Q.msg.", 2, ((StringBuilder)localObject4).toString());
      }
    }
    this.sb = new QQText((CharSequence)localObject1, 13, ChatTextSizeSettingActivity.a(), this);
    if (!bool2) {
      return;
    }
    String str2 = getExtInfoFromExtStr("sens_msg_ctrl_info");
    if (!TextUtils.isEmpty(str2))
    {
      localObject4 = getExtInfoFromExtStr("sens_msg_confirmed");
      bool1 = bool3;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        bool1 = bool3;
        if (((String)localObject4).equalsIgnoreCase("1")) {
          bool1 = true;
        }
      }
      if (!bool1) {
        saveExtInfoToExtStr("sens_msg_original_text", (String)localObject1);
      }
      localObject1 = new CopyOnWriteArrayList();
      ((List)localObject1).add(this);
      MQPSensitiveMsgUtil.a(this, (List)localObject1, bool1, HexUtil.hexStr2Bytes(str2));
    }
    Object localObject1 = getExtInfoFromExtStr("barrage_time_location");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.isBarrageMsg = true;
      this.barrageTimeLocation = Long.valueOf((String)localObject1).longValue();
      localObject1 = getExtInfoFromExtStr("barrage_source_msg_type");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.barrageSourceMsgType = Integer.valueOf((String)localObject1).intValue();
      }
    }
  }
  
  public boolean getHasPulledSourceMsg()
  {
    return this.mHasPullHistorySourceMsg;
  }
  
  public MessageRecord getSourceMessage()
  {
    return this.sourceMessage;
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
  
  protected void postRead()
  {
    super.postRead();
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    Object localObject2 = getExtInfoFromExtStr("sens_msg_original_text");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.msg;
    }
    this.msg = ((String)localObject1);
    if (this.msg == null) {
      localObject2 = "";
    } else {
      localObject2 = this.msg;
    }
    this.msg = ((String)localObject2);
    this.msgData = ((String)localObject1).getBytes();
    try
    {
      localObject1 = getAppInterface();
      if ((this.sourceMessage != null) && (localObject1 != null)) {
        this.mSourceMsgInfo.packSourceMsg((QQAppInterface)localObject1, this.sourceMessage);
      }
      saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.a(this.mSourceMsgInfo)));
      if (this.isBarrageMsg)
      {
        saveExtInfoToExtStr("barrage_time_location", String.valueOf(this.barrageTimeLocation));
        saveExtInfoToExtStr("barrage_source_msg_type", String.valueOf(this.barrageSourceMsgType));
      }
      this.extLong |= 0x1;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("prewrite MessageForReplyText exception:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.d("Q.msg.", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void setPulledSourceMsg()
  {
    this.mHasPullHistorySourceMsg = true;
  }
  
  public void setSourceMessageRecord(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    this.sourceMessage = paramMessageRecord;
    Object localObject = this.sourceMessage;
    ((MessageRecord)localObject).isReplySource = true;
    ((MessageRecord)localObject).isMultiMsg = this.isMultiMsg;
    this.sourceMessage.isReMultiMsg = this.isReMultiMsg;
    if ((paramMessageRecord instanceof MessageForMixedMsg))
    {
      localObject = (MessageForMixedMsg)paramMessageRecord;
      if (((MessageForMixedMsg)localObject).msgElemList != null)
      {
        localObject = ((MessageForMixedMsg)localObject).msgElemList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord != null) {
            localMessageRecord.isReplySource = true;
          }
        }
      }
    }
    localObject = this.mSourceMsgInfo;
    if (localObject != null)
    {
      ((MessageForReplyText.SourceMsgInfo)localObject).setUniSeq(paramMessageRecord.uniseq, false);
      paramMessageRecord.uniseq = this.mSourceMsgInfo.getUniSeq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForReplyText
 * JD-Core Version:    0.7.0.1
 */