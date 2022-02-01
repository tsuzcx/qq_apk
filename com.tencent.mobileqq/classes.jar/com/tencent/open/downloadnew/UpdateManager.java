package com.tencent.open.downloadnew;

import android.content.Context;
import android.os.Environment;
import com.tencent.apkupdate.ApkUpdateListener;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.ApkUpdateSDK;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class UpdateManager
  implements ApkUpdateListener
{
  protected static UpdateManager a;
  protected static final String b = "com.tencent.open.downloadnew.UpdateManager";
  protected ConcurrentLinkedQueue<UpdateManager.OnCheckUpdateListener> c = new ConcurrentLinkedQueue();
  
  protected UpdateManager()
  {
    ApkUpdateSDK.getInstance().init(CommonDataAdapter.a().b());
    ApkUpdateSDK.getInstance().addListener(this);
  }
  
  public static boolean a()
  {
    try
    {
      UpdateManager localUpdateManager = a;
      boolean bool;
      if (localUpdateManager != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static UpdateManager b()
  {
    try
    {
      if (a == null) {
        a = new UpdateManager();
      }
      UpdateManager localUpdateManager = a;
      return localUpdateManager;
    }
    finally {}
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = paramDownloadInfo.e;
    Object localObject3 = paramDownloadInfo.q;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject1).append(DownloadManager.a);
      ((StringBuilder)localObject1).append("newApkDir");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = CommonDataAdapter.a().b().getFilesDir().getAbsolutePath();
    }
    Object localObject4 = new File((String)localObject1);
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdirs();
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append("/");
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append(".newGen.apk");
    Object localObject1 = ((StringBuilder)localObject4).toString();
    localObject4 = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("patchNewApk>>>>>packageName=");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(", patchPath=");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append(", newApkPath=");
    localStringBuilder.append((String)localObject1);
    LogUtility.b((String)localObject4, localStringBuilder.toString());
    int i = ApkUpdateSDK.getInstance().patchNewApk((String)localObject2, (String)localObject3, (String)localObject1);
    if (i == 0)
    {
      LogUtility.b(b, HardCodeUtil.a(2131913144));
      paramDownloadInfo.q = ((String)localObject1);
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (ConfigHandler.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.w = false;
      }
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (DownloadManager.b().l()))
      {
        paramDownloadInfo.D = DownloadManager.b().h(paramDownloadInfo);
        if (paramDownloadInfo.D != 0)
        {
          LogUtility.d(b, "updateManager patchNewApk write code fail......");
          paramDownloadInfo.a(-2);
          DownloadManager.b().f(paramDownloadInfo);
          DownloadManager.b().a(paramDownloadInfo, paramDownloadInfo.D, null);
          return;
        }
        paramDownloadInfo.a(4);
        DownloadManager.b().f(paramDownloadInfo);
        localObject2 = b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("info.path = ");
        ((StringBuilder)localObject3).append(paramDownloadInfo.q);
        LogUtility.c((String)localObject2, ((StringBuilder)localObject3).toString());
        DownloadManager.b().a(4, paramDownloadInfo);
        if (paramDownloadInfo.w) {
          DownloadManager.b().d(paramDownloadInfo);
        }
        StaticAnalyz.a("300", paramDownloadInfo.h, paramDownloadInfo.c, paramDownloadInfo.F);
        ThreadManager.getSubThreadHandler().post(new UpdateManager.1(this, (String)localObject1, paramDownloadInfo));
        return;
      }
      ThreadManager.getSubThreadHandler().post(new UpdateManager.2(this, (String)localObject1, paramDownloadInfo));
      return;
    }
    localObject1 = b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913145));
    ((StringBuilder)localObject2).append(i);
    LogUtility.e((String)localObject1, ((StringBuilder)localObject2).toString());
    DownloadManager.b().a(-24, paramDownloadInfo);
  }
  
  public void a(UpdateManager.OnCheckUpdateListener paramOnCheckUpdateListener)
  {
    try
    {
      this.c.add(paramOnCheckUpdateListener);
      return;
    }
    finally
    {
      paramOnCheckUpdateListener = finally;
      throw paramOnCheckUpdateListener;
    }
  }
  
  public void a(List<String> paramList)
  {
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkUpdate>>> list size:");
    localStringBuilder.append(paramList.size());
    LogUtility.b(str, localStringBuilder.toString());
    ApkUpdateSDK.getInstance().checkUpdate(paramList);
  }
  
  public void b(UpdateManager.OnCheckUpdateListener paramOnCheckUpdateListener)
  {
    try
    {
      this.c.remove(paramOnCheckUpdateListener);
      return;
    }
    finally
    {
      paramOnCheckUpdateListener = finally;
      throw paramOnCheckUpdateListener;
    }
  }
  
  public void b(List<ApkUpdateParam> paramList)
  {
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkUpdate>>> list size:");
    localStringBuilder.append(paramList.size());
    LogUtility.b(str, localStringBuilder.toString());
    ApkUpdateSDK.getInstance().checkUpdateList(paramList);
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 32	com/tencent/apkupdate/ApkUpdateSDK:getInstance	()Lcom/tencent/apkupdate/ApkUpdateSDK;
    //   5: aload_0
    //   6: invokevirtual 272	com/tencent/apkupdate/ApkUpdateSDK:removeListener	(Lcom/tencent/apkupdate/ApkUpdateListener;)V
    //   9: invokestatic 32	com/tencent/apkupdate/ApkUpdateSDK:getInstance	()Lcom/tencent/apkupdate/ApkUpdateSDK;
    //   12: invokevirtual 275	com/tencent/apkupdate/ApkUpdateSDK:destory	()V
    //   15: goto +18 -> 33
    //   18: astore_1
    //   19: goto +33 -> 52
    //   22: astore_1
    //   23: getstatic 121	com/tencent/open/downloadnew/UpdateManager:b	Ljava/lang/String;
    //   26: ldc_w 277
    //   29: aload_1
    //   30: invokestatic 280	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   33: ldc 2
    //   35: monitorenter
    //   36: aconst_null
    //   37: putstatic 51	com/tencent/open/downloadnew/UpdateManager:a	Lcom/tencent/open/downloadnew/UpdateManager;
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	UpdateManager
    //   18	1	1	localObject1	Object
    //   22	8	1	localException	java.lang.Exception
    //   46	9	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
    //   23	33	18	finally
    //   33	36	18	finally
    //   50	52	18	finally
    //   2	15	22	java/lang/Exception
    //   36	43	46	finally
    //   47	50	46	finally
  }
  
  public void onCheckUpdateFailed(String paramString)
  {
    Object localObject = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCheckUpdateFailed>>>errMsg=");
    localStringBuilder.append(paramString);
    LogUtility.c((String)localObject, localStringBuilder.toString());
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UpdateManager.OnCheckUpdateListener)((Iterator)localObject).next()).a(paramString);
    }
  }
  
  public void onCheckUpdateSucceed(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((UpdateManager.OnCheckUpdateListener)localIterator.next()).a(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager
 * JD-Core Version:    0.7.0.1
 */