package com.tencent.viola.ui.dom;

import com.tencent.viola.ui.dom.style.FlexNode.MeasureFunction;

public class DomObjectFooterCell
  extends DomObjectCell
{
  static final FlexNode.MeasureFunction FOOTER_CELL_MEASURE_FUNCTION = new DomObjectFooterCell.1();
  
  public DomObjectFooterCell()
  {
    setMeasureFunction(FOOTER_CELL_MEASURE_FUNCTION);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectFooterCell
 * JD-Core Version:    0.7.0.1
 */