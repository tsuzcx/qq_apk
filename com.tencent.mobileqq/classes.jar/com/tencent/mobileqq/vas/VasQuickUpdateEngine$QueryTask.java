package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;

public class VasQuickUpdateEngine$QueryTask
  extends VasQuickUpdateEngine.PendingTask
{
  private QueryItemVersionCallback callback;
  private boolean isCfg;
  
  public VasQuickUpdateEngine$QueryTask(int paramInt, String paramString, boolean paramBoolean, QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    this.bid = paramInt;
    this.scid = paramString;
    this.isCfg = paramBoolean;
    this.callback = paramQueryItemVersionCallback;
  }
  
  public boolean equals(VasQuickUpdateEngine.PendingTask paramPendingTask)
  {
    paramPendingTask = (QueryTask)paramPendingTask;
    return this.callback == paramPendingTask.callback;
  }
  
  public void run(VasQuickUpdateEngine paramVasQuickUpdateEngine)
  {
    paramVasQuickUpdateEngine.queryItemVersion((int)this.bid, this.scid, this.isCfg, this.callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine.QueryTask
 * JD-Core Version:    0.7.0.1
 */