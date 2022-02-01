package com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.sveffects.SLog;
import java.util.HashMap;

class GestureMgrRecognize$RecognizeRunnable
  implements Runnable
{
  int mToken = 0;
  
  public GestureMgrRecognize$RecognizeRunnable(GestureMgrRecognize paramGestureMgrRecognize, int paramInt)
  {
    this.mToken = paramInt;
  }
  
  public void run()
  {
    Thread localThread = Thread.currentThread();
    Object localObject2;
    GestureMgrRecognize.GestureInfo localGestureInfo;
    for (;;)
    {
      HashMap localHashMap;
      GestureMgrRecognize.GestureInfo[] arrayOfGestureInfo;
      try
      {
        long[] arrayOfLong1 = new long[15];
        localHashMap = new HashMap();
        arrayOfGestureInfo = new GestureMgrRecognize.GestureInfo[5];
        i = 0;
        if (i < 5)
        {
          arrayOfGestureInfo[i] = new GestureMgrRecognize.GestureInfo(this.this$0);
          i += 1;
          continue;
        }
        SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable, ThreadId[%s], token[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.mToken) }));
        j = 0;
        i = 0;
        if (this.this$0.loadSo()) {
          continue;
        }
        SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable load so fail, ThreadId[%s], token[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.mToken) }));
        GestureMgrRecognize.access$000(this.this$0, localHashMap);
        GestureMgrRecognize.reportCost(arrayOfLong1, i);
      }
      catch (Exception localException1)
      {
        SLog.e("GestureMgrRecognize", String.format("RecognizeRunnable occured exception[%s]", new Object[] { localException1.getClass().getName() }), localException1);
        continue;
        localObject2 = this.this$0.mGestureData;
        this.this$0.mGestureData = null;
        if (localObject2 == null) {
          break label557;
        }
      }
      SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable, finaly exit, ThreadId[%s], token[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.mToken) }));
      return;
      if (this.mToken != this.this$0.mCurRecognizeRunnableToken)
      {
        SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable exit1, ThreadId[%s], token[%s], curToken[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.mToken), Integer.valueOf(this.this$0.mCurRecognizeRunnableToken) }));
      }
      else
      {
        localGestureInfo = arrayOfGestureInfo[j];
        this.this$0.mGestureInfo.copyTo(localGestureInfo);
        synchronized (GestureMgrRecognize.mGestureLock)
        {
          localObject2 = GestureMgrRecognize.doProcess(this.mToken, (GestureMgrRecognize.GestureData)localObject2, localGestureInfo.type, localException1, i);
          if (!localHashMap.containsKey(((GestureKeyInfo)localObject2).type)) {
            break label552;
          }
          k = ((Integer)localHashMap.get(((GestureKeyInfo)localObject2).type)).intValue();
          label388:
          localHashMap.put(((GestureKeyInfo)localObject2).type, Integer.valueOf(k + 1));
          if (this.mToken != this.this$0.mCurRecognizeRunnableToken) {
            SLog.d("GestureMgrRecognize", String.format("RecognizeRunnable exit2, ThreadId[%s], token[%s], curToken[%s]", new Object[] { Long.valueOf(localThread.getId()), Integer.valueOf(this.mToken), Integer.valueOf(this.this$0.mCurRecognizeRunnableToken) }));
          }
        }
      }
    }
    GestureMgrRecognize.mergeData(this.mToken, localGestureInfo, (GestureKeyInfo)localObject2);
    this.this$0.mGestureInfo = localGestureInfo;
    int k = (j + 1) % 5;
    i += 1;
    if (i == 15) {
      GestureMgrRecognize.reportCost(arrayOfLong2, i);
    }
    int j = i % 15;
    int i = k;
    for (;;)
    {
      try
      {
        Thread.sleep(this.this$0.mRecognizeRunnableSleepMillis);
        k = j;
        j = i;
        i = k;
      }
      catch (Exception localException2)
      {
        continue;
      }
      label552:
      k = 0;
      break label388;
      label557:
      k = i;
      i = j;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize.RecognizeRunnable
 * JD-Core Version:    0.7.0.1
 */