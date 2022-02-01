package com.tencent.mobileqq.filemanager.fileassistant.message;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.qphone.base.util.QLog;

public class FileAssistantMessageManager
  extends C2CMessageManager
{
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    super.b(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
    QLog.w("FileAssistantMessageManager", 1, "doRefreshMessageListHead: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.message.FileAssistantMessageManager
 * JD-Core Version:    0.7.0.1
 */