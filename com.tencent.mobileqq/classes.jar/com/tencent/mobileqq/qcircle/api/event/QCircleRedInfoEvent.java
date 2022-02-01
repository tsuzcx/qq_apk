package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleRedInfoEvent
  extends SimpleBaseEvent
{
  private static final String TAG = "QCircleRedInfoEvent";
  public String mInvokeMethodName = "";
  public boolean mIsClearRedPoint;
  
  public QCircleRedInfoEvent(String paramString, boolean paramBoolean)
  {
    this.mIsClearRedPoint = paramBoolean;
    this.mInvokeMethodName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent
 * JD-Core Version:    0.7.0.1
 */