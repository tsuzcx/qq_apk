package com.tencent.mobileqq.data;

public class MessageForVideoVip
  extends ChatMessage
{
  public String url;
  public String wording;
  
  protected void doParse()
  {
    if (this.msg != null) {}
    for (String[] arrayOfString = this.msg.split("\\|");; arrayOfString = null)
    {
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        this.wording = arrayOfString[0];
        this.url = arrayOfString[1];
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForVideoVip
 * JD-Core Version:    0.7.0.1
 */