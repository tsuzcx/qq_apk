package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.intervideo.IVLoggerFactory;
import com.tencent.shadow.core.common.LoggerFactory;

public class NowliveContainer
  extends Step
{
  protected boolean doStep()
  {
    LoggerFactory.setILoggerFactory(IVLoggerFactory.a());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NowliveContainer
 * JD-Core Version:    0.7.0.1
 */