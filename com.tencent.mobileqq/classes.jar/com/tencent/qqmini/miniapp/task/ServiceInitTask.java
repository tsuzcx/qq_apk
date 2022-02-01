package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;

@ClassTag(tag="ServiceInitTask")
public class ServiceInitTask
  extends AsyncTask
{
  public static final String TAG = "ServiceInitTask";
  protected BaseAppBrandRuntime appBrandRuntime;
  protected AbsAppBrandService customJsService;
  
  public ServiceInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeAsync()
  {
    Object localObject2 = null;
    Object localObject1;
    label48:
    ServiceCreateTask localServiceCreateTask;
    BaselibLoader.BaselibContent localBaselibContent;
    if (this.appBrandRuntime != null)
    {
      localObject1 = this.appBrandRuntime.getMiniAppInfo();
      MiniReportManager.reportEventType((MiniAppInfo)localObject1, 14, "0");
      localObject1 = (RuntimeCreateTask)getRuntimeLoader().getTask(RuntimeCreateTask.class);
      if (localObject1 == null) {
        break label157;
      }
      localObject1 = ((RuntimeCreateTask)localObject1).getAppBrandRuntime();
      this.appBrandRuntime = ((BaseAppBrandRuntime)localObject1);
      localServiceCreateTask = (ServiceCreateTask)getRuntimeLoader().getTask(ServiceCreateTask.class);
      localBaselibContent = ((BaselibLoadAsyncTask)getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent();
      localObject1 = localObject2;
      if (localServiceCreateTask != null) {
        localObject1 = localServiceCreateTask.getJsService();
      }
      if (localServiceCreateTask == null) {
        break label162;
      }
    }
    label157:
    label162:
    for (long l = localServiceCreateTask.getCreateTime();; l = 0L)
    {
      if (localObject1 == null) {
        break label167;
      }
      if (this.appBrandRuntime != null) {
        ((AbsAppBrandService)localObject1).setAppBrandEventInterface(this.appBrandRuntime.getEventListener());
      }
      ((AbsAppBrandService)localObject1).addStateChangeListener(new ServiceInitTask.1(this, (AbsAppBrandService)localObject1, l));
      ((AbsAppBrandService)localObject1).initBaseJs(localBaselibContent);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label48;
    }
    label167:
    onTaskFailed();
  }
  
  public AbsAppBrandService getJsService()
  {
    return this.customJsService;
  }
  
  /* Error */
  protected void onServiceInitSucc(AbsAppBrandService paramAbsAppBrandService, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	com/tencent/qqmini/miniapp/task/ServiceInitTask:customJsService	Lcom/tencent/qqmini/miniapp/core/service/AbsAppBrandService;
    //   6: ifnonnull +140 -> 146
    //   9: aload_1
    //   10: ifnull +136 -> 146
    //   13: aload_0
    //   14: aload_1
    //   15: putfield 97	com/tencent/qqmini/miniapp/task/ServiceInitTask:customJsService	Lcom/tencent/qqmini/miniapp/core/service/AbsAppBrandService;
    //   18: aload_0
    //   19: invokevirtual 102	com/tencent/qqmini/miniapp/task/ServiceInitTask:onTaskSucceed	()V
    //   22: new 104	java/util/Properties
    //   25: dup
    //   26: invokespecial 106	java/util/Properties:<init>	()V
    //   29: astore 6
    //   31: aload_1
    //   32: instanceof 108
    //   35: ifeq +114 -> 149
    //   38: aload 6
    //   40: ldc 110
    //   42: ldc 112
    //   44: invokevirtual 116	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload 6
    //   50: ldc 118
    //   52: lload_2
    //   53: invokestatic 124	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   56: invokevirtual 116	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: pop
    //   60: aload 6
    //   62: ldc 126
    //   64: lload 4
    //   66: invokestatic 124	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: invokevirtual 116	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: aload 6
    //   75: ldc 128
    //   77: ldc 130
    //   79: invokevirtual 116	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   82: pop
    //   83: ldc 10
    //   85: new 132	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   92: aload_1
    //   93: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: ldc 139
    //   98: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: lload_2
    //   102: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: ldc 147
    //   107: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: lload 4
    //   112: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   115: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 157	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: aload_0
    //   123: getfield 23	com/tencent/qqmini/miniapp/task/ServiceInitTask:appBrandRuntime	Lcom/tencent/qqmini/miniapp/core/BaseAppBrandRuntime;
    //   126: bipush 50
    //   128: new 159	com/tencent/qqmini/sdk/launcher/model/MtaReportSt
    //   131: dup
    //   132: ldc 161
    //   134: aload 6
    //   136: invokespecial 164	com/tencent/qqmini/sdk/launcher/model/MtaReportSt:<init>	(Ljava/lang/String;Ljava/util/Properties;)V
    //   139: invokestatic 170	com/tencent/qqmini/sdk/action/AppStateEvent:obtain	(ILjava/lang/Object;)Lcom/tencent/qqmini/sdk/action/AppStateEvent;
    //   142: invokevirtual 174	com/tencent/qqmini/miniapp/core/BaseAppBrandRuntime:performAction	(Lcom/tencent/qqmini/sdk/launcher/core/action/Action;)Ljava/lang/Object;
    //   145: pop
    //   146: aload_0
    //   147: monitorexit
    //   148: return
    //   149: aload 6
    //   151: ldc 110
    //   153: ldc 176
    //   155: invokevirtual 116	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: goto -111 -> 48
    //   162: astore_1
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	ServiceInitTask
    //   0	167	1	paramAbsAppBrandService	AbsAppBrandService
    //   0	167	2	paramLong1	long
    //   0	167	4	paramLong2	long
    //   29	121	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   2	9	162	finally
    //   13	48	162	finally
    //   48	146	162	finally
    //   149	159	162	finally
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    if (this.appBrandRuntime != null) {}
    for (MiniAppInfo localMiniAppInfo = this.appBrandRuntime.getMiniAppInfo();; localMiniAppInfo = null)
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 15, "0");
      return;
    }
  }
  
  public void reset()
  {
    super.reset();
    this.customJsService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ServiceInitTask
 * JD-Core Version:    0.7.0.1
 */