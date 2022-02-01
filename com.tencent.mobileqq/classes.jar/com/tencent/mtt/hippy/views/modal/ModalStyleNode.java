package com.tencent.mtt.hippy.views.modal;

import android.graphics.Point;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.smtt.flexbox.FlexNode;

class ModalStyleNode
  extends StyleNode
{
  public void addChildAt(FlexNode paramFlexNode, int paramInt)
  {
    super.addChildAt(paramFlexNode, paramInt);
    Point localPoint = ModalHostHelper.getModalHostSize(ContextHolder.getAppContext());
    paramFlexNode.setStyleWidth(localPoint.x);
    paramFlexNode.setStyleHeight(localPoint.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.ModalStyleNode
 * JD-Core Version:    0.7.0.1
 */