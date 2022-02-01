package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue
{
  private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 2;
  private final Set<Request> mCurrentRequests = new HashSet();
  private final ResponseDelivery mDelivery;
  private final NetworkDispatcher[] mDispatchers;
  private final List<RequestQueue.RequestFinishedListener> mFinishedListeners = new ArrayList();
  private final Network mNetwork;
  private final PriorityBlockingQueue<Request> mNetworkQueue = new PriorityBlockingQueue();
  private final AtomicInteger mSequenceGenerator = new AtomicInteger();
  
  public RequestQueue(Network paramNetwork)
  {
    this(paramNetwork, 2);
  }
  
  public RequestQueue(Network paramNetwork, int paramInt)
  {
    this(paramNetwork, paramInt, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
  }
  
  public RequestQueue(Network paramNetwork, int paramInt, ResponseDelivery paramResponseDelivery)
  {
    this.mNetwork = paramNetwork;
    this.mDispatchers = new NetworkDispatcher[paramInt];
    this.mDelivery = paramResponseDelivery;
  }
  
  public Request add(Request paramRequest)
  {
    paramRequest.setRequestQueue(this);
    synchronized (this.mCurrentRequests)
    {
      this.mCurrentRequests.add(paramRequest);
      paramRequest.setSequence(getSequenceNumber());
      this.mNetworkQueue.add(paramRequest);
      return paramRequest;
    }
  }
  
  public void cancelAll(RequestQueue.RequestFilter paramRequestFilter)
  {
    synchronized (this.mCurrentRequests)
    {
      Iterator localIterator = this.mCurrentRequests.iterator();
      while (localIterator.hasNext())
      {
        Request localRequest = (Request)localIterator.next();
        if (paramRequestFilter.apply(localRequest)) {
          localRequest.cancel();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramRequestFilter;
    }
  }
  
  public void cancelAll(Object paramObject)
  {
    if (paramObject != null)
    {
      cancelAll(new RequestQueue.1(this, paramObject));
      return;
    }
    throw new IllegalArgumentException("Cannot cancelAll with a null tag");
  }
  
  <T> void finish(Request paramRequest)
  {
    synchronized (this.mCurrentRequests)
    {
      this.mCurrentRequests.remove(paramRequest);
      synchronized (this.mFinishedListeners)
      {
        Iterator localIterator = this.mFinishedListeners.iterator();
        while (localIterator.hasNext()) {
          ((RequestQueue.RequestFinishedListener)localIterator.next()).onRequestFinished(paramRequest);
        }
        return;
      }
    }
    for (;;)
    {
      throw paramRequest;
    }
  }
  
  public int getSequenceNumber()
  {
    return this.mSequenceGenerator.incrementAndGet();
  }
  
  public void start()
  {
    stop();
    int i = 0;
    while (i < this.mDispatchers.length)
    {
      NetworkDispatcher localNetworkDispatcher = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mDelivery);
      this.mDispatchers[i] = localNetworkDispatcher;
      localNetworkDispatcher.start();
      i += 1;
    }
  }
  
  public void stop()
  {
    NetworkDispatcher[] arrayOfNetworkDispatcher = this.mDispatchers;
    int j = arrayOfNetworkDispatcher.length;
    int i = 0;
    while (i < j)
    {
      NetworkDispatcher localNetworkDispatcher = arrayOfNetworkDispatcher[i];
      if (localNetworkDispatcher != null) {
        localNetworkDispatcher.quit();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.RequestQueue
 * JD-Core Version:    0.7.0.1
 */