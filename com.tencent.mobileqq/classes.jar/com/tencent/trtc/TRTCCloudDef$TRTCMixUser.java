package com.tencent.trtc;

public class TRTCCloudDef$TRTCMixUser
{
  public int height;
  public int inputType;
  public boolean pureAudio;
  public String roomId;
  public int streamType;
  public String userId;
  public int width;
  public int x;
  public int y;
  public int zOrder;
  
  public TRTCCloudDef$TRTCMixUser()
  {
    this.userId = "";
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
    this.zOrder = 0;
    this.streamType = 0;
    this.inputType = 0;
  }
  
  public TRTCCloudDef$TRTCMixUser(TRTCMixUser paramTRTCMixUser)
  {
    this.userId = paramTRTCMixUser.userId;
    this.roomId = paramTRTCMixUser.roomId;
    this.x = paramTRTCMixUser.x;
    this.y = paramTRTCMixUser.y;
    this.width = paramTRTCMixUser.width;
    this.height = paramTRTCMixUser.height;
    this.zOrder = paramTRTCMixUser.zOrder;
    this.streamType = paramTRTCMixUser.streamType;
    this.pureAudio = paramTRTCMixUser.pureAudio;
    this.inputType = paramTRTCMixUser.inputType;
  }
  
  public TRTCCloudDef$TRTCMixUser(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.userId = paramString;
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.zOrder = paramInt5;
    this.streamType = 0;
    this.inputType = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("userId=");
    localStringBuilder.append(this.userId);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", zOrder=");
    localStringBuilder.append(this.zOrder);
    localStringBuilder.append(", streamType=");
    localStringBuilder.append(this.streamType);
    localStringBuilder.append(", pureAudio=");
    localStringBuilder.append(this.pureAudio);
    localStringBuilder.append(", inputType=");
    localStringBuilder.append(this.inputType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCMixUser
 * JD-Core Version:    0.7.0.1
 */