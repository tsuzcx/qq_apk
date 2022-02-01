package com.tencent.mobileqq.data;

public class MessageForVideoVip
  extends ChatMessage
{
  public String url;
  public String wording;
  
  protected void doParse()
  {
    String[] arrayOfString;
    if (this.msg != null) {
      arrayOfString = this.msg.split("\\|");
    } else {
      arrayOfString = null;
    }
    if ((arrayOfString != null) && (arrayOfString.length == 2))
    {
      this.wording = arrayOfString[0];
      this.url = arrayOfString[1];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForVideoVip
 * JD-Core Version:    0.7.0.1
 */