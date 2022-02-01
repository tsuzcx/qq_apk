package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.notColumn;
import java.io.File;

public class MessageForFile
  extends ChatMessage
{
  private static final String TAG = "MessageForFile";
  public String fileName;
  public String filePath;
  public long fileSize;
  public String fileSizeString;
  public String fileType;
  @notColumn
  public long originalMsgUid;
  @notColumn
  public long originalTime;
  @notColumn
  public long originalmsgShseq;
  public int status;
  public String[] tempMsg;
  public String url;
  public String urlAtServer;
  
  public void doParse()
  {
    if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026'))
    {
      this.tempMsg = this.msg.split("\\|");
      Object localObject = this.tempMsg;
      if (localObject.length > 0)
      {
        localObject = localObject[0];
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int i = ((String)localObject).lastIndexOf(File.separator);
          if (i != -1)
          {
            this.fileName = ((String)localObject).substring(i + 1);
            return;
          }
          this.fileName = ((String)localObject);
        }
      }
    }
    else
    {
      this.tempMsg = null;
    }
  }
  
  public String getSummaryMsg()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131904454));
    String str2 = this.fileName;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  public boolean hasFileName()
  {
    if (TextUtils.isEmpty(this.fileName)) {
      return false;
    }
    return !this.fileName.trim().equalsIgnoreCase("null");
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    try
    {
      super.postRead();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFile
 * JD-Core Version:    0.7.0.1
 */