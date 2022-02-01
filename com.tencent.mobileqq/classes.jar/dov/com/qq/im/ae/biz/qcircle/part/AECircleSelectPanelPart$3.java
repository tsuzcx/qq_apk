package dov.com.qq.im.ae.biz.qcircle.part;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;
import dov.com.qq.im.ae.biz.qcircle.helper.PicDragHelperCallback.DragListener;

class AECircleSelectPanelPart$3
  implements PicDragHelperCallback.DragListener
{
  AECircleSelectPanelPart$3(AECircleSelectPanelPart paramAECircleSelectPanelPart) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("AECircleSelectPanelPart", 1, "onDragFinish  isInside = " + paramBoolean);
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 10, 1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECircleSelectPanelPart.3
 * JD-Core Version:    0.7.0.1
 */