package com.tencent.mobileqq.msgbackup.controller;

import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msgbackup.data.MsgBackupDBHelper;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgProxy;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupSessionInfo;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReportData;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class MsgBackupController
  implements Handler.Callback, Comparator<MessageRecord>
{
  private static int jdField_a_of_type_Int = 500;
  public static String a;
  private static int jdField_b_of_type_Int = 5000;
  private static int jdField_c_of_type_Int = 1000;
  private static int jdField_d_of_type_Int = 10000;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MsgBackupRequest jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<IMsgBackupRichProcessor> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, MsgBackupDBHelper> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, MsgBackupSessionRequest> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private ConcurrentHashMap<String, MsgBackupSessionRequest> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap<String, MsgBackupSessionRequest> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int jdField_e_of_type_Int;
  private ConcurrentHashMap<String, String> jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = "MsgBackup_MsgBackupController";
  }
  
  public MsgBackupController(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1) {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
    if (this.jdField_b_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_b_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("MsgbackupController_request", 5);
      this.jdField_b_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper(), this);
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("MsgbackupController_flow", 5);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), new MsgBackupController.1(this));
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null)
    {
      int i = Runtime.getRuntime().availableProcessors();
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "MsgBackupController cpuCount = %d ", new Object[] { Integer.valueOf(i) });
      paramQQAppInterface = new ThreadPoolParams();
      int j = i * 2 + 1;
      paramQQAppInterface.corePoolsize = i;
      paramQQAppInterface.maxPooolSize = j;
      paramQQAppInterface.priority = 5;
      paramQQAppInterface.poolThreadName = "msgbackupThreadPool";
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(paramQQAppInterface);
      jdField_b_of_type_Int = jdField_a_of_type_Int * j;
      jdField_d_of_type_Int = jdField_c_of_type_Int * j;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramQQAppInterface = new MsgBackupMultiMsgProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new RichMediaProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    MsgBackupFileProcessor localMsgBackupFileProcessor = new MsgBackupFileProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localMsgBackupFileProcessor);
  }
  
  private int a(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, QQMessageFacade paramQQMessageFacade, int paramInt1, int paramInt2)
  {
    int j;
    do
    {
      j = paramMsgBackupSessionRequest.h + 1;
      List localList = paramQQMessageFacade.a(paramQQMessageFacade.a(paramString, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, j, jdField_a_of_type_Int, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean), paramString);
      i = paramInt2;
      if (localList == null) {
        break;
      }
      i = paramInt2;
      if (localList.size() <= 0) {
        break;
      }
      i = localList.size();
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu slowDB queryMsgSize = %d", new Object[] { Integer.valueOf(i) });
      MsgBackupController.3 local3 = new MsgBackupController.3(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, localList, j);
      this.jdField_e_of_type_Int += jdField_a_of_type_Int;
      j = paramInt2 + jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.h = ((int)((MessageRecord)localList.get(localList.size() - 1)).getId());
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(local3);
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.h) });
      i = j;
      if (j >= paramInt1) {
        break;
      }
      paramInt2 = j;
    } while (this.jdField_e_of_type_Int < jdField_b_of_type_Int);
    int i = j;
    return i;
  }
  
  private String a(String paramString, int paramInt)
  {
    return String.format("%s_%d", new Object[] { paramString, Integer.valueOf(MsgBackupUtil.b(paramInt)) });
  }
  
  private void a(Message paramMessage)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          d();
          return;
        case 2: 
          e();
          return;
        case 3: 
          h();
          return;
        case 4: 
          g();
          return;
        case 6: 
          c();
          return;
        }
      } while (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0);
      paramMessage = (MsgBackupSessionRequest)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.elements().nextElement();
    } while (paramMessage == null);
    b(paramMessage);
  }
  
  private void a(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, QQMessageFacade paramQQMessageFacade, int paramInt1, int paramInt2)
  {
    do
    {
      int i = paramMsgBackupSessionRequest.h + 1;
      List localList = paramQQMessageFacade.b(paramQQMessageFacade.a(paramString, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, i, jdField_a_of_type_Int, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean), paramString);
      if ((localList == null) || (localList.size() <= 0)) {
        break;
      }
      int j = localList.size();
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu quickDB queryMsgSize = %d", new Object[] { Integer.valueOf(j) });
      MsgBackupController.2 local2 = new MsgBackupController.2(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, localList, i);
      this.jdField_e_of_type_Int += jdField_a_of_type_Int;
      paramInt2 += jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.h = ((int)((MessageRecord)localList.get(localList.size() - 1)).getId());
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(local2);
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.h) });
    } while ((paramInt2 < paramInt1) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int));
    do
    {
      return;
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) });
    } while ((this.jdField_e_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest == null) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback == null));
    paramString = new MsgBackupSessionInfo();
    paramString.jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
    paramString.jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, paramString);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    paramMsgBackupDBHelper.a();
  }
  
  private void a(MsgBackupDBHelper paramMsgBackupDBHelper, MessageRecord paramMessageRecord)
  {
    List localList = paramMsgBackupDBHelper.a(paramMessageRecord.msgBackupMsgSeq, paramMessageRecord.msgBackupMsgRandom);
    Iterator localIterator1;
    if ((localList != null) && (localList.size() > 0))
    {
      localIterator1 = localList.iterator();
      do
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        paramMsgBackupDBHelper = (MsgBackupResEntity)localIterator1.next();
      } while (paramMsgBackupDBHelper.msgType != 4);
    }
    for (;;)
    {
      if (paramMsgBackupDBHelper != null)
      {
        paramMsgBackupDBHelper = MsgBackupMultiMsgProcessor.b(paramMessageRecord, paramMsgBackupDBHelper);
        MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "multimsg_tempFilPath = %s", new Object[] { paramMsgBackupDBHelper });
        paramMsgBackupDBHelper = new File(paramMsgBackupDBHelper);
        if (paramMsgBackupDBHelper.exists())
        {
          MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "multimsg_tempFilPath exist = %b", new Object[] { Boolean.valueOf(true) });
          paramMsgBackupDBHelper = FileUtils.a(paramMsgBackupDBHelper);
          paramMsgBackupDBHelper = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a(paramMsgBackupDBHelper, null, paramMessageRecord, null);
          if ((paramMsgBackupDBHelper != null) && (paramMsgBackupDBHelper.size() > 0))
          {
            localIterator1 = MsgBackupMultiMsgProcessor.a(paramMsgBackupDBHelper).iterator();
            for (;;)
            {
              if (!localIterator1.hasNext()) {
                break label248;
              }
              MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
              Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
              if (localIterator2.hasNext())
              {
                IMsgBackupRichProcessor localIMsgBackupRichProcessor = (IMsgBackupRichProcessor)localIterator2.next();
                if (!localIMsgBackupRichProcessor.a(localMessageRecord)) {
                  break;
                }
                localIMsgBackupRichProcessor.b(localMessageRecord, localList);
              }
            }
            label248:
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a(paramMessageRecord, paramMsgBackupDBHelper, null);
          }
        }
      }
      return;
      paramMsgBackupDBHelper = null;
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    MsgBackupTransportProcessor.a().a(paramString1, paramString2, paramLong);
  }
  
  private void a(List<MsgBackupResEntity> paramList, MsgBackupSessionRequest paramMsgBackupSessionRequest, int paramInt)
  {
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:query res.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label286;
      }
      MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)localIterator.next();
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (IMsgBackupRichProcessor)((Iterator)localObject2).next();
        if (!((IMsgBackupRichProcessor)localObject1).a(localMsgBackupResEntity)) {
          break;
        }
        MsgBackupReporter.a();
        localObject2 = MsgBackupReporter.a;
        ((MsgBackupReportData)localObject2).d += 1L;
        localObject2 = ((IMsgBackupRichProcessor)localObject1).a(null, localMsgBackupResEntity);
        if (((ResDownloadObject)localObject2).a())
        {
          localObject1 = ((ResDownloadObject)localObject2).a((IMsgBackupRichProcessor)localObject1, null, localMsgBackupResEntity);
          MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:need res:uin = %s,uinType = %d,msgType = %d,filePath = %s,clientPath = %s, filesize = %s", new Object[] { paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, Integer.valueOf(paramMsgBackupSessionRequest.jdField_a_of_type_Int), Integer.valueOf(localMsgBackupResEntity.msgType), localMsgBackupResEntity.filePath, localObject1, Long.valueOf(localMsgBackupResEntity.fileSize) });
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:need res,but clientPath is empty", new Object[0]);
          }
          else if (!this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject1))
          {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, "");
            a(localMsgBackupResEntity.filePath, (String)localObject1, localMsgBackupResEntity.fileSize);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        label286:
        paramMsgBackupSessionRequest.f += paramList.size();
        this.jdField_e_of_type_Int -= paramInt;
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step segment startNext,,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int) });
        if (paramMsgBackupSessionRequest.f >= paramMsgBackupSessionRequest.jdField_e_of_type_Int)
        {
          this.jdField_e_of_type_Int = 0;
          if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
          {
            a(null, null, 0L);
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            MsgBackupTimeStats.a("statis_qianchums_end");
            MsgBackupTimeStats.e();
            return;
          }
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
          continue;
        }
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      finally {}
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(5);
    }
  }
  
  private void a(List<MessageRecord> paramList1, ArrayList<MessageRecord> paramArrayList, List<MessageRecord> paramList2)
  {
    paramList1 = paramList1.iterator();
    label299:
    label303:
    for (;;)
    {
      MessageRecord localMessageRecord1;
      label48:
      MessageRecord localMessageRecord2;
      int i;
      if (paramList1.hasNext())
      {
        localMessageRecord1 = (MessageRecord)paramList1.next();
        if ((paramList2 == null) || (paramList2.size() <= 0)) {
          break label299;
        }
        Iterator localIterator = paramList2.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localMessageRecord2 = (MessageRecord)localIterator.next();
            if ((localMessageRecord1.istroop == 1) || (localMessageRecord1.istroop == 1026) || (localMessageRecord1.istroop == 3000))
            {
              if (localMessageRecord1.shmsgseq == 0L) {
                MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated troopMsg ,mr.msgshseq = 0.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg, Integer.valueOf(localMessageRecord1.msgtype) });
              }
              if ((localMessageRecord1.shmsgseq != localMessageRecord2.shmsgseq) || (localMessageRecord1.msgtype != localMessageRecord2.msgtype)) {
                continue;
              }
              MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg, Integer.valueOf(localMessageRecord1.msgtype) });
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label303;
        }
        paramArrayList.add(localMessageRecord1);
        break;
        if ((localMessageRecord1.msgUid != localMessageRecord2.msgUid) || (localMessageRecord1.msgtype != localMessageRecord2.msgtype)) {
          break label48;
        }
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg });
        i = 1;
        continue;
        return;
        i = 0;
      }
    }
  }
  
  private void b(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, QQMessageFacade paramQQMessageFacade, int paramInt1, int paramInt2)
  {
    do
    {
      int i = paramMsgBackupSessionRequest.h + 1;
      Object localObject = paramQQMessageFacade.a(paramString, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, i, jdField_a_of_type_Int, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean);
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu querySql = %s", new Object[] { localObject });
      localObject = paramQQMessageFacade.b((String)localObject, paramString);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      int j = ((List)localObject).size();
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = %d", new Object[] { Integer.valueOf(j) });
      MsgBackupController.4 local4 = new MsgBackupController.4(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, (List)localObject, i);
      this.jdField_e_of_type_Int += jdField_a_of_type_Int;
      paramInt2 += jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.h = ((int)((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).getId());
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu querySql lastQueryIndex = %d", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.h) });
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(local4);
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.h) });
    } while ((paramInt2 < paramInt1) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int));
    do
    {
      return;
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) });
    } while ((this.jdField_e_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest == null) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback == null));
    paramString = new MsgBackupSessionInfo();
    paramString.jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
    paramString.jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, paramString);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    paramMsgBackupDBHelper.a();
  }
  
  private void c()
  {
    f();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_c_of_type_Int != -1) {
        break label268;
      }
      MsgBackupTimeStats.a(null, "single_uin_cost");
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
      ((MsgBackupRequest)localObject1).jdField_c_of_type_Int += 1;
      int i = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_b_of_type_Int;
      if (i == 0) {
        MsgBackupTimeStats.a("statis_qianchums_start");
      }
      if (i == j)
      {
        MsgBackupTimeStats.a("statis_qianchums_end");
        MsgBackupTimeStats.d();
      }
      if (i < j)
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = (MsgBackupSessionRequest)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        ((MsgBackupSessionRequest)localObject1).g = 0;
        Object localObject2 = MsgBackupUtil.a((MsgBackupSessionRequest)localObject1);
        MsgBackupDBHelper.a((String)localObject2);
        localObject2 = new MsgBackupDBHelper((String)localObject2);
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(MsgBackupManager.jdField_a_of_type_JavaLangString))
        {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "file meta is %s, key is %s", new Object[] { MsgBackupManager.jdField_a_of_type_JavaLangString, MsgBackupManager.b });
          MsgBackupExtraEntity localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "key_meta";
          localMsgBackupExtraEntity.value = MsgBackupManager.jdField_a_of_type_JavaLangString;
          localArrayList.add(localMsgBackupExtraEntity);
          localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "db_version";
          localMsgBackupExtraEntity.value = String.valueOf(1);
          localArrayList.add(localMsgBackupExtraEntity);
        }
        ((MsgBackupDBHelper)localObject2).c(localArrayList);
        ((MsgBackupDBHelper)localObject2).a();
        a((MsgBackupSessionRequest)localObject1);
      }
      return;
      label268:
      MsgBackupTimeStats.a("single_uin_cost", null);
      MsgBackupTimeStats.a(null, "single_uin_cost");
    }
  }
  
  private void d(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    String str = a(paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, paramMsgBackupSessionRequest.jdField_a_of_type_Int);
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramMsgBackupSessionRequest);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(5);
    MsgBackupTimeStats.a("statis_qianchums_start");
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_b_of_type_Int;
      if (i < j)
      {
        Object localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject = (MsgBackupSessionRequest)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curUin = %s,curQueryCount = %d,sessionMsgTotalCount = %d,mPendingMsgCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(((MsgBackupSessionRequest)localObject).g), Integer.valueOf(((MsgBackupSessionRequest)localObject).jdField_e_of_type_Int), Integer.valueOf(this.jdField_e_of_type_Int) });
        if ((((MsgBackupSessionRequest)localObject).g < ((MsgBackupSessionRequest)localObject).jdField_e_of_type_Int) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int)) {
          a((MsgBackupSessionRequest)localObject);
        }
      }
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
  
  private void e(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    paramMsgBackupSessionRequest = MsgBackupUtil.a(paramMsgBackupSessionRequest);
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "analysisFileMeta:start dbName = %s ", new Object[] { paramMsgBackupSessionRequest });
    MsgBackupUtil.a();
    paramMsgBackupSessionRequest = new MsgBackupDBHelper(paramMsgBackupSessionRequest);
    Object localObject1 = paramMsgBackupSessionRequest.a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MsgBackupExtraEntity)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((MsgBackupExtraEntity)localObject2).name)) && (((MsgBackupExtraEntity)localObject2).name.equalsIgnoreCase("key_meta")) && (!TextUtils.isEmpty(((MsgBackupExtraEntity)localObject2).value)))
        {
          MsgBackupManager.jdField_a_of_type_JavaLangString = ((MsgBackupExtraEntity)localObject2).value;
          localObject2 = (String)MsgBackupManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MsgBackupExtraEntity)localObject2).value);
          MsgBackupManager.jdField_c_of_type_JavaLangString = (String)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            MsgBackupManager.a().h();
          }
        }
      }
    }
    paramMsgBackupSessionRequest.a();
  }
  
  private void f()
  {
    MsgBackupTransportProcessor.a().a(1);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_b_of_type_Int;
      if (i < j)
      {
        Object localObject = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        localObject = (MsgBackupSessionRequest)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if ((((MsgBackupSessionRequest)localObject).g < ((MsgBackupSessionRequest)localObject).jdField_e_of_type_Int) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int)) {
          c((MsgBackupSessionRequest)localObject);
        }
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d,querySingleIndex = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((MsgBackupSessionRequest)localObject).g) });
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
      ((MsgBackupRequest)localObject).jdField_c_of_type_Int += 1;
      int i = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_b_of_type_Int;
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "nextDaoru curIndex = %d,totalCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i == 0) {
        MsgBackupTimeStats.a("statis_qianchums_start");
      }
      if (i == j)
      {
        MsgBackupTimeStats.a("statis_qianchums_end");
        MsgBackupTimeStats.f();
      }
      if (i < j)
      {
        localObject = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        localObject = (MsgBackupSessionRequest)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        ((MsgBackupSessionRequest)localObject).g = 0;
        MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "nextDaoru uin = %s,uinType = %d", new Object[] { ((MsgBackupSessionRequest)localObject).jdField_a_of_type_JavaLangString, Integer.valueOf(((MsgBackupSessionRequest)localObject).jdField_a_of_type_Int) });
        c((MsgBackupSessionRequest)localObject);
      }
    }
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.istroop == 1) {
      return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
    }
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
  
  public List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.msgtype != -2006) {
        if (((localMessageRecord.extraflag == 32768) || (localMessageRecord.extraflag == 32772)) && (localMessageRecord.isSendFromLocal()))
        {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport send not sucess msg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (!(localMessageRecord instanceof ChatMessage))
        {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport not chatMessage _id = %d...,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if ((MsgProxyUtils.e(localMessageRecord.msgtype)) || (MsgProxyUtils.d(localMessageRecord.msgtype)))
        {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport graytipMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (BeancurdManager.a((ChatMessage)localMessageRecord))
        {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport BeancurdMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (AnonymousChatHelper.a(localMessageRecord))
        {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport AnonymousMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else
        {
          if ((localMessageRecord instanceof MessageForFile)) {
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localMessageRecord);
          }
          if ((localMessageRecord instanceof MessageForCommonHobbyForAIOShow))
          {
            MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport msgtype MessageForCommonHobbyForAIOShow MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW", new Object[0]);
          }
          else if (((localMessageRecord.istroop == 1) || (localMessageRecord.istroop == 3000)) && (localMessageRecord.shmsgseq <= 0L))
          {
            MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport troop or discurss msg shmsgseq <= 0", new Object[0]);
          }
          else
          {
            boolean bool = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localMessageRecord);
            if (localMessageRecord.msgtype == -2002) {
              bool = true;
            }
            for (;;)
            {
              if (!bool) {
                break label510;
              }
              localArrayList.add(localMessageRecord);
              break;
              if (localMessageRecord.msgtype == -2071) {
                bool = true;
              } else if (localMessageRecord.msgtype == -2007) {
                bool = true;
              } else if (localMessageRecord.msgtype == -5008) {
                bool = true;
              } else if (localMessageRecord.msgtype == -5017) {
                bool = true;
              }
            }
            label510:
            String str = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
            MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport trans to txtMessage _id = %d...,msgtype = %d .msgStr = %s", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype), str });
            localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a(localMessageRecord, str, false);
            if (TextUtils.equals(localMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
              ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageRecord);
            }
            localMessageRecord.setStatus(1000);
            localMessageRecord.msgData = localMessageRecord.msg.getBytes();
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "preHandleQianchu..msgSize = %d...", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    MsgBackupPbCache.a();
    MsgBackupTimeStats.c();
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgBackupDBHelper paramMsgBackupDBHelper, MsgBackupSessionRequest paramMsgBackupSessionRequest, List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramMsgBackupDBHelper == null) || (paramList == null)) {
      return;
    }
    int i = paramList.size();
    a(paramQQAppInterface, paramMsgBackupDBHelper, paramList);
    for (;;)
    {
      try
      {
        paramMsgBackupSessionRequest.f = (i + paramMsgBackupSessionRequest.f);
        this.jdField_e_of_type_Int -= paramInt;
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment startNext,startIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramMsgBackupSessionRequest.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int) });
        if (paramMsgBackupSessionRequest.f >= paramMsgBackupSessionRequest.jdField_e_of_type_Int)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null))
          {
            paramQQAppInterface = new MsgBackupSessionInfo();
            paramQQAppInterface.jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
            paramQQAppInterface.jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, paramQQAppInterface);
          }
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step this session has process done ,uin = %s,uintype = %d,msgSize = %d", new Object[] { paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, Integer.valueOf(paramMsgBackupSessionRequest.jdField_a_of_type_Int), Integer.valueOf(paramMsgBackupDBHelper.a()) });
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMsgBackupDBHelper.a());
          paramMsgBackupDBHelper.a();
          MsgBackupPbCache.b();
          MsgBackupTimeStats.a("statis_qianchums_end");
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
          return;
        }
      }
      finally {}
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgBackupDBHelper paramMsgBackupDBHelper, List<MessageRecord> paramList)
  {
    if ((paramQQAppInterface == null) || (paramMsgBackupDBHelper == null) || (paramList == null)) {
      return;
    }
    paramList.size();
    paramList = a(paramList);
    paramQQAppInterface = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    MessageRecord localMessageRecord;
    Object localObject3;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label492;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
      Object localObject4;
      if (MultiMsgUtil.a((ChatMessage)localMessageRecord))
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a(localMessageRecord);
        Object localObject5 = MsgBackupMultiMsgProcessor.a((HashMap)localObject4);
        if (((List)localObject5).size() > 0)
        {
          localObject3 = new ArrayList();
          localObject5 = ((List)localObject5).iterator();
          for (;;)
          {
            if (!((Iterator)localObject5).hasNext()) {
              break label227;
            }
            localObject6 = (MessageRecord)((Iterator)localObject5).next();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            if (localIterator.hasNext())
            {
              IMsgBackupRichProcessor localIMsgBackupRichProcessor = (IMsgBackupRichProcessor)localIterator.next();
              if (!localIMsgBackupRichProcessor.a((MessageRecord)localObject6)) {
                break;
              }
              localIMsgBackupRichProcessor.a((MessageRecord)localObject6, (List)localObject1);
              ((ArrayList)localObject3).addAll((Collection)localObject1);
              ((ArrayList)localObject1).clear();
            }
          }
          label227:
          long l1 = MsgBackupUtil.a(localMessageRecord);
          long l2 = MsgBackupUtil.b(localMessageRecord);
          localObject5 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (MsgBackupResEntity)((Iterator)localObject5).next();
            ((MsgBackupResEntity)localObject6).msgSeq = l1;
            ((MsgBackupResEntity)localObject6).msgRandom = l2;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a((HashMap)localObject4, null, true);
          localObject5 = MsgBackupUtil.b(((MessageForStructing)localMessageRecord).structingMsg.mFileName);
          FileUtils.a((byte[])localObject4, (String)localObject5);
          Object localObject6 = new MsgBackupResEntity();
          ((MsgBackupResEntity)localObject6).msgSeq = l1;
          ((MsgBackupResEntity)localObject6).msgRandom = l2;
          ((MsgBackupResEntity)localObject6).filePath = ((String)localObject5);
          ((MsgBackupResEntity)localObject6).fileSize = localObject4.length;
          ((MsgBackupResEntity)localObject6).msgSubType = 10;
          ((MsgBackupResEntity)localObject6).msgType = 4;
          ((MsgBackupResEntity)localObject6).extraDataStr = MsgBackupMultiMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localMessageRecord);
          paramQQAppInterface.add(localObject6);
          if (((ArrayList)localObject3).size() > 0) {
            paramQQAppInterface.addAll((Collection)localObject3);
          }
        }
      }
      else
      {
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (IMsgBackupRichProcessor)((Iterator)localObject3).next();
          if (!((IMsgBackupRichProcessor)localObject4).a(localMessageRecord)) {
            break;
          }
          ((IMsgBackupRichProcessor)localObject4).a(localMessageRecord, (List)localObject1);
          paramQQAppInterface.addAll((Collection)localObject1);
          ((ArrayList)localObject1).clear();
        }
      }
    }
    label492:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    localObject2 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localMessageRecord = (MessageRecord)paramList.next();
      try
      {
        localObject3 = ((MsgBackupMsgProxy)localObject1).a(localMessageRecord);
        if (localObject3 == null) {
          break label604;
        }
        ((ArrayList)localObject2).add(localObject3);
      }
      catch (Throwable localThrowable)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "transToBackupEntity : " + localThrowable);
      }
      continue;
      label604:
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu generate pb failed ..unsupport not chatMessage _id = %d,msgtype = %d .mr =%s ", new Object[] { Long.valueOf(localThrowable.getId()), Integer.valueOf(localThrowable.msgtype), localThrowable.toString() });
    }
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment msg process  + msg.size = %d ", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
    paramMsgBackupDBHelper.a((List)localObject2);
    paramMsgBackupDBHelper.b(paramQQAppInterface);
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment insert db done", new Object[0]);
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!MsgBackupUtil.a())) {
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "handleRequest checkDBDirs result = false,requestType = %d ", new Object[] { Integer.valueOf(paramMsgBackupRequest.jdField_a_of_type_Int) });
    }
    do
    {
      return;
      switch (paramMsgBackupRequest.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 0: 
        int i = paramMsgBackupRequest.jdField_a_of_type_JavaUtilHashSet.size();
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "requestQianchu start,request.dataList.size() = %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          break label125;
        }
      }
    } while (paramMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback == null);
    paramMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(1, paramMsgBackupRequest, null);
    return;
    label125:
    b(paramMsgBackupRequest);
    return;
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "requestQianru start ", new Object[0]);
    MsgBackupSessionRequest localMsgBackupSessionRequest = new MsgBackupSessionRequest();
    MsgBackupUtil.a(paramMsgBackupRequest.jdField_a_of_type_JavaLangString.substring(paramMsgBackupRequest.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1), localMsgBackupSessionRequest);
    MsgBackupManager.d = localMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
    MsgBackupManager.jdField_c_of_type_Int = localMsgBackupSessionRequest.jdField_a_of_type_Int;
    d(localMsgBackupSessionRequest);
    return;
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "requestDaoru start ", new Object[0]);
    c(paramMsgBackupRequest);
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "sendRequest is called from = %d", new Object[] { Integer.valueOf(paramInt) });
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest = paramMsgBackupRequest;
    if (MsgBackupUtil.b)
    {
      if (paramInt == 10000)
      {
        localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5);
        localMessage.obj = paramMsgBackupRequest;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
        return;
      }
      if (paramInt == 10001)
      {
        MsgBackupManager.jdField_a_of_type_JavaLangString = null;
        MsgBackupManager.jdField_c_of_type_JavaLangString = null;
        localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(7);
        localMessage.obj = paramMsgBackupRequest;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
        return;
      }
      localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
      localMessage.obj = paramMsgBackupRequest;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    localMessage.obj = paramMsgBackupRequest;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    Object localObject1 = MsgBackupUtil.a(paramMsgBackupSessionRequest);
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleExcuteQianchu,start uin = %s,dbPath = %s,request.startQueryIndex = %d ", new Object[] { paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, localObject1, Integer.valueOf(paramMsgBackupSessionRequest.h) });
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1) == null)
    {
      localObject2 = new MsgBackupDBHelper((String)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, localObject2);
    }
    localObject1 = (MsgBackupDBHelper)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
    Object localObject2 = MessageRecord.getTableName(paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, paramMsgBackupSessionRequest.jdField_a_of_type_Int);
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    int i;
    int k;
    int j;
    if (paramMsgBackupSessionRequest.jdField_e_of_type_Int == 0)
    {
      i = localQQMessageFacade.a((String)localObject2, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean);
      k = localQQMessageFacade.b((String)localObject2, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean);
      j = i + k;
      paramMsgBackupSessionRequest.jdField_c_of_type_Int = i;
      paramMsgBackupSessionRequest.jdField_d_of_type_Int = k;
      paramMsgBackupSessionRequest.jdField_e_of_type_Int = j;
      if ((j != 0) && ((paramMsgBackupSessionRequest.g < j) || (this.jdField_e_of_type_Int != 0))) {
        break label296;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null))
      {
        localObject2 = new MsgBackupSessionInfo();
        ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
        ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, localObject2);
      }
      ((MsgBackupDBHelper)localObject1).a();
    }
    label296:
    label440:
    int n;
    label389:
    do
    {
      do
      {
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        return;
        do
        {
          do
          {
            do
            {
              i = paramMsgBackupSessionRequest.jdField_c_of_type_Int;
              k = paramMsgBackupSessionRequest.jdField_d_of_type_Int;
              j = paramMsgBackupSessionRequest.jdField_e_of_type_Int;
              break;
              MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickDBCount = %d,slowDBCount = %d,totalCount = %d,request.queryIndex = %d,queryCount = %d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramMsgBackupSessionRequest.h), Integer.valueOf(paramMsgBackupSessionRequest.g) });
              if (k != 0) {
                break label389;
              }
              j = paramMsgBackupSessionRequest.g;
            } while (j >= paramMsgBackupSessionRequest.jdField_c_of_type_Int);
            b(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localQQMessageFacade, i, j);
            return;
            m = paramMsgBackupSessionRequest.g;
          } while (m >= j);
          if (m >= k) {
            break label440;
          }
        } while (a(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localQQMessageFacade, k, m) < k);
        paramMsgBackupSessionRequest.g = k;
        paramMsgBackupSessionRequest.h = 0;
        return;
        n = m - k;
        m = n;
      } while (i <= 0);
      int m = n;
    } while (n >= i);
    a(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localQQMessageFacade, i, n);
  }
  
  public void a(MsgBackupDBHelper paramMsgBackupDBHelper, MsgBackupSessionRequest paramMsgBackupSessionRequest, List<MsgBackupMsgEntity> paramList)
  {
    paramList.size();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:query done ,msgEntity.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject2 = (MsgBackupMsgEntity)paramList.next();
      if (((MsgBackupMsgEntity)localObject2).extensionData == null)
      {
        i += 1;
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step has encounter msgEntity.extensionData == null,msgType = %d,invalidMsgCount = %d", new Object[] { Integer.valueOf(((MsgBackupMsgEntity)localObject2).msgType), Integer.valueOf(i) });
      }
      else
      {
        try
        {
          localObject2 = ((MsgBackupMsgProxy)localObject1).a((MsgBackupMsgEntity)localObject2);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "transToMessageRecord " + localThrowable);
        }
      }
    }
    MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "segmentDaoru step:trans done ,msg.size = %d ", new Object[] { Integer.valueOf(localArrayList.size()) });
    if (localArrayList.size() > 0)
    {
      do
      {
        paramList = localArrayList.iterator();
        while (!((Iterator)localObject4).hasNext())
        {
          for (;;)
          {
            if (!paramList.hasNext()) {
              break label399;
            }
            localObject1 = (MessageRecord)paramList.next();
            if (!MultiMsgUtil.a((ChatMessage)localObject1)) {
              break;
            }
            a(paramMsgBackupDBHelper, (MessageRecord)localObject1);
          }
          localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        localObject3 = (IMsgBackupRichProcessor)((Iterator)localObject4).next();
      } while (!((IMsgBackupRichProcessor)localObject3).a((MessageRecord)localObject1));
      Object localObject4 = paramMsgBackupDBHelper.a(((MessageRecord)localObject1).msgBackupMsgSeq, ((MessageRecord)localObject1).msgBackupMsgRandom);
      if (localObject4 != null) {}
      for (i = ((List)localObject4).size();; i = 0)
      {
        MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "segmentDaoru step:rich process ,query.res.size = %d ", new Object[] { Integer.valueOf(i) });
        ((IMsgBackupRichProcessor)localObject3).b((MessageRecord)localObject1, (List)localObject4);
        break;
      }
      label399:
      paramMsgBackupDBHelper = new ArrayList();
      paramList = (MessageRecord)localArrayList.get(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList.frienduin, paramList.istroop, null);
      Object localObject3 = jdField_a_of_type_JavaLangString;
      if (localObject1 == null) {
        break label638;
      }
      i = ((List)localObject1).size();
      MsgBackupUtil.b((String)localObject3, "segmentDaoru step:mainMsg.size = %d,uin = %s,istroop = %d ", new Object[] { Integer.valueOf(i), paramList.frienduin, Integer.valueOf(paramList.istroop) });
      a(localArrayList, paramMsgBackupDBHelper, (List)localObject1);
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter done ,msgNew.size = %d ,uin = %s", new Object[] { Integer.valueOf(paramMsgBackupDBHelper.size()), paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString });
      if (paramMsgBackupDBHelper.size() > 0)
      {
        Collections.sort(paramMsgBackupDBHelper, this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramMsgBackupDBHelper);
        if (MsgBackupUtil.jdField_a_of_type_Boolean)
        {
          ((MessageRecord)paramMsgBackupDBHelper.get(0)).getTableName();
          paramMsgBackupDBHelper = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, paramMsgBackupSessionRequest.jdField_a_of_type_Int, null);
          if (paramMsgBackupDBHelper != null) {
            break label644;
          }
        }
      }
    }
    label644:
    for (i = 0;; i = paramMsgBackupDBHelper.size())
    {
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "daoru step:seqmentDaoru done result size =  %d", new Object[] { Integer.valueOf(i) });
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:saveToDb done ", new Object[0]);
      return;
      label638:
      i = 0;
      break;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandlerThread.quit();
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void b(MsgBackupRequest paramMsgBackupRequest)
  {
    MsgBackupTimeStats.e = 0L;
    HashSet localHashSet = paramMsgBackupRequest.jdField_a_of_type_JavaUtilHashSet;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "qianchu no recentdBaseData ", new Object[0]);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    MsgBackupPbCache.a();
    MsgBackupTimeStats.c();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      String str = ((RecentBaseData)localObject).getRecentUserUin();
      int i = ((RecentBaseData)localObject).getRecentUserType();
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "requestQianchu uin = %s ", new Object[] { str });
      localObject = new MsgBackupSessionRequest();
      ((MsgBackupSessionRequest)localObject).jdField_a_of_type_JavaLangString = str;
      ((MsgBackupSessionRequest)localObject).jdField_a_of_type_Int = i;
      ((MsgBackupSessionRequest)localObject).jdField_b_of_type_Int = 0;
      ((MsgBackupSessionRequest)localObject).jdField_a_of_type_Long = paramMsgBackupRequest.jdField_a_of_type_Long;
      ((MsgBackupSessionRequest)localObject).jdField_b_of_type_Long = paramMsgBackupRequest.jdField_b_of_type_Long;
      ((MsgBackupSessionRequest)localObject).jdField_a_of_type_Boolean = paramMsgBackupRequest.jdField_a_of_type_Boolean;
      ((MsgBackupSessionRequest)localObject).g = -1;
      ((MsgBackupSessionRequest)localObject).h = 0;
      str = a(str, i);
      this.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    }
    paramMsgBackupRequest.jdField_b_of_type_Int = localHashSet.size();
    paramMsgBackupRequest.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void b(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    Object localObject1 = MsgBackupUtil.a(paramMsgBackupSessionRequest);
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleNextQianru step:start dbName = %s， request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { localObject1, Integer.valueOf(paramMsgBackupSessionRequest.h), Integer.valueOf(paramMsgBackupSessionRequest.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int) });
    MsgBackupUtil.a();
    localObject1 = new MsgBackupDBHelper((String)localObject1);
    if (paramMsgBackupSessionRequest.jdField_e_of_type_Int == 0) {
      paramMsgBackupSessionRequest.jdField_e_of_type_Int = ((MsgBackupDBHelper)localObject1).b();
    }
    int i = paramMsgBackupSessionRequest.jdField_e_of_type_Int;
    if ((i == 0) || ((paramMsgBackupSessionRequest.g >= paramMsgBackupSessionRequest.jdField_e_of_type_Int) && (this.jdField_e_of_type_Int == 0)))
    {
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleNextQianru step queryResList.size = 0,", new Object[0]);
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
      ((MsgBackupDBHelper)localObject1).a();
      return;
    }
    while ((paramMsgBackupSessionRequest.g < i) && (this.jdField_e_of_type_Int < jdField_d_of_type_Int))
    {
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleNextQianru step:,request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.h), Integer.valueOf(paramMsgBackupSessionRequest.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int) });
      Object localObject2 = ((MsgBackupDBHelper)localObject1).a(paramMsgBackupSessionRequest.h + 1, jdField_c_of_type_Int);
      paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramMsgBackupSessionRequest.h = ((int)((MsgBackupResEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
        this.jdField_e_of_type_Int += jdField_c_of_type_Int;
        localObject2 = new MsgBackupController.5(this, (List)localObject2, paramMsgBackupSessionRequest);
        this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject2);
      }
      else if (this.jdField_e_of_type_Int == 0)
      {
        if ((paramMsgBackupSessionRequest.f == paramMsgBackupSessionRequest.jdField_e_of_type_Int) || (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0)) {
          break label372;
        }
        a(null, null, 0L);
      }
    }
    for (;;)
    {
      ((MsgBackupDBHelper)localObject1).a();
      return;
      label372:
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
    }
  }
  
  public void b(MsgBackupDBHelper paramMsgBackupDBHelper, MsgBackupSessionRequest paramMsgBackupSessionRequest, List<MsgBackupMsgEntity> paramList)
  {
    if ((paramMsgBackupDBHelper != null) && (paramMsgBackupSessionRequest != null) && (paramList != null))
    {
      int i = paramList.size();
      a(paramMsgBackupDBHelper, paramMsgBackupSessionRequest, paramList);
      try
      {
        this.jdField_e_of_type_Int -= jdField_a_of_type_Int;
        paramMsgBackupSessionRequest.f = (i + paramMsgBackupSessionRequest.f);
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step segment startNext,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d,uin = %s ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int), paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString });
        if (paramMsgBackupSessionRequest.f >= paramMsgBackupSessionRequest.jdField_e_of_type_Int)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null))
          {
            paramList = new MsgBackupSessionInfo();
            paramList.jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
            paramList.jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, paramList);
          }
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step this session has process done ,uin = %s,uintype = %d", new Object[] { paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, Integer.valueOf(paramMsgBackupSessionRequest.jdField_a_of_type_Int) });
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMsgBackupDBHelper.a());
          paramMsgBackupDBHelper.a();
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
        }
        for (;;)
        {
          return;
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(4);
        }
        return;
      }
      finally {}
    }
  }
  
  public void c(MsgBackupRequest paramMsgBackupRequest)
  {
    HashSet localHashSet = paramMsgBackupRequest.jdField_a_of_type_JavaUtilHashSet;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "daoru no recentdBaseData ", new Object[0]);
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      String str = ((RecentBaseData)localObject).getRecentUserUin();
      int i = ((RecentBaseData)localObject).getRecentUserType();
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "daoru uin = %s ", new Object[] { str });
      localObject = new MsgBackupSessionRequest();
      ((MsgBackupSessionRequest)localObject).jdField_a_of_type_JavaLangString = str;
      ((MsgBackupSessionRequest)localObject).jdField_a_of_type_Int = i;
      ((MsgBackupSessionRequest)localObject).jdField_b_of_type_Int = 2;
      ((MsgBackupSessionRequest)localObject).g = -1;
      ((MsgBackupSessionRequest)localObject).h = -1;
      str = a(str, i);
      this.jdField_b_of_type_JavaUtilArrayList.add(str);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    }
    paramMsgBackupRequest.jdField_b_of_type_Int = localHashSet.size();
    paramMsgBackupRequest.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  public void c(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    MsgBackupManager.jdField_a_of_type_JavaLangString = null;
    MsgBackupManager.jdField_c_of_type_JavaLangString = null;
    e(paramMsgBackupSessionRequest);
    Object localObject1;
    if (TextUtils.isEmpty(MsgBackupManager.jdField_c_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null)
      {
        localObject1 = new MsgBackupSessionInfo();
        ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
        ((MsgBackupSessionInfo)localObject1).jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.h), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int) });
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, localObject1);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
    }
    do
    {
      return;
      localObject1 = MsgBackupUtil.a(paramMsgBackupSessionRequest);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1) == null)
      {
        localObject2 = new MsgBackupDBHelper((String)localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, localObject2);
      }
      localObject1 = (MsgBackupDBHelper)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
      int i = ((MsgBackupDBHelper)localObject1).a();
      if (paramMsgBackupSessionRequest.jdField_e_of_type_Int == 0) {
        paramMsgBackupSessionRequest.jdField_e_of_type_Int = ((MsgBackupDBHelper)localObject1).a();
      }
      if ((paramMsgBackupSessionRequest.jdField_e_of_type_Int == 0) || ((paramMsgBackupSessionRequest.g >= i) && (this.jdField_e_of_type_Int == 0)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null)
        {
          localObject2 = new MsgBackupSessionInfo();
          ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
          ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.h), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int) });
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, localObject2);
        }
        ((MsgBackupDBHelper)localObject1).a();
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
        return;
      }
      do
      {
        paramMsgBackupSessionRequest.h = ((int)((MsgBackupMsgEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
        MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleDaoru queryMsg result.size = %d ", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        this.jdField_e_of_type_Int += jdField_a_of_type_Int;
        localObject2 = new MsgBackupController.6(this, (MsgBackupDBHelper)localObject1, paramMsgBackupSessionRequest, (List)localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject2);
        if ((paramMsgBackupSessionRequest.g >= i) || (this.jdField_e_of_type_Int >= jdField_b_of_type_Int)) {
          break;
        }
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleDaoru queryMsgBefore  curIndex = %d,totalCount = %d,doneCount = %d ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.h), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.f) });
        if (paramMsgBackupSessionRequest.g <= 0) {
          MsgBackupMsgProxy.jdField_a_of_type_Long = 0L;
        }
        localObject2 = ((MsgBackupDBHelper)localObject1).a(paramMsgBackupSessionRequest.h + 1, jdField_a_of_type_Int);
        paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
      } while ((localObject2 != null) && (((List)localObject2).size() != 0));
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleDaoru..query result == 0", new Object[0]);
    } while ((this.jdField_e_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback == null));
    MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleDaoru queryMsgAfter  msgSize = = 0 ", new Object[0]);
    Object localObject2 = new MsgBackupSessionInfo();
    ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
    ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, localObject2);
    ((MsgBackupDBHelper)localObject1).a();
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      bool1 = false;
      return bool1;
    }
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      return true;
    case 0: 
      localObject = jdField_a_of_type_JavaLangString;
      if (paramMessage.obj != null) {}
      for (bool1 = true;; bool1 = false)
      {
        MsgBackupUtil.a((String)localObject, "MSG_WHAT_SUB_REQUEST_POST msg.obj = %b", new Object[] { Boolean.valueOf(bool1) });
        bool1 = bool2;
        if (!(paramMessage.obj instanceof MsgBackupRequest)) {
          break;
        }
        a((MsgBackupRequest)paramMessage.obj);
        return true;
      }
    case 5: 
      if (TextUtils.isEmpty(MsgBackupManager.b))
      {
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5);
        ((Message)localObject).obj = paramMessage.obj;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 1000L);
        return true;
      }
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
      ((Message)localObject).what = 0;
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      return true;
    case 7: 
      if ((TextUtils.isEmpty(MsgBackupManager.jdField_a_of_type_JavaLangString)) && ((paramMessage.obj instanceof MsgBackupRequest)))
      {
        localObject = (MsgBackupRequest)paramMessage.obj;
        MsgBackupSessionRequest localMsgBackupSessionRequest = new MsgBackupSessionRequest();
        MsgBackupUtil.a(((MsgBackupRequest)localObject).jdField_a_of_type_JavaLangString.substring(((MsgBackupRequest)localObject).jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1), localMsgBackupSessionRequest);
        e(localMsgBackupSessionRequest);
      }
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(6);
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      return true;
    }
    if (TextUtils.isEmpty(MsgBackupManager.jdField_a_of_type_JavaLangString))
    {
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "MSG_WHAT_SUB_DECRYPT_KEY_VALID sFileMeta is null, so skip this session!", new Object[0]);
      f();
      return true;
    }
    Object localObject = (String)MsgBackupManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(MsgBackupManager.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(6);
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 1000L);
      return true;
    }
    MsgBackupManager.jdField_c_of_type_JavaLangString = (String)localObject;
    localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    ((Message)localObject).obj = paramMessage.obj;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupController
 * JD-Core Version:    0.7.0.1
 */