package com.tencent.mobileqq.startup.step;

import avyz;
import com.tencent.shadow.core.common.LoggerFactory;

public class NowliveContainer
  extends Step
{
  protected boolean doStep()
  {
    LoggerFactory.setILoggerFactory(avyz.a());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NowliveContainer
 * JD-Core Version:    0.7.0.1
 */