package com.tencent.qqlive.module.videoreport.report.element;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class ExposureRecorderImpl$1
  implements ListenerMgr.INotifyCallback<IExposureRecorder.OnExposureStatusListener>
{
  ExposureRecorderImpl$1(ExposureRecorderImpl paramExposureRecorderImpl, IExposureRecorder.ExposureInfoWrapper paramExposureInfoWrapper, long paramLong) {}
  
  public void onNotify(IExposureRecorder.OnExposureStatusListener paramOnExposureStatusListener)
  {
    paramOnExposureStatusListener.onViewUnexposed(this.val$wrapper, this.val$exposureInterval);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ExposureRecorderImpl.1
 * JD-Core Version:    0.7.0.1
 */