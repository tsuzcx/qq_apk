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
    Object localObject1 = paramHashMap1;
    if (paramHashMap1 == null) {
      localObject1 = new HashMap();
    }
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = paramArrayList.iterator();
    int j;
    for (int i = 0; localIterator1.hasNext(); i = j + 1)
    {
      paramArrayList = (MessageRecord)localIterator1.next();
      localArrayList1.add(paramArrayList);
      MultiMsgUtil.a(paramArrayList, (String)paramHashMap.get(MsgProxyUtils.a(paramArrayList)), paramMessageForStructing);
      j = i;
      if (MultiMsgUtil.a((ChatMessage)paramArrayList))
      {
        j = 0;
        int k = 0;
        MessageForStructing localMessageForStructing = (MessageForStructing)paramArrayList;
        HashMap localHashMap = paramQQAppInterface.getMultiMessageProxy().a(localMessageForStructing);
        if (localHashMap.size() > 0)
        {
          Iterator localIterator2 = localHashMap.keySet().iterator();
          j = k;
          while (localIterator2.hasNext())
          {
            paramArrayList = (String)localIterator2.next();
            ArrayList localArrayList2 = (ArrayList)localHashMap.get(paramArrayList);
            j = localArrayList2.size();
            paramHashMap1 = paramArrayList;
            if (paramArrayList.equalsIgnoreCase("MultiMsg"))
            {
              paramHashMap1 = String.valueOf(((HashMap)localObject1).size());
              localMessageForStructing.structingMsg.mFileName = paramHashMap1;
              localMessageForStructing.doPrewrite();
            }
            Iterator localIterator3 = localArrayList2.iterator();
            while (localIterator3.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)localIterator3.next();
              Object localObject2 = localMessageRecord.getExtInfoFromExtStr("self_nickname");
              paramArrayList = (ArrayList<ChatMessage>)localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                paramArrayList = MultiMsgManager.a().a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              if (paramArrayList != null)
              {
                localObject2 = paramArrayList;
                if (paramArrayList.trim().length() != 0) {}
              }
              else
              {
                localObject2 = MultiMsgUtil.a(localMessageRecord.senderuin);
              }
              MultiMsgUtil.a(localMessageRecord, (String)localObject2, paramMessageForStructing);
            }
            ((HashMap)localObject1).put(paramHashMap1, localArrayList2);
          }
        }
        j = i + j;
      }
    }
    paramMessageForStructing.structingMsg.mTSum = i;
    paramMessageForStructing.doPrewrite();
    ((HashMap)localObject1).put("MultiMsg", localArrayList1);
    MultiMsgUtil.b("step.preHandle.mTSum = %d", new Object[] { Integer.valueOf(i) });
    return localObject1;
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
    if ((localList == null) || (localList.size() == 0)) {
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
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    Object localObject2;
    long l;
    MultiMsgRequest localMultiMsgRequest;
    List localList;
    do
    {
      do
      {
        do
        {
          return;
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        } while (localQQAppInterface == null);
        localObject2 = paramDownResult.d;
        l = paramDownResult.jdField_a_of_type_Long;
        localMultiMsgRequest = (MultiMsgRequest)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        MultiMsgUtil.b("onDownloadResp: mUniseq = %d,resIdStr = %s,errcode = %d", new Object[] { Long.valueOf(l), paramDownResult.e, Integer.valueOf(paramDownResult.jdField_b_of_type_Int) });
      } while (localMultiMsgRequest == null);
      localList = localMultiMsgRequest.jdField_b_of_type_JavaUtilList;
    } while (localList == null);
    label288:
    for (;;)
    {
      try
      {
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (MessageForStructing)localIterator.next();
          if (((MessageForStructing)localObject2).uniseq != l) {
            break label288;
          }
          localObject1 = localObject2;
          break label288;
        }
        if (localObject1 == null) {
          return;
        }
      }
      finally {}
      if (paramDownResult.jdField_b_of_type_Int == 0)
      {
        localList.remove(localObject1);
        localObject2 = new HashMap();
        localQQAppInterface.getProxyManager().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, (HashMap)localObject2, localObject1, null);
      }
      for (;;)
      {
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        e(localMultiMsgRequest);
        return;
        paramDownResult = localQQAppInterface.getMultiMessageProxy().a(localObject1, MultiMsgConstant.b, false);
        int i = localMultiMsgRequest.jdField_a_of_type_JavaUtilList.indexOf(localObject1);
        if (i >= 0) {
          localMultiMsgRequest.jdField_a_of_type_JavaUtilList.set(i, (ChatMessage)paramDownResult);
        }
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public boolean a(QQAppInterface paramQQAppInterface, MultiMsgRequest paramMultiMsgRequest)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramMultiMsgRequest.jdField_a_of_type_JavaUtilList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
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
          localArrayList.add((MessageForStructing)localChatMessage);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      paramMultiMsgRequest.jdField_b_of_type_JavaUtilList = localArrayList;
      return true;
    }
    return false;
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
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    label769:
    for (;;)
    {
      Object localObject1;
      try
      {
        long l = ((Long)paramSendResult.jdField_a_of_type_JavaLangObject).longValue();
        localObject1 = null;
        localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (((MultiMsgRequest)this.jdField_a_of_type_JavaUtilMap.get(localObject3)).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq != l) {
            break label769;
          }
          localObject1 = (MultiMsgRequest)this.jdField_a_of_type_JavaUtilMap.get(localObject3);
          continue;
        }
        if (localObject1 == null) {
          break;
        }
      }
      catch (Exception paramSendResult)
      {
        QLog.e("MultiMsg_TAG", 1, paramSendResult, new Object[0]);
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(((MultiMsgRequest)localObject1).a());
      Object localObject2 = ((MultiMsgRequest)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
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
        MultiMsgUtil.a("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramSendResult.jdField_a_of_type_Int), Long.valueOf(((MessageForStructing)localObject2).uniseq), Integer.valueOf(((MultiMsgRequest)localObject1).a()), Integer.valueOf(((MultiMsgRequest)localObject1).b()) });
        if (i != 0) {
          break label563;
        }
        i = 1;
      }
      for (;;)
      {
        label331:
        paramSendResult = ((MessageForStructing)localObject2).frienduin;
        int m = ((MessageForStructing)localObject2).structingMsg.mTSum;
        int n = ((MultiMsgRequest)localObject1).c;
        int i1 = ((MultiMsgRequest)localObject1).d;
        int i2 = ((MultiMsgRequest)localObject1).e;
        int i3 = ((MultiMsgRequest)localObject1).f;
        localObject1 = ((MultiMsgRequest)localObject1).jdField_a_of_type_JavaUtilHashMap;
        localObject2 = ((HashMap)localObject1).keySet().iterator();
        int k = 0;
        int j = 0;
        label648:
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label651;
          }
          localObject3 = ((ArrayList)((HashMap)localObject1).get((String)((Iterator)localObject2).next())).iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label648;
            }
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            if (localMessageRecord.msgtype == -2022)
            {
              j += 1;
              continue;
              if (paramSendResult.jdField_a_of_type_Int == 0)
              {
                ((MessageForStructing)localObject2).structingMsg.mResid = paramSendResult.c;
                ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
                localQQAppInterface.getMessageFacade().a((String)localObject3, i, ((MessageForStructing)localObject2).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
                localQQAppInterface.getMessageFacade().b((MessageRecord)localObject2, null);
                break;
              }
              ((MultiMsgRequest)localObject1).a(1, 65536);
              c((MultiMsgRequest)localObject1);
              break;
              label563:
              if ((i == 3000) || (i == 1))
              {
                i = 2;
                break label331;
              }
              if ((i == 1000) || (i == 1004))
              {
                i = 3;
                break label331;
              }
              if (!ChatActivityUtils.a(localQQAppInterface, ((MultiMsgRequest)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
                break label764;
              }
              i = 4;
              break label331;
            }
            if ((localMessageRecord.msgtype == -2005) || (localMessageRecord.msgtype == -2017)) {
              k += 1;
            }
          }
        }
        label651:
        ReportController.b(localQQAppInterface, "CliOper", "", paramSendResult, "0X8009AC0", "0X8009AC0", i, 0, m + "", n + i1 + i2 + i3 + "", "" + j, "" + k);
        return;
        label764:
        i = 1;
      }
    }
  }
  
  protected void c(MultiMsgRequest paramMultiMsgRequest)
  {
    if (paramMultiMsgRequest == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    MessageForStructing localMessageForStructing = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    String str = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localMessageForStructing.extraflag = 32768;
    localQQAppInterface.getMsgCache().a(str, i, localMessageForStructing.uniseq);
    paramMultiMsgRequest = localQQAppInterface.getMessageFacade().a(str, i);
    if ((paramMultiMsgRequest != null) && (paramMultiMsgRequest.uniseq == localMessageForStructing.uniseq)) {
      paramMultiMsgRequest.extraflag = 32768;
    }
    long l = localMessageForStructing.uniseq;
    ((MessageHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(i), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  protected void d(MultiMsgRequest paramMultiMsgRequest) {}
  
  public void e(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localObject == null);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramMultiMsgRequest.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramMultiMsgRequest.a(), paramMultiMsgRequest);
    }
    if (a((QQAppInterface)localObject, paramMultiMsgRequest))
    {
      a((QQAppInterface)localObject, paramMultiMsgRequest);
      return;
    }
    if (paramMultiMsgRequest.jdField_a_of_type_Int == 0) {}
    for (int i = 0;; i = 2)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((android.os.Message)localObject).obj = paramMultiMsgRequest;
      ((android.os.Message)localObject).sendToTarget();
      return;
    }
  }
  
  public void f(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      } while (localObject1 == null);
      Object localObject3 = paramMultiMsgRequest.jdField_a_of_type_JavaUtilList;
      HashMap localHashMap = (HashMap)paramMultiMsgRequest.jdField_a_of_type_JavaUtilMap;
      localObject2 = paramMultiMsgRequest.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      localObject3 = a((QQAppInterface)localObject1, (MessageForStructing)localObject2, (ArrayList)localObject3, localHashMap, null);
      localObject1 = ((QQAppInterface)localObject1).getProxyManager().a().a((MessageRecord)localObject2, (HashMap)localObject3, null, true, true);
      paramMultiMsgRequest.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    } while (((HashMap)localObject1).size() == 0);
    paramMultiMsgRequest.a(15);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((IMultiMsgRichProcessor)((Iterator)localObject2).next()).a(paramMultiMsgRequest, (HashMap)localObject1, this);
    }
    MultiMsgUtil.b("step.uploadRichStart", new Object[0]);
  }
  
  protected void g(MultiMsgRequest paramMultiMsgRequest)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d(localMultiMsgRequest);
      continue;
      f(localMultiMsgRequest);
      continue;
      g(localMultiMsgRequest);
      continue;
      a(localMultiMsgRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgController
 * JD-Core Version:    0.7.0.1
 */