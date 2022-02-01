package com.tencent.weiyun.transmission.upload;

public class UploadFile$UploadServerInfo
  implements Cloneable
{
  public int channelCount;
  public String checkKey;
  public boolean fileExist;
  public String fileId;
  public String fileVersion;
  public String serverIp;
  public String serverName;
  public int serverPort;
  
  public UploadFile$UploadServerInfo(UploadFile paramUploadFile, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    this.fileExist = paramBoolean;
    this.fileId = paramString1;
    this.serverName = paramString2;
    this.serverIp = paramString3;
    this.serverPort = paramInt1;
    this.checkKey = paramString4;
    this.channelCount = paramInt2;
    this.fileVersion = paramString5;
  }
  
  public UploadServerInfo clone()
  {
    try
    {
      UploadServerInfo localUploadServerInfo = (UploadServerInfo)super.clone();
      return localUploadServerInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadFile.UploadServerInfo
 * JD-Core Version:    0.7.0.1
 */