package com.tencent.mobileqq.multimsg;

import android.os.Handler.Callback;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.util.ArrayList<Lcom.tencent.mobileqq.data.MessageRecord;>;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class MultiMsgController
  implements Handler.Callback, IMultiMsgRichUploadCallback, IUpLoadMsgPackBusinessType, DownCallBack, UpCallBack
{
  protected QQAppInterface a;
  protected List<IMultiMsgRichProcessor> a;
  protected Map<String, MultiMsgRequest> a;
  protected AtomicBoolean a;
  protected MqqHandler a;
  
  public MultiMsgController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1) {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
    paramQQAppInterface = new PicMultiMsgProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new VideoMultiMsgProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    PttMultiMsgProcessor localPttMultiMsgProcessor = new PttMultiMsgProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    FileMultiMsgProcessor localFileMultiMsgProcessor = new FileMultiMsgProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localPttMultiMsgProcessor);
    this.jdField_a_of_type_JavaUtilList.add(localFileMultiMsgProcessor);
  }
  
  public int a()
  {
    return 0;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, @NonNull ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, HashMap<String, ArrayList<MessageRecord>> paramHashMap1)
  {
    Object localObject2;
    if (paramHashMap1 == null) {
      localObject2 = new HashMap();
    } else {
      localObject2 = paramHashMap1;
    }
    ArrayList localArrayList1 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      paramHashMap1 = (MessageRecord)paramArrayList.next();
      localArrayList1.add(paramHashMap1);
      MultiMsgUtil.a(paramHashMap1, (String)paramHashMap.get(MsgProxyUtils.a(paramHashMap1)), paramMessageForStructing);
      if (MultiMsgUtil.a((ChatMessage)paramHashMap1))
      {
        Object localObject1 = (MessageForStructing)paramHashMap1;
        HashMap localHashMap = paramQQAppInterface.getMultiMessageProxy().a((MessageRecord)localObject1);
        int j;
        if (localHashMap.size() > 0)
        {
          Iterator localIterator1 = localHashMap.keySet().iterator();
          j = 0;
          paramHashMap1 = paramArrayList;
          while (localIterator1.hasNext())
          {
            paramArrayList = (String)localIterator1.next();
            ArrayList localArrayList2 = (ArrayList)localHashMap.get(paramArrayList);
            j = localArrayList2.size();
            Object localObject3 = paramArrayList;
            if (paramArrayList.equalsIgnoreCase("MultiMsg"))
            {
              localObject3 = String.valueOf(((HashMap)localObject2).size());
              ((MessageForStructing)localObject1).structingMsg.mFileName = ((String)localObject3);
              ((MessageForStructing)localObject1).doPrewrite();
            }
            Iterator localIterator2 = localArrayList2.iterator();
            paramArrayList = (ArrayList<ChatMessage>)localObject1;
            localObject1 = paramHashMap1;
            while (localIterator2.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)localIterator2.next();
              paramHashMap1 = localMessageRecord.getExtInfoFromExtStr("self_nickname");
              if (TextUtils.isEmpty(paramHashMap1)) {
                paramHashMap1 = MultiMsgManager.a().a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              Object localObject4;
              if (paramHashMap1 != null)
              {
                localObject4 = paramHashMap1;
                if (paramHashMap1.trim().length() != 0) {}
              }
              else
              {
                localObject4 = MultiMsgUtil.a(localMessageRecord.senderuin);
              }
              MultiMsgUtil.a(localMessageRecord, (String)localObject4, paramMessageForStructing);
            }
            ((HashMap)localObject2).put(localObject3, localArrayList2);
            paramHashMap1 = (HashMap<String, ArrayList<MessageRecord>>)localObject1;
            localObject1 = paramArrayList;
          }
          paramArrayList = paramHashMap1;
        }
        else
        {
          j = 0;
        }
        i += j;
      }
      i += 1;
    }
    paramMessageForStructing.structingMsg.mTSum = i;
    paramMessageForStructing.doPrewrite();
    ((HashMap)localObject2).put("MultiMsg", localArrayList1);
    MultiMsgUtil.b("step.preHandle.mTSum = %d", new Object[] { Integer.valueOf(i) });
    return localObject2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    paramMultiMsgRequest.a(paramInt2);
    paramMultiMsgRequest.a(paramInt1, paramInt2);
    if (paramMultiMsgRequest.a() == 0)
    {
      android.os.Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
      localMessage.obj = paramMultiMsgRequest;
      localMessage.sendToTarget();
    }
    MultiMsgUtil.a("step.onUploadFinish:resultCode = %d,richMask = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramMultiMsgRequest.a()), Integer.valueOf(paramMultiMsgRequest.b()) });
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(QQAppInterface paramQQAppInterface, MultiMsgRequest paramMultiMsgRequest)
  {
    List localList = paramMultiMsgRequest.jdField_b_of_type_JavaUtilList;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)localIterator.next();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.mIsUp = false;
        localTransferRequest.mFileType = 131078;
        localTransferRequest.resIdStr = localMessageForStructing.structingMsg.mResid;
        localTransferRequest.mSelfUin = localMessageForStructing.selfuin;
        localTransferRequest.mPeerUin = localMessageForStructing.frienduin;
        localTransferRequest.mSecondId = localMessageForStructing.frienduin;
        localTransferRequest.mUinType = localMessageForStructing.istroop;
        localTransferRequest.mUniseq = localMessageForStructing.uniseq;
        localTransferRequest.mBusiType = 1035;
        localTransferRequest.mDownCallBack = this;
        localTransferRequest.mRichTag = paramMultiMsgRequest.a();
        ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
        MultiMsgUtil.b("downloadNestMultiMsg mUniseq = %d,resIdStr = %s", new Object[] { Long.valueOf(localTransferRequest.mUniseq), localTransferRequest.resIdStr });
      }
      MultiMsgUtil.b("downloadNestMultiMsg msgSize = %d ", new Object[] { Integer.valueOf(localList.size()) });
    }
  }
  
  protected void a(MultiMsgRequest paramMultiMsgRequest)
  {
    Object localObject1 = paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (ArrayList)paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if ((localObject3 instanceof MessageForReplyText))
          {
            localObject3 = (MessageForReplyText)localObject3;
            if ((((MessageForReplyText)localObject3).getSourceMessage() != null) && (((MessageForReplyText)localObject3).mSourceMsgInfo != null))
            {
              ((MessageForReplyText)localObject3).getSourceMessage().createMessageUniseq();
              ((MessageForReplyText)localObject3).mSourceMsgInfo.setUniSeq(((MessageForReplyText)localObject3).getSourceMessage().uniseq, true);
              ((MessageForReplyText)localObject3).mSourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForReplyText)localObject3).getSourceMessage());
              if ((paramMultiMsgRequest.g > 0) || (paramMultiMsgRequest.jdField_b_of_type_Int == 0) || (paramMultiMsgRequest.jdField_b_of_type_Int == 9))
              {
                ((MessageForReplyText)localObject3).mSourceMsgInfo.mSourceMsgTroopName = null;
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A5D2", "0X800A5D2", 0, 0, "", "", "", "");
              }
              try
              {
                ((MessageForReplyText)localObject3).saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.a(((MessageForReplyText)localObject3).mSourceMsgInfo)));
                if (FileManagerUtil.a(((MessageForReplyText)localObject3).getSourceMessage()))
                {
                  String str = ((MessageForReplyText)localObject3).getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                  ChatMessage localChatMessage = FileManagerUtil.a((ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                  QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, ((MessageForReplyText)localObject3).getSourceMessage());
                  if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
                  {
                    int i = Integer.parseInt(str);
                    if ((i == 1) || (i == 2)) {
                      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                    }
                  }
                }
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
    }
    if (paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap.containsKey("reply_msg")) {
      paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap.remove("reply_msg");
    }
    b(paramMultiMsgRequest);
    if (paramMultiMsgRequest.b() != 0)
    {
      c(paramMultiMsgRequest);
      return;
    }
    localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    ((android.os.Message)localObject1).obj = paramMultiMsgRequest;
    ((android.os.Message)localObject1).sendToTarget();
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject1 = paramDownResult.d;
    long l = paramDownResult.jdField_a_of_type_Long;
    MultiMsgRequest localMultiMsgRequest = (MultiMsgRequest)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
    MultiMsgUtil.b("onDownloadResp: mUniseq = %d,resIdStr = %s,errcode = %d", new Object[] { Long.valueOf(l), paramDownResult.e, Integer.valueOf(paramDownResult.jdField_b_of_type_Int) });
    if (localMultiMsgRequest == null) {
      return;
    }
    List localList = localMultiMsgRequest.jdField_b_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    try
    {
      Iterator localIterator = localList.iterator();
      localObject1 = null;
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (MessageForStructing)localIterator.next();
        if (((MessageForStructing)localObject2).uniseq == l) {
          localObject1 = localObject2;
        }
      }
      if (localObject1 == null) {
        return;
      }
      if (paramDownResult.jdField_b_of_type_Int == 0)
      {
        localList.remove(localObject1);
        localObject2 = new HashMap();
        localQQAppInterface.getProxyManager().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, (HashMap)localObject2, (MessageRecord)localObject1, null);
      }
      else
      {
        paramDownResult = localQQAppInterface.getMultiMessageProxy().a((MessageRecord)localObject1, MultiMsgConstant.b, false);
        int i = localMultiMsgRequest.jdField_a_of_type_JavaUtilList.indexOf(localObject1);
        if (i >= 0) {
          localMultiMsgRequest.jdField_a_of_type_JavaUtilList.set(i, (ChatMessage)paramDownResult);
        }
      }
      if ((localList == null) || (localList.size() == 0)) {
        e(localMultiMsgRequest);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramDownResult;
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public boolean a(QQAppInterface paramQQAppInterface, MultiMsgRequest paramMultiMsgRequest)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramMultiMsgRequest.jdField_a_of_type_JavaUtilList;
    Iterator localIterator = localList.iterator();
    boolean bool1;
    for (;;)
    {
      boolean bool2 = localIterator.hasNext();
      bool1 = false;
      if (!bool2) {
        break;
      }
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (MultiMsgUtil.a(localChatMessage))
      {
        Object localObject = (MessageForStructing)localChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mResid == null))
        {
          localObject = paramQQAppInterface.getMultiMessageProxy().a(localChatMessage, MultiMsgConstant.jdField_a_of_type_JavaLangString, false);
          localList.set(localList.indexOf(localChatMessage), (ChatMessage)localObject);
        }
        else if (paramQQAppInterface.getMultiMessageProxy().a((MessageRecord)localObject).size() == 0)
        {
          localArrayList.add(localObject);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      bool1 = true;
      paramMultiMsgRequest.jdField_b_of_type_JavaUtilList = localArrayList;
    }
    return bool1;
  }
  
  protected void b(MultiMsgRequest paramMultiMsgRequest)
  {
    MultiMsgProxy localMultiMsgProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy();
    Iterator localIterator = paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ArrayList)paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord instanceof MessageForReplyText))
          {
            if (localMultiMsgProxy != null) {
              localMultiMsgProxy.a(localMessageRecord, null);
            }
          }
          else if (((localMessageRecord instanceof MessageForMixedMsg)) && (((MessageForMixedMsg)localMessageRecord).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) && (localMultiMsgProxy != null)) {
            localMultiMsgProxy.a(localMessageRecord, null);
          }
        }
      }
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    int j = 0;
    try
    {
      long l = ((Long)paramSendResult.jdField_a_of_type_JavaLangObject).longValue();
      Object localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      Object localObject1 = null;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (((MultiMsgRequest)this.jdField_a_of_type_JavaUtilMap.get(localObject3)).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq == l) {
          localObject1 = (MultiMsgRequest)this.jdField_a_of_type_JavaUtilMap.get(localObject3);
        }
      }
      if (localObject1 == null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(((MultiMsgRequest)localObject1).a());
      localObject2 = ((MultiMsgRequest)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      Object localObject3 = ((MultiMsgRequest)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int i = ((MultiMsgRequest)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((MultiMsgRequest)localObject1).jdField_b_of_type_Int == 2)
      {
        if (paramSendResult.jdField_a_of_type_Int == 0)
        {
          ((MessageForStructing)localObject2).structingMsg.mResid = paramSendResult.c;
          ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
        }
        i = ((MultiMsgRequest)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.g;
        new MultiMsgManager.MsgForwardWXUploadCallback(localQQAppInterface, (MessageRecord)localObject2, (String)localObject3, i, (ArrayList)((MultiMsgRequest)localObject1).jdField_a_of_type_JavaUtilHashMap.get("MultiMsg"), (HashMap)((MultiMsgRequest)localObject1).jdField_a_of_type_JavaUtilMap).b(paramSendResult);
      }
      else if (paramSendResult.jdField_a_of_type_Int == 0)
      {
        ((MessageForStructing)localObject2).structingMsg.mResid = paramSendResult.c;
        ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
        localQQAppInterface.getMessageFacade().a((String)localObject3, i, ((MessageForStructing)localObject2).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
        localQQAppInterface.getMessageFacade().b((MessageRecord)localObject2, null);
      }
      else
      {
        ((MultiMsgRequest)localObject1).a(1, 65536);
        c((MultiMsgRequest)localObject1);
      }
      MultiMsgUtil.a("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramSendResult.jdField_a_of_type_Int), Long.valueOf(((MessageForStructing)localObject2).uniseq), Integer.valueOf(((MultiMsgRequest)localObject1).a()), Integer.valueOf(((MultiMsgRequest)localObject1).b()) });
      if (i == 0) {}
      do
      {
        i = 1;
        break label472;
        if ((i == 3000) || (i == 1)) {
          break label470;
        }
        if ((i == 1000) || (i == 1004)) {
          break;
        }
      } while (!ChatActivityUtils.a(localQQAppInterface, ((MultiMsgRequest)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
      i = 4;
      break label472;
      i = 3;
      break label472;
      label470:
      i = 2;
      label472:
      paramSendResult = ((MessageForStructing)localObject2).frienduin;
      int i1 = ((MessageForStructing)localObject2).structingMsg.mTSum;
      int i2 = ((MultiMsgRequest)localObject1).c;
      int i3 = ((MultiMsgRequest)localObject1).d;
      int i4 = ((MultiMsgRequest)localObject1).e;
      int i5 = ((MultiMsgRequest)localObject1).f;
      localObject1 = ((MultiMsgRequest)localObject1).jdField_a_of_type_JavaUtilHashMap;
      localObject2 = ((HashMap)localObject1).keySet().iterator();
      int n = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((ArrayList)((HashMap)localObject1).get((String)((Iterator)localObject2).next())).iterator();
        int m = j;
        int k = n;
        for (;;)
        {
          n = k;
          j = m;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (MessageRecord)((Iterator)localObject3).next();
          if (((MessageRecord)localObject4).msgtype == -2022) {
            m += 1;
          } else if ((((MessageRecord)localObject4).msgtype == -2005) || (((MessageRecord)localObject4).msgtype == -2017)) {
            k += 1;
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i2 + i3 + i4 + i5);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(j);
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(n);
      ReportController.b(localQQAppInterface, "CliOper", "", paramSendResult, "0X8009AC0", "0X8009AC0", i, 0, (String)localObject1, (String)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString());
      return;
    }
    catch (Exception paramSendResult)
    {
      QLog.e("MultiMsg_TAG", 1, paramSendResult, new Object[0]);
    }
  }
  
  protected void c(MultiMsgRequest paramMultiMsgRequest)
  {
    if (paramMultiMsgRequest == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    MessageForStructing localMessageForStructing = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    String str = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localMessageForStructing.extraflag = 32768;
    localQQAppInterface.getMsgCache().a(str, i, localMessageForStructing.uniseq);
    paramMultiMsgRequest = localQQAppInterface.getMessageFacade().getLastMessage(str, i);
    if ((paramMultiMsgRequest != null) && (paramMultiMsgRequest.uniseq == localMessageForStructing.uniseq)) {
      paramMultiMsgRequest.extraflag = 32768;
    }
    long l = localMessageForStructing.uniseq;
    ((MessageHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(i), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  protected void d(MultiMsgRequest paramMultiMsgRequest) {}
  
  public void e(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramMultiMsgRequest.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramMultiMsgRequest.a(), paramMultiMsgRequest);
    }
    if (a((QQAppInterface)localObject, paramMultiMsgRequest))
    {
      a((QQAppInterface)localObject, paramMultiMsgRequest);
      return;
    }
    int i;
    if (paramMultiMsgRequest.jdField_a_of_type_Int == 0) {
      i = 0;
    } else {
      i = 2;
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
    ((android.os.Message)localObject).obj = paramMultiMsgRequest;
    ((android.os.Message)localObject).sendToTarget();
  }
  
  public void f(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null) {
      return;
    }
    Object localObject3 = paramMultiMsgRequest.jdField_a_of_type_JavaUtilList;
    HashMap localHashMap = (HashMap)paramMultiMsgRequest.jdField_a_of_type_JavaUtilMap;
    Object localObject2 = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    localObject3 = a((QQAppInterface)localObject1, (MessageForStructing)localObject2, (ArrayList)localObject3, localHashMap, null);
    localObject1 = ((QQAppInterface)localObject1).getProxyManager().a().a((MessageRecord)localObject2, (HashMap)localObject3, null, true, true);
    paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    if (((HashMap)localObject1).size() == 0) {
      return;
    }
    paramMultiMsgRequest.a(15);
    localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((IMultiMsgRichProcessor)((Iterator)localObject2).next()).a(paramMultiMsgRequest, (HashMap)localObject1, this);
    }
    MultiMsgUtil.b("step.uploadRichStart", new Object[0]);
  }
  
  protected void g(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    byte[] arrayOfByte = localQQAppInterface.getProxyManager().a().a(paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap, (HashMap)paramMultiMsgRequest.jdField_a_of_type_JavaUtilMap, true);
    if (arrayOfByte == null)
    {
      paramMultiMsgRequest.a(99, 99);
      c(paramMultiMsgRequest);
      return;
    }
    String str1 = localQQAppInterface.getAccount();
    String str2 = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    String str3 = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
    int i = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    paramMultiMsgRequest.c = arrayOfByte.length;
    paramMultiMsgRequest = new TransferRequest();
    paramMultiMsgRequest.mIsUp = true;
    paramMultiMsgRequest.mFileType = 131078;
    paramMultiMsgRequest.multiMsgType = 0;
    paramMultiMsgRequest.toSendData = arrayOfByte;
    paramMultiMsgRequest.mSelfUin = str1;
    paramMultiMsgRequest.mPeerUin = str2;
    paramMultiMsgRequest.mSecondId = str3;
    paramMultiMsgRequest.mUinType = i;
    paramMultiMsgRequest.mUniseq = l;
    paramMultiMsgRequest.mBusiType = 1035;
    paramMultiMsgRequest.mUpCallBack = this;
    paramMultiMsgRequest.upMsgBusiType = a();
    ((ITransFileController)localQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramMultiMsgRequest);
    MultiMsgUtil.b("step.uploadPb.uniseq = %d,fileSize = %d", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) });
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    MultiMsgRequest localMultiMsgRequest = (MultiMsgRequest)paramMessage.obj;
    int i = paramMessage.what;
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 3) {
            a(localMultiMsgRequest);
          }
        }
        else {
          g(localMultiMsgRequest);
        }
      }
      else {
        f(localMultiMsgRequest);
      }
    }
    else {
      d(localMultiMsgRequest);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgController
 * JD-Core Version:    0.7.0.1
 */