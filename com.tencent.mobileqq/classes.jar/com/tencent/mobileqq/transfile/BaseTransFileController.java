package com.tencent.mobileqq.transfile;

import arfv;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseTransFileController
  implements INetEngine.INetEngineListener
{
  public static final String TAG = "Q.richmedia.TransFileController";
  public AppInterface app;
  public int count;
  public BaseTransFileController.ProcHandler mHandler;
  public arfv mRichmediaIpv6ConifgBean;
  AtomicBoolean mWorking = new AtomicBoolean(true);
  public ConcurrentHashMap<String, IHttpCommunicatorListener> processorMap = new ConcurrentHashMap(20);
  public long startTime;
  
  public BaseTransFileController() {}
  
  public BaseTransFileController(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.app = paramAppInterface;
    this.mHandler = new BaseTransFileController.ProcHandler(this, ThreadManager.getSubThreadLooper());
    ThreadManager.executeOnSubThread(new BaseTransFileController.1(this));
  }
  
  public void addHandle(TransProcessorHandler paramTransProcessorHandler)
  {
    BaseTransProcessor.addHandler(paramTransProcessorHandler);
  }
  
  public abstract void destroy();
  
  public IHttpCommunicatorListener findProcessor(String paramString, long paramLong)
  {
    if (!this.processorMap.isEmpty()) {
      return (IHttpCommunicatorListener)this.processorMap.get(paramString + paramLong);
    }
    return null;
  }
  
  protected Set<String> getKeySetClone(ConcurrentHashMap<String, IHttpCommunicatorListener> paramConcurrentHashMap)
  {
    HashSet localHashSet = new HashSet();
    if (paramConcurrentHashMap != null) {}
    for (paramConcurrentHashMap = paramConcurrentHashMap.keySet(); paramConcurrentHashMap != null; paramConcurrentHashMap = null)
    {
      paramConcurrentHashMap = paramConcurrentHashMap.iterator();
      while (paramConcurrentHashMap.hasNext()) {
        localHashSet.add((String)paramConcurrentHashMap.next());
      }
    }
    return localHashSet;
  }
  
  public abstract BaseTransProcessor getProcessor(TransferRequest paramTransferRequest);
  
  public void onResp(NetResp paramNetResp)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doPreConn req").append(paramNetResp.mReq).append(" result:");
      if (paramNetResp.mResult != 0) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("Q.richmedia.TransFileController", 2, bool);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void removeHandle(TransProcessorHandler paramTransProcessorHandler)
  {
    BaseTransProcessor.removeHandler(paramTransProcessorHandler);
  }
  
  public boolean removeProcessor(String paramString)
  {
    if (paramString == null) {}
    while (this.processorMap.remove(paramString) == null) {
      return false;
    }
    return true;
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
    Object localObject = paramTransferRequest.getKeyForTransfer();
    if (this.mWorking.get())
    {
      if (!this.processorMap.containsKey(localObject))
      {
        paramTransferRequest = getProcessor(paramTransferRequest);
        if ((paramTransferRequest != null) && (paramTransferRequest.checkParam() == 0))
        {
          this.processorMap.put(localObject, paramTransferRequest);
          paramTransferRequest.setKey((String)localObject);
          if (this.mHandler != null)
          {
            this.mHandler.startProcessor(paramTransferRequest);
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.TransFileController", 2, "bad bad:" + paramTransferRequest.mUniseq);
        }
        long l = System.currentTimeMillis();
        if (this.startTime <= 0L) {
          this.startTime = l;
        }
        if (l - this.startTime > 2000L) {
          this.startTime = l;
        }
        for (this.count = 0;; this.count += 1)
        {
          if (this.count > 500) {
            QLog.e("Q.richmedia.TransFileController", 1, "bad bad 日志频繁打印" + QLog.getStackTraceString(new Throwable()));
          }
          localObject = (BaseTransProcessor)findProcessor(paramTransferRequest.mPeerUin, paramTransferRequest.mUniseq);
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
          }
          return false;
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, AbstractImageDownloader.getExceptionMessage(new Exception("tranfilecontroller closed")));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransFileController
 * JD-Core Version:    0.7.0.1
 */