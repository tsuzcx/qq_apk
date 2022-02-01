package com.tencent.mobileqq.statistics.provider.report;

import android.view.MotionEvent;
import com.tencent.mobileqq.bridge.report.service.ITouchEventService;
import com.tencent.mobileqq.tablequery.TableQueryController;

class TouchEventServiceProvider$1
  implements ITouchEventService
{
  TouchEventServiceProvider$1(TouchEventServiceProvider paramTouchEventServiceProvider) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    TableQueryController.a().a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.TouchEventServiceProvider.1
 * JD-Core Version:    0.7.0.1
 */