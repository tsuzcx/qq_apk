package com.tencent.superplayer.preload;

import android.app.Activity;
import com.tencent.superplayer.api.ISPlayerPreLoader;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SPlayerPreLoaderImpl
  implements ISPlayerPreLoader
{
  private int mMaxTaskSize;
  private int mSceneId;
  private Queue<Integer> mTaskQueue = new ConcurrentLinkedQueue();
  
  public SPlayerPreLoaderImpl(int paramInt1, int paramInt2)
  {
    this.mSceneId = paramInt1;
    this.mMaxTaskSize = paramInt2;
  }
  
  public void release()
  {
    try
    {
      Iterator localIterator = this.mTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        PreloadPlayerMgr.getInstance().stopPreloadTask(localInteger.intValue());
      }
      this.mTaskQueue.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int startPreloadTask(Activity paramActivity, SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    try
    {
      int i = PreloadPlayerMgr.getInstance().startPreloadTask(paramActivity, this.mSceneId, paramSuperPlayerVideoInfo);
      this.mTaskQueue.offer(Integer.valueOf(i));
      if (this.mTaskQueue.size() > this.mMaxTaskSize)
      {
        paramActivity = (Integer)this.mTaskQueue.poll();
        if (paramActivity != null) {
          PreloadPlayerMgr.getInstance().stopPreloadTask(paramActivity.intValue());
        }
      }
      return i;
    }
    finally {}
  }
  
  public void stopPreloadTask(int paramInt)
  {
    try
    {
      if (this.mTaskQueue.contains(Integer.valueOf(paramInt)))
      {
        PreloadPlayerMgr.getInstance().stopPreloadTask(paramInt);
        this.mTaskQueue.remove(Integer.valueOf(paramInt));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.preload.SPlayerPreLoaderImpl
 * JD-Core Version:    0.7.0.1
 */