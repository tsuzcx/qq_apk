package com.tencent.superplayer.framecheck;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.superplayer.utils.BitmapHashUtil;
import com.tencent.superplayer.utils.LogUtil;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class FrameComparePipeLine
{
  public static final int BLACK_SCREEN_HASH = -2;
  public static final int HAMMING_DISTANCE_LIMIT = 0;
  private static final String TAG = "SuperPlayer-.FrameComparePipeLine";
  private Handler mHandler;
  private HandlerThread mHandlerThread = new HandlerThread("FrameComparePipeLine");
  private FrameComparePipeLine.OnVideoFrameCheckListener mOnVideoFrameCheckListener = null;
  private Queue<VideoFrameCaptureTask> mQueue = new ArrayDeque();
  private Random mRandom = new Random();
  private List<FrameComparePipeLine.TaskResult> mTaskResultList = new ArrayList();
  
  public FrameComparePipeLine()
  {
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
  }
  
  private boolean checkBitmapIsColor(Bitmap paramBitmap, int paramInt)
  {
    int j = Math.min(Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()), 32);
    int i = 0;
    while (i < j)
    {
      if (paramBitmap.getPixel(i, this.mRandom.nextInt(j)) != paramInt) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int checkTaskResultList()
  {
    Iterator localIterator = this.mTaskResultList.iterator();
    Object localObject = null;
    int j = 1;
    int i = 1;
    int k;
    for (int m = 1;; m = k)
    {
      boolean bool = localIterator.hasNext();
      int n = 0;
      if (!bool) {
        break;
      }
      FrameComparePipeLine.TaskResult localTaskResult = (FrameComparePipeLine.TaskResult)localIterator.next();
      if ((i != 0) && (localTaskResult.isBlack)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((j != 0) && (localTaskResult.isTransparent)) {
        j = 1;
      } else {
        j = 0;
      }
      k = m;
      if (localObject != null)
      {
        k = n;
        if (m != 0)
        {
          k = n;
          if (BitmapHashUtil.hammingDistance(localTaskResult.pHash, localObject.pHash) <= 0) {
            k = 1;
          }
        }
      }
      localObject = localTaskResult;
    }
    if (j != 0) {
      return 1;
    }
    if (i != 0) {
      return 2;
    }
    if (m != 0) {
      return 3;
    }
    return 0;
  }
  
  private void fetchOneTaskAndRun()
  {
    VideoFrameCaptureTask localVideoFrameCaptureTask = (VideoFrameCaptureTask)this.mQueue.poll();
    boolean bool = this.mQueue.isEmpty();
    if (localVideoFrameCaptureTask != null) {
      this.mHandler.postDelayed(new FrameComparePipeLine.2(this, localVideoFrameCaptureTask, bool), localVideoFrameCaptureTask.getTaskDelay());
    }
  }
  
  private String getResultListStr()
  {
    StringBuilder localStringBuilder = new StringBuilder("mTaskResultList:");
    Iterator localIterator = this.mTaskResultList.iterator();
    while (localIterator.hasNext())
    {
      FrameComparePipeLine.TaskResult localTaskResult = (FrameComparePipeLine.TaskResult)localIterator.next();
      localStringBuilder.append("\n");
      localStringBuilder.append(localTaskResult);
    }
    return localStringBuilder.toString();
  }
  
  private void onTaskException()
  {
    this.mTaskResultList.clear();
  }
  
  private void runTask(VideoFrameCaptureTask paramVideoFrameCaptureTask)
  {
    Bitmap localBitmap = paramVideoFrameCaptureTask.doTask();
    if (localBitmap == null)
    {
      onTaskException();
      return;
    }
    FrameComparePipeLine.TaskResult localTaskResult = new FrameComparePipeLine.TaskResult(this);
    if (checkBitmapIsColor(localBitmap, 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("checkTransparentBitmap unPass, ");
      localStringBuilder1.append(paramVideoFrameCaptureTask);
      LogUtil.d("SuperPlayer-.FrameComparePipeLine", localStringBuilder1.toString());
      localTaskResult.isTransparent = true;
    }
    try
    {
      localTaskResult.pHash = BitmapHashUtil.dctImageHash(localBitmap, true);
    }
    catch (IOException localIOException)
    {
      LogUtil.e("SuperPlayer-.FrameComparePipeLine", "dctImageHash exception", localIOException);
    }
    if (BitmapHashUtil.hammingDistance(-2L, localTaskResult.pHash) == 0)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("checkBlackBitmap unPass, ");
      localStringBuilder2.append(paramVideoFrameCaptureTask);
      LogUtil.d("SuperPlayer-.FrameComparePipeLine", localStringBuilder2.toString());
      localTaskResult.isBlack = true;
    }
    this.mTaskResultList.add(localTaskResult);
    if (!localBitmap.isRecycled()) {
      localBitmap.recycle();
    }
  }
  
  public void addTask(VideoFrameCaptureTask paramVideoFrameCaptureTask)
  {
    if ((paramVideoFrameCaptureTask instanceof FirstFrameCaptureTask))
    {
      ArrayList localArrayList = new ArrayList(this.mQueue);
      this.mQueue.clear();
      this.mQueue.add(paramVideoFrameCaptureTask);
      this.mQueue.addAll(localArrayList);
      return;
    }
    this.mQueue.add(paramVideoFrameCaptureTask);
  }
  
  public void release()
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.mHandlerThread.quitSafely();
      return;
    }
    this.mHandlerThread.quit();
  }
  
  public void reset()
  {
    this.mHandler.removeCallbacks(null);
    this.mQueue.clear();
    this.mHandler.post(new FrameComparePipeLine.1(this));
  }
  
  public void setOnVideoFrameCheckListener(FrameComparePipeLine.OnVideoFrameCheckListener paramOnVideoFrameCheckListener)
  {
    this.mOnVideoFrameCheckListener = paramOnVideoFrameCheckListener;
  }
  
  public void start()
  {
    LogUtil.d("SuperPlayer-.FrameComparePipeLine", "start");
    fetchOneTaskAndRun();
  }
  
  public void stop()
  {
    reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.FrameComparePipeLine
 * JD-Core Version:    0.7.0.1
 */