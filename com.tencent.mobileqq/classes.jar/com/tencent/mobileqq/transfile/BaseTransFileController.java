package com.tencent.mobileqq.transfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.RichmediaIpv6ConifgBean;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public abstract class BaseTransFileController
  implements INetEngineListener
{
  public static final String TAG = "Q.richmedia.TransFileController";
  public AppInterface app;
  public int count;
  public BaseTransFileController.ProcHandler mHandler = null;
  public RichmediaIpv6ConifgBean mRichmediaIpv6ConifgBean;
  protected AtomicBoolean mWorking = new AtomicBoolean(true);
  public ConcurrentHashMap<String, IHttpCommunicatorListener> processorMap = new ConcurrentHashMap(20);
  public long startTime;
  
  public BaseTransFileController() {}
  
  public BaseTransFileController(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("construct transfilecontroller:");
      localStringBuilder.append(this);
      QLog.d("Q.richmedia.TransFileController", 2, localStringBuilder.toString());
    }
    this.app = ((AppInterface)paramAppRuntime);
    this.mHandler = new BaseTransFileController.ProcHandler(this, ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new BaseTransFileController.1(this));
  }
  
  public static String getProperty(String paramString)
  {
    try
    {
      paramString = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(paramString, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String makeKey(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String makeReceiveKey(TransferRequest paramTransferRequest)
  {
    return makeReceiveKey(paramTransferRequest.mMd5, paramTransferRequest.mServerPath, paramTransferRequest.mFileType);
  }
  
  public static String makeReceiveKey(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1)))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_");
      paramString2.append(paramInt);
      return paramString2.toString();
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append("_");
    paramString1.append(paramInt);
    return paramString1.toString();
  }
  
  public static void setProperty(String paramString1, String paramString2)
  {
    try
    {
      PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putString(paramString1, paramString2).commit();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void addHandle(TransProcessorHandler paramTransProcessorHandler)
  {
    BaseTransProcessor.addHandler(paramTransProcessorHandler);
  }
  
  public void addProcessor(String paramString, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    this.processorMap.put(paramString, paramIHttpCommunicatorListener);
  }
  
  public boolean containsProcessor(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramLong);
    paramString = localStringBuilder.toString();
    if (!this.processorMap.isEmpty()) {
      return this.processorMap.containsKey(paramString);
    }
    return false;
  }
  
  protected void fillTransRequestMessage(BaseTransProcessor paramBaseTransProcessor) {}
  
  public IHttpCommunicatorListener findProcessor(String paramString)
  {
    if (!this.processorMap.isEmpty()) {
      return (IHttpCommunicatorListener)this.processorMap.get(paramString);
    }
    return null;
  }
  
  public IHttpCommunicatorListener findProcessor(String paramString, long paramLong)
  {
    if (!this.processorMap.isEmpty())
    {
      ConcurrentHashMap localConcurrentHashMap = this.processorMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramLong);
      return (IHttpCommunicatorListener)localConcurrentHashMap.get(localStringBuilder.toString());
    }
    return null;
  }
  
  protected Set<String> getKeySetClone(ConcurrentHashMap<String, IHttpCommunicatorListener> paramConcurrentHashMap)
  {
    HashSet localHashSet = new HashSet();
    if (paramConcurrentHashMap != null) {
      paramConcurrentHashMap = paramConcurrentHashMap.keySet();
    } else {
      paramConcurrentHashMap = null;
    }
    if (paramConcurrentHashMap != null)
    {
      paramConcurrentHashMap = paramConcurrentHashMap.iterator();
      while (paramConcurrentHashMap.hasNext()) {
        localHashSet.add((String)paramConcurrentHashMap.next());
      }
    }
    return localHashSet;
  }
  
  public ConcurrentHashMap<String, IHttpCommunicatorListener> getProcessMap()
  {
    return this.processorMap;
  }
  
  public abstract BaseTransProcessor getProcessor(TransferRequest paramTransferRequest);
  
  public AtomicBoolean isWorking()
  {
    return this.mWorking;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPreConn req");
      localStringBuilder.append(paramNetResp.mReq);
      localStringBuilder.append(" result:");
      boolean bool;
      if (paramNetResp.mResult == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.e("Q.richmedia.TransFileController", 2, localStringBuilder.toString());
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  void printBadRequest()
  {
    long l = System.currentTimeMillis();
    if (this.startTime <= 0L) {
      this.startTime = l;
    }
    if (l - this.startTime > 2000L)
    {
      this.startTime = l;
      this.count = 0;
    }
    else
    {
      this.count += 1;
    }
    if (this.count > 500)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bad bad 日志频繁打印");
      localStringBuilder.append(QLog.getStackTraceString(new Throwable()));
      QLog.e("Q.richmedia.TransFileController", 1, localStringBuilder.toString());
    }
  }
  
  public void removeHandle(TransProcessorHandler paramTransProcessorHandler)
  {
    BaseTransProcessor.removeHandler(paramTransProcessorHandler);
  }
  
  public boolean removeProcessor(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if (this.processorMap.remove(paramString) != null) {
      bool = true;
    }
    return bool;
  }
  
  public void stop(TransferRequest paramTransferRequest)
  {
    paramTransferRequest = paramTransferRequest.getKeyForTransfer();
    if (this.processorMap.containsKey(paramTransferRequest))
    {
      Object localObject = (IHttpCommunicatorListener)this.processorMap.get(paramTransferRequest);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        ((BaseTransProcessor)localObject).stop();
        ((BaseTransProcessor)localObject).cancel();
        this.processorMap.remove(paramTransferRequest);
      }
    }
  }
  
  public void stopCurrentWork()
  {
    Iterator localIterator = getKeySetClone(this.processorMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (IHttpCommunicatorListener)this.processorMap.get(str);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        ((BaseTransProcessor)localObject).stop();
        ((BaseTransProcessor)localObject).cancel();
        ((BaseTransProcessor)localObject).accountChanged();
        this.processorMap.remove(str);
      }
    }
  }
  
  public boolean transferAsync(TransferRequest paramTransferRequest)
  {
    try
    {
      Object localObject = paramTransferRequest.getKeyForTransfer();
      boolean bool2 = false;
      boolean bool1;
      if (this.mWorking.get())
      {
        if (!this.processorMap.containsKey(localObject))
        {
          paramTransferRequest = getProcessor(paramTransferRequest);
          bool1 = bool2;
          if (paramTransferRequest != null)
          {
            bool1 = bool2;
            if (paramTransferRequest.checkParam() == 0)
            {
              this.processorMap.put(localObject, paramTransferRequest);
              paramTransferRequest.setKey((String)localObject);
              bool1 = bool2;
              if (this.mHandler != null)
              {
                this.mHandler.startProcessor(paramTransferRequest);
                bool1 = true;
              }
            }
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("bad bad:");
            ((StringBuilder)localObject).append(paramTransferRequest.mUniseq);
            QLog.d("Q.richmedia.TransFileController", 2, ((StringBuilder)localObject).toString());
          }
          printBadRequest();
          localObject = (BaseTransProcessor)findProcessor(paramTransferRequest.mPeerUin, paramTransferRequest.mUniseq);
          bool1 = bool2;
          if (localObject != null)
          {
            if ((paramTransferRequest.mFileType == 131078) && (((BaseTransProcessor)localObject).mUiRequest != null) && (((BaseTransProcessor)localObject).mUiRequest.mDownCallBack == null) && (paramTransferRequest.mDownCallBack != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.richmedia.TransFileController", 2, "multimsg-replace callback to predownload");
              }
              ((BaseTransProcessor)localObject).mUiRequest.mDownCallBack = paramTransferRequest.mDownCallBack;
            }
            ((BaseTransProcessor)localObject).resume();
            bool1 = bool2;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.richmedia.TransFileController", 2, ProcessorReport.getExceptionMessage(new Exception("tranfilecontroller closed")));
          bool1 = bool2;
        }
      }
      return bool1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransFileController
 * JD-Core Version:    0.7.0.1
 */