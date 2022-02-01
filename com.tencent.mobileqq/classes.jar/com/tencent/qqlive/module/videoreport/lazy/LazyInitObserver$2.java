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
      Log.e("LazyInitSequence", "ATTENTION:\n=========================ERROR============================\n\n\n    " + "ERROR: 你可能忘记调用markToProceed！会导致数据无法上报！" + "\n\n\n========================ERROR END=========================\n");
      Toast.makeText(ReportUtils.getContext(), "ERROR: 你可能忘记调用markToProceed！会导致数据无法上报！", 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver.2
 * JD-Core Version:    0.7.0.1
 */