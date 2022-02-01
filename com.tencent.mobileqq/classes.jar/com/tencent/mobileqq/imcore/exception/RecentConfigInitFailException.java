package com.tencent.mobileqq.imcore.exception;

public class RecentConfigInitFailException
  extends RuntimeException
{
  public RecentConfigInitFailException(Throwable paramThrowable)
  {
    super("配置未初始化,请在RecentUserCacheConfig INIT失败", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.exception.RecentConfigInitFailException
 * JD-Core Version:    0.7.0.1
 */