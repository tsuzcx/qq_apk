package com.tencent.mobileqq.filemanager.fileassistant.aio;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import java.util.List;

public class FileAssistReadConfirmCallback
  implements IReadConfirmCallback
{
  public void a(AIOContext paramAIOContext)
  {
    if (QFileAssistantUtils.a(paramAIOContext.a().a)) {
      ((DataLineHandler)paramAIOContext.a().getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).g();
    }
  }
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt) {}
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.aio.FileAssistReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */