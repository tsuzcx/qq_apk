package com.tencent.qqprotect.qsec;

import bhjv;
import bhjw;

public abstract interface ICloudAVEngine
{
  public static final int EVENT_GET_MD5_FAILED = 4;
  public static final int EVENT_QUEUE_FULL = 1;
  public static final int EVENT_SERVER_REPLY = 3;
  public static final int EVENT_WAIT_TIMEOUT = 2;
  
  public abstract int cloudDetect(bhjv parambhjv, boolean paramBoolean1, boolean paramBoolean2, bhjw parambhjw);
  
  public abstract void flushRequest();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.ICloudAVEngine
 * JD-Core Version:    0.7.0.1
 */