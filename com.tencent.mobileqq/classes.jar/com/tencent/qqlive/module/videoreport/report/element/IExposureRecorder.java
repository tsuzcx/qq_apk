package com.tencent.qqlive.module.videoreport.report.element;

import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import java.util.Collection;
import java.util.Map;

public abstract interface IExposureRecorder
{
  public abstract void clearExposure();
  
  public abstract Map<Long, IExposureRecorder.ExposureInfoWrapper> getExposedRecords();
  
  public abstract boolean isExposed(long paramLong);
  
  public abstract void markExposed(ExposureElementInfo paramExposureElementInfo);
  
  public abstract void markUnexposed(long paramLong);
  
  public abstract void markUnexposed(Collection<Long> paramCollection);
  
  public abstract void registerOnExposureStatusListener(IExposureRecorder.OnExposureStatusListener paramOnExposureStatusListener);
  
  public abstract void updateAreaInfo(long paramLong, AreaInfo paramAreaInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder
 * JD-Core Version:    0.7.0.1
 */