package com.tencent.ttpic.openapi.watermark;

import java.util.Queue;

class LogicDataManager$80
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$80(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    synchronized (LogicDataManager.access$5200(this.this$0))
    {
      if (LogicDataManager.access$5200(this.this$0).isEmpty()) {
        break label85;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (!LogicDataManager.access$5200(this.this$0).isEmpty()) {
        localStringBuilder.append((String)LogicDataManager.access$5200(this.this$0).poll());
      }
    }
    String str = localObject.toString();
    return str;
    label85:
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.80
 * JD-Core Version:    0.7.0.1
 */