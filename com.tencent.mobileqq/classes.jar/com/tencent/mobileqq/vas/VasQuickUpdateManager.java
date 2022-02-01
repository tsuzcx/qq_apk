package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

@Deprecated
public class VasQuickUpdateManager
  implements Manager
{
  private static final String TAG = "VasQuickUpdateManager";
  public QQAppInterface app = null;
  ConcurrentHashMap<Integer, CallBacker> callBackers = new ConcurrentHashMap();
  private BaseUpdateCallback defaultCallback = new VasQuickUpdateManager.DefaultUpdateCallback(this);
  private IVasEngine mEngineProxy;
  AtomicInteger mKey = new AtomicInteger(0);
  public IApolloExtensionObserver mQuickUpdateObserver = new VasQuickUpdateManager.DefaultVasExtensionObserver(this);
  
  public VasQuickUpdateManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    initEngine();
    paramQQAppInterface.addObserver(this.mQuickUpdateObserver, true);
  }
  
  /* Error */
  public static void cleanCache()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 76	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: ldc 78
    //   13: invokestatic 82	com/tencent/mobileqq/vas/VasQuickUpdateManager:deleteJSON	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokestatic 88	com/tencent/mobileqq/theme/ThemeCleaner:a	(Landroid/content/Context;)V
    //   20: aload_0
    //   21: invokestatic 92	com/tencent/mobileqq/vas/quickupdate/UpdateCallbackSelector:cleanCache	(Landroid/content/Context;)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: ldc 11
    //   30: iconst_1
    //   31: ldc 94
    //   33: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: goto -12 -> 24
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	15	0	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   39	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	39	finally
    //   11	24	39	finally
    //   28	36	39	finally
  }
  
  public static void deleteJSON(String paramString)
  {
    try
    {
      paramString = new File(BaseApplicationImpl.getApplication().getFilesDir() + File.separator + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void initEngine()
  {
    QLog.e("VasQuickUpdateManager", 1, "initEngine: " + this);
    this.mEngineProxy = ((IVasEngine)this.app.getRuntimeService(IVasEngine.class, ""));
    UpdateCallbackSelector.setDefaultCallback(this.defaultCallback);
    if (this.mEngineProxy != null)
    {
      this.mEngineProxy.setRequestHandler(new VasQuickUpdateManager.1(this));
      this.mEngineProxy.startUpdateAllItem();
    }
  }
  
  public void addCallBacker(CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {}
    while (this.callBackers.containsValue(paramCallBacker)) {
      return;
    }
    int i = this.mKey.addAndGet(1);
    this.callBackers.put(Integer.valueOf(i), paramCallBacker);
    paramCallBacker.key = i;
  }
  
  public void addWeakCallback(CallBacker paramCallBacker)
  {
    Object localObject = this.callBackers.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      CallBacker localCallBacker = (CallBacker)((Iterator)localObject).next();
      if (((localCallBacker instanceof VasQuickUpdateManager.WeakCallbacker)) && (((VasQuickUpdateManager.WeakCallbacker)localCallBacker).isWrapOf(paramCallBacker))) {
        return;
      }
    }
    localObject = new VasQuickUpdateManager.WeakCallbacker(paramCallBacker, this);
    addCallBacker((CallBacker)localObject);
    paramCallBacker.key = ((VasQuickUpdateManager.WeakCallbacker)localObject).key;
  }
  
  public void callBackToAll(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasQuickUpdateManager", 2, "callBackToAll Error bid = " + paramLong + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + ", from = " + paramString3 + ", errorCode = " + paramInt1);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.callBackers.values().iterator();
      while (localIterator.hasNext()) {
        ((CallBacker)localIterator.next()).callback(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "cancelDwonloadItem bid = " + paramLong + " scid = " + paramString);
    }
    if (this.mEngineProxy != null) {
      this.mEngineProxy.cancelDwonloadItem(paramLong, paramString);
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "downloadGatherItem bid = " + paramLong + " scid = " + paramString1 + " scidList = " + TextUtils.join(",", paramArrayOfString) + " from = " + paramString2);
    }
    if (this.mEngineProxy != null) {
      this.mEngineProxy.downloadGatherItem(paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString2);
    }
    if (this.mEngineProxy != null) {
      this.mEngineProxy.downloadItem(paramLong, paramString1, paramString2);
    }
  }
  
  public IVasEngine getVasEngine()
  {
    return this.mEngineProxy;
  }
  
  public void onDestroy()
  {
    QLog.e("VasQuickUpdateManager", 1, "onDestroy: " + this);
    this.app.removeObserver(this.mQuickUpdateObserver);
    UpdateCallbackSelector.unsetDefaultCallback(this.defaultCallback);
    this.callBackers.clear();
    if (this.mEngineProxy != null)
    {
      this.mEngineProxy.onDestroy();
      this.mEngineProxy = null;
    }
  }
  
  public void onProgressToAll(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasQuickUpdateManager", 2, "callBackToAll Error bid = " + paramLong1 + ", cfgScid=" + paramString2 + ",scid = " + paramString1);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.callBackers.values().iterator();
      while (localIterator.hasNext()) {
        ((CallBacker)localIterator.next()).onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      }
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, QueryItemCallback paramQueryItemCallback)
  {
    if (this.mEngineProxy != null)
    {
      paramQueryItemCallback = new VasQuickUpdateManager.TimeoutWrapper(paramQueryItemCallback, paramBoolean2, null);
      if (paramLong > 0L) {
        ThreadManager.getSubThreadHandler().postDelayed(paramQueryItemCallback, paramLong);
      }
      this.mEngineProxy.queryItemVersion(paramInt, paramString, paramBoolean1, paramQueryItemCallback);
      return;
    }
    paramQueryItemCallback.a(2, "", "");
  }
  
  public void removeCallBacker(CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {
      return;
    }
    this.callBackers.remove(Integer.valueOf(paramCallBacker.key));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager
 * JD-Core Version:    0.7.0.1
 */