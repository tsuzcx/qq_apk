package com.tencent.mobileqq.wink.pick.circle.part;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.wink.pick.circle.adapter.PicPreviewMoveAdapter.PicOperationListener;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;

class WinkCircleSelectPanelPart$2
  implements PicPreviewMoveAdapter.PicOperationListener
{
  WinkCircleSelectPanelPart$2(WinkCircleSelectPanelPart paramWinkCircleSelectPanelPart) {}
  
  public void a(int paramInt)
  {
    SimpleEventBus.getInstance().dispatchEvent(new WinkCircleSelectChangeEvent());
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCircleSelectPanelPart.2
 * JD-Core Version:    0.7.0.1
 */