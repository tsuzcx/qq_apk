package com.tencent.mobileqq.transfile.api.impl;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.proto.IProtoReqStrategy;
import com.tencent.mobileqq.transfile.ptt.PttProtoReqStrategy;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class ProtoReqManagerImpl
  implements DPCObserver, IProtoReqManager
{
  public static final String KEY_RUNNABLE_INDEX = "key_runnable_index";
  public static final String TAG = "Q.richmedia.ProtoReqManager";
  @ConfigInject(configPath="Foundation/Transfile/src/main/resources/Inject_InitProtoReqStrategyConfig.yml", version=1)
  public static HashMap<String, Class<? extends IProtoReqStrategy>> protoReqStrategy = new HashMap();
  private AppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mHasGetDPC = false;
  ConcurrentHashMap<Intent, ProtoReqManagerImpl.ProtoResp> requests = new ConcurrentHashMap();
  
  static
  {
    protoReqStrategy.put("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200", PttProtoReqStrategy.class);
    protoReqStrategy.put("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500", PttProtoReqStrategy.class);
    protoReqStrategy.put("PttStore.GroupPttDown", PttProtoReqStrategy.class);
    protoReqStrategy.put("PttStore.GroupPttUp", PttProtoReqStrategy.class);
  }
  
  private void getDPC()
  {
    if (((IDPCApi)QRoute.api(IDPCApi.class)).getServerDataCurrentState() == 4) {
      RichMediaStrategy.updataFromDpc(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.RichProReqCfg.name()));
    }
  }
  
  private boolean isAllTryFinished(ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int i = 0;
    while (i < paramProtoResp.runs.length)
    {
      if ((!paramProtoResp.runs[i].finished) && ((paramProtoResp.runs[i].activated == true) || (paramProtoResp.runs[i].scheduled == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void recordRunnableBack(Intent paramIntent, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramProtoResp.runs[i].finished = true;
    paramProtoResp.runs[i].finishTime = System.currentTimeMillis();
  }
  
  private void setConfigFromDpc(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    paramProtoReq.tryTime = RichMediaStrategy.getTryTime_dpc();
    paramProtoReq.tryCount = RichMediaStrategy.getTryCount_dpc();
    paramProtoReq.fixScheduleCount = RichMediaStrategy.getFixSchedulTryCount_dpc();
  }
  
  private void stopAllRunnables(ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    paramProtoResp.processed = true;
    int i = 0;
    while (i < paramProtoResp.runs.length)
    {
      this.requests.remove(paramProtoResp.runs[i].intent);
      this.mHandler.removeCallbacks(paramProtoResp.runs[i]);
      i += 1;
    }
  }
  
  public void cancelReq(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if (paramProtoReq != null) {}
    try
    {
      if (paramProtoReq.resp != null) {
        stopAllRunnables(paramProtoReq.resp);
      }
      return;
    }
    finally
    {
      paramProtoReq = finally;
      throw paramProtoReq;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.ProtoReqManager", 2, "onDestroy ");
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mApp = null;
  }
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      RichMediaStrategy.updataFromDpc(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.RichProReqCfg.name()));
    }
    ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    for (;;)
    {
      ProtoReqManagerImpl.IProtoRespBack localIProtoRespBack;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label539;
        }
        localObject = (ProtoReqManagerImpl.ProtoResp)this.requests.get(paramIntent);
        if (localObject == null) {
          break label524;
        }
        if (((ProtoReqManagerImpl.ProtoResp)localObject).processed)
        {
          localProtoReq = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localProtoReq;
          if (localObject != null) {
            ((ProtoReqManagerImpl.IProtoRespBack)localObject).onProtoResp(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        recordRunnableBack(paramIntent, (ProtoReqManagerImpl.ProtoResp)localObject);
        localProtoReq = ((ProtoReqManagerImpl.ProtoResp)localObject).req;
        ((ProtoReqManagerImpl.ProtoResp)localObject).resp = paramFromServiceMsg;
        ((ProtoReqManagerImpl.ProtoResp)localObject).statisInfo.b = ((ProtoReqManagerImpl.ProtoResp)localObject).resp.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          stopAllRunnables((ProtoReqManagerImpl.ProtoResp)localObject);
          this.requests.remove(paramIntent);
          if (localProtoReq.callback != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localIProtoRespBack = localProtoReq.callback;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localProtoReq;
            localObject = localIProtoRespBack;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((ProtoReqManagerImpl.ProtoResp)localObject).startTime;
            if ((l1 < localProtoReq.noMsfSuggestRetryTime) && (((ProtoReqManagerImpl.ProtoResp)localObject).freeRunnalbleIndex < localProtoReq.tryCount))
            {
              long l2 = localProtoReq.tryTime;
              paramIntent = localObject.runs[localObject.freeRunnalbleIndex];
              ((ProtoReqManagerImpl.ProtoResp)localObject).freeRunnalbleIndex += 1;
              paramIntent.timeOut = (l2 - l1 - 5000L);
              scheduleRunnable(paramIntent, 0L);
              localIProtoRespBack = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localProtoReq;
              localObject = localIProtoRespBack;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((ProtoReqManagerImpl.ProtoResp)localObject).freeRunnalbleIndex);
            }
          }
          if (isAllTryFinished((ProtoReqManagerImpl.ProtoResp)localObject))
          {
            stopAllRunnables((ProtoReqManagerImpl.ProtoResp)localObject);
            this.requests.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new ProtoReqManagerImpl.CheckConErroObserverImp(this, (ProtoReqManagerImpl.ProtoResp)localObject, localProtoReq));
              paramIntent.putExtra("action", 2201);
              this.mApp.startServlet(paramIntent);
              localIProtoRespBack = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localProtoReq;
              localObject = localIProtoRespBack;
              continue;
            }
            if (localProtoReq.callback != null)
            {
              localIProtoRespBack = localProtoReq.callback;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localProtoReq;
              localObject = localIProtoRespBack;
              continue;
            }
          }
        }
        localIProtoRespBack = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localProtoReq;
      localObject = localIProtoRespBack;
      continue;
      label524:
      ProtoReqManagerImpl.ProtoReq localProtoReq = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localProtoReq;
      continue;
      label539:
      paramIntent = null;
      localProtoReq = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localProtoReq;
    }
  }
  
  public void scheduleRunnable(ProtoReqManagerImpl.ProtoReqRunnable paramProtoReqRunnable, long paramLong)
  {
    paramProtoReqRunnable.scheduled = true;
    this.mHandler.postDelayed(paramProtoReqRunnable, paramLong);
  }
  
  /* Error */
  public void sendProtoReq(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +32 -> 37
    //   8: ldc 15
    //   10: iconst_2
    //   11: new 227	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 361
    //   21: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: getfield 364	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:ssoCmd	Ljava/lang/String;
    //   28: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 77	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl:mHasGetDPC	Z
    //   41: ifne +12 -> 53
    //   44: aload_0
    //   45: invokespecial 366	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl:getDPC	()V
    //   48: aload_0
    //   49: iconst_1
    //   50: putfield 77	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl:mHasGetDPC	Z
    //   53: aload_0
    //   54: getfield 200	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   57: astore 9
    //   59: aload 9
    //   61: ifnonnull +6 -> 67
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_1
    //   68: ifnull -4 -> 64
    //   71: aload_1
    //   72: getfield 364	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:ssoCmd	Ljava/lang/String;
    //   75: ifnull +34 -> 109
    //   78: aload_1
    //   79: getfield 364	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:ssoCmd	Ljava/lang/String;
    //   82: ldc_w 368
    //   85: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +16 -> 104
    //   91: aload_1
    //   92: getfield 364	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:ssoCmd	Ljava/lang/String;
    //   95: ldc_w 376
    //   98: invokevirtual 374	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifeq +8 -> 109
    //   104: aload_0
    //   105: aload_1
    //   106: invokespecial 378	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl:setConfigFromDpc	(Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq;)V
    //   109: aload_1
    //   110: getfield 364	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:ssoCmd	Ljava/lang/String;
    //   113: astore 11
    //   115: aconst_null
    //   116: astore 10
    //   118: aload 10
    //   120: astore 9
    //   122: aload 11
    //   124: ifnull +35 -> 159
    //   127: getstatic 41	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl:protoReqStrategy	Ljava/util/HashMap;
    //   130: aload 11
    //   132: invokevirtual 379	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 381	java/lang/Class
    //   138: astore 11
    //   140: aload 10
    //   142: astore 9
    //   144: aload 11
    //   146: ifnull +13 -> 159
    //   149: aload 11
    //   151: invokevirtual 385	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   154: checkcast 387	com/tencent/mobileqq/transfile/proto/IProtoReqStrategy
    //   157: astore 9
    //   159: aload 9
    //   161: ifnull +11 -> 172
    //   164: aload 9
    //   166: aload_1
    //   167: invokeinterface 390 2 0
    //   172: new 114	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp
    //   175: dup
    //   176: invokespecial 391	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:<init>	()V
    //   179: astore 10
    //   181: aload_1
    //   182: aload 10
    //   184: putfield 192	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:resp	Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp;
    //   187: aload 10
    //   189: aload_1
    //   190: putfield 255	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:req	Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq;
    //   193: aload 10
    //   195: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   198: putfield 293	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:startTime	J
    //   201: aload 10
    //   203: aload_1
    //   204: getfield 164	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:tryCount	I
    //   207: anewarray 120	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable
    //   210: putfield 118	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:runs	[Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable;
    //   213: aload_1
    //   214: getfield 395	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:reqBody	[B
    //   217: astore 11
    //   219: aload 11
    //   221: arraylength
    //   222: iconst_4
    //   223: iadd
    //   224: invokestatic 401	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   227: astore 12
    //   229: aload 12
    //   231: aload 11
    //   233: arraylength
    //   234: iconst_4
    //   235: iadd
    //   236: invokevirtual 404	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   239: aload 11
    //   241: invokevirtual 407	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   244: pop
    //   245: aload 12
    //   247: invokevirtual 410	java/nio/ByteBuffer:array	()[B
    //   250: astore 11
    //   252: iconst_0
    //   253: istore_2
    //   254: iload_2
    //   255: aload_1
    //   256: getfield 164	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:tryCount	I
    //   259: if_icmpge +259 -> 518
    //   262: new 120	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable
    //   265: dup
    //   266: aload_0
    //   267: invokespecial 413	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable:<init>	(Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl;)V
    //   270: astore 12
    //   272: aload 10
    //   274: getfield 118	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:runs	[Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable;
    //   277: iload_2
    //   278: aload 12
    //   280: aastore
    //   281: aload 12
    //   283: aload 10
    //   285: putfield 414	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable:resp	Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp;
    //   288: aload 12
    //   290: new 322	mqq/app/NewIntent
    //   293: dup
    //   294: aload_0
    //   295: getfield 200	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   298: invokevirtual 418	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   301: ldc_w 420
    //   304: invokespecial 331	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   307: putfield 179	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable:intent	Lmqq/app/NewIntent;
    //   310: aload 12
    //   312: getfield 179	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable:intent	Lmqq/app/NewIntent;
    //   315: astore 12
    //   317: aload 12
    //   319: ldc_w 422
    //   322: aload 11
    //   324: invokevirtual 425	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   327: pop
    //   328: aload 12
    //   330: ldc_w 427
    //   333: aload_1
    //   334: getfield 364	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:ssoCmd	Ljava/lang/String;
    //   337: invokevirtual 430	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   340: pop
    //   341: aload 12
    //   343: ldc 12
    //   345: iload_2
    //   346: invokevirtual 346	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   349: pop
    //   350: aload 12
    //   352: ldc_w 432
    //   355: aload_1
    //   356: getfield 435	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:isFastResendEnable	Z
    //   359: invokevirtual 438	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   362: pop
    //   363: aload 12
    //   365: ldc_w 440
    //   368: aload_1
    //   369: getfield 443	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:isNeedRemindSlowNetwork	Z
    //   372: invokevirtual 438	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   375: pop
    //   376: aload 9
    //   378: ifnull +133 -> 511
    //   381: aload 9
    //   383: aload 12
    //   385: invokeinterface 446 2 0
    //   390: goto +121 -> 511
    //   393: astore 9
    //   395: aload 9
    //   397: invokevirtual 449	java/lang/IllegalAccessException:printStackTrace	()V
    //   400: aload 10
    //   402: astore 9
    //   404: goto -245 -> 159
    //   407: astore_1
    //   408: aload_0
    //   409: monitorexit
    //   410: aload_1
    //   411: athrow
    //   412: astore 9
    //   414: aload 9
    //   416: invokevirtual 450	java/lang/InstantiationException:printStackTrace	()V
    //   419: aload 10
    //   421: astore 9
    //   423: goto -264 -> 159
    //   426: iload_2
    //   427: aload_1
    //   428: getfield 170	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:fixScheduleCount	I
    //   431: if_icmpge +68 -> 499
    //   434: aload_1
    //   435: getfield 158	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:tryTime	I
    //   438: iload_2
    //   439: imul
    //   440: aload_1
    //   441: getfield 170	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:fixScheduleCount	I
    //   444: idiv
    //   445: i2l
    //   446: lstore_3
    //   447: aload_1
    //   448: getfield 158	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:tryTime	I
    //   451: i2l
    //   452: lstore 5
    //   454: aload_1
    //   455: getfield 453	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:timeSpace	I
    //   458: iload_2
    //   459: imul
    //   460: i2l
    //   461: lstore 7
    //   463: aload 10
    //   465: getfield 118	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:runs	[Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable;
    //   468: iload_2
    //   469: aaload
    //   470: lload 5
    //   472: lload_3
    //   473: lsub
    //   474: lload 7
    //   476: lsub
    //   477: putfield 304	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable:timeOut	J
    //   480: aload_0
    //   481: aload 10
    //   483: getfield 118	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:runs	[Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable;
    //   486: iload_2
    //   487: aaload
    //   488: lload_3
    //   489: invokevirtual 308	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl:scheduleRunnable	(Lcom/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReqRunnable;J)V
    //   492: iload_2
    //   493: iconst_1
    //   494: iadd
    //   495: istore_2
    //   496: goto -70 -> 426
    //   499: aload 10
    //   501: aload_1
    //   502: getfield 170	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:fixScheduleCount	I
    //   505: putfield 299	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:freeRunnalbleIndex	I
    //   508: goto -444 -> 64
    //   511: iload_2
    //   512: iconst_1
    //   513: iadd
    //   514: istore_2
    //   515: goto -261 -> 254
    //   518: iconst_0
    //   519: istore_2
    //   520: goto -94 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	ProtoReqManagerImpl
    //   0	523	1	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   253	267	2	i	int
    //   446	43	3	l1	long
    //   452	19	5	l2	long
    //   461	14	7	l3	long
    //   57	325	9	localObject1	Object
    //   393	3	9	localIllegalAccessException	java.lang.IllegalAccessException
    //   402	1	9	localObject2	Object
    //   412	3	9	localInstantiationException	java.lang.InstantiationException
    //   421	1	9	localObject3	Object
    //   116	384	10	localProtoResp	ProtoReqManagerImpl.ProtoResp
    //   113	210	11	localObject4	Object
    //   227	157	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   149	159	393	java/lang/IllegalAccessException
    //   2	37	407	finally
    //   37	53	407	finally
    //   53	59	407	finally
    //   71	104	407	finally
    //   104	109	407	finally
    //   109	115	407	finally
    //   127	140	407	finally
    //   149	159	407	finally
    //   164	172	407	finally
    //   172	252	407	finally
    //   254	376	407	finally
    //   381	390	407	finally
    //   395	400	407	finally
    //   414	419	407	finally
    //   426	492	407	finally
    //   499	508	407	finally
    //   149	159	412	java/lang/InstantiationException
  }
  
  void sendToMsf(NewIntent paramNewIntent)
  {
    if (this.mApp != null) {
      this.mApp.startServlet(paramNewIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl
 * JD-Core Version:    0.7.0.1
 */