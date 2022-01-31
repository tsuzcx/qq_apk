package com.tencent.viola.ui.dom;

import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexNode.MeasureFunction;
import com.tencent.viola.ui.dom.style.MeasureOutput;

final class DomObjectCell$1
  implements FlexNode.MeasureFunction
{
  public void measure(FlexNode paramFlexNode, float paramFloat, MeasureOutput paramMeasureOutput)
  {
    DomObject localDomObject;
    if (paramFlexNode != null)
    {
      FlexNode localFlexNode = paramFlexNode.getParent();
      localDomObject = (DomObject)localFlexNode;
      if ((paramFlexNode instanceof DomObjectCell))
      {
        paramFlexNode.setLayoutWidth(paramFloat);
        paramMeasureOutput.width = paramFloat;
      }
      if (!"slider".equals(localDomObject.getType())) {
        break label66;
      }
      paramMeasureOutput.height = localFlexNode.getLayoutHeight();
      paramMeasureOutput.width = localFlexNode.getLayoutWidth();
    }
    label66:
    while ((!"waterfall-list".equals(localDomObject.getType())) || (!(localDomObject instanceof DomObjectWaterfallList))) {
      return;
    }
    int i = ((DomObjectWaterfallList)localDomObject).getCellWidth();
    paramFlexNode.setLayoutWidth(i);
    paramMeasureOutput.width = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectCell.1
 * JD-Core Version:    0.7.0.1
 */