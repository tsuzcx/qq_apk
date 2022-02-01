package com.tencent.mobileqq.vas;

import androidx.annotation.Keep;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasApolloExtensionHandler;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@Keep
public class VasQuickUpdateEngine
  implements IVasEngine
{
  private static final String TAG = "VasQuickUpdateEngine";
  private static final String TAG_NATIVE = "VasQuickUpdateEngine_Native";
  private static VasQuickUpdateEngine mInstance;
  public IVasApolloExtensionHandler mRequestHandler;
  ArrayList<VasQuickUpdateEngine.PendingTask> pendingTasks = new ArrayList();
  
  public static byte[] alloc(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public static VasQuickUpdateEngine getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new VasQuickUpdateEngine();
      }
      VasQuickUpdateEngine localVasQuickUpdateEngine = mInstance;
      return localVasQuickUpdateEngine;
    }
    finally {}
  }
  
  @Keep
  public static void quickUpdateLog(int paramInt, byte[] paramArrayOfByte)
  {
    do
    {
      do
      {
        do
        {
          try
          {
            paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
            switch (paramInt)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.d("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
              }
              return;
            }
          }
          catch (Throwable paramArrayOfByte)
          {
            QLog.e("VasQuickUpdateEngine_Native", 1, "Couldn't convert the jbyteArray to jstring", paramArrayOfByte);
            return;
          }
          QLog.e("VasQuickUpdateEngine_Native", 1, paramArrayOfByte);
          return;
        } while (!QLog.isColorLevel());
        QLog.w("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString) {}
  
  public void cancelQuery(QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    removePendingTask(new VasQuickUpdateEngine.QueryTask(0, "", false, paramQueryItemVersionCallback));
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "deleteFiles bid = " + paramLong + " scid = " + paramString);
    }
    BaseUpdateCallback localBaseUpdateCallback = UpdateCallbackSelector.getCallback(paramLong);
    return (localBaseUpdateCallback != null) && (localBaseUpdateCallback.deleteFiles(paramLong, paramString));
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " scidList = " + paramArrayOfString + " from = " + paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2) {}
  
  public BaseUpdateBusiness getBusinessCallback(long paramLong)
  {
    return null;
  }
  
  public <T extends IBusinessCallback> T getBusinessCallback(Class<T> paramClass)
  {
    return null;
  }
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("VasQuickUpdateEngine", 1, "onCompleted bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString3 + " dlFrom = " + paramInt1 + " errorCode = " + paramInt2 + " httpCode = " + paramInt3);
    BaseUpdateCallback localBaseUpdateCallback = UpdateCallbackSelector.getCallback(paramLong);
    if (localBaseUpdateCallback != null) {
      localBaseUpdateCallback.onCompleted(paramLong, paramString1, paramString2, paramString3, paramInt2, paramInt3);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2) {}
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "onProgress bid = " + paramLong1 + " scid = " + paramString1 + " cfgScid = " + paramString2 + "dwProgress = " + paramLong2 + " dwProgressMax = " + paramLong3);
    }
    BaseUpdateCallback localBaseUpdateCallback = UpdateCallbackSelector.getCallback(paramLong1);
    if (localBaseUpdateCallback != null) {
      localBaseUpdateCallback.onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, QueryItemVersionCallback paramQueryItemVersionCallback) {}
  
  void removePendingTask(VasQuickUpdateEngine.PendingTask paramPendingTask)
  {
    for (;;)
    {
      int i;
      synchronized (this.pendingTasks)
      {
        i = this.pendingTasks.size() - 1;
        if (i >= 0)
        {
          VasQuickUpdateEngine.PendingTask localPendingTask = (VasQuickUpdateEngine.PendingTask)this.pendingTasks.get(i);
          if ((localPendingTask.getClass() == paramPendingTask.getClass()) && (localPendingTask.equals(paramPendingTask))) {
            this.pendingTasks.remove(i);
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public void setRequestHandler(IVasApolloExtensionHandler paramIVasApolloExtensionHandler)
  {
    this.mRequestHandler = paramIVasApolloExtensionHandler;
  }
  
  public void startUpdateAllItem() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine
 * JD-Core Version:    0.7.0.1
 */