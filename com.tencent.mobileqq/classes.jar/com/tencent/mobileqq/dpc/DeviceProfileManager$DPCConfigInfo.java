package com.tencent.mobileqq.dpc;

import java.io.Serializable;

public class DeviceProfileManager$DPCConfigInfo
  implements Serializable, Cloneable
{
  public static final String DPCINFO_FEATUREVALUE_DEFAULTVAL = "";
  public String featureValue = "";
  
  public Object clone()
  {
    Object localObject;
    try
    {
      DPCConfigInfo localDPCConfigInfo = (DPCConfigInfo)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
      localObject = null;
    }
    if (localObject == null) {
      return this;
    }
    localObject.featureValue = this.featureValue;
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("DPCConfigInfo: featureValue=");
    localStringBuilder.append(this.featureValue);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.DeviceProfileManager.DPCConfigInfo
 * JD-Core Version:    0.7.0.1
 */