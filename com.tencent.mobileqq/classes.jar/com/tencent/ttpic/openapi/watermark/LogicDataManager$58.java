package com.tencent.ttpic.openapi.watermark;

import com.tencent.ttpic.openapi.model.WMElement;
import java.util.HashMap;

class LogicDataManager$58
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$58(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    return "-1";
  }
  
  public String getValue(WMElement paramWMElement)
  {
    if (paramWMElement.numberSource.equals("")) {
      return getValue();
    }
    try
    {
      int i = Integer.parseInt((String)this.this$0.mFollowData.get(paramWMElement.numberSource));
      if (((paramWMElement.showCaseMin.equals("")) && (paramWMElement.showCaseMax.equals(""))) || ((i >= Integer.parseInt(paramWMElement.showCaseMin)) && (i <= Integer.parseInt(paramWMElement.showCaseMax)))) {
        return String.valueOf(i % 1000 / 100);
      }
      return "-1";
    }
    catch (NumberFormatException paramWMElement)
    {
      paramWMElement.printStackTrace();
    }
    return "-1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.58
 * JD-Core Version:    0.7.0.1
 */