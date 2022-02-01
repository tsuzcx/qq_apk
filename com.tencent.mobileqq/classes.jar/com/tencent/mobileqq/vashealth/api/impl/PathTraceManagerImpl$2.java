package com.tencent.mobileqq.vashealth.api.impl;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.qphone.base.util.QLog;

class PathTraceManagerImpl$2
  implements SensorEventListener
{
  PathTraceManagerImpl$2(PathTraceManagerImpl paramPathTraceManagerImpl) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step Changed:");
    localStringBuilder.append(paramSensorEvent.values[0]);
    QLog.d("PathTraceManager", 1, localStringBuilder.toString());
    if (PathTraceManagerImpl.access$100(this.a) == 1)
    {
      PathTraceManagerImpl.access$202(this.a, (int)paramSensorEvent.values[0]);
      if ((PathTraceManagerImpl.access$300(this.a) != null) && (PathTraceManagerImpl.access$200(this.a) > PathTraceManagerImpl.access$400(this.a)) && (PathTraceManagerImpl.access$400(this.a) != 0))
      {
        int i = PathTraceManagerImpl.access$300(this.a).totalSteps;
        if (this.a.debug)
        {
          paramSensorEvent = PathTraceManagerImpl.access$300(this.a);
          paramSensorEvent.totalSteps += (PathTraceManagerImpl.access$200(this.a) - PathTraceManagerImpl.access$400(this.a)) * (int)(Math.random() * 20.0D);
        }
        else
        {
          paramSensorEvent = PathTraceManagerImpl.access$300(this.a);
          paramSensorEvent.totalSteps += PathTraceManagerImpl.access$200(this.a) - PathTraceManagerImpl.access$400(this.a);
        }
        paramSensorEvent = this.a;
        PathTraceManagerImpl.access$402(paramSensorEvent, PathTraceManagerImpl.access$200(paramSensorEvent));
        PathTraceManagerImpl.access$500(this.a, null);
        if (PathTraceManagerImpl.access$300(this.a).type == 1)
        {
          if ((i < PathTraceManagerImpl.access$300(this.a).stepsGoal) && (PathTraceManagerImpl.access$300(this.a).totalSteps >= PathTraceManagerImpl.access$300(this.a).stepsGoal))
          {
            paramSensorEvent = this.a;
            paramSensorEvent.stepVoiceBroadCast(PathTraceManagerImpl.access$300(paramSensorEvent), false, true);
            return;
          }
          if (Math.floor(PathTraceManagerImpl.access$300(this.a).totalSteps / 1000) - Math.floor(i / 1000) > 0.0D)
          {
            paramSensorEvent = this.a;
            paramSensorEvent.stepVoiceBroadCast(PathTraceManagerImpl.access$300(paramSensorEvent), false, false);
          }
        }
      }
      else if (PathTraceManagerImpl.access$400(this.a) == 0)
      {
        paramSensorEvent = this.a;
        PathTraceManagerImpl.access$402(paramSensorEvent, PathTraceManagerImpl.access$200(paramSensorEvent));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */