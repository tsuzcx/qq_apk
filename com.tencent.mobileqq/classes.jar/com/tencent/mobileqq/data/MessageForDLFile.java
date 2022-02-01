package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.filemanager.fileassistant.data.DatalineFileData;

public class MessageForDLFile
  extends ChatMessage
{
  public static final String TAG = "MessageForDLFile";
  public long associatedId;
  public int deviceType;
  public String fileName;
  public long fileSize;
  public String localPath;
  public String thumbPath;
  
  protected void doParse()
  {
    try
    {
      DatalineFileData localDatalineFileData = (DatalineFileData)MessagePkgUtils.a(this.msgData);
      if (localDatalineFileData == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localException.printStackTrace();
        localObject = null;
      }
      this.associatedId = localObject.associatedId;
      this.deviceType = localObject.deviceType;
      this.fileName = localObject.filename;
      this.fileSize = localObject.filesize;
      this.localPath = localObject.localPath;
      this.thumbPath = localObject.thumbPath;
    }
  }
  
  public String getSummaryMsg()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(HardCodeUtil.a(2131706580));
    if (this.fileName == null) {}
    for (String str = "";; str = this.fileName) {
      return str;
    }
  }
  
  public boolean isSend()
  {
    return super.isSend();
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    DatalineFileData localDatalineFileData = new DatalineFileData();
    localDatalineFileData.filename = this.fileName;
    localDatalineFileData.filesize = this.fileSize;
    localDatalineFileData.localPath = this.localPath;
    localDatalineFileData.thumbPath = this.thumbPath;
    localDatalineFileData.associatedId = this.associatedId;
    localDatalineFileData.deviceType = this.deviceType;
    try
    {
      this.msgData = MessagePkgUtils.a(localDatalineFileData);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDLFile
 * JD-Core Version:    0.7.0.1
 */