package com.tencent.viola.ui.dom;

import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexNode.MeasureFunction;
import com.tencent.viola.ui.dom.style.MeasureOutput;

class DomObjectCell$1
  implements FlexNode.MeasureFunction
{
  public void measure(FlexNode paramFlexNode, float paramFloat, MeasureOutput paramMeasureOutput)
  {
    if (paramFlexNode != null)
    {
      FlexNode localFlexNode = paramFlexNode.getParent();
      DomObject localDomObject = (DomObject)localFlexNode;
      if ((paramFlexNode instanceof DomObjectCell))
      {
        paramFlexNode.setLayoutWidth(paramFloat);
        paramMeasureOutput.width = paramFloat;
      }
      if ("slider".equals(localDomObject.getType()))
      {
        paramMeasureOutput.height = localFlexNode.getLayoutHeight();
        paramMeasureOutput.width = localFlexNode.getLayoutWidth();
        return;
      }
      if (("waterfall-list".equals(localDomObject.getType())) && ((localDomObject instanceof DomObjectWaterfallList)))
      {
        paramFloat = ((DomObjectWaterfallList)localDomObject).getCellWidth();
        paramFlexNode.setLayoutWidth(paramFloat);
        paramMeasureOutput.width = paramFloat;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectCell.1
 * JD-Core Version:    0.7.0.1
 */