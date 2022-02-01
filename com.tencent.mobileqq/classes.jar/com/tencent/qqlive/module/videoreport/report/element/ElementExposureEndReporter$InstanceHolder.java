package com.tencent.qqlive.module.videoreport.report.element;

class ElementExposureEndReporter$InstanceHolder
{
  static final ElementExposureEndReporter INSTANCE = new ElementExposureEndReporter(null);
  
  static
  {
    IExposureRecorder.Factory.getInstance().registerOnExposureStatusListener(INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureEndReporter.InstanceHolder
 * JD-Core Version:    0.7.0.1
 */