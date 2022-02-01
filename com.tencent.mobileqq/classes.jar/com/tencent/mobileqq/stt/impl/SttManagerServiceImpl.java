package com.tencent.mobileqq.stt.impl;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.ISttListener;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.stt.SttManager;
import mqq.app.AppRuntime;

public class SttManagerServiceImpl
  implements ISttManagerService
{
  SttManager sttManager;
  
  public boolean isTranslating(MessageForPtt paramMessageForPtt)
  {
    SttManager localSttManager = this.sttManager;
    if (localSttManager != null) {
      return localSttManager.a(paramMessageForPtt);
    }
    return false;
  }
  
  public boolean needAuotoChange(MessageForPtt paramMessageForPtt)
  {
    SttManager localSttManager = this.sttManager;
    if (localSttManager != null) {
      return localSttManager.b(paramMessageForPtt);
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.sttManager = new SttManager(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    SttManager localSttManager = this.sttManager;
    if (localSttManager != null) {
      localSttManager.onDestroy();
    }
  }
  
  public void onSttResultPush(byte[] paramArrayOfByte)
  {
    SttManager localSttManager = this.sttManager;
    if (localSttManager != null) {
      localSttManager.a(paramArrayOfByte);
    }
  }
  
  public void setListener(ISttListener paramISttListener)
  {
    SttManager localSttManager = this.sttManager;
    if (localSttManager != null) {
      localSttManager.a(paramISttListener);
    }
  }
  
  public Long translate(MessageForPtt paramMessageForPtt, int paramInt)
  {
    SttManager localSttManager = this.sttManager;
    if (localSttManager != null) {
      return localSttManager.a(paramMessageForPtt, paramInt);
    }
    return Long.valueOf(-1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.impl.SttManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */