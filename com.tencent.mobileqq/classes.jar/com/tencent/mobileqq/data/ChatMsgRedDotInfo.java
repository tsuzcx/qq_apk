package com.tencent.mobileqq.data;

public class ChatMsgRedDotInfo
{
  public boolean isQcircleRedDotPulled = false;
  public boolean isQzoneRedDotPulled = false;
  public boolean isShowQcircleRedDot = false;
  public boolean isShowQzoneRedDot = false;
  public String qCircleRedDotIconUrl = "";
  public String qCircleRedDotJumpSchema = "";
  public String qZoneRedDotIconUrl = "";
  public String qZoneRedDotJumpSchema = "";
  
  public String getQcircleJumpIconUrl()
  {
    return this.qCircleRedDotIconUrl;
  }
  
  public boolean getQcircleRedDotFlag()
  {
    return this.isShowQcircleRedDot;
  }
  
  public String getQcircleRedDotJumpSchema()
  {
    return this.qCircleRedDotJumpSchema;
  }
  
  public boolean getQcircleRedDotPulledFlag()
  {
    return this.isQcircleRedDotPulled;
  }
  
  public String getQzoneJumpIconUrl()
  {
    return this.qZoneRedDotIconUrl;
  }
  
  public boolean getQzoneRedDotFlag()
  {
    return this.isShowQzoneRedDot;
  }
  
  public String getQzoneRedDotJumpSchema()
  {
    return this.qZoneRedDotJumpSchema;
  }
  
  public boolean getQzoneRedDotPulledFlag()
  {
    return this.isQzoneRedDotPulled;
  }
  
  public void setQcircleJumpIconUrl(String paramString)
  {
    this.qCircleRedDotIconUrl = paramString;
  }
  
  public void setQcircleRedDotFlag(boolean paramBoolean)
  {
    this.isShowQcircleRedDot = paramBoolean;
  }
  
  public void setQcircleRedDotJumpSchema(String paramString)
  {
    this.qCircleRedDotJumpSchema = paramString;
  }
  
  public void setQcircleRedDotPulledFlag(boolean paramBoolean)
  {
    this.isQcircleRedDotPulled = paramBoolean;
  }
  
  public void setQzoneJumpIconUrl(String paramString)
  {
    this.qZoneRedDotIconUrl = paramString;
  }
  
  public void setQzoneRedDotFlag(boolean paramBoolean)
  {
    this.isShowQzoneRedDot = paramBoolean;
  }
  
  public void setQzoneRedDotJumpSchema(String paramString)
  {
    this.qZoneRedDotJumpSchema = paramString;
  }
  
  public void setQzoneRedDotPulledFlag(boolean paramBoolean)
  {
    this.isQzoneRedDotPulled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatMsgRedDotInfo
 * JD-Core Version:    0.7.0.1
 */