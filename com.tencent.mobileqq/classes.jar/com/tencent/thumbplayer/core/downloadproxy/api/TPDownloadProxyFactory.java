package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;

public class TPDownloadProxyFactory
{
  private static final String FILE_NAME = "TPDownloadProxyFactory";
  private static TPDownloadProxyFactoryAidl downloadProxyFactoryAidl;
  private static TPDLProxyBindServiceCallback mCallback = null;
  private static boolean mCanUseAIDL;
  private static ServiceConnection mConnection = new TPDownloadProxyFactory.1();
  private static boolean mIsReadyForDownload;
  private static Object mMapObject = new Object();
  private static boolean mUseService;
  private static HashMap<Integer, TPDownloadProxyClient> mvTPDownloadProxyClientMap;
  private static HashMap<Integer, ITPDownloadProxy> mvTPDownloadProxyMap = new HashMap();
  
  static
  {
    mvTPDownloadProxyClientMap = new HashMap();
    mUseService = false;
    mCanUseAIDL = false;
    mIsReadyForDownload = false;
  }
  
  public static boolean canUseService()
  {
    try
    {
      boolean bool = mUseService;
      if (!bool) {
        return true;
      }
      bool = mCanUseAIDL;
      if (!bool) {
        return false;
      }
      TPDownloadProxyFactoryAidl localTPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
      if (localTPDownloadProxyFactoryAidl != null) {
        try
        {
          downloadProxyFactoryAidl.isReadyForPlay();
          return true;
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("canUseService failed, error:");
          localStringBuilder.append(localThrowable.toString());
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", localStringBuilder.toString());
        }
      }
      return false;
    }
    finally {}
  }
  
