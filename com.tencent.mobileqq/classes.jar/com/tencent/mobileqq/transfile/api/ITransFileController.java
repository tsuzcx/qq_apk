package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITransFileController
  extends IRuntimeService
{
  public abstract void addHandle(TransProcessorHandler paramTransProcessorHandler);
  
  @Deprecated
  public abstract void addProcessor(String paramString, IHttpCommunicatorListener paramIHttpCommunicatorListener);
  
  public abstract boolean containsProcessor(String paramString, long paramLong);
  
  public abstract IHttpCommunicatorListener findProcessor(String paramString);
  
  public abstract IHttpCommunicatorListener findProcessor(String paramString, long paramLong);
  
  public abstract TransFileControllerBusHelper getBusHelper();
  
  public abstract ConcurrentHashMap<String, IHttpCommunicatorListener> getProcessMap();
  
  public abstract AtomicBoolean isWorking();
  
  public abstract void removeHandle(TransProcessorHandler paramTransProcessorHandler);
  
  public abstract boolean removeProcessor(String paramString);
  
  public abstract void removeProcessorByPeerUin(String paramString, int paramInt);
  
  public abstract void stop(TransferRequest paramTransferRequest);
  
  public abstract boolean transferAsync(TransferRequest paramTransferRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.ITransFileController
 * JD-Core Version:    0.7.0.1
 */