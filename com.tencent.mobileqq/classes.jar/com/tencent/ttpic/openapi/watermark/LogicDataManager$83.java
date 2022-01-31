package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;

class LogicDataManager$83
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$83(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    if ((!TextUtils.isEmpty(LogicDataManager.access$5300(this.this$0))) && (LogicDataManager.access$5300(this.this$0).length() > 1)) {
      return LogicDataManager.access$5300(this.this$0).substring(1, 2);
    }
    return LogicDataManager.access$400(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.83
 * JD-Core Version:    0.7.0.1
 */