package com.tencent.mobileqq.fts.api.impl;

import com.tencent.mobileqq.fts.operator.FTSSyncHandler;
import com.tencent.mobileqq.fts.utils.FTSUtils;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;

class FTSDBRuntimeServiceImpl$1
  implements Runnable
{
  FTSDBRuntimeServiceImpl$1(FTSDBRuntimeServiceImpl paramFTSDBRuntimeServiceImpl) {}
  
  public void run()
  {
    if (this.this$0.hasInit()) {
      return;
    }
    if (FTSUtils.d(FTSDBRuntimeServiceImpl.access$000(this.this$0)))
    {
      FTSDBRuntimeServiceImpl.access$100(this.this$0);
      return;
    }
    if (FTSUtils.e(FTSDBRuntimeServiceImpl.access$000(this.this$0)))
    {
      if (this.this$0.isDestroyed) {
        return;
      }
      FTSDBRuntimeServiceImpl.access$204(this.this$0);
      ThreadRegulator.a().c();
      if (!FTSDBRuntimeServiceImpl.access$300(this.this$0)) {
        if ((FTSDBRuntimeServiceImpl.access$200(this.this$0) <= 10) && (FTSDBRuntimeServiceImpl.access$400(this.this$0) != 1))
        {
          if (FTSDBRuntimeServiceImpl.access$400(this.this$0) == -1) {
            this.this$0.mSyncHandler.postDelayed(this, 5000L);
          }
        }
        else {
          FTSDBRuntimeServiceImpl.access$100(this.this$0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */