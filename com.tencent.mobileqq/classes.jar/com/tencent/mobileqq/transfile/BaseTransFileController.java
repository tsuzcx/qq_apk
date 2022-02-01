package com.tencent.mobileqq.transfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.RichmediaIpv6ConifgBean;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
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
    return paramString + paramLong;
  }
  
  public static String makeReceiveKey(TransferRequest paramTransferRequest)
  {
    return makeReceiveKey(paramTransferRequest.mMd5, paramTransferRequest.mServerPath, paramTransferRequest.mFileType);
  }
  
  public static String makeReceiveKey(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
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
    paramString = paramString + paramLong;
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
  
  void printBadRequest()
  {
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
      return;
    }
  }
  
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
  
  /* Error */
  public boolean transferAsync(TransferRequest paramTransferRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 300	com/tencent/mobileqq/transfile/TransferRequest:getKeyForTransfer	()Ljava/lang/String;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 38	com/tencent/mobileqq/transfile/BaseTransFileController:mWorking	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   11: invokevirtual 316	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   14: ifeq +196 -> 210
    //   17: aload_0
    //   18: getfield 45	com/tencent/mobileqq/transfile/BaseTransFileController:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   21: aload_3
    //   22: invokevirtual 194	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   25: ifne +56 -> 81
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 318	com/tencent/mobileqq/transfile/BaseTransFileController:getProcessor	(Lcom/tencent/mobileqq/transfile/TransferRequest;)Lcom/tencent/mobileqq/transfile/BaseTransProcessor;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +200 -> 235
    //   38: aload_1
    //   39: invokevirtual 321	com/tencent/mobileqq/transfile/BaseTransProcessor:checkParam	()I
    //   42: ifne +193 -> 235
    //   45: aload_0
    //   46: getfield 45	com/tencent/mobileqq/transfile/BaseTransFileController:processorMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 186	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_1
    //   56: aload_3
    //   57: invokevirtual 325	com/tencent/mobileqq/transfile/BaseTransProcessor:setKey	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 31	com/tencent/mobileqq/transfile/BaseTransFileController:mHandler	Lcom/tencent/mobileqq/transfile/BaseTransFileController$ProcHandler;
    //   64: ifnull +171 -> 235
    //   67: aload_0
    //   68: getfield 31	com/tencent/mobileqq/transfile/BaseTransFileController:mHandler	Lcom/tencent/mobileqq/transfile/BaseTransFileController$ProcHandler;
    //   71: aload_1
    //   72: invokevirtual 328	com/tencent/mobileqq/transfile/BaseTransFileController$ProcHandler:startProcessor	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor;)V
    //   75: iconst_1
    //   76: istore_2
    //   77: aload_0
    //   78: monitorexit
    //   79: iload_2
    //   80: ireturn
    //   81: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +32 -> 116
    //   87: ldc 10
    //   89: iconst_2
    //   90: new 55	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 330
    //   100: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: getfield 333	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   107: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_0
    //   117: invokevirtual 335	com/tencent/mobileqq/transfile/BaseTransFileController:printBadRequest	()V
    //   120: aload_0
    //   121: aload_1
    //   122: getfield 338	com/tencent/mobileqq/transfile/TransferRequest:mPeerUin	Ljava/lang/String;
    //   125: aload_1
    //   126: getfield 333	com/tencent/mobileqq/transfile/TransferRequest:mUniseq	J
    //   129: invokevirtual 340	com/tencent/mobileqq/transfile/BaseTransFileController:findProcessor	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   132: checkcast 177	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   135: astore_3
    //   136: aload_3
    //   137: ifnull +98 -> 235
    //   140: aload_1
    //   141: getfield 140	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   144: ldc_w 341
    //   147: if_icmpne +53 -> 200
    //   150: aload_3
    //   151: getfield 345	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   154: ifnull +46 -> 200
    //   157: aload_3
    //   158: getfield 345	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   161: getfield 349	com/tencent/mobileqq/transfile/TransferRequest:mDownCallBack	Lcom/tencent/mobileqq/pic/DownCallBack;
    //   164: ifnonnull +36 -> 200
    //   167: aload_1
    //   168: getfield 349	com/tencent/mobileqq/transfile/TransferRequest:mDownCallBack	Lcom/tencent/mobileqq/pic/DownCallBack;
    //   171: ifnull +29 -> 200
    //   174: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +12 -> 189
    //   180: ldc 10
    //   182: iconst_2
    //   183: ldc_w 351
    //   186: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload_3
    //   190: getfield 345	com/tencent/mobileqq/transfile/BaseTransProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   193: aload_1
    //   194: getfield 349	com/tencent/mobileqq/transfile/TransferRequest:mDownCallBack	Lcom/tencent/mobileqq/pic/DownCallBack;
    //   197: putfield 349	com/tencent/mobileqq/transfile/TransferRequest:mDownCallBack	Lcom/tencent/mobileqq/pic/DownCallBack;
    //   200: aload_3
    //   201: invokevirtual 354	com/tencent/mobileqq/transfile/BaseTransProcessor:resume	()I
    //   204: pop
    //   205: iconst_0
    //   206: istore_2
    //   207: goto -130 -> 77
    //   210: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +22 -> 235
    //   216: ldc 10
    //   218: iconst_2
    //   219: new 101	java/lang/Exception
    //   222: dup
    //   223: ldc_w 356
    //   226: invokespecial 358	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   229: invokestatic 362	com/tencent/mobileqq/transfile/BaseTransProcessor:getExceptionMessage	(Ljava/lang/Exception;)Ljava/lang/String;
    //   232: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: iconst_0
    //   236: istore_2
    //   237: goto -160 -> 77
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	BaseTransFileController
    //   0	245	1	paramTransferRequest	TransferRequest
    //   76	161	2	bool	boolean
    //   6	195	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	240	finally
    //   38	75	240	finally
    //   81	116	240	finally
    //   116	136	240	finally
    //   140	189	240	finally
    //   189	200	240	finally
    //   200	205	240	finally
    //   210	235	240	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransFileController
 * JD-Core Version:    0.7.0.1
 */