  public static boolean ensurePlayManagerService(TPDLProxyBindServiceCallback paramTPDLProxyBindServiceCallback)
  {
    Object localObject = TPDownloadProxyHelper.getContext();
    if (localObject == null)
    {
      TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "ensurePlayManagerService get context null!");
      return false;
    }
    mCallback = paramTPDLProxyBindServiceCallback;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ensurePlayManagerService ");
    if (localObject == null) {
      paramTPDLProxyBindServiceCallback = "context is null";
    } else {
      paramTPDLProxyBindServiceCallback = "ok";
    }
    localStringBuilder.append(paramTPDLProxyBindServiceCallback);
    TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", localStringBuilder.toString());
    try
    {
      paramTPDLProxyBindServiceCallback = new Intent((Context)localObject, TPDownloadProxyService.class);
      ((Context)localObject).startService(paramTPDLProxyBindServiceCallback);
      if (!((Context)localObject).bindService(paramTPDLProxyBindServiceCallback, mConnection, 1)) {
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "ensurePlayManagerService bind service failed!");
      }
      return true;
    }
    catch (Throwable paramTPDLProxyBindServiceCallback)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ensurePlayManagerService failed, error:");
      ((StringBuilder)localObject).append(paramTPDLProxyBindServiceCallback.toString());
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public static boolean getCanUseAIDL()
  {
    try
    {
      boolean bool = mCanUseAIDL;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getNativeVersion()
  {
    if (!mUseService) {
      return TPDownloadProxyNative.getInstance().getNativeVersion();
    }
    if (!mCanUseAIDL) {
      return TPDownloadProxyNative.getInstance().getNativeVersion();
    }
    Object localObject = downloadProxyFactoryAidl;
    if (localObject != null) {
      try
      {
        localObject = ((TPDownloadProxyFactoryAidl)localObject).getNativeVersion();
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNativeVersion failed, error:");
        localStringBuilder.append(localThrowable.toString());
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", localStringBuilder.toString());
      }
    }
    return TPDownloadProxyNative.getInstance().getNativeVersion();
  }
  
  public static ITPDownloadProxy getTPDownloadProxy(int paramInt)
  {
    Object localObject1;
    if (paramInt <= 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTPDownloadProxy is invalid, serviceType:");
      ((StringBuilder)localObject1).append(paramInt);
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", ((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject4;
    if (mUseService)
    {
      if (mCanUseAIDL) {
        try
        {
          localObject1 = getTPDownloadProxyService(paramInt);
          return localObject1;
        }
        catch (Throwable localThrowable)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getTPDownloadProxy failed, error:");
          ((StringBuilder)localObject4).append(localThrowable.toString());
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", ((StringBuilder)localObject4).toString());
          return null;
        }
      }
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy failed, can't use aidl!");
      return null;
    }
    synchronized (mMapObject)
    {
      localObject4 = (ITPDownloadProxy)mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
      Object localObject2 = localObject4;
      if (localObject4 == null)
      {
        localObject2 = new TPDownloadProxy(paramInt);
        mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject2);
      }
      return localObject2;
    }
  }
  
  private static ITPDownloadProxy getTPDownloadProxyService(int paramInt)
  {
    try
    {
      if (downloadProxyFactoryAidl != null) {
        synchronized (mvTPDownloadProxyClientMap)
        {
          TPDownloadProxyClient localTPDownloadProxyClient3 = (TPDownloadProxyClient)mvTPDownloadProxyClientMap.get(Integer.valueOf(paramInt));
          TPDownloadProxyClient localTPDownloadProxyClient1 = localTPDownloadProxyClient3;
          TPDownloadProxyClient localTPDownloadProxyClient2;
          if (localTPDownloadProxyClient3 == null) {
            try
            {
              localTPDownloadProxyClient1 = new TPDownloadProxyClient(downloadProxyFactoryAidl.getTPDownloadProxy(paramInt));
            }
            catch (Throwable localThrowable)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getTPDownloadProxyService failed, error:");
              localStringBuilder.append(localThrowable.toString());
              TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", localStringBuilder.toString());
              localTPDownloadProxyClient2 = localTPDownloadProxyClient3;
            }
          }
          mvTPDownloadProxyClientMap.put(Integer.valueOf(paramInt), localTPDownloadProxyClient2);
          return localTPDownloadProxyClient2;
        }
      }
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxyService failed, aidl is null!");
      return null;
    }
    finally {}
  }
  
  public static boolean getUseService()
  {
    return mUseService;
  }
  
  public static boolean isReadyForDownload()
  {
    try
    {
      boolean bool1 = mUseService;
      boolean bool2 = false;
      if (!bool1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isReadyForDownload ret:");
        ((StringBuilder)localObject1).append(mIsReadyForDownload);
        TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", ((StringBuilder)localObject1).toString());
        bool1 = mIsReadyForDownload;
        return bool1;
      }
      bool1 = mCanUseAIDL;
      if (!bool1) {
        return false;
      }
      Object localObject1 = downloadProxyFactoryAidl;
      bool1 = bool2;
      if (localObject1 != null) {
        try
        {
          bool1 = downloadProxyFactoryAidl.isReadyForDownload();
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isReadyForDownload failed, error:");
          localStringBuilder.append(localThrowable.toString());
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", localStringBuilder.toString());
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean isReadyForPlay()
  {
    try
    {
      boolean bool1 = mUseService;
      boolean bool2 = false;
      if (!bool1)
      {
        bool1 = TPDownloadProxyNative.getInstance().isReadyForWork();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isReadyForPlay ret:");
        ((StringBuilder)localObject1).append(bool1);
        TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", ((StringBuilder)localObject1).toString());
        return bool1;
      }
      bool1 = mCanUseAIDL;
      if (!bool1) {
        return false;
      }
      Object localObject1 = downloadProxyFactoryAidl;
      bool1 = bool2;
      if (localObject1 != null) {
        try
        {
          bool1 = downloadProxyFactoryAidl.isReadyForPlay();
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isReadyForPlay failed, error:");
          localStringBuilder.append(localThrowable.toString());
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", localStringBuilder.toString());
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  private static void setCanUseAIDL(boolean paramBoolean)
  {
    try
    {
      mCanUseAIDL = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setReadyForDownload(boolean paramBoolean)
  {
    try
    {
      mIsReadyForDownload = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setUseService(boolean paramBoolean)
  {
    mUseService = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory
 * JD-Core Version:    0.7.0.1
 */