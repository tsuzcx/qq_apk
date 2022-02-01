package com.tencent.mobileqq.qrscan.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qrscan.IQRScanIPCConst;
import com.tencent.mobileqq.qrscan.IQRScanIPCConst.IMiniResDownloadCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;

public class QRScanSubQIPCModule
  extends QIPCModule
  implements IQRScanIPCConst
{
  public static volatile boolean a = false;
  private static volatile QRScanSubQIPCModule b;
  private WeakReference<IQRScanIPCConst.IMiniResDownloadCallback> c;
  
  public QRScanSubQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QRScanSubQIPCModule a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QRScanSubQIPCModule("QRScanSubQIPCModule");
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_res_type", paramInt);
    localBundle.putString("key_call_proc", BaseApplication.processName);
    QLog.d("MiniRecog.QRScanSubQIPCModule", 1, String.format("downloadQRScanRes resType=%d proc=%s", new Object[] { Integer.valueOf(paramInt), BaseApplication.processName }));
    QIPCClientHelper.getInstance().callServer("QRScanMainQIPCModule", "action_call_download_res", localBundle, new QRScanSubQIPCModule.1(this));
  }
  
  public void a(IQRScanIPCConst.IMiniResDownloadCallback paramIMiniResDownloadCallback)
  {
    if (paramIMiniResDownloadCallback == null)
    {
      this.c = null;
      return;
    }
    this.c = new WeakReference(paramIMiniResDownloadCallback);
  }
  
  public void b()
  {
    try
    {
      boolean bool = a;
      if (!bool) {
        try
        {
          QIPCClientHelper.getInstance().register(this);
          a = true;
        }
        catch (Exception localException)
        {
          QLog.d("MiniRecog.QRScanSubQIPCModule", 1, "register", localException);
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 80	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   5: invokevirtual 117	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   8: ifnull +34 -> 42
    //   11: invokestatic 80	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   14: invokevirtual 117	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   17: aload_0
    //   18: invokevirtual 123	eipc/EIPCClient:unRegisterModule	(Leipc/EIPCModule;)V
    //   21: iconst_0
    //   22: putstatic 105	com/tencent/mobileqq/qrscan/ipc/QRScanSubQIPCModule:a	Z
    //   25: goto +17 -> 42
    //   28: astore_1
    //   29: goto +16 -> 45
    //   32: astore_1
    //   33: ldc 52
    //   35: iconst_1
    //   36: ldc 125
    //   38: aload_1
    //   39: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	QRScanSubQIPCModule
    //   28	1	1	localObject	Object
    //   32	16	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	25	28	finally
    //   33	42	28	finally
    //   2	25	32	java/lang/Exception
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (IQRScanIPCConst.IMiniResDownloadCallback)((WeakReference)localObject).get();
    }
    if ("action_notify_download_process".equalsIgnoreCase(paramString))
    {
      paramInt = paramBundle.getInt("key_res_type", -1);
      int i = paramBundle.getInt("key_download_progress", 0);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.QRScanSubQIPCModule", 2, String.format("onCall_%s resType=%d progress=%d", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i) }));
      }
      if (localObject != null)
      {
        ((IQRScanIPCConst.IMiniResDownloadCallback)localObject).a(paramInt, i);
        return null;
      }
    }
    else if ("action_notify_download_result".equalsIgnoreCase(paramString))
    {
      paramInt = paramBundle.getInt("key_res_type", -1);
      boolean bool = paramBundle.getBoolean("key_download_result", false);
      QLog.d("MiniRecog.QRScanSubQIPCModule", 1, String.format("onCall_%s resType=%d suc=%b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
      if (localObject != null) {
        ((IQRScanIPCConst.IMiniResDownloadCallback)localObject).a(paramInt, bool);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanSubQIPCModule
 * JD-Core Version:    0.7.0.1
 */