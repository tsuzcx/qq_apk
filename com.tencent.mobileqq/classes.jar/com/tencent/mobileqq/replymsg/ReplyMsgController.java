package com.tencent.mobileqq.replymsg;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.IMultiMsgRichProcessor;
import com.tencent.mobileqq.multimsg.MultiMsgController;
import com.tencent.mobileqq.multimsg.MultiMsgRequest;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class ReplyMsgController
  extends MultiMsgController
{
  public ReplyMsgController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private ChatActivityFacade.SendMsgParams a(MessageForReplyText paramMessageForReplyText, MultiMsgRequest paramMultiMsgRequest)
  {
    SessionInfo localSessionInfo = paramMultiMsgRequest.a;
    int i = paramMultiMsgRequest.n;
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    localSendMsgParams.f = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    localSendMsgParams.g = System.currentTimeMillis();
    Object localObject1 = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_msg");
    Object localObject2 = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_at_list");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (i <= 0))
    {
      localSendMsgParams.m = ((String)localObject2);
      localObject2 = MessageForText.getTroopMemberInfoFromExtrJson((String)localObject2);
      String str = ChatActivityFacade.a((String)localObject1, (ArrayList)localObject2);
      if (!TextUtils.isEmpty(str)) {
        localObject1 = MessageUtils.a(str, true, (ArrayList)localObject2);
      }
      localSendMsgParams.l = ((String)localObject1);
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_msg");
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_at_list");
    }
    localObject1 = paramMessageForReplyText.mSourceMsgInfo;
    int j = 0;
    if (localObject1 != null)
    {
      localSendMsgParams.h = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText.mSourceMsgInfo);
      if (paramMessageForReplyText.getSourceMessage() != null) {
        localSendMsgParams.h.packSourceMsg(this.a, paramMessageForReplyText.getSourceMessage());
      }
      if (i > 0)
      {
        localSendMsgParams.o = paramMessageForReplyText.uniseq;
        localSendMsgParams.n = i;
        paramMessageForReplyText.atInfoList = null;
      }
      localSendMsgParams.h.mType = 0;
    }
    i = j;
    if (paramMessageForReplyText.istroop == 1)
    {
      i = j;
      if (localSessionInfo.a == 1)
      {
        i = j;
        if (localSessionInfo.b.equals(paramMessageForReplyText.frienduin)) {
          i = 1;
        }
      }
    }
    if ((!paramMultiMsgRequest.o) || (i != 0))
    {
      localSendMsgParams.i = paramMessageForReplyText.isBarrageMsg;
      localSendMsgParams.j = paramMessageForReplyText.barrageTimeLocation;
      localSendMsgParams.k = paramMessageForReplyText.barrageSourceMsgType;
    }
    return localSendMsgParams;
  }
  
  private void a(MessageForReplyText paramMessageForReplyText1, MessageForReplyText paramMessageForReplyText2)
  {
    if (paramMessageForReplyText2.getSourceMessage() == null)
    {
      QLog.d("ReplyMsgController", 1, "originMsg is null");
      return;
    }
    paramMessageForReplyText1.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText2.mSourceMsgInfo);
    MessageRecord localMessageRecord = paramMessageForReplyText2.getSourceMessage();
    paramMessageForReplyText2 = null;
    if (localMessageRecord != null) {
      if (localMessageRecord.msgtype == -1037)
      {
        paramMessageForReplyText2 = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
      }
      else if (localMessageRecord.msgtype == -1036)
      {
        paramMessageForReplyText2 = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord).rebuildLongMsg();
      }
      else if (localMessageRecord.msgtype == -1035)
      {
        paramMessageForReplyText2 = ((MessageForMixedMsg)localMessageRecord).rebuildMixedMsg();
      }
      else if (localMessageRecord.msgtype == -2011)
      {
        paramMessageForReplyText2 = new MessageForStructing(localMessageRecord);
      }
      else if (localMessageRecord.msgtype == -2000)
      {
        localMessageRecord = (MessageRecord)localMessageRecord.deepCopyByReflect();
        paramMessageForReplyText2 = localMessageRecord;
        if (!TextUtils.isEmpty(paramMessageForReplyText1.mSourceMsgInfo.mSourceMsgTroopName))
        {
          localMessageRecord.istroop = paramMessageForReplyText1.istroop;
          paramMessageForReplyText2 = localMessageRecord;
        }
      }
      else
      {
        paramMessageForReplyText2 = (MessageRecord)localMessageRecord.deepCopyByReflect();
      }
    }
    if ((paramMessageForReplyText2 == null) && (QLog.isColorLevel())) {
      QLog.d("ReplyMsgController", 2, "MessageForReplyText deepCopySourceMsg is null");
    }
    paramMessageForReplyText1.setSourceMessageRecord(paramMessageForReplyText2);
  }
  
  private void h(MultiMsgRequest paramMultiMsgRequest)
  {
    HashMap localHashMap = paramMultiMsgRequest.f;
    Iterator localIterator1 = localHashMap.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (ArrayList)localHashMap.get((String)localIterator1.next());
      if (localObject == null) {
        return;
      }
      Iterator localIterator2 = ((ArrayList)localObject).iterator();
      while (localIterator2.hasNext())
      {
        localObject = (MessageRecord)localIterator2.next();
        if ((localObject instanceof MessageForReplyText))
        {
          MessageForReplyText localMessageForReplyText = (MessageForReplyText)localObject;
          if (((MessageRecord)localObject).msg == null) {
            localObject = "";
          } else {
            localObject = ((MessageRecord)localObject).msg;
          }
          ChatActivityFacade.SendMsgParams localSendMsgParams = a(localMessageForReplyText, paramMultiMsgRequest);
          ChatActivityFacade.a(this.a, null, paramMultiMsgRequest.a, (String)localObject, localMessageForReplyText.atInfoList, localSendMsgParams);
        }
      }
    }
  }
  
  public ArrayList<MessageRecord> a(QQAppInterface paramQQAppInterface, List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (paramBoolean)
      {
        if (localMessageRecord.msgtype == -1037)
        {
          paramList = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
        }
        else if (localMessageRecord.msgtype == -1036)
        {
          paramList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord).rebuildLongMsg();
        }
        else if (localMessageRecord.msgtype == -1035)
        {
          paramList = ((MessageForMixedMsg)localMessageRecord).rebuildMixedMsg();
        }
        else if (localMessageRecord.msgtype == -2011)
        {
          paramList = new MessageForStructing(localMessageRecord);
        }
        else if (localMessageRecord.msgtype == -1049)
        {
          paramList = (MessageRecord)localMessageRecord.deepCopyByReflect();
          a((MessageForReplyText)paramList, (MessageForReplyText)localMessageRecord);
        }
        else
        {
          paramList = (MessageRecord)localMessageRecord.deepCopyByReflect();
        }
        if (paramList == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ReplyMsgController", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
          continue;
        }
        if (!TextUtils.isEmpty(paramList.getExtInfoFromExtStr("troop_at_info_list"))) {
          paramList.removeExtInfoToExtStr("troop_at_info_list");
        }
        if (!TextUtils.isEmpty(paramList.getExtInfoFromExtStr("disc_at_info_list"))) {
          paramList.removeExtInfoToExtStr("disc_at_info_list");
        }
        paramList.atInfoList = null;
        paramList.extLong = localMessageRecord.extLong;
      }
      else
      {
        paramList = localMessageRecord;
      }
      if (paramList != null)
      {
        paramList.uniseq = localMessageRecord.uniseq;
        paramList.msgseq = localMessageRecord.msgseq;
        if (FileManagerUtil.a(paramList)) {
          paramQQAppInterface.getFileManagerEngine().e().a(localMessageRecord, paramList);
        }
        MessageForReplyText localMessageForReplyText1;
        MessageForReplyText localMessageForReplyText2;
        if ((paramList instanceof MessageForReplyText))
        {
          localMessageForReplyText1 = (MessageForReplyText)localMessageRecord;
          localMessageForReplyText2 = (MessageForReplyText)paramList;
          if ((localMessageForReplyText2.getSourceMessage() != null) && (FileManagerUtil.a(localMessageForReplyText2.getSourceMessage()))) {
            paramQQAppInterface.getFileManagerEngine().e().a(localMessageForReplyText1.getSourceMessage(), localMessageForReplyText2.getSourceMessage());
          }
        }
        if ((paramList instanceof MessageForMixedMsg))
        {
          localMessageForReplyText1 = ((MessageForMixedMsg)paramList).getReplyMessage(paramQQAppInterface);
          localMessageForReplyText2 = ((MessageForMixedMsg)localMessageRecord).getReplyMessage(paramQQAppInterface);
          if ((localMessageForReplyText1 != null) && (localMessageForReplyText2 != null) && (localMessageForReplyText1.getSourceMessage() != null) && (FileManagerUtil.a(localMessageForReplyText1.getSourceMessage()))) {
            paramQQAppInterface.getFileManagerEngine().e().a(localMessageForReplyText2.getSourceMessage(), localMessageForReplyText1.getSourceMessage());
          }
        }
        if (paramList.msgtype == -2022) {
          ((MessageForShortVideo)paramList).redBagType = 0;
        }
        localArrayList.add(paramList);
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("preAddMultiMsg, MessageRecord:");
          paramList.append(localMessageRecord.toString());
          QLog.d("ReplyMsgController", 2, paramList.toString());
        }
      }
    }
    return localArrayList;
  }
  
  protected void b(MultiMsgRequest paramMultiMsgRequest) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (this.d.get()) {
      return;
    }
    if (this.a == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend result.data=");
      localStringBuilder.append(paramSendResult.l);
      QLog.d("ReplyMsgController", 2, localStringBuilder.toString());
    }
    if (paramSendResult.l == null) {
      return;
    }
    if ((paramSendResult.l instanceof String))
    {
      paramSendResult = (String)paramSendResult.l;
      paramSendResult = (MultiMsgRequest)this.c.get(paramSendResult);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSend request=");
        localStringBuilder.append(paramSendResult);
        QLog.d("ReplyMsgController", 2, localStringBuilder.toString());
      }
      if (paramSendResult == null) {
        return;
      }
      this.c.remove(paramSendResult.a());
      h(paramSendResult);
    }
  }
  
  protected void c(MultiMsgRequest paramMultiMsgRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReplyMsgController", 2, "onFailed");
    }
    UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
    localSendResult.l = paramMultiMsgRequest.a();
    b(localSendResult);
  }
  
  protected void d(MultiMsgRequest paramMultiMsgRequest)
  {
    Object localObject1 = paramMultiMsgRequest.b;
    Object localObject2 = (HashMap)paramMultiMsgRequest.c;
    localObject2 = this.a;
    int j = paramMultiMsgRequest.h;
    int i = 0;
    boolean bool;
    if (j != 2) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = a((QQAppInterface)localObject2, (List)localObject1, bool);
    localObject1 = new HashMap(1);
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
      long l = localMessageRecord.uniseq;
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localMessageRecord);
      ((HashMap)localObject1).put(String.valueOf(l), localArrayList);
    }
    paramMultiMsgRequest.f = ((HashMap)localObject1);
    if ((paramMultiMsgRequest.h != 0) && (paramMultiMsgRequest.h == 2)) {
      i = 1;
    }
    localObject1 = this.e.obtainMessage(i);
    ((Message)localObject1).obj = paramMultiMsgRequest;
    ((Message)localObject1).sendToTarget();
  }
  
  public void e(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.d.get()) {
      return;
    }
    if (this.a == null) {
      return;
    }
    if (!this.c.containsKey(paramMultiMsgRequest.a())) {
      this.c.put(paramMultiMsgRequest.a(), paramMultiMsgRequest);
    }
    Message localMessage = this.e.obtainMessage(-1);
    localMessage.obj = paramMultiMsgRequest;
    localMessage.sendToTarget();
  }
  
  public void f(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.d.get()) {
      return;
    }
    if (this.a == null) {
      return;
    }
    if (paramMultiMsgRequest.f.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "uploadRichMsg dstMsgMap is empty");
      }
      return;
    }
    paramMultiMsgRequest.a(15);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((IMultiMsgRichProcessor)localIterator.next()).a(paramMultiMsgRequest, paramMultiMsgRequest.f, this);
    }
    MultiMsgUtil.b("ReplyMsgController step.uploadRichStart", new Object[0]);
  }
  
  protected void g(MultiMsgRequest paramMultiMsgRequest)
  {
    UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
    localSendResult.l = paramMultiMsgRequest.a();
    b(localSendResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.replymsg.ReplyMsgController
 * JD-Core Version:    0.7.0.1
 */