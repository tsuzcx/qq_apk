package com.tencent.mobileqq.vas;

import androidx.annotation.Keep;
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
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label6:
      break label6;
    }
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
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      if ((paramInt != 0) && (paramInt != 1))
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
            }
          }
          else if (QLog.isColorLevel()) {
            QLog.i("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.w("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
        }
      }
      else {
        QLog.e("VasQuickUpdateEngine_Native", 1, paramArrayOfByte);
      }
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("VasQuickUpdateEngine_Native", 1, "Couldn't convert the jbyteArray to jstring", paramArrayOfByte);
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString) {}
  
  public void cancelQuery(QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    removePendingTask(new VasQuickUpdateEngine.QueryTask(0, "", false, paramQueryItemVersionCallback));
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteFiles bid = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" scid = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VasQuickUpdateEngine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = UpdateCallbackSelector.getCallback(paramLong);
    return (localObject != null) && (((QuickUpdateBusinessCallback)localObject).deleteFiles(paramLong, paramString));
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadItem bid = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" scid = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" scidList = ");
      localStringBuilder.append(paramArrayOfString);
      localStringBuilder.append(" from = ");
      localStringBuilder.append(paramString2);
      QLog.d("VasQuickUpdateEngine", 2, localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCompleted bid = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" scid = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" from = ");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" dlFrom = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" errorCode = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" httpCode = ");
    ((StringBuilder)localObject).append(paramInt3);
    QLog.d("VasQuickUpdateEngine", 1, ((StringBuilder)localObject).toString());
    localObject = UpdateCallbackSelector.getCallback(paramLong);
    if (localObject != null) {
      ((QuickUpdateListener)localObject).onCompleted(paramLong, paramString1, paramString2, paramString3, paramInt2, paramInt3);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2) {}
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onProgress bid = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" scid = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" cfgScid = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("dwProgress = ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" dwProgressMax = ");
      ((StringBuilder)localObject).append(paramLong3);
      QLog.d("VasQuickUpdateEngine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = UpdateCallbackSelector.getCallback(paramLong1);
    if (localObject != null) {
      ((QuickUpdateListener)localObject).onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, QueryItemVersionCallback paramQueryItemVersionCallback) {}
  
  void removePendingTask(VasQuickUpdateEngine.PendingTask paramPendingTask)
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
  }
  
  public void setRequestHandler(IVasApolloExtensionHandler paramIVasApolloExtensionHandler)
  {
    this.mRequestHandler = paramIVasApolloExtensionHandler;
  }
  
  public void startUpdateAllItem() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine
 * JD-Core Version:    0.7.0.1
 */