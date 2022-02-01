package com.tencent.mobileqq.imcore.exception;

public class TroopConfigInitFailException
  extends RuntimeException
{
  public TroopConfigInitFailException(Throwable paramThrowable)
  {
    super("配置未初始化,TroopCustomizedProcessorConfig INIT失败", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.exception.TroopConfigInitFailException
 * JD-Core Version:    0.7.0.1
 */