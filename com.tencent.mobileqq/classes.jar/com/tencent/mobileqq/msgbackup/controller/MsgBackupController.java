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
  public static String a = "MsgBackup_MsgBackupController";
  private static int d = 500;
  private static int e = 5000;
  private static int f = 1000;
  private static int g = 10000;
  private BaseQQAppInterface b;
  private List<IMsgBackupRichProcessor> c;
  private int h;
  private MqqHandler i;
  private MqqHandler j;
  private HandlerThread k;
  private AtomicBoolean l = new AtomicBoolean(false);
  private HandlerThread m;
  private Executor n;
  private ArrayList<String> o = new ArrayList();
  private ArrayList<String> p = new ArrayList();
  private ConcurrentHashMap<String, MsgBackupDBHelper> q;
  private ConcurrentHashMap<String, MsgBackupSessionRequest> r;
  private ConcurrentHashMap<String, MsgBackupSessionRequest> s;
  private ConcurrentHashMap<String, MsgBackupSessionRequest> t;
  private ConcurrentHashMap<String, String> u;
  private MsgBackupRequest v;
  private AtomicInteger w = new AtomicInteger(0);
  private AtomicInteger x = new AtomicInteger(0);
  
  public MsgBackupController(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.b = paramBaseQQAppInterface;
    if (this.m == null)
    {
      this.m = ThreadManager.newFreeHandlerThread("MsgbackupController_request", 5);
      this.m.start();
      this.i = new MqqHandler(this.m.getLooper(), this);
    }
    if (this.j == null)
    {
      this.k = ThreadManager.newFreeHandlerThread("MsgbackupController_flow", 5);
      this.k.start();
      this.j = new MqqHandler(this.k.getLooper(), new MsgBackupController.1(this));
    }
    if (this.n == null)
    {
      int i1 = Runtime.getRuntime().availableProcessors();
      MsgBackupUtil.a(a, "MsgBackupController cpuCount = %d ", new Object[] { Integer.valueOf(i1) });
      paramBaseQQAppInterface = new ThreadPoolParams();
      int i2 = i1 * 2 + 1;
      paramBaseQQAppInterface.corePoolsize = i1;
      paramBaseQQAppInterface.maxPooolSize = i2;
      paramBaseQQAppInterface.priority = 5;
      paramBaseQQAppInterface.poolThreadName = "msgbackupThreadPool";
      this.n = ThreadManager.newFreeThreadPool(paramBaseQQAppInterface);
      e = d * i2;
      g = i2 * f;
    }
    this.r = new ConcurrentHashMap();
    this.s = new ConcurrentHashMap();
    this.t = new ConcurrentHashMap();
    this.q = new ConcurrentHashMap();
    this.u = new ConcurrentHashMap();
    this.c = new ArrayList();
    paramBaseQQAppInterface = new MsgBackupMultiMsgProcessor(this.b);
    RichMediaProcessor localRichMediaProcessor = new RichMediaProcessor(this.b);
    MsgBackupFileProcessor localMsgBackupFileProcessor = new MsgBackupFileProcessor(this.b);
    this.c.add(paramBaseQQAppInterface);
    this.c.add(localRichMediaProcessor);
    this.c.add(localMsgBackupFileProcessor);
  }
  
  private String a(String paramString, int paramInt)
  {
    return String.format("%s_%d", new Object[] { paramString, Integer.valueOf(MsgBackupUtil.b(paramInt)) });
  }
  
  private void a(Message paramMessage)
  {
    if (!this.l.get()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
    case 6: 
      e();
      return;
    case 5: 
      if (this.t.size() > 0)
      {
        paramMessage = (MsgBackupSessionRequest)this.t.elements().nextElement();
        if (paramMessage != null)
        {
          b(paramMessage);
          return;
        }
      }
      break;
    case 4: 
      i();
      return;
    case 3: 
      j();
      return;
    case 2: 
      g();
      return;
    case 1: 
      f();
    }
  }
  
  private void a(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, IMessageFacade paramIMessageFacade, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i1 = paramMsgBackupSessionRequest.m + 1;
      List localList = paramIMessageFacade.getQuickDbMessage(paramIMessageFacade.getSqlStr(paramString, paramMsgBackupSessionRequest.e, paramMsgBackupSessionRequest.f, i1, d, paramMsgBackupSessionRequest.g), paramString);
      if ((localList == null) || (localList.size() <= 0)) {
        break;
      }
      int i2 = localList.size();
      MsgBackupUtil.a(a, "singleExcuteQianchu quickDB queryMsgSize = %d", new Object[] { Integer.valueOf(i2) });
      MsgBackupController.2 local2 = new MsgBackupController.2(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, localList, i1);
      i1 = this.h;
      i2 = d;
      this.h = (i1 + i2);
      paramInt2 += i2;
      paramMsgBackupSessionRequest.l += d;
      paramMsgBackupSessionRequest.m = ((int)((MessageRecord)localList.get(localList.size() - 1)).getId());
      this.n.execute(local2);
      MsgBackupUtil.a(a, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.h), Integer.valueOf(paramMsgBackupSessionRequest.m) });
      if (paramInt2 >= paramInt1) {
        return;
      }
      if (this.h >= e) {
        return;
      }
    }
    MsgBackupUtil.a(a, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.h) });
    if (this.h == 0)
    {
      paramString = this.v;
      if ((paramString != null) && (paramString.h != null))
      {
        paramString = new MsgBackupSessionInfo();
        paramString.a = paramMsgBackupSessionRequest.a;
        paramString.b = paramMsgBackupSessionRequest.b;
        this.v.h.a(this.v, paramString);
        this.j.sendEmptyMessage(1);
        paramMsgBackupDBHelper.b();
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
        paramMsgBackupDBHelper = MsgBackupMultiMsgProcessor.c(paramMessageRecord, paramMsgBackupDBHelper);
        MsgBackupUtil.a(a, "multimsg_tempFilPath = %s", new Object[] { paramMsgBackupDBHelper });
        paramMsgBackupDBHelper = new File(paramMsgBackupDBHelper);
        if (paramMsgBackupDBHelper.exists())
        {
          MsgBackupUtil.a(a, "multimsg_tempFilPath exist = %b", new Object[] { Boolean.valueOf(true) });
          localObject = FileUtils.fileToBytes(paramMsgBackupDBHelper);
          paramMsgBackupDBHelper = (IMultiMsgProxy)QRoute.api(IMultiMsgProxy.class);
          localObject = paramMsgBackupDBHelper.unpackPbToMultiMsgWithNest(this.b, (byte[])localObject, null, paramMessageRecord, null);
          if ((localObject != null) && (((HashMap)localObject).size() > 0))
          {
            Iterator localIterator1 = MsgBackupMultiMsgProcessor.a((HashMap)localObject).iterator();
            for (;;)
            {
              if (!localIterator1.hasNext()) {
                break label269;
              }
              MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
              Iterator localIterator2 = this.c.iterator();
              if (localIterator2.hasNext())
              {
                IMsgBackupRichProcessor localIMsgBackupRichProcessor = (IMsgBackupRichProcessor)localIterator2.next();
                if (!localIMsgBackupRichProcessor.a(localMessageRecord)) {
                  break;
                }
                localIMsgBackupRichProcessor.b(localMessageRecord, localList);
              }
            }
            paramMsgBackupDBHelper.addMultiMsgWithNest(this.b, paramMessageRecord, (HashMap)localObject, null);
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
    MsgBackupUtil.b(a, "segmentExcuteQianru step:query res.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label289;
      }
      MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)localIterator.next();
      Object localObject2 = this.c.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (IMsgBackupRichProcessor)((Iterator)localObject2).next();
        if (!((IMsgBackupRichProcessor)localObject1).a(localMsgBackupResEntity)) {
          break;
        }
        MsgBackupReporter.a();
        localObject2 = MsgBackupReporter.a;
        ((MsgBackupReportData)localObject2).i += 1L;
        localObject2 = ((IMsgBackupRichProcessor)localObject1).a(null, localMsgBackupResEntity);
        if (((ResDownloadObject)localObject2).a())
        {
          localObject1 = ((ResDownloadObject)localObject2).a((IMsgBackupRichProcessor)localObject1, null, localMsgBackupResEntity);
          MsgBackupUtil.a(a, "segmentExcuteQianru step:need res:uin = %s,uinType = %d,msgType = %d,filePath = %s,clientPath = %s, filesize = %s", new Object[] { paramMsgBackupSessionRequest.a, Integer.valueOf(paramMsgBackupSessionRequest.b), Integer.valueOf(localMsgBackupResEntity.msgType), localMsgBackupResEntity.filePath, localObject1, Long.valueOf(localMsgBackupResEntity.fileSize) });
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            MsgBackupUtil.a(a, "segmentExcuteQianru step:need res,but clientPath is empty", new Object[0]);
          }
          else if (!this.u.containsKey(localObject1))
          {
            this.u.put(localObject1, "");
            a(localMsgBackupResEntity.filePath, (String)localObject1, localMsgBackupResEntity.fileSize);
          }
        }
      }
    }
    try
    {
      label289:
      paramMsgBackupSessionRequest.k += paramList.size();
      this.h -= paramInt;
      MsgBackupUtil.b(a, "segmentExcuteQianru step segment startNext,,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.k), Integer.valueOf(this.h), Integer.valueOf(paramMsgBackupSessionRequest.j) });
      if (paramMsgBackupSessionRequest.k >= paramMsgBackupSessionRequest.j)
      {
        this.h = 0;
        if (this.u.size() > 0)
        {
          a(null, null, 0L);
          this.u.clear();
        }
        else
        {
          this.j.removeCallbacksAndMessages(null);
          this.j.sendEmptyMessage(6);
        }
        MsgBackupTimeStats.a("statis_qianchums_end");
        MsgBackupTimeStats.e();
      }
      else
      {
        this.j.removeCallbacksAndMessages(null);
        this.j.sendEmptyMessage(5);
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
      int i1 = 1;
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
              MsgBackupUtil.b(a, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg });
              break label289;
            }
          }
          else
          {
            if (localMessageRecord1.shmsgseq == 0L) {
              MsgBackupUtil.b(a, "segmentDaoru step:msgfilter duplicated troopMsg ,mr.msgshseq = 0.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg, Integer.valueOf(localMessageRecord1.msgtype) });
            }
            if ((localMessageRecord1.shmsgseq == localMessageRecord2.shmsgseq) && (localMessageRecord1.msgtype == localMessageRecord2.msgtype))
            {
              MsgBackupUtil.b(a, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { localMessageRecord1.msg, localMessageRecord2.msg, Integer.valueOf(localMessageRecord1.msgtype) });
              break label289;
            }
          }
        }
      }
      i1 = 0;
      label289:
      if (i1 == 0) {
        paramArrayList.add(localMessageRecord1);
      }
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    return ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).isMultiMsg(paramChatMessage);
  }
  
  private int b(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, IMessageFacade paramIMessageFacade, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      i1 = paramMsgBackupSessionRequest.m + 1;
      List localList = paramIMessageFacade.getSlowDbMessage(paramIMessageFacade.getSqlStr(paramString, paramMsgBackupSessionRequest.e, paramMsgBackupSessionRequest.f, i1, d, paramMsgBackupSessionRequest.g), paramString);
      if ((localList == null) || (localList.size() <= 0)) {
        break;
      }
      int i2 = localList.size();
      MsgBackupUtil.a(a, "singleExcuteQianchu slowDB queryMsgSize = %d", new Object[] { Integer.valueOf(i2) });
      MsgBackupController.3 local3 = new MsgBackupController.3(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, localList, i1);
      i1 = this.h;
      i2 = d;
      this.h = (i1 + i2);
      paramInt2 += i2;
      paramMsgBackupSessionRequest.l += d;
      paramMsgBackupSessionRequest.m = ((int)((MessageRecord)localList.get(localList.size() - 1)).getId());
      this.n.execute(local3);
      MsgBackupUtil.a(a, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.h), Integer.valueOf(paramMsgBackupSessionRequest.m) });
      i1 = paramInt2;
      if (paramInt2 >= paramInt1) {
        break label250;
      }
      if (this.h >= e) {
        return paramInt2;
      }
    }
    int i1 = paramInt2;
    label250:
    return i1;
  }
  
  private void c(MsgBackupSessionRequest paramMsgBackupSessionRequest, MsgBackupDBHelper paramMsgBackupDBHelper, String paramString, IMessageFacade paramIMessageFacade, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i1 = paramMsgBackupSessionRequest.m + 1;
      Object localObject = paramIMessageFacade.getSqlStr(paramString, paramMsgBackupSessionRequest.e, paramMsgBackupSessionRequest.f, i1, d, paramMsgBackupSessionRequest.g);
      MsgBackupUtil.a(a, "singleExcuteQianchu querySql = %s", new Object[] { localObject });
      localObject = paramIMessageFacade.getQuickDbMessage((String)localObject, paramString);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      int i2 = ((List)localObject).size();
      MsgBackupUtil.a(a, "singleExcuteQianchu queryMsgSize = %d", new Object[] { Integer.valueOf(i2) });
      MsgBackupController.4 local4 = new MsgBackupController.4(this, paramMsgBackupDBHelper, paramMsgBackupSessionRequest, (List)localObject, i1);
      i1 = this.h;
      i2 = d;
      this.h = (i1 + i2);
      paramInt2 += i2;
      paramMsgBackupSessionRequest.l += d;
      paramMsgBackupSessionRequest.m = ((int)((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).getId());
      MsgBackupUtil.a(a, "singleExcuteQianchu querySql lastQueryIndex = %d", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.m) });
      this.n.execute(local4);
      MsgBackupUtil.a(a, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { paramString, Integer.valueOf(this.h), Integer.valueOf(paramMsgBackupSessionRequest.m) });
      if (paramInt2 >= paramInt1) {
        return;
      }
      if (this.h >= e) {
        return;
      }
    }
    MsgBackupUtil.a(a, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.h) });
    if (this.h == 0)
    {
      paramString = this.v;
      if ((paramString != null) && (paramString.h != null))
      {
        paramString = new MsgBackupSessionInfo();
        paramString.a = paramMsgBackupSessionRequest.a;
        paramString.b = paramMsgBackupSessionRequest.b;
        this.v.h.a(this.v, paramString);
        this.j.sendEmptyMessage(1);
        paramMsgBackupDBHelper.b();
      }
    }
  }
  
  private void d(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    this.t.clear();
    this.u.clear();
    String str = a(paramMsgBackupSessionRequest.a, paramMsgBackupSessionRequest.b);
    this.t.put(str, paramMsgBackupSessionRequest);
    this.j.sendEmptyMessage(5);
    MsgBackupTimeStats.a("statis_qianchums_start");
  }
  
  private void e()
  {
    h();
  }
  
  private void e(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    paramMsgBackupSessionRequest = MsgBackupUtil.a(paramMsgBackupSessionRequest);
    MsgBackupUtil.b(a, "analysisFileMeta:start dbName = %s ", new Object[] { paramMsgBackupSessionRequest });
    MsgBackupUtil.b();
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
          MsgBackupManager.b = ((MsgBackupExtraEntity)localObject2).value;
          localObject2 = (String)MsgBackupManager.e.get(((MsgBackupExtraEntity)localObject2).value);
          MsgBackupManager.d = (String)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            MsgBackupManager.a().k();
          }
        }
      }
    }
    paramMsgBackupSessionRequest.b();
  }
  
  private void f()
  {
    Object localObject1 = this.v;
    if (localObject1 != null)
    {
      if (((MsgBackupRequest)localObject1).g == -1)
      {
        MsgBackupTimeStats.a(null, "single_uin_cost");
      }
      else
      {
        MsgBackupTimeStats.a("single_uin_cost", null);
        MsgBackupTimeStats.a(null, "single_uin_cost");
      }
      localObject1 = this.v;
      ((MsgBackupRequest)localObject1).g += 1;
      int i1 = this.v.g;
      int i2 = this.v.f;
      if (i1 == 0) {
        MsgBackupTimeStats.a("statis_qianchums_start");
      }
      if (i1 == i2)
      {
        MsgBackupTimeStats.a("statis_qianchums_end");
        MsgBackupTimeStats.d();
      }
      if (i1 < i2)
      {
        localObject1 = (String)this.o.get(i1);
        localObject1 = (MsgBackupSessionRequest)this.r.get(localObject1);
        ((MsgBackupSessionRequest)localObject1).l = 0;
        Object localObject2 = MsgBackupUtil.a((MsgBackupSessionRequest)localObject1);
        MsgBackupDBHelper.a((String)localObject2);
        localObject2 = new MsgBackupDBHelper((String)localObject2);
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(MsgBackupManager.b))
        {
          MsgBackupUtil.b(a, "file meta is %s, key is %s", new Object[] { MsgBackupManager.b, MsgBackupManager.c });
          MsgBackupExtraEntity localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "key_meta";
          localMsgBackupExtraEntity.value = MsgBackupManager.b;
          localArrayList.add(localMsgBackupExtraEntity);
          localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "db_version";
          localMsgBackupExtraEntity.value = String.valueOf(1);
          localArrayList.add(localMsgBackupExtraEntity);
        }
        ((MsgBackupDBHelper)localObject2).c(localArrayList);
        ((MsgBackupDBHelper)localObject2).b();
        a((MsgBackupSessionRequest)localObject1);
      }
    }
  }
  
  private void g()
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      int i1 = ((MsgBackupRequest)localObject).g;
      int i2 = this.v.f;
      if (i1 < i2)
      {
        localObject = (String)this.o.get(i1);
        localObject = (MsgBackupSessionRequest)this.r.get(localObject);
        MsgBackupUtil.b(a, "singleNextQianchu curUin = %s,curQueryCount = %d,sessionMsgTotalCount = %d,mPendingMsgCount = %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(((MsgBackupSessionRequest)localObject).l), Integer.valueOf(((MsgBackupSessionRequest)localObject).j), Integer.valueOf(this.h) });
        if ((((MsgBackupSessionRequest)localObject).l < ((MsgBackupSessionRequest)localObject).j) && (this.h < e)) {
          a((MsgBackupSessionRequest)localObject);
        }
      }
      MsgBackupUtil.b(a, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
    }
  }
  
  private void h()
  {
    MsgBackupTransportProcessor.a().k(1);
  }
  
  private void i()
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      int i1 = ((MsgBackupRequest)localObject).g;
      int i2 = this.v.f;
      if (i1 < i2)
      {
        localObject = (String)this.p.get(i1);
        localObject = (MsgBackupSessionRequest)this.s.get(localObject);
        if ((((MsgBackupSessionRequest)localObject).l < ((MsgBackupSessionRequest)localObject).j) && (this.h < e)) {
          c((MsgBackupSessionRequest)localObject);
        }
        MsgBackupUtil.b(a, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d,querySingleIndex = %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(((MsgBackupSessionRequest)localObject).l) });
      }
    }
  }
  
  private void j()
  {
    Object localObject = this.v;
    if (localObject != null)
    {
      ((MsgBackupRequest)localObject).g += 1;
      int i1 = this.v.g;
      int i2 = this.v.f;
      MsgBackupUtil.b(a, "nextDaoru curIndex = %d,totalCount = %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
      if (i1 == 0) {
        MsgBackupTimeStats.a("statis_qianchums_start");
      }
      if (i1 == i2)
      {
        MsgBackupTimeStats.a("statis_qianchums_end");
        MsgBackupTimeStats.f();
      }
      if (i1 < i2)
      {
        localObject = (String)this.p.get(i1);
        localObject = (MsgBackupSessionRequest)this.s.get(localObject);
        ((MsgBackupSessionRequest)localObject).l = 0;
        MsgBackupUtil.a(a, "nextDaoru uin = %s,uinType = %d", new Object[] { ((MsgBackupSessionRequest)localObject).a, Integer.valueOf(((MsgBackupSessionRequest)localObject).b) });
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
      int i1 = 1;
      if (!bool) {
        break;
      }
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.msgtype != -2006) {
        if (((localMessageRecord.extraflag == 32768) || (localMessageRecord.extraflag == 32772)) && (localMessageRecord.isSendFromLocal())) {
          MsgBackupUtil.b(a, "preHandleQianchu..unsupport send not sucess msg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        } else if (!(localMessageRecord instanceof ChatMessage)) {
          MsgBackupUtil.b(a, "preHandleQianchu..unsupport not chatMessage _id = %d...,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        } else if ((!MsgProxyUtils.e(localMessageRecord.msgtype)) && (!MsgProxyUtils.d(localMessageRecord.msgtype)))
        {
          if (localIMsgBackupTempApi.isBeancurdMsg((ChatMessage)localMessageRecord))
          {
            MsgBackupUtil.b(a, "preHandleQianchu..unsupport BeancurdMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
          }
          else if (localIMsgBackupTempApi.isAnonymousMsg(localMessageRecord))
          {
            MsgBackupUtil.b(a, "preHandleQianchu..unsupport AnonymousMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
          }
          else if (localMessageRecord.msgtype == -2023)
          {
            MsgBackupUtil.b(a, "preHandleQianchu..unsupport msgtype MessageForCommonHobbyForAIOShow MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW", new Object[0]);
          }
          else if (((localMessageRecord.istroop == 1) || (localMessageRecord.istroop == 3000)) && (localMessageRecord.shmsgseq <= 0L))
          {
            MsgBackupUtil.b(a, "preHandleQianchu..unsupport troop or discurss msg shmsgseq <= 0", new Object[0]);
          }
          else
          {
            bool = localIMsgBackupTempApi.isSupportMsgType(this.b, localMessageRecord);
            if ((localMessageRecord.msgtype != -2002) && (localMessageRecord.msgtype != -2071) && (localMessageRecord.msgtype != -2007) && (localMessageRecord.msgtype != -5008) && (localMessageRecord.msgtype != -5017) && (localMessageRecord.msgtype != -8018)) {
              i1 = bool;
            }
            if (i1 != 0)
            {
              paramBaseQQAppInterface.add(localMessageRecord);
            }
            else
            {
              String str = localIMsgBackupTempApi.getUnsupportMsgStr(this.b, localMessageRecord);
              localMessageRecord = localIMsgBackupTempApi.changeRichTextToTextMsg(this.b, localMessageRecord, str, false);
              if (TextUtils.equals(localMessageRecord.senderuin, this.b.getCurrentAccountUin())) {
                ((ISVIPHandler)this.b.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).a(localMessageRecord);
              }
              localMessageRecord.setStatus(1000);
              localMessageRecord.msgData = localMessageRecord.msg.getBytes();
              paramBaseQQAppInterface.add(localMessageRecord);
            }
          }
        }
        else {
          MsgBackupUtil.b(a, "preHandleQianchu..unsupport graytipMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
      }
    }
    MsgBackupUtil.a(a, "preHandleQianchu..msgSize = %d...", new Object[] { Integer.valueOf(paramBaseQQAppInterface.size()) });
    return paramBaseQQAppInterface;
  }
  
  public void a()
  {
    this.l.set(false);
    MqqHandler localMqqHandler = this.i;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    localMqqHandler = this.j;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    this.q.clear();
    this.o.clear();
    this.r.clear();
    this.p.clear();
    this.r.clear();
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
      int i1 = paramList.size();
      a(paramAppInterface, paramMsgBackupDBHelper, paramList);
      try
      {
        paramMsgBackupSessionRequest.k += i1;
        this.h -= paramInt;
        MsgBackupUtil.b(a, "segmentExcuteQianchu step segment startNext,startIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramMsgBackupSessionRequest.k), Integer.valueOf(this.h), Integer.valueOf(paramMsgBackupSessionRequest.j) });
        if (paramMsgBackupSessionRequest.k >= paramMsgBackupSessionRequest.j)
        {
          if ((this.v != null) && (this.v.h != null))
          {
            paramAppInterface = new MsgBackupSessionInfo();
            paramAppInterface.a = paramMsgBackupSessionRequest.a;
            paramAppInterface.b = paramMsgBackupSessionRequest.b;
            this.v.h.a(this.v, paramAppInterface);
          }
          MsgBackupUtil.b(a, "segmentExcuteQianchu step this session has process done ,uin = %s,uintype = %d,msgSize = %d", new Object[] { paramMsgBackupSessionRequest.a, Integer.valueOf(paramMsgBackupSessionRequest.b), Integer.valueOf(paramMsgBackupDBHelper.c()) });
          this.q.remove(paramMsgBackupDBHelper.e());
          paramMsgBackupDBHelper.b();
          MsgBackupPbCache.b();
          MsgBackupTimeStats.a("statis_qianchums_end");
          this.j.removeCallbacksAndMessages(null);
          this.j.sendEmptyMessage(1);
        }
        else
        {
          this.j.sendEmptyMessage(2);
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
      Object localObject1 = a(this.b, paramList);
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
          Object localObject7 = ((IMultiMsgProxy)localObject6).queryMultiMsgWithNest(this.b, (MessageRecord)localObject4);
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
              Iterator localIterator = this.c.iterator();
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
            localObject6 = ((IMultiMsgProxy)localObject6).packPbFromMultiMsgWithNest(this.b, (HashMap)localObject7, null, true);
            localObject7 = MsgBackupUtil.d(((IMsgBackupTempApi)localObject2).handleMultiMsg((MessageRecord)localObject4));
            FileUtils.writeFile((byte[])localObject6, (String)localObject7);
            localObject8 = new MsgBackupResEntity();
            ((MsgBackupResEntity)localObject8).msgSeq = l1;
            ((MsgBackupResEntity)localObject8).msgRandom = l2;
            ((MsgBackupResEntity)localObject8).filePath = ((String)localObject7);
            ((MsgBackupResEntity)localObject8).fileSize = localObject6.length;
            ((MsgBackupResEntity)localObject8).msgSubType = 10;
            ((MsgBackupResEntity)localObject8).msgType = 4;
            ((MsgBackupResEntity)localObject8).extraDataStr = MsgBackupMultiMsgProcessor.a(this.b.getCurrentUin(), (MessageRecord)localObject4);
            paramList.add(localObject8);
            if (((ArrayList)localObject5).size() <= 0) {
              break label521;
            }
            paramList.addAll((Collection)localObject5);
          }
        }
        else
        {
          localObject5 = this.c.iterator();
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
          localObject4 = (MsgBackupMsgEntity)paramAppInterface.transToBackupEntity(this.b, (MessageRecord)localObject3);
          if (localObject4 != null) {
            ((ArrayList)localObject2).add(localObject4);
          } else {
            MsgBackupUtil.a(a, "segmentExcuteQianchu generate pb failed ..unsupport not chatMessage _id = %d,msgtype = %d .mr =%s ", new Object[] { Long.valueOf(((MessageRecord)localObject3).getId()), Integer.valueOf(((MessageRecord)localObject3).msgtype), ((MessageRecord)localObject3).toString() });
          }
        }
        catch (Throwable localThrowable)
        {
          localObject4 = a;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("transToBackupEntity : ");
          ((StringBuilder)localObject5).append(localThrowable);
          QLog.e((String)localObject4, 1, ((StringBuilder)localObject5).toString());
        }
      }
      MsgBackupUtil.b(a, "segmentExcuteQianchu step segment msg process  + msg.size = %d ", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
      paramMsgBackupDBHelper.a((List)localObject2);
      paramMsgBackupDBHelper.b(paramList);
      MsgBackupUtil.b(a, "segmentExcuteQianchu step segment insert db done", new Object[0]);
    }
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest)
  {
    if ((this.l.get()) && (MsgBackupUtil.b()))
    {
      int i1 = paramMsgBackupRequest.b;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2) {
            return;
          }
          MsgBackupUtil.b(a, "requestDaoru start ", new Object[0]);
          c(paramMsgBackupRequest);
          return;
        }
        MsgBackupUtil.b(a, "requestQianru start ", new Object[0]);
        MsgBackupSessionRequest localMsgBackupSessionRequest = new MsgBackupSessionRequest();
        MsgBackupUtil.a(paramMsgBackupRequest.i.substring(paramMsgBackupRequest.i.lastIndexOf("/") + 1), localMsgBackupSessionRequest);
        MsgBackupManager.o = localMsgBackupSessionRequest.a;
        MsgBackupManager.p = localMsgBackupSessionRequest.b;
        d(localMsgBackupSessionRequest);
        return;
      }
      i1 = paramMsgBackupRequest.a.size();
      MsgBackupUtil.b(a, "requestQianchu start,request.dataList.size() = %d ", new Object[] { Integer.valueOf(i1) });
      if (i1 == 0)
      {
        if (paramMsgBackupRequest.h != null) {
          paramMsgBackupRequest.h.a(1, paramMsgBackupRequest, null);
        }
      }
      else {
        b(paramMsgBackupRequest);
      }
      return;
    }
    MsgBackupUtil.b(a, "handleRequest checkDBDirs result = false,requestType = %d ", new Object[] { Integer.valueOf(paramMsgBackupRequest.b) });
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest, int paramInt)
  {
    this.l.set(true);
    MsgBackupUtil.b(a, "sendRequest is called from = %d", new Object[] { Integer.valueOf(paramInt) });
    this.v = paramMsgBackupRequest;
    if (MsgBackupUtil.b)
    {
      if (paramInt == 10000)
      {
        localMessage = this.i.obtainMessage(5);
        localMessage.obj = paramMsgBackupRequest;
        this.i.sendMessageDelayed(localMessage, 100L);
        return;
      }
      if (paramInt == 10001)
      {
        MsgBackupManager.b = null;
        MsgBackupManager.d = null;
        localMessage = this.i.obtainMessage(7);
        localMessage.obj = paramMsgBackupRequest;
        this.i.sendMessageDelayed(localMessage, 100L);
        return;
      }
      localMessage = this.i.obtainMessage(0);
      localMessage.obj = paramMsgBackupRequest;
      this.i.sendMessageDelayed(localMessage, 100L);
      return;
    }
    Message localMessage = this.i.obtainMessage(0);
    localMessage.obj = paramMsgBackupRequest;
    this.i.sendMessage(localMessage);
  }
  
  public void a(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    Object localObject1 = MsgBackupUtil.a(paramMsgBackupSessionRequest);
    MsgBackupUtil.b(a, "singleExcuteQianchu,start uin = %s,dbPath = %s,request.startQueryIndex = %d ", new Object[] { paramMsgBackupSessionRequest.a, localObject1, Integer.valueOf(paramMsgBackupSessionRequest.m) });
    if (this.q.get(localObject1) == null)
    {
      localObject2 = new MsgBackupDBHelper((String)localObject1);
      this.q.put(localObject1, localObject2);
    }
    localObject1 = (MsgBackupDBHelper)this.q.get(localObject1);
    Object localObject2 = MessageRecord.getTableName(paramMsgBackupSessionRequest.a, paramMsgBackupSessionRequest.b);
    IMessageFacade localIMessageFacade = (IMessageFacade)this.b.getRuntimeService(IMessageFacade.class, "");
    int i1;
    int i2;
    int i3;
    if (paramMsgBackupSessionRequest.j == 0)
    {
      i1 = localIMessageFacade.getQuickDBMsgCount((String)localObject2, paramMsgBackupSessionRequest.e, paramMsgBackupSessionRequest.f, paramMsgBackupSessionRequest.g);
      i2 = localIMessageFacade.getSlowDBMsgCount((String)localObject2, paramMsgBackupSessionRequest.e, paramMsgBackupSessionRequest.f, paramMsgBackupSessionRequest.g);
      i3 = i1 + i2;
      paramMsgBackupSessionRequest.h = i1;
      paramMsgBackupSessionRequest.i = i2;
      paramMsgBackupSessionRequest.j = i3;
    }
    else
    {
      i1 = paramMsgBackupSessionRequest.h;
      i2 = paramMsgBackupSessionRequest.i;
      i3 = paramMsgBackupSessionRequest.j;
    }
    if ((i3 != 0) && ((paramMsgBackupSessionRequest.l < i3) || (this.h != 0)))
    {
      MsgBackupUtil.b(a, "singleExcuteQianchu dbName = %s,quickDBCount = %d,slowDBCount = %d,totalCount = %d,request.queryIndex = %d,queryCount = %d", new Object[] { localObject2, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramMsgBackupSessionRequest.m), Integer.valueOf(paramMsgBackupSessionRequest.l) });
      if (i2 == 0)
      {
        i2 = paramMsgBackupSessionRequest.l;
        if (i2 < paramMsgBackupSessionRequest.h) {
          c(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localIMessageFacade, i1, i2);
        }
      }
      else
      {
        int i4 = paramMsgBackupSessionRequest.l;
        while (i4 < i3) {
          if (i4 < i2)
          {
            if (b(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localIMessageFacade, i2, i4) >= i2)
            {
              paramMsgBackupSessionRequest.l = i2;
              paramMsgBackupSessionRequest.m = 0;
            }
          }
          else
          {
            int i5 = i4 - i2;
            i4 = i5;
            if (i1 > 0)
            {
              i4 = i5;
              if (i5 < i1) {
                a(paramMsgBackupSessionRequest, (MsgBackupDBHelper)localObject1, (String)localObject2, localIMessageFacade, i1, i5);
              }
            }
          }
        }
      }
      return;
    }
    localObject2 = this.v;
    if ((localObject2 != null) && (((MsgBackupRequest)localObject2).h != null))
    {
      localObject2 = new MsgBackupSessionInfo();
      ((MsgBackupSessionInfo)localObject2).a = paramMsgBackupSessionRequest.a;
      ((MsgBackupSessionInfo)localObject2).b = paramMsgBackupSessionRequest.b;
      this.v.h.a(this.v, localObject2);
    }
    ((MsgBackupDBHelper)localObject1).b();
    this.j.sendEmptyMessage(1);
  }
  
  public void a(MsgBackupDBHelper paramMsgBackupDBHelper, MsgBackupSessionRequest paramMsgBackupSessionRequest, List<MsgBackupMsgEntity> paramList)
  {
    paramList.size();
    Object localObject1 = (IMsgBackupProxy)QRoute.api(IMsgBackupProxy.class);
    MsgBackupUtil.b(a, "segmentDaoru step:query done ,msgEntity.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i1 = 0;
    Object localObject4;
    while (paramList.hasNext())
    {
      Object localObject2 = (MsgBackupMsgEntity)paramList.next();
      if (((MsgBackupMsgEntity)localObject2).extensionData == null)
      {
        i1 += 1;
        MsgBackupUtil.b(a, "segmentDaoru step has encounter msgEntity.extensionData == null,msgType = %d,invalidMsgCount = %d", new Object[] { Integer.valueOf(((MsgBackupMsgEntity)localObject2).msgType), Integer.valueOf(i1) });
      }
      else
      {
        try
        {
          localObject2 = ((IMsgBackupProxy)localObject1).transToMessageRecord(this.b, localObject2);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
        catch (Throwable localThrowable)
        {
          localObject4 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("transToMessageRecord ");
          localStringBuilder.append(localThrowable);
          QLog.e((String)localObject4, 1, localStringBuilder.toString());
        }
      }
    }
    MsgBackupUtil.a(a, "segmentDaoru step:trans done ,msg.size = %d ", new Object[] { Integer.valueOf(localArrayList.size()) });
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
          localObject4 = this.c.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject3 = (IMsgBackupRichProcessor)((Iterator)localObject4).next();
            if (!((IMsgBackupRichProcessor)localObject3).a((MessageRecord)localObject1)) {
              break;
            }
            localObject4 = paramMsgBackupDBHelper.a(((MessageRecord)localObject1).msgBackupMsgSeq, ((MessageRecord)localObject1).msgBackupMsgRandom);
            if (localObject4 != null) {
              i1 = ((List)localObject4).size();
            } else {
              i1 = 0;
            }
            MsgBackupUtil.a(a, "segmentDaoru step:rich process ,query.res.size = %d ", new Object[] { Integer.valueOf(i1) });
            ((IMsgBackupRichProcessor)localObject3).b((MessageRecord)localObject1, (List)localObject4);
          }
        }
      }
      label418:
      paramMsgBackupDBHelper = new ArrayList();
      paramList = (MessageRecord)localArrayList.get(0);
      localObject1 = (IMessageFacade)this.b.getRuntimeService(IMessageFacade.class, "");
      Object localObject3 = ((IMessageFacade)localObject1).getAllMessages(paramList.frienduin, paramList.istroop, null);
      localObject4 = a;
      if (localObject3 != null) {
        i1 = ((List)localObject3).size();
      } else {
        i1 = 0;
      }
      MsgBackupUtil.b((String)localObject4, "segmentDaoru step:mainMsg.size = %d,uin = %s,istroop = %d ", new Object[] { Integer.valueOf(i1), paramList.frienduin, Integer.valueOf(paramList.istroop) });
      a(localArrayList, paramMsgBackupDBHelper, (List)localObject3);
      MsgBackupUtil.b(a, "segmentDaoru step:msgfilter done ,msgNew.size = %d ,uin = %s", new Object[] { Integer.valueOf(paramMsgBackupDBHelper.size()), paramMsgBackupSessionRequest.a });
      if (paramMsgBackupDBHelper.size() > 0)
      {
        Collections.sort(paramMsgBackupDBHelper, this);
        ((IMessageFacade)localObject1).addMessageForMsgBackup(paramMsgBackupDBHelper);
        if (MsgBackupUtil.a)
        {
          ((MessageRecord)paramMsgBackupDBHelper.get(0)).getTableName();
          paramMsgBackupDBHelper = ((IMessageFacade)localObject1).getAllMessages(paramMsgBackupSessionRequest.a, paramMsgBackupSessionRequest.b, null);
          if (paramMsgBackupDBHelper == null) {
            i1 = 0;
          } else {
            i1 = paramMsgBackupDBHelper.size();
          }
          MsgBackupUtil.a(a, "daoru step:seqmentDaoru done result size =  %d", new Object[] { Integer.valueOf(i1) });
        }
      }
    }
    MsgBackupUtil.b(a, "segmentDaoru step:saveToDb done ", new Object[0]);
  }
  
  public void b()
  {
    MqqHandler localMqqHandler = this.i;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeCallbacksAndMessages(null);
      this.m.quit();
    }
    localMqqHandler = this.j;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeCallbacksAndMessages(null);
      this.k.quit();
    }
  }
  
  public void b(MsgBackupRequest paramMsgBackupRequest)
  {
    MsgBackupTimeStats.h = 0L;
    HashSet localHashSet = paramMsgBackupRequest.a;
    if ((localHashSet != null) && (localHashSet.size() != 0))
    {
      this.o.clear();
      this.r.clear();
      this.q.clear();
      MsgBackupPbCache.a();
      MsgBackupTimeStats.c();
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (RecentBaseData)localIterator.next();
        String str = ((RecentBaseData)localObject).getRecentUserUin();
        int i1 = ((RecentBaseData)localObject).getRecentUserType();
        MsgBackupUtil.b(a, "requestQianchu uin = %s ", new Object[] { str });
        localObject = new MsgBackupSessionRequest();
        ((MsgBackupSessionRequest)localObject).a = str;
        ((MsgBackupSessionRequest)localObject).b = i1;
        ((MsgBackupSessionRequest)localObject).d = 0;
        ((MsgBackupSessionRequest)localObject).e = paramMsgBackupRequest.c;
        ((MsgBackupSessionRequest)localObject).f = paramMsgBackupRequest.d;
        ((MsgBackupSessionRequest)localObject).g = paramMsgBackupRequest.e;
        ((MsgBackupSessionRequest)localObject).l = -1;
        ((MsgBackupSessionRequest)localObject).m = 0;
        str = a(str, i1);
        this.o.add(str);
        this.r.put(str, localObject);
      }
      paramMsgBackupRequest.f = localHashSet.size();
      paramMsgBackupRequest.g = -1;
      this.j.sendEmptyMessage(1);
      return;
    }
    MsgBackupUtil.b(a, "qianchu no recentdBaseData ", new Object[0]);
  }
  
  public void b(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    Object localObject1 = MsgBackupUtil.a(paramMsgBackupSessionRequest);
    MsgBackupUtil.b(a, "singleNextQianru step:start dbName = %s， request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { localObject1, Integer.valueOf(paramMsgBackupSessionRequest.m), Integer.valueOf(paramMsgBackupSessionRequest.k), Integer.valueOf(this.h), Integer.valueOf(paramMsgBackupSessionRequest.j) });
    MsgBackupUtil.b();
    localObject1 = new MsgBackupDBHelper((String)localObject1);
    if (paramMsgBackupSessionRequest.j == 0) {
      paramMsgBackupSessionRequest.j = ((MsgBackupDBHelper)localObject1).d();
    }
    int i1 = paramMsgBackupSessionRequest.j;
    if ((i1 != 0) && ((paramMsgBackupSessionRequest.l < paramMsgBackupSessionRequest.j) || (this.h != 0)))
    {
      while ((paramMsgBackupSessionRequest.l < i1) && (this.h < g))
      {
        MsgBackupUtil.b(a, "singleNextQianru step:,request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.m), Integer.valueOf(paramMsgBackupSessionRequest.k), Integer.valueOf(this.h), Integer.valueOf(paramMsgBackupSessionRequest.j) });
        Object localObject2 = ((MsgBackupDBHelper)localObject1).a(paramMsgBackupSessionRequest.m + 1, f);
        paramMsgBackupSessionRequest.l += d;
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          paramMsgBackupSessionRequest.m = ((int)((MsgBackupResEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
          this.h += f;
          localObject2 = new MsgBackupController.5(this, (List)localObject2, paramMsgBackupSessionRequest);
          this.n.execute((Runnable)localObject2);
        }
        else if (this.h == 0)
        {
          if ((paramMsgBackupSessionRequest.k != paramMsgBackupSessionRequest.j) && (this.t.size() > 0))
          {
            a(null, null, 0L);
          }
          else
          {
            this.j.removeCallbacksAndMessages(null);
            this.j.sendEmptyMessage(6);
          }
        }
      }
      ((MsgBackupDBHelper)localObject1).b();
      return;
    }
    MsgBackupUtil.b(a, "singleNextQianru step queryResList.size = 0,", new Object[0]);
    this.j.removeCallbacksAndMessages(null);
    this.j.sendEmptyMessage(6);
    ((MsgBackupDBHelper)localObject1).b();
  }
  
  public void b(MsgBackupDBHelper paramMsgBackupDBHelper, MsgBackupSessionRequest paramMsgBackupSessionRequest, List<MsgBackupMsgEntity> paramList)
  {
    if ((paramMsgBackupDBHelper != null) && (paramMsgBackupSessionRequest != null) && (paramList != null))
    {
      int i1 = paramList.size();
      a(paramMsgBackupDBHelper, paramMsgBackupSessionRequest, paramList);
      try
      {
        this.h -= d;
        paramMsgBackupSessionRequest.k += i1;
        MsgBackupUtil.b(a, "segmentDaoru step segment startNext,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d,uin = %s ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.k), Integer.valueOf(this.h), Integer.valueOf(paramMsgBackupSessionRequest.j), paramMsgBackupSessionRequest.a });
        if (paramMsgBackupSessionRequest.k >= paramMsgBackupSessionRequest.j)
        {
          if ((this.v != null) && (this.v.h != null))
          {
            paramList = new MsgBackupSessionInfo();
            paramList.a = paramMsgBackupSessionRequest.a;
            paramList.b = paramMsgBackupSessionRequest.b;
            this.v.h.a(this.v, paramList);
          }
          MsgBackupUtil.b(a, "segmentDaoru step this session has process done ,uin = %s,uintype = %d", new Object[] { paramMsgBackupSessionRequest.a, Integer.valueOf(paramMsgBackupSessionRequest.b) });
          this.q.remove(paramMsgBackupDBHelper.e());
          paramMsgBackupDBHelper.b();
          this.j.removeCallbacksAndMessages(null);
          this.j.sendEmptyMessage(3);
        }
        else
        {
          this.j.sendEmptyMessage(4);
        }
        return;
      }
      finally {}
    }
  }
  
  public void c(MsgBackupRequest paramMsgBackupRequest)
  {
    HashSet localHashSet = paramMsgBackupRequest.a;
    if ((localHashSet != null) && (localHashSet.size() != 0))
    {
      this.p.clear();
      this.s.clear();
      this.q.clear();
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (RecentBaseData)localIterator.next();
        String str = ((RecentBaseData)localObject).getRecentUserUin();
        int i1 = ((RecentBaseData)localObject).getRecentUserType();
        MsgBackupUtil.b(a, "daoru uin = %s ", new Object[] { str });
        localObject = new MsgBackupSessionRequest();
        ((MsgBackupSessionRequest)localObject).a = str;
        ((MsgBackupSessionRequest)localObject).b = i1;
        ((MsgBackupSessionRequest)localObject).d = 2;
        ((MsgBackupSessionRequest)localObject).l = -1;
        ((MsgBackupSessionRequest)localObject).m = -1;
        str = a(str, i1);
        this.p.add(str);
        this.s.put(str, localObject);
      }
      paramMsgBackupRequest.f = localHashSet.size();
      paramMsgBackupRequest.g = -1;
      this.j.sendEmptyMessage(3);
      return;
    }
    MsgBackupUtil.a(a, "daoru no recentdBaseData ", new Object[0]);
  }
  
  public void c(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    MsgBackupManager.b = null;
    MsgBackupManager.d = null;
    e(paramMsgBackupSessionRequest);
    if (TextUtils.isEmpty(MsgBackupManager.d))
    {
      if (this.v.h != null)
      {
        localObject1 = new MsgBackupSessionInfo();
        ((MsgBackupSessionInfo)localObject1).a = paramMsgBackupSessionRequest.a;
        ((MsgBackupSessionInfo)localObject1).b = paramMsgBackupSessionRequest.b;
        MsgBackupUtil.b(a, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.m), Integer.valueOf(paramMsgBackupSessionRequest.j) });
        this.v.h.a(this.v, localObject1);
      }
      this.j.removeCallbacksAndMessages(null);
      this.j.sendEmptyMessage(3);
      return;
    }
    Object localObject1 = MsgBackupUtil.a(paramMsgBackupSessionRequest);
    Object localObject2;
    if (this.q.get(localObject1) == null)
    {
      localObject2 = new MsgBackupDBHelper((String)localObject1);
      this.q.put(localObject1, localObject2);
    }
    localObject1 = (MsgBackupDBHelper)this.q.get(localObject1);
    int i1 = ((MsgBackupDBHelper)localObject1).c();
    if (paramMsgBackupSessionRequest.j == 0) {
      paramMsgBackupSessionRequest.j = ((MsgBackupDBHelper)localObject1).c();
    }
    if ((paramMsgBackupSessionRequest.j != 0) && ((paramMsgBackupSessionRequest.l < i1) || (this.h != 0)))
    {
      while ((paramMsgBackupSessionRequest.l < i1) && (this.h < e))
      {
        MsgBackupUtil.b(a, "singleDaoru queryMsgBefore  curIndex = %d,totalCount = %d,doneCount = %d ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.m), Integer.valueOf(paramMsgBackupSessionRequest.j), Integer.valueOf(paramMsgBackupSessionRequest.k) });
        int i2 = paramMsgBackupSessionRequest.l;
        localObject2 = ((MsgBackupDBHelper)localObject1).a(paramMsgBackupSessionRequest.m + 1, d);
        paramMsgBackupSessionRequest.l += d;
        if ((localObject2 != null) && (((List)localObject2).size() != 0))
        {
          paramMsgBackupSessionRequest.m = ((int)((MsgBackupMsgEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
          MsgBackupUtil.a(a, "singleDaoru queryMsg result.size = %d ", new Object[] { Integer.valueOf(((List)localObject2).size()) });
          this.h += d;
          localObject2 = new MsgBackupController.6(this, (MsgBackupDBHelper)localObject1, paramMsgBackupSessionRequest, (List)localObject2);
          this.n.execute((Runnable)localObject2);
        }
        else
        {
          MsgBackupUtil.b(a, "singleDaoru..query result == 0", new Object[0]);
          if ((this.h == 0) && (this.v.h != null))
          {
            MsgBackupUtil.a(a, "singleDaoru queryMsgAfter  msgSize = = 0 ", new Object[0]);
            localObject2 = new MsgBackupSessionInfo();
            ((MsgBackupSessionInfo)localObject2).a = paramMsgBackupSessionRequest.a;
            ((MsgBackupSessionInfo)localObject2).b = paramMsgBackupSessionRequest.b;
            this.v.h.a(this.v, localObject2);
            ((MsgBackupDBHelper)localObject1).b();
            this.j.sendEmptyMessage(3);
          }
        }
      }
      return;
    }
    if (this.v.h != null)
    {
      localObject2 = new MsgBackupSessionInfo();
      ((MsgBackupSessionInfo)localObject2).a = paramMsgBackupSessionRequest.a;
      ((MsgBackupSessionInfo)localObject2).b = paramMsgBackupSessionRequest.b;
      MsgBackupUtil.b(a, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramMsgBackupSessionRequest.m), Integer.valueOf(paramMsgBackupSessionRequest.j) });
      this.v.h.a(this.v, localObject2);
    }
    ((MsgBackupDBHelper)localObject1).b();
    this.j.sendEmptyMessage(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.l.get()) {
      return false;
    }
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 5)
      {
        if (i1 != 6)
        {
          if (i1 != 7) {
            return true;
          }
          if ((TextUtils.isEmpty(MsgBackupManager.b)) && ((paramMessage.obj instanceof MsgBackupRequest)))
          {
            localObject = (MsgBackupRequest)paramMessage.obj;
            MsgBackupSessionRequest localMsgBackupSessionRequest = new MsgBackupSessionRequest();
            MsgBackupUtil.a(((MsgBackupRequest)localObject).i.substring(((MsgBackupRequest)localObject).i.lastIndexOf("/") + 1), localMsgBackupSessionRequest);
            e(localMsgBackupSessionRequest);
          }
          localObject = this.i.obtainMessage(6);
          ((Message)localObject).obj = paramMessage.obj;
          this.i.sendMessage((Message)localObject);
          return true;
        }
        if (TextUtils.isEmpty(MsgBackupManager.b))
        {
          MsgBackupUtil.a(a, "MSG_WHAT_SUB_DECRYPT_KEY_VALID sFileMeta is null, so skip this session!", new Object[0]);
          h();
          return true;
        }
        localObject = (String)MsgBackupManager.e.get(MsgBackupManager.b);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = this.i.obtainMessage(6);
          ((Message)localObject).obj = paramMessage.obj;
          this.i.sendMessageDelayed((Message)localObject, 1000L);
          return true;
        }
        MsgBackupManager.d = (String)localObject;
        localObject = this.i.obtainMessage(0);
        ((Message)localObject).obj = paramMessage.obj;
        this.i.sendMessage((Message)localObject);
        return true;
      }
      if (TextUtils.isEmpty(MsgBackupManager.c))
      {
        localObject = this.i.obtainMessage(5);
        ((Message)localObject).obj = paramMessage.obj;
        this.i.sendMessageDelayed((Message)localObject, 1000L);
        return true;
      }
      localObject = this.i.obtainMessage(0);
      ((Message)localObject).what = 0;
      ((Message)localObject).obj = paramMessage.obj;
      this.i.sendMessage((Message)localObject);
      return true;
    }
    Object localObject = a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupController
 * JD-Core Version:    0.7.0.1
 */