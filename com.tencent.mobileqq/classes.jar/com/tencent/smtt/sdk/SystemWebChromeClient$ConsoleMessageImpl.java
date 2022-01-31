package com.tencent.smtt.sdk;

class SystemWebChromeClient$ConsoleMessageImpl
  implements com.tencent.smtt.export.external.interfaces.ConsoleMessage
{
  private int mLineNumber;
  private String mMessage;
  private com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel mMessageLevel;
  private String mSourceId;
  
  SystemWebChromeClient$ConsoleMessageImpl(android.webkit.ConsoleMessage paramConsoleMessage)
  {
    this.mMessageLevel = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.valueOf(paramConsoleMessage.messageLevel().name());
    this.mMessage = paramConsoleMessage.message();
    this.mSourceId = paramConsoleMessage.sourceId();
    this.mLineNumber = paramConsoleMessage.lineNumber();
  }
  
  SystemWebChromeClient$ConsoleMessageImpl(String paramString1, String paramString2, int paramInt)
  {
    this.mMessageLevel = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.LOG;
    this.mMessage = paramString1;
    this.mSourceId = paramString2;
    this.mLineNumber = paramInt;
  }
  
  public int lineNumber()
  {
    return this.mLineNumber;
  }
  
  public String message()
  {
    return this.mMessage;
  }
  
  public com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel messageLevel()
  {
    return this.mMessageLevel;
  }
  
  public String sourceId()
  {
    return this.mSourceId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.ConsoleMessageImpl
 * JD-Core Version:    0.7.0.1
 */