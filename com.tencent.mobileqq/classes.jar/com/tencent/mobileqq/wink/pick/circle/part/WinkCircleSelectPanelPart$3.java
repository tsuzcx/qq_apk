package com.tencent.mobileqq.wink.pick.circle.part;

import com.tencent.mobileqq.wink.pick.circle.adapter.PicPreviewMoveAdapter;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;
import com.tencent.mobileqq.wink.pick.circle.helper.PicDragHelperCallback.DragListener;
import com.tencent.qphone.base.util.QLog;

class WinkCircleSelectPanelPart$3
  implements PicDragHelperCallback.DragListener
{
  WinkCircleSelectPanelPart$3(WinkCircleSelectPanelPart paramWinkCircleSelectPanelPart) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDragFinish  isInside = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("WinkCircleSelectPanelPart", 1, localStringBuilder.toString());
    new WinkCircleSelectChangeEvent().setImageDragEventFlag(true);
    WinkCircleSelectPanelPart.a(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCircleSelectPanelPart.3
 * JD-Core Version:    0.7.0.1
 */