package com.tencent.mobileqq.filemanager.fileassistant.aio;

import com.tencent.mobileqq.activity.aio.SessionInfo;
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
    if (QFileAssistantUtils.a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      ((DataLineHandler)paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).g();
    }
  }
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt) {}
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.aio.FileAssistReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */