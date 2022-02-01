package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZoneStartupMonitor;

public class QzoneTracer
  extends Step
{
  protected boolean doStep()
  {
    ((IQZoneStartupMonitor)QRoute.api(IQZoneStartupMonitor.class)).beforeLoadPlugin();
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.QzoneTracer
 * JD-Core Version:    0.7.0.1
 */