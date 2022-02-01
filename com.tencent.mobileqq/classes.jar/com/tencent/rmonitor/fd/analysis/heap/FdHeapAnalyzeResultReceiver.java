package com.tencent.rmonitor.fd.analysis.heap;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class FdHeapAnalyzeResultReceiver
  extends ResultReceiver
{
  private final IFdHeapAnalyzeListener a;
  
  public FdHeapAnalyzeResultReceiver(IFdHeapAnalyzeListener paramIFdHeapAnalyzeListener)
  {
    super(new Handler(Looper.myLooper()));
    this.a = paramIFdHeapAnalyzeListener;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveResult: resultCode=");
    ((StringBuilder)localObject).append(paramInt);
    LogUtils.a("FdHeapAnalyzeResultReceiver", ((StringBuilder)localObject).toString());
    if (this.a == null)
    {
      LogUtils.c("FdHeapAnalyzeResultReceiver", "onReceiveResult: listener == null");
      return;
    }
    ArrayList localArrayList = (ArrayList)paramBundle.getSerializable("key_analyze_result");
    localObject = localArrayList;
    if (localArrayList == null) {
      localObject = new ArrayList();
    }
    paramBundle = paramBundle.getString("key_analyze_error_message");
    this.a.a(paramInt, paramBundle, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.heap.FdHeapAnalyzeResultReceiver
 * JD-Core Version:    0.7.0.1
 */