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
  protected static final String a = "com.tencent.open.downloadnew.UpdateManager";
  protected ConcurrentLinkedQueue<UpdateManager.OnCheckUpdateListener> a;
  
  protected UpdateManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    ApkUpdateSDK.getInstance().init(CommonDataAdapter.a().a());
    ApkUpdateSDK.getInstance().addListener(this);
  }
  
  public static UpdateManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager = new UpdateManager();
      }
      UpdateManager localUpdateManager = jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager;
      return localUpdateManager;
    }
    finally {}
  }
  
  public static boolean a()
  {
    try
    {
      UpdateManager localUpdateManager = jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager;
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
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 30	com/tencent/apkupdate/ApkUpdateSDK:getInstance	()Lcom/tencent/apkupdate/ApkUpdateSDK;
    //   5: aload_0
    //   6: invokevirtual 56	com/tencent/apkupdate/ApkUpdateSDK:removeListener	(Lcom/tencent/apkupdate/ApkUpdateListener;)V
    //   9: invokestatic 30	com/tencent/apkupdate/ApkUpdateSDK:getInstance	()Lcom/tencent/apkupdate/ApkUpdateSDK;
    //   12: invokevirtual 59	com/tencent/apkupdate/ApkUpdateSDK:destory	()V
    //   15: goto +17 -> 32
    //   18: astore_1
    //   19: goto +32 -> 51
    //   22: astore_1
    //   23: getstatic 61	com/tencent/open/downloadnew/UpdateManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: ldc 63
    //   28: aload_1
    //   29: invokestatic 68	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   32: ldc 2
    //   34: monitorenter
    //   35: aconst_null
    //   36: putstatic 49	com/tencent/open/downloadnew/UpdateManager:jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager	Lcom/tencent/open/downloadnew/UpdateManager;
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	UpdateManager
    //   18	1	1	localObject1	Object
    //   22	7	1	localException	java.lang.Exception
    //   45	9	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
    //   23	32	18	finally
    //   32	35	18	finally
    //   49	51	18	finally
    //   2	15	22	java/lang/Exception
    //   35	42	45	finally
    //   46	49	45	finally
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = paramDownloadInfo.e;
    Object localObject3 = paramDownloadInfo.l;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject1).append(DownloadManager.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("newApkDir");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = CommonDataAdapter.a().a().getFilesDir().getAbsolutePath();
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
    localObject4 = jdField_a_of_type_JavaLangString;
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
      LogUtility.b(jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131715676));
      paramDownloadInfo.l = ((String)localObject1);
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (ConfigHandler.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.a = false;
      }
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (DownloadManager.a().b()))
      {
        paramDownloadInfo.j = DownloadManager.a().a(paramDownloadInfo);
        if (paramDownloadInfo.j != 0)
        {
          LogUtility.d(jdField_a_of_type_JavaLangString, "updateManager patchNewApk write code fail......");
          paramDownloadInfo.a(-2);
          DownloadManager.a().e(paramDownloadInfo);
          DownloadManager.a().a(paramDownloadInfo, paramDownloadInfo.j, null);
          return;
        }
        paramDownloadInfo.a(4);
        DownloadManager.a().e(paramDownloadInfo);
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("info.path = ");
        ((StringBuilder)localObject3).append(paramDownloadInfo.l);
        LogUtility.c((String)localObject2, ((StringBuilder)localObject3).toString());
        DownloadManager.a().a(4, paramDownloadInfo);
        if (paramDownloadInfo.a) {
          DownloadManager.a().c(paramDownloadInfo);
        }
        StaticAnalyz.a("300", paramDownloadInfo.h, paramDownloadInfo.c, paramDownloadInfo.o);
        ThreadManager.getSubThreadHandler().post(new UpdateManager.1(this, (String)localObject1, paramDownloadInfo));
        return;
      }
      ThreadManager.getSubThreadHandler().post(new UpdateManager.2(this, (String)localObject1, paramDownloadInfo));
      return;
    }
    localObject1 = jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715677));
    ((StringBuilder)localObject2).append(i);
    LogUtility.e((String)localObject1, ((StringBuilder)localObject2).toString());
    DownloadManager.a().a(-24, paramDownloadInfo);
  }
  
  public void a(UpdateManager.OnCheckUpdateListener paramOnCheckUpdateListener)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramOnCheckUpdateListener);
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
    String str = jdField_a_of_type_JavaLangString;
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramOnCheckUpdateListener);
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
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkUpdate>>> list size:");
    localStringBuilder.append(paramList.size());
    LogUtility.b(str, localStringBuilder.toString());
    ApkUpdateSDK.getInstance().checkUpdateList(paramList);
  }
  
  public void onCheckUpdateFailed(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCheckUpdateFailed>>>errMsg=");
    localStringBuilder.append(paramString);
    LogUtility.c((String)localObject, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UpdateManager.OnCheckUpdateListener)((Iterator)localObject).next()).a(paramString);
    }
  }
  
  public void onCheckUpdateSucceed(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((UpdateManager.OnCheckUpdateListener)localIterator.next()).a(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager
 * JD-Core Version:    0.7.0.1
 */