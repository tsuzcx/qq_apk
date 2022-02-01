package com.tencent.mobileqq.msgbackup.controller;

import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMsgBackupProxy;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.msgbackup.data.MsgBackupDBHelper;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupSessionInfo;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReportData;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
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
  public static String a = "MsgBackup_MsgBackupController";
  private static int jdField_b_of_type_Int = 5000;
  private static int jdField_c_of_type_Int = 1000;
  private static int jdField_d_of_type_Int = 10000;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
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
  
  public MsgBackupController(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
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
      paramBaseQQAppInterface = new ThreadPoolParams();
      int j = i * 2 + 1;
      paramBaseQQAppInterface.corePoolsize = i;
      paramBaseQQAppInterface.maxPooolSize = j;
      paramBaseQQAppInterface.priority = 5;
      paramBaseQQAppInterface.poolThreadName = "msgbackupThreadPool";
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(paramBaseQQAppInterface);
      jdField_b_of_type_Int = jdField_a_of_type_Int * j;
      jdField_d_of_type_Int = j * jdField_c_of_type_Int;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramBaseQQAppInterface = new MsgBackupMultiMsgProcessor(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
    RichMediaProcessor localRichMediaProcessor = new RichMediaProcessor(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
    MsgBackupFileProcessor localMsgBackupFileProcessor = new MsgBackupFileProcessor(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramBaseQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localRichMediaProcessor);
    this.jdField_a_of_type_JavaUtilList.add(localMsgBackupFileProcessor);
  }
  
  private int a(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, IMessageFacade paramIMessageFacade, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      i = paramMsgBackupSessionRequest.h + 1;
      List localList = paramIMessageFacade.getSlowDbMessage(paramIMessageFacade.getSqlStr(paramString, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, i, jdField_a_of_type_Int, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean), paramString);
      if ((localList == null) || (localList.size() <= 0)) {
        break;
      }
      int j = localList.size();
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu slowDB queryMsgSize = %d", new Object[] { Integer.valueOf(j) });
      MsgBackupController.3 local3 = new MsgBackupController.3(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, localList, i);
      i = this.jdField_e_of_type_Int;
      j = jdField_a_of_type_Int;
      this.jdField_e_of_type_Int = (i + j);
      paramInt2 += j;
      paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.h = ((int)((MessageRecord)localList.get(localList.size() - 1)).getId());
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(local3);
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.h) });
      i = paramInt2;
      if (paramInt2 >= paramInt1) {
        break label248;
      }
      if (this.jdField_e_of_type_Int >= jdField_b_of_type_Int) {
        return paramInt2;
      }
    }
    int i = paramInt2;
    label248:
    return i;
  }
  
  private String a(String paramString, int paramInt)
  {
    return String.format("%s_%d", new Object[] { paramString, Integer.valueOf(MsgBackupUtil.b(paramInt)) });
  }
  
  private void a(Message paramMessage)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
    case 6: 
      c();
      return;
    case 5: 
      if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
      {
        paramMessage = (MsgBackupSessionRequest)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.elements().nextElement();
        if (paramMessage != null)
        {
          b(paramMessage);
          return;
        }
      }
      break;
    case 4: 
      g();
      return;
    case 3: 
      h();
      return;
    case 2: 
      e();
      return;
    case 1: 
      d();
    }
  }
  
  private void a(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, IMessageFacade paramIMessageFacade, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i = paramMsgBackupSessionRequest.h + 1;
      List localList = paramIMessageFacade.getQuickDbMessage(paramIMessageFacade.getSqlStr(paramString, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, i, jdField_a_of_type_Int, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean), paramString);
      if ((localList == null) || (localList.size() <= 0)) {
        break;
      }
      int j = localList.size();
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu quickDB queryMsgSize = %d", new Object[] { Integer.valueOf(j) });
      MsgBackupController.2 local2 = new MsgBackupController.2(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, localList, i);
      i = this.jdField_e_of_type_Int;
      j = jdField_a_of_type_Int;
      this.jdField_e_of_type_Int = (i + j);
      paramInt2 += j;
      paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.h = ((int)((MessageRecord)localList.get(localList.size() - 1)).getId());
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(local2);
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.h) });
      if (paramInt2 >= paramInt1) {
        return;
      }
      if (this.jdField_e_of_type_Int >= jdField_b_of_type_Int) {
        return;
      }
    }
    MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) });
    if (this.jdField_e_of_type_Int == 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
      if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null))
      {
        paramString = new MsgBackupSessionInfo();
        paramString.jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, paramString);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        paramMsgBackupDBHelper.a();
      }
    }
  }
  
  private void a(MsgBackupDBHelper paramMsgBackupDBHelper, MessageRecord paramMessageRecord)
  {
    List localList = paramMsgBackupDBHelper.a(paramMessageRecord.msgBackupMsgSeq, paramMessageRecord.msgBackupMsgRandom);
    label269:
    if ((localList != null) && (localList.size() > 0))
    {
      Object localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramMsgBackupDBHelper = (MsgBackupResEntity)((Iterator)localObject).next();
        if (paramMsgBackupDBHelper.msgType == 4) {
          break label68;
        }
      }
      paramMsgBackupDBHelper = null;
      label68:
      if (paramMsgBackupDBHelper != null)
      {
        paramMsgBackupDBHelper = MsgBackupMultiMsgProcessor.b(paramMessageRecord, paramMsgBackupDBHelper);
        MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "multimsg_tempFilPath = %s", new Object[] { paramMsgBackupDBHelper });
        paramMsgBackupDBHelper = new File(paramMsgBackupDBHelper);
        if (paramMsgBackupDBHelper.exists())
        {
          MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "multimsg_tempFilPath exist = %b", new Object[] { Boolean.valueOf(true) });
          localObject = FileUtils.fileToBytes(paramMsgBackupDBHelper);
          paramMsgBackupDBHelper = (IMultiMsgProxy)QRoute.api(IMultiMsgProxy.class);
          localObject = paramMsgBackupDBHelper.unpackPbToMultiMsgWithNest(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (byte[])localObject, null, paramMessageRecord, null);
          if ((localObject != null) && (((HashMap)localObject).size() > 0))
          {
            Iterator localIterator1 = MsgBackupMultiMsgProcessor.a((HashMap)localObject).iterator();
            for (;;)
            {
              if (!localIterator1.hasNext()) {
                break label269;
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
            paramMsgBackupDBHelper.addMultiMsgWithNest(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramMessageRecord, (HashMap)localObject, null);
          }
        }
      }
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
        break label289;
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
    try
    {
      label289:
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
        }
        else
        {
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
        }
        MsgBackupTimeStats.a("statis_qianchums_end");
        MsgBackupTimeStats.e();
      }
      else
      {
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(5);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void a(List<MessageRecord> paramList1, ArrayList<MessageRecord> paramArrayList, List<MessageRecord> paramList2)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList1.next();
      int i = 1;
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        Iterator localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          if ((localMessageRecord1.istroop != 1) && (localMessageRecord1.istroop != 1026) && (localMessageRecord1.istroop != 3000))
          {
            if ((localMessageRecord1.msgUid == localMessageRecord2.msgUid) && (localMessageRecord1.msgtype == localMessageRecord2.msgtype))
            {
              MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg });
              break label289;
            }
          }
          else
          {
            if (localMessageRecord1.shmsgseq == 0L) {
              MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated troopMsg ,mr.msgshseq = 0.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg, Integer.valueOf(localMessageRecord1.msgtype) });
            }
            if ((localMessageRecord1.shmsgseq == localMessageRecord2.shmsgseq) && (localMessageRecord1.msgtype == localMessageRecord2.msgtype))
            {
              MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg, Integer.valueOf(localMessageRecord1.msgtype) });
              break label289;
            }
          }
        }
      }
      i = 0;
      label289:
      if (i == 0) {
        paramArrayList.add(localMessageRecord1);
      }
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    return ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).isMultiMsg(paramChatMessage);
  }
  
  private void b(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, IMessageFacade paramIMessageFacade, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i = paramMsgBackupSessionRequest.h + 1;
      Object localObject = paramIMessageFacade.getSqlStr(paramString, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, i, jdField_a_of_type_Int, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean);
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu querySql = %s", new Object[] { localObject });
      localObject = paramIMessageFacade.getQuickDbMessage((String)localObject, paramString);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      int j = ((List)localObject).size();
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = %d", new Object[] { Integer.valueOf(j) });
      MsgBackupController.4 local4 = new MsgBackupController.4(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, (List)localObject, i);
      i = this.jdField_e_of_type_Int;
      j = jdField_a_of_type_Int;
      this.jdField_e_of_type_Int = (i + j);
      paramInt2 += j;
      paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
      paramMsgBackupSessionRequest.h = ((int)((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).getId());
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu querySql lastQueryIndex = %d", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.h) });
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(local4);
      MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.h) });
      if (paramInt2 >= paramInt1) {
        return;
      }
      if (this.jdField_e_of_type_Int >= jdField_b_of_type_Int) {
        return;
      }
    }
    MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) });
    if (this.jdField_e_of_type_Int == 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
      if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null))
      {
        paramString = new MsgBackupSessionInfo();
        paramString.jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
        paramString.jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, paramString);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        paramMsgBackupDBHelper.a();
      }
    }
  }
  
  private void c()
  {
    f();
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
    if (localObject1 != null)
    {
      if (((MsgBackupRequest)localObject1).jdField_c_of_type_Int == -1)
      {
        MsgBackupTimeStats.a(null, "single_uin_cost");
      }
      else
      {
        MsgBackupTimeStats.a("single_uin_cost", null);
        MsgBackupTimeStats.a(null, "single_uin_cost");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
    if (localObject != null)
    {
      int i = ((MsgBackupRequest)localObject).jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_b_of_type_Int;
      if (i < j)
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
    if (localObject != null)
    {
      int i = ((MsgBackupRequest)localObject).jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_b_of_type_Int;
      if (i < j)
      {
        localObject = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
    if (localObject != null)
    {
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
    long l1;
    if (paramMessageRecord1.istroop == 1) {
      l1 = paramMessageRecord1.shmsgseq;
    }
    for (long l2 = paramMessageRecord2.shmsgseq;; l2 = paramMessageRecord2.time)
    {
      return (int)(l1 - l2);
      l1 = paramMessageRecord1.time;
    }
  }
  
  public List<MessageRecord> a(BaseQQAppInterface paramBaseQQAppInterface, List<MessageRecord> paramList)
  {
    paramBaseQQAppInterface = new ArrayList();
    IMsgBackupTempApi localIMsgBackupTempApi = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    paramList = paramList.iterator();
    for (;;)
    {
      boolean bool = paramList.hasNext();
      int i = 1;
      if (!bool) {
        break;
      }
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.msgtype != -2006) {
        if (((localMessageRecord.extraflag == 32768) || (localMessageRecord.extraflag == 32772)) && (localMessageRecord.isSendFromLocal())) {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport send not sucess msg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        } else if (!(localMessageRecord instanceof ChatMessage)) {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport not chatMessage _id = %d...,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        } else if ((!MsgProxyUtils.e(localMessageRecord.msgtype)) && (!MsgProxyUtils.d(localMessageRecord.msgtype)))
        {
          if (localIMsgBackupTempApi.isBeancurdMsg((ChatMessage)localMessageRecord))
          {
            MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport BeancurdMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
          }
          else if (localIMsgBackupTempApi.isAnonymousMsg(localMessageRecord))
          {
            MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport AnonymousMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
          }
          else if (localMessageRecord.msgtype == -2023)
          {
            MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport msgtype MessageForCommonHobbyForAIOShow MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW", new Object[0]);
          }
          else if (((localMessageRecord.istroop == 1) || (localMessageRecord.istroop == 3000)) && (localMessageRecord.shmsgseq <= 0L))
          {
            MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport troop or discurss msg shmsgseq <= 0", new Object[0]);
          }
          else
          {
            bool = localIMsgBackupTempApi.isSupportMsgType(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localMessageRecord);
            if ((localMessageRecord.msgtype != -2002) && (localMessageRecord.msgtype != -2071) && (localMessageRecord.msgtype != -2007) && (localMessageRecord.msgtype != -5008) && (localMessageRecord.msgtype != -5017)) {
              i = bool;
            }
            if (i != 0)
            {
              paramBaseQQAppInterface.add(localMessageRecord);
            }
            else
            {
              String str = localIMsgBackupTempApi.getUnsupportMsgStr(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localMessageRecord);
              localMessageRecord = localIMsgBackupTempApi.changeRichTextToTextMsg(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localMessageRecord, str, false);
              if (TextUtils.equals(localMessageRecord.senderuin, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin())) {
                ((ISVIPHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).a(localMessageRecord);
              }
              localMessageRecord.setStatus(1000);
              localMessageRecord.msgData = localMessageRecord.msg.getBytes();
              paramBaseQQAppInterface.add(localMessageRecord);
            }
          }
        }
        else {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport graytipMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
      }
    }
    MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "preHandleQianchu..msgSize = %d...", new Object[] { Integer.valueOf(paramBaseQQAppInterface.size()) });
    return paramBaseQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    localMqqHandler = this.jdField_b_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    MsgBackupPbCache.a();
    MsgBackupTimeStats.c();
  }
  
  public void a(AppInterface paramAppInterface, MsgBackupDBHelper paramMsgBackupDBHelper, MsgBackupSessionRequest paramMsgBackupSessionRequest, List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if ((paramAppInterface != null) && (paramMsgBackupDBHelper != null))
    {
      if (paramList == null) {
        return;
      }
      int i = paramList.size();
      a(paramAppInterface, paramMsgBackupDBHelper, paramList);
      try
      {
        paramMsgBackupSessionRequest.f += i;
        this.jdField_e_of_type_Int -= paramInt;
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment startNext,startIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramMsgBackupSessionRequest.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int) });
        if (paramMsgBackupSessionRequest.f >= paramMsgBackupSessionRequest.jdField_e_of_type_Int)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null))
          {
            paramAppInterface = new MsgBackupSessionInfo();
            paramAppInterface.jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
            paramAppInterface.jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, paramAppInterface);
          }
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step this session has process done ,uin = %s,uintype = %d,msgSize = %d", new Object[] { paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, Integer.valueOf(paramMsgBackupSessionRequest.jdField_a_of_type_Int), Integer.valueOf(paramMsgBackupDBHelper.a()) });
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMsgBackupDBHelper.a());
          paramMsgBackupDBHelper.a();
          MsgBackupPbCache.b();
          MsgBackupTimeStats.a("statis_qianchums_end");
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        }
        else
        {
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(AppInterface paramAppInterface, MsgBackupDBHelper paramMsgBackupDBHelper, List<MessageRecord> paramList)
  {
    if ((paramAppInterface != null) && (paramMsgBackupDBHelper != null))
    {
      if (paramList == null) {
        return;
      }
      Object localObject2 = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
      paramList.size();
      Object localObject1 = a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramList);
      paramList = new ArrayList();
      Object localObject3 = new ArrayList();
      paramAppInterface = ((List)localObject1).iterator();
      Object localObject4;
      Object localObject5;
      label257:
      label521:
      while (paramAppInterface.hasNext())
      {
        localObject4 = (MessageRecord)paramAppInterface.next();
        Object localObject6;
        if (((IMsgBackupTempApi)localObject2).isMultiMsg((ChatMessage)localObject4))
        {
          localObject6 = (IMultiMsgProxy)QRoute.api(IMultiMsgProxy.class);
          Object localObject7 = ((IMultiMsgProxy)localObject6).queryMultiMsgWithNest(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (MessageRecord)localObject4);
          Object localObject8 = MsgBackupMultiMsgProcessor.a((HashMap)localObject7);
          if (((List)localObject8).size() > 0)
          {
            localObject5 = new ArrayList();
            localObject8 = ((List)localObject8).iterator();
            Object localObject9;
            for (;;)
            {
              if (!((Iterator)localObject8).hasNext()) {
                break label257;
              }
              localObject9 = (MessageRecord)((Iterator)localObject8).next();
              Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
              if (localIterator.hasNext())
              {
                IMsgBackupRichProcessor localIMsgBackupRichProcessor = (IMsgBackupRichProcessor)localIterator.next();
                if (!localIMsgBackupRichProcessor.a((MessageRecord)localObject9)) {
                  break;
                }
                localIMsgBackupRichProcessor.a((MessageRecord)localObject9, (List)localObject3);
                ((ArrayList)localObject5).addAll((Collection)localObject3);
                ((ArrayList)localObject3).clear();
              }
            }
            long l1 = MsgBackupUtil.a((MessageRecord)localObject4);
            long l2 = MsgBackupUtil.b((MessageRecord)localObject4);
            localObject8 = ((ArrayList)localObject5).iterator();
            while (((Iterator)localObject8).hasNext())
            {
              localObject9 = (MsgBackupResEntity)((Iterator)localObject8).next();
              ((MsgBackupResEntity)localObject9).msgSeq = l1;
              ((MsgBackupResEntity)localObject9).msgRandom = l2;
            }
            localObject6 = ((IMultiMsgProxy)localObject6).packPbFromMultiMsgWithNest(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (HashMap)localObject7, null, true);
            localObject7 = MsgBackupUtil.b(((IMsgBackupTempApi)localObject2).handleMultiMsg((MessageRecord)localObject4));
            FileUtils.writeFile((byte[])localObject6, (String)localObject7);
            localObject8 = new MsgBackupResEntity();
            ((MsgBackupResEntity)localObject8).msgSeq = l1;
            ((MsgBackupResEntity)localObject8).msgRandom = l2;
            ((MsgBackupResEntity)localObject8).filePath = ((String)localObject7);
            ((MsgBackupResEntity)localObject8).fileSize = localObject6.length;
            ((MsgBackupResEntity)localObject8).msgSubType = 10;
            ((MsgBackupResEntity)localObject8).msgType = 4;
            ((MsgBackupResEntity)localObject8).extraDataStr = MsgBackupMultiMsgProcessor.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentUin(), (MessageRecord)localObject4);
            paramList.add(localObject8);
            if (((ArrayList)localObject5).size() <= 0) {
              break label521;
            }
            paramList.addAll((Collection)localObject5);
          }
        }
        else
        {
          localObject5 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (IMsgBackupRichProcessor)((Iterator)localObject5).next();
            if (((IMsgBackupRichProcessor)localObject6).a((MessageRecord)localObject4))
            {
              ((IMsgBackupRichProcessor)localObject6).a((MessageRecord)localObject4, (List)localObject3);
              paramList.addAll((Collection)localObject3);
              ((ArrayList)localObject3).clear();
            }
          }
        }
      }
      paramAppInterface = (IMsgBackupProxy)QRoute.api(IMsgBackupProxy.class);
      localObject2 = new ArrayList(((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject1).next();
        try
        {
          localObject4 = (MsgBackupMsgEntity)paramAppInterface.transToBackupEntity(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (MessageRecord)localObject3);
          if (localObject4 != null) {
            ((ArrayList)localObject2).add(localObject4);
          } else {
            MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu generate pb failed ..unsupport not chatMessage _id = %d,msgtype = %d .mr =%s ", new Object[] { Long.valueOf(((MessageRecord)localObject3).getId()), Integer.valueOf(((MessageRecord)localObject3).msgtype), ((MessageRecord)localObject3).toString() });
          }
        }
        catch (Throwable localThrowable)
        {
          localObject4 = jdField_a_of_type_JavaLangString;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("transToBackupEntity : ");
          ((StringBuilder)localObject5).append(localThrowable);
          QLog.e((String)localObject4, 1, ((StringBuilder)localObject5).toString());
        }
      }
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment msg process  + msg.size = %d ", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
      paramMsgBackupDBHelper.a((List)localObject2);
      paramMsgBackupDBHelper.b(paramList);
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment insert db done", new Object[0]);
    }
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (MsgBackupUtil.a()))
    {
      int i = paramMsgBackupRequest.jdField_a_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "requestDaoru start ", new Object[0]);
          c(paramMsgBackupRequest);
          return;
        }
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "requestQianru start ", new Object[0]);
        MsgBackupSessionRequest localMsgBackupSessionRequest = new MsgBackupSessionRequest();
        MsgBackupUtil.a(paramMsgBackupRequest.jdField_a_of_type_JavaLangString.substring(paramMsgBackupRequest.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1), localMsgBackupSessionRequest);
        MsgBackupManager.d = localMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
        MsgBackupManager.jdField_c_of_type_Int = localMsgBackupSessionRequest.jdField_a_of_type_Int;
        d(localMsgBackupSessionRequest);
        return;
      }
      i = paramMsgBackupRequest.jdField_a_of_type_JavaUtilHashSet.size();
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "requestQianchu start,request.dataList.size() = %d ", new Object[] { Integer.valueOf(i) });
      if (i == 0)
      {
        if (paramMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null) {
          paramMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(1, paramMsgBackupRequest, null);
        }
      }
      else {
        b(paramMsgBackupRequest);
      }
      return;
    }
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "handleRequest checkDBDirs result = false,requestType = %d ", new Object[] { Integer.valueOf(paramMsgBackupRequest.jdField_a_of_type_Int) });
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
    IMessageFacade localIMessageFacade = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    int i;
    int j;
    int k;
    if (paramMsgBackupSessionRequest.jdField_e_of_type_Int == 0)
    {
      i = localIMessageFacade.getQuickDBMsgCount((String)localObject2, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean);
      j = localIMessageFacade.getSlowDBMsgCount((String)localObject2, paramMsgBackupSessionRequest.jdField_a_of_type_Long, paramMsgBackupSessionRequest.jdField_b_of_type_Long, paramMsgBackupSessionRequest.jdField_a_of_type_Boolean);
      k = i + j;
      paramMsgBackupSessionRequest.jdField_c_of_type_Int = i;
      paramMsgBackupSessionRequest.jdField_d_of_type_Int = j;
      paramMsgBackupSessionRequest.jdField_e_of_type_Int = k;
    }
    else
    {
      i = paramMsgBackupSessionRequest.jdField_c_of_type_Int;
      j = paramMsgBackupSessionRequest.jdField_d_of_type_Int;
      k = paramMsgBackupSessionRequest.jdField_e_of_type_Int;
    }
    if ((k != 0) && ((paramMsgBackupSessionRequest.g < k) || (this.jdField_e_of_type_Int != 0)))
    {
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickDBCount = %d,slowDBCount = %d,totalCount = %d,request.queryIndex = %d,queryCount = %d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramMsgBackupSessionRequest.h), Integer.valueOf(paramMsgBackupSessionRequest.g) });
      if (j == 0)
      {
        j = paramMsgBackupSessionRequest.g;
        if (j < paramMsgBackupSessionRequest.jdField_c_of_type_Int) {
          b(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localIMessageFacade, i, j);
        }
      }
      else
      {
        int m = paramMsgBackupSessionRequest.g;
        while (m < k) {
          if (m < j)
          {
            if (a(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localIMessageFacade, j, m) >= j)
            {
              paramMsgBackupSessionRequest.g = j;
              paramMsgBackupSessionRequest.h = 0;
            }
          }
          else
          {
            int n = m - j;
            m = n;
            if (i > 0)
            {
              m = n;
              if (n < i) {
                a(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localIMessageFacade, i, n);
              }
            }
          }
        }
      }
      return;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest;
    if ((localObject2 != null) && (((MsgBackupRequest)localObject2).jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null))
    {
      localObject2 = new MsgBackupSessionInfo();
      ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
      ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, localObject2);
    }
    ((MsgBackupDBHelper)localObject1).a();
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void a(MsgBackupDBHelper paramMsgBackupDBHelper, MsgBackupSessionRequest paramMsgBackupSessionRequest, List<MsgBackupMsgEntity> paramList)
  {
    paramList.size();
    Object localObject1 = (IMsgBackupProxy)QRoute.api(IMsgBackupProxy.class);
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:query done ,msgEntity.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    Object localObject4;
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
          localObject2 = ((IMsgBackupProxy)localObject1).transToMessageRecord(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localObject2);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
        catch (Throwable localThrowable)
        {
          localObject4 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("transToMessageRecord ");
          localStringBuilder.append(localThrowable);
          QLog.e((String)localObject4, 1, localStringBuilder.toString());
        }
      }
    }
    MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "segmentDaoru step:trans done ,msg.size = %d ", new Object[] { Integer.valueOf(localArrayList.size()) });
    if (localArrayList.size() > 0)
    {
      paramList = localArrayList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label418;
        }
        localObject1 = (MessageRecord)paramList.next();
        if (a((ChatMessage)localObject1))
        {
          a(paramMsgBackupDBHelper, (MessageRecord)localObject1);
        }
        else
        {
          localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject3 = (IMsgBackupRichProcessor)((Iterator)localObject4).next();
            if (!((IMsgBackupRichProcessor)localObject3).a((MessageRecord)localObject1)) {
              break;
            }
            localObject4 = paramMsgBackupDBHelper.a(((MessageRecord)localObject1).msgBackupMsgSeq, ((MessageRecord)localObject1).msgBackupMsgRandom);
            if (localObject4 != null) {
              i = ((List)localObject4).size();
            } else {
              i = 0;
            }
            MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "segmentDaoru step:rich process ,query.res.size = %d ", new Object[] { Integer.valueOf(i) });
            ((IMsgBackupRichProcessor)localObject3).b((MessageRecord)localObject1, (List)localObject4);
          }
        }
      }
      label418:
      paramMsgBackupDBHelper = new ArrayList();
      paramList = (MessageRecord)localArrayList.get(0);
      localObject1 = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
      Object localObject3 = ((IMessageFacade)localObject1).getAllMessages(paramList.frienduin, paramList.istroop, null);
      localObject4 = jdField_a_of_type_JavaLangString;
      if (localObject3 != null) {
        i = ((List)localObject3).size();
      } else {
        i = 0;
      }
      MsgBackupUtil.b((String)localObject4, "segmentDaoru step:mainMsg.size = %d,uin = %s,istroop = %d ", new Object[] { Integer.valueOf(i), paramList.frienduin, Integer.valueOf(paramList.istroop) });
      a(localArrayList, paramMsgBackupDBHelper, (List)localObject3);
      MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter done ,msgNew.size = %d ,uin = %s", new Object[] { Integer.valueOf(paramMsgBackupDBHelper.size()), paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString });
      if (paramMsgBackupDBHelper.size() > 0)
      {
        Collections.sort(paramMsgBackupDBHelper, this);
        ((IMessageFacade)localObject1).addMessageForMsgBackup(paramMsgBackupDBHelper);
        if (MsgBackupUtil.jdField_a_of_type_Boolean)
        {
          ((MessageRecord)paramMsgBackupDBHelper.get(0)).getTableName();
          paramMsgBackupDBHelper = ((IMessageFacade)localObject1).getAllMessages(paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, paramMsgBackupSessionRequest.jdField_a_of_type_Int, null);
          if (paramMsgBackupDBHelper == null) {
            i = 0;
          } else {
            i = paramMsgBackupDBHelper.size();
          }
          MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "daoru step:seqmentDaoru done result size =  %d", new Object[] { Integer.valueOf(i) });
        }
      }
    }
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:saveToDb done ", new Object[0]);
  }
  
  public void b()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandlerThread.quit();
    }
    localMqqHandler = this.jdField_b_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void b(MsgBackupRequest paramMsgBackupRequest)
  {
    MsgBackupTimeStats.e = 0L;
    HashSet localHashSet = paramMsgBackupRequest.jdField_a_of_type_JavaUtilHashSet;
    if ((localHashSet != null) && (localHashSet.size() != 0))
    {
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
      return;
    }
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "qianchu no recentdBaseData ", new Object[0]);
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
    if ((i != 0) && ((paramMsgBackupSessionRequest.g < paramMsgBackupSessionRequest.jdField_e_of_type_Int) || (this.jdField_e_of_type_Int != 0)))
    {
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
          if ((paramMsgBackupSessionRequest.f != paramMsgBackupSessionRequest.jdField_e_of_type_Int) && (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
          {
            a(null, null, 0L);
          }
          else
          {
            this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
            this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
          }
        }
      }
      ((MsgBackupDBHelper)localObject1).a();
      return;
    }
    MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleNextQianru step queryResList.size = 0,", new Object[0]);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
    ((MsgBackupDBHelper)localObject1).a();
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
        paramMsgBackupSessionRequest.f += i;
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
        else
        {
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
    if ((localHashSet != null) && (localHashSet.size() != 0))
    {
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
      return;
    }
    MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "daoru no recentdBaseData ", new Object[0]);
  }
  
  public void c(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    MsgBackupManager.jdField_a_of_type_JavaLangString = null;
    MsgBackupManager.jdField_c_of_type_JavaLangString = null;
    e(paramMsgBackupSessionRequest);
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
      return;
    }
    Object localObject1 = MsgBackupUtil.a(paramMsgBackupSessionRequest);
    Object localObject2;
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
    if ((paramMsgBackupSessionRequest.jdField_e_of_type_Int != 0) && ((paramMsgBackupSessionRequest.g < i) || (this.jdField_e_of_type_Int != 0)))
    {
      while ((paramMsgBackupSessionRequest.g < i) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int))
      {
        MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleDaoru queryMsgBefore  curIndex = %d,totalCount = %d,doneCount = %d ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.h), Integer.valueOf(paramMsgBackupSessionRequest.jdField_e_of_type_Int), Integer.valueOf(paramMsgBackupSessionRequest.f) });
        int j = paramMsgBackupSessionRequest.g;
        localObject2 = ((MsgBackupDBHelper)localObject1).a(paramMsgBackupSessionRequest.h + 1, jdField_a_of_type_Int);
        paramMsgBackupSessionRequest.g += jdField_a_of_type_Int;
        if ((localObject2 != null) && (((List)localObject2).size() != 0))
        {
          paramMsgBackupSessionRequest.h = ((int)((MsgBackupMsgEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
          MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleDaoru queryMsg result.size = %d ", new Object[] { Integer.valueOf(((List)localObject2).size()) });
          this.jdField_e_of_type_Int += jdField_a_of_type_Int;
          localObject2 = new MsgBackupController.6(this, (MsgBackupDBHelper)localObject1, paramMsgBackupSessionRequest, (List)localObject2);
          this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject2);
        }
        else
        {
          MsgBackupUtil.b(jdField_a_of_type_JavaLangString, "singleDaoru..query result == 0", new Object[0]);
          if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback != null))
          {
            MsgBackupUtil.a(jdField_a_of_type_JavaLangString, "singleDaoru queryMsgAfter  msgSize = = 0 ", new Object[0]);
            localObject2 = new MsgBackupSessionInfo();
            ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_JavaLangString = paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString;
            ((MsgBackupSessionInfo)localObject2).jdField_a_of_type_Int = paramMsgBackupSessionRequest.jdField_a_of_type_Int;
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupRequest, localObject2);
            ((MsgBackupDBHelper)localObject1).a();
            this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
          }
        }
      }
      return;
    }
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
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 5)
      {
        if (i != 6)
        {
          if (i != 7) {
            return true;
          }
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
        localObject = (String)MsgBackupManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(MsgBackupManager.jdField_a_of_type_JavaLangString);
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
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    boolean bool;
    if (paramMessage.obj != null) {
      bool = true;
    } else {
      bool = false;
    }
    MsgBackupUtil.a((String)localObject, "MSG_WHAT_SUB_REQUEST_POST msg.obj = %b", new Object[] { Boolean.valueOf(bool) });
    if ((paramMessage.obj instanceof MsgBackupRequest)) {
      a((MsgBackupRequest)paramMessage.obj);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupController
 * JD-Core Version:    0.7.0.1
 */