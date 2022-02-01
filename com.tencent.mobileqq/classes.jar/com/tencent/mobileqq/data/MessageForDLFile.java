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
    Object localObject;
    try
    {
      DatalineFileData localDatalineFileData = (DatalineFileData)MessagePkgUtils.a(this.msgData);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    this.associatedId = localObject.associatedId;
    this.deviceType = localObject.deviceType;
    this.fileName = localObject.filename;
    this.fileSize = localObject.filesize;
    this.localPath = localObject.localPath;
    this.thumbPath = localObject.thumbPath;
  }
  
  public String getSummaryMsg()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131706603));
    String str2 = this.fileName;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  public boolean isSend()
  {
    return super.isSend();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDLFile
 * JD-Core Version:    0.7.0.1
 */