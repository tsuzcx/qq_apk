package com.tencent.mobileqq.startup.step;

import areg;
import com.tencent.shadow.core.common.LoggerFactory;

public class NowliveContainer
  extends Step
{
  protected boolean doStep()
  {
    LoggerFactory.setILoggerFactory(areg.a());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NowliveContainer
 * JD-Core Version:    0.7.0.1
 */