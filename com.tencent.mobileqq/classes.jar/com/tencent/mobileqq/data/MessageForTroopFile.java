package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;

public class MessageForTroopFile
  extends ChatMessage
{
  public static final String TAG = "MessageForTroopFile";
  public String FromUin;
  public boolean bReported = false;
  public int bisID;
  public String dspFileName;
  public String dspFileSize;
  public int duration;
  public long entitySessionId;
  public String fileName;
  public long fileSize;
  public int height;
  public long lastTime;
  public String sha1;
  public String url;
  public String uuid;
  public int width;
  
  public void doParse()
  {
    try
    {
      TroopFileData localTroopFileData = (TroopFileData)MessagePkgUtils.a(this.msgData);
      if (localTroopFileData != null)
      {
        this.url = localTroopFileData.fileUrl;
        this.sha1 = localTroopFileData.sha1;
        this.dspFileSize = localTroopFileData.dspFileSize;
        this.dspFileName = localTroopFileData.dspFileName;
        this.bisID = localTroopFileData.bisID;
        this.uuid = localTroopFileData.uuid;
        this.fileSize = localTroopFileData.lfileSize;
        this.fileName = localTroopFileData.fileName;
        this.FromUin = localTroopFileData.FromUin;
        this.lastTime = localTroopFileData.lastTime;
        this.entitySessionId = localTroopFileData.entitySessionId;
        this.width = localTroopFileData.width;
        this.height = localTroopFileData.height;
        this.duration = localTroopFileData.duration;
      }
      this.msg = "[群文件]";
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public String getSummaryMsg()
  {
    return "[文件]" + this.fileName;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    TroopFileData localTroopFileData = new TroopFileData();
    localTroopFileData.fileUrl = this.url;
    localTroopFileData.sha1 = this.sha1;
    localTroopFileData.fileName = this.fileName;
    localTroopFileData.dspFileName = this.dspFileName;
    localTroopFileData.dspFileSize = this.dspFileSize;
    localTroopFileData.bisID = this.bisID;
    localTroopFileData.uuid = this.uuid;
    localTroopFileData.lfileSize = this.fileSize;
    localTroopFileData.FromUin = this.FromUin;
    localTroopFileData.lastTime = this.lastTime;
    localTroopFileData.entitySessionId = this.entitySessionId;
    localTroopFileData.width = this.width;
    localTroopFileData.height = this.height;
    localTroopFileData.duration = this.duration;
    try
    {
      this.msgData = MessagePkgUtils.a(localTroopFileData);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopFile
 * JD-Core Version:    0.7.0.1
 */