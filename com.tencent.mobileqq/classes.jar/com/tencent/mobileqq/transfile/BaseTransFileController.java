package com.tencent.mobileqq.transfile;

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
  public int a;
  public long a;
  public AppInterface a;
  public BaseTransFileController.ProcHandler a;
  public ConcurrentHashMap a;
  AtomicBoolean a;
  
  public BaseTransFileController(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController$ProcHandler = new BaseTransFileController.ProcHandler(this, ThreadManager.getSubThreadLooper());
  }
  
  public abstract BaseTransProcessor a(TransferRequest paramTransferRequest);
  
  public IHttpCommunicatorListener a(String paramString, long paramLong)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + paramLong);
    }
    return null;
  }
  
  protected Set a(ConcurrentHashMap paramConcurrentHashMap)
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
  
  public void a()
  {
    Iterator localIterator = a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        ((BaseTransProcessor)localObject).h();
        ((BaseTransProcessor)localObject).a();
        ((BaseTransProcessor)localObject).b();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      }
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doPreConn req").append(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).append(" result:");
      if (paramNetResp.jdField_a_of_type_Int != 0) {
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
  
  public void a(TransProcessorHandler paramTransProcessorHandler)
  {
    BaseTransProcessor.a(paramTransProcessorHandler);
  }
  
  public void a(TransferRequest paramTransferRequest)
  {
    paramTransferRequest = paramTransferRequest.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramTransferRequest))
    {
      Object localObject = (IHttpCommunicatorListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramTransferRequest);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        ((BaseTransProcessor)localObject).h();
        ((BaseTransProcessor)localObject).a();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramTransferRequest);
      }
    }
  }
  
  public boolean a(TransferRequest paramTransferRequest)
  {
    String str = paramTransferRequest.a();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
      {
        paramTransferRequest = a(paramTransferRequest);
        if ((paramTransferRequest != null) && (paramTransferRequest.c() == 0))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramTransferRequest);
          paramTransferRequest.c(str);
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController$ProcHandler != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController$ProcHandler.a(paramTransferRequest);
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.TransFileController", 2, "bad bad:" + paramTransferRequest.jdField_a_of_type_Long);
        }
        long l = System.currentTimeMillis();
        if (this.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_Long = l;
        }
        if (l - this.jdField_a_of_type_Long > 2000L) {
          this.jdField_a_of_type_Long = l;
        }
        for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int += 1)
        {
          if (this.jdField_a_of_type_Int > 500) {
            QLog.e("Q.richmedia.TransFileController", 1, "bad bad 日志频繁打印" + QLog.getStackTraceString(new Throwable()));
          }
          paramTransferRequest = (BaseTransProcessor)a(paramTransferRequest.c, paramTransferRequest.jdField_a_of_type_Long);
          if (paramTransferRequest != null) {
            paramTransferRequest.b();
          }
          return false;
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, AbstractImageDownloader.a(new Exception("tranfilecontroller closed")));
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public void b(TransProcessorHandler paramTransProcessorHandler)
  {
    BaseTransProcessor.b(paramTransProcessorHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransFileController
 * JD-Core Version:    0.7.0.1
 */