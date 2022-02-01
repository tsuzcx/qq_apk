package com.tencent.webbundle.sdk;

abstract interface HybridIdleTaskHelper$IIdleTask
{
  public static final int RESULT_CONTINUE = 2;
  public static final int RESULT_DONE_OK = 1;
  public static final int RESULT_DONE_UNNECESSARY = 0;
  
  public abstract int run();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.webbundle.sdk.HybridIdleTaskHelper.IIdleTask
 * JD-Core Version:    0.7.0.1
 */