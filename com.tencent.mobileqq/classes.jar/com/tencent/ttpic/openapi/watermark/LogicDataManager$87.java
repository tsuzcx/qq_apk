package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;

class LogicDataManager$87
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$87(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    if ((!TextUtils.isEmpty(LogicDataManager.access$5300(this.this$0))) && (LogicDataManager.access$5300(this.this$0).length() > 8)) {
      return LogicDataManager.access$5300(this.this$0).substring(8, 9);
    }
    return LogicDataManager.access$1400(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.87
 * JD-Core Version:    0.7.0.1
 */