package com.tencent.mobileqq.winkpublish.queue;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.IPublishQueueListener;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.Singleton;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.event.DraftDataChangeEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.NetworkState;
import cooperation.qqcircle.utils.NetworkState.NetworkStateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public class AUploadTaskQueue
  implements Handler.Callback, IPublishQueue, NetworkState.NetworkStateListener
{
  public static final String a;
  public static boolean b = false;
  private static int c;
  private static final Singleton<AUploadTaskQueue, Void> f;
  private static final long k = TimeZone.getTimeZone("GMT+8").getRawOffset();
  private Handler d = new Handler(QCircleHostQzoneThreadHelper.getRealTimeLooper(), this);
  private final ArrayList<WeakReference<IPublishQueueListener>> e = new ArrayList();
  private boolean g = false;
  private Runnable h = new AUploadTaskQueue.2(this);
  private Runnable i = new AUploadTaskQueue.3(this);
  private Runnable j = new AUploadTaskQueue.4(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("[upload2_AUploadTaskQueue]");
    a = localStringBuilder.toString();
    c = 10;
    f = new AUploadTaskQueue.1();
  }
  
  private AUploadTaskQueue()
  {
    NetworkState.addListener(this);
  }
  
  public static AUploadTaskQueue a()
  {
    return (AUploadTaskQueue)f.get(null);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddTask id:");
    localStringBuilder.append(paramMessage.getTaskId());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.getExactType());
    localStringBuilder.append(" network:");
    localStringBuilder.append(NetworkState.isNetSupport());
    QLog.i(str, 1, localStringBuilder.toString());
    AUploadTaskManager.a().a(paramMessage);
    if (!NetworkState.isNetSupport())
    {
      paramMessage.setState(6);
      a(paramMessage, false);
    }
    else
    {
      i();
    }
    f();
  }
  
  private void b(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdateTask id:");
    localStringBuilder.append(paramMessage.getTaskId());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.getExactType());
    QLog.i(str, 1, localStringBuilder.toString());
    AUploadTaskManager.a().b(paramMessage);
  }
  
  private void c(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPauseTask id:");
    localStringBuilder.append(paramMessage.getTaskId());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.getExactType());
    QLog.i(str, 1, localStringBuilder.toString());
    AUploadTaskManager.a().c(paramMessage);
  }
  
  private void d(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeTask id:");
    localStringBuilder.append(paramMessage.getTaskId());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.getExactType());
    QLog.i(str, 1, localStringBuilder.toString());
    AUploadTaskManager.a().d(paramMessage);
    if (!NetworkState.isNetSupport()) {
      a(paramMessage, false);
    } else {
      i();
    }
    f();
  }
  
  private void e(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    paramMessage = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onResumeTaskForAll] clientKey: ");
    ((StringBuilder)localObject).append(str);
    QLog.i(paramMessage, 1, ((StringBuilder)localObject).toString());
    localObject = ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).getTaskList();
    if (localObject != null)
    {
      paramMessage = (Message)localObject;
      if (((CopyOnWriteArrayList)localObject).size() != 0) {}
    }
    else
    {
      AUploadTaskManager.a().c();
      localObject = AUploadTaskManager.a().e();
      paramMessage = (Message)localObject;
      if (localObject == null)
      {
        QLog.w(a, 1, "warning!!! taskList == null");
        return;
      }
    }
    paramMessage = paramMessage.iterator();
    while (paramMessage.hasNext())
    {
      localObject = (IQueueTask)paramMessage.next();
      if ((localObject != null) && (str.equals(((IQueueTask)localObject).getClientKey())))
      {
        AUploadTaskManager.a().e((IQueueTask)localObject);
        if (!NetworkState.isNetSupport()) {
          a((IQueueTask)localObject, false);
        } else {
          i();
        }
      }
    }
    f();
  }
  
  private void f(Message paramMessage)
  {
    IQueueTask localIQueueTask = (IQueueTask)paramMessage.obj;
    if (localIQueueTask == null) {
      return;
    }
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onCompleteTask id:");
    ((StringBuilder)localObject2).append(localIQueueTask.getTaskId());
    ((StringBuilder)localObject2).append(", type:");
    ((StringBuilder)localObject2).append(localIQueueTask.getExactType());
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool2 = true;
    QLog.i((String)localObject1, 1, (String)localObject2);
    localObject1 = AUploadTaskManager.a();
    boolean bool1;
    if (paramMessage.arg1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((AUploadTaskManager)localObject1).a(localIQueueTask, bool1);
    if (paramMessage.arg1 == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localIQueueTask.notifyComplete(bool1);
    i();
    f();
  }
  
  private void g()
  {
    if (AUploadTaskManager.a().c())
    {
      this.d.removeCallbacks(this.j);
      this.d.postDelayed(this.j, 3000L);
      this.d.removeCallbacks(this.h);
      this.d.postDelayed(this.h, 5000L);
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRestore taskList size:");
    localStringBuilder.append(c());
    QLog.i(str, 1, localStringBuilder.toString());
    f();
  }
  
  private void g(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRemoveTask id:");
    localStringBuilder.append(paramMessage.getTaskId());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.getExactType());
    QLog.i(str, 1, localStringBuilder.toString());
    AUploadTaskManager.a().f(paramMessage);
    i();
    f();
  }
  
  private void h()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResetTask task size:");
    localStringBuilder.append(c());
    QLog.i(str, 1, localStringBuilder.toString());
    AUploadTaskManager.a().d();
  }
  
  private boolean h(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return false;
    }
    int m = QCircleConfigHelper.a("QZoneSetting", "ReconnectionTimes", Integer.valueOf(2147483647)).intValue();
    long l = QCircleConfigHelper.a("QZoneSetting", "ReconnectionDays", Integer.valueOf(7)).intValue() * 86400;
    if ((paramIQueueTask.getRetryNum() < m) && (System.currentTimeMillis() - paramIQueueTask.getTimeStamp() < l)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("this task is out of date. task.retryNum = ");
      localStringBuilder.append(paramIQueueTask.getRetryNum());
      localStringBuilder.append(",task.timestamp = ");
      localStringBuilder.append(paramIQueueTask.getTimeStamp());
      QLog.d(str, 1, localStringBuilder.toString());
    }
    return false;
  }
  
  private boolean i()
  {
    return AUploadTaskManager.a().b();
  }
  
  private List<IPublishQueueListener> j()
  {
    Object localObject3;
    synchronized (this.e)
    {
      if (this.e.size() > 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator = this.e.iterator();
        Object localObject1;
        for (;;)
        {
          localObject1 = localArrayList1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (WeakReference)localIterator.next();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = (IPublishQueueListener)((WeakReference)localObject1).get();
          }
          if (localObject1 != null) {
            localArrayList1.add(localObject1);
          }
        }
        return localObject1;
      }
    }
  }
  
  public void a(IPublishQueueListener paramIPublishQueueListener)
  {
    if (paramIPublishQueueListener == null) {
      return;
    }
    synchronized (this.e)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        IPublishQueueListener localIPublishQueueListener = (IPublishQueueListener)((WeakReference)localIterator.next()).get();
        if (localIPublishQueueListener == null) {
          localIterator.remove();
        } else if (localIPublishQueueListener == paramIPublishQueueListener) {
          return;
        }
      }
      this.e.add(new WeakReference(paramIPublishQueueListener));
      return;
    }
    for (;;)
    {
      throw paramIPublishQueueListener;
    }
  }
  
  public void a(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    paramIQueueTask.setTime(System.currentTimeMillis());
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramIQueueTask;
    this.d.sendMessage(localMessage);
  }
  
  public void a(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    localMessage.obj = paramString;
    this.d.sendMessage(localMessage);
  }
  
  public IQueueTask b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return AUploadTaskManager.a().a(paramString);
  }
  
  public void b()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    this.d.sendMessage(localMessage);
  }
  
  public void b(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localMessage.obj = paramIQueueTask;
    this.d.sendMessage(localMessage);
  }
  
  public boolean b(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    if (paramIQueueTask == null) {
      return false;
    }
    String str = QCircleConfigHelper.a("QZoneSetting", "SafetyStrikeCode", "-4015,-4033");
    if (!TextUtils.isEmpty(str))
    {
      Object localObject1 = str.split(",");
      int n = localObject1.length;
      int m = 0;
      while (m < n)
      {
        Object localObject2 = localObject1[m];
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(String.valueOf(paramIQueueTask.getResultCode()))))
        {
          if (paramBoolean) {
            f();
          }
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("this task is beSafetyStriked(). task.mResultCode = ");
          ((StringBuilder)localObject2).append(paramIQueueTask.getResultCode());
          ((StringBuilder)localObject2).append(",errorCode = ");
          ((StringBuilder)localObject2).append(str);
          QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
  
  public int c()
  {
    return AUploadTaskManager.a().g();
  }
  
  public boolean c(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return false;
    }
    boolean bool1 = f(paramIQueueTask);
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (paramIQueueTask.getState() != 2)
      {
        bool1 = bool2;
        if (paramIQueueTask.getState() != 0)
        {
          bool1 = bool2;
          if (paramIQueueTask.getState() != 5) {
            if (paramIQueueTask.getState() == 6)
            {
              bool1 = bool2;
            }
            else if (paramIQueueTask.cancel())
            {
              bool1 = bool2;
            }
            else
            {
              QLog.i(a, 1, "removeTask cancel fail");
              return false;
            }
          }
        }
      }
    }
    else
    {
      bool1 = false;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = paramIQueueTask;
    this.d.sendMessage(localMessage);
    return bool1;
  }
  
  public void d(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.obj = paramIQueueTask;
    this.d.sendMessage(localMessage);
  }
  
  public boolean d()
  {
    return AUploadTaskManager.a().i();
  }
  
  public CopyOnWriteArrayList<IQueueTask> e()
  {
    long l = System.currentTimeMillis();
    CopyOnWriteArrayList localCopyOnWriteArrayList = AUploadTaskManager.a().e();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTaskList timeCost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.d(str, 1, localStringBuilder.toString());
    return localCopyOnWriteArrayList;
  }
  
  public void e(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramIQueueTask;
    this.d.sendMessage(localMessage);
  }
  
  public void f()
  {
    Object localObject = j();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublishQueueListener localIPublishQueueListener = (IPublishQueueListener)((Iterator)localObject).next();
        if (localIPublishQueueListener != null) {
          localIPublishQueueListener.onQueueChanged();
        }
      }
    }
    SimpleEventBus.getInstance().dispatchEvent(new DraftDataChangeEvent(3));
  }
  
  public boolean f(IQueueTask paramIQueueTask)
  {
    return AUploadTaskManager.a().g(paramIQueueTask);
  }
  
  public void g(IQueueTask paramIQueueTask)
  {
    Object localObject = j();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublishQueueListener localIPublishQueueListener = (IPublishQueueListener)((Iterator)localObject).next();
        if (localIPublishQueueListener != null) {
          localIPublishQueueListener.onProgressChanged(paramIQueueTask);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 9: 
      e(paramMessage);
      break;
    case 8: 
      b(paramMessage);
      break;
    case 7: 
      h();
      break;
    case 6: 
      f(paramMessage);
      break;
    case 5: 
      g();
      break;
    case 4: 
      g(paramMessage);
      break;
    case 3: 
      c(paramMessage);
      break;
    case 2: 
      d(paramMessage);
      break;
    case 1: 
      a(paramMessage);
    }
    return false;
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b = false;
      this.g = false;
      this.d.removeCallbacks(this.i);
      this.d.postDelayed(this.i, 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue
 * JD-Core Version:    0.7.0.1
 */