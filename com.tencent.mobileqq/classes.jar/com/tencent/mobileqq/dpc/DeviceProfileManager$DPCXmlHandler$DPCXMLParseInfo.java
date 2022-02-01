package com.tencent.mobileqq.dpc;

class DeviceProfileManager$DPCXmlHandler$DPCXMLParseInfo
{
  public String key = "";
  public String taskId = "0";
  public String testType = "";
  public String value = "";
  public int weight = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DPCXMLParseInfo: key=");
    localStringBuilder.append(this.key);
    localStringBuilder.append(",value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(",weight=");
    localStringBuilder.append(this.weight);
    localStringBuilder.append(",taskId=");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append(",testType=");
    localStringBuilder.append(this.testType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo
 * JD-Core Version:    0.7.0.1
 */