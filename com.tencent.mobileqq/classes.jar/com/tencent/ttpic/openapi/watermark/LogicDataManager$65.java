package com.tencent.ttpic.openapi.watermark;

import com.tencent.ttpic.openapi.model.WMElement;
import java.util.HashMap;

class LogicDataManager$65
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$65(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    return super.getValue();
  }
  
  public String getValue(WMElement paramWMElement)
  {
    if (paramWMElement.textSource.equals("")) {
      paramWMElement = getValue();
    }
    String str;
    do
    {
      return paramWMElement;
      str = (String)this.this$0.mFollowData.get(paramWMElement.textSource);
      paramWMElement = str;
    } while (str != null);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.65
 * JD-Core Version:    0.7.0.1
 */