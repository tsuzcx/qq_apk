package com.tencent.qphone.base.util;

import com.tencent.qphone.base.util.log.RecyclablePool.Recyclable;

public class QLog$QLogItem
  extends RecyclablePool.Recyclable
{
  public int contentType;
  public int level;
  public long logTime;
  public String msg;
  public byte[] msgBytes;
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
    this.contentType = 0;
    this.msgBytes = null;
    this.trace = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog.QLogItem
 * JD-Core Version:    0.7.0.1
 */