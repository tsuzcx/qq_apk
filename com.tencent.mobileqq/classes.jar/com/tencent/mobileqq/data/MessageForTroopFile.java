package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.HardCodeUtil;
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
  public boolean isPause = false;
  public long lastTime;
  public String md5;
  public String sha1;
  public String url;
  public String uuid;
  public int width;
  public String yybApkIconUrl;
  public String yybApkName;
  public String yybApkPackageName;
  
  public void doParse()
  {
    Object localObject;
    try
    {
      TroopFileData localTroopFileData = (TroopFileData)MessagePkgUtils.a(this.msgData);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject != null)
    {
      this.url = localObject.fileUrl;
      this.sha1 = localObject.sha1;
      this.md5 = localObject.md5;
      this.dspFileSize = localObject.dspFileSize;
      this.dspFileName = localObject.dspFileName;
      this.bisID = localObject.bisID;
      this.uuid = localObject.uuid;
      this.fileSize = localObject.lfileSize;
      this.fileName = localObject.fileName;
      this.FromUin = localObject.FromUin;
      this.lastTime = localObject.lastTime;
      this.entitySessionId = localObject.entitySessionId;
      this.width = localObject.width;
      this.height = localObject.height;
      this.duration = localObject.duration;
      this.yybApkPackageName = localObject.yybApkPackageName;
      this.yybApkName = localObject.yybApkName;
      this.yybApkIconUrl = localObject.yybApkIconUrl;
    }
    this.msg = HardCodeUtil.a(2131904456);
  }
  
  public String getSummaryMsg()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131904505));
    localStringBuilder.append(this.fileName);
    return localStringBuilder.toString();
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
    localTroopFileData.md5 = this.md5;
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
    localTroopFileData.yybApkPackageName = this.yybApkPackageName;
    localTroopFileData.yybApkName = this.yybApkName;
    localTroopFileData.yybApkIconUrl = this.yybApkIconUrl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopFile
 * JD-Core Version:    0.7.0.1
 */