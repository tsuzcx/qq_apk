package com.tencent.mobileqq.mini.http;

import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class WxRequest
{
  private static final String TAG = "WxRequest";
  private static ConcurrentHashMap<Integer, RequestTask> requestMap = new ConcurrentHashMap();
  private static AtomicInteger sRequestCount = new AtomicInteger(0);
  
  public static void abort(RequestTask.Request paramRequest)
  {
    if ((requestMap != null) && (requestMap.containsKey(Integer.valueOf(paramRequest.mTaskId))))
    {
      paramRequest = (RequestTask)requestMap.remove(Integer.valueOf(paramRequest.mTaskId));
      if (paramRequest != null) {
        paramRequest.abort();
      }
    }
  }
  
  public static void removeTaskInMap(int paramInt)
  {
    if ((requestMap != null) && (requestMap.containsKey(Integer.valueOf(paramInt)))) {
      requestMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static boolean request(RequestTask.Request paramRequest)
  {
    RequestTask localRequestTask = new RequestTask(paramRequest);
    if (sRequestCount.get() > 200)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WxRequest", 2, "[httpRequest] too much request");
      }
      return false;
    }
    requestMap.put(Integer.valueOf(paramRequest.mTaskId), localRequestTask);
    TTHandleThread.getInstance().execute(localRequestTask, new WxRequest.1());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.WxRequest
 * JD-Core Version:    0.7.0.1
 */