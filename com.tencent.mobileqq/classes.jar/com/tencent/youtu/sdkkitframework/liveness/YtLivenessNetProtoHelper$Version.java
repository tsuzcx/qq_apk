package com.tencent.youtu.sdkkitframework.liveness;

class YtLivenessNetProtoHelper$Version
{
  public String faction_sdk_version = "";
  public String freflect_sdk_version = "";
  public String ftrack_sdk_version = "";
  public String sdk_version = "";
  
  public String makeVersion()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("sdk_version:").append(this.sdk_version);
    localStringBuffer.append(";ftrack_sdk_version:").append(this.ftrack_sdk_version);
    if (this.freflect_sdk_version != "") {
      localStringBuffer.append(";freflect_sdk_version:").append(this.freflect_sdk_version);
    }
    if (this.faction_sdk_version != "") {
      localStringBuffer.append(";faction_sdk_version:").append(this.faction_sdk_version);
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper.Version
 * JD-Core Version:    0.7.0.1
 */