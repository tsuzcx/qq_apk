package com.tencent.mobileqq.flashshow.redpoint;

import android.os.HandlerThread;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flashshow.api.IFlashShowEeveeManagerService;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.flashshow.api.events.FSAccountChangeEvent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudEeveeUndealmsg.BizUndealMsg;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import feedcloud.FeedCloudEeveeUndealmsg.IntervalControl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import qflash.QFlashBadge.EeveeMessageBufferData;

public class FSEeveeManager
  implements SimpleEventReceiver
{
  public static long d;
  private static volatile FSEeveeManager e;
  public long a = 60000L;
  public long b = 5000L;
  public long c = 45000L;
  private volatile MqqHandler f;
  private long g = 0L;
  private long h = 0L;
  private final AtomicInteger i = new AtomicInteger(10000);
  private final Runnable j = new FSEeveeManager.1(this);
  
  private FSEeveeManager()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public static FSEeveeManager a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new FSEeveeManager();
        }
      }
      finally {}
    }
    return e;
  }
  
  private void a(FeedCloudEeveeUndealmsg.BizUndealMsg paramBizUndealMsg)
  {
    int k = paramBizUndealMsg.mainType.get();
    paramBizUndealMsg = paramBizUndealMsg.bufferData.get();
    if (paramBizUndealMsg != null) {
      paramBizUndealMsg = paramBizUndealMsg.toByteArray();
    } else {
      paramBizUndealMsg = null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleBizUndealMsg mainType ");
    ((StringBuilder)localObject).append(k);
    QLog.d("FSEeveeRedPoint", 1, ((StringBuilder)localObject).toString());
    if (k != 111) {
      return;
    }
    try
    {
      localObject = new QFlashBadge.EeveeMessageBufferData();
      ((QFlashBadge.EeveeMessageBufferData)localObject).mergeFrom(paramBizUndealMsg);
      paramBizUndealMsg = new StringBuilder();
      paramBizUndealMsg.append("handleBizUndealMsg mainType ");
      paramBizUndealMsg.append(k);
      paramBizUndealMsg.append(", ");
      paramBizUndealMsg.append(((QFlashBadge.EeveeMessageBufferData)localObject).qFlashBadgeInfoList.size());
      QLog.d("FSEeveeRedPoint", 1, paramBizUndealMsg.toString());
      ((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).handleRedPointInfos(((QFlashBadge.EeveeMessageBufferData)localObject).qFlashBadgeInfoList.get());
      return;
    }
    catch (Exception paramBizUndealMsg)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleBizUndealMsg error: mainType ");
      ((StringBuilder)localObject).append(k);
      QLog.e("FSEeveeRedPoint", 1, ((StringBuilder)localObject).toString(), paramBizUndealMsg);
    }
  }
  
  private void a(FeedCloudEeveeUndealmsg.FcUndealMsgsRsp paramFcUndealMsgsRsp, int paramInt)
  {
    if (paramFcUndealMsgsRsp == null) {
      return;
    }
    a(paramFcUndealMsgsRsp.intervalCtl);
    paramFcUndealMsgsRsp = paramFcUndealMsgsRsp.msgs.get();
    if (paramFcUndealMsgsRsp.isEmpty()) {
      return;
    }
    paramFcUndealMsgsRsp = paramFcUndealMsgsRsp.iterator();
    while (paramFcUndealMsgsRsp.hasNext()) {
      a((FeedCloudEeveeUndealmsg.BizUndealMsg)paramFcUndealMsgsRsp.next());
    }
  }
  
  private void a(FeedCloudEeveeUndealmsg.IntervalControl paramIntervalControl)
  {
    if (paramIntervalControl == null) {
      return;
    }
    int k = paramIntervalControl.pollingInterval.get();
    if (k > 0) {
      this.a = (k * 1000L);
    }
    int m = paramIntervalControl.sceneSwitchInterval.get();
    if (m > 0) {
      this.b = (m * 1000L);
    }
    int n = paramIntervalControl.homeSwitchInterval.get();
    if (n > 0) {
      this.c = (n * 1000L);
    }
    paramIntervalControl = new StringBuilder();
    paramIntervalControl.append("saveInterval pollingInterval= ");
    paramIntervalControl.append(k);
    paramIntervalControl.append("sceneSwitchInterval =");
    paramIntervalControl.append(m);
    paramIntervalControl.append("homeSwitchInterval");
    paramIntervalControl.append(n);
    QLog.d("FSEeveeRedPoint", 1, paramIntervalControl.toString());
  }
  
  /* Error */
  public static void c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 123
    //   5: iconst_1
    //   6: ldc 223
    //   8: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: getstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnonnull +7 -> 23
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 2
    //   25: monitorenter
    //   26: getstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   29: ifnonnull +10 -> 39
    //   32: ldc 2
    //   34: monitorexit
    //   35: ldc 2
    //   37: monitorexit
    //   38: return
    //   39: getstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   42: getfield 225	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:f	Lmqq/os/MqqHandler;
    //   45: ifnull +30 -> 75
    //   48: getstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   51: getfield 225	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:f	Lmqq/os/MqqHandler;
    //   54: getstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   57: getfield 57	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:j	Ljava/lang/Runnable;
    //   60: invokevirtual 231	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   63: getstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   66: getfield 225	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:f	Lmqq/os/MqqHandler;
    //   69: invokevirtual 235	mqq/os/MqqHandler:getLooper	()Landroid/os/Looper;
    //   72: invokevirtual 240	android/os/Looper:quit	()V
    //   75: getstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   78: aconst_null
    //   79: putfield 225	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:f	Lmqq/os/MqqHandler;
    //   82: invokestatic 63	com/tencent/biz/richframework/eventbus/SimpleEventBus:getInstance	()Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;
    //   85: getstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   88: invokevirtual 243	com/tencent/biz/richframework/eventbus/SimpleEventBus:unRegisterReceiver	(Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;)V
    //   91: new 2	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager
    //   94: dup
    //   95: invokespecial 71	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:<init>	()V
    //   98: putstatic 70	com/tencent/mobileqq/flashshow/redpoint/FSEeveeManager:e	Lcom/tencent/mobileqq/flashshow/redpoint/FSEeveeManager;
    //   101: ldc 2
    //   103: monitorexit
    //   104: ldc 2
    //   106: monitorexit
    //   107: return
    //   108: astore_0
    //   109: ldc 2
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	2	0	localFSEeveeManager	FSEeveeManager
    //   108	5	0	localObject1	Object
    //   114	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	35	108	finally
    //   39	75	108	finally
    //   75	104	108	finally
    //   109	112	108	finally
    //   3	15	114	finally
    //   23	26	114	finally
    //   112	114	114	finally
  }
  
  private MqqHandler e()
  {
    if (this.f == null) {
      try
      {
        if (this.f == null)
        {
          HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("fs_eevee_timer", 0);
          localHandlerThread.start();
          this.f = new MqqHandler(localHandlerThread.getLooper());
        }
      }
      finally {}
    }
    return this.f;
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public AtomicInteger b()
  {
    return this.i;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSAccountChangeEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FSAccountChangeEvent)) && (((FSAccountChangeEvent)paramSimpleBaseEvent).hasSwitchAccount())) {
      ((IFlashShowEeveeManagerService)QRoute.api(IFlashShowEeveeManagerService.class)).release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.redpoint.FSEeveeManager
 * JD-Core Version:    0.7.0.1
 */