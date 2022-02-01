package com.tencent.qqlive.module.videoreport.lazy;

import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;

class LazyInitObserver$2
  implements Runnable
{
  LazyInitObserver$2(LazyInitObserver paramLazyInitObserver) {}
  
  public void run()
  {
    if (!LazyInitObserver.access$100(this.this$0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ATTENTION:\n=========================ERROR============================\n\n\n    ");
      localStringBuilder.append("ERROR: 你可能忘记调用markToProceed！会导致数据无法上报！");
      localStringBuilder.append("\n\n\n========================ERROR END=========================\n");
      Log.e("LazyInitSequence", localStringBuilder.toString());
      Toast.makeText(ReportUtils.getContext(), "ERROR: 你可能忘记调用markToProceed！会导致数据无法上报！", 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver.2
 * JD-Core Version:    0.7.0.1
 */