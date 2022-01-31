package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;

class LogicDataManager$81
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$81(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    if ((!TextUtils.isEmpty(LogicDataManager.access$5300(this.this$0))) && (LogicDataManager.access$5300(this.this$0).length() > 0)) {
      return LogicDataManager.access$5300(this.this$0).substring(0, 1);
    }
    return LogicDataManager.access$400(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.81
 * JD-Core Version:    0.7.0.1
 */