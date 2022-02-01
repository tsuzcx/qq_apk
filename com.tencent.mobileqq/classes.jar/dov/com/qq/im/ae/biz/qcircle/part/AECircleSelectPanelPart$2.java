package dov.com.qq.im.ae.biz.qcircle.part;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import dov.com.qq.im.ae.biz.qcircle.adapter.PicPreviewMoveAdapter.PicOperationListener;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;

class AECircleSelectPanelPart$2
  implements PicPreviewMoveAdapter.PicOperationListener
{
  AECircleSelectPanelPart$2(AECircleSelectPanelPart paramAECircleSelectPanelPart) {}
  
  public void a(int paramInt)
  {
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 11, 2);
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECircleSelectPanelPart.2
 * JD-Core Version:    0.7.0.1
 */