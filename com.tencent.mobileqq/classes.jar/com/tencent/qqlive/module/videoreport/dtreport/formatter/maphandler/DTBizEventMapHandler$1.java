package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

class DTBizEventMapHandler$1
  implements Runnable
{
  DTBizEventMapHandler$1(DTBizEventMapHandler paramDTBizEventMapHandler, Map paramMap) {}
  
  public void run()
  {
    DTBizEventMapHandler.access$000(this.this$0, this.val$udfKv);
    synchronized (DTBizEventMapHandler.access$100(this.this$0))
    {
      DTBizEventMapHandler.access$100(this.this$0).notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBizEventMapHandler.1
 * JD-Core Version:    0.7.0.1
 */