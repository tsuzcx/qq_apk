package com.tribe.async.async;

import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;
import com.tribe.async.reactive.StreamFunction;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

public class ThrottlingFunction<IN>
  extends StreamFunction<IN, IN>
{
  private static final String TAG = "async.boss.ThrottlingFunction";
  private Map<IN, Future> mFutures = new ConcurrentHashMap();
  private int mJobType;
  private final int mMaxSimultaneousRequests;
  private int mNumCurrentRequests;
  private final ConcurrentLinkedQueue<IN> mPendingRequests;
  private String mTAG;
  
  public ThrottlingFunction(int paramInt1, int paramInt2)
  {
    this("ThrottlingFunction", paramInt1, paramInt2);
  }
  
  public ThrottlingFunction(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    this.mTAG = paramString;
    this.mPendingRequests = new ConcurrentLinkedQueue();
    this.mMaxSimultaneousRequests = paramInt1;
    this.mJobType = paramInt2;
    this.mNumCurrentRequests = 0;
  }
  
  private void onRequestFinished()
  {
    try
    {
      Object localObject1 = this.mPendingRequests.poll();
      if (localObject1 == null) {
        this.mNumCurrentRequests -= 1;
      }
      if (localObject1 != null) {
        produceResultsInternal(localObject1);
      }
      return;
    }
    finally {}
  }
  
  private void produceResultsInternal(@NonNull IN paramIN)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("process ");
    ((StringBuilder)localObject).append(paramIN);
    ((StringBuilder)localObject).append(", size = ");
    ((StringBuilder)localObject).append(this.mNumCurrentRequests);
    SLog.d("async.boss.ThrottlingFunction", ((StringBuilder)localObject).toString());
    new ThrottlingFunction.ThreadOffJob(this, this.mTAG, null).setJobType(this.mJobType);
    localObject = Bosses.get().prepareWorker(new ThrottlingFunction.ThreadOffJob(this, this.mTAG, null), this.mJobType, new ThrottlingFunction.InnerCallFutureListener(this, null), paramIN);
    this.mFutures.put(paramIN, localObject);
    Bosses.get().getJobController().getDefaultHandler().handleExecute(Bosses.get().getExecutors(), (Worker)localObject);
  }
  
  protected void call(IN paramIN)
  {
    try
    {
      int j = this.mNumCurrentRequests;
      int k = this.mMaxSimultaneousRequests;
      int i = 1;
      if (j >= k)
      {
        this.mPendingRequests.add(paramIN);
      }
      else
      {
        this.mNumCurrentRequests += 1;
        i = 0;
      }
      if (i == 0) {
        produceResultsInternal(paramIN);
      }
      return;
    }
    finally {}
  }
  
  protected void error(Error paramError)
  {
    ThrottlingFunction.ThreadOffErrJob localThreadOffErrJob = new ThrottlingFunction.ThreadOffErrJob(this, this.mTAG, null);
    localThreadOffErrJob.setJobType(this.mJobType);
    Bosses.get().postJob(localThreadOffErrJob, paramError);
  }
  
  protected void onCancel()
  {
    Iterator localIterator = this.mFutures.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((Future)((Map.Entry)localIterator.next()).getValue()).cancel(true);
    }
    try
    {
      this.mFutures.clear();
      this.mPendingRequests.clear();
      this.mNumCurrentRequests = 0;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.ThrottlingFunction
 * JD-Core Version:    0.7.0.1
 */