package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;

class LogicDataManager$85
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$85(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    if ((!TextUtils.isEmpty(LogicDataManager.access$5300(this.this$0))) && (LogicDataManager.access$5300(this.this$0).length() > 3)) {
      return LogicDataManager.access$5300(this.this$0).substring(3, 4);
    }
    return LogicDataManager.access$400(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.85
 * JD-Core Version:    0.7.0.1
 */