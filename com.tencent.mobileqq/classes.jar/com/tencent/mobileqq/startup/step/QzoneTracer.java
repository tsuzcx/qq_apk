package com.tencent.mobileqq.startup.step;

import cooperation.qzone.QZoneStartupMonitor;

public class QzoneTracer
  extends Step
{
  protected boolean doStep()
  {
    QZoneStartupMonitor.beforeLoadPlugin();
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.QzoneTracer
 * JD-Core Version:    0.7.0.1
 */