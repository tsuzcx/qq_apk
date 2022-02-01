package com.tencent.mobileqq.triton.debug;

import com.tencent.mobileqq.triton.sdk.ITTEngine.OnGetTraceRecordCallback;
import com.tencent.mobileqq.triton.sdk.statics.TraceStatistics;
import com.tencent.mobileqq.triton.sdk.statics.TraceStatistics.Record;
import java.util.ArrayList;
import java.util.Collections;

class JankCanary$a
  implements Runnable
{
  JankCanary$a(JankCanary paramJankCanary, ITTEngine.OnGetTraceRecordCallback paramOnGetTraceRecordCallback) {}
  
  public void run()
  {
    Object localObject = JankCanary.a(JankCanary.a(this.b), Object.class);
    if (localObject != null)
    {
      Object[] arrayOfObject = (Object[])localObject[0];
      localObject = (long[])localObject[1];
      ArrayList localArrayList = new ArrayList(arrayOfObject.length);
      int i = 0;
      while (i < arrayOfObject.length)
      {
        localArrayList.add(new TraceStatistics.Record((String)arrayOfObject[i], localObject[i]));
        i += 1;
      }
      this.a.onGetTraceRecord(new TraceStatistics(localArrayList));
      return;
    }
    this.a.onGetTraceRecord(new TraceStatistics(Collections.emptyList()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.debug.JankCanary.a
 * JD-Core Version:    0.7.0.1
 */