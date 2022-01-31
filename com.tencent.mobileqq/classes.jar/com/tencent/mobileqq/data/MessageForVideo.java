package com.tencent.mobileqq.data;

import ajjy;
import azzz;
import com.tencent.qphone.base.util.QLog;

public class MessageForVideo
  extends ChatMessage
{
  private static final String TAG = "MessageForVideo";
  public boolean isVideo;
  public String text;
  public int type;
  
  protected void doParse()
  {
    String[] arrayOfString;
    if (this.msg != null)
    {
      arrayOfString = this.msg.split("\\|");
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label90;
      }
      this.text = arrayOfString[0].trim();
      if ((arrayOfString == null) || (arrayOfString.length <= 1)) {
        break label227;
      }
    }
    for (;;)
    {
      try
      {
        this.type = Integer.parseInt(arrayOfString[1]);
        if ((arrayOfString == null) || (arrayOfString.length <= 3)) {
          break label251;
        }
        if (arrayOfString.length != 4) {
          break label235;
        }
        this.isVideo = "1".equals(arrayOfString[3]);
        return;
        arrayOfString = null;
        break;
        label90:
        this.text = "";
      }
      catch (Exception localException)
      {
        if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026')) {
          throw new RuntimeException("java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg is " + this.msg);
        }
        this.type = 5;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForVideo", 2, "java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg byte " + azzz.a(this.msg));
        continue;
      }
      label227:
      this.type = 5;
    }
    label235:
    this.isVideo = arrayOfString[0].contains(ajjy.a(2131640815));
    return;
    label251:
    this.isVideo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForVideo
 * JD-Core Version:    0.7.0.1
 */