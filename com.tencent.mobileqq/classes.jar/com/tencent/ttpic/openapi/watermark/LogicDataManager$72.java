package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;
import com.tencent.ttpic.openapi.model.WMElement;

class LogicDataManager$72
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$72(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    return getValue(null);
  }
  
  public String getValue(WMElement paramWMElement)
  {
    if (paramWMElement != null)
    {
      paramWMElement = this.this$0.getLocationForSpecificMaterial(paramWMElement.sid);
      if (!TextUtils.isEmpty(paramWMElement)) {
        return paramWMElement;
      }
    }
    if (LogicDataManager.access$4600(this.this$0) == null) {
      return "我在这里";
    }
    return LogicDataManager.access$4600(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.72
 * JD-Core Version:    0.7.0.1
 */