package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;
import java.util.Map;

class FinalDataTarget$NotifyCallbackImpl
  implements ListenerMgr.INotifyCallback<FinalDataTarget.IFinalDataHandleListener>
{
  Object mEventObj;
  FinalData mFinalData;
  Map<String, Object> mInnerPublicParams;
  
  public void onNotify(FinalDataTarget.IFinalDataHandleListener paramIFinalDataHandleListener)
  {
    paramIFinalDataHandleListener.onHandleFinalData(this.mEventObj, this.mFinalData, this.mInnerPublicParams);
  }
  
  void setNotifyData(Object paramObject, FinalData paramFinalData, Map<String, Object> paramMap)
  {
    this.mEventObj = paramObject;
    this.mFinalData = paramFinalData;
    this.mInnerPublicParams = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget.NotifyCallbackImpl
 * JD-Core Version:    0.7.0.1
 */