package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class MiniLog$QLogItem
  extends RecyclablePool.Recyclable
{
  public String appId;
  public int level;
  public long logTime;
  public String msg;
  public String tag;
  public int threadId;
  public Throwable trace;
  
  public void recycle()
  {
    super.recycle();
    this.logTime = 0L;
    this.threadId = 0;
    this.level = 0;
    this.tag = "";
    this.msg = "";
    this.trace = null;
    this.appId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLog.QLogItem
 * JD-Core Version:    0.7.0.1
 */